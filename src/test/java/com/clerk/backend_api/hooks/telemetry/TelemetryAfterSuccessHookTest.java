package com.clerk.backend_api.hooks.telemetry;

import com.clerk.backend_api.SecuritySource;
import com.clerk.backend_api.hooks.telemetry.TelemetryBeforeRequestHookTest.TestCollector;
import com.clerk.backend_api.models.components.Security;
import com.clerk.backend_api.utils.Hook;
import org.junit.jupiter.api.Test;

import javax.net.ssl.SSLSession;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TelemetryAfterSuccessHookTest {

    @Test
    void testAfterSuccess_CollectsEvent() throws Exception {
        // Arrange
        TestCollector collector = new TestCollector();

        TelemetryAfterSuccessHook hook = new TelemetryAfterSuccessHook(List.of(collector));

        String operationId = "test-operation";
        String expectedSk = "abc";
        Hook.AfterSuccessContext context = new Hook.AfterSuccessContextImpl(
                operationId,
                Optional.empty(),
                Optional.of(new SecuritySource.DefaultSecuritySource(new Security(Optional.of(expectedSk)))));

        HttpResponse<InputStream> originalResponse = new TestHttpResponse(200);

        // Act
        HttpResponse<InputStream> resultResponse = hook.afterSuccess(context, originalResponse);

        // Assert
        TelemetryEvent actual = collector.collectedEvents.get(0);
        assertNotNull(actual, "Event should have been collected");
        assertEquals(expectedSk, actual.sk, "SK should be set to the token");
        assertEquals(TelemetryEvent.EVENT_METHOD_SUCCEEDED, actual.event, "Event type should be METHOD_SUCCEEDED");
        assertEquals(0.1f, actual.samplingRate, "Sampling rate should be 0.1f");
        assertEquals(operationId, actual.payload.get("method"), "Operation ID should be in payload");
        assertEquals("200", actual.payload.get("status_code"), "Status code should be in payload");
        assertSame(originalResponse, resultResponse, "Response should be returned unchanged");
    }

    // Helper test classes
    // We just make a fake even though we only need this to use statusCode
    public static class TestHttpResponse implements HttpResponse<InputStream> {
        private final int statusCode;

        public TestHttpResponse(int statusCode) {
            this.statusCode = statusCode;
        }

        @Override
        public int statusCode() {
            return statusCode;
        }

        @Override
        public HttpRequest request() {
            return null;
        }

        @Override
        public Optional<HttpResponse<InputStream>> previousResponse() {
            return Optional.empty();
        }

        @Override
        public HttpHeaders headers() {
            return HttpHeaders.of(new java.util.HashMap<>(), (k, v) -> true);
        }

        @Override
        public InputStream body() {
            return null;
        }

        @Override
        public Optional<SSLSession> sslSession() {
            return Optional.empty();
        }

        @Override
        public URI uri() {
            try {
                return new URI("https://example.com");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public HttpClient.Version version() {
            return HttpClient.Version.HTTP_2;
        }
    }

}