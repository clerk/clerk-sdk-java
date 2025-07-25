/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Map;
import java.util.Optional;


public class UpdateOrganizationMembershipMetadataRequestBody {
    /**
     * Metadata saved on the organization membership, that is visible to both your frontend and backend.
     * The new object will be merged with the existing value.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("public_metadata")
    private Optional<? extends Map<String, Object>> publicMetadata;

    /**
     * Metadata saved on the organization membership that is only visible to your backend.
     * The new object will be merged with the existing value.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("private_metadata")
    private Optional<? extends Map<String, Object>> privateMetadata;

    @JsonCreator
    public UpdateOrganizationMembershipMetadataRequestBody(
            @JsonProperty("public_metadata") Optional<? extends Map<String, Object>> publicMetadata,
            @JsonProperty("private_metadata") Optional<? extends Map<String, Object>> privateMetadata) {
        Utils.checkNotNull(publicMetadata, "publicMetadata");
        Utils.checkNotNull(privateMetadata, "privateMetadata");
        this.publicMetadata = publicMetadata;
        this.privateMetadata = privateMetadata;
    }
    
    public UpdateOrganizationMembershipMetadataRequestBody() {
        this(Optional.empty(), Optional.empty());
    }

    /**
     * Metadata saved on the organization membership, that is visible to both your frontend and backend.
     * The new object will be merged with the existing value.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<Map<String, Object>> publicMetadata() {
        return (Optional<Map<String, Object>>) publicMetadata;
    }

    /**
     * Metadata saved on the organization membership that is only visible to your backend.
     * The new object will be merged with the existing value.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<Map<String, Object>> privateMetadata() {
        return (Optional<Map<String, Object>>) privateMetadata;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * Metadata saved on the organization membership, that is visible to both your frontend and backend.
     * The new object will be merged with the existing value.
     */
    public UpdateOrganizationMembershipMetadataRequestBody withPublicMetadata(Map<String, Object> publicMetadata) {
        Utils.checkNotNull(publicMetadata, "publicMetadata");
        this.publicMetadata = Optional.ofNullable(publicMetadata);
        return this;
    }


    /**
     * Metadata saved on the organization membership, that is visible to both your frontend and backend.
     * The new object will be merged with the existing value.
     */
    public UpdateOrganizationMembershipMetadataRequestBody withPublicMetadata(Optional<? extends Map<String, Object>> publicMetadata) {
        Utils.checkNotNull(publicMetadata, "publicMetadata");
        this.publicMetadata = publicMetadata;
        return this;
    }

    /**
     * Metadata saved on the organization membership that is only visible to your backend.
     * The new object will be merged with the existing value.
     */
    public UpdateOrganizationMembershipMetadataRequestBody withPrivateMetadata(Map<String, Object> privateMetadata) {
        Utils.checkNotNull(privateMetadata, "privateMetadata");
        this.privateMetadata = Optional.ofNullable(privateMetadata);
        return this;
    }


    /**
     * Metadata saved on the organization membership that is only visible to your backend.
     * The new object will be merged with the existing value.
     */
    public UpdateOrganizationMembershipMetadataRequestBody withPrivateMetadata(Optional<? extends Map<String, Object>> privateMetadata) {
        Utils.checkNotNull(privateMetadata, "privateMetadata");
        this.privateMetadata = privateMetadata;
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
        UpdateOrganizationMembershipMetadataRequestBody other = (UpdateOrganizationMembershipMetadataRequestBody) o;
        return 
            Utils.enhancedDeepEquals(this.publicMetadata, other.publicMetadata) &&
            Utils.enhancedDeepEquals(this.privateMetadata, other.privateMetadata);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            publicMetadata, privateMetadata);
    }
    
    @Override
    public String toString() {
        return Utils.toString(UpdateOrganizationMembershipMetadataRequestBody.class,
                "publicMetadata", publicMetadata,
                "privateMetadata", privateMetadata);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private Optional<? extends Map<String, Object>> publicMetadata = Optional.empty();

        private Optional<? extends Map<String, Object>> privateMetadata = Optional.empty();

        private Builder() {
          // force use of static builder() method
        }


        /**
         * Metadata saved on the organization membership, that is visible to both your frontend and backend.
         * The new object will be merged with the existing value.
         */
        public Builder publicMetadata(Map<String, Object> publicMetadata) {
            Utils.checkNotNull(publicMetadata, "publicMetadata");
            this.publicMetadata = Optional.ofNullable(publicMetadata);
            return this;
        }

        /**
         * Metadata saved on the organization membership, that is visible to both your frontend and backend.
         * The new object will be merged with the existing value.
         */
        public Builder publicMetadata(Optional<? extends Map<String, Object>> publicMetadata) {
            Utils.checkNotNull(publicMetadata, "publicMetadata");
            this.publicMetadata = publicMetadata;
            return this;
        }


        /**
         * Metadata saved on the organization membership that is only visible to your backend.
         * The new object will be merged with the existing value.
         */
        public Builder privateMetadata(Map<String, Object> privateMetadata) {
            Utils.checkNotNull(privateMetadata, "privateMetadata");
            this.privateMetadata = Optional.ofNullable(privateMetadata);
            return this;
        }

        /**
         * Metadata saved on the organization membership that is only visible to your backend.
         * The new object will be merged with the existing value.
         */
        public Builder privateMetadata(Optional<? extends Map<String, Object>> privateMetadata) {
            Utils.checkNotNull(privateMetadata, "privateMetadata");
            this.privateMetadata = privateMetadata;
            return this;
        }

        public UpdateOrganizationMembershipMetadataRequestBody build() {

            return new UpdateOrganizationMembershipMetadataRequestBody(
                publicMetadata, privateMetadata);
        }

    }
}
