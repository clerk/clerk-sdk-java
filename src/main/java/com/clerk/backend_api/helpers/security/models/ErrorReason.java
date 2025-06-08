package com.clerk.backend_api.helpers.security.models;

/**
 * ErrorReason - Interface implemented by AuthErrorReason and TokenVerificationErrorReason.
 */
public interface ErrorReason {

    String id();

    String message();
}
