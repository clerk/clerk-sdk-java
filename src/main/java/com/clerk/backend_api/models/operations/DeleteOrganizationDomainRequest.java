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


public class DeleteOrganizationDomainRequest {

    /**
     * The ID of the organization the domain belongs to
     */
    @SpeakeasyMetadata("pathParam:style=simple,explode=false,name=organization_id")
    private String organizationId;

    /**
     * The ID of the domain
     */
    @SpeakeasyMetadata("pathParam:style=simple,explode=false,name=domain_id")
    private String domainId;

    @JsonCreator
    public DeleteOrganizationDomainRequest(
            String organizationId,
            String domainId) {
        Utils.checkNotNull(organizationId, "organizationId");
        Utils.checkNotNull(domainId, "domainId");
        this.organizationId = organizationId;
        this.domainId = domainId;
    }

    /**
     * The ID of the organization the domain belongs to
     */
    @JsonIgnore
    public String organizationId() {
        return organizationId;
    }

    /**
     * The ID of the domain
     */
    @JsonIgnore
    public String domainId() {
        return domainId;
    }

    public final static Builder builder() {
        return new Builder();
    }

    /**
     * The ID of the organization the domain belongs to
     */
    public DeleteOrganizationDomainRequest withOrganizationId(String organizationId) {
        Utils.checkNotNull(organizationId, "organizationId");
        this.organizationId = organizationId;
        return this;
    }

    /**
     * The ID of the domain
     */
    public DeleteOrganizationDomainRequest withDomainId(String domainId) {
        Utils.checkNotNull(domainId, "domainId");
        this.domainId = domainId;
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
        DeleteOrganizationDomainRequest other = (DeleteOrganizationDomainRequest) o;
        return 
            Objects.deepEquals(this.organizationId, other.organizationId) &&
            Objects.deepEquals(this.domainId, other.domainId);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            organizationId,
            domainId);
    }
    
    @Override
    public String toString() {
        return Utils.toString(DeleteOrganizationDomainRequest.class,
                "organizationId", organizationId,
                "domainId", domainId);
    }
    
    public final static class Builder {
 
        private String organizationId;
 
        private String domainId;  
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * The ID of the organization the domain belongs to
         */
        public Builder organizationId(String organizationId) {
            Utils.checkNotNull(organizationId, "organizationId");
            this.organizationId = organizationId;
            return this;
        }

        /**
         * The ID of the domain
         */
        public Builder domainId(String domainId) {
            Utils.checkNotNull(domainId, "domainId");
            this.domainId = domainId;
            return this;
        }
        
        public DeleteOrganizationDomainRequest build() {
            return new DeleteOrganizationDomainRequest(
                organizationId,
                domainId);
        }
    }
}

