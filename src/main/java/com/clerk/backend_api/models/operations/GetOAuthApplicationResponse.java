/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.models.components.OAuthApplication;
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


public class GetOAuthApplicationResponse implements Response {
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
     * An OAuth application
     */
    private Optional<? extends OAuthApplication> oAuthApplication;

    @JsonCreator
    public GetOAuthApplicationResponse(
            String contentType,
            int statusCode,
            HttpResponse<InputStream> rawResponse,
            Optional<? extends OAuthApplication> oAuthApplication) {
        Utils.checkNotNull(contentType, "contentType");
        Utils.checkNotNull(statusCode, "statusCode");
        Utils.checkNotNull(rawResponse, "rawResponse");
        Utils.checkNotNull(oAuthApplication, "oAuthApplication");
        this.contentType = contentType;
        this.statusCode = statusCode;
        this.rawResponse = rawResponse;
        this.oAuthApplication = oAuthApplication;
    }
    
    public GetOAuthApplicationResponse(
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
     * An OAuth application
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<OAuthApplication> oAuthApplication() {
        return (Optional<OAuthApplication>) oAuthApplication;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * HTTP response content type for this operation
     */
    public GetOAuthApplicationResponse withContentType(String contentType) {
        Utils.checkNotNull(contentType, "contentType");
        this.contentType = contentType;
        return this;
    }

    /**
     * HTTP response status code for this operation
     */
    public GetOAuthApplicationResponse withStatusCode(int statusCode) {
        Utils.checkNotNull(statusCode, "statusCode");
        this.statusCode = statusCode;
        return this;
    }

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    public GetOAuthApplicationResponse withRawResponse(HttpResponse<InputStream> rawResponse) {
        Utils.checkNotNull(rawResponse, "rawResponse");
        this.rawResponse = rawResponse;
        return this;
    }

    /**
     * An OAuth application
     */
    public GetOAuthApplicationResponse withOAuthApplication(OAuthApplication oAuthApplication) {
        Utils.checkNotNull(oAuthApplication, "oAuthApplication");
        this.oAuthApplication = Optional.ofNullable(oAuthApplication);
        return this;
    }


    /**
     * An OAuth application
     */
    public GetOAuthApplicationResponse withOAuthApplication(Optional<? extends OAuthApplication> oAuthApplication) {
        Utils.checkNotNull(oAuthApplication, "oAuthApplication");
        this.oAuthApplication = oAuthApplication;
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
        GetOAuthApplicationResponse other = (GetOAuthApplicationResponse) o;
        return 
            Utils.enhancedDeepEquals(this.contentType, other.contentType) &&
            Utils.enhancedDeepEquals(this.statusCode, other.statusCode) &&
            Utils.enhancedDeepEquals(this.rawResponse, other.rawResponse) &&
            Utils.enhancedDeepEquals(this.oAuthApplication, other.oAuthApplication);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            contentType, statusCode, rawResponse,
            oAuthApplication);
    }
    
    @Override
    public String toString() {
        return Utils.toString(GetOAuthApplicationResponse.class,
                "contentType", contentType,
                "statusCode", statusCode,
                "rawResponse", rawResponse,
                "oAuthApplication", oAuthApplication);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String contentType;

        private Integer statusCode;

        private HttpResponse<InputStream> rawResponse;

        private Optional<? extends OAuthApplication> oAuthApplication = Optional.empty();

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
         * An OAuth application
         */
        public Builder oAuthApplication(OAuthApplication oAuthApplication) {
            Utils.checkNotNull(oAuthApplication, "oAuthApplication");
            this.oAuthApplication = Optional.ofNullable(oAuthApplication);
            return this;
        }

        /**
         * An OAuth application
         */
        public Builder oAuthApplication(Optional<? extends OAuthApplication> oAuthApplication) {
            Utils.checkNotNull(oAuthApplication, "oAuthApplication");
            this.oAuthApplication = oAuthApplication;
            return this;
        }

        public GetOAuthApplicationResponse build() {

            return new GetOAuthApplicationResponse(
                contentType, statusCode, rawResponse,
                oAuthApplication);
        }

    }
}
