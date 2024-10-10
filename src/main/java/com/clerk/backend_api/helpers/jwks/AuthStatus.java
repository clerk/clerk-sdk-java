package com.clerk.backend_api.helpers.jwks;

/**
 * AuthStatus - The request authentication status.
 */
public enum AuthStatus {
    SIGNED_IN("signed-in"),
    SIGNED_OUT("signed-out");

    private final String value;

    private AuthStatus(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
