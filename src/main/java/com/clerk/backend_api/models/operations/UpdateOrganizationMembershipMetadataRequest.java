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


public class UpdateOrganizationMembershipMetadataRequest {
    /**
     * The ID of the organization the membership belongs to
     */
    @SpeakeasyMetadata("pathParam:style=simple,explode=false,name=organization_id")
    private String organizationId;

    /**
     * The ID of the user that this membership belongs to
     */
    @SpeakeasyMetadata("pathParam:style=simple,explode=false,name=user_id")
    private String userId;


    @SpeakeasyMetadata("request:mediaType=application/json")
    private Optional<? extends UpdateOrganizationMembershipMetadataRequestBody> requestBody;

    @JsonCreator
    public UpdateOrganizationMembershipMetadataRequest(
            String organizationId,
            String userId,
            Optional<? extends UpdateOrganizationMembershipMetadataRequestBody> requestBody) {
        Utils.checkNotNull(organizationId, "organizationId");
        Utils.checkNotNull(userId, "userId");
        Utils.checkNotNull(requestBody, "requestBody");
        this.organizationId = organizationId;
        this.userId = userId;
        this.requestBody = requestBody;
    }
    
    public UpdateOrganizationMembershipMetadataRequest(
            String organizationId,
            String userId) {
        this(organizationId, userId, Optional.empty());
    }

    /**
     * The ID of the organization the membership belongs to
     */
    @JsonIgnore
    public String organizationId() {
        return organizationId;
    }

    /**
     * The ID of the user that this membership belongs to
     */
    @JsonIgnore
    public String userId() {
        return userId;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<UpdateOrganizationMembershipMetadataRequestBody> requestBody() {
        return (Optional<UpdateOrganizationMembershipMetadataRequestBody>) requestBody;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * The ID of the organization the membership belongs to
     */
    public UpdateOrganizationMembershipMetadataRequest withOrganizationId(String organizationId) {
        Utils.checkNotNull(organizationId, "organizationId");
        this.organizationId = organizationId;
        return this;
    }

    /**
     * The ID of the user that this membership belongs to
     */
    public UpdateOrganizationMembershipMetadataRequest withUserId(String userId) {
        Utils.checkNotNull(userId, "userId");
        this.userId = userId;
        return this;
    }

    public UpdateOrganizationMembershipMetadataRequest withRequestBody(UpdateOrganizationMembershipMetadataRequestBody requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = Optional.ofNullable(requestBody);
        return this;
    }


    public UpdateOrganizationMembershipMetadataRequest withRequestBody(Optional<? extends UpdateOrganizationMembershipMetadataRequestBody> requestBody) {
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
        UpdateOrganizationMembershipMetadataRequest other = (UpdateOrganizationMembershipMetadataRequest) o;
        return 
            Utils.enhancedDeepEquals(this.organizationId, other.organizationId) &&
            Utils.enhancedDeepEquals(this.userId, other.userId) &&
            Utils.enhancedDeepEquals(this.requestBody, other.requestBody);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            organizationId, userId, requestBody);
    }
    
    @Override
    public String toString() {
        return Utils.toString(UpdateOrganizationMembershipMetadataRequest.class,
                "organizationId", organizationId,
                "userId", userId,
                "requestBody", requestBody);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String organizationId;

        private String userId;

        private Optional<? extends UpdateOrganizationMembershipMetadataRequestBody> requestBody = Optional.empty();

        private Builder() {
          // force use of static builder() method
        }


        /**
         * The ID of the organization the membership belongs to
         */
        public Builder organizationId(String organizationId) {
            Utils.checkNotNull(organizationId, "organizationId");
            this.organizationId = organizationId;
            return this;
        }


        /**
         * The ID of the user that this membership belongs to
         */
        public Builder userId(String userId) {
            Utils.checkNotNull(userId, "userId");
            this.userId = userId;
            return this;
        }


        public Builder requestBody(UpdateOrganizationMembershipMetadataRequestBody requestBody) {
            Utils.checkNotNull(requestBody, "requestBody");
            this.requestBody = Optional.ofNullable(requestBody);
            return this;
        }

        public Builder requestBody(Optional<? extends UpdateOrganizationMembershipMetadataRequestBody> requestBody) {
            Utils.checkNotNull(requestBody, "requestBody");
            this.requestBody = requestBody;
            return this;
        }

        public UpdateOrganizationMembershipMetadataRequest build() {

            return new UpdateOrganizationMembershipMetadataRequest(
                organizationId, userId, requestBody);
        }

    }
}
