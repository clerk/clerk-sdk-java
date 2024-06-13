/* 
 * Code generated by Speakeasy (https://speakeasyapi.dev). DO NOT EDIT.
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

public class CNameTarget {

    @JsonProperty("host")
    private String host;

    @JsonProperty("value")
    private String value;

    /**
     * Denotes whether this CNAME target is required to be set in order for the domain to be considered deployed.
     * 
     */
    @JsonProperty("required")
    private boolean required;

    @JsonCreator
    public CNameTarget(
            @JsonProperty("host") String host,
            @JsonProperty("value") String value,
            @JsonProperty("required") boolean required) {
        Utils.checkNotNull(host, "host");
        Utils.checkNotNull(value, "value");
        Utils.checkNotNull(required, "required");
        this.host = host;
        this.value = value;
        this.required = required;
    }

    @JsonIgnore
    public String host() {
        return host;
    }

    @JsonIgnore
    public String value() {
        return value;
    }

    /**
     * Denotes whether this CNAME target is required to be set in order for the domain to be considered deployed.
     * 
     */
    @JsonIgnore
    public boolean required() {
        return required;
    }

    public final static Builder builder() {
        return new Builder();
    }

    public CNameTarget withHost(String host) {
        Utils.checkNotNull(host, "host");
        this.host = host;
        return this;
    }

    public CNameTarget withValue(String value) {
        Utils.checkNotNull(value, "value");
        this.value = value;
        return this;
    }

    /**
     * Denotes whether this CNAME target is required to be set in order for the domain to be considered deployed.
     * 
     */
    public CNameTarget withRequired(boolean required) {
        Utils.checkNotNull(required, "required");
        this.required = required;
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
        CNameTarget other = (CNameTarget) o;
        return 
            java.util.Objects.deepEquals(this.host, other.host) &&
            java.util.Objects.deepEquals(this.value, other.value) &&
            java.util.Objects.deepEquals(this.required, other.required);
    }
    
    @Override
    public int hashCode() {
        return java.util.Objects.hash(
            host,
            value,
            required);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CNameTarget.class,
                "host", host,
                "value", value,
                "required", required);
    }
    
    public final static class Builder {
 
        private String host;
 
        private String value;
 
        private Boolean required;  
        
        private Builder() {
          // force use of static builder() method
        }

        public Builder host(String host) {
            Utils.checkNotNull(host, "host");
            this.host = host;
            return this;
        }

        public Builder value(String value) {
            Utils.checkNotNull(value, "value");
            this.value = value;
            return this;
        }

        /**
         * Denotes whether this CNAME target is required to be set in order for the domain to be considered deployed.
         * 
         */
        public Builder required(boolean required) {
            Utils.checkNotNull(required, "required");
            this.required = required;
            return this;
        }
        
        public CNameTarget build() {
            return new CNameTarget(
                host,
                value,
                required);
        }
    }
}
