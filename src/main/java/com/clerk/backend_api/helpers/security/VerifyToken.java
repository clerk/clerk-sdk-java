package com.clerk.backend_api.helpers.security;

import com.clerk.backend_api.helpers.security.models.TokenType;
import com.clerk.backend_api.helpers.security.models.TokenVerificationException;
import com.clerk.backend_api.helpers.security.models.TokenVerificationResponse;
import com.clerk.backend_api.helpers.security.models.VerifyTokenOptions;
import com.clerk.backend_api.helpers.security.token_verifiers.impl.APIKeyTokenVerifier;
import com.clerk.backend_api.helpers.security.token_verifiers.impl.JwtSessionTokenVerifier;
import com.clerk.backend_api.helpers.security.token_verifiers.impl.MachineTokenVerifier;
import com.clerk.backend_api.helpers.security.token_verifiers.impl.OAuthTokenVerifier;
import java.io.IOException;

import static com.clerk.backend_api.helpers.security.util.TokenTypeHelper.getTokenType;

/**
 * VerifyToken - Helper methods for verifying JSON Web Tokens (JWT).
 */
public final class VerifyToken {

    private VerifyToken() {
        // prevent instantiation (this is a utility class)
    }

    public static TokenVerificationResponse<?> verifyToken(String token, VerifyTokenOptions options)
        throws TokenVerificationException, IOException, InterruptedException {
        TokenType tokenType = getTokenType(token);
        if (tokenType == TokenType.API_KEY) {
            return new APIKeyTokenVerifier().verify(token, options);
        } else if (tokenType == TokenType.MACHINE_TOKEN) {
            return new MachineTokenVerifier().verify(token, options);
        } else if (tokenType == TokenType.OAUTH_TOKEN) {
            return new OAuthTokenVerifier().verify(token, options);
        } else
            return JwtSessionTokenVerifier.verify(token, options);
    }

}
