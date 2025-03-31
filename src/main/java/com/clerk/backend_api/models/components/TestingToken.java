/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.components;

import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * TestingToken
 * 
 * <p>A Testing Token
 */
public class TestingToken {

    @JsonProperty("object")
    private TestingTokenObject object;

    /**
     * The actual token. This value is meant to be passed in the `__clerk_testing_token` query parameter with requests to the Frontend API.
     */
    @JsonProperty("token")
    private String token;

    /**
     * Unix timestamp of the token's expiration time.
     */
    @JsonProperty("expires_at")
    private long expiresAt;

    @JsonCreator
    public TestingToken(
            @JsonProperty("object") TestingTokenObject object,
            @JsonProperty("token") String token,
            @JsonProperty("expires_at") long expiresAt) {
        Utils.checkNotNull(object, "object");
        Utils.checkNotNull(token, "token");
        Utils.checkNotNull(expiresAt, "expiresAt");
        this.object = object;
        this.token = token;
        this.expiresAt = expiresAt;
    }

    @JsonIgnore
    public TestingTokenObject object() {
        return object;
    }

    /**
     * The actual token. This value is meant to be passed in the `__clerk_testing_token` query parameter with requests to the Frontend API.
     */
    @JsonIgnore
    public String token() {
        return token;
    }

    /**
     * Unix timestamp of the token's expiration time.
     */
    @JsonIgnore
    public long expiresAt() {
        return expiresAt;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    public TestingToken withObject(TestingTokenObject object) {
        Utils.checkNotNull(object, "object");
        this.object = object;
        return this;
    }

    /**
     * The actual token. This value is meant to be passed in the `__clerk_testing_token` query parameter with requests to the Frontend API.
     */
    public TestingToken withToken(String token) {
        Utils.checkNotNull(token, "token");
        this.token = token;
        return this;
    }

    /**
     * Unix timestamp of the token's expiration time.
     */
    public TestingToken withExpiresAt(long expiresAt) {
        Utils.checkNotNull(expiresAt, "expiresAt");
        this.expiresAt = expiresAt;
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
        TestingToken other = (TestingToken) o;
        return 
            Objects.deepEquals(this.object, other.object) &&
            Objects.deepEquals(this.token, other.token) &&
            Objects.deepEquals(this.expiresAt, other.expiresAt);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            object,
            token,
            expiresAt);
    }
    
    @Override
    public String toString() {
        return Utils.toString(TestingToken.class,
                "object", object,
                "token", token,
                "expiresAt", expiresAt);
    }
    
    public final static class Builder {
 
        private TestingTokenObject object;
 
        private String token;
 
        private Long expiresAt;
        
        private Builder() {
          // force use of static builder() method
        }

        public Builder object(TestingTokenObject object) {
            Utils.checkNotNull(object, "object");
            this.object = object;
            return this;
        }

        /**
         * The actual token. This value is meant to be passed in the `__clerk_testing_token` query parameter with requests to the Frontend API.
         */
        public Builder token(String token) {
            Utils.checkNotNull(token, "token");
            this.token = token;
            return this;
        }

        /**
         * Unix timestamp of the token's expiration time.
         */
        public Builder expiresAt(long expiresAt) {
            Utils.checkNotNull(expiresAt, "expiresAt");
            this.expiresAt = expiresAt;
            return this;
        }
        
        public TestingToken build() {
            return new TestingToken(
                object,
                token,
                expiresAt);
        }
    }
}
