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
import java.lang.Boolean;
import java.lang.Deprecated;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.List;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;


public class UpdateInstanceRequestBody {
    /**
     * Toggles test mode for this instance, allowing the use of test email addresses and phone numbers.
     * Defaults to true for development instances.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("test_mode")
    private JsonNullable<Boolean> testMode;

    /**
     * Whether the instance should be using the HIBP service to check passwords for breaches
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("hibp")
    private JsonNullable<Boolean> hibp;

    /**
     * The "enhanced_email_deliverability" feature will send emails from "verifications@clerk.dev" instead of your domain.
     * This can be helpful if you do not have a high domain reputation.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("enhanced_email_deliverability")
    private JsonNullable<Boolean> enhancedEmailDeliverability;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("support_email")
    private JsonNullable<String> supportEmail;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("clerk_js_version")
    private JsonNullable<String> clerkJsVersion;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("development_origin")
    private JsonNullable<String> developmentOrigin;

    /**
     * For browser-like stacks such as browser extensions, Electron, or Capacitor.js the instance allowed origins need to be updated with the request origin value.
     * For Chrome extensions popup, background, or service worker pages the origin is chrome-extension://extension_uiid. For Electron apps the default origin is http://localhost:3000. For Capacitor, the origin is capacitor://localhost.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("allowed_origins")
    private Optional<? extends List<String>> allowedOrigins;

    /**
     * Whether the instance should operate in cookieless development mode (i.e. without third-party cookies).
     * Deprecated: Please use `url_based_session_syncing` instead.
     * 
     * @deprecated field: This will be removed in a future release, please migrate away from it as soon as possible.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("cookieless_dev")
    @Deprecated
    private JsonNullable<Boolean> cookielessDev;

    /**
     * Whether the instance should use URL-based session syncing in development mode (i.e. without third-party cookies).
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("url_based_session_syncing")
    private JsonNullable<Boolean> urlBasedSessionSyncing;

    @JsonCreator
    public UpdateInstanceRequestBody(
            @JsonProperty("test_mode") JsonNullable<Boolean> testMode,
            @JsonProperty("hibp") JsonNullable<Boolean> hibp,
            @JsonProperty("enhanced_email_deliverability") JsonNullable<Boolean> enhancedEmailDeliverability,
            @JsonProperty("support_email") JsonNullable<String> supportEmail,
            @JsonProperty("clerk_js_version") JsonNullable<String> clerkJsVersion,
            @JsonProperty("development_origin") JsonNullable<String> developmentOrigin,
            @JsonProperty("allowed_origins") Optional<? extends List<String>> allowedOrigins,
            @JsonProperty("cookieless_dev") JsonNullable<Boolean> cookielessDev,
            @JsonProperty("url_based_session_syncing") JsonNullable<Boolean> urlBasedSessionSyncing) {
        Utils.checkNotNull(testMode, "testMode");
        Utils.checkNotNull(hibp, "hibp");
        Utils.checkNotNull(enhancedEmailDeliverability, "enhancedEmailDeliverability");
        Utils.checkNotNull(supportEmail, "supportEmail");
        Utils.checkNotNull(clerkJsVersion, "clerkJsVersion");
        Utils.checkNotNull(developmentOrigin, "developmentOrigin");
        Utils.checkNotNull(allowedOrigins, "allowedOrigins");
        Utils.checkNotNull(cookielessDev, "cookielessDev");
        Utils.checkNotNull(urlBasedSessionSyncing, "urlBasedSessionSyncing");
        this.testMode = testMode;
        this.hibp = hibp;
        this.enhancedEmailDeliverability = enhancedEmailDeliverability;
        this.supportEmail = supportEmail;
        this.clerkJsVersion = clerkJsVersion;
        this.developmentOrigin = developmentOrigin;
        this.allowedOrigins = allowedOrigins;
        this.cookielessDev = cookielessDev;
        this.urlBasedSessionSyncing = urlBasedSessionSyncing;
    }
    
    public UpdateInstanceRequestBody() {
        this(JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined(),
            JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined(),
            Optional.empty(), JsonNullable.undefined(), JsonNullable.undefined());
    }

    /**
     * Toggles test mode for this instance, allowing the use of test email addresses and phone numbers.
     * Defaults to true for development instances.
     */
    @JsonIgnore
    public JsonNullable<Boolean> testMode() {
        return testMode;
    }

