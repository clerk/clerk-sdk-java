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


public class CreateOrganizationDomainRequest {

    /**
     * The ID of the organization where the new domain will be created.
     */
    @SpeakeasyMetadata("pathParam:style=simple,explode=false,name=organization_id")
    private String organizationId;

    @SpeakeasyMetadata("request:mediaType=application/json")
    private CreateOrganizationDomainRequestBody requestBody;

    @JsonCreator
    public CreateOrganizationDomainRequest(
            String organizationId,
            CreateOrganizationDomainRequestBody requestBody) {
        Utils.checkNotNull(organizationId, "organizationId");
        Utils.checkNotNull(requestBody, "requestBody");
        this.organizationId = organizationId;
        this.requestBody = requestBody;
    }

    /**
     * The ID of the organization where the new domain will be created.
     */
    @JsonIgnore
    public String organizationId() {
        return organizationId;
    }

    @JsonIgnore
    public CreateOrganizationDomainRequestBody requestBody() {
        return requestBody;
    }

    public final static Builder builder() {
        return new Builder();
    }

    /**
     * The ID of the organization where the new domain will be created.
     */
    public CreateOrganizationDomainRequest withOrganizationId(String organizationId) {
        Utils.checkNotNull(organizationId, "organizationId");
        this.organizationId = organizationId;
        return this;
    }

    public CreateOrganizationDomainRequest withRequestBody(CreateOrganizationDomainRequestBody requestBody) {
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
        CreateOrganizationDomainRequest other = (CreateOrganizationDomainRequest) o;
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
        return Utils.toString(CreateOrganizationDomainRequest.class,
                "organizationId", organizationId,
                "requestBody", requestBody);
    }
    
    public final static class Builder {
 
        private String organizationId;
 
        private CreateOrganizationDomainRequestBody requestBody;  
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * The ID of the organization where the new domain will be created.
         */
        public Builder organizationId(String organizationId) {
            Utils.checkNotNull(organizationId, "organizationId");
            this.organizationId = organizationId;
            return this;
        }

        public Builder requestBody(CreateOrganizationDomainRequestBody requestBody) {
            Utils.checkNotNull(requestBody, "requestBody");
            this.requestBody = requestBody;
            return this;
        }
        
        public CreateOrganizationDomainRequest build() {
            return new CreateOrganizationDomainRequest(
                organizationId,
                requestBody);
        }
    }
}

