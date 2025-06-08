package com.clerk.backend_api.helpers.security.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

public class MachineAuthVerificationData {

    @JsonProperty("object")
    private String object;

    @JsonProperty("id")
    private String id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("name")
    private String name;

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("scopes")
    private List<String> scopes;

    @JsonProperty("claims")
    private Claims claims;

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

    // Nested class for claims
    public static class Claims {
        @JsonProperty("permissions")
        private List<String> permissions;

        // Default constructor
        public Claims() {}

        // Getters and setters
        public List<String> getPermissions() {
            return permissions;
        }

        public void setPermissions(List<String> permissions) {
            this.permissions = permissions;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Claims claims = (Claims) o;
            return Objects.equals(permissions, claims.permissions);
        }

        @Override
        public int hashCode() {
            return Objects.hash(permissions);
        }

        @Override
        public String toString() {
            return "Claims{" +
                "permissions=" + permissions +
                '}';
        }
    }

    public MachineAuthVerificationData() {}

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

    public Claims getClaims() {
        return claims;
    }

    public void setClaims(Claims claims) {
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
