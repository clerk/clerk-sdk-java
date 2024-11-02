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
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Objects;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;


public class CreateOrganizationInvitationRequestBody {

    /**
     * The email address of the new member that is going to be invited to the organization
     */
    @JsonProperty("email_address")
    private String emailAddress;

    /**
     * The ID of the user that invites the new member to the organization.
     * Must be an administrator in the organization.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("inviter_user_id")
    private JsonNullable<String> inviterUserId;

    /**
     * The role of the new member in the organization
     */
    @JsonProperty("role")
    private String role;

    /**
     * Metadata saved on the organization invitation, read-only from the Frontend API and fully accessible (read/write) from the Backend API.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("public_metadata")
    private Optional<? extends CreateOrganizationInvitationPublicMetadata> publicMetadata;

    /**
     * Metadata saved on the organization invitation, fully accessible (read/write) from the Backend API but not visible from the Frontend API.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("private_metadata")
    private Optional<? extends CreateOrganizationInvitationPrivateMetadata> privateMetadata;

    /**
     * Optional URL that the invitee will be redirected to once they accept the invitation by clicking the join link in the invitation email.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("redirect_url")
    private Optional<String> redirectUrl;

    @JsonCreator
    public CreateOrganizationInvitationRequestBody(
            @JsonProperty("email_address") String emailAddress,
            @JsonProperty("inviter_user_id") JsonNullable<String> inviterUserId,
            @JsonProperty("role") String role,
            @JsonProperty("public_metadata") Optional<? extends CreateOrganizationInvitationPublicMetadata> publicMetadata,
            @JsonProperty("private_metadata") Optional<? extends CreateOrganizationInvitationPrivateMetadata> privateMetadata,
            @JsonProperty("redirect_url") Optional<String> redirectUrl) {
        Utils.checkNotNull(emailAddress, "emailAddress");
        Utils.checkNotNull(inviterUserId, "inviterUserId");
        Utils.checkNotNull(role, "role");
        Utils.checkNotNull(publicMetadata, "publicMetadata");
        Utils.checkNotNull(privateMetadata, "privateMetadata");
        Utils.checkNotNull(redirectUrl, "redirectUrl");
        this.emailAddress = emailAddress;
        this.inviterUserId = inviterUserId;
        this.role = role;
        this.publicMetadata = publicMetadata;
        this.privateMetadata = privateMetadata;
        this.redirectUrl = redirectUrl;
    }
    
    public CreateOrganizationInvitationRequestBody(
            String emailAddress,
            String role) {
        this(emailAddress, JsonNullable.undefined(), role, Optional.empty(), Optional.empty(), Optional.empty());
    }

    /**
     * The email address of the new member that is going to be invited to the organization
     */
    @JsonIgnore
    public String emailAddress() {
        return emailAddress;
    }

    /**
     * The ID of the user that invites the new member to the organization.
     * Must be an administrator in the organization.
     */
    @JsonIgnore
    public JsonNullable<String> inviterUserId() {
        return inviterUserId;
    }

    /**
     * The role of the new member in the organization
     */
    @JsonIgnore
    public String role() {
        return role;
    }

    /**
     * Metadata saved on the organization invitation, read-only from the Frontend API and fully accessible (read/write) from the Backend API.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<CreateOrganizationInvitationPublicMetadata> publicMetadata() {
        return (Optional<CreateOrganizationInvitationPublicMetadata>) publicMetadata;
    }

    /**
     * Metadata saved on the organization invitation, fully accessible (read/write) from the Backend API but not visible from the Frontend API.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<CreateOrganizationInvitationPrivateMetadata> privateMetadata() {
        return (Optional<CreateOrganizationInvitationPrivateMetadata>) privateMetadata;
    }

    /**
     * Optional URL that the invitee will be redirected to once they accept the invitation by clicking the join link in the invitation email.
     */
    @JsonIgnore
    public Optional<String> redirectUrl() {
        return redirectUrl;
    }

    public final static Builder builder() {
        return new Builder();
    }

    /**
     * The email address of the new member that is going to be invited to the organization
     */
    public CreateOrganizationInvitationRequestBody withEmailAddress(String emailAddress) {
        Utils.checkNotNull(emailAddress, "emailAddress");
        this.emailAddress = emailAddress;
        return this;
    }