    /**
     * Whether the instance should be using the HIBP service to check passwords for breaches
     */
    @JsonIgnore
    public JsonNullable<Boolean> hibp() {
        return hibp;
    }

    /**
     * The "enhanced_email_deliverability" feature will send emails from "verifications@clerk.dev" instead of your domain.
     * This can be helpful if you do not have a high domain reputation.
     */
    @JsonIgnore
    public JsonNullable<Boolean> enhancedEmailDeliverability() {
        return enhancedEmailDeliverability;
    }

    @JsonIgnore
    public JsonNullable<String> supportEmail() {
        return supportEmail;
    }

    @JsonIgnore
    public JsonNullable<String> clerkJsVersion() {
        return clerkJsVersion;
    }

    @JsonIgnore
    public JsonNullable<String> developmentOrigin() {
        return developmentOrigin;
    }

    /**
     * For browser-like stacks such as browser extensions, Electron, or Capacitor.js the instance allowed origins need to be updated with the request origin value.
     * For Chrome extensions popup, background, or service worker pages the origin is chrome-extension://extension_uiid. For Electron apps the default origin is http://localhost:3000. For Capacitor, the origin is capacitor://localhost.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<List<String>> allowedOrigins() {
        return (Optional<List<String>>) allowedOrigins;
    }

    /**
     * Whether the instance should operate in cookieless development mode (i.e. without third-party cookies).
     * Deprecated: Please use `url_based_session_syncing` instead.
     * 
     * @deprecated field: This will be removed in a future release, please migrate away from it as soon as possible.
     */
    @Deprecated
    @JsonIgnore
    public JsonNullable<Boolean> cookielessDev() {
        return cookielessDev;
    }

