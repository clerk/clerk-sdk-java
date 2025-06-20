package com.clerk.backend_api.helpers.security.models;

import java.util.List;
import java.util.Map;

public class SessionAuthObjectV1 implements AuthObject {
    private String sessionId;
    private String userId;
    private String orgId;
    private String orgRole;
    private List<String> orgPermissions;
    private List<Integer> factorVerificationAge;
    private Map<String, Object> claims;

    public SessionAuthObjectV1(String sessionId, String userId, String orgId, String orgRole,
        List<String> orgPermissions,
        List<Integer> factorVerificationAge, Map<String, Object> claims) {
        this.sessionId = sessionId;
        this.userId = userId;
        this.orgId = orgId;
        this.orgRole = orgRole;
        this.orgPermissions = orgPermissions;
        this.factorVerificationAge = factorVerificationAge;
        this.claims = claims;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getUserId() {
        return userId;
    }

    public String getOrgId() {
        return orgId;
    }

    public String getOrgRole() {
        return orgRole;
    }

    public List<String> getOrgPermissions() {
        return orgPermissions;
    }

    public List<Integer> getFactorVerificationAge() {
        return factorVerificationAge;
    }

    public Map<String, Object> getClaims() {
        return claims;
    }
}
