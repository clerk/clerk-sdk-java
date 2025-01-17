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
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Objects;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;

/**
 * OrganizationDomain - An organization domain
 */

public class OrganizationDomain {

    /**
     * Unique identifier for the organization domain
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("id")
    private Optional<String> id;

    /**
     * String representing the object's type. Objects of the same type share the same value. Always `organization_domain`
     * 
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("object")
    private Optional<? extends OrganizationDomainObject> object;

    /**
     * Unique identifier for the organization
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("organization_id")
    private Optional<String> organizationId;

    /**
     * Name of the organization domain
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("name")
    private Optional<String> name;

    /**
     * Mode of enrollment for the domain
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("enrollment_mode")
    private Optional<? extends EnrollmentMode> enrollmentMode;

    /**
     * Affiliation email address for the domain, if available.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("affiliation_email_address")
    private JsonNullable<String> affiliationEmailAddress;

    /**
     * Verification details for the domain
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("verification")
    private JsonNullable<? extends OrganizationDomainVerification> verification;

    /**
     * Total number of pending invitations associated with this domain
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("total_pending_invitations")
    private Optional<Integer> totalPendingInvitations;

    /**
     * Total number of pending suggestions associated with this domain
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("total_pending_suggestions")
    private Optional<Integer> totalPendingSuggestions;

    /**
     * Unix timestamp when the domain was created
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("created_at")
    private Optional<Long> createdAt;

    /**
     * Unix timestamp of the last update to the domain
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("updated_at")
    private Optional<Long> updatedAt;

    @JsonCreator
    public OrganizationDomain(
            @JsonProperty("id") Optional<String> id,
            @JsonProperty("object") Optional<? extends OrganizationDomainObject> object,
            @JsonProperty("organization_id") Optional<String> organizationId,
            @JsonProperty("name") Optional<String> name,
            @JsonProperty("enrollment_mode") Optional<? extends EnrollmentMode> enrollmentMode,
            @JsonProperty("affiliation_email_address") JsonNullable<String> affiliationEmailAddress,
            @JsonProperty("verification") JsonNullable<? extends OrganizationDomainVerification> verification,
            @JsonProperty("total_pending_invitations") Optional<Integer> totalPendingInvitations,
            @JsonProperty("total_pending_suggestions") Optional<Integer> totalPendingSuggestions,
            @JsonProperty("created_at") Optional<Long> createdAt,
            @JsonProperty("updated_at") Optional<Long> updatedAt) {
        Utils.checkNotNull(id, "id");
        Utils.checkNotNull(object, "object");
        Utils.checkNotNull(organizationId, "organizationId");
        Utils.checkNotNull(name, "name");
        Utils.checkNotNull(enrollmentMode, "enrollmentMode");
        Utils.checkNotNull(affiliationEmailAddress, "affiliationEmailAddress");
        Utils.checkNotNull(verification, "verification");
        Utils.checkNotNull(totalPendingInvitations, "totalPendingInvitations");
        Utils.checkNotNull(totalPendingSuggestions, "totalPendingSuggestions");
        Utils.checkNotNull(createdAt, "createdAt");
        Utils.checkNotNull(updatedAt, "updatedAt");
        this.id = id;
        this.object = object;
        this.organizationId = organizationId;
        this.name = name;
        this.enrollmentMode = enrollmentMode;
        this.affiliationEmailAddress = affiliationEmailAddress;
        this.verification = verification;
        this.totalPendingInvitations = totalPendingInvitations;
        this.totalPendingSuggestions = totalPendingSuggestions;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    public OrganizationDomain() {
        this(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), JsonNullable.undefined(), JsonNullable.undefined(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty());
    }

    /**
     * Unique identifier for the organization domain
     */
    @JsonIgnore
    public Optional<String> id() {
        return id;
    }

    /**
     * String representing the object's type. Objects of the same type share the same value. Always `organization_domain`
     * 
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<OrganizationDomainObject> object() {
        return (Optional<OrganizationDomainObject>) object;
    }

    /**
     * Unique identifier for the organization
     */
    @JsonIgnore
    public Optional<String> organizationId() {
        return organizationId;
    }

