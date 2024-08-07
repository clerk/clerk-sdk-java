/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.components;

import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.InputStream;
import java.lang.Deprecated;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Otp {

    @JsonProperty("status")
    private VerificationStatus status;

    @JsonProperty("strategy")
    private Strategy strategy;

    @JsonProperty("attempts")
    private long attempts;

    @JsonProperty("expire_at")
    private long expireAt;

    @JsonCreator
    public Otp(
            @JsonProperty("status") VerificationStatus status,
            @JsonProperty("strategy") Strategy strategy,
            @JsonProperty("attempts") long attempts,
            @JsonProperty("expire_at") long expireAt) {
        Utils.checkNotNull(status, "status");
        Utils.checkNotNull(strategy, "strategy");
        Utils.checkNotNull(attempts, "attempts");
        Utils.checkNotNull(expireAt, "expireAt");
        this.status = status;
        this.strategy = strategy;
        this.attempts = attempts;
        this.expireAt = expireAt;
    }

    @JsonIgnore
    public VerificationStatus status() {
        return status;
    }

    @JsonIgnore
    public Strategy strategy() {
        return strategy;
    }

    @JsonIgnore
    public long attempts() {
        return attempts;
    }

    @JsonIgnore
    public long expireAt() {
        return expireAt;
    }

    public final static Builder builder() {
        return new Builder();
    }

    public Otp withStatus(VerificationStatus status) {
        Utils.checkNotNull(status, "status");
        this.status = status;
        return this;
    }

    public Otp withStrategy(Strategy strategy) {
        Utils.checkNotNull(strategy, "strategy");
        this.strategy = strategy;
        return this;
    }

    public Otp withAttempts(long attempts) {
        Utils.checkNotNull(attempts, "attempts");
        this.attempts = attempts;
        return this;
    }

    public Otp withExpireAt(long expireAt) {
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
        Otp other = (Otp) o;
        return 
            java.util.Objects.deepEquals(this.status, other.status) &&
            java.util.Objects.deepEquals(this.strategy, other.strategy) &&
            java.util.Objects.deepEquals(this.attempts, other.attempts) &&
            java.util.Objects.deepEquals(this.expireAt, other.expireAt);
    }
    
    @Override
    public int hashCode() {
        return java.util.Objects.hash(
            status,
            strategy,
            attempts,
            expireAt);
    }
    
    @Override
    public String toString() {
        return Utils.toString(Otp.class,
                "status", status,
                "strategy", strategy,
                "attempts", attempts,
                "expireAt", expireAt);
    }
    
    public final static class Builder {
 
        private VerificationStatus status;
 
        private Strategy strategy;
 
        private Long attempts;
 
        private Long expireAt;  
        
        private Builder() {
          // force use of static builder() method
        }

        public Builder status(VerificationStatus status) {
            Utils.checkNotNull(status, "status");
            this.status = status;
            return this;
        }

        public Builder strategy(Strategy strategy) {
            Utils.checkNotNull(strategy, "strategy");
            this.strategy = strategy;
            return this;
        }

        public Builder attempts(long attempts) {
            Utils.checkNotNull(attempts, "attempts");
            this.attempts = attempts;
            return this;
        }

        public Builder expireAt(long expireAt) {
            Utils.checkNotNull(expireAt, "expireAt");
            this.expireAt = expireAt;
            return this;
        }
        
        public Otp build() {
            return new Otp(
                status,
                strategy,
                attempts,
                expireAt);
        }
    }
}

