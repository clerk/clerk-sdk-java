package com.clerk.backend_api.helpers.security.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

public class MachineAuthVerificationData {

    @JsonProperty("object")
    private String object;

    @JsonProperty("id")
    private String id;

    @JsonProperty("client_id")
    private String clientId;

    @JsonProperty("type")
    private String type;

    @JsonProperty("name")
    private String name;

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("scopes")
    private List<String> scopes;

    @JsonProperty("claims")
    private Map<String, Object> claims;

    @JsonProperty("created_at")
    private Long createdAt;

    @JsonProperty("updated_at")
    private Long updatedAt;

    @JsonProperty("expiration")
    private Long expiration;

    @JsonProperty("revoked")
    private Boolean revoked;

    @JsonProperty("revocation_reason")
    private String revocationReason;

    @JsonProperty("expired")
    private Boolean expired;

    @JsonProperty("created_by")
    private String createdBy;

    public MachineAuthVerificationData() {}

    public MachineAuthVerificationData(String object, String id, String clientId, String type, String name,
        String subject,
        List<String> scopes, Map<String, Object> claims, Long createdAt, Long updatedAt, Long expiration,
        Boolean revoked,
        String revocationReason, Boolean expired, String createdBy) {
        this.object = object;
        this.id = id;
        this.clientId = clientId;
        this.type = type;
        this.name = name;
        this.subject = subject;
        this.scopes = scopes;
        this.claims = claims;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.expiration = expiration;
        this.revoked = revoked;
        this.revocationReason = revocationReason;
        this.expired = expired;
        this.createdBy = createdBy;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<String> getScopes() {
        return scopes;
    }

    public void setScopes(List<String> scopes) {
        this.scopes = scopes;
    }

    public Map<String, Object> getClaims() {
        return claims;
    }

    public void setClaims(Map<String, Object> claims) {
        this.claims = claims;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getExpiration() {
        return expiration;
    }

    public void setExpiration(Long expiration) {
        this.expiration = expiration;
    }

    public Boolean getRevoked() {
        return revoked;
    }

    public void setRevoked(Boolean revoked) {
        this.revoked = revoked;
    }

    public String getRevocationReason() {
        return revocationReason;
    }

    public void setRevocationReason(String revocationReason) {
        this.revocationReason = revocationReason;
    }

    public Boolean getExpired() {
        return expired;
    }

    public void setExpired(Boolean expired) {
        this.expired = expired;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "ApiKey{" +
            "object='" + object + '\'' +
            ", id='" + id + '\'' +
            ", type='" + type + '\'' +
            ", name='" + name + '\'' +
            ", subject='" + subject + '\'' +
            ", scopes=" + scopes +
            ", claims=" + claims +
            ", createdAt=" + createdAt +
            ", updatedAt=" + updatedAt +
            ", expiration=" + expiration +
            ", revoked=" + revoked +
            ", revocationReason='" + revocationReason + '\'' +
            ", expired=" + expired +
            ", createdBy='" + createdBy + '\'' +
            '}';
    }
}
