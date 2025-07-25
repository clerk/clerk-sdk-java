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
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;


public class Passkey {

    @JsonProperty("status")
    private PasskeyVerificationStatus status;


    @JsonProperty("strategy")
    private PasskeyVerificationStrategy strategy;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("nonce")
    private Optional<? extends Nonce> nonce;


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
    public Passkey(
            @JsonProperty("status") PasskeyVerificationStatus status,
            @JsonProperty("strategy") PasskeyVerificationStrategy strategy,
            @JsonProperty("nonce") Optional<? extends Nonce> nonce,
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
    
    public Passkey(
            PasskeyVerificationStatus status,
            PasskeyVerificationStrategy strategy) {
        this(status, strategy, Optional.empty(),
            JsonNullable.undefined(), Optional.empty(), Optional.empty(),
            JsonNullable.undefined());
    }

    @JsonIgnore
    public PasskeyVerificationStatus status() {
        return status;
    }

    @JsonIgnore
    public PasskeyVerificationStrategy strategy() {
        return strategy;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<Nonce> nonce() {
        return (Optional<Nonce>) nonce;
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

    public static Builder builder() {
        return new Builder();
    }


    public Passkey withStatus(PasskeyVerificationStatus status) {
        Utils.checkNotNull(status, "status");
        this.status = status;
        return this;
    }

    public Passkey withStrategy(PasskeyVerificationStrategy strategy) {
        Utils.checkNotNull(strategy, "strategy");
        this.strategy = strategy;
        return this;
    }

    public Passkey withNonce(Nonce nonce) {
        Utils.checkNotNull(nonce, "nonce");
        this.nonce = Optional.ofNullable(nonce);
        return this;
    }


    public Passkey withNonce(Optional<? extends Nonce> nonce) {
        Utils.checkNotNull(nonce, "nonce");
        this.nonce = nonce;
        return this;
    }

    public Passkey withMessage(String message) {
        Utils.checkNotNull(message, "message");
        this.message = JsonNullable.of(message);
        return this;
    }

    public Passkey withMessage(JsonNullable<String> message) {
        Utils.checkNotNull(message, "message");
        this.message = message;
        return this;
    }

    public Passkey withAttempts(long attempts) {
        Utils.checkNotNull(attempts, "attempts");
        this.attempts = Optional.ofNullable(attempts);
        return this;
    }


    public Passkey withAttempts(Optional<Long> attempts) {
        Utils.checkNotNull(attempts, "attempts");
        this.attempts = attempts;
        return this;
    }

    public Passkey withExpireAt(long expireAt) {
        Utils.checkNotNull(expireAt, "expireAt");
        this.expireAt = Optional.ofNullable(expireAt);
        return this;
    }


    public Passkey withExpireAt(Optional<Long> expireAt) {
        Utils.checkNotNull(expireAt, "expireAt");
        this.expireAt = expireAt;
        return this;
    }

    public Passkey withVerifiedAtClient(String verifiedAtClient) {
        Utils.checkNotNull(verifiedAtClient, "verifiedAtClient");
        this.verifiedAtClient = JsonNullable.of(verifiedAtClient);
        return this;
    }

    public Passkey withVerifiedAtClient(JsonNullable<String> verifiedAtClient) {
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
        Passkey other = (Passkey) o;
        return 
            Utils.enhancedDeepEquals(this.status, other.status) &&
            Utils.enhancedDeepEquals(this.strategy, other.strategy) &&
            Utils.enhancedDeepEquals(this.nonce, other.nonce) &&
            Utils.enhancedDeepEquals(this.message, other.message) &&
            Utils.enhancedDeepEquals(this.attempts, other.attempts) &&
            Utils.enhancedDeepEquals(this.expireAt, other.expireAt) &&
            Utils.enhancedDeepEquals(this.verifiedAtClient, other.verifiedAtClient);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            status, strategy, nonce,
            message, attempts, expireAt,
            verifiedAtClient);
    }
    
    @Override
    public String toString() {
        return Utils.toString(Passkey.class,
                "status", status,
                "strategy", strategy,
                "nonce", nonce,
                "message", message,
                "attempts", attempts,
                "expireAt", expireAt,
                "verifiedAtClient", verifiedAtClient);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private PasskeyVerificationStatus status;

        private PasskeyVerificationStrategy strategy;

        private Optional<? extends Nonce> nonce = Optional.empty();

        private JsonNullable<String> message = JsonNullable.undefined();

        private Optional<Long> attempts = Optional.empty();

        private Optional<Long> expireAt = Optional.empty();

        private JsonNullable<String> verifiedAtClient = JsonNullable.undefined();

        private Builder() {
          // force use of static builder() method
        }


        public Builder status(PasskeyVerificationStatus status) {
            Utils.checkNotNull(status, "status");
            this.status = status;
            return this;
        }


        public Builder strategy(PasskeyVerificationStrategy strategy) {
            Utils.checkNotNull(strategy, "strategy");
            this.strategy = strategy;
            return this;
        }


        public Builder nonce(Nonce nonce) {
            Utils.checkNotNull(nonce, "nonce");
            this.nonce = Optional.ofNullable(nonce);
            return this;
        }

        public Builder nonce(Optional<? extends Nonce> nonce) {
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

        public Passkey build() {

            return new Passkey(
                status, strategy, nonce,
                message, attempts, expireAt,
                verifiedAtClient);
        }

    }
}
