package com.clerk.backend_api.helpers.security.util;

import com.clerk.backend_api.helpers.security.models.TokenPrefix;
import com.clerk.backend_api.helpers.security.models.TokenType;

public class TokenTypeHelper {

    public static TokenType getTokenType(String token) {
        if (token.startsWith(TokenPrefix.API_KEY_PREFIX.getPrefix())) {
            return TokenType.API_KEY;
        } else if (token.startsWith(TokenPrefix.MACHINE_TOKEN_PREFIX.getPrefix())) {
            return TokenType.MACHINE_TOKEN;
        } else if (token.startsWith(TokenPrefix.OAUTH_TOKEN_PREFIX.getPrefix())) {
            return TokenType.OAUTH_TOKEN;
        } else {
            return TokenType.SESSION_TOKEN; // Default to SESSION_TOKEN for JWTs
        }
    }

}
