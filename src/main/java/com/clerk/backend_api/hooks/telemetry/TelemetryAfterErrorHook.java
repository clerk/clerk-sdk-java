package com.clerk.backend_api.hooks.telemetry;

import com.clerk.backend_api.utils.Hook;

import java.io.InputStream;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TelemetryAfterErrorHook implements Hook.AfterError {

    private final List<TelemetryCollector> collectors;

    public TelemetryAfterErrorHook(List<TelemetryCollector> collectors) {
        this.collectors = collectors;
    }

    @SuppressWarnings("OptionalIsPresent")
    @Override
    public HttpResponse<InputStream> afterError(Hook.AfterErrorContext context, Optional<HttpResponse<InputStream>> response, Optional<Exception> error) throws Exception {
        Map<String, String> additionalPayload = new HashMap<>();
        if (response.isPresent()) {
            additionalPayload.put("status_code", String.valueOf(response.get().statusCode()));
        }
        if (error.isPresent()) {
            additionalPayload.put("error_message", error.get().getMessage());
        }

        TelemetryEvent event = TelemetryEvent.fromContext(
                context,
                TelemetryEvent.EVENT_METHOD_FAILED,
                0.1f,
                additionalPayload
        );
        collectors.forEach(c -> c.collect(event));
        if (response.isPresent()) {
            return response.get();
        } else if (error.isPresent()) {
           throw error.get();
        } else {
            throw new IllegalArgumentException("afterError called with no response or error");
        }
    }
}
