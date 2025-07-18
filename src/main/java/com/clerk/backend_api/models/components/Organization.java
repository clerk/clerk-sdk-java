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
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Map;
import java.util.Optional;


public class Organization {

    @JsonProperty("object")
    private OrganizationObject object;


    @JsonProperty("id")
    private String id;


    @JsonProperty("name")
    private String name;


    @JsonProperty("slug")
    private String slug;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("members_count")
    private Optional<Long> membersCount;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("missing_member_with_elevated_permissions")
    private Optional<Boolean> missingMemberWithElevatedPermissions;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("pending_invitations_count")
    private Optional<Long> pendingInvitationsCount;


    @JsonProperty("max_allowed_memberships")
    private long maxAllowedMemberships;


    @JsonProperty("admin_delete_enabled")
    private boolean adminDeleteEnabled;


    @JsonProperty("public_metadata")
    private Map<String, Object> publicMetadata;


    @JsonProperty("private_metadata")
    private Map<String, Object> privateMetadata;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("created_by")
    private Optional<String> createdBy;

    /**
     * Unix timestamp of creation.
     */
    @JsonProperty("created_at")
    private long createdAt;

    /**
     * Unix timestamp of last update.
     */
    @JsonProperty("updated_at")
    private long updatedAt;

    @JsonCreator
    public Organization(
            @JsonProperty("object") OrganizationObject object,
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("slug") String slug,
            @JsonProperty("members_count") Optional<Long> membersCount,
            @JsonProperty("missing_member_with_elevated_permissions") Optional<Boolean> missingMemberWithElevatedPermissions,
            @JsonProperty("pending_invitations_count") Optional<Long> pendingInvitationsCount,
            @JsonProperty("max_allowed_memberships") long maxAllowedMemberships,
            @JsonProperty("admin_delete_enabled") boolean adminDeleteEnabled,
            @JsonProperty("public_metadata") Map<String, Object> publicMetadata,
            @JsonProperty("private_metadata") Map<String, Object> privateMetadata,
            @JsonProperty("created_by") Optional<String> createdBy,
            @JsonProperty("created_at") long createdAt,
            @JsonProperty("updated_at") long updatedAt) {
        Utils.checkNotNull(object, "object");
        Utils.checkNotNull(id, "id");
        Utils.checkNotNull(name, "name");
        Utils.checkNotNull(slug, "slug");
        Utils.checkNotNull(membersCount, "membersCount");
        Utils.checkNotNull(missingMemberWithElevatedPermissions, "missingMemberWithElevatedPermissions");
        Utils.checkNotNull(pendingInvitationsCount, "pendingInvitationsCount");
        Utils.checkNotNull(maxAllowedMemberships, "maxAllowedMemberships");
        Utils.checkNotNull(adminDeleteEnabled, "adminDeleteEnabled");
        publicMetadata = Utils.emptyMapIfNull(publicMetadata);
        Utils.checkNotNull(publicMetadata, "publicMetadata");
        privateMetadata = Utils.emptyMapIfNull(privateMetadata);
        Utils.checkNotNull(privateMetadata, "privateMetadata");
        Utils.checkNotNull(createdBy, "createdBy");
        Utils.checkNotNull(createdAt, "createdAt");
        Utils.checkNotNull(updatedAt, "updatedAt");
        this.object = object;
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.membersCount = membersCount;
        this.missingMemberWithElevatedPermissions = missingMemberWithElevatedPermissions;
        this.pendingInvitationsCount = pendingInvitationsCount;
        this.maxAllowedMemberships = maxAllowedMemberships;
        this.adminDeleteEnabled = adminDeleteEnabled;
        this.publicMetadata = publicMetadata;
        this.privateMetadata = privateMetadata;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    public Organization(
            OrganizationObject object,
            String id,
            String name,
            String slug,
            long maxAllowedMemberships,
            boolean adminDeleteEnabled,
            Map<String, Object> publicMetadata,
            Map<String, Object> privateMetadata,
            long createdAt,
            long updatedAt) {
        this(object, id, name,
            slug, Optional.empty(), Optional.empty(),
            Optional.empty(), maxAllowedMemberships, adminDeleteEnabled,
            publicMetadata, privateMetadata, Optional.empty(),
            createdAt, updatedAt);
    }

    @JsonIgnore
    public OrganizationObject object() {
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
    public Optional<Long> membersCount() {
        return membersCount;
    }

    @JsonIgnore
    public Optional<Boolean> missingMemberWithElevatedPermissions() {
        return missingMemberWithElevatedPermissions;
    }

    @JsonIgnore
    public Optional<Long> pendingInvitationsCount() {
        return pendingInvitationsCount;
    }

    @JsonIgnore
    public long maxAllowedMemberships() {
        return maxAllowedMemberships;
    }

    @JsonIgnore
    public boolean adminDeleteEnabled() {
        return adminDeleteEnabled;
    }

    @JsonIgnore
    public Map<String, Object> publicMetadata() {
        return publicMetadata;
    }

    @JsonIgnore
    public Map<String, Object> privateMetadata() {
        return privateMetadata;
    }

    @JsonIgnore
    public Optional<String> createdBy() {
        return createdBy;
    }

    /**
     * Unix timestamp of creation.
     */
    @JsonIgnore
    public long createdAt() {
        return createdAt;
    }

    /**
     * Unix timestamp of last update.
     */
    @JsonIgnore
    public long updatedAt() {
        return updatedAt;
    }

    public static Builder builder() {
        return new Builder();
    }


    public Organization withObject(OrganizationObject object) {
        Utils.checkNotNull(object, "object");
        this.object = object;
        return this;
    }

    public Organization withId(String id) {
        Utils.checkNotNull(id, "id");
        this.id = id;
        return this;
    }

    public Organization withName(String name) {
        Utils.checkNotNull(name, "name");
        this.name = name;
        return this;
    }

    public Organization withSlug(String slug) {
        Utils.checkNotNull(slug, "slug");
        this.slug = slug;
        return this;
    }

    public Organization withMembersCount(long membersCount) {
        Utils.checkNotNull(membersCount, "membersCount");
        this.membersCount = Optional.ofNullable(membersCount);
        return this;
    }


    public Organization withMembersCount(Optional<Long> membersCount) {
        Utils.checkNotNull(membersCount, "membersCount");
        this.membersCount = membersCount;
        return this;
    }

    public Organization withMissingMemberWithElevatedPermissions(boolean missingMemberWithElevatedPermissions) {
        Utils.checkNotNull(missingMemberWithElevatedPermissions, "missingMemberWithElevatedPermissions");
        this.missingMemberWithElevatedPermissions = Optional.ofNullable(missingMemberWithElevatedPermissions);
        return this;
    }


    public Organization withMissingMemberWithElevatedPermissions(Optional<Boolean> missingMemberWithElevatedPermissions) {
        Utils.checkNotNull(missingMemberWithElevatedPermissions, "missingMemberWithElevatedPermissions");
        this.missingMemberWithElevatedPermissions = missingMemberWithElevatedPermissions;
        return this;
    }

    public Organization withPendingInvitationsCount(long pendingInvitationsCount) {
        Utils.checkNotNull(pendingInvitationsCount, "pendingInvitationsCount");
        this.pendingInvitationsCount = Optional.ofNullable(pendingInvitationsCount);
        return this;
    }


    public Organization withPendingInvitationsCount(Optional<Long> pendingInvitationsCount) {
        Utils.checkNotNull(pendingInvitationsCount, "pendingInvitationsCount");
        this.pendingInvitationsCount = pendingInvitationsCount;
        return this;
    }

    public Organization withMaxAllowedMemberships(long maxAllowedMemberships) {
        Utils.checkNotNull(maxAllowedMemberships, "maxAllowedMemberships");
        this.maxAllowedMemberships = maxAllowedMemberships;
        return this;
    }

    public Organization withAdminDeleteEnabled(boolean adminDeleteEnabled) {
        Utils.checkNotNull(adminDeleteEnabled, "adminDeleteEnabled");
        this.adminDeleteEnabled = adminDeleteEnabled;
        return this;
    }

    public Organization withPublicMetadata(Map<String, Object> publicMetadata) {
        Utils.checkNotNull(publicMetadata, "publicMetadata");
        this.publicMetadata = publicMetadata;
        return this;
    }

    public Organization withPrivateMetadata(Map<String, Object> privateMetadata) {
        Utils.checkNotNull(privateMetadata, "privateMetadata");
        this.privateMetadata = privateMetadata;
        return this;
    }

    public Organization withCreatedBy(String createdBy) {
        Utils.checkNotNull(createdBy, "createdBy");
        this.createdBy = Optional.ofNullable(createdBy);
        return this;
    }


    public Organization withCreatedBy(Optional<String> createdBy) {
        Utils.checkNotNull(createdBy, "createdBy");
        this.createdBy = createdBy;
        return this;
    }

    /**
     * Unix timestamp of creation.
     */
    public Organization withCreatedAt(long createdAt) {
        Utils.checkNotNull(createdAt, "createdAt");
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Unix timestamp of last update.
     */
    public Organization withUpdatedAt(long updatedAt) {
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
        Organization other = (Organization) o;
        return 
            Utils.enhancedDeepEquals(this.object, other.object) &&
            Utils.enhancedDeepEquals(this.id, other.id) &&
            Utils.enhancedDeepEquals(this.name, other.name) &&
            Utils.enhancedDeepEquals(this.slug, other.slug) &&
            Utils.enhancedDeepEquals(this.membersCount, other.membersCount) &&
            Utils.enhancedDeepEquals(this.missingMemberWithElevatedPermissions, other.missingMemberWithElevatedPermissions) &&
            Utils.enhancedDeepEquals(this.pendingInvitationsCount, other.pendingInvitationsCount) &&
            Utils.enhancedDeepEquals(this.maxAllowedMemberships, other.maxAllowedMemberships) &&
            Utils.enhancedDeepEquals(this.adminDeleteEnabled, other.adminDeleteEnabled) &&
            Utils.enhancedDeepEquals(this.publicMetadata, other.publicMetadata) &&
            Utils.enhancedDeepEquals(this.privateMetadata, other.privateMetadata) &&
            Utils.enhancedDeepEquals(this.createdBy, other.createdBy) &&
            Utils.enhancedDeepEquals(this.createdAt, other.createdAt) &&
            Utils.enhancedDeepEquals(this.updatedAt, other.updatedAt);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            object, id, name,
            slug, membersCount, missingMemberWithElevatedPermissions,
            pendingInvitationsCount, maxAllowedMemberships, adminDeleteEnabled,
            publicMetadata, privateMetadata, createdBy,
            createdAt, updatedAt);
    }
    
    @Override
    public String toString() {
        return Utils.toString(Organization.class,
                "object", object,
                "id", id,
                "name", name,
                "slug", slug,
                "membersCount", membersCount,
                "missingMemberWithElevatedPermissions", missingMemberWithElevatedPermissions,
                "pendingInvitationsCount", pendingInvitationsCount,
                "maxAllowedMemberships", maxAllowedMemberships,
                "adminDeleteEnabled", adminDeleteEnabled,
                "publicMetadata", publicMetadata,
                "privateMetadata", privateMetadata,
                "createdBy", createdBy,
                "createdAt", createdAt,
                "updatedAt", updatedAt);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private OrganizationObject object;

        private String id;

        private String name;

        private String slug;

        private Optional<Long> membersCount = Optional.empty();

        private Optional<Boolean> missingMemberWithElevatedPermissions = Optional.empty();

        private Optional<Long> pendingInvitationsCount = Optional.empty();

        private Long maxAllowedMemberships;

        private Boolean adminDeleteEnabled;

        private Map<String, Object> publicMetadata;

        private Map<String, Object> privateMetadata;

        private Optional<String> createdBy = Optional.empty();

        private Long createdAt;

        private Long updatedAt;

        private Builder() {
          // force use of static builder() method
        }


        public Builder object(OrganizationObject object) {
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
            this.membersCount = Optional.ofNullable(membersCount);
            return this;
        }

        public Builder membersCount(Optional<Long> membersCount) {
            Utils.checkNotNull(membersCount, "membersCount");
            this.membersCount = membersCount;
            return this;
        }


        public Builder missingMemberWithElevatedPermissions(boolean missingMemberWithElevatedPermissions) {
            Utils.checkNotNull(missingMemberWithElevatedPermissions, "missingMemberWithElevatedPermissions");
            this.missingMemberWithElevatedPermissions = Optional.ofNullable(missingMemberWithElevatedPermissions);
            return this;
        }

        public Builder missingMemberWithElevatedPermissions(Optional<Boolean> missingMemberWithElevatedPermissions) {
            Utils.checkNotNull(missingMemberWithElevatedPermissions, "missingMemberWithElevatedPermissions");
            this.missingMemberWithElevatedPermissions = missingMemberWithElevatedPermissions;
            return this;
        }


        public Builder pendingInvitationsCount(long pendingInvitationsCount) {
            Utils.checkNotNull(pendingInvitationsCount, "pendingInvitationsCount");
            this.pendingInvitationsCount = Optional.ofNullable(pendingInvitationsCount);
            return this;
        }

        public Builder pendingInvitationsCount(Optional<Long> pendingInvitationsCount) {
            Utils.checkNotNull(pendingInvitationsCount, "pendingInvitationsCount");
            this.pendingInvitationsCount = pendingInvitationsCount;
            return this;
        }


        public Builder maxAllowedMemberships(long maxAllowedMemberships) {
            Utils.checkNotNull(maxAllowedMemberships, "maxAllowedMemberships");
            this.maxAllowedMemberships = maxAllowedMemberships;
            return this;
        }


        public Builder adminDeleteEnabled(boolean adminDeleteEnabled) {
            Utils.checkNotNull(adminDeleteEnabled, "adminDeleteEnabled");
            this.adminDeleteEnabled = adminDeleteEnabled;
            return this;
        }


        public Builder publicMetadata(Map<String, Object> publicMetadata) {
            Utils.checkNotNull(publicMetadata, "publicMetadata");
            this.publicMetadata = publicMetadata;
            return this;
        }


        public Builder privateMetadata(Map<String, Object> privateMetadata) {
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
         */
        public Builder createdAt(long createdAt) {
            Utils.checkNotNull(createdAt, "createdAt");
            this.createdAt = createdAt;
            return this;
        }


        /**
         * Unix timestamp of last update.
         */
        public Builder updatedAt(long updatedAt) {
            Utils.checkNotNull(updatedAt, "updatedAt");
            this.updatedAt = updatedAt;
            return this;
        }

        public Organization build() {

            return new Organization(
                object, id, name,
                slug, membersCount, missingMemberWithElevatedPermissions,
                pendingInvitationsCount, maxAllowedMemberships, adminDeleteEnabled,
                publicMetadata, privateMetadata, createdBy,
                createdAt, updatedAt);
        }

    }
}
