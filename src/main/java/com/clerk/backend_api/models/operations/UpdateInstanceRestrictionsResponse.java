/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.models.components.InstanceRestrictions;
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


public class UpdateInstanceRestrictionsResponse implements Response {
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
    private Optional<? extends InstanceRestrictions> instanceRestrictions;

    @JsonCreator
    public UpdateInstanceRestrictionsResponse(
            String contentType,
            int statusCode,
            HttpResponse<InputStream> rawResponse,
            Optional<? extends InstanceRestrictions> instanceRestrictions) {
        Utils.checkNotNull(contentType, "contentType");
        Utils.checkNotNull(statusCode, "statusCode");
        Utils.checkNotNull(rawResponse, "rawResponse");
        Utils.checkNotNull(instanceRestrictions, "instanceRestrictions");
        this.contentType = contentType;
        this.statusCode = statusCode;
        this.rawResponse = rawResponse;
        this.instanceRestrictions = instanceRestrictions;
    }
    
    public UpdateInstanceRestrictionsResponse(
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
    public Optional<InstanceRestrictions> instanceRestrictions() {
        return (Optional<InstanceRestrictions>) instanceRestrictions;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * HTTP response content type for this operation
     */
    public UpdateInstanceRestrictionsResponse withContentType(String contentType) {
        Utils.checkNotNull(contentType, "contentType");
        this.contentType = contentType;
        return this;
    }

    /**
     * HTTP response status code for this operation
     */
    public UpdateInstanceRestrictionsResponse withStatusCode(int statusCode) {
        Utils.checkNotNull(statusCode, "statusCode");
        this.statusCode = statusCode;
        return this;
    }

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    public UpdateInstanceRestrictionsResponse withRawResponse(HttpResponse<InputStream> rawResponse) {
        Utils.checkNotNull(rawResponse, "rawResponse");
        this.rawResponse = rawResponse;
        return this;
    }

    /**
     * Success
     */
    public UpdateInstanceRestrictionsResponse withInstanceRestrictions(InstanceRestrictions instanceRestrictions) {
        Utils.checkNotNull(instanceRestrictions, "instanceRestrictions");
        this.instanceRestrictions = Optional.ofNullable(instanceRestrictions);
        return this;
    }


    /**
     * Success
     */
    public UpdateInstanceRestrictionsResponse withInstanceRestrictions(Optional<? extends InstanceRestrictions> instanceRestrictions) {
        Utils.checkNotNull(instanceRestrictions, "instanceRestrictions");
        this.instanceRestrictions = instanceRestrictions;
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
        UpdateInstanceRestrictionsResponse other = (UpdateInstanceRestrictionsResponse) o;
        return 
            Utils.enhancedDeepEquals(this.contentType, other.contentType) &&
            Utils.enhancedDeepEquals(this.statusCode, other.statusCode) &&
            Utils.enhancedDeepEquals(this.rawResponse, other.rawResponse) &&
            Utils.enhancedDeepEquals(this.instanceRestrictions, other.instanceRestrictions);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            contentType, statusCode, rawResponse,
            instanceRestrictions);
    }
    
    @Override
    public String toString() {
        return Utils.toString(UpdateInstanceRestrictionsResponse.class,
                "contentType", contentType,
                "statusCode", statusCode,
                "rawResponse", rawResponse,
                "instanceRestrictions", instanceRestrictions);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String contentType;

        private Integer statusCode;

        private HttpResponse<InputStream> rawResponse;

        private Optional<? extends InstanceRestrictions> instanceRestrictions = Optional.empty();

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
        public Builder instanceRestrictions(InstanceRestrictions instanceRestrictions) {
            Utils.checkNotNull(instanceRestrictions, "instanceRestrictions");
            this.instanceRestrictions = Optional.ofNullable(instanceRestrictions);
            return this;
        }

        /**
         * Success
         */
        public Builder instanceRestrictions(Optional<? extends InstanceRestrictions> instanceRestrictions) {
            Utils.checkNotNull(instanceRestrictions, "instanceRestrictions");
            this.instanceRestrictions = instanceRestrictions;
            return this;
        }

        public UpdateInstanceRestrictionsResponse build() {

            return new UpdateInstanceRestrictionsResponse(
                contentType, statusCode, rawResponse,
                instanceRestrictions);
        }

    }
}
