package com.clerk.backend_api.helpers.security.models;

import java.util.List;
import java.util.Map;

public class M2MMachineAuthObject implements AuthObject {
    private TokenType token_type = TokenType.MACHINE_TOKEN;
    private String id;
    private String machineId;
    private String clientId;
    private String name;
    private List<String> scopes;
    private Map<String, Object> claims;

    public M2MMachineAuthObject(String id, String machineId, String clientId, String name,
        List<String> scopes, Map<String, Object> claims) {
        this.id = id;
        this.machineId = machineId;
        this.clientId = clientId;
        this.name = name;
        this.scopes = scopes;
        this.claims = claims;
    }

    public TokenType getToken_type() {
        return token_type;
    }

    public String getId() {
        return id;
    }

    public String getMachineId() {
        return machineId;
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

    public Map<String, Object> getClaims() {
        return claims;
    }
}
