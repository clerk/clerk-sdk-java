package com.clerk.backend_api.hooks.telemetry;

import com.clerk.backend_api.SecuritySource;
import com.clerk.backend_api.models.components.Security;
import com.clerk.backend_api.utils.Hook;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TelemetryEventTest {

    @Test
    void testConstructor_InitializesAllFields() {
        // Arrange
        String sk = "sk_test_123";
        String event = TelemetryEvent.EVENT_METHOD_CALLED;
        Map<String, String> payload = Map.of("key1", "value1", "key2", "value2");
        float samplingRate = 0.5f;

        // Act
        TelemetryEvent telemetryEvent = new TelemetryEvent(sk, event, payload, samplingRate);

        // Assert
        assertEquals(sk, telemetryEvent.sk, "SK should match");
        assertEquals("development", telemetryEvent.it, "IT should be development for test SK");
        assertEquals(event, telemetryEvent.event, "Event should match");
        assertEquals(payload, telemetryEvent.payload, "Payload should match");
        assertEquals(samplingRate, telemetryEvent.samplingRate, "Sampling rate should match");
    }

    @ParameterizedTest
    @MethodSource("provideSkValues")
    void testConstructor_SetsItBasedOnSk(String sk, String expectedIt) {
        // Arrange & Act
        TelemetryEvent telemetryEvent = new TelemetryEvent(
                sk,
                TelemetryEvent.EVENT_METHOD_CALLED,
                Map.of(),
                0.5f
        );

        // Assert
        assertEquals(expectedIt, telemetryEvent.it, "IT should be set correctly based on SK");
    }

    private static Stream<Arguments> provideSkValues() {
        return Stream.of(
                Arguments.of("sk_test_123", "development"),
                Arguments.of("sk_test_abc", "development"),
                Arguments.of("sk_live_456", "production"),
                // overly defensive
                Arguments.of("sk_123", "production"),
                Arguments.of(null, "production")
        );
    }

    @Test
    void testFromContext_WithSecuritySource() {
        // Arrange
        String operationId = "testOperation";
        String sk = "sk_test_xyz";
        Map<String, String> additionalPayload = Map.of("key1", "value1");
        float samplingRate = 0.75f;

        TestSecuritySource securitySource = new TestSecuritySource(sk);
        Hook.HookContext context = new TestHookContext(operationId, securitySource);

        // Act
        TelemetryEvent event = TelemetryEvent.fromContext(
                context,
                TelemetryEvent.EVENT_METHOD_SUCCEEDED,
                samplingRate,
                additionalPayload
        );

        // Assert
        assertEquals(sk, event.sk, "SK should be extracted from security source");
        assertEquals("development", event.it, "IT should be set to development for test SK");
        assertEquals(TelemetryEvent.EVENT_METHOD_SUCCEEDED, event.event, "Event type should match");
        assertEquals(samplingRate, event.samplingRate, "Sampling rate should match");
        assertEquals("testOperation", event.payload.get("method"), "Operation ID should be in payload");
        assertEquals("value1", event.payload.get("key1"), "Additional payload should be included");
    }

    @Test
    void testFromContext_WithoutSecuritySource() {
        // Arrange
        String operationId = "testOperation";
        Map<String, String> additionalPayload = Map.of("key1", "value1");
        float samplingRate = 0.75f;

        Hook.HookContext context = new TestHookContext(operationId, null);

        // Act
        TelemetryEvent event = TelemetryEvent.fromContext(
                context,
                TelemetryEvent.EVENT_METHOD_FAILED,
                samplingRate,
                additionalPayload
        );

        // Assert
        assertEquals("unknown", event.sk, "SK should be 'unknown' when security source is absent");
        assertEquals("production", event.it, "IT should be set to production for unknown SK");
        assertEquals(TelemetryEvent.EVENT_METHOD_FAILED, event.event, "Event type should match");
        assertEquals(samplingRate, event.samplingRate, "Sampling rate should match");
        assertEquals("testOperation", event.payload.get("method"), "Operation ID should be in payload");
        assertEquals("value1", event.payload.get("key1"), "Additional payload should be included");
    }

    @Test
    void testFromContext_EmptyAdditionalPayload() {
        // Arrange
        String operationId = "testOperation";
        String sk = "sk_live_abc";
        Map<String, String> emptyPayload = Map.of();
        float samplingRate = 0.1f;

        TestSecuritySource securitySource = new TestSecuritySource(sk);
        Hook.HookContext context = new TestHookContext(operationId, securitySource);

        // Act
        TelemetryEvent event = TelemetryEvent.fromContext(
                context,
                TelemetryEvent.EVENT_METHOD_CALLED,
                samplingRate,
                emptyPayload
        );

        // Assert
        assertEquals(1, event.payload.size(), "Payload should only contain the method");
        assertEquals("testOperation", event.payload.get("method"), "Operation ID should be in payload");
    }

    @Test
    void testFromContext_AdditionalPayloadOverridesMethod() {
        // Not so much behaviour we desire as documentation that this occurs
        // Arrange
        String operationId = "testOperation";
        String sk = "sk_test_abc";
        Map<String, String> overridingPayload = Map.of("method", "overridden-method");
        float samplingRate = 0.5f;

        TestSecuritySource securitySource = new TestSecuritySource(sk);
        Hook.HookContext context = new TestHookContext(operationId, securitySource);

        // Act
        TelemetryEvent event = TelemetryEvent.fromContext(
                context,
                TelemetryEvent.EVENT_METHOD_CALLED,
                samplingRate,
                overridingPayload
        );

        // Assert
        assertEquals(1, event.payload.size(), "Payload should only contain one method entry");
        assertEquals("overridden-method", event.payload.get("method"), "Additional payload should override the method");
    }

    // Test implementations of the interfaces needed for testing
    private static class TestHookContext implements Hook.HookContext {
        private final String operationId;
        private final SecuritySource securitySource;

        public TestHookContext(String operationId, SecuritySource securitySource) {
            this.operationId = operationId;
            this.securitySource = securitySource;
        }

        @Override
        public String operationId() {
            return operationId;
        }

        @Override
        public Optional<List<String>> oauthScopes() {
            return Optional.empty();
        }

        @Override
        public Optional<SecuritySource> securitySource() {
            return Optional.ofNullable(securitySource);
        }
    }

    private static class TestSecuritySource implements SecuritySource {
        private final String token;

        public TestSecuritySource(String token) {
            this.token = token;
        }

        @Override
        public Security getSecurity() {
            return new Security(Optional.of(token));
        }
    }

}