    /**
     * Name of the organization domain
     */
    @JsonIgnore
    public Optional<String> name() {
        return name;
    }

    /**
     * Mode of enrollment for the domain
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<EnrollmentMode> enrollmentMode() {
        return (Optional<EnrollmentMode>) enrollmentMode;
    }

    /**
     * Affiliation email address for the domain, if available.
     */
    @JsonIgnore
    public JsonNullable<String> affiliationEmailAddress() {
        return affiliationEmailAddress;
    }

    /**
     * Verification details for the domain
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<OrganizationDomainVerification> verification() {
        return (JsonNullable<OrganizationDomainVerification>) verification;
    }

    /**
     * Total number of pending invitations associated with this domain
     */
    @JsonIgnore
    public Optional<Integer> totalPendingInvitations() {
        return totalPendingInvitations;
    }

    /**
     * Total number of pending suggestions associated with this domain
     */
    @JsonIgnore
    public Optional<Integer> totalPendingSuggestions() {
        return totalPendingSuggestions;
    }

    /**
     * Unix timestamp when the domain was created
     */
    @JsonIgnore
    public Optional<Long> createdAt() {
        return createdAt;
    }

    /**
     * Unix timestamp of the last update to the domain
     */
    @JsonIgnore
    public Optional<Long> updatedAt() {
        return updatedAt;
    }

    public final static Builder builder() {
        return new Builder();
    }

    /**
     * Unique identifier for the organization domain
     */
    public OrganizationDomain withId(String id) {
        Utils.checkNotNull(id, "id");
        this.id = Optional.ofNullable(id);
        return this;
    }

    /**
     * Unique identifier for the organization domain
     */
    public OrganizationDomain withId(Optional<String> id) {
        Utils.checkNotNull(id, "id");
        this.id = id;
        return this;
    }

    /**
     * String representing the object's type. Objects of the same type share the same value. Always `organization_domain`
     * 
     */
    public OrganizationDomain withObject(OrganizationDomainObject object) {
        Utils.checkNotNull(object, "object");
        this.object = Optional.ofNullable(object);
        return this;
    }

    /**
     * String representing the object's type. Objects of the same type share the same value. Always `organization_domain`
     * 
     */
    public OrganizationDomain withObject(Optional<? extends OrganizationDomainObject> object) {
        Utils.checkNotNull(object, "object");
        this.object = object;
        return this;
    }

    /**
     * Unique identifier for the organization
     */
    public OrganizationDomain withOrganizationId(String organizationId) {
        Utils.checkNotNull(organizationId, "organizationId");
        this.organizationId = Optional.ofNullable(organizationId);
        return this;
    }

    /**
     * Unique identifier for the organization
     */
    public OrganizationDomain withOrganizationId(Optional<String> organizationId) {
        Utils.checkNotNull(organizationId, "organizationId");
        this.organizationId = organizationId;
        return this;
    }

    /**
     * Name of the organization domain
     */
    public OrganizationDomain withName(String name) {
        Utils.checkNotNull(name, "name");
        this.name = Optional.ofNullable(name);
        return this;
    }

    /**
     * Name of the organization domain
     */
    public OrganizationDomain withName(Optional<String> name) {
        Utils.checkNotNull(name, "name");
        this.name = name;
        return this;
    }

    /**
     * Mode of enrollment for the domain
     */
    public OrganizationDomain withEnrollmentMode(EnrollmentMode enrollmentMode) {
        Utils.checkNotNull(enrollmentMode, "enrollmentMode");
        this.enrollmentMode = Optional.ofNullable(enrollmentMode);
        return this;
    }

    /**
     * Mode of enrollment for the domain
     */
    public OrganizationDomain withEnrollmentMode(Optional<? extends EnrollmentMode> enrollmentMode) {
        Utils.checkNotNull(enrollmentMode, "enrollmentMode");
        this.enrollmentMode = enrollmentMode;
        return this;
    }

