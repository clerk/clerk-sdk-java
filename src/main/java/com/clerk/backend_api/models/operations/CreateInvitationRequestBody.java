/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.operations;


import com.clerk.backend_api.utils.LazySingletonValue;
import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Objects;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;

/**
 * CreateInvitationRequestBody - Required parameters
 */

public class CreateInvitationRequestBody {

    /**
     * The email address the invitation will be sent to
     */
    @JsonProperty("email_address")
    private String emailAddress;

    /**
     * Metadata that will be attached to the newly created invitation.
     * The value of this property should be a well-formed JSON object.
     * Once the user accepts the invitation and signs up, these metadata will end up in the user's public metadata.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("public_metadata")
    private Optional<? extends CreateInvitationPublicMetadata> publicMetadata;

    /**
     * Optional URL which specifies where to redirect the user once they click the invitation link.
     * This is only required if you have implemented a [custom flow](https://clerk.com/docs/authentication/invitations#custom-flow) and you're not using Clerk Hosted Pages or Clerk Components.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("redirect_url")
    private Optional<String> redirectUrl;

    /**
     * Optional flag which denotes whether an email invitation should be sent to the given email address.
     * Defaults to true.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("notify")
    private JsonNullable<Boolean> notify_;

    /**
     * Whether an invitation should be created if there is already an existing invitation for this email address, or it's claimed by another user.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("ignore_existing")
    private JsonNullable<Boolean> ignoreExisting;

    /**
     * The number of days the invitation will be valid for. By default, the invitation does not expire.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("expires_in_days")
    private JsonNullable<Long> expiresInDays;

    @JsonCreator
    public CreateInvitationRequestBody(
            @JsonProperty("email_address") String emailAddress,
            @JsonProperty("public_metadata") Optional<? extends CreateInvitationPublicMetadata> publicMetadata,
            @JsonProperty("redirect_url") Optional<String> redirectUrl,
            @JsonProperty("notify") JsonNullable<Boolean> notify_,
            @JsonProperty("ignore_existing") JsonNullable<Boolean> ignoreExisting,
            @JsonProperty("expires_in_days") JsonNullable<Long> expiresInDays) {
        Utils.checkNotNull(emailAddress, "emailAddress");
        Utils.checkNotNull(publicMetadata, "publicMetadata");
        Utils.checkNotNull(redirectUrl, "redirectUrl");
        Utils.checkNotNull(notify_, "notify_");
        Utils.checkNotNull(ignoreExisting, "ignoreExisting");
        Utils.checkNotNull(expiresInDays, "expiresInDays");
        this.emailAddress = emailAddress;
        this.publicMetadata = publicMetadata;
        this.redirectUrl = redirectUrl;
        this.notify_ = notify_;
        this.ignoreExisting = ignoreExisting;
        this.expiresInDays = expiresInDays;
    }
    
    public CreateInvitationRequestBody(
            String emailAddress) {
        this(emailAddress, Optional.empty(), Optional.empty(), JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined());
    }

    /**
     * The email address the invitation will be sent to
     */
    @JsonIgnore
    public String emailAddress() {
        return emailAddress;
    }

    /**
     * Metadata that will be attached to the newly created invitation.
     * The value of this property should be a well-formed JSON object.
     * Once the user accepts the invitation and signs up, these metadata will end up in the user's public metadata.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<CreateInvitationPublicMetadata> publicMetadata() {
        return (Optional<CreateInvitationPublicMetadata>) publicMetadata;
    }

    /**
     * Optional URL which specifies where to redirect the user once they click the invitation link.
     * This is only required if you have implemented a [custom flow](https://clerk.com/docs/authentication/invitations#custom-flow) and you're not using Clerk Hosted Pages or Clerk Components.
     */
    @JsonIgnore
    public Optional<String> redirectUrl() {
        return redirectUrl;
    }

    /**
     * Optional flag which denotes whether an email invitation should be sent to the given email address.
     * Defaults to true.
     */
    @JsonIgnore
    public JsonNullable<Boolean> notify_() {
        return notify_;
    }

    /**
     * Whether an invitation should be created if there is already an existing invitation for this email address, or it's claimed by another user.
     */
    @JsonIgnore
    public JsonNullable<Boolean> ignoreExisting() {
        return ignoreExisting;
    }

    /**
     * The number of days the invitation will be valid for. By default, the invitation does not expire.
     */
    @JsonIgnore
    public JsonNullable<Long> expiresInDays() {
        return expiresInDays;
    }

    public final static Builder builder() {
        return new Builder();
    }

    /**
     * The email address the invitation will be sent to
     */
    public CreateInvitationRequestBody withEmailAddress(String emailAddress) {
        Utils.checkNotNull(emailAddress, "emailAddress");
        this.emailAddress = emailAddress;
        return this;
    }

    /**
     * Metadata that will be attached to the newly created invitation.
     * The value of this property should be a well-formed JSON object.
     * Once the user accepts the invitation and signs up, these metadata will end up in the user's public metadata.
     */
    public CreateInvitationRequestBody withPublicMetadata(CreateInvitationPublicMetadata publicMetadata) {
        Utils.checkNotNull(publicMetadata, "publicMetadata");
        this.publicMetadata = Optional.ofNullable(publicMetadata);
        return this;
    }

