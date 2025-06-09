package com.clerk.backend_api.helpers.security.models;

/**
 * AuthStatus - The request authentication status.
 */
public enum AuthStatus {
    SIGNED_IN("signed-in"),
    SIGNED_OUT("signed-out");

    private final String value;

    AuthStatus(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
