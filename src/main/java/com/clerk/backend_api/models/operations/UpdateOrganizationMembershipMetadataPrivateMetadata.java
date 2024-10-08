/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.operations;


import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * UpdateOrganizationMembershipMetadataPrivateMetadata - Metadata saved on the organization membership that is only visible to your backend.
 * The new object will be merged with the existing value.
 */

public class UpdateOrganizationMembershipMetadataPrivateMetadata {

    @JsonCreator
    public UpdateOrganizationMembershipMetadataPrivateMetadata() {
        
        
    }

    public final static Builder builder() {
        return new Builder();
    }
    
    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            );
    }
    
    @Override
    public String toString() {
        return Utils.toString(UpdateOrganizationMembershipMetadataPrivateMetadata.class);
    }
    
    public final static class Builder {  
        
        private Builder() {
          // force use of static builder() method
        }
        
        public UpdateOrganizationMembershipMetadataPrivateMetadata build() {
            return new UpdateOrganizationMembershipMetadataPrivateMetadata(
                );
        }
    }
}

