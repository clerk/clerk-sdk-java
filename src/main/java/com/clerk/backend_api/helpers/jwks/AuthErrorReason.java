package com.clerk.backend_api.helpers.jwks;

/**
 * AuthErrorReason - The reason for request authentication failure.
 */
public enum AuthErrorReason implements ErrorReason {

    SESSION_TOKEN_MISSING(
            "session-token-missing",
            "Could not retrieve session token. Please make sure that the __session cookie or the HTTP authorization header contain a Clerk-generated session JWT"),
    SECRET_KEY_MISSING(
            "secret-key-missing",
            "Missing Clerk Secret Key. Go to https://dashboard.clerk.com and get your key for your instance.");

    private final String id;
    private final String message;

    private AuthErrorReason(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public String id() {
        return id;
    }

    public String message() {
        return message;
    }
}
