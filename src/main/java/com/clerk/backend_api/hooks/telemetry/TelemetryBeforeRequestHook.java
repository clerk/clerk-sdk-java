package com.clerk.backend_api.hooks.telemetry;

import com.clerk.backend_api.utils.Hook;

import java.net.http.HttpRequest;
import java.util.List;
import java.util.Map;

public class TelemetryBeforeRequestHook implements Hook.BeforeRequest {

    // only visible so we can test
    public final List<TelemetryCollector> collectors;

    public TelemetryBeforeRequestHook(List<TelemetryCollector> collectors) {
        this.collectors = collectors;
    }

    @Override
    public HttpRequest beforeRequest(Hook.BeforeRequestContext context, HttpRequest request) throws Exception {
        TelemetryEvent event = TelemetryEvent.fromContext(
                context,
                TelemetryEvent.EVENT_METHOD_CALLED,
                0.1f,
                Map.of()
        );
        collectors.forEach(c -> c.collect(event));
        return request;

    }
}
