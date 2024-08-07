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

public class VerificationOTP {

    @JsonProperty("status")
    private OTPVerificationStatus status;

    @JsonProperty("strategy")
    private OTPVerificationStrategy strategy;

    @JsonProperty("attempts")
    private long attempts;

    @JsonProperty("expire_at")
    private long expireAt;

    @JsonCreator
    public VerificationOTP(
            @JsonProperty("status") OTPVerificationStatus status,
            @JsonProperty("strategy") OTPVerificationStrategy strategy,
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
    public OTPVerificationStatus status() {
        return status;
    }

    @JsonIgnore
    public OTPVerificationStrategy strategy() {
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

    public VerificationOTP withStatus(OTPVerificationStatus status) {
        Utils.checkNotNull(status, "status");
        this.status = status;
        return this;
    }

    public VerificationOTP withStrategy(OTPVerificationStrategy strategy) {
        Utils.checkNotNull(strategy, "strategy");
        this.strategy = strategy;
        return this;
    }

    public VerificationOTP withAttempts(long attempts) {
        Utils.checkNotNull(attempts, "attempts");
        this.attempts = attempts;
        return this;
    }

    public VerificationOTP withExpireAt(long expireAt) {
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
        VerificationOTP other = (VerificationOTP) o;
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
        return Utils.toString(VerificationOTP.class,
                "status", status,
                "strategy", strategy,
                "attempts", attempts,
                "expireAt", expireAt);
    }
    
    public final static class Builder {
 
        private OTPVerificationStatus status;
 
        private OTPVerificationStrategy strategy;
 
        private Long attempts;
 
        private Long expireAt;  
        
        private Builder() {
          // force use of static builder() method
        }

        public Builder status(OTPVerificationStatus status) {
            Utils.checkNotNull(status, "status");
            this.status = status;
            return this;
        }

        public Builder strategy(OTPVerificationStrategy strategy) {
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
        
        public VerificationOTP build() {
            return new VerificationOTP(
                status,
                strategy,
                attempts,
                expireAt);
        }
    }
}

