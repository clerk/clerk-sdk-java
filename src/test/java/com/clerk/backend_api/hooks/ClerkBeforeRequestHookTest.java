package com.clerk.backend_api.hooks;

import com.clerk.backend_api.utils.Hook.BeforeRequestContext;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClerkBeforeRequestHookTest {

    @Test
    void testBeforeRequestAddsHeader() throws Exception {
        // Arrange
        ClerkBeforeRequestHook hook = new ClerkBeforeRequestHook();
        BeforeRequestContext context = new BeforeRequestContext(); // Assuming a default constructor is available
        HttpRequest originalRequest = HttpRequest.newBuilder()
                .uri(new URI("http://example.com"))
                .build();

        // Act
        HttpRequest modifiedRequest = hook.beforeRequest(context, originalRequest);

        // Assert
        assertEquals("2024-10-01", modifiedRequest.headers().firstValue("Clerk-API-Version").orElse(null));
    }
}