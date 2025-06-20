package com.clerk.backend_api.helpers.security.models;

import java.util.List;

public class OAuthMachineAuthObject implements AuthObject {
    public TokenType token_type = TokenType.OAUTH_TOKEN;
    public String id;
    public String userId;
    public String clientId;
    public String name;
    public List<String> scopes;

    public OAuthMachineAuthObject(String id, String userId, String clientId, String name, List<String> scopes) {
        this.id = id;
        this.userId = userId;
        this.clientId = clientId;
        this.name = name;
        this.scopes = scopes;
    }

    public TokenType getToken_type() {
        return token_type;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getClientId() {
        return clientId;
    }

    public String getName() {
        return name;
    }

    public List<String> getScopes() {
        return scopes;
    }
}