    /**
     * The ID of the user that invites the new member to the organization.
     * Must be an administrator in the organization.
     */
    public CreateOrganizationInvitationRequestBody withInviterUserId(String inviterUserId) {
        Utils.checkNotNull(inviterUserId, "inviterUserId");
        this.inviterUserId = JsonNullable.of(inviterUserId);
        return this;
    }

    /**
     * The ID of the user that invites the new member to the organization.
     * Must be an administrator in the organization.
     */
    public CreateOrganizationInvitationRequestBody withInviterUserId(JsonNullable<String> inviterUserId) {
        Utils.checkNotNull(inviterUserId, "inviterUserId");
        this.inviterUserId = inviterUserId;
        return this;
    }

    /**
     * The role of the new member in the organization
     */
    public CreateOrganizationInvitationRequestBody withRole(String role) {
        Utils.checkNotNull(role, "role");
        this.role = role;
        return this;
    }

    /**
     * Metadata saved on the organization invitation, read-only from the Frontend API and fully accessible (read/write) from the Backend API.
     */
    public CreateOrganizationInvitationRequestBody withPublicMetadata(CreateOrganizationInvitationPublicMetadata publicMetadata) {
        Utils.checkNotNull(publicMetadata, "publicMetadata");
        this.publicMetadata = Optional.ofNullable(publicMetadata);
        return this;
    }

    /**
     * Metadata saved on the organization invitation, read-only from the Frontend API and fully accessible (read/write) from the Backend API.
     */
    public CreateOrganizationInvitationRequestBody withPublicMetadata(Optional<? extends CreateOrganizationInvitationPublicMetadata> publicMetadata) {
        Utils.checkNotNull(publicMetadata, "publicMetadata");
        this.publicMetadata = publicMetadata;
        return this;
    }

    /**
     * Metadata saved on the organization invitation, fully accessible (read/write) from the Backend API but not visible from the Frontend API.
     */
    public CreateOrganizationInvitationRequestBody withPrivateMetadata(CreateOrganizationInvitationPrivateMetadata privateMetadata) {
        Utils.checkNotNull(privateMetadata, "privateMetadata");
        this.privateMetadata = Optional.ofNullable(privateMetadata);
        return this;
    }

    /**
     * Metadata saved on the organization invitation, fully accessible (read/write) from the Backend API but not visible from the Frontend API.
     */
    public CreateOrganizationInvitationRequestBody withPrivateMetadata(Optional<? extends CreateOrganizationInvitationPrivateMetadata> privateMetadata) {
        Utils.checkNotNull(privateMetadata, "privateMetadata");
        this.privateMetadata = privateMetadata;
        return this;
    }

    /**
     * Optional URL that the invitee will be redirected to once they accept the invitation by clicking the join link in the invitation email.
     */
    public CreateOrganizationInvitationRequestBody withRedirectUrl(String redirectUrl) {
        Utils.checkNotNull(redirectUrl, "redirectUrl");
        this.redirectUrl = Optional.ofNullable(redirectUrl);
        return this;
    }

