/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.models.components.Organizations;
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


public class ListOrganizationsResponse implements Response {
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
     * A list of organizations
     */
    private Optional<? extends Organizations> organizations;

    @JsonCreator
    public ListOrganizationsResponse(
            String contentType,
            int statusCode,
            HttpResponse<InputStream> rawResponse,
            Optional<? extends Organizations> organizations) {
        Utils.checkNotNull(contentType, "contentType");
        Utils.checkNotNull(statusCode, "statusCode");
        Utils.checkNotNull(rawResponse, "rawResponse");
        Utils.checkNotNull(organizations, "organizations");
        this.contentType = contentType;
        this.statusCode = statusCode;
        this.rawResponse = rawResponse;
        this.organizations = organizations;
    }
    
    public ListOrganizationsResponse(
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
     * A list of organizations
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<Organizations> organizations() {
        return (Optional<Organizations>) organizations;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * HTTP response content type for this operation
     */
    public ListOrganizationsResponse withContentType(String contentType) {
        Utils.checkNotNull(contentType, "contentType");
        this.contentType = contentType;
        return this;
    }

    /**
     * HTTP response status code for this operation
     */
    public ListOrganizationsResponse withStatusCode(int statusCode) {
        Utils.checkNotNull(statusCode, "statusCode");
        this.statusCode = statusCode;
        return this;
    }

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    public ListOrganizationsResponse withRawResponse(HttpResponse<InputStream> rawResponse) {
        Utils.checkNotNull(rawResponse, "rawResponse");
        this.rawResponse = rawResponse;
        return this;
    }

    /**
     * A list of organizations
     */
    public ListOrganizationsResponse withOrganizations(Organizations organizations) {
        Utils.checkNotNull(organizations, "organizations");
        this.organizations = Optional.ofNullable(organizations);
        return this;
    }


    /**
     * A list of organizations
     */
    public ListOrganizationsResponse withOrganizations(Optional<? extends Organizations> organizations) {
        Utils.checkNotNull(organizations, "organizations");
        this.organizations = organizations;
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
        ListOrganizationsResponse other = (ListOrganizationsResponse) o;
        return 
            Utils.enhancedDeepEquals(this.contentType, other.contentType) &&
            Utils.enhancedDeepEquals(this.statusCode, other.statusCode) &&
            Utils.enhancedDeepEquals(this.rawResponse, other.rawResponse) &&
            Utils.enhancedDeepEquals(this.organizations, other.organizations);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            contentType, statusCode, rawResponse,
            organizations);
    }
    
    @Override
    public String toString() {
        return Utils.toString(ListOrganizationsResponse.class,
                "contentType", contentType,
                "statusCode", statusCode,
                "rawResponse", rawResponse,
                "organizations", organizations);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String contentType;

        private Integer statusCode;

        private HttpResponse<InputStream> rawResponse;

        private Optional<? extends Organizations> organizations = Optional.empty();

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
         * A list of organizations
         */
        public Builder organizations(Organizations organizations) {
            Utils.checkNotNull(organizations, "organizations");
            this.organizations = Optional.ofNullable(organizations);
            return this;
        }

        /**
         * A list of organizations
         */
        public Builder organizations(Optional<? extends Organizations> organizations) {
            Utils.checkNotNull(organizations, "organizations");
            this.organizations = organizations;
            return this;
        }

        public ListOrganizationsResponse build() {

            return new ListOrganizationsResponse(
                contentType, statusCode, rawResponse,
                organizations);
        }

    }
}
