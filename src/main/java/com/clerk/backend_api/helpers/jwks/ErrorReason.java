package com.clerk.backend_api.helpers.jwks;

/**
 * ErrorReason - Interface implemented by AuthErrorReason and TokenVerificationErrorReason.
 */
public interface ErrorReason {

    String id();

    String message();
}
