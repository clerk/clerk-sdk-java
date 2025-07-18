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
import java.lang.Override;
import java.lang.String;
import org.openapitools.jackson.nullable.JsonNullable;


public class UpdateInstanceAuthConfigRequestBody {
    /**
     * Whether sign up is restricted to email addresses, phone numbers and usernames that are on the allowlist.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("restricted_to_allowlist")
    private JsonNullable<Boolean> restrictedToAllowlist;

    /**
     * The local part of the email address from which authentication-related emails (e.g. OTP code, magic links) will be sent.
     * Only alphanumeric values are allowed.
     * Note that this value should contain only the local part of the address (e.g. `foo` for `foo@example.com`).
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("from_email_address")
    private JsonNullable<String> fromEmailAddress;

    /**
     * Enable the Progressive Sign Up algorithm. Refer to the [docs](https://clerk.com/docs/upgrade-guides/progressive-sign-up) for more info.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("progressive_sign_up")
    private JsonNullable<Boolean> progressiveSignUp;

    /**
     * The "enhanced_email_deliverability" feature will send emails from "verifications@clerk.dev" instead of your domain.
     * This can be helpful if you do not have a high domain reputation.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("enhanced_email_deliverability")
    private JsonNullable<Boolean> enhancedEmailDeliverability;

    /**
     * Toggles test mode for this instance, allowing the use of test email addresses and phone numbers.
     * Defaults to true for development instances.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("test_mode")
    private JsonNullable<Boolean> testMode;

    @JsonCreator
    public UpdateInstanceAuthConfigRequestBody(
            @JsonProperty("restricted_to_allowlist") JsonNullable<Boolean> restrictedToAllowlist,
            @JsonProperty("from_email_address") JsonNullable<String> fromEmailAddress,
            @JsonProperty("progressive_sign_up") JsonNullable<Boolean> progressiveSignUp,
            @JsonProperty("enhanced_email_deliverability") JsonNullable<Boolean> enhancedEmailDeliverability,
            @JsonProperty("test_mode") JsonNullable<Boolean> testMode) {
        Utils.checkNotNull(restrictedToAllowlist, "restrictedToAllowlist");
        Utils.checkNotNull(fromEmailAddress, "fromEmailAddress");
        Utils.checkNotNull(progressiveSignUp, "progressiveSignUp");
        Utils.checkNotNull(enhancedEmailDeliverability, "enhancedEmailDeliverability");
        Utils.checkNotNull(testMode, "testMode");
        this.restrictedToAllowlist = restrictedToAllowlist;
        this.fromEmailAddress = fromEmailAddress;
        this.progressiveSignUp = progressiveSignUp;
        this.enhancedEmailDeliverability = enhancedEmailDeliverability;
        this.testMode = testMode;
    }
    
    public UpdateInstanceAuthConfigRequestBody() {
        this(JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined(),
            JsonNullable.undefined(), JsonNullable.undefined());
    }

    /**
     * Whether sign up is restricted to email addresses, phone numbers and usernames that are on the allowlist.
     */
    @JsonIgnore
    public JsonNullable<Boolean> restrictedToAllowlist() {
        return restrictedToAllowlist;
    }

    /**
     * The local part of the email address from which authentication-related emails (e.g. OTP code, magic links) will be sent.
     * Only alphanumeric values are allowed.
     * Note that this value should contain only the local part of the address (e.g. `foo` for `foo@example.com`).
     */
    @JsonIgnore
    public JsonNullable<String> fromEmailAddress() {
        return fromEmailAddress;
    }

    /**
     * Enable the Progressive Sign Up algorithm. Refer to the [docs](https://clerk.com/docs/upgrade-guides/progressive-sign-up) for more info.
     */
    @JsonIgnore
    public JsonNullable<Boolean> progressiveSignUp() {
        return progressiveSignUp;
    }

