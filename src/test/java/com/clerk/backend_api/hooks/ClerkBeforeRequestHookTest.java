package com.clerk.backend_api.hooks;

import com.clerk.backend_api.utils.Hook.BeforeRequestContext;
import com.clerk.backend_api.utils.Hook.BeforeRequestContextImpl;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClerkBeforeRequestHookTest {

    @Test
    void testBeforeRequestAddsHeader() throws Exception {
        // Arrange
        ClerkBeforeRequestHook hook = new ClerkBeforeRequestHook();

        // Instantiate BeforeRequestContext using its implementation
        BeforeRequestContext context = new BeforeRequestContextImpl(
            null,
            "http://example.com", // Provide a mock Base URL
            "test-operation-id", // Provide a mock operation ID
            Optional.empty(), // No OAuth scopes needed
            Optional.empty() // No SecuritySource needed
        );

        HttpRequest originalRequest = HttpRequest.newBuilder()
                .uri(new URI("http://example.com"))
                .build();

        // Act
        HttpRequest modifiedRequest = hook.beforeRequest(context, originalRequest);

        // Assert
        assertEquals("2024-10-01", modifiedRequest.headers().firstValue("Clerk-API-Version").orElse(null));
    }
}