    /**
     * Affiliation email address for the domain, if available.
     */
    public OrganizationDomain withAffiliationEmailAddress(String affiliationEmailAddress) {
        Utils.checkNotNull(affiliationEmailAddress, "affiliationEmailAddress");
        this.affiliationEmailAddress = JsonNullable.of(affiliationEmailAddress);
        return this;
    }

    /**
     * Affiliation email address for the domain, if available.
     */
    public OrganizationDomain withAffiliationEmailAddress(JsonNullable<String> affiliationEmailAddress) {
        Utils.checkNotNull(affiliationEmailAddress, "affiliationEmailAddress");
        this.affiliationEmailAddress = affiliationEmailAddress;
        return this;
    }

    /**
     * Verification details for the domain
     */
    public OrganizationDomain withVerification(OrganizationDomainVerification verification) {
        Utils.checkNotNull(verification, "verification");
        this.verification = JsonNullable.of(verification);
        return this;
    }

    /**
     * Verification details for the domain
     */
    public OrganizationDomain withVerification(JsonNullable<? extends OrganizationDomainVerification> verification) {
        Utils.checkNotNull(verification, "verification");
        this.verification = verification;
        return this;
    }

    /**
     * Total number of pending invitations associated with this domain
     */
    public OrganizationDomain withTotalPendingInvitations(int totalPendingInvitations) {
        Utils.checkNotNull(totalPendingInvitations, "totalPendingInvitations");
        this.totalPendingInvitations = Optional.ofNullable(totalPendingInvitations);
        return this;
    }

    /**
     * Total number of pending invitations associated with this domain
     */
    public OrganizationDomain withTotalPendingInvitations(Optional<Integer> totalPendingInvitations) {
        Utils.checkNotNull(totalPendingInvitations, "totalPendingInvitations");
        this.totalPendingInvitations = totalPendingInvitations;
        return this;
    }

    /**
     * Total number of pending suggestions associated with this domain
     */
    public OrganizationDomain withTotalPendingSuggestions(int totalPendingSuggestions) {
        Utils.checkNotNull(totalPendingSuggestions, "totalPendingSuggestions");
        this.totalPendingSuggestions = Optional.ofNullable(totalPendingSuggestions);
        return this;
    }

    /**
     * Total number of pending suggestions associated with this domain
     */
    public OrganizationDomain withTotalPendingSuggestions(Optional<Integer> totalPendingSuggestions) {
        Utils.checkNotNull(totalPendingSuggestions, "totalPendingSuggestions");
        this.totalPendingSuggestions = totalPendingSuggestions;
        return this;
    }

    /**
     * Unix timestamp when the domain was created
     */
    public OrganizationDomain withCreatedAt(long createdAt) {
        Utils.checkNotNull(createdAt, "createdAt");
        this.createdAt = Optional.ofNullable(createdAt);
        return this;
    }

    /**
     * Unix timestamp when the domain was created
     */
    public OrganizationDomain withCreatedAt(Optional<Long> createdAt) {
        Utils.checkNotNull(createdAt, "createdAt");
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Unix timestamp of the last update to the domain
     */
    public OrganizationDomain withUpdatedAt(long updatedAt) {
        Utils.checkNotNull(updatedAt, "updatedAt");
        this.updatedAt = Optional.ofNullable(updatedAt);
        return this;
    }

    /**
     * Unix timestamp of the last update to the domain
     */
    public OrganizationDomain withUpdatedAt(Optional<Long> updatedAt) {
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
        OrganizationDomain other = (OrganizationDomain) o;
        return 
            Objects.deepEquals(this.id, other.id) &&
            Objects.deepEquals(this.object, other.object) &&
            Objects.deepEquals(this.organizationId, other.organizationId) &&
            Objects.deepEquals(this.name, other.name) &&
            Objects.deepEquals(this.enrollmentMode, other.enrollmentMode) &&
            Objects.deepEquals(this.affiliationEmailAddress, other.affiliationEmailAddress) &&
            Objects.deepEquals(this.verification, other.verification) &&
            Objects.deepEquals(this.totalPendingInvitations, other.totalPendingInvitations) &&
            Objects.deepEquals(this.totalPendingSuggestions, other.totalPendingSuggestions) &&
            Objects.deepEquals(this.createdAt, other.createdAt) &&
            Objects.deepEquals(this.updatedAt, other.updatedAt);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            object,
            organizationId,
            name,
            enrollmentMode,
            affiliationEmailAddress,
            verification,
            totalPendingInvitations,
            totalPendingSuggestions,
            createdAt,
            updatedAt);
    }
    
