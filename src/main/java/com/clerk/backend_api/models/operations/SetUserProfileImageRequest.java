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
import java.util.Objects;

public class SetUserProfileImageRequest {

    /**
     * The ID of the user to update the profile image for
     */
    @SpeakeasyMetadata("pathParam:style=simple,explode=false,name=user_id")
    private String userId;

    @SpeakeasyMetadata("request:mediaType=multipart/form-data")
    private SetUserProfileImageRequestBody requestBody;

    @JsonCreator
    public SetUserProfileImageRequest(
            String userId,
            SetUserProfileImageRequestBody requestBody) {
        Utils.checkNotNull(userId, "userId");
        Utils.checkNotNull(requestBody, "requestBody");
        this.userId = userId;
        this.requestBody = requestBody;
    }

    /**
     * The ID of the user to update the profile image for
     */
    @JsonIgnore
    public String userId() {
        return userId;
    }

    @JsonIgnore
    public SetUserProfileImageRequestBody requestBody() {
        return requestBody;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * The ID of the user to update the profile image for
     */
    public SetUserProfileImageRequest withUserId(String userId) {
        Utils.checkNotNull(userId, "userId");
        this.userId = userId;
        return this;
    }

    public SetUserProfileImageRequest withRequestBody(SetUserProfileImageRequestBody requestBody) {
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
        SetUserProfileImageRequest other = (SetUserProfileImageRequest) o;
        return 
            Objects.deepEquals(this.userId, other.userId) &&
            Objects.deepEquals(this.requestBody, other.requestBody);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            userId,
            requestBody);
    }
    
    @Override
    public String toString() {
        return Utils.toString(SetUserProfileImageRequest.class,
                "userId", userId,
                "requestBody", requestBody);
    }
    
    public final static class Builder {
 
        private String userId;
 
        private SetUserProfileImageRequestBody requestBody;
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * The ID of the user to update the profile image for
         */
        public Builder userId(String userId) {
            Utils.checkNotNull(userId, "userId");
            this.userId = userId;
            return this;
        }

        public Builder requestBody(SetUserProfileImageRequestBody requestBody) {
            Utils.checkNotNull(requestBody, "requestBody");
            this.requestBody = requestBody;
            return this;
        }
        
        public SetUserProfileImageRequest build() {
            return new SetUserProfileImageRequest(
                userId,
                requestBody);
        }
    }
}