    /**
     * The "enhanced_email_deliverability" feature will send emails from "verifications@clerk.dev" instead of your domain.
     * This can be helpful if you do not have a high domain reputation.
     */
    @JsonIgnore
    public JsonNullable<Boolean> enhancedEmailDeliverability() {
        return enhancedEmailDeliverability;
    }

    /**
     * Toggles test mode for this instance, allowing the use of test email addresses and phone numbers.
     * Defaults to true for development instances.
     */
    @JsonIgnore
    public JsonNullable<Boolean> testMode() {
        return testMode;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * Whether sign up is restricted to email addresses, phone numbers and usernames that are on the allowlist.
     */
    public UpdateInstanceAuthConfigRequestBody withRestrictedToAllowlist(boolean restrictedToAllowlist) {
        Utils.checkNotNull(restrictedToAllowlist, "restrictedToAllowlist");
        this.restrictedToAllowlist = JsonNullable.of(restrictedToAllowlist);
        return this;
    }

    /**
     * Whether sign up is restricted to email addresses, phone numbers and usernames that are on the allowlist.
     */
    public UpdateInstanceAuthConfigRequestBody withRestrictedToAllowlist(JsonNullable<Boolean> restrictedToAllowlist) {
        Utils.checkNotNull(restrictedToAllowlist, "restrictedToAllowlist");
        this.restrictedToAllowlist = restrictedToAllowlist;
        return this;
    }

    /**
     * The local part of the email address from which authentication-related emails (e.g. OTP code, magic links) will be sent.
     * Only alphanumeric values are allowed.
     * Note that this value should contain only the local part of the address (e.g. `foo` for `foo@example.com`).
     */
    public UpdateInstanceAuthConfigRequestBody withFromEmailAddress(String fromEmailAddress) {
        Utils.checkNotNull(fromEmailAddress, "fromEmailAddress");
        this.fromEmailAddress = JsonNullable.of(fromEmailAddress);
        return this;
    }

    /**
     * The local part of the email address from which authentication-related emails (e.g. OTP code, magic links) will be sent.
     * Only alphanumeric values are allowed.
     * Note that this value should contain only the local part of the address (e.g. `foo` for `foo@example.com`).
     */
    public UpdateInstanceAuthConfigRequestBody withFromEmailAddress(JsonNullable<String> fromEmailAddress) {
        Utils.checkNotNull(fromEmailAddress, "fromEmailAddress");
        this.fromEmailAddress = fromEmailAddress;
        return this;
    }

    /**
     * Enable the Progressive Sign Up algorithm. Refer to the [docs](https://clerk.com/docs/upgrade-guides/progressive-sign-up) for more info.
     */
    public UpdateInstanceAuthConfigRequestBody withProgressiveSignUp(boolean progressiveSignUp) {
        Utils.checkNotNull(progressiveSignUp, "progressiveSignUp");
        this.progressiveSignUp = JsonNullable.of(progressiveSignUp);
        return this;
    }

    /**
     * Enable the Progressive Sign Up algorithm. Refer to the [docs](https://clerk.com/docs/upgrade-guides/progressive-sign-up) for more info.
     */
    public UpdateInstanceAuthConfigRequestBody withProgressiveSignUp(JsonNullable<Boolean> progressiveSignUp) {
        Utils.checkNotNull(progressiveSignUp, "progressiveSignUp");
        this.progressiveSignUp = progressiveSignUp;
        return this;
    }

    /**
     * The "enhanced_email_deliverability" feature will send emails from "verifications@clerk.dev" instead of your domain.
     * This can be helpful if you do not have a high domain reputation.
     */
    public UpdateInstanceAuthConfigRequestBody withEnhancedEmailDeliverability(boolean enhancedEmailDeliverability) {
        Utils.checkNotNull(enhancedEmailDeliverability, "enhancedEmailDeliverability");
        this.enhancedEmailDeliverability = JsonNullable.of(enhancedEmailDeliverability);
        return this;
    }

    /**
     * The "enhanced_email_deliverability" feature will send emails from "verifications@clerk.dev" instead of your domain.
     * This can be helpful if you do not have a high domain reputation.
     */
    public UpdateInstanceAuthConfigRequestBody withEnhancedEmailDeliverability(JsonNullable<Boolean> enhancedEmailDeliverability) {
        Utils.checkNotNull(enhancedEmailDeliverability, "enhancedEmailDeliverability");
        this.enhancedEmailDeliverability = enhancedEmailDeliverability;
        return this;
    }

    /**
     * Toggles test mode for this instance, allowing the use of test email addresses and phone numbers.
     * Defaults to true for development instances.
     */
    public UpdateInstanceAuthConfigRequestBody withTestMode(boolean testMode) {
        Utils.checkNotNull(testMode, "testMode");
        this.testMode = JsonNullable.of(testMode);
        return this;
    }

    /**
     * Toggles test mode for this instance, allowing the use of test email addresses and phone numbers.
     * Defaults to true for development instances.
     */
    public UpdateInstanceAuthConfigRequestBody withTestMode(JsonNullable<Boolean> testMode) {
        Utils.checkNotNull(testMode, "testMode");
        this.testMode = testMode;
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
        UpdateInstanceAuthConfigRequestBody other = (UpdateInstanceAuthConfigRequestBody) o;
        return 
            Utils.enhancedDeepEquals(this.restrictedToAllowlist, other.restrictedToAllowlist) &&
            Utils.enhancedDeepEquals(this.fromEmailAddress, other.fromEmailAddress) &&
            Utils.enhancedDeepEquals(this.progressiveSignUp, other.progressiveSignUp) &&
            Utils.enhancedDeepEquals(this.enhancedEmailDeliverability, other.enhancedEmailDeliverability) &&
            Utils.enhancedDeepEquals(this.testMode, other.testMode);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            restrictedToAllowlist, fromEmailAddress, progressiveSignUp,
            enhancedEmailDeliverability, testMode);
    }
    