    @Override
    public String toString() {
        return Utils.toString(OrganizationDomain.class,
                "id", id,
                "object", object,
                "organizationId", organizationId,
                "name", name,
                "enrollmentMode", enrollmentMode,
                "affiliationEmailAddress", affiliationEmailAddress,
                "verification", verification,
                "totalPendingInvitations", totalPendingInvitations,
                "totalPendingSuggestions", totalPendingSuggestions,
                "createdAt", createdAt,
                "updatedAt", updatedAt);
    }
    
    public final static class Builder {
 
        private Optional<String> id = Optional.empty();
 
        private Optional<? extends OrganizationDomainObject> object = Optional.empty();
 
        private Optional<String> organizationId = Optional.empty();
 
        private Optional<String> name = Optional.empty();
 
        private Optional<? extends EnrollmentMode> enrollmentMode = Optional.empty();
 
        private JsonNullable<String> affiliationEmailAddress = JsonNullable.undefined();
 
        private JsonNullable<? extends OrganizationDomainVerification> verification = JsonNullable.undefined();
 
        private Optional<Integer> totalPendingInvitations = Optional.empty();
 
        private Optional<Integer> totalPendingSuggestions = Optional.empty();
 
        private Optional<Long> createdAt = Optional.empty();
 
        private Optional<Long> updatedAt = Optional.empty();  
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * Unique identifier for the organization domain
         */
        public Builder id(String id) {
            Utils.checkNotNull(id, "id");
            this.id = Optional.ofNullable(id);
            return this;
        }

        /**
         * Unique identifier for the organization domain
         */
        public Builder id(Optional<String> id) {
            Utils.checkNotNull(id, "id");
            this.id = id;
            return this;
        }

        /**
         * String representing the object's type. Objects of the same type share the same value. Always `organization_domain`
         * 
         */
        public Builder object(OrganizationDomainObject object) {
            Utils.checkNotNull(object, "object");
            this.object = Optional.ofNullable(object);
            return this;
        }

        /**
         * String representing the object's type. Objects of the same type share the same value. Always `organization_domain`
         * 
         */
        public Builder object(Optional<? extends OrganizationDomainObject> object) {
            Utils.checkNotNull(object, "object");
            this.object = object;
            return this;
        }

        /**
         * Unique identifier for the organization
         */
        public Builder organizationId(String organizationId) {
            Utils.checkNotNull(organizationId, "organizationId");
            this.organizationId = Optional.ofNullable(organizationId);
            return this;
        }

        /**
         * Unique identifier for the organization
         */
        public Builder organizationId(Optional<String> organizationId) {
            Utils.checkNotNull(organizationId, "organizationId");
            this.organizationId = organizationId;
            return this;
        }

        /**
         * Name of the organization domain
         */
        public Builder name(String name) {
            Utils.checkNotNull(name, "name");
            this.name = Optional.ofNullable(name);
            return this;
        }

        /**
         * Name of the organization domain
         */
        public Builder name(Optional<String> name) {
            Utils.checkNotNull(name, "name");
            this.name = name;
            return this;
        }

        /**
         * Mode of enrollment for the domain
         */
        public Builder enrollmentMode(EnrollmentMode enrollmentMode) {
            Utils.checkNotNull(enrollmentMode, "enrollmentMode");
            this.enrollmentMode = Optional.ofNullable(enrollmentMode);
            return this;
        }