    /**
     * Metadata that will be attached to the newly created invitation.
     * The value of this property should be a well-formed JSON object.
     * Once the user accepts the invitation and signs up, these metadata will end up in the user's public metadata.
     */
    public CreateInvitationRequestBody withPublicMetadata(Optional<? extends CreateInvitationPublicMetadata> publicMetadata) {
        Utils.checkNotNull(publicMetadata, "publicMetadata");
        this.publicMetadata = publicMetadata;
        return this;
    }

    /**
     * Optional URL which specifies where to redirect the user once they click the invitation link.
     * This is only required if you have implemented a [custom flow](https://clerk.com/docs/authentication/invitations#custom-flow) and you're not using Clerk Hosted Pages or Clerk Components.
     */
    public CreateInvitationRequestBody withRedirectUrl(String redirectUrl) {
        Utils.checkNotNull(redirectUrl, "redirectUrl");
        this.redirectUrl = Optional.ofNullable(redirectUrl);
        return this;
    }

    /**
     * Optional URL which specifies where to redirect the user once they click the invitation link.
     * This is only required if you have implemented a [custom flow](https://clerk.com/docs/authentication/invitations#custom-flow) and you're not using Clerk Hosted Pages or Clerk Components.
     */
    public CreateInvitationRequestBody withRedirectUrl(Optional<String> redirectUrl) {
        Utils.checkNotNull(redirectUrl, "redirectUrl");
        this.redirectUrl = redirectUrl;
        return this;
    }

    /**
     * Optional flag which denotes whether an email invitation should be sent to the given email address.
     * Defaults to true.
     */
    public CreateInvitationRequestBody withNotify(boolean notify_) {
        Utils.checkNotNull(notify_, "notify_");
        this.notify_ = JsonNullable.of(notify_);
        return this;
    }

    /**
     * Optional flag which denotes whether an email invitation should be sent to the given email address.
     * Defaults to true.
     */
    public CreateInvitationRequestBody withNotify(JsonNullable<Boolean> notify_) {
        Utils.checkNotNull(notify_, "notify_");
        this.notify_ = notify_;
        return this;
    }

    /**
     * Whether an invitation should be created if there is already an existing invitation for this email address, or it's claimed by another user.
     */
    public CreateInvitationRequestBody withIgnoreExisting(boolean ignoreExisting) {
        Utils.checkNotNull(ignoreExisting, "ignoreExisting");
        this.ignoreExisting = JsonNullable.of(ignoreExisting);
        return this;
    }

    /**
     * Whether an invitation should be created if there is already an existing invitation for this email address, or it's claimed by another user.
     */
    public CreateInvitationRequestBody withIgnoreExisting(JsonNullable<Boolean> ignoreExisting) {
        Utils.checkNotNull(ignoreExisting, "ignoreExisting");
        this.ignoreExisting = ignoreExisting;
        return this;
    }

    /**
     * The number of days the invitation will be valid for. By default, the invitation does not expire.
     */
    public CreateInvitationRequestBody withExpiresInDays(long expiresInDays) {
        Utils.checkNotNull(expiresInDays, "expiresInDays");
        this.expiresInDays = JsonNullable.of(expiresInDays);
        return this;
    }

