package com.clerk.backend_api.helpers.jwks;

/**
 * TokenVerificationErrorReason - The reason for token verification failure.
 */
public enum TokenVerificationErrorReason implements ErrorReason {

    JWK_FAILED_TO_LOAD(
            "jwk-failed-to-load",
            "Failed to load JWKS from Clerk Backend API. Contact support@clerk.com."),
    JWK_REMOTE_INVALID(
            "jwk-remote-invalid",
            "The JWKS endpoint did not contain any signing keys. Contact support@clerk.com."),
    JWK_LOCAL_INVALID(
            "jwk-local-invalid",
            "The provided PEM Public Key is not in the proper format."),
    JWK_FAILED_TO_RESOLVE(
            "jwk-failed-to-resolve",
            "Failed to resolve JWK. Public Key is not in the proper format."),
    JWK_KID_MISMATCH(
            "jwk-kid-mismatch",
            "Unable to find a signing key in JWKS that matches the kid of the provided session token."),
    TOKEN_EXPIRED(
            "token-expired",
            "Token has expired and is no longer valid."),
    TOKEN_INVALID(
            "token-invalid",
            "Token is invalid and could not be verified."),
    TOKEN_INVALID_AUTHORIZED_PARTIES(
            "token-invalid-authorized-parties",
            "Authorized party claim (azp) does not match any of the authorized parties."),
    TOKEN_INVALID_AUDIENCE(
            "token-invalid-audience",
            "Token audience claim (aud) does not match one of the expected audience values."),
    TOKEN_IAT_IN_THE_FUTURE(
            "token-iat-in-the-future",
            "Token Issued At claim (iat) represents a time in the future."),
    TOKEN_NOT_ACTIVE_YET(
            "token-not-active-yet",
            "Token is not yet valid. Not Before claim (nbf) is in the future."),
    TOKEN_INVALID_SIGNATURE(
            "token-invalid-signature",
            "Token signature is invalid and could not be verified."),
    SECRET_KEY_MISSING(
            "secret-key-missing",
            "Missing Clerk Secret Key. Go to https://dashboard.clerk.com and get your key for your instance.");

    private final String id;
    private final String message;

    private TokenVerificationErrorReason(String id, String message) {
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
