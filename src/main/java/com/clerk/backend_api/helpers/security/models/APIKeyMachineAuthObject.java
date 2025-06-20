package com.clerk.backend_api.helpers.security.models;

import io.jsonwebtoken.Claims;
import java.util.List;
import java.util.Map;

public class APIKeyMachineAuthObject implements AuthObject {
    private TokenType tokenType = TokenType.API_KEY;
    private String id;
    private String userId;
    private String orgId;
    private String name;
    private List<String> scopes;
    private Map<String, Object> claims;

    public APIKeyMachineAuthObject(String id, String userId, String orgId, String name,
        List<String> scopes, Map<String, Object> claims) {
        this.id = id;
        this.userId = userId;
        this.orgId = orgId;
        this.name = name;
        this.scopes = scopes;
        this.claims = claims;
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getOrgId() {
        return orgId;
    }

    public String getName() {
        return name;
    }

    public List<String> getScopes() {
        return scopes;
    }

    public Map<String, Object> getClaims() {
        return claims;
    }
}
