/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.models.components.OrganizationInvitation;
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


public class RevokeOrganizationInvitationResponse implements Response {
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
     * An organization invitation
     */
    private Optional<? extends OrganizationInvitation> organizationInvitation;

    @JsonCreator
    public RevokeOrganizationInvitationResponse(
            String contentType,
            int statusCode,
            HttpResponse<InputStream> rawResponse,
            Optional<? extends OrganizationInvitation> organizationInvitation) {
        Utils.checkNotNull(contentType, "contentType");
        Utils.checkNotNull(statusCode, "statusCode");
        Utils.checkNotNull(rawResponse, "rawResponse");
        Utils.checkNotNull(organizationInvitation, "organizationInvitation");
        this.contentType = contentType;
        this.statusCode = statusCode;
        this.rawResponse = rawResponse;
        this.organizationInvitation = organizationInvitation;
    }
    
    public RevokeOrganizationInvitationResponse(
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
     * An organization invitation
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<OrganizationInvitation> organizationInvitation() {
        return (Optional<OrganizationInvitation>) organizationInvitation;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * HTTP response content type for this operation
     */
    public RevokeOrganizationInvitationResponse withContentType(String contentType) {
        Utils.checkNotNull(contentType, "contentType");
        this.contentType = contentType;
        return this;
    }

    /**
     * HTTP response status code for this operation
     */
    public RevokeOrganizationInvitationResponse withStatusCode(int statusCode) {
        Utils.checkNotNull(statusCode, "statusCode");
        this.statusCode = statusCode;
        return this;
    }

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    public RevokeOrganizationInvitationResponse withRawResponse(HttpResponse<InputStream> rawResponse) {
        Utils.checkNotNull(rawResponse, "rawResponse");
        this.rawResponse = rawResponse;
        return this;
    }

    /**
     * An organization invitation
     */
    public RevokeOrganizationInvitationResponse withOrganizationInvitation(OrganizationInvitation organizationInvitation) {
        Utils.checkNotNull(organizationInvitation, "organizationInvitation");
        this.organizationInvitation = Optional.ofNullable(organizationInvitation);
        return this;
    }


    /**
     * An organization invitation
     */
    public RevokeOrganizationInvitationResponse withOrganizationInvitation(Optional<? extends OrganizationInvitation> organizationInvitation) {
        Utils.checkNotNull(organizationInvitation, "organizationInvitation");
        this.organizationInvitation = organizationInvitation;
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
        RevokeOrganizationInvitationResponse other = (RevokeOrganizationInvitationResponse) o;
        return 
            Utils.enhancedDeepEquals(this.contentType, other.contentType) &&
            Utils.enhancedDeepEquals(this.statusCode, other.statusCode) &&
            Utils.enhancedDeepEquals(this.rawResponse, other.rawResponse) &&
            Utils.enhancedDeepEquals(this.organizationInvitation, other.organizationInvitation);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            contentType, statusCode, rawResponse,
            organizationInvitation);
    }
    
    @Override
    public String toString() {
        return Utils.toString(RevokeOrganizationInvitationResponse.class,
                "contentType", contentType,
                "statusCode", statusCode,
                "rawResponse", rawResponse,
                "organizationInvitation", organizationInvitation);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String contentType;

        private Integer statusCode;

        private HttpResponse<InputStream> rawResponse;

        private Optional<? extends OrganizationInvitation> organizationInvitation = Optional.empty();

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
         * An organization invitation
         */
        public Builder organizationInvitation(OrganizationInvitation organizationInvitation) {
            Utils.checkNotNull(organizationInvitation, "organizationInvitation");
            this.organizationInvitation = Optional.ofNullable(organizationInvitation);
            return this;
        }

        /**
         * An organization invitation
         */
        public Builder organizationInvitation(Optional<? extends OrganizationInvitation> organizationInvitation) {
            Utils.checkNotNull(organizationInvitation, "organizationInvitation");
            this.organizationInvitation = organizationInvitation;
            return this;
        }

        public RevokeOrganizationInvitationResponse build() {

            return new RevokeOrganizationInvitationResponse(
                contentType, statusCode, rawResponse,
                organizationInvitation);
        }

    }
}
