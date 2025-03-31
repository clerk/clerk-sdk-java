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
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import org.openapitools.jackson.nullable.JsonNullable;

public class AddDomainRequestBody {

    /**
     * The new domain name. Can contain the port for development instances.
     */
    @JsonProperty("name")
    private String name;

    /**
     * Marks the new domain as satellite. Only `true` is accepted at the moment.
     */
    @JsonProperty("is_satellite")
    private boolean isSatellite;

    /**
     * The full URL of the proxy which will forward requests to the Clerk Frontend API for this domain. Applicable only to production instances.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("proxy_url")
    private JsonNullable<String> proxyUrl;

    @JsonCreator
    public AddDomainRequestBody(
            @JsonProperty("name") String name,
            @JsonProperty("is_satellite") boolean isSatellite,
            @JsonProperty("proxy_url") JsonNullable<String> proxyUrl) {
        Utils.checkNotNull(name, "name");
        Utils.checkNotNull(isSatellite, "isSatellite");
        Utils.checkNotNull(proxyUrl, "proxyUrl");
        this.name = name;
        this.isSatellite = isSatellite;
        this.proxyUrl = proxyUrl;
    }
    
    public AddDomainRequestBody(
            String name,
            boolean isSatellite) {
        this(name, isSatellite, JsonNullable.undefined());
    }

    /**
     * The new domain name. Can contain the port for development instances.
     */
    @JsonIgnore
    public String name() {
        return name;
    }

    /**
     * Marks the new domain as satellite. Only `true` is accepted at the moment.
     */
    @JsonIgnore
    public boolean isSatellite() {
        return isSatellite;
    }

    /**
     * The full URL of the proxy which will forward requests to the Clerk Frontend API for this domain. Applicable only to production instances.
     */
    @JsonIgnore
    public JsonNullable<String> proxyUrl() {
        return proxyUrl;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * The new domain name. Can contain the port for development instances.
     */
    public AddDomainRequestBody withName(String name) {
        Utils.checkNotNull(name, "name");
        this.name = name;
        return this;
    }

    /**
     * Marks the new domain as satellite. Only `true` is accepted at the moment.
     */
    public AddDomainRequestBody withIsSatellite(boolean isSatellite) {
        Utils.checkNotNull(isSatellite, "isSatellite");
        this.isSatellite = isSatellite;
        return this;
    }

    /**
     * The full URL of the proxy which will forward requests to the Clerk Frontend API for this domain. Applicable only to production instances.
     */
    public AddDomainRequestBody withProxyUrl(String proxyUrl) {
        Utils.checkNotNull(proxyUrl, "proxyUrl");
        this.proxyUrl = JsonNullable.of(proxyUrl);
        return this;
    }

    /**
     * The full URL of the proxy which will forward requests to the Clerk Frontend API for this domain. Applicable only to production instances.
     */
    public AddDomainRequestBody withProxyUrl(JsonNullable<String> proxyUrl) {
        Utils.checkNotNull(proxyUrl, "proxyUrl");
        this.proxyUrl = proxyUrl;
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
        AddDomainRequestBody other = (AddDomainRequestBody) o;
        return 
            Objects.deepEquals(this.name, other.name) &&
            Objects.deepEquals(this.isSatellite, other.isSatellite) &&
            Objects.deepEquals(this.proxyUrl, other.proxyUrl);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            name,
            isSatellite,
            proxyUrl);
    }
    
    @Override
    public String toString() {
        return Utils.toString(AddDomainRequestBody.class,
                "name", name,
                "isSatellite", isSatellite,
                "proxyUrl", proxyUrl);
    }
    
    public final static class Builder {
 
        private String name;
 
        private Boolean isSatellite;
 
        private JsonNullable<String> proxyUrl = JsonNullable.undefined();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * The new domain name. Can contain the port for development instances.
         */
        public Builder name(String name) {
            Utils.checkNotNull(name, "name");
            this.name = name;
            return this;
        }

        /**
         * Marks the new domain as satellite. Only `true` is accepted at the moment.
         */
        public Builder isSatellite(boolean isSatellite) {
            Utils.checkNotNull(isSatellite, "isSatellite");
            this.isSatellite = isSatellite;
            return this;
        }

        /**
         * The full URL of the proxy which will forward requests to the Clerk Frontend API for this domain. Applicable only to production instances.
         */
        public Builder proxyUrl(String proxyUrl) {
            Utils.checkNotNull(proxyUrl, "proxyUrl");
            this.proxyUrl = JsonNullable.of(proxyUrl);
            return this;
        }

        /**
         * The full URL of the proxy which will forward requests to the Clerk Frontend API for this domain. Applicable only to production instances.
         */
        public Builder proxyUrl(JsonNullable<String> proxyUrl) {
            Utils.checkNotNull(proxyUrl, "proxyUrl");
            this.proxyUrl = proxyUrl;
            return this;
        }
        
        public AddDomainRequestBody build() {
            return new AddDomainRequestBody(
                name,
                isSatellite,
                proxyUrl);
        }
    }
}
