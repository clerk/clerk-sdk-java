/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.models.components.OrganizationMemberships;
import com.clerk.backend_api.utils.Response;
import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.InputStream;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.net.http.HttpResponse;
import java.util.Optional;


public class ListOrganizationMembershipsResponse implements Response {
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
    private Optional<? extends OrganizationMemberships> organizationMemberships;

    @JsonCreator
    public ListOrganizationMembershipsResponse(
            String contentType,
            int statusCode,
            HttpResponse<InputStream> rawResponse,
            Optional<? extends OrganizationMemberships> organizationMemberships) {
        Utils.checkNotNull(contentType, "contentType");
        Utils.checkNotNull(statusCode, "statusCode");
        Utils.checkNotNull(rawResponse, "rawResponse");
        Utils.checkNotNull(organizationMemberships, "organizationMemberships");
        this.contentType = contentType;
        this.statusCode = statusCode;
        this.rawResponse = rawResponse;
        this.organizationMemberships = organizationMemberships;
    }
    
    public ListOrganizationMembershipsResponse(
            String contentType,
            int statusCode,
            HttpResponse<InputStream> rawResponse) {
        this(contentType, statusCode, rawResponse,
            Optional.empty());
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
    public Optional<OrganizationMemberships> organizationMemberships() {
        return (Optional<OrganizationMemberships>) organizationMemberships;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * HTTP response content type for this operation
     */
    public ListOrganizationMembershipsResponse withContentType(String contentType) {
        Utils.checkNotNull(contentType, "contentType");
        this.contentType = contentType;
        return this;
    }

    /**
     * HTTP response status code for this operation
     */
    public ListOrganizationMembershipsResponse withStatusCode(int statusCode) {
        Utils.checkNotNull(statusCode, "statusCode");
        this.statusCode = statusCode;
        return this;
    }

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    public ListOrganizationMembershipsResponse withRawResponse(HttpResponse<InputStream> rawResponse) {
        Utils.checkNotNull(rawResponse, "rawResponse");
        this.rawResponse = rawResponse;
        return this;
    }

    /**
     * A list of organization memberships
     */
    public ListOrganizationMembershipsResponse withOrganizationMemberships(OrganizationMemberships organizationMemberships) {
        Utils.checkNotNull(organizationMemberships, "organizationMemberships");
        this.organizationMemberships = Optional.ofNullable(organizationMemberships);
        return this;
    }


    /**
     * A list of organization memberships
     */
    public ListOrganizationMembershipsResponse withOrganizationMemberships(Optional<? extends OrganizationMemberships> organizationMemberships) {
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
        ListOrganizationMembershipsResponse other = (ListOrganizationMembershipsResponse) o;
        return 
            Utils.enhancedDeepEquals(this.contentType, other.contentType) &&
            Utils.enhancedDeepEquals(this.statusCode, other.statusCode) &&
            Utils.enhancedDeepEquals(this.rawResponse, other.rawResponse) &&
            Utils.enhancedDeepEquals(this.organizationMemberships, other.organizationMemberships);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            contentType, statusCode, rawResponse,
            organizationMemberships);
    }
    
    @Override
    public String toString() {
        return Utils.toString(ListOrganizationMembershipsResponse.class,
                "contentType", contentType,
                "statusCode", statusCode,
                "rawResponse", rawResponse,
                "organizationMemberships", organizationMemberships);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String contentType;

        private Integer statusCode;

        private HttpResponse<InputStream> rawResponse;

        private Optional<? extends OrganizationMemberships> organizationMemberships = Optional.empty();

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
        public Builder organizationMemberships(OrganizationMemberships organizationMemberships) {
            Utils.checkNotNull(organizationMemberships, "organizationMemberships");
            this.organizationMemberships = Optional.ofNullable(organizationMemberships);
            return this;
        }

        /**
         * A list of organization memberships
         */
        public Builder organizationMemberships(Optional<? extends OrganizationMemberships> organizationMemberships) {
            Utils.checkNotNull(organizationMemberships, "organizationMemberships");
            this.organizationMemberships = organizationMemberships;
            return this;
        }

        public ListOrganizationMembershipsResponse build() {

            return new ListOrganizationMembershipsResponse(
                contentType, statusCode, rawResponse,
                organizationMemberships);
        }

    }
}
