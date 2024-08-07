/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.operations;

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
    private Optional<? extends String> token;

    @JsonCreator
    public VerifySessionRequestBody(
            @JsonProperty("token") Optional<? extends String> token) {
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
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<String> token() {
        return (Optional<String>) token;
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
    public VerifySessionRequestBody withToken(Optional<? extends String> token) {
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
            java.util.Objects.deepEquals(this.token, other.token);
    }
    
    @Override
    public int hashCode() {
        return java.util.Objects.hash(
            token);
    }
    
    @Override
    public String toString() {
        return Utils.toString(VerifySessionRequestBody.class,
                "token", token);
    }
    
    public final static class Builder {
 
        private Optional<? extends String> token = Optional.empty();  
        
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
        public Builder token(Optional<? extends String> token) {
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