    /**
     * The number of days the invitation will be valid for. By default, the invitation does not expire.
     */
    public CreateInvitationRequestBody withExpiresInDays(JsonNullable<Long> expiresInDays) {
        Utils.checkNotNull(expiresInDays, "expiresInDays");
        this.expiresInDays = expiresInDays;
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
        CreateInvitationRequestBody other = (CreateInvitationRequestBody) o;
        return 
            Objects.deepEquals(this.emailAddress, other.emailAddress) &&
            Objects.deepEquals(this.publicMetadata, other.publicMetadata) &&
            Objects.deepEquals(this.redirectUrl, other.redirectUrl) &&
            Objects.deepEquals(this.notify_, other.notify_) &&
            Objects.deepEquals(this.ignoreExisting, other.ignoreExisting) &&
            Objects.deepEquals(this.expiresInDays, other.expiresInDays);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            emailAddress,
            publicMetadata,
            redirectUrl,
            notify_,
            ignoreExisting,
            expiresInDays);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CreateInvitationRequestBody.class,
                "emailAddress", emailAddress,
                "publicMetadata", publicMetadata,
                "redirectUrl", redirectUrl,
                "notify_", notify_,
                "ignoreExisting", ignoreExisting,
                "expiresInDays", expiresInDays);
    }
    
    public final static class Builder {
 
        private String emailAddress;
 
        private Optional<? extends CreateInvitationPublicMetadata> publicMetadata = Optional.empty();
 
        private Optional<String> redirectUrl = Optional.empty();
 
        private JsonNullable<Boolean> notify_;
 
        private JsonNullable<Boolean> ignoreExisting;
 
        private JsonNullable<Long> expiresInDays = JsonNullable.undefined();  
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * The email address the invitation will be sent to
         */
        public Builder emailAddress(String emailAddress) {
            Utils.checkNotNull(emailAddress, "emailAddress");
            this.emailAddress = emailAddress;
            return this;
        }

        /**
         * Metadata that will be attached to the newly created invitation.
         * The value of this property should be a well-formed JSON object.
         * Once the user accepts the invitation and signs up, these metadata will end up in the user's public metadata.
         */
        public Builder publicMetadata(CreateInvitationPublicMetadata publicMetadata) {
            Utils.checkNotNull(publicMetadata, "publicMetadata");
            this.publicMetadata = Optional.ofNullable(publicMetadata);
            return this;
        }

        /**
         * Metadata that will be attached to the newly created invitation.
         * The value of this property should be a well-formed JSON object.
         * Once the user accepts the invitation and signs up, these metadata will end up in the user's public metadata.
         */
        public Builder publicMetadata(Optional<? extends CreateInvitationPublicMetadata> publicMetadata) {
            Utils.checkNotNull(publicMetadata, "publicMetadata");
            this.publicMetadata = publicMetadata;
            return this;
        }

        /**
         * Optional URL which specifies where to redirect the user once they click the invitation link.
         * This is only required if you have implemented a [custom flow](https://clerk.com/docs/authentication/invitations#custom-flow) and you're not using Clerk Hosted Pages or Clerk Components.
         */
        public Builder redirectUrl(String redirectUrl) {
            Utils.checkNotNull(redirectUrl, "redirectUrl");
            this.redirectUrl = Optional.ofNullable(redirectUrl);
            return this;
        }

        /**
         * Optional URL which specifies where to redirect the user once they click the invitation link.
         * This is only required if you have implemented a [custom flow](https://clerk.com/docs/authentication/invitations#custom-flow) and you're not using Clerk Hosted Pages or Clerk Components.
         */
        public Builder redirectUrl(Optional<String> redirectUrl) {
            Utils.checkNotNull(redirectUrl, "redirectUrl");
            this.redirectUrl = redirectUrl;
            return this;
        }

        /**
         * Optional flag which denotes whether an email invitation should be sent to the given email address.
         * Defaults to true.
         */
        public Builder notify_(boolean notify_) {
            Utils.checkNotNull(notify_, "notify_");
            this.notify_ = JsonNullable.of(notify_);
            return this;
        }

        /**
         * Optional flag which denotes whether an email invitation should be sent to the given email address.
         * Defaults to true.
         */
        public Builder notify_(JsonNullable<Boolean> notify_) {
            Utils.checkNotNull(notify_, "notify_");
            this.notify_ = notify_;
            return this;
        }

        /**
         * Whether an invitation should be created if there is already an existing invitation for this email address, or it's claimed by another user.
         */
        public Builder ignoreExisting(boolean ignoreExisting) {
            Utils.checkNotNull(ignoreExisting, "ignoreExisting");
            this.ignoreExisting = JsonNullable.of(ignoreExisting);
            return this;
        }

        /**
         * Whether an invitation should be created if there is already an existing invitation for this email address, or it's claimed by another user.
         */
        public Builder ignoreExisting(JsonNullable<Boolean> ignoreExisting) {
            Utils.checkNotNull(ignoreExisting, "ignoreExisting");
            this.ignoreExisting = ignoreExisting;
            return this;
        }

        /**
         * The number of days the invitation will be valid for. By default, the invitation does not expire.
         */
        public Builder expiresInDays(long expiresInDays) {
            Utils.checkNotNull(expiresInDays, "expiresInDays");
            this.expiresInDays = JsonNullable.of(expiresInDays);
            return this;
        }

        /**
         * The number of days the invitation will be valid for. By default, the invitation does not expire.
         */
        public Builder expiresInDays(JsonNullable<Long> expiresInDays) {
            Utils.checkNotNull(expiresInDays, "expiresInDays");
            this.expiresInDays = expiresInDays;
            return this;
        }
        
        public CreateInvitationRequestBody build() {
            if (notify_ == null) {
                notify_ = _SINGLETON_VALUE_Notify.value();
            }
            if (ignoreExisting == null) {
                ignoreExisting = _SINGLETON_VALUE_IgnoreExisting.value();
            }            return new CreateInvitationRequestBody(
                emailAddress,
                publicMetadata,
                redirectUrl,
                notify_,
                ignoreExisting,
                expiresInDays);
        }

        private static final LazySingletonValue<JsonNullable<Boolean>> _SINGLETON_VALUE_Notify =
                new LazySingletonValue<>(
                        "notify",
                        "true",
                        new TypeReference<JsonNullable<Boolean>>() {});

        private static final LazySingletonValue<JsonNullable<Boolean>> _SINGLETON_VALUE_IgnoreExisting =
                new LazySingletonValue<>(
                        "ignore_existing",
                        "false",
                        new TypeReference<JsonNullable<Boolean>>() {});
    }
}

