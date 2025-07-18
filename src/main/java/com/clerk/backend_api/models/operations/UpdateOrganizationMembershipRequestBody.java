/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Override;
import java.lang.String;


public class UpdateOrganizationMembershipRequestBody {
    /**
     * The new role of the given membership.
     */
    @JsonProperty("role")
    private String role;

    @JsonCreator
    public UpdateOrganizationMembershipRequestBody(
            @JsonProperty("role") String role) {
        Utils.checkNotNull(role, "role");
        this.role = role;
    }

    /**
     * The new role of the given membership.
     */
    @JsonIgnore
    public String role() {
        return role;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * The new role of the given membership.
     */
    public UpdateOrganizationMembershipRequestBody withRole(String role) {
        Utils.checkNotNull(role, "role");
        this.role = role;
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
        UpdateOrganizationMembershipRequestBody other = (UpdateOrganizationMembershipRequestBody) o;
        return 
            Utils.enhancedDeepEquals(this.role, other.role);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            role);
    }
    
    @Override
    public String toString() {
        return Utils.toString(UpdateOrganizationMembershipRequestBody.class,
                "role", role);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String role;

        private Builder() {
          // force use of static builder() method
        }


        /**
         * The new role of the given membership.
         */
        public Builder role(String role) {
            Utils.checkNotNull(role, "role");
            this.role = role;
            return this;
        }

        public UpdateOrganizationMembershipRequestBody build() {

            return new UpdateOrganizationMembershipRequestBody(
                role);
        }

    }
}
