package com.clerk.backend_api.hooks.telemetry;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class TelemetrySamplerTest {

    private static TelemetryEvent testEvent(float samplingRate) {
        return new TelemetryEvent(
                "sk_test_123",
                TelemetryEvent.EVENT_METHOD_CALLED,
                Map.of("method", "test-method"),
                samplingRate
        );
    }

    private static PreparedEvent testPreparedEvent(TelemetryEvent event) {
        return new PreparedEvent(event.event, event.it, "sdk", "sdkv", event.sk, event.payload);
    }

    @Test
    void testRandomSampler_WithSeedWorks() {
        // Arrange
        Random fixedRandom = new Random(1L);
        TelemetrySampler.RandomSampler sampler = new TelemetrySampler.RandomSampler(fixedRandom);

        TelemetryEvent event = testEvent(0.5f);
        PreparedEvent preparedEvent = testPreparedEvent(event);

        // Act - with a fixed seed, we should get deterministic results
        boolean firstResult = sampler.test(preparedEvent, event);
        boolean secondResult = sampler.test(preparedEvent, event);

        // The exact results will depend on the random seed, but we can at least verify they're different
        // With seed 1, these should be predictable
        assertNotEquals(firstResult, secondResult, "With seed 1, the first two samples should differ");
    }

    @Test
    void testRandomSampler_SamplingRateZero_AlwaysFalse() {
        // Arrange
        TelemetrySampler.RandomSampler sampler = new TelemetrySampler.RandomSampler(new Random());

        TelemetryEvent event = testEvent(0.0f);
        PreparedEvent preparedEvent = testPreparedEvent(event);

        // Act & Assert
        for (int i = 0; i < 100; i++) {
            assertFalse(sampler.test(preparedEvent, event), "Should always return false with 0.0 sampling rate");
        }
    }

    @Test
    void testRandomSampler_SamplingRateOne_AlwaysTrue() {
        // Arrange
        TelemetrySampler.RandomSampler sampler = new TelemetrySampler.RandomSampler(new Random());

        TelemetryEvent event = testEvent(1.0f);
        PreparedEvent preparedEvent = testPreparedEvent(event);

        // Act & Assert
        for (int i = 0; i < 100; i++) {
            assertTrue(sampler.test(preparedEvent, event), "Should always return true with 1.0 sampling rate");
        }
    }

    @Test
    void testDeduplicatingSampler_FirstEventAccepted() {
        // Arrange
        Clock fixedClock = Clock.fixed(Instant.parse("2023-01-01T12:00:00Z"), ZoneId.of("UTC"));
        TelemetrySampler.DeduplicatingSampler sampler = new TelemetrySampler.DeduplicatingSampler(
                Duration.ofDays(1), fixedClock);

        TelemetryEvent event = testEvent(0.5f);
        PreparedEvent preparedEvent = testPreparedEvent(event);

        // Act & Assert
        assertTrue(sampler.test(preparedEvent, event), "First event should be accepted");
    }

    @Test
    void testDeduplicatingSampler_DuplicateEventWithinWindowRejected() {
        // Arrange
        Instant start = Instant.parse("2023-01-01T12:00:00Z");
        TestClock testClock = new TestClock(start);

        TelemetrySampler.DeduplicatingSampler sampler = new TelemetrySampler.DeduplicatingSampler(
                Duration.ofDays(1), testClock);

        TelemetryEvent event = testEvent(0.5f);
        PreparedEvent preparedEvent = testPreparedEvent(event);

        // Act
        boolean firstResult = sampler.test(preparedEvent, event);

        // Move time forward, but still within window
        testClock.setInstant(start.plus(Duration.ofHours(23)));

        boolean secondResult = sampler.test(preparedEvent, event);

        // Assert
        assertTrue(firstResult, "First event should be accepted");
        assertFalse(secondResult, "Duplicate event within window should be rejected");
    }

    @Test
    void testDeduplicatingSampler_EventAfterWindowAccepted() {
        // Arrange
        Instant start = Instant.parse("2023-01-01T12:00:00Z");
        TestClock testClock = new TestClock(start);

        TelemetrySampler.DeduplicatingSampler sampler = new TelemetrySampler.DeduplicatingSampler(
                Duration.ofDays(1), testClock);

        TelemetryEvent event = testEvent(0.5f);
        PreparedEvent preparedEvent = testPreparedEvent(event);

        // Act
        boolean firstResult = sampler.test(preparedEvent, event);

        // Move time forward beyond window
        testClock.setInstant(start.plus(Duration.ofHours(25)));

        boolean secondResult = sampler.test(preparedEvent, event);

        // Assert
        assertTrue(firstResult, "First event should be accepted");
        assertTrue(secondResult, "Event after window should be accepted");
    }

    @Test
    void testDeduplicatingSampler_DifferentEventsAccepted() {
        // Arrange
        Clock fixedClock = Clock.fixed(Instant.parse("2023-01-01T12:00:00Z"), ZoneId.of("UTC"));
        TelemetrySampler.DeduplicatingSampler sampler = new TelemetrySampler.DeduplicatingSampler(
                Duration.ofDays(1), fixedClock);

        TelemetryEvent firstEvent = new TelemetryEvent(
                "sk_test_123",
                TelemetryEvent.EVENT_METHOD_CALLED,
                Map.of("method", "test-method-1"),
                0.5f
        );
        PreparedEvent firstPreparedEvent = testPreparedEvent(firstEvent);

        TelemetryEvent secondEvent = new TelemetryEvent(
                "sk_test_123",
                TelemetryEvent.EVENT_METHOD_CALLED,
                Map.of("method", "test-method-2"),
                0.5f
        );
        PreparedEvent secondPreparedEvent = testPreparedEvent(secondEvent);

        // Act
        boolean firstResult = sampler.test(firstPreparedEvent, firstEvent);
        boolean secondResult = sampler.test(secondPreparedEvent, secondEvent);

        // Assert
        assertTrue(firstResult, "First event should be accepted");
        assertTrue(secondResult, "Different event should be accepted");
    }

    // A test clock implementation that allows changing the time
    private static class TestClock extends Clock {
        private Instant instant;

        public TestClock(Instant instant) {
            this.instant = instant;
        }

        public void setInstant(Instant instant) {
            this.instant = instant;
        }

        @Override
        public ZoneId getZone() {
            return ZoneId.of("UTC");
        }

        @Override
        public Clock withZone(ZoneId zone) {
            return this;
        }

        @Override
        public Instant instant() {
            return instant;
        }
    }
}
