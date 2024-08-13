/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.components;


import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;


public class OrganizationMembershipOrganization {

    @JsonProperty("object")
    private OrganizationMembershipOrganizationObject object;

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("slug")
    private String slug;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("members_count")
    private JsonNullable<Long> membersCount;

    @JsonProperty("max_allowed_memberships")
    private long maxAllowedMemberships;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("admin_delete_enabled")
    private Optional<Boolean> adminDeleteEnabled;

    @JsonProperty("public_metadata")
    private OrganizationMembershipOrganizationPublicMetadata publicMetadata;

    @JsonProperty("private_metadata")
    private OrganizationMembershipOrganizationPrivateMetadata privateMetadata;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("created_by")
    private Optional<String> createdBy;

    /**
     * Unix timestamp of creation.
     * 
     */
    @JsonProperty("created_at")
    private long createdAt;

    /**
     * Unix timestamp of last update.
     * 
     */
    @JsonProperty("updated_at")
    private long updatedAt;

    @JsonCreator
    public OrganizationMembershipOrganization(
            @JsonProperty("object") OrganizationMembershipOrganizationObject object,
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("slug") String slug,
            @JsonProperty("members_count") JsonNullable<Long> membersCount,
            @JsonProperty("max_allowed_memberships") long maxAllowedMemberships,
            @JsonProperty("admin_delete_enabled") Optional<Boolean> adminDeleteEnabled,
            @JsonProperty("public_metadata") OrganizationMembershipOrganizationPublicMetadata publicMetadata,
            @JsonProperty("private_metadata") OrganizationMembershipOrganizationPrivateMetadata privateMetadata,
            @JsonProperty("created_by") Optional<String> createdBy,
            @JsonProperty("created_at") long createdAt,
            @JsonProperty("updated_at") long updatedAt) {
        Utils.checkNotNull(object, "object");
        Utils.checkNotNull(id, "id");
        Utils.checkNotNull(name, "name");
        Utils.checkNotNull(slug, "slug");
        Utils.checkNotNull(membersCount, "membersCount");
        Utils.checkNotNull(maxAllowedMemberships, "maxAllowedMemberships");
        Utils.checkNotNull(adminDeleteEnabled, "adminDeleteEnabled");
        Utils.checkNotNull(publicMetadata, "publicMetadata");
        Utils.checkNotNull(privateMetadata, "privateMetadata");
        Utils.checkNotNull(createdBy, "createdBy");
        Utils.checkNotNull(createdAt, "createdAt");
        Utils.checkNotNull(updatedAt, "updatedAt");
        this.object = object;
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.membersCount = membersCount;
        this.maxAllowedMemberships = maxAllowedMemberships;
        this.adminDeleteEnabled = adminDeleteEnabled;
        this.publicMetadata = publicMetadata;
        this.privateMetadata = privateMetadata;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    public OrganizationMembershipOrganization(
            OrganizationMembershipOrganizationObject object,
            String id,
            String name,
            String slug,
            long maxAllowedMemberships,
            OrganizationMembershipOrganizationPublicMetadata publicMetadata,
            OrganizationMembershipOrganizationPrivateMetadata privateMetadata,
            long createdAt,
            long updatedAt) {
        this(object, id, name, slug, JsonNullable.undefined(), maxAllowedMemberships, Optional.empty(), publicMetadata, privateMetadata, Optional.empty(), createdAt, updatedAt);
    }

    @JsonIgnore
    public OrganizationMembershipOrganizationObject object() {
        return object;
    }

    @JsonIgnore
    public String id() {
        return id;
    }

    @JsonIgnore
    public String name() {
        return name;
    }

    @JsonIgnore
    public String slug() {
        return slug;
    }

    @JsonIgnore
    public JsonNullable<Long> membersCount() {
        return membersCount;
    }

    @JsonIgnore
    public long maxAllowedMemberships() {
        return maxAllowedMemberships;
    }

    @JsonIgnore
    public Optional<Boolean> adminDeleteEnabled() {
        return adminDeleteEnabled;
    }

    @JsonIgnore
    public OrganizationMembershipOrganizationPublicMetadata publicMetadata() {
        return publicMetadata;
    }

    @JsonIgnore
    public OrganizationMembershipOrganizationPrivateMetadata privateMetadata() {
        return privateMetadata;
    }

    @JsonIgnore
    public Optional<String> createdBy() {
        return createdBy;
    }

    /**
     * Unix timestamp of creation.
     * 
     */
    @JsonIgnore
    public long createdAt() {
        return createdAt;
    }

    /**
     * Unix timestamp of last update.
     * 
     */
    @JsonIgnore
    public long updatedAt() {
        return updatedAt;
    }

    public final static Builder builder() {
        return new Builder();
    }

    public OrganizationMembershipOrganization withObject(OrganizationMembershipOrganizationObject object) {
        Utils.checkNotNull(object, "object");
        this.object = object;
        return this;
    }

    public OrganizationMembershipOrganization withId(String id) {
        Utils.checkNotNull(id, "id");
        this.id = id;
        return this;
    }

    public OrganizationMembershipOrganization withName(String name) {
        Utils.checkNotNull(name, "name");
        this.name = name;
        return this;
    }

    public OrganizationMembershipOrganization withSlug(String slug) {
        Utils.checkNotNull(slug, "slug");
        this.slug = slug;
        return this;
    }

    public OrganizationMembershipOrganization withMembersCount(long membersCount) {
        Utils.checkNotNull(membersCount, "membersCount");
        this.membersCount = JsonNullable.of(membersCount);
        return this;
    }

    public OrganizationMembershipOrganization withMembersCount(JsonNullable<Long> membersCount) {
        Utils.checkNotNull(membersCount, "membersCount");
        this.membersCount = membersCount;
        return this;
    }

    public OrganizationMembershipOrganization withMaxAllowedMemberships(long maxAllowedMemberships) {
        Utils.checkNotNull(maxAllowedMemberships, "maxAllowedMemberships");
        this.maxAllowedMemberships = maxAllowedMemberships;
        return this;
    }

    public OrganizationMembershipOrganization withAdminDeleteEnabled(boolean adminDeleteEnabled) {
        Utils.checkNotNull(adminDeleteEnabled, "adminDeleteEnabled");
        this.adminDeleteEnabled = Optional.ofNullable(adminDeleteEnabled);
        return this;
    }

    public OrganizationMembershipOrganization withAdminDeleteEnabled(Optional<Boolean> adminDeleteEnabled) {
        Utils.checkNotNull(adminDeleteEnabled, "adminDeleteEnabled");
        this.adminDeleteEnabled = adminDeleteEnabled;
        return this;
    }

    public OrganizationMembershipOrganization withPublicMetadata(OrganizationMembershipOrganizationPublicMetadata publicMetadata) {
        Utils.checkNotNull(publicMetadata, "publicMetadata");
        this.publicMetadata = publicMetadata;
        return this;
    }

    public OrganizationMembershipOrganization withPrivateMetadata(OrganizationMembershipOrganizationPrivateMetadata privateMetadata) {
        Utils.checkNotNull(privateMetadata, "privateMetadata");
        this.privateMetadata = privateMetadata;
        return this;
    }

    public OrganizationMembershipOrganization withCreatedBy(String createdBy) {
        Utils.checkNotNull(createdBy, "createdBy");
        this.createdBy = Optional.ofNullable(createdBy);
        return this;
    }

    public OrganizationMembershipOrganization withCreatedBy(Optional<String> createdBy) {
        Utils.checkNotNull(createdBy, "createdBy");
        this.createdBy = createdBy;
        return this;
    }

    /**
     * Unix timestamp of creation.
     * 
     */
    public OrganizationMembershipOrganization withCreatedAt(long createdAt) {
        Utils.checkNotNull(createdAt, "createdAt");
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Unix timestamp of last update.
     * 
     */
    public OrganizationMembershipOrganization withUpdatedAt(long updatedAt) {
        Utils.checkNotNull(updatedAt, "updatedAt");
        this.updatedAt = updatedAt;
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
        OrganizationMembershipOrganization other = (OrganizationMembershipOrganization) o;
        return 
            Objects.deepEquals(this.object, other.object) &&
            Objects.deepEquals(this.id, other.id) &&
            Objects.deepEquals(this.name, other.name) &&
            Objects.deepEquals(this.slug, other.slug) &&
            Objects.deepEquals(this.membersCount, other.membersCount) &&
            Objects.deepEquals(this.maxAllowedMemberships, other.maxAllowedMemberships) &&
            Objects.deepEquals(this.adminDeleteEnabled, other.adminDeleteEnabled) &&
            Objects.deepEquals(this.publicMetadata, other.publicMetadata) &&
            Objects.deepEquals(this.privateMetadata, other.privateMetadata) &&
            Objects.deepEquals(this.createdBy, other.createdBy) &&
            Objects.deepEquals(this.createdAt, other.createdAt) &&
            Objects.deepEquals(this.updatedAt, other.updatedAt);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            object,
            id,
            name,
            slug,
            membersCount,
            maxAllowedMemberships,
            adminDeleteEnabled,
            publicMetadata,
            privateMetadata,
            createdBy,
            createdAt,
            updatedAt);
    }
    
    @Override
    public String toString() {
        return Utils.toString(OrganizationMembershipOrganization.class,
                "object", object,
                "id", id,
                "name", name,
                "slug", slug,
                "membersCount", membersCount,
                "maxAllowedMemberships", maxAllowedMemberships,
                "adminDeleteEnabled", adminDeleteEnabled,
                "publicMetadata", publicMetadata,
                "privateMetadata", privateMetadata,
                "createdBy", createdBy,
                "createdAt", createdAt,
                "updatedAt", updatedAt);
    }
    
    public final static class Builder {
 
        private OrganizationMembershipOrganizationObject object;
 
        private String id;
 
        private String name;
 
        private String slug;
 
        private JsonNullable<Long> membersCount = JsonNullable.undefined();
 
        private Long maxAllowedMemberships;
 
        private Optional<Boolean> adminDeleteEnabled = Optional.empty();
 
        private OrganizationMembershipOrganizationPublicMetadata publicMetadata;
 
        private OrganizationMembershipOrganizationPrivateMetadata privateMetadata;
 
        private Optional<String> createdBy = Optional.empty();
 
        private Long createdAt;
 
        private Long updatedAt;  
        
        private Builder() {
          // force use of static builder() method
        }

        public Builder object(OrganizationMembershipOrganizationObject object) {
            Utils.checkNotNull(object, "object");
            this.object = object;
            return this;
        }

        public Builder id(String id) {
            Utils.checkNotNull(id, "id");
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            Utils.checkNotNull(name, "name");
            this.name = name;
            return this;
        }

        public Builder slug(String slug) {
            Utils.checkNotNull(slug, "slug");
            this.slug = slug;
            return this;
        }

        public Builder membersCount(long membersCount) {
            Utils.checkNotNull(membersCount, "membersCount");
            this.membersCount = JsonNullable.of(membersCount);
            return this;
        }

        public Builder membersCount(JsonNullable<Long> membersCount) {
            Utils.checkNotNull(membersCount, "membersCount");
            this.membersCount = membersCount;
            return this;
        }

        public Builder maxAllowedMemberships(long maxAllowedMemberships) {
            Utils.checkNotNull(maxAllowedMemberships, "maxAllowedMemberships");
            this.maxAllowedMemberships = maxAllowedMemberships;
            return this;
        }

        public Builder adminDeleteEnabled(boolean adminDeleteEnabled) {
            Utils.checkNotNull(adminDeleteEnabled, "adminDeleteEnabled");
            this.adminDeleteEnabled = Optional.ofNullable(adminDeleteEnabled);
            return this;
        }

        public Builder adminDeleteEnabled(Optional<Boolean> adminDeleteEnabled) {
            Utils.checkNotNull(adminDeleteEnabled, "adminDeleteEnabled");
            this.adminDeleteEnabled = adminDeleteEnabled;
            return this;
        }

        public Builder publicMetadata(OrganizationMembershipOrganizationPublicMetadata publicMetadata) {
            Utils.checkNotNull(publicMetadata, "publicMetadata");
            this.publicMetadata = publicMetadata;
            return this;
        }

        public Builder privateMetadata(OrganizationMembershipOrganizationPrivateMetadata privateMetadata) {
            Utils.checkNotNull(privateMetadata, "privateMetadata");
            this.privateMetadata = privateMetadata;
            return this;
        }

        public Builder createdBy(String createdBy) {
            Utils.checkNotNull(createdBy, "createdBy");
            this.createdBy = Optional.ofNullable(createdBy);
            return this;
        }

        public Builder createdBy(Optional<String> createdBy) {
            Utils.checkNotNull(createdBy, "createdBy");
            this.createdBy = createdBy;
            return this;
        }

        /**
         * Unix timestamp of creation.
         * 
         */
        public Builder createdAt(long createdAt) {
            Utils.checkNotNull(createdAt, "createdAt");
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Unix timestamp of last update.
         * 
         */
        public Builder updatedAt(long updatedAt) {
            Utils.checkNotNull(updatedAt, "updatedAt");
            this.updatedAt = updatedAt;
            return this;
        }
        
        public OrganizationMembershipOrganization build() {
            return new OrganizationMembershipOrganization(
                object,
                id,
                name,
                slug,
                membersCount,
                maxAllowedMemberships,
                adminDeleteEnabled,
                publicMetadata,
                privateMetadata,
                createdBy,
                createdAt,
                updatedAt);
        }
    }
}

