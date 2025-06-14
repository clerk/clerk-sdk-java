package com.clerk.backend_api.hooks.telemetry;

import com.clerk.backend_api.SecuritySource;
import com.clerk.backend_api.models.components.Security;
import com.clerk.backend_api.utils.Hook;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TelemetryBeforeRequestHookTest {


    @Test
    void testBeforeRequest_CollectsEvent() throws Exception {
        // Arrange
        TestCollector collector = new TestCollector();

        TelemetryBeforeRequestHook hook = new TelemetryBeforeRequestHook(List.of(collector));

        String operationId = "test-operation";
        String expectedSk = "abc";
        Hook.BeforeRequestContext context = new Hook.BeforeRequestContextImpl(
                operationId,
                Optional.empty(),
                Optional.of(new SecuritySource.DefaultSecuritySource(new Security(Optional.of(expectedSk)))));

        HttpRequest originalRequest = HttpRequest.newBuilder()
                .uri(new URI("http://example.com"))
                .build();

        // Act
        HttpRequest resultRequest = hook.beforeRequest(context, originalRequest);

        // Assert
        TelemetryEvent actual = collector.collectedEvents.get(0);
        assertNotNull(actual, "Event should have been collected");
        assertEquals("abc", actual.sk, "SK should be set to the token");
        assertEquals(TelemetryEvent.EVENT_METHOD_CALLED, actual.event, "Event type should be METHOD_CALLED");
        assertEquals(0.1f, actual.samplingRate, "Sampling rate should be 0.1f");
        assertEquals(operationId, actual.payload.get("method"), "Operation ID should be in payload");
        assertSame(originalRequest, resultRequest, "Request should be returned unchanged");
    }

    // Helper test classes
    static class TestCollector implements TelemetryCollector {
        public final List<TelemetryEvent> collectedEvents = new ArrayList<>();
        @Override
        public void collect(TelemetryEvent event) {
            collectedEvents.add(event);
        }
    }

}