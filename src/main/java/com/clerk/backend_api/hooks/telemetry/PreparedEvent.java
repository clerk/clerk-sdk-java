package com.clerk.backend_api.hooks.telemetry;

import java.util.TreeMap;

public class PreparedEvent {
    public final String event;
    public final String it;
    public final String sdk;
    public final String sdkv;
    public final String sk;
    public final TreeMap<String, String> payload;

    public PreparedEvent(String event, String it, String sdk, String sdkv, String sk, TreeMap<String, String> payload) {
        this.event = event;
        this.it = it;
        this.sdk = sdk;
        this.sdkv = sdkv;
        this.sk = sk;
        this.payload = payload;
    }

    public TreeMap<String, String> sanitize() {
        TreeMap<String, String> sanitizedEvent = new TreeMap<>();

        sanitizedEvent.put("event", event);
        sanitizedEvent.put("it", it);
        sanitizedEvent.put("sdk", sdk);
        sanitizedEvent.put("sdkv", sdkv);
        sanitizedEvent.putAll(payload);

        return sanitizedEvent;
    }

}
