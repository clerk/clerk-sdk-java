package com.clerk.backend_api.helpers.jwks;

/**
 * ErrorReason - Interface implemented by AuthErrorReason and TokenVerificationErrorReason.
 */
interface ErrorReason {

    String id();

    String message();
}
