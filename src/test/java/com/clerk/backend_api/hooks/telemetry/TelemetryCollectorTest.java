package com.clerk.backend_api.hooks.telemetry;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class TelemetryCollectorTest {

    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalErr = System.err;

    @BeforeEach
    void setUpStreams() {
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setErr(originalErr);
    }

    @Test
    void testBaseCollector_CollectIgnoresProductionEvents() {
        // Arrange
        TelemetryEvent prodEvent = new TelemetryEvent(
                "sk_live_123",
                TelemetryEvent.EVENT_METHOD_CALLED,
                Map.of("method", "test-method"),
                1.0f
        );

        TestCollector collector = new TestCollector();

        // Act
        collector.collect(prodEvent);

        // Assert
        assertFalse(collector.wasCollectInternalCalled, "collectInternal should not be called for production events");
    }

    @Test
    void testBaseCollector_CollectCallsCollectInternalForDevelopment() {
        // Arrange
        TelemetryEvent devEvent = new TelemetryEvent(
                "sk_test_123",
                TelemetryEvent.EVENT_METHOD_CALLED,
                Map.of("method", "test-method"),
                1.0f
        );

        TestCollector collector = new TestCollector();

        // Act
        collector.collect(devEvent);

        // Assert
        assertTrue(collector.wasCollectInternalCalled, "collectInternal should be called for development events");
        assertEquals(devEvent, collector.lastEvent, "The event passed to collectInternal should match");
    }

    @Test
    void testBaseCollector_PrepareEventPopulatesAllFields() {
        // Arrange
        TelemetryEvent event = new TelemetryEvent(
                "sk_test_123",
                TelemetryEvent.EVENT_METHOD_CALLED,
                Map.of("key1", "value1"),
                1.0f
        );

        TestCollector collector = new TestCollector();

        // Act
        PreparedEvent prepared = collector.prepareEvent(event);

        // Assert
        assertEquals(event.event, prepared.event);
        assertEquals(event.it, prepared.it);
        assertNotNull(prepared.sdk);
        assertNotNull(prepared.sdkv);
        assertEquals(event.sk, prepared.sk);
        assertInstanceOf(TreeMap.class, prepared.payload);
        assertEquals("value1", prepared.payload.get("key1"));
    }

    @Test
    void testDebugCollector_PrintsToStderr() {
        // Arrange
        TelemetryEvent event = new TelemetryEvent(
                "sk_test_123",
                TelemetryEvent.EVENT_METHOD_CALLED,
                Map.of("method", "test-method"),
                1.0f
        );

        ThrowingDebugCollector collector = new ThrowingDebugCollector();

        // Act
        collector.collectInternal(event);

        // Assert
        String output = errContent.toString();
        assertFalse(output.isEmpty(), "Debug collector should print to stderr");
        assertTrue(output.contains(collector.serializedOutput), "Debug collector should print the serialized event");
    }

    @Test
    void testDebugCollector_HandlesSerializationError() {
        // Arrange
        TelemetryEvent event = new TelemetryEvent(
                "sk_test_123",
                TelemetryEvent.EVENT_METHOD_CALLED,
                Map.of("method", "test-method"),
                1.0f
        );

        ThrowingDebugCollector collector = new ThrowingDebugCollector();
        collector.throwOnSerialize = true;

        // Act
        collector.collectInternal(event);

        // Assert
        String output = errContent.toString();
        assertTrue(output.contains("Failed to serialize event"), "Should print error message on serialization failure");
    }

    @Test
    void testLiveCollector_FiltersBySamplers() {
        // Arrange
        TelemetryEvent event = new TelemetryEvent(
                "sk_test_123",
                TelemetryEvent.EVENT_METHOD_CALLED,
                Map.of("method", "test-method"),
                1.0f
        );

        // Create a sampler that always returns false
        TelemetrySampler rejectingSampler = (preparedEvent, telemetryEvent) -> false;

        // Create test executor and collector
        TestExecutorService executor = new TestExecutorService();
        ThrowingLiveCollector collector = new ThrowingLiveCollector(List.of(rejectingSampler), executor);

        // Act
        collector.collectInternal(event);

        // Assert
        assertEquals(0, executor.submissions.size(), "No task should be submitted when sampler rejects");
    }

    @Test
    void testLiveCollector_SubmitsTaskWhenSamplingPasses() {
        // Arrange
        TelemetryEvent event = new TelemetryEvent(
                "sk_test_123",
                TelemetryEvent.EVENT_METHOD_CALLED,
                Map.of("method", "test-method"),
                1.0f
        );

        // Create a sampler that always returns true
        TelemetrySampler acceptingSampler = (preparedEvent, telemetryEvent) -> true;

        // Create test executor and collector
        TestExecutorService executor = new TestExecutorService();
        ThrowingLiveCollector collector = new ThrowingLiveCollector(List.of(acceptingSampler), executor);

        // Act
        collector.collectInternal(event);

        // Assert
        assertEquals(1, executor.submissions.size(), "Task should be submitted when sampler accepts");
    }

    @Test
    void testLiveCollector_SendEventCatchesExceptions() {
        // Arrange
        TelemetryEvent event = new TelemetryEvent(
                "sk_test_123",
                TelemetryEvent.EVENT_METHOD_CALLED,
                Map.of("method", "test-method"),
                1.0f
        );

        ThrowingLiveCollector collector = new ThrowingLiveCollector(
                Collections.emptyList(), Executors.newSingleThreadExecutor());
        collector.throwOnSerialize = true;

        // Act - should not throw exception out of the method
        collector.sendEvent(event);

        // Assert
        String output = errContent.toString();
        assertTrue(output.contains("Error sending telemetry event"),
                "Should log error message when exception occurs");
    }

    // Helper test classes
    // We make all of these because we don't have Mockito here and we don't want to introduce
    // more dependencies just for testing

    private static class TestCollector extends TelemetryCollector.BaseCollector {
        public boolean wasCollectInternalCalled = false;
        public TelemetryEvent lastEvent = null;

        @Override
        protected void collectInternal(TelemetryEvent event) {
            wasCollectInternalCalled = true;
            lastEvent = event;
        }
    }

    private static class ThrowingDebugCollector extends TelemetryCollector.DebugCollector {
        public boolean throwOnSerialize = false;
        public String serializedOutput = "{\"test\":\"json\"}";

        @Override
        protected String serializeToJson(PreparedEvent preparedEvent) throws com.fasterxml.jackson.core.JsonProcessingException {
            if (throwOnSerialize) {
                throw new com.fasterxml.jackson.core.JsonProcessingException("Test error") {};
            }
            return serializedOutput;
        }
    }

    private static class ThrowingLiveCollector extends TelemetryCollector.LiveCollector {
        public boolean throwOnSerialize = false;

        public ThrowingLiveCollector(List<TelemetrySampler> samplers, ExecutorService svc) {
            super(samplers, svc);
        }

        @Override
        protected String serializeToJson(PreparedEvent preparedEvent) throws JsonProcessingException {
            if (throwOnSerialize) {
                throw new RuntimeException("Test exception");
            }
            return super.serializeToJson(preparedEvent);
        }
    }

    static class TestExecutorService extends AbstractExecutorService {
        public final List<Runnable> submissions = new ArrayList<>();

        @Override
        public void execute(Runnable command) {
            submissions.add(command);
        }

        @Override
        public List<Runnable> shutdownNow() {
            return submissions;
        }

        @Override
        public void shutdown() {
        }

        @Override
        public boolean isShutdown() {
            return false;
        }

        @Override
        public boolean isTerminated() {
            return false;
        }

        @Override
        public boolean awaitTermination(long timeout, TimeUnit unit) {
            return true;
        }

    }

}