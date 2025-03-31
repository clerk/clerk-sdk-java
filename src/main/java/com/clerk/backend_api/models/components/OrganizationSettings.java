/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.components;

import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Objects;

/**
 * OrganizationSettings
 * 
 * <p>Success
 */
public class OrganizationSettings {

    /**
     * String representing the object's type. Objects of the same type share the same value.
     */
    @JsonProperty("object")
    private OrganizationSettingsObject object;

    @JsonProperty("enabled")
    private boolean enabled;

    @JsonProperty("max_allowed_memberships")
    private long maxAllowedMemberships;

    @JsonProperty("max_allowed_roles")
    private long maxAllowedRoles;

    @JsonProperty("max_allowed_permissions")
    private long maxAllowedPermissions;

    /**
     * The role key that a user will be assigned after creating an organization.
     */
    @JsonProperty("creator_role")
    private String creatorRole;

    /**
     * The default for whether an admin can delete an organization with the Frontend API.
     */
    @JsonProperty("admin_delete_enabled")
    private boolean adminDeleteEnabled;

    @JsonProperty("domains_enabled")
    private boolean domainsEnabled;

    @JsonProperty("domains_enrollment_modes")
    private List<DomainsEnrollmentModes> domainsEnrollmentModes;

    /**
     * The role key that it will be used in order to create an organization invitation or suggestion.
     */
    @JsonProperty("domains_default_role")
    private String domainsDefaultRole;

    @JsonCreator
    public OrganizationSettings(
            @JsonProperty("object") OrganizationSettingsObject object,
            @JsonProperty("enabled") boolean enabled,
            @JsonProperty("max_allowed_memberships") long maxAllowedMemberships,
            @JsonProperty("max_allowed_roles") long maxAllowedRoles,
            @JsonProperty("max_allowed_permissions") long maxAllowedPermissions,
            @JsonProperty("creator_role") String creatorRole,
            @JsonProperty("admin_delete_enabled") boolean adminDeleteEnabled,
            @JsonProperty("domains_enabled") boolean domainsEnabled,
            @JsonProperty("domains_enrollment_modes") List<DomainsEnrollmentModes> domainsEnrollmentModes,
            @JsonProperty("domains_default_role") String domainsDefaultRole) {
        Utils.checkNotNull(object, "object");
        Utils.checkNotNull(enabled, "enabled");
        Utils.checkNotNull(maxAllowedMemberships, "maxAllowedMemberships");
        Utils.checkNotNull(maxAllowedRoles, "maxAllowedRoles");
        Utils.checkNotNull(maxAllowedPermissions, "maxAllowedPermissions");
        Utils.checkNotNull(creatorRole, "creatorRole");
        Utils.checkNotNull(adminDeleteEnabled, "adminDeleteEnabled");
        Utils.checkNotNull(domainsEnabled, "domainsEnabled");
        Utils.checkNotNull(domainsEnrollmentModes, "domainsEnrollmentModes");
        Utils.checkNotNull(domainsDefaultRole, "domainsDefaultRole");
        this.object = object;
        this.enabled = enabled;
        this.maxAllowedMemberships = maxAllowedMemberships;
        this.maxAllowedRoles = maxAllowedRoles;
        this.maxAllowedPermissions = maxAllowedPermissions;
        this.creatorRole = creatorRole;
        this.adminDeleteEnabled = adminDeleteEnabled;
        this.domainsEnabled = domainsEnabled;
        this.domainsEnrollmentModes = domainsEnrollmentModes;
        this.domainsDefaultRole = domainsDefaultRole;
    }

    /**
     * String representing the object's type. Objects of the same type share the same value.
     */
    @JsonIgnore
    public OrganizationSettingsObject object() {
        return object;
    }

    @JsonIgnore
    public boolean enabled() {
        return enabled;
    }

    @JsonIgnore
    public long maxAllowedMemberships() {
        return maxAllowedMemberships;
    }

    @JsonIgnore
    public long maxAllowedRoles() {
        return maxAllowedRoles;
    }

    @JsonIgnore
    public long maxAllowedPermissions() {
        return maxAllowedPermissions;
    }

    /**
     * The role key that a user will be assigned after creating an organization.
     */
    @JsonIgnore
    public String creatorRole() {
        return creatorRole;
    }

