package com.clerk.backend_api.helpers.jwks;

/**
 * TokenVerificationException - Exception thrown when token verification fails.
 */
@SuppressWarnings("serial")
public final class TokenVerificationException extends Exception {
    private final TokenVerificationErrorReason reason;

    public TokenVerificationException(TokenVerificationErrorReason reason) {
        super(reason.message());
        this.reason = reason;
    }

    public TokenVerificationException(TokenVerificationErrorReason reason, Throwable cause) {
        super(reason.message(), cause);
        this.reason = reason;
    }

    public TokenVerificationErrorReason reason() {
        return reason;
    }
}