    /**
     * Optional URL that the invitee will be redirected to once they accept the invitation by clicking the join link in the invitation email.
     */
    public CreateOrganizationInvitationRequestBody withRedirectUrl(Optional<String> redirectUrl) {
        Utils.checkNotNull(redirectUrl, "redirectUrl");
        this.redirectUrl = redirectUrl;
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
        CreateOrganizationInvitationRequestBody other = (CreateOrganizationInvitationRequestBody) o;
        return 
            Objects.deepEquals(this.emailAddress, other.emailAddress) &&
            Objects.deepEquals(this.inviterUserId, other.inviterUserId) &&
            Objects.deepEquals(this.role, other.role) &&
            Objects.deepEquals(this.publicMetadata, other.publicMetadata) &&
            Objects.deepEquals(this.privateMetadata, other.privateMetadata) &&
            Objects.deepEquals(this.redirectUrl, other.redirectUrl);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            emailAddress,
            inviterUserId,
            role,
            publicMetadata,
            privateMetadata,
            redirectUrl);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CreateOrganizationInvitationRequestBody.class,
                "emailAddress", emailAddress,
                "inviterUserId", inviterUserId,
                "role", role,
                "publicMetadata", publicMetadata,
                "privateMetadata", privateMetadata,
                "redirectUrl", redirectUrl);
    }
    
    public final static class Builder {
 
        private String emailAddress;
 
        private JsonNullable<String> inviterUserId = JsonNullable.undefined();
 
        private String role;
 
        private Optional<? extends CreateOrganizationInvitationPublicMetadata> publicMetadata = Optional.empty();
 
        private Optional<? extends CreateOrganizationInvitationPrivateMetadata> privateMetadata = Optional.empty();
 
        private Optional<String> redirectUrl = Optional.empty();  
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * The email address of the new member that is going to be invited to the organization
         */
        public Builder emailAddress(String emailAddress) {
            Utils.checkNotNull(emailAddress, "emailAddress");
            this.emailAddress = emailAddress;
            return this;
        }

        /**
         * The ID of the user that invites the new member to the organization.
         * Must be an administrator in the organization.
         */
        public Builder inviterUserId(String inviterUserId) {
            Utils.checkNotNull(inviterUserId, "inviterUserId");
            this.inviterUserId = JsonNullable.of(inviterUserId);
            return this;
        }

        /**
         * The ID of the user that invites the new member to the organization.
         * Must be an administrator in the organization.
         */
        public Builder inviterUserId(JsonNullable<String> inviterUserId) {
            Utils.checkNotNull(inviterUserId, "inviterUserId");
            this.inviterUserId = inviterUserId;
            return this;
        }

        /**
         * The role of the new member in the organization
         */
        public Builder role(String role) {
            Utils.checkNotNull(role, "role");
            this.role = role;
            return this;
        }

        /**
         * Metadata saved on the organization invitation, read-only from the Frontend API and fully accessible (read/write) from the Backend API.
         */
        public Builder publicMetadata(CreateOrganizationInvitationPublicMetadata publicMetadata) {
            Utils.checkNotNull(publicMetadata, "publicMetadata");
            this.publicMetadata = Optional.ofNullable(publicMetadata);
            return this;
        }

        /**
         * Metadata saved on the organization invitation, read-only from the Frontend API and fully accessible (read/write) from the Backend API.
         */
        public Builder publicMetadata(Optional<? extends CreateOrganizationInvitationPublicMetadata> publicMetadata) {
            Utils.checkNotNull(publicMetadata, "publicMetadata");
            this.publicMetadata = publicMetadata;
            return this;
        }

        /**
         * Metadata saved on the organization invitation, fully accessible (read/write) from the Backend API but not visible from the Frontend API.
         */
        public Builder privateMetadata(CreateOrganizationInvitationPrivateMetadata privateMetadata) {
            Utils.checkNotNull(privateMetadata, "privateMetadata");
            this.privateMetadata = Optional.ofNullable(privateMetadata);
            return this;
        }

        /**
         * Metadata saved on the organization invitation, fully accessible (read/write) from the Backend API but not visible from the Frontend API.
         */
        public Builder privateMetadata(Optional<? extends CreateOrganizationInvitationPrivateMetadata> privateMetadata) {
            Utils.checkNotNull(privateMetadata, "privateMetadata");
            this.privateMetadata = privateMetadata;
            return this;
        }

        /**
         * Optional URL that the invitee will be redirected to once they accept the invitation by clicking the join link in the invitation email.
         */
        public Builder redirectUrl(String redirectUrl) {
            Utils.checkNotNull(redirectUrl, "redirectUrl");
            this.redirectUrl = Optional.ofNullable(redirectUrl);
            return this;
        }

        /**
         * Optional URL that the invitee will be redirected to once they accept the invitation by clicking the join link in the invitation email.
         */
        public Builder redirectUrl(Optional<String> redirectUrl) {
            Utils.checkNotNull(redirectUrl, "redirectUrl");
            this.redirectUrl = redirectUrl;
            return this;
        }
        
        public CreateOrganizationInvitationRequestBody build() {
            return new CreateOrganizationInvitationRequestBody(
                emailAddress,
                inviterUserId,
                role,
                publicMetadata,
                privateMetadata,
                redirectUrl);
        }
    }
}

