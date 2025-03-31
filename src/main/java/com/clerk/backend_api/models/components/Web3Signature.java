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
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;

public class Web3Signature {

    @JsonProperty("status")
    private Web3SignatureVerificationStatus status;

    @JsonProperty("strategy")
    private Web3SignatureVerificationStrategy strategy;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("nonce")
    private JsonNullable<String> nonce;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("message")
    private JsonNullable<String> message;

    @JsonInclude(Include.ALWAYS)
    @JsonProperty("attempts")
    private Optional<Long> attempts;

    @JsonInclude(Include.ALWAYS)
    @JsonProperty("expire_at")
    private Optional<Long> expireAt;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("verified_at_client")
    private JsonNullable<String> verifiedAtClient;

    @JsonCreator
    public Web3Signature(
            @JsonProperty("status") Web3SignatureVerificationStatus status,
            @JsonProperty("strategy") Web3SignatureVerificationStrategy strategy,
            @JsonProperty("nonce") JsonNullable<String> nonce,
            @JsonProperty("message") JsonNullable<String> message,
            @JsonProperty("attempts") Optional<Long> attempts,
            @JsonProperty("expire_at") Optional<Long> expireAt,
            @JsonProperty("verified_at_client") JsonNullable<String> verifiedAtClient) {
        Utils.checkNotNull(status, "status");
        Utils.checkNotNull(strategy, "strategy");
        Utils.checkNotNull(nonce, "nonce");
        Utils.checkNotNull(message, "message");
        Utils.checkNotNull(attempts, "attempts");
        Utils.checkNotNull(expireAt, "expireAt");
        Utils.checkNotNull(verifiedAtClient, "verifiedAtClient");
        this.status = status;
        this.strategy = strategy;
        this.nonce = nonce;
        this.message = message;
        this.attempts = attempts;
        this.expireAt = expireAt;
        this.verifiedAtClient = verifiedAtClient;
    }
    
    public Web3Signature(
            Web3SignatureVerificationStatus status,
            Web3SignatureVerificationStrategy strategy) {
        this(status, strategy, JsonNullable.undefined(), JsonNullable.undefined(), Optional.empty(), Optional.empty(), JsonNullable.undefined());
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
    public JsonNullable<String> nonce() {
        return nonce;
    }

    @JsonIgnore
    public JsonNullable<String> message() {
        return message;
    }

    @JsonIgnore
    public Optional<Long> attempts() {
        return attempts;
    }

    @JsonIgnore
    public Optional<Long> expireAt() {
        return expireAt;
    }

    @JsonIgnore
    public JsonNullable<String> verifiedAtClient() {
        return verifiedAtClient;
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

    public Web3Signature withNonce(String nonce) {
        Utils.checkNotNull(nonce, "nonce");
        this.nonce = JsonNullable.of(nonce);
        return this;
    }

    public Web3Signature withNonce(JsonNullable<String> nonce) {
        Utils.checkNotNull(nonce, "nonce");
        this.nonce = nonce;
        return this;
    }

    public Web3Signature withMessage(String message) {
        Utils.checkNotNull(message, "message");
        this.message = JsonNullable.of(message);
        return this;
    }

    public Web3Signature withMessage(JsonNullable<String> message) {
        Utils.checkNotNull(message, "message");
        this.message = message;
        return this;
    }

    public Web3Signature withAttempts(long attempts) {
        Utils.checkNotNull(attempts, "attempts");
        this.attempts = Optional.ofNullable(attempts);
        return this;
    }

    public Web3Signature withAttempts(Optional<Long> attempts) {
        Utils.checkNotNull(attempts, "attempts");
        this.attempts = attempts;
        return this;
    }

    public Web3Signature withExpireAt(long expireAt) {
        Utils.checkNotNull(expireAt, "expireAt");
        this.expireAt = Optional.ofNullable(expireAt);
        return this;
    }

    public Web3Signature withExpireAt(Optional<Long> expireAt) {
        Utils.checkNotNull(expireAt, "expireAt");
        this.expireAt = expireAt;
        return this;
    }

    public Web3Signature withVerifiedAtClient(String verifiedAtClient) {
        Utils.checkNotNull(verifiedAtClient, "verifiedAtClient");
        this.verifiedAtClient = JsonNullable.of(verifiedAtClient);
        return this;
    }

    public Web3Signature withVerifiedAtClient(JsonNullable<String> verifiedAtClient) {
        Utils.checkNotNull(verifiedAtClient, "verifiedAtClient");
        this.verifiedAtClient = verifiedAtClient;
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
            Objects.deepEquals(this.message, other.message) &&
            Objects.deepEquals(this.attempts, other.attempts) &&
            Objects.deepEquals(this.expireAt, other.expireAt) &&
            Objects.deepEquals(this.verifiedAtClient, other.verifiedAtClient);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            status,
            strategy,
            nonce,
            message,
            attempts,
            expireAt,
            verifiedAtClient);
    }
    
    @Override
    public String toString() {
        return Utils.toString(Web3Signature.class,
                "status", status,
                "strategy", strategy,
                "nonce", nonce,
                "message", message,
                "attempts", attempts,
                "expireAt", expireAt,
                "verifiedAtClient", verifiedAtClient);
    }
    
    public final static class Builder {
 
        private Web3SignatureVerificationStatus status;
 
        private Web3SignatureVerificationStrategy strategy;
 
        private JsonNullable<String> nonce = JsonNullable.undefined();
 
        private JsonNullable<String> message = JsonNullable.undefined();
 
        private Optional<Long> attempts = Optional.empty();
 
        private Optional<Long> expireAt = Optional.empty();
 
        private JsonNullable<String> verifiedAtClient = JsonNullable.undefined();
        
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

        public Builder nonce(String nonce) {
            Utils.checkNotNull(nonce, "nonce");
            this.nonce = JsonNullable.of(nonce);
            return this;
        }

        public Builder nonce(JsonNullable<String> nonce) {
            Utils.checkNotNull(nonce, "nonce");
            this.nonce = nonce;
            return this;
        }

        public Builder message(String message) {
            Utils.checkNotNull(message, "message");
            this.message = JsonNullable.of(message);
            return this;
        }

        public Builder message(JsonNullable<String> message) {
            Utils.checkNotNull(message, "message");
            this.message = message;
            return this;
        }

        public Builder attempts(long attempts) {
            Utils.checkNotNull(attempts, "attempts");
            this.attempts = Optional.ofNullable(attempts);
            return this;
        }

        public Builder attempts(Optional<Long> attempts) {
            Utils.checkNotNull(attempts, "attempts");
            this.attempts = attempts;
            return this;
        }

        public Builder expireAt(long expireAt) {
            Utils.checkNotNull(expireAt, "expireAt");
            this.expireAt = Optional.ofNullable(expireAt);
            return this;
        }

        public Builder expireAt(Optional<Long> expireAt) {
            Utils.checkNotNull(expireAt, "expireAt");
            this.expireAt = expireAt;
            return this;
        }

        public Builder verifiedAtClient(String verifiedAtClient) {
            Utils.checkNotNull(verifiedAtClient, "verifiedAtClient");
            this.verifiedAtClient = JsonNullable.of(verifiedAtClient);
            return this;
        }

        public Builder verifiedAtClient(JsonNullable<String> verifiedAtClient) {
            Utils.checkNotNull(verifiedAtClient, "verifiedAtClient");
            this.verifiedAtClient = verifiedAtClient;
            return this;
        }
        
        public Web3Signature build() {
            return new Web3Signature(
                status,
                strategy,
                nonce,
                message,
                attempts,
                expireAt,
                verifiedAtClient);
        }
    }
}
