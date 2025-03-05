package com.clerk.backend_api.hooks;

import com.clerk.backend_api.utils.Hook;

import java.net.http.HttpRequest;

public class TelemetryBeforeRequestHook implements Hook.BeforeRequest {

    @Override
    public HttpRequest beforeRequest(Hook.BeforeRequestContext context, HttpRequest request) throws Exception {
        String sk = context.securitySource()
                .flatMap(x -> x.getSecurity().bearerAuth())
                .orElse("unknown");
        return request;

    }
}