    /**
     * The default for whether an admin can delete an organization with the Frontend API.
     */
    @JsonIgnore
    public boolean adminDeleteEnabled() {
        return adminDeleteEnabled;
    }

    @JsonIgnore
    public boolean domainsEnabled() {
        return domainsEnabled;
    }

    @JsonIgnore
    public List<DomainsEnrollmentModes> domainsEnrollmentModes() {
        return domainsEnrollmentModes;
    }

    /**
     * The role key that it will be used in order to create an organization invitation or suggestion.
     */
    @JsonIgnore
    public String domainsDefaultRole() {
        return domainsDefaultRole;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * String representing the object's type. Objects of the same type share the same value.
     */
    public OrganizationSettings withObject(OrganizationSettingsObject object) {
        Utils.checkNotNull(object, "object");
        this.object = object;
        return this;
    }

    public OrganizationSettings withEnabled(boolean enabled) {
        Utils.checkNotNull(enabled, "enabled");
        this.enabled = enabled;
        return this;
    }

    public OrganizationSettings withMaxAllowedMemberships(long maxAllowedMemberships) {
        Utils.checkNotNull(maxAllowedMemberships, "maxAllowedMemberships");
        this.maxAllowedMemberships = maxAllowedMemberships;
        return this;
    }

    public OrganizationSettings withMaxAllowedRoles(long maxAllowedRoles) {
        Utils.checkNotNull(maxAllowedRoles, "maxAllowedRoles");
        this.maxAllowedRoles = maxAllowedRoles;
        return this;
    }

    public OrganizationSettings withMaxAllowedPermissions(long maxAllowedPermissions) {
        Utils.checkNotNull(maxAllowedPermissions, "maxAllowedPermissions");
        this.maxAllowedPermissions = maxAllowedPermissions;
        return this;
    }

    /**
     * The role key that a user will be assigned after creating an organization.
     */
    public OrganizationSettings withCreatorRole(String creatorRole) {
        Utils.checkNotNull(creatorRole, "creatorRole");
        this.creatorRole = creatorRole;
        return this;
    }

    /**
     * The default for whether an admin can delete an organization with the Frontend API.
     */
    public OrganizationSettings withAdminDeleteEnabled(boolean adminDeleteEnabled) {
        Utils.checkNotNull(adminDeleteEnabled, "adminDeleteEnabled");
        this.adminDeleteEnabled = adminDeleteEnabled;
        return this;
    }

    public OrganizationSettings withDomainsEnabled(boolean domainsEnabled) {
        Utils.checkNotNull(domainsEnabled, "domainsEnabled");
        this.domainsEnabled = domainsEnabled;
        return this;
    }

    public OrganizationSettings withDomainsEnrollmentModes(List<DomainsEnrollmentModes> domainsEnrollmentModes) {
        Utils.checkNotNull(domainsEnrollmentModes, "domainsEnrollmentModes");
        this.domainsEnrollmentModes = domainsEnrollmentModes;
        return this;
    }

    /**
     * The role key that it will be used in order to create an organization invitation or suggestion.
     */
    public OrganizationSettings withDomainsDefaultRole(String domainsDefaultRole) {
        Utils.checkNotNull(domainsDefaultRole, "domainsDefaultRole");
        this.domainsDefaultRole = domainsDefaultRole;
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
        OrganizationSettings other = (OrganizationSettings) o;
        return 
            Objects.deepEquals(this.object, other.object) &&
            Objects.deepEquals(this.enabled, other.enabled) &&
            Objects.deepEquals(this.maxAllowedMemberships, other.maxAllowedMemberships) &&
            Objects.deepEquals(this.maxAllowedRoles, other.maxAllowedRoles) &&
            Objects.deepEquals(this.maxAllowedPermissions, other.maxAllowedPermissions) &&
            Objects.deepEquals(this.creatorRole, other.creatorRole) &&
            Objects.deepEquals(this.adminDeleteEnabled, other.adminDeleteEnabled) &&
            Objects.deepEquals(this.domainsEnabled, other.domainsEnabled) &&
            Objects.deepEquals(this.domainsEnrollmentModes, other.domainsEnrollmentModes) &&
            Objects.deepEquals(this.domainsDefaultRole, other.domainsDefaultRole);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            object,
            enabled,
            maxAllowedMemberships,
            maxAllowedRoles,
            maxAllowedPermissions,
            creatorRole,
            adminDeleteEnabled,
            domainsEnabled,
            domainsEnrollmentModes,
            domainsDefaultRole);
    }
    
