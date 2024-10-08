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
import java.util.Objects;
import org.openapitools.jackson.nullable.JsonNullable;


public class Web3Signature {

    @JsonProperty("status")
    private Web3SignatureVerificationStatus status;

    @JsonProperty("strategy")
    private Web3SignatureVerificationStrategy strategy;

    @JsonProperty("nonce")
    private Nonce nonce;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("attempts")
    private JsonNullable<Long> attempts;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("expire_at")
    private JsonNullable<Long> expireAt;

    @JsonCreator
    public Web3Signature(
            @JsonProperty("status") Web3SignatureVerificationStatus status,
            @JsonProperty("strategy") Web3SignatureVerificationStrategy strategy,
            @JsonProperty("nonce") Nonce nonce,
            @JsonProperty("attempts") JsonNullable<Long> attempts,
            @JsonProperty("expire_at") JsonNullable<Long> expireAt) {
        Utils.checkNotNull(status, "status");
        Utils.checkNotNull(strategy, "strategy");
        Utils.checkNotNull(nonce, "nonce");
        Utils.checkNotNull(attempts, "attempts");
        Utils.checkNotNull(expireAt, "expireAt");
        this.status = status;
        this.strategy = strategy;
        this.nonce = nonce;
        this.attempts = attempts;
        this.expireAt = expireAt;
    }
    
    public Web3Signature(
            Web3SignatureVerificationStatus status,
            Web3SignatureVerificationStrategy strategy,
            Nonce nonce) {
        this(status, strategy, nonce, JsonNullable.undefined(), JsonNullable.undefined());
    }

    @JsonIgnore
    public Web3SignatureVerificationStatus status() {
        return status;
    }

    @JsonIgnore
    public Web3SignatureVerificationStrategy strategy() {
        return strategy;
    }

    @JsonIgnore
    public Nonce nonce() {
        return nonce;
    }

    @JsonIgnore
    public JsonNullable<Long> attempts() {
        return attempts;
    }

    @JsonIgnore
    public JsonNullable<Long> expireAt() {
        return expireAt;
    }

    public final static Builder builder() {
        return new Builder();
    }

    public Web3Signature withStatus(Web3SignatureVerificationStatus status) {
        Utils.checkNotNull(status, "status");
        this.status = status;
        return this;
    }

    public Web3Signature withStrategy(Web3SignatureVerificationStrategy strategy) {
        Utils.checkNotNull(strategy, "strategy");
        this.strategy = strategy;
        return this;
    }

    public Web3Signature withNonce(Nonce nonce) {
        Utils.checkNotNull(nonce, "nonce");
        this.nonce = nonce;
        return this;
    }

    public Web3Signature withAttempts(long attempts) {
        Utils.checkNotNull(attempts, "attempts");
        this.attempts = JsonNullable.of(attempts);
        return this;
    }

    public Web3Signature withAttempts(JsonNullable<Long> attempts) {
        Utils.checkNotNull(attempts, "attempts");
        this.attempts = attempts;
        return this;
    }

    public Web3Signature withExpireAt(long expireAt) {
        Utils.checkNotNull(expireAt, "expireAt");
        this.expireAt = JsonNullable.of(expireAt);
        return this;
    }

    public Web3Signature withExpireAt(JsonNullable<Long> expireAt) {
        Utils.checkNotNull(expireAt, "expireAt");
        this.expireAt = expireAt;
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
        Web3Signature other = (Web3Signature) o;
        return 
            Objects.deepEquals(this.status, other.status) &&
            Objects.deepEquals(this.strategy, other.strategy) &&
            Objects.deepEquals(this.nonce, other.nonce) &&
            Objects.deepEquals(this.attempts, other.attempts) &&
            Objects.deepEquals(this.expireAt, other.expireAt);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            status,
            strategy,
            nonce,
            attempts,
            expireAt);
    }
    
    @Override
    public String toString() {
        return Utils.toString(Web3Signature.class,
                "status", status,
                "strategy", strategy,
                "nonce", nonce,
                "attempts", attempts,
                "expireAt", expireAt);
    }
    
    public final static class Builder {
 
        private Web3SignatureVerificationStatus status;
 
        private Web3SignatureVerificationStrategy strategy;
 
        private Nonce nonce;
 
        private JsonNullable<Long> attempts = JsonNullable.undefined();
 
        private JsonNullable<Long> expireAt = JsonNullable.undefined();  
        
        private Builder() {
          // force use of static builder() method
        }

        public Builder status(Web3SignatureVerificationStatus status) {
            Utils.checkNotNull(status, "status");
            this.status = status;
            return this;
        }

        public Builder strategy(Web3SignatureVerificationStrategy strategy) {
            Utils.checkNotNull(strategy, "strategy");
            this.strategy = strategy;
            return this;
        }

        public Builder nonce(Nonce nonce) {
            Utils.checkNotNull(nonce, "nonce");
            this.nonce = nonce;
            return this;
        }

        public Builder attempts(long attempts) {
            Utils.checkNotNull(attempts, "attempts");
            this.attempts = JsonNullable.of(attempts);
            return this;
        }

        public Builder attempts(JsonNullable<Long> attempts) {
            Utils.checkNotNull(attempts, "attempts");
            this.attempts = attempts;
            return this;
        }

        public Builder expireAt(long expireAt) {
            Utils.checkNotNull(expireAt, "expireAt");
            this.expireAt = JsonNullable.of(expireAt);
            return this;
        }

        public Builder expireAt(JsonNullable<Long> expireAt) {
            Utils.checkNotNull(expireAt, "expireAt");
            this.expireAt = expireAt;
            return this;
        }
        
        public Web3Signature build() {
            return new Web3Signature(
                status,
                strategy,
                nonce,
                attempts,
                expireAt);
        }
    }
}

