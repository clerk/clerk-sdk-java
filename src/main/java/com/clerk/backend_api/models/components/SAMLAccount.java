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
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Map;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;


public class SAMLAccount {

    @JsonProperty("id")
    private String id;

    /**
     * String representing the object's type. Objects of the same type share the same value.
     */
    @JsonProperty("object")
    private SAMLAccountObject object;


    @JsonProperty("provider")
    private String provider;


    @JsonProperty("active")
    private boolean active;


    @JsonProperty("email_address")
    private String emailAddress;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("first_name")
    private JsonNullable<String> firstName;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("last_name")
    private JsonNullable<String> lastName;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("provider_user_id")
    private JsonNullable<String> providerUserId;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("public_metadata")
    private Optional<? extends Map<String, Object>> publicMetadata;


    @JsonInclude(Include.ALWAYS)
    @JsonProperty("verification")
    private Optional<? extends SAMLAccountVerification> verification;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("saml_connection")
    private JsonNullable<? extends SamlConnection> samlConnection;

    @JsonCreator
    public SAMLAccount(
            @JsonProperty("id") String id,
            @JsonProperty("object") SAMLAccountObject object,
            @JsonProperty("provider") String provider,
            @JsonProperty("active") boolean active,
            @JsonProperty("email_address") String emailAddress,
            @JsonProperty("first_name") JsonNullable<String> firstName,
            @JsonProperty("last_name") JsonNullable<String> lastName,
            @JsonProperty("provider_user_id") JsonNullable<String> providerUserId,
            @JsonProperty("public_metadata") Optional<? extends Map<String, Object>> publicMetadata,
            @JsonProperty("verification") Optional<? extends SAMLAccountVerification> verification,
            @JsonProperty("saml_connection") JsonNullable<? extends SamlConnection> samlConnection) {
        Utils.checkNotNull(id, "id");
        Utils.checkNotNull(object, "object");
        Utils.checkNotNull(provider, "provider");
        Utils.checkNotNull(active, "active");
        Utils.checkNotNull(emailAddress, "emailAddress");
        Utils.checkNotNull(firstName, "firstName");
        Utils.checkNotNull(lastName, "lastName");
        Utils.checkNotNull(providerUserId, "providerUserId");
        Utils.checkNotNull(publicMetadata, "publicMetadata");
        Utils.checkNotNull(verification, "verification");
        Utils.checkNotNull(samlConnection, "samlConnection");
        this.id = id;
        this.object = object;
        this.provider = provider;
        this.active = active;
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.providerUserId = providerUserId;
        this.publicMetadata = publicMetadata;
        this.verification = verification;
        this.samlConnection = samlConnection;
    }
    
    public SAMLAccount(
            String id,
            SAMLAccountObject object,
            String provider,
            boolean active,
            String emailAddress) {
        this(id, object, provider,
            active, emailAddress, JsonNullable.undefined(),
            JsonNullable.undefined(), JsonNullable.undefined(), Optional.empty(),
            Optional.empty(), JsonNullable.undefined());
    }

    @JsonIgnore
    public String id() {
        return id;
    }

    /**
     * String representing the object's type. Objects of the same type share the same value.
     */
    @JsonIgnore
    public SAMLAccountObject object() {
        return object;
    }

    @JsonIgnore
    public String provider() {
        return provider;
    }

    @JsonIgnore
    public boolean active() {
        return active;
    }

    @JsonIgnore
    public String emailAddress() {
        return emailAddress;
    }

    @JsonIgnore
    public JsonNullable<String> firstName() {
        return firstName;
    }

    @JsonIgnore
    public JsonNullable<String> lastName() {
        return lastName;
    }