    @Override
    public String toString() {
        return Utils.toString(OrganizationSettings.class,
                "object", object,
                "enabled", enabled,
                "maxAllowedMemberships", maxAllowedMemberships,
                "maxAllowedRoles", maxAllowedRoles,
                "maxAllowedPermissions", maxAllowedPermissions,
                "creatorRole", creatorRole,
                "adminDeleteEnabled", adminDeleteEnabled,
                "domainsEnabled", domainsEnabled,
                "domainsEnrollmentModes", domainsEnrollmentModes,
                "domainsDefaultRole", domainsDefaultRole);
    }
    
    public final static class Builder {
 
        private OrganizationSettingsObject object;
 
        private Boolean enabled;
 
        private Long maxAllowedMemberships;
 
        private Long maxAllowedRoles;
 
        private Long maxAllowedPermissions;
 
        private String creatorRole;
 
        private Boolean adminDeleteEnabled;
 
        private Boolean domainsEnabled;
 
        private List<DomainsEnrollmentModes> domainsEnrollmentModes;
 
        private String domainsDefaultRole;
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * String representing the object's type. Objects of the same type share the same value.
         */
        public Builder object(OrganizationSettingsObject object) {
            Utils.checkNotNull(object, "object");
            this.object = object;
            return this;
        }

        public Builder enabled(boolean enabled) {
            Utils.checkNotNull(enabled, "enabled");
            this.enabled = enabled;
            return this;
        }

        public Builder maxAllowedMemberships(long maxAllowedMemberships) {
            Utils.checkNotNull(maxAllowedMemberships, "maxAllowedMemberships");
            this.maxAllowedMemberships = maxAllowedMemberships;
            return this;
        }

        public Builder maxAllowedRoles(long maxAllowedRoles) {
            Utils.checkNotNull(maxAllowedRoles, "maxAllowedRoles");
            this.maxAllowedRoles = maxAllowedRoles;
            return this;
        }

        public Builder maxAllowedPermissions(long maxAllowedPermissions) {
            Utils.checkNotNull(maxAllowedPermissions, "maxAllowedPermissions");
            this.maxAllowedPermissions = maxAllowedPermissions;
            return this;
        }

        /**
         * The role key that a user will be assigned after creating an organization.
         */
        public Builder creatorRole(String creatorRole) {
            Utils.checkNotNull(creatorRole, "creatorRole");
            this.creatorRole = creatorRole;
            return this;
        }

        /**
         * The default for whether an admin can delete an organization with the Frontend API.
         */
        public Builder adminDeleteEnabled(boolean adminDeleteEnabled) {
            Utils.checkNotNull(adminDeleteEnabled, "adminDeleteEnabled");
            this.adminDeleteEnabled = adminDeleteEnabled;
            return this;
        }

        public Builder domainsEnabled(boolean domainsEnabled) {
            Utils.checkNotNull(domainsEnabled, "domainsEnabled");
            this.domainsEnabled = domainsEnabled;
            return this;
        }

        public Builder domainsEnrollmentModes(List<DomainsEnrollmentModes> domainsEnrollmentModes) {
            Utils.checkNotNull(domainsEnrollmentModes, "domainsEnrollmentModes");
            this.domainsEnrollmentModes = domainsEnrollmentModes;
            return this;
        }

        /**
         * The role key that it will be used in order to create an organization invitation or suggestion.
         */
        public Builder domainsDefaultRole(String domainsDefaultRole) {
            Utils.checkNotNull(domainsDefaultRole, "domainsDefaultRole");
            this.domainsDefaultRole = domainsDefaultRole;
            return this;
        }
        
        public OrganizationSettings build() {
            return new OrganizationSettings(
                object,
                enabled,
                maxAllowedMemberships,
                maxAllowedRoles,
                maxAllowedPermissions,
                creatorRole,
                adminDeleteEnabled,
                domainsEnabled,
                domainsEnrollmentModes,
                domainsDefaultRole);
        }
    }
}
