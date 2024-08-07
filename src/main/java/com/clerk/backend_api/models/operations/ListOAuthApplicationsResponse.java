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

public class ListOAuthApplicationsResponse implements com.clerk.backend_api.utils.Response {

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
     * A list of OAuth applications
     */
    private Optional<? extends com.clerk.backend_api.models.components.OAuthApplications> oAuthApplications;

    private Callable<Optional<ListOAuthApplicationsResponse>> next = () -> Optional.empty();

    @JsonCreator
    public ListOAuthApplicationsResponse(
            String contentType,
            int statusCode,
            HttpResponse<InputStream> rawResponse,
            Optional<? extends com.clerk.backend_api.models.components.OAuthApplications> oAuthApplications) {
        Utils.checkNotNull(contentType, "contentType");
        Utils.checkNotNull(statusCode, "statusCode");
        Utils.checkNotNull(rawResponse, "rawResponse");
        Utils.checkNotNull(oAuthApplications, "oAuthApplications");
        this.contentType = contentType;
        this.statusCode = statusCode;
        this.rawResponse = rawResponse;
        this.oAuthApplications = oAuthApplications;
    }
    
    public ListOAuthApplicationsResponse(
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
     * A list of OAuth applications
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<com.clerk.backend_api.models.components.OAuthApplications> oAuthApplications() {
        return (Optional<com.clerk.backend_api.models.components.OAuthApplications>) oAuthApplications;
    }

    public Optional<ListOAuthApplicationsResponse> next() throws Exception {
        return this.next.call();
    }
    
    // internal use only
    private ListOAuthApplicationsResponse withNext(Callable<Optional<ListOAuthApplicationsResponse>> next) {
        this.next = next;
        return this;
    }

    public final static Builder builder() {
        return new Builder();
    }

    /**
     * HTTP response content type for this operation
     */
    public ListOAuthApplicationsResponse withContentType(String contentType) {
        Utils.checkNotNull(contentType, "contentType");
        this.contentType = contentType;
        return this;
    }

    /**
     * HTTP response status code for this operation
     */
    public ListOAuthApplicationsResponse withStatusCode(int statusCode) {
        Utils.checkNotNull(statusCode, "statusCode");
        this.statusCode = statusCode;
        return this;
    }

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    public ListOAuthApplicationsResponse withRawResponse(HttpResponse<InputStream> rawResponse) {
        Utils.checkNotNull(rawResponse, "rawResponse");
        this.rawResponse = rawResponse;
        return this;
    }

    /**
     * A list of OAuth applications
     */
    public ListOAuthApplicationsResponse withOAuthApplications(com.clerk.backend_api.models.components.OAuthApplications oAuthApplications) {
        Utils.checkNotNull(oAuthApplications, "oAuthApplications");
        this.oAuthApplications = Optional.ofNullable(oAuthApplications);
        return this;
    }

    /**
     * A list of OAuth applications
     */
    public ListOAuthApplicationsResponse withOAuthApplications(Optional<? extends com.clerk.backend_api.models.components.OAuthApplications> oAuthApplications) {
        Utils.checkNotNull(oAuthApplications, "oAuthApplications");
        this.oAuthApplications = oAuthApplications;
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
        ListOAuthApplicationsResponse other = (ListOAuthApplicationsResponse) o;
        return 
            java.util.Objects.deepEquals(this.contentType, other.contentType) &&
            java.util.Objects.deepEquals(this.statusCode, other.statusCode) &&
            java.util.Objects.deepEquals(this.rawResponse, other.rawResponse) &&
            java.util.Objects.deepEquals(this.oAuthApplications, other.oAuthApplications);
    }
    
    @Override
    public int hashCode() {
        return java.util.Objects.hash(
            contentType,
            statusCode,
            rawResponse,
            oAuthApplications);
    }
    
    @Override
    public String toString() {
        return Utils.toString(ListOAuthApplicationsResponse.class,
                "contentType", contentType,
                "statusCode", statusCode,
                "rawResponse", rawResponse,
                "oAuthApplications", oAuthApplications);
    }
    
    public final static class Builder {
        private Callable<Optional<ListOAuthApplicationsResponse>> next;
 
        private String contentType;
 
        private Integer statusCode;
 
        private HttpResponse<InputStream> rawResponse;
 
        private Optional<? extends com.clerk.backend_api.models.components.OAuthApplications> oAuthApplications = Optional.empty();  
        
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
         * A list of OAuth applications
         */
        public Builder oAuthApplications(com.clerk.backend_api.models.components.OAuthApplications oAuthApplications) {
            Utils.checkNotNull(oAuthApplications, "oAuthApplications");
            this.oAuthApplications = Optional.ofNullable(oAuthApplications);
            return this;
        }

        /**
         * A list of OAuth applications
         */
        public Builder oAuthApplications(Optional<? extends com.clerk.backend_api.models.components.OAuthApplications> oAuthApplications) {
            Utils.checkNotNull(oAuthApplications, "oAuthApplications");
            this.oAuthApplications = oAuthApplications;
            return this;
        }

        /**
         * Internal API. Not for public use. Sets the provider of the next page.
         *
         * @deprecated not part of the public API, may be removed without notice
         */
        @Deprecated
        public Builder next(Callable<Optional<ListOAuthApplicationsResponse>> next) {
            Utils.checkNotNull(next, "next");
            this.next = next;
            return this;
        }
        
        public ListOAuthApplicationsResponse build() {
            return new ListOAuthApplicationsResponse(
                contentType,
                statusCode,
                rawResponse,
                oAuthApplications)
                .withNext(next);
        }
    }
}