    @Override
    public String toString() {
        return Utils.toString(UpdateInstanceAuthConfigRequestBody.class,
                "restrictedToAllowlist", restrictedToAllowlist,
                "fromEmailAddress", fromEmailAddress,
                "progressiveSignUp", progressiveSignUp,
                "enhancedEmailDeliverability", enhancedEmailDeliverability,
                "testMode", testMode);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private JsonNullable<Boolean> restrictedToAllowlist;

        private JsonNullable<String> fromEmailAddress = JsonNullable.undefined();

        private JsonNullable<Boolean> progressiveSignUp = JsonNullable.undefined();

        private JsonNullable<Boolean> enhancedEmailDeliverability = JsonNullable.undefined();

        private JsonNullable<Boolean> testMode = JsonNullable.undefined();

        private Builder() {
          // force use of static builder() method
        }


        /**
         * Whether sign up is restricted to email addresses, phone numbers and usernames that are on the allowlist.
         */
        public Builder restrictedToAllowlist(boolean restrictedToAllowlist) {
            Utils.checkNotNull(restrictedToAllowlist, "restrictedToAllowlist");
            this.restrictedToAllowlist = JsonNullable.of(restrictedToAllowlist);
            return this;
        }

        /**
         * Whether sign up is restricted to email addresses, phone numbers and usernames that are on the allowlist.
         */
        public Builder restrictedToAllowlist(JsonNullable<Boolean> restrictedToAllowlist) {
            Utils.checkNotNull(restrictedToAllowlist, "restrictedToAllowlist");
            this.restrictedToAllowlist = restrictedToAllowlist;
            return this;
        }


        /**
         * The local part of the email address from which authentication-related emails (e.g. OTP code, magic links) will be sent.
         * Only alphanumeric values are allowed.
         * Note that this value should contain only the local part of the address (e.g. `foo` for `foo@example.com`).
         */
        public Builder fromEmailAddress(String fromEmailAddress) {
            Utils.checkNotNull(fromEmailAddress, "fromEmailAddress");
            this.fromEmailAddress = JsonNullable.of(fromEmailAddress);
            return this;
        }

        /**
         * The local part of the email address from which authentication-related emails (e.g. OTP code, magic links) will be sent.
         * Only alphanumeric values are allowed.
         * Note that this value should contain only the local part of the address (e.g. `foo` for `foo@example.com`).
         */
        public Builder fromEmailAddress(JsonNullable<String> fromEmailAddress) {
            Utils.checkNotNull(fromEmailAddress, "fromEmailAddress");
            this.fromEmailAddress = fromEmailAddress;
            return this;
        }


        /**
         * Enable the Progressive Sign Up algorithm. Refer to the [docs](https://clerk.com/docs/upgrade-guides/progressive-sign-up) for more info.
         */
        public Builder progressiveSignUp(boolean progressiveSignUp) {
            Utils.checkNotNull(progressiveSignUp, "progressiveSignUp");
            this.progressiveSignUp = JsonNullable.of(progressiveSignUp);
            return this;
        }

        /**
         * Enable the Progressive Sign Up algorithm. Refer to the [docs](https://clerk.com/docs/upgrade-guides/progressive-sign-up) for more info.
         */
        public Builder progressiveSignUp(JsonNullable<Boolean> progressiveSignUp) {
            Utils.checkNotNull(progressiveSignUp, "progressiveSignUp");
            this.progressiveSignUp = progressiveSignUp;
            return this;
        }


        /**
         * The "enhanced_email_deliverability" feature will send emails from "verifications@clerk.dev" instead of your domain.
         * This can be helpful if you do not have a high domain reputation.
         */
        public Builder enhancedEmailDeliverability(boolean enhancedEmailDeliverability) {
            Utils.checkNotNull(enhancedEmailDeliverability, "enhancedEmailDeliverability");
            this.enhancedEmailDeliverability = JsonNullable.of(enhancedEmailDeliverability);
            return this;
        }

        /**
         * The "enhanced_email_deliverability" feature will send emails from "verifications@clerk.dev" instead of your domain.
         * This can be helpful if you do not have a high domain reputation.
         */
        public Builder enhancedEmailDeliverability(JsonNullable<Boolean> enhancedEmailDeliverability) {
            Utils.checkNotNull(enhancedEmailDeliverability, "enhancedEmailDeliverability");
            this.enhancedEmailDeliverability = enhancedEmailDeliverability;
            return this;
        }


        /**
         * Toggles test mode for this instance, allowing the use of test email addresses and phone numbers.
         * Defaults to true for development instances.
         */
        public Builder testMode(boolean testMode) {
            Utils.checkNotNull(testMode, "testMode");
            this.testMode = JsonNullable.of(testMode);
            return this;
        }

        /**
         * Toggles test mode for this instance, allowing the use of test email addresses and phone numbers.
         * Defaults to true for development instances.
         */
        public Builder testMode(JsonNullable<Boolean> testMode) {
            Utils.checkNotNull(testMode, "testMode");
            this.testMode = testMode;
            return this;
        }

        public UpdateInstanceAuthConfigRequestBody build() {
            if (restrictedToAllowlist == null) {
                restrictedToAllowlist = _SINGLETON_VALUE_RestrictedToAllowlist.value();
            }

            return new UpdateInstanceAuthConfigRequestBody(
                restrictedToAllowlist, fromEmailAddress, progressiveSignUp,
                enhancedEmailDeliverability, testMode);
        }


        private static final LazySingletonValue<JsonNullable<Boolean>> _SINGLETON_VALUE_RestrictedToAllowlist =
                new LazySingletonValue<>(
                        "restricted_to_allowlist",
                        "false",
                        new TypeReference<JsonNullable<Boolean>>() {});
    }
}
