package com.clerk.backend_api.helpers.security.models;

import java.util.List;

public enum TokenType {
    SESSION_TOKEN ("session_token"),
    API_KEY ("api_key"),
    MACHINE_TOKEN ("machine_token"),
    OAUTH_TOKEN ("oauth_token"),
    ANY ("any");

    private final String type;
    TokenType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }

    public static List<TokenType> getAllTypes() {
        return List.of(SESSION_TOKEN, API_KEY, MACHINE_TOKEN, OAUTH_TOKEN, ANY);
    }
}

