/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.utils.SpeakeasyMetadata;
import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Optional;


public class UpdateUserMetadataRequest {
    /**
     * The ID of the user whose metadata will be updated and merged
     */
    @SpeakeasyMetadata("pathParam:style=simple,explode=false,name=user_id")
    private String userId;


    @SpeakeasyMetadata("request:mediaType=application/json")
    private Optional<? extends UpdateUserMetadataRequestBody> requestBody;

    @JsonCreator
    public UpdateUserMetadataRequest(
            String userId,
            Optional<? extends UpdateUserMetadataRequestBody> requestBody) {
        Utils.checkNotNull(userId, "userId");
        Utils.checkNotNull(requestBody, "requestBody");
        this.userId = userId;
        this.requestBody = requestBody;
    }
    
    public UpdateUserMetadataRequest(
            String userId) {
        this(userId, Optional.empty());
    }

    /**
     * The ID of the user whose metadata will be updated and merged
     */
    @JsonIgnore
    public String userId() {
        return userId;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<UpdateUserMetadataRequestBody> requestBody() {
        return (Optional<UpdateUserMetadataRequestBody>) requestBody;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * The ID of the user whose metadata will be updated and merged
     */
    public UpdateUserMetadataRequest withUserId(String userId) {
        Utils.checkNotNull(userId, "userId");
        this.userId = userId;
        return this;
    }

    public UpdateUserMetadataRequest withRequestBody(UpdateUserMetadataRequestBody requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = Optional.ofNullable(requestBody);
        return this;
    }


    public UpdateUserMetadataRequest withRequestBody(Optional<? extends UpdateUserMetadataRequestBody> requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = requestBody;
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
        UpdateUserMetadataRequest other = (UpdateUserMetadataRequest) o;
        return 
            Utils.enhancedDeepEquals(this.userId, other.userId) &&
            Utils.enhancedDeepEquals(this.requestBody, other.requestBody);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            userId, requestBody);
    }
    
    @Override
    public String toString() {
        return Utils.toString(UpdateUserMetadataRequest.class,
                "userId", userId,
                "requestBody", requestBody);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String userId;

        private Optional<? extends UpdateUserMetadataRequestBody> requestBody = Optional.empty();

        private Builder() {
          // force use of static builder() method
        }


        /**
         * The ID of the user whose metadata will be updated and merged
         */
        public Builder userId(String userId) {
            Utils.checkNotNull(userId, "userId");
            this.userId = userId;
            return this;
        }


        public Builder requestBody(UpdateUserMetadataRequestBody requestBody) {
            Utils.checkNotNull(requestBody, "requestBody");
            this.requestBody = Optional.ofNullable(requestBody);
            return this;
        }

        public Builder requestBody(Optional<? extends UpdateUserMetadataRequestBody> requestBody) {
            Utils.checkNotNull(requestBody, "requestBody");
            this.requestBody = requestBody;
            return this;
        }

        public UpdateUserMetadataRequest build() {

            return new UpdateUserMetadataRequest(
                userId, requestBody);
        }

    }
}
