package com.clerk.backend_api.helpers.security.models;

/**
 * AuthErrorReason - The reason for request authentication failure.
 */
public enum AuthErrorReason implements ErrorReason {

    SESSION_TOKEN_MISSING(
            "session-token-missing",
            "Could not retrieve session token. Please make sure that the __session cookie or the HTTP authorization header contain a Clerk-generated session JWT"),
    SECRET_KEY_MISSING(
            "secret-key-missing",
            "Missing Clerk Secret Key. Go to https://dashboard.clerk.com and get your key for your instance."),
    INTERNAL_ERROR(
            "internal-error",
            "An internal error occurred while processing the request. Please try again later."),
    TOKEN_TYPE_NOT_SUPPORTED(
            "token-type-not-supported",
            "The provided token type is not supported. Please use a valid session token, API key, machine token, or OAuth token.");
    private final String id;
    private final String message;

    AuthErrorReason(String id, String message) {
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
