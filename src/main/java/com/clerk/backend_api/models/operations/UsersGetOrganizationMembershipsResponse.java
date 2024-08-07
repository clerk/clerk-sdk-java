/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.InputStream;
import java.lang.Deprecated;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.http.HttpResponse;
import java.util.Optional;
import java.util.concurrent.Callable;

public class UsersGetOrganizationMembershipsResponse implements com.clerk.backend_api.utils.Response {

    /**
     * HTTP response content type for this operation
     */
    private String contentType;

    /**
     * HTTP response status code for this operation
     */
    private int statusCode;

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    private HttpResponse<InputStream> rawResponse;

    /**
     * A list of organization memberships
     */
    private Optional<? extends com.clerk.backend_api.models.components.OrganizationMemberships> organizationMemberships;

    private Callable<Optional<UsersGetOrganizationMembershipsResponse>> next = () -> Optional.empty();

    @JsonCreator
    public UsersGetOrganizationMembershipsResponse(
            String contentType,
            int statusCode,
            HttpResponse<InputStream> rawResponse,
            Optional<? extends com.clerk.backend_api.models.components.OrganizationMemberships> organizationMemberships) {
        Utils.checkNotNull(contentType, "contentType");
        Utils.checkNotNull(statusCode, "statusCode");
        Utils.checkNotNull(rawResponse, "rawResponse");
        Utils.checkNotNull(organizationMemberships, "organizationMemberships");
        this.contentType = contentType;
        this.statusCode = statusCode;
        this.rawResponse = rawResponse;
        this.organizationMemberships = organizationMemberships;
    }
    
    public UsersGetOrganizationMembershipsResponse(
            String contentType,
            int statusCode,
            HttpResponse<InputStream> rawResponse) {
        this(contentType, statusCode, rawResponse, Optional.empty());
    }

    /**
     * HTTP response content type for this operation
     */
    @JsonIgnore
    public String contentType() {
        return contentType;
    }

    /**
     * HTTP response status code for this operation
     */
    @JsonIgnore
    public int statusCode() {
        return statusCode;
    }

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    @JsonIgnore
    public HttpResponse<InputStream> rawResponse() {
        return rawResponse;
    }

    /**
     * A list of organization memberships
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<com.clerk.backend_api.models.components.OrganizationMemberships> organizationMemberships() {
        return (Optional<com.clerk.backend_api.models.components.OrganizationMemberships>) organizationMemberships;
    }

    public Optional<UsersGetOrganizationMembershipsResponse> next() throws Exception {
        return this.next.call();
    }
    
    // internal use only
    private UsersGetOrganizationMembershipsResponse withNext(Callable<Optional<UsersGetOrganizationMembershipsResponse>> next) {
        this.next = next;
        return this;
    }

    public final static Builder builder() {
        return new Builder();
    }

    /**
     * HTTP response content type for this operation
     */
    public UsersGetOrganizationMembershipsResponse withContentType(String contentType) {
        Utils.checkNotNull(contentType, "contentType");
        this.contentType = contentType;
        return this;
    }

    /**
     * HTTP response status code for this operation
     */
    public UsersGetOrganizationMembershipsResponse withStatusCode(int statusCode) {
        Utils.checkNotNull(statusCode, "statusCode");
        this.statusCode = statusCode;
        return this;
    }

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    public UsersGetOrganizationMembershipsResponse withRawResponse(HttpResponse<InputStream> rawResponse) {
        Utils.checkNotNull(rawResponse, "rawResponse");
        this.rawResponse = rawResponse;
        return this;
    }

    /**
     * A list of organization memberships
     */
    public UsersGetOrganizationMembershipsResponse withOrganizationMemberships(com.clerk.backend_api.models.components.OrganizationMemberships organizationMemberships) {
        Utils.checkNotNull(organizationMemberships, "organizationMemberships");
        this.organizationMemberships = Optional.ofNullable(organizationMemberships);
        return this;
    }

    /**
     * A list of organization memberships
     */
    public UsersGetOrganizationMembershipsResponse withOrganizationMemberships(Optional<? extends com.clerk.backend_api.models.components.OrganizationMemberships> organizationMemberships) {
        Utils.checkNotNull(organizationMemberships, "organizationMemberships");
        this.organizationMemberships = organizationMemberships;
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
        UsersGetOrganizationMembershipsResponse other = (UsersGetOrganizationMembershipsResponse) o;
        return 
            java.util.Objects.deepEquals(this.contentType, other.contentType) &&
            java.util.Objects.deepEquals(this.statusCode, other.statusCode) &&
            java.util.Objects.deepEquals(this.rawResponse, other.rawResponse) &&
            java.util.Objects.deepEquals(this.organizationMemberships, other.organizationMemberships);
    }
    
    @Override
    public int hashCode() {
        return java.util.Objects.hash(
            contentType,
            statusCode,
            rawResponse,
            organizationMemberships);
    }
    
    @Override
    public String toString() {
        return Utils.toString(UsersGetOrganizationMembershipsResponse.class,
                "contentType", contentType,
                "statusCode", statusCode,
                "rawResponse", rawResponse,
                "organizationMemberships", organizationMemberships);
    }
    
    public final static class Builder {
        private Callable<Optional<UsersGetOrganizationMembershipsResponse>> next;
 
        private String contentType;
 
        private Integer statusCode;
 
        private HttpResponse<InputStream> rawResponse;
 
        private Optional<? extends com.clerk.backend_api.models.components.OrganizationMemberships> organizationMemberships = Optional.empty();  
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * HTTP response content type for this operation
         */
        public Builder contentType(String contentType) {
            Utils.checkNotNull(contentType, "contentType");
            this.contentType = contentType;
            return this;
        }

        /**
         * HTTP response status code for this operation
         */
        public Builder statusCode(int statusCode) {
            Utils.checkNotNull(statusCode, "statusCode");
            this.statusCode = statusCode;
            return this;
        }

        /**
         * Raw HTTP response; suitable for custom response parsing
         */
        public Builder rawResponse(HttpResponse<InputStream> rawResponse) {
            Utils.checkNotNull(rawResponse, "rawResponse");
            this.rawResponse = rawResponse;
            return this;
        }

        /**
         * A list of organization memberships
         */
        public Builder organizationMemberships(com.clerk.backend_api.models.components.OrganizationMemberships organizationMemberships) {
            Utils.checkNotNull(organizationMemberships, "organizationMemberships");
            this.organizationMemberships = Optional.ofNullable(organizationMemberships);
            return this;
        }

        /**
         * A list of organization memberships
         */
        public Builder organizationMemberships(Optional<? extends com.clerk.backend_api.models.components.OrganizationMemberships> organizationMemberships) {
            Utils.checkNotNull(organizationMemberships, "organizationMemberships");
            this.organizationMemberships = organizationMemberships;
            return this;
        }

        /**
         * Internal API. Not for public use. Sets the provider of the next page.
         *
         * @deprecated not part of the public API, may be removed without notice
         */
        @Deprecated
        public Builder next(Callable<Optional<UsersGetOrganizationMembershipsResponse>> next) {
            Utils.checkNotNull(next, "next");
            this.next = next;
            return this;
        }
        
        public UsersGetOrganizationMembershipsResponse build() {
            return new UsersGetOrganizationMembershipsResponse(
                contentType,
                statusCode,
                rawResponse,
                organizationMemberships)
                .withNext(next);
        }
    }
}

