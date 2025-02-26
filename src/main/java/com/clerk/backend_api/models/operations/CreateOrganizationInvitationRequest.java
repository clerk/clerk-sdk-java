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
import java.util.Objects;
import java.util.Optional;


public class CreateOrganizationInvitationRequest {

    /**
     * The ID of the organization for which to send the invitation
     */
    @SpeakeasyMetadata("pathParam:style=simple,explode=false,name=organization_id")
    private String organizationId;

    @SpeakeasyMetadata("request:mediaType=application/json")
    private Optional<? extends CreateOrganizationInvitationRequestBody> requestBody;

    @JsonCreator
    public CreateOrganizationInvitationRequest(
            String organizationId,
            Optional<? extends CreateOrganizationInvitationRequestBody> requestBody) {
        Utils.checkNotNull(organizationId, "organizationId");
        Utils.checkNotNull(requestBody, "requestBody");
        this.organizationId = organizationId;
        this.requestBody = requestBody;
    }
    
    public CreateOrganizationInvitationRequest(
            String organizationId) {
        this(organizationId, Optional.empty());
    }

    /**
     * The ID of the organization for which to send the invitation
     */
    @JsonIgnore
    public String organizationId() {
        return organizationId;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<CreateOrganizationInvitationRequestBody> requestBody() {
        return (Optional<CreateOrganizationInvitationRequestBody>) requestBody;
    }

    public final static Builder builder() {
        return new Builder();
    }

    /**
     * The ID of the organization for which to send the invitation
     */
    public CreateOrganizationInvitationRequest withOrganizationId(String organizationId) {
        Utils.checkNotNull(organizationId, "organizationId");
        this.organizationId = organizationId;
        return this;
    }

    public CreateOrganizationInvitationRequest withRequestBody(CreateOrganizationInvitationRequestBody requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = Optional.ofNullable(requestBody);
        return this;
    }

    public CreateOrganizationInvitationRequest withRequestBody(Optional<? extends CreateOrganizationInvitationRequestBody> requestBody) {
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
        CreateOrganizationInvitationRequest other = (CreateOrganizationInvitationRequest) o;
        return 
            Objects.deepEquals(this.organizationId, other.organizationId) &&
            Objects.deepEquals(this.requestBody, other.requestBody);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            organizationId,
            requestBody);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CreateOrganizationInvitationRequest.class,
                "organizationId", organizationId,
                "requestBody", requestBody);
    }
    
    public final static class Builder {
 
        private String organizationId;
 
        private Optional<? extends CreateOrganizationInvitationRequestBody> requestBody = Optional.empty();  
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * The ID of the organization for which to send the invitation
         */
        public Builder organizationId(String organizationId) {
            Utils.checkNotNull(organizationId, "organizationId");
            this.organizationId = organizationId;
            return this;
        }

        public Builder requestBody(CreateOrganizationInvitationRequestBody requestBody) {
            Utils.checkNotNull(requestBody, "requestBody");
            this.requestBody = Optional.ofNullable(requestBody);
            return this;
        }

        public Builder requestBody(Optional<? extends CreateOrganizationInvitationRequestBody> requestBody) {
            Utils.checkNotNull(requestBody, "requestBody");
            this.requestBody = requestBody;
            return this;
        }
        
        public CreateOrganizationInvitationRequest build() {
            return new CreateOrganizationInvitationRequest(
                organizationId,
                requestBody);
        }
    }
}

