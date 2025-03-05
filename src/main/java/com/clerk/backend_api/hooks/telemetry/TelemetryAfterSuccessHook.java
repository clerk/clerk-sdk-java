package com.clerk.backend_api.hooks.telemetry;

import com.clerk.backend_api.utils.Hook;

import java.io.InputStream;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class TelemetryAfterSuccessHook implements Hook.AfterSuccess {

    private final List<TelemetryCollector> collectors;

    public TelemetryAfterSuccessHook(List<TelemetryCollector> collectors) {
        this.collectors = collectors;
    }

    @Override
    public HttpResponse<InputStream> afterSuccess(Hook.AfterSuccessContext context, HttpResponse<InputStream> response) throws Exception {
        TelemetryEvent event = TelemetryEvent.fromContext(
                context,
                TelemetryEvent.EVENT_METHOD_SUCCEEDED,
                0.1f,
                Map.of("status_code", String.valueOf(response.statusCode()))
        );
        collectors.forEach(c -> c.collect(event));
        return response;
    }
}
