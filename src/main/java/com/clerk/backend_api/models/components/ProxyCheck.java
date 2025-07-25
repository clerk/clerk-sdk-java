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
import java.lang.Boolean;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.Optional;

/**
 * ProxyCheck
 * 
 * <p>Health check information about a domain's proxy configuration validation attempt.
 */
public class ProxyCheck {

    @JsonProperty("object")
    private ProxyCheckObject object;


    @JsonProperty("id")
    private String id;


    @JsonProperty("domain_id")
    private String domainId;

    /**
     * Unix timestamp of last run.
     */
    @JsonInclude(Include.ALWAYS)
    @JsonProperty("last_run_at")
    private Optional<Long> lastRunAt;


    @JsonProperty("proxy_url")
    private String proxyUrl;


    @JsonProperty("successful")
    private boolean successful;

    /**
     * Unix timestamp of creation.
     */
    @JsonProperty("created_at")
    private long createdAt;

    /**
     * Unix timestamp of last update.
     */
    @JsonProperty("updated_at")
    private long updatedAt;

    @JsonCreator
    public ProxyCheck(
            @JsonProperty("object") ProxyCheckObject object,
            @JsonProperty("id") String id,
            @JsonProperty("domain_id") String domainId,
            @JsonProperty("last_run_at") Optional<Long> lastRunAt,
            @JsonProperty("proxy_url") String proxyUrl,
            @JsonProperty("successful") boolean successful,
            @JsonProperty("created_at") long createdAt,
            @JsonProperty("updated_at") long updatedAt) {
        Utils.checkNotNull(object, "object");
        Utils.checkNotNull(id, "id");
        Utils.checkNotNull(domainId, "domainId");
        Utils.checkNotNull(lastRunAt, "lastRunAt");
        Utils.checkNotNull(proxyUrl, "proxyUrl");
        Utils.checkNotNull(successful, "successful");
        Utils.checkNotNull(createdAt, "createdAt");
        Utils.checkNotNull(updatedAt, "updatedAt");
        this.object = object;
        this.id = id;
        this.domainId = domainId;
        this.lastRunAt = lastRunAt;
        this.proxyUrl = proxyUrl;
        this.successful = successful;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    public ProxyCheck(
            ProxyCheckObject object,
            String id,
            String domainId,
            String proxyUrl,
            boolean successful,
            long createdAt,
            long updatedAt) {
        this(object, id, domainId,
            Optional.empty(), proxyUrl, successful,
            createdAt, updatedAt);
    }

    @JsonIgnore
    public ProxyCheckObject object() {
        return object;
    }

    @JsonIgnore
    public String id() {
        return id;
    }

    @JsonIgnore
    public String domainId() {
        return domainId;
    }

    /**
     * Unix timestamp of last run.
     */
    @JsonIgnore
    public Optional<Long> lastRunAt() {
        return lastRunAt;
    }

    @JsonIgnore
    public String proxyUrl() {
        return proxyUrl;
    }

    @JsonIgnore
    public boolean successful() {
        return successful;
    }

    /**
     * Unix timestamp of creation.
     */
    @JsonIgnore
    public long createdAt() {
        return createdAt;
    }

    /**
     * Unix timestamp of last update.
     */
    @JsonIgnore
    public long updatedAt() {
        return updatedAt;
    }

    public static Builder builder() {
        return new Builder();
    }


    public ProxyCheck withObject(ProxyCheckObject object) {
        Utils.checkNotNull(object, "object");
        this.object = object;
        return this;
    }

    public ProxyCheck withId(String id) {
        Utils.checkNotNull(id, "id");
        this.id = id;
        return this;
    }

    public ProxyCheck withDomainId(String domainId) {
        Utils.checkNotNull(domainId, "domainId");
        this.domainId = domainId;
        return this;
    }

    /**
     * Unix timestamp of last run.
     */
    public ProxyCheck withLastRunAt(long lastRunAt) {
        Utils.checkNotNull(lastRunAt, "lastRunAt");
        this.lastRunAt = Optional.ofNullable(lastRunAt);
        return this;
    }


    /**
     * Unix timestamp of last run.
     */
    public ProxyCheck withLastRunAt(Optional<Long> lastRunAt) {
        Utils.checkNotNull(lastRunAt, "lastRunAt");
        this.lastRunAt = lastRunAt;
        return this;
    }

    public ProxyCheck withProxyUrl(String proxyUrl) {
        Utils.checkNotNull(proxyUrl, "proxyUrl");
        this.proxyUrl = proxyUrl;
        return this;
    }

    public ProxyCheck withSuccessful(boolean successful) {
        Utils.checkNotNull(successful, "successful");
        this.successful = successful;
        return this;
    }

    /**
     * Unix timestamp of creation.
     */
    public ProxyCheck withCreatedAt(long createdAt) {
        Utils.checkNotNull(createdAt, "createdAt");
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Unix timestamp of last update.
     */
    public ProxyCheck withUpdatedAt(long updatedAt) {
        Utils.checkNotNull(updatedAt, "updatedAt");
        this.updatedAt = updatedAt;
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
        ProxyCheck other = (ProxyCheck) o;
        return 
            Utils.enhancedDeepEquals(this.object, other.object) &&
            Utils.enhancedDeepEquals(this.id, other.id) &&
            Utils.enhancedDeepEquals(this.domainId, other.domainId) &&
            Utils.enhancedDeepEquals(this.lastRunAt, other.lastRunAt) &&
            Utils.enhancedDeepEquals(this.proxyUrl, other.proxyUrl) &&
            Utils.enhancedDeepEquals(this.successful, other.successful) &&
            Utils.enhancedDeepEquals(this.createdAt, other.createdAt) &&
            Utils.enhancedDeepEquals(this.updatedAt, other.updatedAt);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            object, id, domainId,
            lastRunAt, proxyUrl, successful,
            createdAt, updatedAt);
    }
    
    @Override
    public String toString() {
        return Utils.toString(ProxyCheck.class,
                "object", object,
                "id", id,
                "domainId", domainId,
                "lastRunAt", lastRunAt,
                "proxyUrl", proxyUrl,
                "successful", successful,
                "createdAt", createdAt,
                "updatedAt", updatedAt);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private ProxyCheckObject object;

        private String id;

        private String domainId;

        private Optional<Long> lastRunAt = Optional.empty();

        private String proxyUrl;

        private Boolean successful;

        private Long createdAt;

        private Long updatedAt;

        private Builder() {
          // force use of static builder() method
        }


        public Builder object(ProxyCheckObject object) {
            Utils.checkNotNull(object, "object");
            this.object = object;
            return this;
        }


        public Builder id(String id) {
            Utils.checkNotNull(id, "id");
            this.id = id;
            return this;
        }


        public Builder domainId(String domainId) {
            Utils.checkNotNull(domainId, "domainId");
            this.domainId = domainId;
            return this;
        }


        /**
         * Unix timestamp of last run.
         */
        public Builder lastRunAt(long lastRunAt) {
            Utils.checkNotNull(lastRunAt, "lastRunAt");
            this.lastRunAt = Optional.ofNullable(lastRunAt);
            return this;
        }

        /**
         * Unix timestamp of last run.
         */
        public Builder lastRunAt(Optional<Long> lastRunAt) {
            Utils.checkNotNull(lastRunAt, "lastRunAt");
            this.lastRunAt = lastRunAt;
            return this;
        }


        public Builder proxyUrl(String proxyUrl) {
            Utils.checkNotNull(proxyUrl, "proxyUrl");
            this.proxyUrl = proxyUrl;
            return this;
        }


        public Builder successful(boolean successful) {
            Utils.checkNotNull(successful, "successful");
            this.successful = successful;
            return this;
        }


        /**
         * Unix timestamp of creation.
         */
        public Builder createdAt(long createdAt) {
            Utils.checkNotNull(createdAt, "createdAt");
            this.createdAt = createdAt;
            return this;
        }


        /**
         * Unix timestamp of last update.
         */
        public Builder updatedAt(long updatedAt) {
            Utils.checkNotNull(updatedAt, "updatedAt");
            this.updatedAt = updatedAt;
            return this;
        }

        public ProxyCheck build() {

            return new ProxyCheck(
                object, id, domainId,
                lastRunAt, proxyUrl, successful,
                createdAt, updatedAt);
        }

    }
}
