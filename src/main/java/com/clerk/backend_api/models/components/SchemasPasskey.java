/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.components;

import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Objects;
import java.util.Optional;

public class SchemasPasskey {

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("id")
    private Optional<String> id;

    /**
     * String representing the object's type. Objects of the same type share the same value.
     */
    @JsonProperty("object")
    private SchemasPasskeyObject object;

    @JsonProperty("name")
    private String name;

    /**
     * Unix timestamp of when the passkey was last used.
     */
    @JsonProperty("last_used_at")
    private long lastUsedAt;

    @JsonInclude(Include.ALWAYS)
    @JsonProperty("verification")
    private Optional<? extends SchemasPasskeyVerification> verification;

    @JsonCreator
    public SchemasPasskey(
            @JsonProperty("id") Optional<String> id,
            @JsonProperty("object") SchemasPasskeyObject object,
            @JsonProperty("name") String name,
            @JsonProperty("last_used_at") long lastUsedAt,
            @JsonProperty("verification") Optional<? extends SchemasPasskeyVerification> verification) {
        Utils.checkNotNull(id, "id");
        Utils.checkNotNull(object, "object");
        Utils.checkNotNull(name, "name");
        Utils.checkNotNull(lastUsedAt, "lastUsedAt");
        Utils.checkNotNull(verification, "verification");
        this.id = id;
        this.object = object;
        this.name = name;
        this.lastUsedAt = lastUsedAt;
        this.verification = verification;
    }
    
    public SchemasPasskey(
            SchemasPasskeyObject object,
            String name,
            long lastUsedAt) {
        this(Optional.empty(), object, name, lastUsedAt, Optional.empty());
    }

    @JsonIgnore
    public Optional<String> id() {
        return id;
    }

    /**
     * String representing the object's type. Objects of the same type share the same value.
     */
    @JsonIgnore
    public SchemasPasskeyObject object() {
        return object;
    }

    @JsonIgnore
    public String name() {
        return name;
    }

    /**
     * Unix timestamp of when the passkey was last used.
     */
    @JsonIgnore
    public long lastUsedAt() {
        return lastUsedAt;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<SchemasPasskeyVerification> verification() {
        return (Optional<SchemasPasskeyVerification>) verification;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    public SchemasPasskey withId(String id) {
        Utils.checkNotNull(id, "id");
        this.id = Optional.ofNullable(id);
        return this;
    }

    public SchemasPasskey withId(Optional<String> id) {
        Utils.checkNotNull(id, "id");
        this.id = id;
        return this;
    }

    /**
     * String representing the object's type. Objects of the same type share the same value.
     */
    public SchemasPasskey withObject(SchemasPasskeyObject object) {
        Utils.checkNotNull(object, "object");
        this.object = object;
        return this;
    }

    public SchemasPasskey withName(String name) {
        Utils.checkNotNull(name, "name");
        this.name = name;
        return this;
    }

    /**
     * Unix timestamp of when the passkey was last used.
     */
    public SchemasPasskey withLastUsedAt(long lastUsedAt) {
        Utils.checkNotNull(lastUsedAt, "lastUsedAt");
        this.lastUsedAt = lastUsedAt;
        return this;
    }

    public SchemasPasskey withVerification(SchemasPasskeyVerification verification) {
        Utils.checkNotNull(verification, "verification");
        this.verification = Optional.ofNullable(verification);
        return this;
    }

    public SchemasPasskey withVerification(Optional<? extends SchemasPasskeyVerification> verification) {
        Utils.checkNotNull(verification, "verification");
        this.verification = verification;
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
        SchemasPasskey other = (SchemasPasskey) o;
        return 
            Objects.deepEquals(this.id, other.id) &&
            Objects.deepEquals(this.object, other.object) &&
            Objects.deepEquals(this.name, other.name) &&
            Objects.deepEquals(this.lastUsedAt, other.lastUsedAt) &&
            Objects.deepEquals(this.verification, other.verification);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            object,
            name,
            lastUsedAt,
            verification);
    }
    
    @Override
    public String toString() {
        return Utils.toString(SchemasPasskey.class,
                "id", id,
                "object", object,
                "name", name,
                "lastUsedAt", lastUsedAt,
                "verification", verification);
    }
    
    public final static class Builder {
 
        private Optional<String> id = Optional.empty();
 
        private SchemasPasskeyObject object;
 
        private String name;
 
        private Long lastUsedAt;
 
        private Optional<? extends SchemasPasskeyVerification> verification = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        public Builder id(String id) {
            Utils.checkNotNull(id, "id");
            this.id = Optional.ofNullable(id);
            return this;
        }

        public Builder id(Optional<String> id) {
            Utils.checkNotNull(id, "id");
            this.id = id;
            return this;
        }

        /**
         * String representing the object's type. Objects of the same type share the same value.
         */
        public Builder object(SchemasPasskeyObject object) {
            Utils.checkNotNull(object, "object");
            this.object = object;
            return this;
        }

        public Builder name(String name) {
            Utils.checkNotNull(name, "name");
            this.name = name;
            return this;
        }

        /**
         * Unix timestamp of when the passkey was last used.
         */
        public Builder lastUsedAt(long lastUsedAt) {
            Utils.checkNotNull(lastUsedAt, "lastUsedAt");
            this.lastUsedAt = lastUsedAt;
            return this;
        }

        public Builder verification(SchemasPasskeyVerification verification) {
            Utils.checkNotNull(verification, "verification");
            this.verification = Optional.ofNullable(verification);
            return this;
        }

        public Builder verification(Optional<? extends SchemasPasskeyVerification> verification) {
            Utils.checkNotNull(verification, "verification");
            this.verification = verification;
            return this;
        }
        
        public SchemasPasskey build() {
            return new SchemasPasskey(
                id,
                object,
                name,
                lastUsedAt,
                verification);
        }
    }
}
