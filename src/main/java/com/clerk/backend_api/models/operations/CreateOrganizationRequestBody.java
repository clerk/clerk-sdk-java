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
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Map;
import java.util.Objects;
import org.openapitools.jackson.nullable.JsonNullable;

public class CreateOrganizationRequestBody {

    /**
     * The name of the new organization.
     * May not contain URLs or HTML.
     * Max length: 256
     */
    @JsonProperty("name")
    private String name;

    /**
     * The ID of the User who will become the administrator for the new organization
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("created_by")
    private JsonNullable<String> createdBy;

    /**
     * Metadata saved on the organization, accessible only from the Backend API
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("private_metadata")
    private JsonNullable<? extends Map<String, Object>> privateMetadata;

    /**
     * Metadata saved on the organization, read-only from the Frontend API and fully accessible (read/write) from the Backend API
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("public_metadata")
    private JsonNullable<? extends Map<String, Object>> publicMetadata;

    /**
     * A slug for the new organization.
     * Can contain only lowercase alphanumeric characters and the dash "-".
     * Must be unique for the instance.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("slug")
    private JsonNullable<String> slug;

    /**
     * The maximum number of memberships allowed for this organization
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("max_allowed_memberships")
    private JsonNullable<Long> maxAllowedMemberships;

    /**
     * A custom date/time denoting _when_ the organization was created, specified in RFC3339 format (e.g. `2012-10-20T07:15:20.902Z`).
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("created_at")
    private JsonNullable<String> createdAt;

    @JsonCreator
    public CreateOrganizationRequestBody(
            @JsonProperty("name") String name,
            @JsonProperty("created_by") JsonNullable<String> createdBy,
            @JsonProperty("private_metadata") JsonNullable<? extends Map<String, Object>> privateMetadata,
            @JsonProperty("public_metadata") JsonNullable<? extends Map<String, Object>> publicMetadata,
            @JsonProperty("slug") JsonNullable<String> slug,
            @JsonProperty("max_allowed_memberships") JsonNullable<Long> maxAllowedMemberships,
            @JsonProperty("created_at") JsonNullable<String> createdAt) {
        Utils.checkNotNull(name, "name");
        Utils.checkNotNull(createdBy, "createdBy");
        Utils.checkNotNull(privateMetadata, "privateMetadata");
        Utils.checkNotNull(publicMetadata, "publicMetadata");
        Utils.checkNotNull(slug, "slug");
        Utils.checkNotNull(maxAllowedMemberships, "maxAllowedMemberships");
        Utils.checkNotNull(createdAt, "createdAt");
        this.name = name;
        this.createdBy = createdBy;
        this.privateMetadata = privateMetadata;
        this.publicMetadata = publicMetadata;
        this.slug = slug;
        this.maxAllowedMemberships = maxAllowedMemberships;
        this.createdAt = createdAt;
    }
    
    public CreateOrganizationRequestBody(
            String name) {
        this(name, JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined());
    }

    /**
     * The name of the new organization.
     * May not contain URLs or HTML.
     * Max length: 256
     */
    @JsonIgnore
    public String name() {
        return name;
    }

    /**
     * The ID of the User who will become the administrator for the new organization
     */
    @JsonIgnore
    public JsonNullable<String> createdBy() {
        return createdBy;
    }

    /**
     * Metadata saved on the organization, accessible only from the Backend API
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<Map<String, Object>> privateMetadata() {
        return (JsonNullable<Map<String, Object>>) privateMetadata;
    }

    /**
     * Metadata saved on the organization, read-only from the Frontend API and fully accessible (read/write) from the Backend API
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<Map<String, Object>> publicMetadata() {
        return (JsonNullable<Map<String, Object>>) publicMetadata;
    }

    /**
     * A slug for the new organization.
     * Can contain only lowercase alphanumeric characters and the dash "-".
     * Must be unique for the instance.
     */
    @JsonIgnore
    public JsonNullable<String> slug() {
        return slug;
    }

    /**
     * The maximum number of memberships allowed for this organization
     */
    @JsonIgnore
    public JsonNullable<Long> maxAllowedMemberships() {
        return maxAllowedMemberships;
    }

