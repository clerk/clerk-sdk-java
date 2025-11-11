package com.clerk.backend_api.hooks.telemetry;

import com.clerk.backend_api.SecuritySource;
import com.clerk.backend_api.hooks.telemetry.TelemetryBeforeRequestHookTest.TestCollector;
import com.clerk.backend_api.models.components.Security;
import com.clerk.backend_api.utils.Hook;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TelemetryAfterErrorHookTest {

    @Test
    void testAfterError_WithResponse_CollectsEventAndReturnsResponse() throws Exception {
        // Arrange
        TestCollector collector = new TestCollector();
        TelemetryAfterErrorHook hook = new TelemetryAfterErrorHook(List.of(collector));

        String operationId = "test-operation";
        String expectedSk = "abc";
        Hook.AfterErrorContext context = new Hook.AfterErrorContextImpl(
                operationId,
                Optional.empty(),
                Optional.of(new SecuritySource.DefaultSecuritySource(new Security(Optional.of(expectedSk)))));

        HttpResponse<InputStream> originalResponse = new TelemetryAfterSuccessHookTest.TestHttpResponse(404);

        // Act
        HttpResponse<InputStream> resultResponse = hook.afterError(context, Optional.of(originalResponse), Optional.empty());

        // Assert
        TelemetryEvent actual = collector.collectedEvents.get(0);
        assertNotNull(actual, "Event should have been collected");
        assertEquals(expectedSk, actual.sk, "SK should be set to the token");
        assertEquals(TelemetryEvent.EVENT_METHOD_FAILED, actual.event, "Event type should be METHOD_FAILED");
        assertEquals(0.1f, actual.samplingRate, "Sampling rate should be 0.1f");
        assertEquals(operationId, actual.payload.get("method"), "Operation ID should be in payload");
        assertEquals("404", actual.payload.get("status_code"), "Status code should be in payload");
        assertFalse(actual.payload.containsKey("error_message"), "Error message should not be in payload");
        assertSame(originalResponse, resultResponse, "Response should be returned unchanged");
    }

    @Test
    void testAfterError_WithException_CollectsEventAndRethrowsException() {
        // Arrange
        TestCollector collector = new TestCollector();
        TelemetryAfterErrorHook hook = new TelemetryAfterErrorHook(List.of(collector));

        String operationId = "test-operation";
        String expectedSk = "abc";
        Hook.AfterErrorContext context = new Hook.AfterErrorContextImpl(
                operationId,
                Optional.empty(),
                Optional.of(new SecuritySource.DefaultSecuritySource(new Security(Optional.of(expectedSk)))));

        Exception originalException = new RuntimeException("Test error message");

        // Act & Assert
        Exception thrownException = assertThrows(Exception.class, () ->
                hook.afterError(context, Optional.empty(), Optional.of(originalException))
        );

        // Assert exception
        assertSame(originalException, thrownException, "Original exception should be rethrown");

        // Assert telemetry event
        TelemetryEvent actual = collector.collectedEvents.get(0);
        assertNotNull(actual, "Event should have been collected");
        assertEquals(expectedSk, actual.sk, "SK should be set to the token");
        assertEquals(TelemetryEvent.EVENT_METHOD_FAILED, actual.event, "Event type should be METHOD_FAILED");
        assertEquals(0.1f, actual.samplingRate, "Sampling rate should be 0.1f");
        assertEquals(operationId, actual.payload.get("method"), "Operation ID should be in payload");
        assertFalse(actual.payload.containsKey("status_code"), "Status code should not be in payload");
        assertEquals("Test error message", actual.payload.get("error_message"), "Error message should be in payload");
    }


}