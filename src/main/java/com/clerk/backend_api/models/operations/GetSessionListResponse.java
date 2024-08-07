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

public class GetSessionListResponse implements com.clerk.backend_api.utils.Response {

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
    private Optional<? extends java.util.List<com.clerk.backend_api.models.components.Session>> sessionList;

    @JsonCreator
    public GetSessionListResponse(
            String contentType,
            int statusCode,
            HttpResponse<InputStream> rawResponse,
            Optional<? extends java.util.List<com.clerk.backend_api.models.components.Session>> sessionList) {
        Utils.checkNotNull(contentType, "contentType");
        Utils.checkNotNull(statusCode, "statusCode");
        Utils.checkNotNull(rawResponse, "rawResponse");
        Utils.checkNotNull(sessionList, "sessionList");
        this.contentType = contentType;
        this.statusCode = statusCode;
        this.rawResponse = rawResponse;
        this.sessionList = sessionList;
    }
    
    public GetSessionListResponse(
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
     * Success
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<java.util.List<com.clerk.backend_api.models.components.Session>> sessionList() {
        return (Optional<java.util.List<com.clerk.backend_api.models.components.Session>>) sessionList;
    }

    public final static Builder builder() {
        return new Builder();
    }

    /**
     * HTTP response content type for this operation
     */
    public GetSessionListResponse withContentType(String contentType) {
        Utils.checkNotNull(contentType, "contentType");
        this.contentType = contentType;
        return this;
    }

    /**
     * HTTP response status code for this operation
     */
    public GetSessionListResponse withStatusCode(int statusCode) {
        Utils.checkNotNull(statusCode, "statusCode");
        this.statusCode = statusCode;
        return this;
    }

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    public GetSessionListResponse withRawResponse(HttpResponse<InputStream> rawResponse) {
        Utils.checkNotNull(rawResponse, "rawResponse");
        this.rawResponse = rawResponse;
        return this;
    }

    /**
     * Success
     */
    public GetSessionListResponse withSessionList(java.util.List<com.clerk.backend_api.models.components.Session> sessionList) {
        Utils.checkNotNull(sessionList, "sessionList");
        this.sessionList = Optional.ofNullable(sessionList);
        return this;
    }

    /**
     * Success
     */
    public GetSessionListResponse withSessionList(Optional<? extends java.util.List<com.clerk.backend_api.models.components.Session>> sessionList) {
        Utils.checkNotNull(sessionList, "sessionList");
        this.sessionList = sessionList;
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
        GetSessionListResponse other = (GetSessionListResponse) o;
        return 
            java.util.Objects.deepEquals(this.contentType, other.contentType) &&
            java.util.Objects.deepEquals(this.statusCode, other.statusCode) &&
            java.util.Objects.deepEquals(this.rawResponse, other.rawResponse) &&
            java.util.Objects.deepEquals(this.sessionList, other.sessionList);
    }
    
    @Override
    public int hashCode() {
        return java.util.Objects.hash(
            contentType,
            statusCode,
            rawResponse,
            sessionList);
    }
    
    @Override
    public String toString() {
        return Utils.toString(GetSessionListResponse.class,
                "contentType", contentType,
                "statusCode", statusCode,
                "rawResponse", rawResponse,
                "sessionList", sessionList);
    }
    
    public final static class Builder {
 
        private String contentType;
 
        private Integer statusCode;
 
        private HttpResponse<InputStream> rawResponse;
 
        private Optional<? extends java.util.List<com.clerk.backend_api.models.components.Session>> sessionList = Optional.empty();  
        
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
        public Builder sessionList(java.util.List<com.clerk.backend_api.models.components.Session> sessionList) {
            Utils.checkNotNull(sessionList, "sessionList");
            this.sessionList = Optional.ofNullable(sessionList);
            return this;
        }

        /**
         * Success
         */
        public Builder sessionList(Optional<? extends java.util.List<com.clerk.backend_api.models.components.Session>> sessionList) {
            Utils.checkNotNull(sessionList, "sessionList");
            this.sessionList = sessionList;
            return this;
        }
        
        public GetSessionListResponse build() {
            return new GetSessionListResponse(
                contentType,
                statusCode,
                rawResponse,
                sessionList);
        }
    }
}