    /**
     * A custom date/time denoting _when_ the organization was created, specified in RFC3339 format (e.g. `2012-10-20T07:15:20.902Z`).
     */
    @JsonIgnore
    public JsonNullable<String> createdAt() {
        return createdAt;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * The name of the new organization.
     * May not contain URLs or HTML.
     * Max length: 256
     */
    public CreateOrganizationRequestBody withName(String name) {
        Utils.checkNotNull(name, "name");
        this.name = name;
        return this;
    }

    /**
     * The ID of the User who will become the administrator for the new organization
     */
    public CreateOrganizationRequestBody withCreatedBy(String createdBy) {
        Utils.checkNotNull(createdBy, "createdBy");
        this.createdBy = JsonNullable.of(createdBy);
        return this;
    }

    /**
     * The ID of the User who will become the administrator for the new organization
     */
    public CreateOrganizationRequestBody withCreatedBy(JsonNullable<String> createdBy) {
        Utils.checkNotNull(createdBy, "createdBy");
        this.createdBy = createdBy;
        return this;
    }

    /**
     * Metadata saved on the organization, accessible only from the Backend API
     */
    public CreateOrganizationRequestBody withPrivateMetadata(Map<String, Object> privateMetadata) {
        Utils.checkNotNull(privateMetadata, "privateMetadata");
        this.privateMetadata = JsonNullable.of(privateMetadata);
        return this;
    }

    /**
     * Metadata saved on the organization, accessible only from the Backend API
     */
    public CreateOrganizationRequestBody withPrivateMetadata(JsonNullable<? extends Map<String, Object>> privateMetadata) {
        Utils.checkNotNull(privateMetadata, "privateMetadata");
        this.privateMetadata = privateMetadata;
        return this;
    }

    /**
     * Metadata saved on the organization, read-only from the Frontend API and fully accessible (read/write) from the Backend API
     */
    public CreateOrganizationRequestBody withPublicMetadata(Map<String, Object> publicMetadata) {
        Utils.checkNotNull(publicMetadata, "publicMetadata");
        this.publicMetadata = JsonNullable.of(publicMetadata);
        return this;
    }

    /**
     * Metadata saved on the organization, read-only from the Frontend API and fully accessible (read/write) from the Backend API
     */
    public CreateOrganizationRequestBody withPublicMetadata(JsonNullable<? extends Map<String, Object>> publicMetadata) {
        Utils.checkNotNull(publicMetadata, "publicMetadata");
        this.publicMetadata = publicMetadata;
        return this;
    }

    /**
     * A slug for the new organization.
     * Can contain only lowercase alphanumeric characters and the dash "-".
     * Must be unique for the instance.
     */
    public CreateOrganizationRequestBody withSlug(String slug) {
        Utils.checkNotNull(slug, "slug");
        this.slug = JsonNullable.of(slug);
        return this;
    }

    /**
     * A slug for the new organization.
     * Can contain only lowercase alphanumeric characters and the dash "-".
     * Must be unique for the instance.
     */
    public CreateOrganizationRequestBody withSlug(JsonNullable<String> slug) {
        Utils.checkNotNull(slug, "slug");
        this.slug = slug;
        return this;
    }

    /**
     * The maximum number of memberships allowed for this organization
     */
    public CreateOrganizationRequestBody withMaxAllowedMemberships(long maxAllowedMemberships) {
        Utils.checkNotNull(maxAllowedMemberships, "maxAllowedMemberships");
        this.maxAllowedMemberships = JsonNullable.of(maxAllowedMemberships);
        return this;
    }

    /**
     * The maximum number of memberships allowed for this organization
     */
    public CreateOrganizationRequestBody withMaxAllowedMemberships(JsonNullable<Long> maxAllowedMemberships) {
        Utils.checkNotNull(maxAllowedMemberships, "maxAllowedMemberships");
        this.maxAllowedMemberships = maxAllowedMemberships;
        return this;
    }

    /**
     * A custom date/time denoting _when_ the organization was created, specified in RFC3339 format (e.g. `2012-10-20T07:15:20.902Z`).
     */
    public CreateOrganizationRequestBody withCreatedAt(String createdAt) {
        Utils.checkNotNull(createdAt, "createdAt");
        this.createdAt = JsonNullable.of(createdAt);
        return this;
    }

    /**
     * A custom date/time denoting _when_ the organization was created, specified in RFC3339 format (e.g. `2012-10-20T07:15:20.902Z`).
     */
    public CreateOrganizationRequestBody withCreatedAt(JsonNullable<String> createdAt) {
        Utils.checkNotNull(createdAt, "createdAt");
        this.createdAt = createdAt;
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
        CreateOrganizationRequestBody other = (CreateOrganizationRequestBody) o;
        return 
            Objects.deepEquals(this.name, other.name) &&
            Objects.deepEquals(this.createdBy, other.createdBy) &&
            Objects.deepEquals(this.privateMetadata, other.privateMetadata) &&
            Objects.deepEquals(this.publicMetadata, other.publicMetadata) &&
            Objects.deepEquals(this.slug, other.slug) &&
            Objects.deepEquals(this.maxAllowedMemberships, other.maxAllowedMemberships) &&
            Objects.deepEquals(this.createdAt, other.createdAt);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            name,
            createdBy,
            privateMetadata,
            publicMetadata,
            slug,
            maxAllowedMemberships,
            createdAt);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CreateOrganizationRequestBody.class,
                "name", name,
                "createdBy", createdBy,
                "privateMetadata", privateMetadata,
                "publicMetadata", publicMetadata,
                "slug", slug,
                "maxAllowedMemberships", maxAllowedMemberships,
                "createdAt", createdAt);
    }
    
    public final static class Builder {
 
        private String name;
 
        private JsonNullable<String> createdBy = JsonNullable.undefined();
 
        private JsonNullable<? extends Map<String, Object>> privateMetadata = JsonNullable.undefined();
 
        private JsonNullable<? extends Map<String, Object>> publicMetadata = JsonNullable.undefined();
 
        private JsonNullable<String> slug = JsonNullable.undefined();
 
        private JsonNullable<Long> maxAllowedMemberships = JsonNullable.undefined();
 
        private JsonNullable<String> createdAt = JsonNullable.undefined();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * The name of the new organization.
         * May not contain URLs or HTML.
         * Max length: 256
         */
        public Builder name(String name) {
            Utils.checkNotNull(name, "name");
            this.name = name;
            return this;
        }

        /**
         * The ID of the User who will become the administrator for the new organization
         */
        public Builder createdBy(String createdBy) {
            Utils.checkNotNull(createdBy, "createdBy");
            this.createdBy = JsonNullable.of(createdBy);
            return this;
        }

        /**
         * The ID of the User who will become the administrator for the new organization
         */
        public Builder createdBy(JsonNullable<String> createdBy) {
            Utils.checkNotNull(createdBy, "createdBy");
            this.createdBy = createdBy;
            return this;
        }

        /**
         * Metadata saved on the organization, accessible only from the Backend API
         */
        public Builder privateMetadata(Map<String, Object> privateMetadata) {
            Utils.checkNotNull(privateMetadata, "privateMetadata");
            this.privateMetadata = JsonNullable.of(privateMetadata);
            return this;
        }

        /**
         * Metadata saved on the organization, accessible only from the Backend API
         */
        public Builder privateMetadata(JsonNullable<? extends Map<String, Object>> privateMetadata) {
            Utils.checkNotNull(privateMetadata, "privateMetadata");
            this.privateMetadata = privateMetadata;
            return this;
        }

        /**
         * Metadata saved on the organization, read-only from the Frontend API and fully accessible (read/write) from the Backend API
         */
        public Builder publicMetadata(Map<String, Object> publicMetadata) {
            Utils.checkNotNull(publicMetadata, "publicMetadata");
            this.publicMetadata = JsonNullable.of(publicMetadata);
            return this;
        }

        /**
         * Metadata saved on the organization, read-only from the Frontend API and fully accessible (read/write) from the Backend API
         */
        public Builder publicMetadata(JsonNullable<? extends Map<String, Object>> publicMetadata) {
            Utils.checkNotNull(publicMetadata, "publicMetadata");
            this.publicMetadata = publicMetadata;
            return this;
        }

        /**
         * A slug for the new organization.
         * Can contain only lowercase alphanumeric characters and the dash "-".
         * Must be unique for the instance.
         */
        public Builder slug(String slug) {
            Utils.checkNotNull(slug, "slug");
            this.slug = JsonNullable.of(slug);
            return this;
        }

        /**
         * A slug for the new organization.
         * Can contain only lowercase alphanumeric characters and the dash "-".
         * Must be unique for the instance.
         */
        public Builder slug(JsonNullable<String> slug) {
            Utils.checkNotNull(slug, "slug");
            this.slug = slug;
            return this;
        }

        /**
         * The maximum number of memberships allowed for this organization
         */
        public Builder maxAllowedMemberships(long maxAllowedMemberships) {
            Utils.checkNotNull(maxAllowedMemberships, "maxAllowedMemberships");
            this.maxAllowedMemberships = JsonNullable.of(maxAllowedMemberships);
            return this;
        }

        /**
         * The maximum number of memberships allowed for this organization
         */
        public Builder maxAllowedMemberships(JsonNullable<Long> maxAllowedMemberships) {
            Utils.checkNotNull(maxAllowedMemberships, "maxAllowedMemberships");
            this.maxAllowedMemberships = maxAllowedMemberships;
            return this;
        }

        /**
         * A custom date/time denoting _when_ the organization was created, specified in RFC3339 format (e.g. `2012-10-20T07:15:20.902Z`).
         */
        public Builder createdAt(String createdAt) {
            Utils.checkNotNull(createdAt, "createdAt");
            this.createdAt = JsonNullable.of(createdAt);
            return this;
        }

        /**
         * A custom date/time denoting _when_ the organization was created, specified in RFC3339 format (e.g. `2012-10-20T07:15:20.902Z`).
         */
        public Builder createdAt(JsonNullable<String> createdAt) {
            Utils.checkNotNull(createdAt, "createdAt");
            this.createdAt = createdAt;
            return this;
        }
        
        public CreateOrganizationRequestBody build() {
            return new CreateOrganizationRequestBody(
                name,
                createdBy,
                privateMetadata,
                publicMetadata,
                slug,
                maxAllowedMemberships,
                createdAt);
        }
    }
}