    /**
     * Whether the instance should use URL-based session syncing in development mode (i.e. without third-party cookies).
     */
    @JsonIgnore
    public JsonNullable<Boolean> urlBasedSessionSyncing() {
        return urlBasedSessionSyncing;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * Toggles test mode for this instance, allowing the use of test email addresses and phone numbers.
     * Defaults to true for development instances.
     */
    public UpdateInstanceRequestBody withTestMode(boolean testMode) {
        Utils.checkNotNull(testMode, "testMode");
        this.testMode = JsonNullable.of(testMode);
        return this;
    }

    /**
     * Toggles test mode for this instance, allowing the use of test email addresses and phone numbers.
     * Defaults to true for development instances.
     */
    public UpdateInstanceRequestBody withTestMode(JsonNullable<Boolean> testMode) {
        Utils.checkNotNull(testMode, "testMode");
        this.testMode = testMode;
        return this;
    }

    /**
     * Whether the instance should be using the HIBP service to check passwords for breaches
     */
    public UpdateInstanceRequestBody withHibp(boolean hibp) {
        Utils.checkNotNull(hibp, "hibp");
        this.hibp = JsonNullable.of(hibp);
        return this;
    }

    /**
     * Whether the instance should be using the HIBP service to check passwords for breaches
     */
    public UpdateInstanceRequestBody withHibp(JsonNullable<Boolean> hibp) {
        Utils.checkNotNull(hibp, "hibp");
        this.hibp = hibp;
        return this;
    }

    /**
     * The "enhanced_email_deliverability" feature will send emails from "verifications@clerk.dev" instead of your domain.
     * This can be helpful if you do not have a high domain reputation.
     */
    public UpdateInstanceRequestBody withEnhancedEmailDeliverability(boolean enhancedEmailDeliverability) {
        Utils.checkNotNull(enhancedEmailDeliverability, "enhancedEmailDeliverability");
        this.enhancedEmailDeliverability = JsonNullable.of(enhancedEmailDeliverability);
        return this;
    }

    /**
     * The "enhanced_email_deliverability" feature will send emails from "verifications@clerk.dev" instead of your domain.
     * This can be helpful if you do not have a high domain reputation.
     */
    public UpdateInstanceRequestBody withEnhancedEmailDeliverability(JsonNullable<Boolean> enhancedEmailDeliverability) {
        Utils.checkNotNull(enhancedEmailDeliverability, "enhancedEmailDeliverability");
        this.enhancedEmailDeliverability = enhancedEmailDeliverability;
        return this;
    }

    public UpdateInstanceRequestBody withSupportEmail(String supportEmail) {
        Utils.checkNotNull(supportEmail, "supportEmail");
        this.supportEmail = JsonNullable.of(supportEmail);
        return this;
    }

    public UpdateInstanceRequestBody withSupportEmail(JsonNullable<String> supportEmail) {
        Utils.checkNotNull(supportEmail, "supportEmail");
        this.supportEmail = supportEmail;
        return this;
    }

    public UpdateInstanceRequestBody withClerkJsVersion(String clerkJsVersion) {
        Utils.checkNotNull(clerkJsVersion, "clerkJsVersion");
        this.clerkJsVersion = JsonNullable.of(clerkJsVersion);
        return this;
    }

    public UpdateInstanceRequestBody withClerkJsVersion(JsonNullable<String> clerkJsVersion) {
        Utils.checkNotNull(clerkJsVersion, "clerkJsVersion");
        this.clerkJsVersion = clerkJsVersion;
        return this;
    }

    public UpdateInstanceRequestBody withDevelopmentOrigin(String developmentOrigin) {
        Utils.checkNotNull(developmentOrigin, "developmentOrigin");
        this.developmentOrigin = JsonNullable.of(developmentOrigin);
        return this;
    }

    public UpdateInstanceRequestBody withDevelopmentOrigin(JsonNullable<String> developmentOrigin) {
        Utils.checkNotNull(developmentOrigin, "developmentOrigin");
        this.developmentOrigin = developmentOrigin;
        return this;
    }

    /**
     * For browser-like stacks such as browser extensions, Electron, or Capacitor.js the instance allowed origins need to be updated with the request origin value.
     * For Chrome extensions popup, background, or service worker pages the origin is chrome-extension://extension_uiid. For Electron apps the default origin is http://localhost:3000. For Capacitor, the origin is capacitor://localhost.
     */
    public UpdateInstanceRequestBody withAllowedOrigins(List<String> allowedOrigins) {
        Utils.checkNotNull(allowedOrigins, "allowedOrigins");
        this.allowedOrigins = Optional.ofNullable(allowedOrigins);
        return this;
    }


    /**
     * For browser-like stacks such as browser extensions, Electron, or Capacitor.js the instance allowed origins need to be updated with the request origin value.
     * For Chrome extensions popup, background, or service worker pages the origin is chrome-extension://extension_uiid. For Electron apps the default origin is http://localhost:3000. For Capacitor, the origin is capacitor://localhost.
     */
    public UpdateInstanceRequestBody withAllowedOrigins(Optional<? extends List<String>> allowedOrigins) {
        Utils.checkNotNull(allowedOrigins, "allowedOrigins");
        this.allowedOrigins = allowedOrigins;
        return this;
    }

    /**
     * Whether the instance should operate in cookieless development mode (i.e. without third-party cookies).
     * Deprecated: Please use `url_based_session_syncing` instead.
     * 
     * @deprecated field: This will be removed in a future release, please migrate away from it as soon as possible.
     */
    @Deprecated
    public UpdateInstanceRequestBody withCookielessDev(boolean cookielessDev) {
        Utils.checkNotNull(cookielessDev, "cookielessDev");
        this.cookielessDev = JsonNullable.of(cookielessDev);
        return this;
    }

    /**
     * Whether the instance should operate in cookieless development mode (i.e. without third-party cookies).
     * Deprecated: Please use `url_based_session_syncing` instead.
     * 
     * @deprecated field: This will be removed in a future release, please migrate away from it as soon as possible.
     */
    @Deprecated
    public UpdateInstanceRequestBody withCookielessDev(JsonNullable<Boolean> cookielessDev) {
        Utils.checkNotNull(cookielessDev, "cookielessDev");
        this.cookielessDev = cookielessDev;
        return this;
    }

    /**
     * Whether the instance should use URL-based session syncing in development mode (i.e. without third-party cookies).
     */
    public UpdateInstanceRequestBody withUrlBasedSessionSyncing(boolean urlBasedSessionSyncing) {
        Utils.checkNotNull(urlBasedSessionSyncing, "urlBasedSessionSyncing");
        this.urlBasedSessionSyncing = JsonNullable.of(urlBasedSessionSyncing);
        return this;
    }

    /**
     * Whether the instance should use URL-based session syncing in development mode (i.e. without third-party cookies).
     */
    public UpdateInstanceRequestBody withUrlBasedSessionSyncing(JsonNullable<Boolean> urlBasedSessionSyncing) {
        Utils.checkNotNull(urlBasedSessionSyncing, "urlBasedSessionSyncing");
        this.urlBasedSessionSyncing = urlBasedSessionSyncing;
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
        UpdateInstanceRequestBody other = (UpdateInstanceRequestBody) o;
        return 
            Utils.enhancedDeepEquals(this.testMode, other.testMode) &&
            Utils.enhancedDeepEquals(this.hibp, other.hibp) &&
            Utils.enhancedDeepEquals(this.enhancedEmailDeliverability, other.enhancedEmailDeliverability) &&
            Utils.enhancedDeepEquals(this.supportEmail, other.supportEmail) &&
            Utils.enhancedDeepEquals(this.clerkJsVersion, other.clerkJsVersion) &&
            Utils.enhancedDeepEquals(this.developmentOrigin, other.developmentOrigin) &&
            Utils.enhancedDeepEquals(this.allowedOrigins, other.allowedOrigins) &&
            Utils.enhancedDeepEquals(this.cookielessDev, other.cookielessDev) &&
            Utils.enhancedDeepEquals(this.urlBasedSessionSyncing, other.urlBasedSessionSyncing);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            testMode, hibp, enhancedEmailDeliverability,
            supportEmail, clerkJsVersion, developmentOrigin,
            allowedOrigins, cookielessDev, urlBasedSessionSyncing);
    }
    
