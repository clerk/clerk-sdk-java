/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.models.components.DeletedObject;
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
import java.util.Objects;
import java.util.Optional;

public class UserWeb3WalletDeleteResponse implements Response {

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
     * Deleted Object
     */
    private Optional<? extends DeletedObject> deletedObject;

    @JsonCreator
    public UserWeb3WalletDeleteResponse(
            String contentType,
            int statusCode,
            HttpResponse<InputStream> rawResponse,
            Optional<? extends DeletedObject> deletedObject) {
        Utils.checkNotNull(contentType, "contentType");
        Utils.checkNotNull(statusCode, "statusCode");
        Utils.checkNotNull(rawResponse, "rawResponse");
        Utils.checkNotNull(deletedObject, "deletedObject");
        this.contentType = contentType;
        this.statusCode = statusCode;
        this.rawResponse = rawResponse;
        this.deletedObject = deletedObject;
    }
    
    public UserWeb3WalletDeleteResponse(
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
     * Deleted Object
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<DeletedObject> deletedObject() {
        return (Optional<DeletedObject>) deletedObject;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * HTTP response content type for this operation
     */
    public UserWeb3WalletDeleteResponse withContentType(String contentType) {
        Utils.checkNotNull(contentType, "contentType");
        this.contentType = contentType;
        return this;
    }

    /**
     * HTTP response status code for this operation
     */
    public UserWeb3WalletDeleteResponse withStatusCode(int statusCode) {
        Utils.checkNotNull(statusCode, "statusCode");
        this.statusCode = statusCode;
        return this;
    }

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    public UserWeb3WalletDeleteResponse withRawResponse(HttpResponse<InputStream> rawResponse) {
        Utils.checkNotNull(rawResponse, "rawResponse");
        this.rawResponse = rawResponse;
        return this;
    }

    /**
     * Deleted Object
     */
    public UserWeb3WalletDeleteResponse withDeletedObject(DeletedObject deletedObject) {
        Utils.checkNotNull(deletedObject, "deletedObject");
        this.deletedObject = Optional.ofNullable(deletedObject);
        return this;
    }

    /**
     * Deleted Object
     */
    public UserWeb3WalletDeleteResponse withDeletedObject(Optional<? extends DeletedObject> deletedObject) {
        Utils.checkNotNull(deletedObject, "deletedObject");
        this.deletedObject = deletedObject;
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
        UserWeb3WalletDeleteResponse other = (UserWeb3WalletDeleteResponse) o;
        return 
            Objects.deepEquals(this.contentType, other.contentType) &&
            Objects.deepEquals(this.statusCode, other.statusCode) &&
            Objects.deepEquals(this.rawResponse, other.rawResponse) &&
            Objects.deepEquals(this.deletedObject, other.deletedObject);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            contentType,
            statusCode,
            rawResponse,
            deletedObject);
    }
    
    @Override
    public String toString() {
        return Utils.toString(UserWeb3WalletDeleteResponse.class,
                "contentType", contentType,
                "statusCode", statusCode,
                "rawResponse", rawResponse,
                "deletedObject", deletedObject);
    }
    
    public final static class Builder {
 
        private String contentType;
 
        private Integer statusCode;
 
        private HttpResponse<InputStream> rawResponse;
 
        private Optional<? extends DeletedObject> deletedObject = Optional.empty();
        
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
         * Deleted Object
         */
        public Builder deletedObject(DeletedObject deletedObject) {
            Utils.checkNotNull(deletedObject, "deletedObject");
            this.deletedObject = Optional.ofNullable(deletedObject);
            return this;
        }

        /**
         * Deleted Object
         */
        public Builder deletedObject(Optional<? extends DeletedObject> deletedObject) {
            Utils.checkNotNull(deletedObject, "deletedObject");
            this.deletedObject = deletedObject;
            return this;
        }
        
        public UserWeb3WalletDeleteResponse build() {
            return new UserWeb3WalletDeleteResponse(
                contentType,
                statusCode,
                rawResponse,
                deletedObject);
        }
    }
}
