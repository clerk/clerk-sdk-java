package com.clerk.backend_api.hooks.telemetry;

import com.clerk.backend_api.utils.Hook;

import java.util.Map;
import java.util.TreeMap;

public class TelemetryEvent {
    public static final String EVENT_METHOD_CALLED = "METHOD_CALLED";
    public static final String EVENT_METHOD_SUCCEEDED = "METHOD_SUCCEEDED";
    public static final String EVENT_METHOD_FAILED = "METHOD_FAILED";

    public final String sk;
    public final String it;
    public final String event;
    public final Map<String, String> payload;
    public final float samplingRate;

    public TelemetryEvent(
            String sk,
            String event,
            Map<String, String> payload,
            float samplingRate
    ) {
        this.sk = sk;
        this.it = sk != null && sk.startsWith("sk_test") ? "development" : "production";
        this.event = event;
        this.payload = payload;
        this.samplingRate = samplingRate;
    }

    public static TelemetryEvent fromContext(
            Hook.HookContext ctx,
            String event,
            float samplingRate,
            Map<String, String> additionalPayload
    ) {
        String sk = ctx.securitySource()
                .flatMap(x -> x.getSecurity().bearerAuth())
                .orElse("unknown");
        Map<String, String> payload = new TreeMap<>();
        payload.put("method", ctx.operationId());
        payload.putAll(additionalPayload);
        return new TelemetryEvent(
            sk,
            event,
            payload,
            samplingRate
        );
    }

}