    @Override
    public String toString() {
        return Utils.toString(UpdateInstanceRequestBody.class,
                "testMode", testMode,
                "hibp", hibp,
                "enhancedEmailDeliverability", enhancedEmailDeliverability,
                "supportEmail", supportEmail,
                "clerkJsVersion", clerkJsVersion,
                "developmentOrigin", developmentOrigin,
                "allowedOrigins", allowedOrigins,
                "cookielessDev", cookielessDev,
                "urlBasedSessionSyncing", urlBasedSessionSyncing);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private JsonNullable<Boolean> testMode = JsonNullable.undefined();

        private JsonNullable<Boolean> hibp = JsonNullable.undefined();

        private JsonNullable<Boolean> enhancedEmailDeliverability = JsonNullable.undefined();

        private JsonNullable<String> supportEmail = JsonNullable.undefined();

        private JsonNullable<String> clerkJsVersion = JsonNullable.undefined();

        private JsonNullable<String> developmentOrigin = JsonNullable.undefined();

        private Optional<? extends List<String>> allowedOrigins = Optional.empty();

        @Deprecated
        private JsonNullable<Boolean> cookielessDev = JsonNullable.undefined();

        private JsonNullable<Boolean> urlBasedSessionSyncing = JsonNullable.undefined();

        private Builder() {
          // force use of static builder() method
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


        /**
         * Whether the instance should be using the HIBP service to check passwords for breaches
         */
        public Builder hibp(boolean hibp) {
            Utils.checkNotNull(hibp, "hibp");
            this.hibp = JsonNullable.of(hibp);
            return this;
        }

        /**
         * Whether the instance should be using the HIBP service to check passwords for breaches
         */
        public Builder hibp(JsonNullable<Boolean> hibp) {
            Utils.checkNotNull(hibp, "hibp");
            this.hibp = hibp;
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


        public Builder supportEmail(String supportEmail) {
            Utils.checkNotNull(supportEmail, "supportEmail");
            this.supportEmail = JsonNullable.of(supportEmail);
            return this;
        }

        public Builder supportEmail(JsonNullable<String> supportEmail) {
            Utils.checkNotNull(supportEmail, "supportEmail");
            this.supportEmail = supportEmail;
            return this;
        }


        public Builder clerkJsVersion(String clerkJsVersion) {
            Utils.checkNotNull(clerkJsVersion, "clerkJsVersion");
            this.clerkJsVersion = JsonNullable.of(clerkJsVersion);
            return this;
        }

        public Builder clerkJsVersion(JsonNullable<String> clerkJsVersion) {
            Utils.checkNotNull(clerkJsVersion, "clerkJsVersion");
            this.clerkJsVersion = clerkJsVersion;
            return this;
        }


        public Builder developmentOrigin(String developmentOrigin) {
            Utils.checkNotNull(developmentOrigin, "developmentOrigin");
            this.developmentOrigin = JsonNullable.of(developmentOrigin);
            return this;
        }

        public Builder developmentOrigin(JsonNullable<String> developmentOrigin) {
            Utils.checkNotNull(developmentOrigin, "developmentOrigin");
            this.developmentOrigin = developmentOrigin;
            return this;
        }


        /**
         * For browser-like stacks such as browser extensions, Electron, or Capacitor.js the instance allowed origins need to be updated with the request origin value.
         * For Chrome extensions popup, background, or service worker pages the origin is chrome-extension://extension_uiid. For Electron apps the default origin is http://localhost:3000. For Capacitor, the origin is capacitor://localhost.
         */
        public Builder allowedOrigins(List<String> allowedOrigins) {
            Utils.checkNotNull(allowedOrigins, "allowedOrigins");
            this.allowedOrigins = Optional.ofNullable(allowedOrigins);
            return this;
        }

        /**
         * For browser-like stacks such as browser extensions, Electron, or Capacitor.js the instance allowed origins need to be updated with the request origin value.
         * For Chrome extensions popup, background, or service worker pages the origin is chrome-extension://extension_uiid. For Electron apps the default origin is http://localhost:3000. For Capacitor, the origin is capacitor://localhost.
         */
        public Builder allowedOrigins(Optional<? extends List<String>> allowedOrigins) {
            Utils.checkNotNull(allowedOrigins, "allowedOrigins");
            this.allowedOrigins = allowedOrigins;
            return this;
        }


        /**
         * Whether the instance should operate in cookieless development mode (i.e. without third-party cookies).
         * Deprecated: Please use `url_based_session_syncing` instead.
         * 
         * @deprecated field: This will be removed in a future release, please migrate away from it as soon as possible.
         */
        @Deprecated
        public Builder cookielessDev(boolean cookielessDev) {
            Utils.checkNotNull(cookielessDev, "cookielessDev");
            this.cookielessDev = JsonNullable.of(cookielessDev);
            return this;
        }

        /**
         * Whether the instance should operate in cookieless development mode (i.e. without third-party cookies).
         * Deprecated: Please use `url_based_session_syncing` instead.
         * 
         * @deprecated field: This will be removed in a future release, please migrate away from it as soon as possible.
         */
        @Deprecated
        public Builder cookielessDev(JsonNullable<Boolean> cookielessDev) {
            Utils.checkNotNull(cookielessDev, "cookielessDev");
            this.cookielessDev = cookielessDev;
            return this;
        }


        /**
         * Whether the instance should use URL-based session syncing in development mode (i.e. without third-party cookies).
         */
        public Builder urlBasedSessionSyncing(boolean urlBasedSessionSyncing) {
            Utils.checkNotNull(urlBasedSessionSyncing, "urlBasedSessionSyncing");
            this.urlBasedSessionSyncing = JsonNullable.of(urlBasedSessionSyncing);
            return this;
        }

        /**
         * Whether the instance should use URL-based session syncing in development mode (i.e. without third-party cookies).
         */
        public Builder urlBasedSessionSyncing(JsonNullable<Boolean> urlBasedSessionSyncing) {
            Utils.checkNotNull(urlBasedSessionSyncing, "urlBasedSessionSyncing");
            this.urlBasedSessionSyncing = urlBasedSessionSyncing;
            return this;
        }

        public UpdateInstanceRequestBody build() {

            return new UpdateInstanceRequestBody(
                testMode, hibp, enhancedEmailDeliverability,
                supportEmail, clerkJsVersion, developmentOrigin,
                allowedOrigins, cookielessDev, urlBasedSessionSyncing);
        }

    }
}
