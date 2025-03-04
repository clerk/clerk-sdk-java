package com.clerk.backend_api.hooks;

import com.clerk.backend_api.utils.Helpers;
import com.clerk.backend_api.utils.Hook.BeforeRequest;
import com.clerk.backend_api.utils.Hook.BeforeRequestContext;

import java.net.http.HttpRequest;

final class ClerkBeforeRequestHook implements BeforeRequest {
    @Override
    public HttpRequest beforeRequest(BeforeRequestContext context, HttpRequest request) throws Exception {
        // modify the request object before it is sent, such as adding headers or query parameters
        // or throw an error to stop the request from being sent

        // Note that HttpRequest is immutable. With JDK 16 and later you can use
        // `HttpRequest.newBuilder(HttpRequest, BiPredicate<String, String>)` to copy the request
        // and modify it (the predicate is for filtering headers). If that method is not
        // available then use `Helpers.copy` in the generated `utils` package.

        HttpRequest.Builder b = Helpers.copy(request);
        b.header("Clerk-API-Version", "2024-10-01");
        return b.build();
    }
}