/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.components;

import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.InputStream;
import java.lang.Deprecated;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;

public class JWTTemplate {

    @JsonProperty("object")
    private JWTTemplateObject object;

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("claims")
    private Claims claims;

    @JsonProperty("lifetime")
    private long lifetime;

    @JsonProperty("allowed_clock_skew")
    private long allowedClockSkew;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("custom_signing_key")
    private Optional<? extends Boolean> customSigningKey;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("signing_algorithm")
    private Optional<? extends String> signingAlgorithm;

    /**
     * Unix timestamp of creation.
     * 
     */
    @JsonProperty("created_at")
    private long createdAt;

    /**
     * Unix timestamp of last update.
     * 
     */
    @JsonProperty("updated_at")
    private long updatedAt;

    @JsonCreator
    public JWTTemplate(
            @JsonProperty("object") JWTTemplateObject object,
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("claims") Claims claims,
            @JsonProperty("lifetime") long lifetime,
            @JsonProperty("allowed_clock_skew") long allowedClockSkew,
            @JsonProperty("custom_signing_key") Optional<? extends Boolean> customSigningKey,
            @JsonProperty("signing_algorithm") Optional<? extends String> signingAlgorithm,
            @JsonProperty("created_at") long createdAt,
            @JsonProperty("updated_at") long updatedAt) {
        Utils.checkNotNull(object, "object");
        Utils.checkNotNull(id, "id");
        Utils.checkNotNull(name, "name");
        Utils.checkNotNull(claims, "claims");
        Utils.checkNotNull(lifetime, "lifetime");
        Utils.checkNotNull(allowedClockSkew, "allowedClockSkew");
        Utils.checkNotNull(customSigningKey, "customSigningKey");
        Utils.checkNotNull(signingAlgorithm, "signingAlgorithm");
        Utils.checkNotNull(createdAt, "createdAt");
        Utils.checkNotNull(updatedAt, "updatedAt");
        this.object = object;
        this.id = id;
        this.name = name;
        this.claims = claims;
        this.lifetime = lifetime;
        this.allowedClockSkew = allowedClockSkew;
        this.customSigningKey = customSigningKey;
        this.signingAlgorithm = signingAlgorithm;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    public JWTTemplate(
            JWTTemplateObject object,
            String id,
            String name,
            Claims claims,
            long lifetime,
            long allowedClockSkew,
            long createdAt,
            long updatedAt) {
        this(object, id, name, claims, lifetime, allowedClockSkew, Optional.empty(), Optional.empty(), createdAt, updatedAt);
    }

    @JsonIgnore
    public JWTTemplateObject object() {
        return object;
    }

    @JsonIgnore
    public String id() {
        return id;
    }

    @JsonIgnore
    public String name() {
        return name;
    }

    @JsonIgnore
    public Claims claims() {
        return claims;
    }

    @JsonIgnore
    public long lifetime() {
        return lifetime;
    }

    @JsonIgnore
    public long allowedClockSkew() {
        return allowedClockSkew;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<Boolean> customSigningKey() {
        return (Optional<Boolean>) customSigningKey;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<String> signingAlgorithm() {
        return (Optional<String>) signingAlgorithm;
    }

    /**
     * Unix timestamp of creation.
     * 
     */
    @JsonIgnore
    public long createdAt() {
        return createdAt;
    }

    /**
     * Unix timestamp of last update.
     * 
     */
    @JsonIgnore
    public long updatedAt() {
        return updatedAt;
    }

    public final static Builder builder() {
        return new Builder();
    }

    public JWTTemplate withObject(JWTTemplateObject object) {
        Utils.checkNotNull(object, "object");
        this.object = object;
        return this;
    }

    public JWTTemplate withId(String id) {
        Utils.checkNotNull(id, "id");
        this.id = id;
        return this;
    }

    public JWTTemplate withName(String name) {
        Utils.checkNotNull(name, "name");
        this.name = name;
        return this;
    }

    public JWTTemplate withClaims(Claims claims) {
        Utils.checkNotNull(claims, "claims");
        this.claims = claims;
        return this;
    }

    public JWTTemplate withLifetime(long lifetime) {
        Utils.checkNotNull(lifetime, "lifetime");
        this.lifetime = lifetime;
        return this;
    }

    public JWTTemplate withAllowedClockSkew(long allowedClockSkew) {
        Utils.checkNotNull(allowedClockSkew, "allowedClockSkew");
        this.allowedClockSkew = allowedClockSkew;
        return this;
    }

    public JWTTemplate withCustomSigningKey(boolean customSigningKey) {
        Utils.checkNotNull(customSigningKey, "customSigningKey");
        this.customSigningKey = Optional.ofNullable(customSigningKey);
        return this;
    }

    public JWTTemplate withCustomSigningKey(Optional<? extends Boolean> customSigningKey) {
        Utils.checkNotNull(customSigningKey, "customSigningKey");
        this.customSigningKey = customSigningKey;
        return this;
    }

    public JWTTemplate withSigningAlgorithm(String signingAlgorithm) {
        Utils.checkNotNull(signingAlgorithm, "signingAlgorithm");
        this.signingAlgorithm = Optional.ofNullable(signingAlgorithm);
        return this;
    }

    public JWTTemplate withSigningAlgorithm(Optional<? extends String> signingAlgorithm) {
        Utils.checkNotNull(signingAlgorithm, "signingAlgorithm");
        this.signingAlgorithm = signingAlgorithm;
        return this;
    }

    /**
     * Unix timestamp of creation.
     * 
     */
    public JWTTemplate withCreatedAt(long createdAt) {
        Utils.checkNotNull(createdAt, "createdAt");
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Unix timestamp of last update.
     * 
     */
    public JWTTemplate withUpdatedAt(long updatedAt) {
        Utils.checkNotNull(updatedAt, "updatedAt");
        this.updatedAt = updatedAt;
        return this;
    }
    
    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        JWTTemplate other = (JWTTemplate) o;
        return 
            java.util.Objects.deepEquals(this.object, other.object) &&
            java.util.Objects.deepEquals(this.id, other.id) &&
            java.util.Objects.deepEquals(this.name, other.name) &&
            java.util.Objects.deepEquals(this.claims, other.claims) &&
            java.util.Objects.deepEquals(this.lifetime, other.lifetime) &&
            java.util.Objects.deepEquals(this.allowedClockSkew, other.allowedClockSkew) &&
            java.util.Objects.deepEquals(this.customSigningKey, other.customSigningKey) &&
            java.util.Objects.deepEquals(this.signingAlgorithm, other.signingAlgorithm) &&
            java.util.Objects.deepEquals(this.createdAt, other.createdAt) &&
            java.util.Objects.deepEquals(this.updatedAt, other.updatedAt);
    }
    
    @Override
    public int hashCode() {
        return java.util.Objects.hash(
            object,
            id,
            name,
            claims,
            lifetime,
            allowedClockSkew,
            customSigningKey,
            signingAlgorithm,
            createdAt,
            updatedAt);
    }
    
    @Override
    public String toString() {
        return Utils.toString(JWTTemplate.class,
                "object", object,
                "id", id,
                "name", name,
                "claims", claims,
                "lifetime", lifetime,
                "allowedClockSkew", allowedClockSkew,
                "customSigningKey", customSigningKey,
                "signingAlgorithm", signingAlgorithm,
                "createdAt", createdAt,
                "updatedAt", updatedAt);
    }
    
    public final static class Builder {
 
        private JWTTemplateObject object;
 
        private String id;
 
        private String name;
 
        private Claims claims;
 
        private Long lifetime;
 
        private Long allowedClockSkew;
 
        private Optional<? extends Boolean> customSigningKey = Optional.empty();
 
        private Optional<? extends String> signingAlgorithm = Optional.empty();
 
        private Long createdAt;
 
        private Long updatedAt;  
        
        private Builder() {
          // force use of static builder() method
        }

        public Builder object(JWTTemplateObject object) {
            Utils.checkNotNull(object, "object");
            this.object = object;
            return this;
        }

        public Builder id(String id) {
            Utils.checkNotNull(id, "id");
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            Utils.checkNotNull(name, "name");
            this.name = name;
            return this;
        }

        public Builder claims(Claims claims) {
            Utils.checkNotNull(claims, "claims");
            this.claims = claims;
            return this;
        }

        public Builder lifetime(long lifetime) {
            Utils.checkNotNull(lifetime, "lifetime");
            this.lifetime = lifetime;
            return this;
        }

        public Builder allowedClockSkew(long allowedClockSkew) {
            Utils.checkNotNull(allowedClockSkew, "allowedClockSkew");
            this.allowedClockSkew = allowedClockSkew;
            return this;
        }

        public Builder customSigningKey(boolean customSigningKey) {
            Utils.checkNotNull(customSigningKey, "customSigningKey");
            this.customSigningKey = Optional.ofNullable(customSigningKey);
            return this;
        }

        public Builder customSigningKey(Optional<? extends Boolean> customSigningKey) {
            Utils.checkNotNull(customSigningKey, "customSigningKey");
            this.customSigningKey = customSigningKey;
            return this;
        }

        public Builder signingAlgorithm(String signingAlgorithm) {
            Utils.checkNotNull(signingAlgorithm, "signingAlgorithm");
            this.signingAlgorithm = Optional.ofNullable(signingAlgorithm);
            return this;
        }

        public Builder signingAlgorithm(Optional<? extends String> signingAlgorithm) {
            Utils.checkNotNull(signingAlgorithm, "signingAlgorithm");
            this.signingAlgorithm = signingAlgorithm;
            return this;
        }

        /**
         * Unix timestamp of creation.
         * 
         */
        public Builder createdAt(long createdAt) {
            Utils.checkNotNull(createdAt, "createdAt");
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Unix timestamp of last update.
         * 
         */
        public Builder updatedAt(long updatedAt) {
            Utils.checkNotNull(updatedAt, "updatedAt");
            this.updatedAt = updatedAt;
            return this;
        }
        
        public JWTTemplate build() {
            return new JWTTemplate(
                object,
                id,
                name,
                claims,
                lifetime,
                allowedClockSkew,
                customSigningKey,
                signingAlgorithm,
                createdAt,
                updatedAt);
        }
    }
}