        /**
         * Mode of enrollment for the domain
         */
        public Builder enrollmentMode(Optional<? extends EnrollmentMode> enrollmentMode) {
            Utils.checkNotNull(enrollmentMode, "enrollmentMode");
            this.enrollmentMode = enrollmentMode;
            return this;
        }

        /**
         * Affiliation email address for the domain, if available.
         */
        public Builder affiliationEmailAddress(String affiliationEmailAddress) {
            Utils.checkNotNull(affiliationEmailAddress, "affiliationEmailAddress");
            this.affiliationEmailAddress = JsonNullable.of(affiliationEmailAddress);
            return this;
        }

        /**
         * Affiliation email address for the domain, if available.
         */
        public Builder affiliationEmailAddress(JsonNullable<String> affiliationEmailAddress) {
            Utils.checkNotNull(affiliationEmailAddress, "affiliationEmailAddress");
            this.affiliationEmailAddress = affiliationEmailAddress;
            return this;
        }

        /**
         * Verification details for the domain
         */
        public Builder verification(OrganizationDomainVerification verification) {
            Utils.checkNotNull(verification, "verification");
            this.verification = JsonNullable.of(verification);
            return this;
        }

        /**
         * Verification details for the domain
         */
        public Builder verification(JsonNullable<? extends OrganizationDomainVerification> verification) {
            Utils.checkNotNull(verification, "verification");
            this.verification = verification;
            return this;
        }

        /**
         * Total number of pending invitations associated with this domain
         */
        public Builder totalPendingInvitations(int totalPendingInvitations) {
            Utils.checkNotNull(totalPendingInvitations, "totalPendingInvitations");
            this.totalPendingInvitations = Optional.ofNullable(totalPendingInvitations);
            return this;
        }

        /**
         * Total number of pending invitations associated with this domain
         */
        public Builder totalPendingInvitations(Optional<Integer> totalPendingInvitations) {
            Utils.checkNotNull(totalPendingInvitations, "totalPendingInvitations");
            this.totalPendingInvitations = totalPendingInvitations;
            return this;
        }

        /**
         * Total number of pending suggestions associated with this domain
         */
        public Builder totalPendingSuggestions(int totalPendingSuggestions) {
            Utils.checkNotNull(totalPendingSuggestions, "totalPendingSuggestions");
            this.totalPendingSuggestions = Optional.ofNullable(totalPendingSuggestions);
            return this;
        }

        /**
         * Total number of pending suggestions associated with this domain
         */
        public Builder totalPendingSuggestions(Optional<Integer> totalPendingSuggestions) {
            Utils.checkNotNull(totalPendingSuggestions, "totalPendingSuggestions");
            this.totalPendingSuggestions = totalPendingSuggestions;
            return this;
        }

        /**
         * Unix timestamp when the domain was created
         */
        public Builder createdAt(long createdAt) {
            Utils.checkNotNull(createdAt, "createdAt");
            this.createdAt = Optional.ofNullable(createdAt);
            return this;
        }

        /**
         * Unix timestamp when the domain was created
         */
        public Builder createdAt(Optional<Long> createdAt) {
            Utils.checkNotNull(createdAt, "createdAt");
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Unix timestamp of the last update to the domain
         */
        public Builder updatedAt(long updatedAt) {
            Utils.checkNotNull(updatedAt, "updatedAt");
            this.updatedAt = Optional.ofNullable(updatedAt);
            return this;
        }

        /**
         * Unix timestamp of the last update to the domain
         */
        public Builder updatedAt(Optional<Long> updatedAt) {
            Utils.checkNotNull(updatedAt, "updatedAt");
            this.updatedAt = updatedAt;
            return this;
        }
        
        public OrganizationDomain build() {
            return new OrganizationDomain(
                id,
                object,
                organizationId,
                name,
                enrollmentMode,
                affiliationEmailAddress,
                verification,
                totalPendingInvitations,
                totalPendingSuggestions,
                createdAt,
                updatedAt);
        }
    }
}