    @JsonIgnore
    public JsonNullable<String> providerUserId() {
        return providerUserId;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<Map<String, Object>> publicMetadata() {
        return (Optional<Map<String, Object>>) publicMetadata;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<SAMLAccountVerification> verification() {
        return (Optional<SAMLAccountVerification>) verification;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<SamlConnection> samlConnection() {
        return (JsonNullable<SamlConnection>) samlConnection;
    }

    public static Builder builder() {
        return new Builder();
    }


    public SAMLAccount withId(String id) {
        Utils.checkNotNull(id, "id");
        this.id = id;
        return this;
    }

    /**
     * String representing the object's type. Objects of the same type share the same value.
     */
    public SAMLAccount withObject(SAMLAccountObject object) {
        Utils.checkNotNull(object, "object");
        this.object = object;
        return this;
    }

    public SAMLAccount withProvider(String provider) {
        Utils.checkNotNull(provider, "provider");
        this.provider = provider;
        return this;
    }

    public SAMLAccount withActive(boolean active) {
        Utils.checkNotNull(active, "active");
        this.active = active;
        return this;
    }

    public SAMLAccount withEmailAddress(String emailAddress) {
        Utils.checkNotNull(emailAddress, "emailAddress");
        this.emailAddress = emailAddress;
        return this;
    }

    public SAMLAccount withFirstName(String firstName) {
        Utils.checkNotNull(firstName, "firstName");
        this.firstName = JsonNullable.of(firstName);
        return this;
    }

    public SAMLAccount withFirstName(JsonNullable<String> firstName) {
        Utils.checkNotNull(firstName, "firstName");
        this.firstName = firstName;
        return this;
    }

    public SAMLAccount withLastName(String lastName) {
        Utils.checkNotNull(lastName, "lastName");
        this.lastName = JsonNullable.of(lastName);
        return this;
    }

    public SAMLAccount withLastName(JsonNullable<String> lastName) {
        Utils.checkNotNull(lastName, "lastName");
        this.lastName = lastName;
        return this;
    }

    public SAMLAccount withProviderUserId(String providerUserId) {
        Utils.checkNotNull(providerUserId, "providerUserId");
        this.providerUserId = JsonNullable.of(providerUserId);
        return this;
    }

    public SAMLAccount withProviderUserId(JsonNullable<String> providerUserId) {
        Utils.checkNotNull(providerUserId, "providerUserId");
        this.providerUserId = providerUserId;
        return this;
    }

    public SAMLAccount withPublicMetadata(Map<String, Object> publicMetadata) {
        Utils.checkNotNull(publicMetadata, "publicMetadata");
        this.publicMetadata = Optional.ofNullable(publicMetadata);
        return this;
    }


    public SAMLAccount withPublicMetadata(Optional<? extends Map<String, Object>> publicMetadata) {
        Utils.checkNotNull(publicMetadata, "publicMetadata");
        this.publicMetadata = publicMetadata;
        return this;
    }

    public SAMLAccount withVerification(SAMLAccountVerification verification) {
        Utils.checkNotNull(verification, "verification");
        this.verification = Optional.ofNullable(verification);
        return this;
    }


    public SAMLAccount withVerification(Optional<? extends SAMLAccountVerification> verification) {
        Utils.checkNotNull(verification, "verification");
        this.verification = verification;
        return this;
    }

    public SAMLAccount withSamlConnection(SamlConnection samlConnection) {
        Utils.checkNotNull(samlConnection, "samlConnection");
        this.samlConnection = JsonNullable.of(samlConnection);
        return this;
    }

    public SAMLAccount withSamlConnection(JsonNullable<? extends SamlConnection> samlConnection) {
        Utils.checkNotNull(samlConnection, "samlConnection");
        this.samlConnection = samlConnection;
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
        SAMLAccount other = (SAMLAccount) o;
        return 
            Utils.enhancedDeepEquals(this.id, other.id) &&
            Utils.enhancedDeepEquals(this.object, other.object) &&
            Utils.enhancedDeepEquals(this.provider, other.provider) &&
            Utils.enhancedDeepEquals(this.active, other.active) &&
            Utils.enhancedDeepEquals(this.emailAddress, other.emailAddress) &&
            Utils.enhancedDeepEquals(this.firstName, other.firstName) &&
            Utils.enhancedDeepEquals(this.lastName, other.lastName) &&
            Utils.enhancedDeepEquals(this.providerUserId, other.providerUserId) &&
            Utils.enhancedDeepEquals(this.publicMetadata, other.publicMetadata) &&
            Utils.enhancedDeepEquals(this.verification, other.verification) &&
            Utils.enhancedDeepEquals(this.samlConnection, other.samlConnection);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            id, object, provider,
            active, emailAddress, firstName,
            lastName, providerUserId, publicMetadata,
            verification, samlConnection);
    }
    
    @Override
    public String toString() {
        return Utils.toString(SAMLAccount.class,
                "id", id,
                "object", object,
                "provider", provider,
                "active", active,
                "emailAddress", emailAddress,
                "firstName", firstName,
                "lastName", lastName,
                "providerUserId", providerUserId,
                "publicMetadata", publicMetadata,
                "verification", verification,
                "samlConnection", samlConnection);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String id;

        private SAMLAccountObject object;

        private String provider;

        private Boolean active;

        private String emailAddress;

        private JsonNullable<String> firstName = JsonNullable.undefined();

        private JsonNullable<String> lastName = JsonNullable.undefined();

        private JsonNullable<String> providerUserId = JsonNullable.undefined();

        private Optional<? extends Map<String, Object>> publicMetadata = Optional.empty();

        private Optional<? extends SAMLAccountVerification> verification = Optional.empty();

        private JsonNullable<? extends SamlConnection> samlConnection = JsonNullable.undefined();

        private Builder() {
          // force use of static builder() method
        }


        public Builder id(String id) {
            Utils.checkNotNull(id, "id");
            this.id = id;
            return this;
        }


        /**
         * String representing the object's type. Objects of the same type share the same value.
         */
        public Builder object(SAMLAccountObject object) {
            Utils.checkNotNull(object, "object");
            this.object = object;
            return this;
        }


        public Builder provider(String provider) {
            Utils.checkNotNull(provider, "provider");
            this.provider = provider;
            return this;
        }


        public Builder active(boolean active) {
            Utils.checkNotNull(active, "active");
            this.active = active;
            return this;
        }


        public Builder emailAddress(String emailAddress) {
            Utils.checkNotNull(emailAddress, "emailAddress");
            this.emailAddress = emailAddress;
            return this;
        }


        public Builder firstName(String firstName) {
            Utils.checkNotNull(firstName, "firstName");
            this.firstName = JsonNullable.of(firstName);
            return this;
        }

        public Builder firstName(JsonNullable<String> firstName) {
            Utils.checkNotNull(firstName, "firstName");
            this.firstName = firstName;
            return this;
        }


        public Builder lastName(String lastName) {
            Utils.checkNotNull(lastName, "lastName");
            this.lastName = JsonNullable.of(lastName);
            return this;
        }

        public Builder lastName(JsonNullable<String> lastName) {
            Utils.checkNotNull(lastName, "lastName");
            this.lastName = lastName;
            return this;
        }


        public Builder providerUserId(String providerUserId) {
            Utils.checkNotNull(providerUserId, "providerUserId");
            this.providerUserId = JsonNullable.of(providerUserId);
            return this;
        }

        public Builder providerUserId(JsonNullable<String> providerUserId) {
            Utils.checkNotNull(providerUserId, "providerUserId");
            this.providerUserId = providerUserId;
            return this;
        }


        public Builder publicMetadata(Map<String, Object> publicMetadata) {
            Utils.checkNotNull(publicMetadata, "publicMetadata");
            this.publicMetadata = Optional.ofNullable(publicMetadata);
            return this;
        }

        public Builder publicMetadata(Optional<? extends Map<String, Object>> publicMetadata) {
            Utils.checkNotNull(publicMetadata, "publicMetadata");
            this.publicMetadata = publicMetadata;
            return this;
        }


        public Builder verification(SAMLAccountVerification verification) {
            Utils.checkNotNull(verification, "verification");
            this.verification = Optional.ofNullable(verification);
            return this;
        }

        public Builder verification(Optional<? extends SAMLAccountVerification> verification) {
            Utils.checkNotNull(verification, "verification");
            this.verification = verification;
            return this;
        }


        public Builder samlConnection(SamlConnection samlConnection) {
            Utils.checkNotNull(samlConnection, "samlConnection");
            this.samlConnection = JsonNullable.of(samlConnection);
            return this;
        }

        public Builder samlConnection(JsonNullable<? extends SamlConnection> samlConnection) {
            Utils.checkNotNull(samlConnection, "samlConnection");
            this.samlConnection = samlConnection;
            return this;
        }

        public SAMLAccount build() {

            return new SAMLAccount(
                id, object, provider,
                active, emailAddress, firstName,
                lastName, providerUserId, publicMetadata,
                verification, samlConnection);
        }

    }
}
