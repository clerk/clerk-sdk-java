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


public class Admin {

    @JsonProperty("status")
    private AdminVerificationStatus status;

    @JsonProperty("strategy")
    private VerificationStrategy strategy;

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
    public Admin(
            @JsonProperty("status") AdminVerificationStatus status,
            @JsonProperty("strategy") VerificationStrategy strategy,
            @JsonProperty("attempts") Optional<Long> attempts,
            @JsonProperty("expire_at") Optional<Long> expireAt,
            @JsonProperty("verified_at_client") JsonNullable<String> verifiedAtClient) {
        Utils.checkNotNull(status, "status");
        Utils.checkNotNull(strategy, "strategy");
        Utils.checkNotNull(attempts, "attempts");
        Utils.checkNotNull(expireAt, "expireAt");
        Utils.checkNotNull(verifiedAtClient, "verifiedAtClient");
        this.status = status;
        this.strategy = strategy;
        this.attempts = attempts;
        this.expireAt = expireAt;
        this.verifiedAtClient = verifiedAtClient;
    }
    
    public Admin(
            AdminVerificationStatus status,
            VerificationStrategy strategy) {
        this(status, strategy, Optional.empty(), Optional.empty(), JsonNullable.undefined());
    }

    @JsonIgnore
    public AdminVerificationStatus status() {
        return status;
    }

    @JsonIgnore
    public VerificationStrategy strategy() {
        return strategy;
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

    public Admin withStatus(AdminVerificationStatus status) {
        Utils.checkNotNull(status, "status");
        this.status = status;
        return this;
    }

    public Admin withStrategy(VerificationStrategy strategy) {
        Utils.checkNotNull(strategy, "strategy");
        this.strategy = strategy;
        return this;
    }

    public Admin withAttempts(long attempts) {
        Utils.checkNotNull(attempts, "attempts");
        this.attempts = Optional.ofNullable(attempts);
        return this;
    }

    public Admin withAttempts(Optional<Long> attempts) {
        Utils.checkNotNull(attempts, "attempts");
        this.attempts = attempts;
        return this;
    }

    public Admin withExpireAt(long expireAt) {
        Utils.checkNotNull(expireAt, "expireAt");
        this.expireAt = Optional.ofNullable(expireAt);
        return this;
    }

    public Admin withExpireAt(Optional<Long> expireAt) {
        Utils.checkNotNull(expireAt, "expireAt");
        this.expireAt = expireAt;
        return this;
    }

    public Admin withVerifiedAtClient(String verifiedAtClient) {
        Utils.checkNotNull(verifiedAtClient, "verifiedAtClient");
        this.verifiedAtClient = JsonNullable.of(verifiedAtClient);
        return this;
    }

    public Admin withVerifiedAtClient(JsonNullable<String> verifiedAtClient) {
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
        Admin other = (Admin) o;
        return 
            Objects.deepEquals(this.status, other.status) &&
            Objects.deepEquals(this.strategy, other.strategy) &&
            Objects.deepEquals(this.attempts, other.attempts) &&
            Objects.deepEquals(this.expireAt, other.expireAt) &&
            Objects.deepEquals(this.verifiedAtClient, other.verifiedAtClient);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            status,
            strategy,
            attempts,
            expireAt,
            verifiedAtClient);
    }
    
    @Override
    public String toString() {
        return Utils.toString(Admin.class,
                "status", status,
                "strategy", strategy,
                "attempts", attempts,
                "expireAt", expireAt,
                "verifiedAtClient", verifiedAtClient);
    }
    
    public final static class Builder {
 
        private AdminVerificationStatus status;
 
        private VerificationStrategy strategy;
 
        private Optional<Long> attempts = Optional.empty();
 
        private Optional<Long> expireAt = Optional.empty();
 
        private JsonNullable<String> verifiedAtClient = JsonNullable.undefined();  
        
        private Builder() {
          // force use of static builder() method
        }

        public Builder status(AdminVerificationStatus status) {
            Utils.checkNotNull(status, "status");
            this.status = status;
            return this;
        }

        public Builder strategy(VerificationStrategy strategy) {
            Utils.checkNotNull(strategy, "strategy");
            this.strategy = strategy;
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
        
        public Admin build() {
            return new Admin(
                status,
                strategy,
                attempts,
                expireAt,
                verifiedAtClient);
        }
    }
}

