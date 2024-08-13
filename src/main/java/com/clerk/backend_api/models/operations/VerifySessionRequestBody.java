/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.operations;


import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

/**
 * VerifySessionRequestBody - Parameters.
 */

public class VerifySessionRequestBody {

    /**
     * The JWT that is sent via the `__session` cookie from your frontend.
     * Note: this JWT must be associated with the supplied session ID.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("token")
    private Optional<String> token;

    @JsonCreator
    public VerifySessionRequestBody(
            @JsonProperty("token") Optional<String> token) {
        Utils.checkNotNull(token, "token");
        this.token = token;
    }
    
    public VerifySessionRequestBody() {
        this(Optional.empty());
    }

    /**
     * The JWT that is sent via the `__session` cookie from your frontend.
     * Note: this JWT must be associated with the supplied session ID.
     */
    @JsonIgnore
    public Optional<String> token() {
        return token;
    }

    public final static Builder builder() {
        return new Builder();
    }

    /**
     * The JWT that is sent via the `__session` cookie from your frontend.
     * Note: this JWT must be associated with the supplied session ID.
     */
    public VerifySessionRequestBody withToken(String token) {
        Utils.checkNotNull(token, "token");
        this.token = Optional.ofNullable(token);
        return this;
    }

    /**
     * The JWT that is sent via the `__session` cookie from your frontend.
     * Note: this JWT must be associated with the supplied session ID.
     */
    public VerifySessionRequestBody withToken(Optional<String> token) {
        Utils.checkNotNull(token, "token");
        this.token = token;
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
        VerifySessionRequestBody other = (VerifySessionRequestBody) o;
        return 
            Objects.deepEquals(this.token, other.token);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            token);
    }
    
    @Override
    public String toString() {
        return Utils.toString(VerifySessionRequestBody.class,
                "token", token);
    }
    
    public final static class Builder {
 
        private Optional<String> token = Optional.empty();  
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * The JWT that is sent via the `__session` cookie from your frontend.
         * Note: this JWT must be associated with the supplied session ID.
         */
        public Builder token(String token) {
            Utils.checkNotNull(token, "token");
            this.token = Optional.ofNullable(token);
            return this;
        }

        /**
         * The JWT that is sent via the `__session` cookie from your frontend.
         * Note: this JWT must be associated with the supplied session ID.
         */
        public Builder token(Optional<String> token) {
            Utils.checkNotNull(token, "token");
            this.token = token;
            return this;
        }
        
        public VerifySessionRequestBody build() {
            return new VerifySessionRequestBody(
                token);
        }
    }
}

