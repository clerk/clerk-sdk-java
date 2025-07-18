/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.models.components.EmailAddress;
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


public class CreateEmailAddressResponse implements Response {
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
     * Success
     */
    private Optional<? extends EmailAddress> emailAddress;

    @JsonCreator
    public CreateEmailAddressResponse(
            String contentType,
            int statusCode,
            HttpResponse<InputStream> rawResponse,
            Optional<? extends EmailAddress> emailAddress) {
        Utils.checkNotNull(contentType, "contentType");
        Utils.checkNotNull(statusCode, "statusCode");
        Utils.checkNotNull(rawResponse, "rawResponse");
        Utils.checkNotNull(emailAddress, "emailAddress");
        this.contentType = contentType;
        this.statusCode = statusCode;
        this.rawResponse = rawResponse;
        this.emailAddress = emailAddress;
    }
    
    public CreateEmailAddressResponse(
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
     * Success
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<EmailAddress> emailAddress() {
        return (Optional<EmailAddress>) emailAddress;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * HTTP response content type for this operation
     */
    public CreateEmailAddressResponse withContentType(String contentType) {
        Utils.checkNotNull(contentType, "contentType");
        this.contentType = contentType;
        return this;
    }

    /**
     * HTTP response status code for this operation
     */
    public CreateEmailAddressResponse withStatusCode(int statusCode) {
        Utils.checkNotNull(statusCode, "statusCode");
        this.statusCode = statusCode;
        return this;
    }

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    public CreateEmailAddressResponse withRawResponse(HttpResponse<InputStream> rawResponse) {
        Utils.checkNotNull(rawResponse, "rawResponse");
        this.rawResponse = rawResponse;
        return this;
    }

    /**
     * Success
     */
    public CreateEmailAddressResponse withEmailAddress(EmailAddress emailAddress) {
        Utils.checkNotNull(emailAddress, "emailAddress");
        this.emailAddress = Optional.ofNullable(emailAddress);
        return this;
    }


    /**
     * Success
     */
    public CreateEmailAddressResponse withEmailAddress(Optional<? extends EmailAddress> emailAddress) {
        Utils.checkNotNull(emailAddress, "emailAddress");
        this.emailAddress = emailAddress;
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
        CreateEmailAddressResponse other = (CreateEmailAddressResponse) o;
        return 
            Utils.enhancedDeepEquals(this.contentType, other.contentType) &&
            Utils.enhancedDeepEquals(this.statusCode, other.statusCode) &&
            Utils.enhancedDeepEquals(this.rawResponse, other.rawResponse) &&
            Utils.enhancedDeepEquals(this.emailAddress, other.emailAddress);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            contentType, statusCode, rawResponse,
            emailAddress);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CreateEmailAddressResponse.class,
                "contentType", contentType,
                "statusCode", statusCode,
                "rawResponse", rawResponse,
                "emailAddress", emailAddress);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String contentType;

        private Integer statusCode;

        private HttpResponse<InputStream> rawResponse;

        private Optional<? extends EmailAddress> emailAddress = Optional.empty();

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
         * Success
         */
        public Builder emailAddress(EmailAddress emailAddress) {
            Utils.checkNotNull(emailAddress, "emailAddress");
            this.emailAddress = Optional.ofNullable(emailAddress);
            return this;
        }

        /**
         * Success
         */
        public Builder emailAddress(Optional<? extends EmailAddress> emailAddress) {
            Utils.checkNotNull(emailAddress, "emailAddress");
            this.emailAddress = emailAddress;
            return this;
        }

        public CreateEmailAddressResponse build() {

            return new CreateEmailAddressResponse(
                contentType, statusCode, rawResponse,
                emailAddress);
        }

    }
}
