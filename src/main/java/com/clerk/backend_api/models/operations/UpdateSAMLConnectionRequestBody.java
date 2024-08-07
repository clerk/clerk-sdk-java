/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.InputStream;
import java.lang.Deprecated;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.openapitools.jackson.nullable.JsonNullable;

public class UpdateSAMLConnectionRequestBody {

    /**
     * The name of the new SAML Connection
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("name")
    private JsonNullable<? extends String> name;

    /**
     * The domain to use for the new SAML Connection
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("domain")
    private JsonNullable<? extends String> domain;

    /**
     * The entity id as provided by the IdP
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("idp_entity_id")
    private JsonNullable<? extends String> idpEntityId;

    /**
     * The SSO url as provided by the IdP
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("idp_sso_url")
    private JsonNullable<? extends String> idpSsoUrl;

    /**
     * The x509 certificated as provided by the IdP
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("idp_certificate")
    private JsonNullable<? extends String> idpCertificate;

    /**
     * The URL which serves the IdP metadata. If present, it takes priority over the corresponding individual properties and replaces them
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("idp_metadata_url")
    private JsonNullable<? extends String> idpMetadataUrl;

    /**
     * The XML content of the IdP metadata file. If present, it takes priority over the corresponding individual properties
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("idp_metadata")
    private JsonNullable<? extends String> idpMetadata;

    /**
     * Define the atrtibute name mapping between Identity Provider and Clerk's user properties
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("attribute_mapping")
    private JsonNullable<? extends UpdateSAMLConnectionAttributeMapping> attributeMapping;

    /**
     * Activate or de-activate the SAML Connection
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("active")
    private JsonNullable<? extends Boolean> active;

    /**
     * Controls whether to update the user's attributes in each sign-in
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("sync_user_attributes")
    private JsonNullable<? extends Boolean> syncUserAttributes;

    /**
     * Allow users with an email address subdomain to use this connection in order to authenticate
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("allow_subdomains")
    private JsonNullable<? extends Boolean> allowSubdomains;

    /**
     * Enable or deactivate IdP-initiated flows
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("allow_idp_initiated")
    private JsonNullable<? extends Boolean> allowIdpInitiated;

    @JsonCreator
    public UpdateSAMLConnectionRequestBody(
            @JsonProperty("name") JsonNullable<? extends String> name,
            @JsonProperty("domain") JsonNullable<? extends String> domain,
            @JsonProperty("idp_entity_id") JsonNullable<? extends String> idpEntityId,
            @JsonProperty("idp_sso_url") JsonNullable<? extends String> idpSsoUrl,
            @JsonProperty("idp_certificate") JsonNullable<? extends String> idpCertificate,
            @JsonProperty("idp_metadata_url") JsonNullable<? extends String> idpMetadataUrl,
            @JsonProperty("idp_metadata") JsonNullable<? extends String> idpMetadata,
            @JsonProperty("attribute_mapping") JsonNullable<? extends UpdateSAMLConnectionAttributeMapping> attributeMapping,
            @JsonProperty("active") JsonNullable<? extends Boolean> active,
            @JsonProperty("sync_user_attributes") JsonNullable<? extends Boolean> syncUserAttributes,
            @JsonProperty("allow_subdomains") JsonNullable<? extends Boolean> allowSubdomains,
            @JsonProperty("allow_idp_initiated") JsonNullable<? extends Boolean> allowIdpInitiated) {
        Utils.checkNotNull(name, "name");
        Utils.checkNotNull(domain, "domain");
        Utils.checkNotNull(idpEntityId, "idpEntityId");
        Utils.checkNotNull(idpSsoUrl, "idpSsoUrl");
        Utils.checkNotNull(idpCertificate, "idpCertificate");
        Utils.checkNotNull(idpMetadataUrl, "idpMetadataUrl");
        Utils.checkNotNull(idpMetadata, "idpMetadata");
        Utils.checkNotNull(attributeMapping, "attributeMapping");
        Utils.checkNotNull(active, "active");
        Utils.checkNotNull(syncUserAttributes, "syncUserAttributes");
        Utils.checkNotNull(allowSubdomains, "allowSubdomains");
        Utils.checkNotNull(allowIdpInitiated, "allowIdpInitiated");
        this.name = name;
        this.domain = domain;
        this.idpEntityId = idpEntityId;
        this.idpSsoUrl = idpSsoUrl;
        this.idpCertificate = idpCertificate;
        this.idpMetadataUrl = idpMetadataUrl;
        this.idpMetadata = idpMetadata;
        this.attributeMapping = attributeMapping;
        this.active = active;
        this.syncUserAttributes = syncUserAttributes;
        this.allowSubdomains = allowSubdomains;
        this.allowIdpInitiated = allowIdpInitiated;
    }
    
    public UpdateSAMLConnectionRequestBody() {
        this(JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined());
    }

    /**
     * The name of the new SAML Connection
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<String> name() {
        return (JsonNullable<String>) name;
    }

    /**
     * The domain to use for the new SAML Connection
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<String> domain() {
        return (JsonNullable<String>) domain;
    }

    /**
     * The entity id as provided by the IdP
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<String> idpEntityId() {
        return (JsonNullable<String>) idpEntityId;
    }

    /**
     * The SSO url as provided by the IdP
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<String> idpSsoUrl() {
        return (JsonNullable<String>) idpSsoUrl;
    }

    /**
     * The x509 certificated as provided by the IdP
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<String> idpCertificate() {
        return (JsonNullable<String>) idpCertificate;
    }

    /**
     * The URL which serves the IdP metadata. If present, it takes priority over the corresponding individual properties and replaces them
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<String> idpMetadataUrl() {
        return (JsonNullable<String>) idpMetadataUrl;
    }

    /**
     * The XML content of the IdP metadata file. If present, it takes priority over the corresponding individual properties
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<String> idpMetadata() {
        return (JsonNullable<String>) idpMetadata;
    }

    /**
     * Define the atrtibute name mapping between Identity Provider and Clerk's user properties
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<UpdateSAMLConnectionAttributeMapping> attributeMapping() {
        return (JsonNullable<UpdateSAMLConnectionAttributeMapping>) attributeMapping;
    }

    /**
     * Activate or de-activate the SAML Connection
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<Boolean> active() {
        return (JsonNullable<Boolean>) active;
    }

    /**
     * Controls whether to update the user's attributes in each sign-in
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<Boolean> syncUserAttributes() {
        return (JsonNullable<Boolean>) syncUserAttributes;
    }

    /**
     * Allow users with an email address subdomain to use this connection in order to authenticate
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<Boolean> allowSubdomains() {
        return (JsonNullable<Boolean>) allowSubdomains;
    }

    /**
     * Enable or deactivate IdP-initiated flows
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<Boolean> allowIdpInitiated() {
        return (JsonNullable<Boolean>) allowIdpInitiated;
    }

    public final static Builder builder() {
        return new Builder();
    }

    /**
     * The name of the new SAML Connection
     */
    public UpdateSAMLConnectionRequestBody withName(String name) {
        Utils.checkNotNull(name, "name");
        this.name = JsonNullable.of(name);
        return this;
    }

    /**
     * The name of the new SAML Connection
     */
    public UpdateSAMLConnectionRequestBody withName(JsonNullable<? extends String> name) {
        Utils.checkNotNull(name, "name");
        this.name = name;
        return this;
    }

    /**
     * The domain to use for the new SAML Connection
     */
    public UpdateSAMLConnectionRequestBody withDomain(String domain) {
        Utils.checkNotNull(domain, "domain");
        this.domain = JsonNullable.of(domain);
        return this;
    }

    /**
     * The domain to use for the new SAML Connection
     */
    public UpdateSAMLConnectionRequestBody withDomain(JsonNullable<? extends String> domain) {
        Utils.checkNotNull(domain, "domain");
        this.domain = domain;
        return this;
    }

    /**
     * The entity id as provided by the IdP
     */
    public UpdateSAMLConnectionRequestBody withIdpEntityId(String idpEntityId) {
        Utils.checkNotNull(idpEntityId, "idpEntityId");
        this.idpEntityId = JsonNullable.of(idpEntityId);
        return this;
    }

    /**
     * The entity id as provided by the IdP
     */
    public UpdateSAMLConnectionRequestBody withIdpEntityId(JsonNullable<? extends String> idpEntityId) {
        Utils.checkNotNull(idpEntityId, "idpEntityId");
        this.idpEntityId = idpEntityId;
        return this;
    }

    /**
     * The SSO url as provided by the IdP
     */
    public UpdateSAMLConnectionRequestBody withIdpSsoUrl(String idpSsoUrl) {
        Utils.checkNotNull(idpSsoUrl, "idpSsoUrl");
        this.idpSsoUrl = JsonNullable.of(idpSsoUrl);
        return this;
    }

    /**
     * The SSO url as provided by the IdP
     */
    public UpdateSAMLConnectionRequestBody withIdpSsoUrl(JsonNullable<? extends String> idpSsoUrl) {
        Utils.checkNotNull(idpSsoUrl, "idpSsoUrl");
        this.idpSsoUrl = idpSsoUrl;
        return this;
    }

    /**
     * The x509 certificated as provided by the IdP
     */
    public UpdateSAMLConnectionRequestBody withIdpCertificate(String idpCertificate) {
        Utils.checkNotNull(idpCertificate, "idpCertificate");
        this.idpCertificate = JsonNullable.of(idpCertificate);
        return this;
    }

    /**
     * The x509 certificated as provided by the IdP
     */
    public UpdateSAMLConnectionRequestBody withIdpCertificate(JsonNullable<? extends String> idpCertificate) {
        Utils.checkNotNull(idpCertificate, "idpCertificate");
        this.idpCertificate = idpCertificate;
        return this;
    }

    /**
     * The URL which serves the IdP metadata. If present, it takes priority over the corresponding individual properties and replaces them
     */
    public UpdateSAMLConnectionRequestBody withIdpMetadataUrl(String idpMetadataUrl) {
        Utils.checkNotNull(idpMetadataUrl, "idpMetadataUrl");
        this.idpMetadataUrl = JsonNullable.of(idpMetadataUrl);
        return this;
    }

    /**
     * The URL which serves the IdP metadata. If present, it takes priority over the corresponding individual properties and replaces them
     */
    public UpdateSAMLConnectionRequestBody withIdpMetadataUrl(JsonNullable<? extends String> idpMetadataUrl) {
        Utils.checkNotNull(idpMetadataUrl, "idpMetadataUrl");
        this.idpMetadataUrl = idpMetadataUrl;
        return this;
    }

    /**
     * The XML content of the IdP metadata file. If present, it takes priority over the corresponding individual properties
     */
    public UpdateSAMLConnectionRequestBody withIdpMetadata(String idpMetadata) {
        Utils.checkNotNull(idpMetadata, "idpMetadata");
        this.idpMetadata = JsonNullable.of(idpMetadata);
        return this;
    }

    /**
     * The XML content of the IdP metadata file. If present, it takes priority over the corresponding individual properties
     */
    public UpdateSAMLConnectionRequestBody withIdpMetadata(JsonNullable<? extends String> idpMetadata) {
        Utils.checkNotNull(idpMetadata, "idpMetadata");
        this.idpMetadata = idpMetadata;
        return this;
    }

    /**
     * Define the atrtibute name mapping between Identity Provider and Clerk's user properties
     */
    public UpdateSAMLConnectionRequestBody withAttributeMapping(UpdateSAMLConnectionAttributeMapping attributeMapping) {
        Utils.checkNotNull(attributeMapping, "attributeMapping");
        this.attributeMapping = JsonNullable.of(attributeMapping);
        return this;
    }

    /**
     * Define the atrtibute name mapping between Identity Provider and Clerk's user properties
     */
    public UpdateSAMLConnectionRequestBody withAttributeMapping(JsonNullable<? extends UpdateSAMLConnectionAttributeMapping> attributeMapping) {
        Utils.checkNotNull(attributeMapping, "attributeMapping");
        this.attributeMapping = attributeMapping;
        return this;
    }

    /**
     * Activate or de-activate the SAML Connection
     */
    public UpdateSAMLConnectionRequestBody withActive(boolean active) {
        Utils.checkNotNull(active, "active");
        this.active = JsonNullable.of(active);
        return this;
    }

    /**
     * Activate or de-activate the SAML Connection
     */
    public UpdateSAMLConnectionRequestBody withActive(JsonNullable<? extends Boolean> active) {
        Utils.checkNotNull(active, "active");
        this.active = active;
        return this;
    }

    /**
     * Controls whether to update the user's attributes in each sign-in
     */
    public UpdateSAMLConnectionRequestBody withSyncUserAttributes(boolean syncUserAttributes) {
        Utils.checkNotNull(syncUserAttributes, "syncUserAttributes");
        this.syncUserAttributes = JsonNullable.of(syncUserAttributes);
        return this;
    }

    /**
     * Controls whether to update the user's attributes in each sign-in
     */
    public UpdateSAMLConnectionRequestBody withSyncUserAttributes(JsonNullable<? extends Boolean> syncUserAttributes) {
        Utils.checkNotNull(syncUserAttributes, "syncUserAttributes");
        this.syncUserAttributes = syncUserAttributes;
        return this;
    }

    /**
     * Allow users with an email address subdomain to use this connection in order to authenticate
     */
    public UpdateSAMLConnectionRequestBody withAllowSubdomains(boolean allowSubdomains) {
        Utils.checkNotNull(allowSubdomains, "allowSubdomains");
        this.allowSubdomains = JsonNullable.of(allowSubdomains);
        return this;
    }

    /**
     * Allow users with an email address subdomain to use this connection in order to authenticate
     */
    public UpdateSAMLConnectionRequestBody withAllowSubdomains(JsonNullable<? extends Boolean> allowSubdomains) {
        Utils.checkNotNull(allowSubdomains, "allowSubdomains");
        this.allowSubdomains = allowSubdomains;
        return this;
    }

    /**
     * Enable or deactivate IdP-initiated flows
     */
    public UpdateSAMLConnectionRequestBody withAllowIdpInitiated(boolean allowIdpInitiated) {
        Utils.checkNotNull(allowIdpInitiated, "allowIdpInitiated");
        this.allowIdpInitiated = JsonNullable.of(allowIdpInitiated);
        return this;
    }

    /**
     * Enable or deactivate IdP-initiated flows
     */
    public UpdateSAMLConnectionRequestBody withAllowIdpInitiated(JsonNullable<? extends Boolean> allowIdpInitiated) {
        Utils.checkNotNull(allowIdpInitiated, "allowIdpInitiated");
        this.allowIdpInitiated = allowIdpInitiated;
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
        UpdateSAMLConnectionRequestBody other = (UpdateSAMLConnectionRequestBody) o;
        return 
            java.util.Objects.deepEquals(this.name, other.name) &&
            java.util.Objects.deepEquals(this.domain, other.domain) &&
            java.util.Objects.deepEquals(this.idpEntityId, other.idpEntityId) &&
            java.util.Objects.deepEquals(this.idpSsoUrl, other.idpSsoUrl) &&
            java.util.Objects.deepEquals(this.idpCertificate, other.idpCertificate) &&
            java.util.Objects.deepEquals(this.idpMetadataUrl, other.idpMetadataUrl) &&
            java.util.Objects.deepEquals(this.idpMetadata, other.idpMetadata) &&
            java.util.Objects.deepEquals(this.attributeMapping, other.attributeMapping) &&
            java.util.Objects.deepEquals(this.active, other.active) &&
            java.util.Objects.deepEquals(this.syncUserAttributes, other.syncUserAttributes) &&
            java.util.Objects.deepEquals(this.allowSubdomains, other.allowSubdomains) &&
            java.util.Objects.deepEquals(this.allowIdpInitiated, other.allowIdpInitiated);
    }
    
    @Override
    public int hashCode() {
        return java.util.Objects.hash(
            name,
            domain,
            idpEntityId,
            idpSsoUrl,
            idpCertificate,
            idpMetadataUrl,
            idpMetadata,
            attributeMapping,
            active,
            syncUserAttributes,
            allowSubdomains,
            allowIdpInitiated);
    }
    
    @Override
    public String toString() {
        return Utils.toString(UpdateSAMLConnectionRequestBody.class,
                "name", name,
                "domain", domain,
                "idpEntityId", idpEntityId,
                "idpSsoUrl", idpSsoUrl,
                "idpCertificate", idpCertificate,
                "idpMetadataUrl", idpMetadataUrl,
                "idpMetadata", idpMetadata,
                "attributeMapping", attributeMapping,
                "active", active,
                "syncUserAttributes", syncUserAttributes,
                "allowSubdomains", allowSubdomains,
                "allowIdpInitiated", allowIdpInitiated);
    }
    
    public final static class Builder {
 
        private JsonNullable<? extends String> name = JsonNullable.undefined();
 
        private JsonNullable<? extends String> domain = JsonNullable.undefined();
 
        private JsonNullable<? extends String> idpEntityId = JsonNullable.undefined();
 
        private JsonNullable<? extends String> idpSsoUrl = JsonNullable.undefined();
 
        private JsonNullable<? extends String> idpCertificate = JsonNullable.undefined();
 
        private JsonNullable<? extends String> idpMetadataUrl = JsonNullable.undefined();
 
        private JsonNullable<? extends String> idpMetadata = JsonNullable.undefined();
 
        private JsonNullable<? extends UpdateSAMLConnectionAttributeMapping> attributeMapping = JsonNullable.undefined();
 
        private JsonNullable<? extends Boolean> active = JsonNullable.undefined();
 
        private JsonNullable<? extends Boolean> syncUserAttributes = JsonNullable.undefined();
 
        private JsonNullable<? extends Boolean> allowSubdomains = JsonNullable.undefined();
 
        private JsonNullable<? extends Boolean> allowIdpInitiated = JsonNullable.undefined();  
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * The name of the new SAML Connection
         */
        public Builder name(String name) {
            Utils.checkNotNull(name, "name");
            this.name = JsonNullable.of(name);
            return this;
        }

        /**
         * The name of the new SAML Connection
         */
        public Builder name(JsonNullable<? extends String> name) {
            Utils.checkNotNull(name, "name");
            this.name = name;
            return this;
        }

        /**
         * The domain to use for the new SAML Connection
         */
        public Builder domain(String domain) {
            Utils.checkNotNull(domain, "domain");
            this.domain = JsonNullable.of(domain);
            return this;
        }

        /**
         * The domain to use for the new SAML Connection
         */
        public Builder domain(JsonNullable<? extends String> domain) {
            Utils.checkNotNull(domain, "domain");
            this.domain = domain;
            return this;
        }

        /**
         * The entity id as provided by the IdP
         */
        public Builder idpEntityId(String idpEntityId) {
            Utils.checkNotNull(idpEntityId, "idpEntityId");
            this.idpEntityId = JsonNullable.of(idpEntityId);
            return this;
        }

        /**
         * The entity id as provided by the IdP
         */
        public Builder idpEntityId(JsonNullable<? extends String> idpEntityId) {
            Utils.checkNotNull(idpEntityId, "idpEntityId");
            this.idpEntityId = idpEntityId;
            return this;
        }

        /**
         * The SSO url as provided by the IdP
         */
        public Builder idpSsoUrl(String idpSsoUrl) {
            Utils.checkNotNull(idpSsoUrl, "idpSsoUrl");
            this.idpSsoUrl = JsonNullable.of(idpSsoUrl);
            return this;
        }

        /**
         * The SSO url as provided by the IdP
         */
        public Builder idpSsoUrl(JsonNullable<? extends String> idpSsoUrl) {
            Utils.checkNotNull(idpSsoUrl, "idpSsoUrl");
            this.idpSsoUrl = idpSsoUrl;
            return this;
        }

        /**
         * The x509 certificated as provided by the IdP
         */
        public Builder idpCertificate(String idpCertificate) {
            Utils.checkNotNull(idpCertificate, "idpCertificate");
            this.idpCertificate = JsonNullable.of(idpCertificate);
            return this;
        }

        /**
         * The x509 certificated as provided by the IdP
         */
        public Builder idpCertificate(JsonNullable<? extends String> idpCertificate) {
            Utils.checkNotNull(idpCertificate, "idpCertificate");
            this.idpCertificate = idpCertificate;
            return this;
        }

        /**
         * The URL which serves the IdP metadata. If present, it takes priority over the corresponding individual properties and replaces them
         */
        public Builder idpMetadataUrl(String idpMetadataUrl) {
            Utils.checkNotNull(idpMetadataUrl, "idpMetadataUrl");
            this.idpMetadataUrl = JsonNullable.of(idpMetadataUrl);
            return this;
        }

        /**
         * The URL which serves the IdP metadata. If present, it takes priority over the corresponding individual properties and replaces them
         */
        public Builder idpMetadataUrl(JsonNullable<? extends String> idpMetadataUrl) {
            Utils.checkNotNull(idpMetadataUrl, "idpMetadataUrl");
            this.idpMetadataUrl = idpMetadataUrl;
            return this;
        }

        /**
         * The XML content of the IdP metadata file. If present, it takes priority over the corresponding individual properties
         */
        public Builder idpMetadata(String idpMetadata) {
            Utils.checkNotNull(idpMetadata, "idpMetadata");
            this.idpMetadata = JsonNullable.of(idpMetadata);
            return this;
        }

        /**
         * The XML content of the IdP metadata file. If present, it takes priority over the corresponding individual properties
         */
        public Builder idpMetadata(JsonNullable<? extends String> idpMetadata) {
            Utils.checkNotNull(idpMetadata, "idpMetadata");
            this.idpMetadata = idpMetadata;
            return this;
        }

        /**
         * Define the atrtibute name mapping between Identity Provider and Clerk's user properties
         */
        public Builder attributeMapping(UpdateSAMLConnectionAttributeMapping attributeMapping) {
            Utils.checkNotNull(attributeMapping, "attributeMapping");
            this.attributeMapping = JsonNullable.of(attributeMapping);
            return this;
        }

        /**
         * Define the atrtibute name mapping between Identity Provider and Clerk's user properties
         */
        public Builder attributeMapping(JsonNullable<? extends UpdateSAMLConnectionAttributeMapping> attributeMapping) {
            Utils.checkNotNull(attributeMapping, "attributeMapping");
            this.attributeMapping = attributeMapping;
            return this;
        }

        /**
         * Activate or de-activate the SAML Connection
         */
        public Builder active(boolean active) {
            Utils.checkNotNull(active, "active");
            this.active = JsonNullable.of(active);
            return this;
        }

        /**
         * Activate or de-activate the SAML Connection
         */
        public Builder active(JsonNullable<? extends Boolean> active) {
            Utils.checkNotNull(active, "active");
            this.active = active;
            return this;
        }

        /**
         * Controls whether to update the user's attributes in each sign-in
         */
        public Builder syncUserAttributes(boolean syncUserAttributes) {
            Utils.checkNotNull(syncUserAttributes, "syncUserAttributes");
            this.syncUserAttributes = JsonNullable.of(syncUserAttributes);
            return this;
        }

        /**
         * Controls whether to update the user's attributes in each sign-in
         */
        public Builder syncUserAttributes(JsonNullable<? extends Boolean> syncUserAttributes) {
            Utils.checkNotNull(syncUserAttributes, "syncUserAttributes");
            this.syncUserAttributes = syncUserAttributes;
            return this;
        }

        /**
         * Allow users with an email address subdomain to use this connection in order to authenticate
         */
        public Builder allowSubdomains(boolean allowSubdomains) {
            Utils.checkNotNull(allowSubdomains, "allowSubdomains");
            this.allowSubdomains = JsonNullable.of(allowSubdomains);
            return this;
        }

        /**
         * Allow users with an email address subdomain to use this connection in order to authenticate
         */
        public Builder allowSubdomains(JsonNullable<? extends Boolean> allowSubdomains) {
            Utils.checkNotNull(allowSubdomains, "allowSubdomains");
            this.allowSubdomains = allowSubdomains;
            return this;
        }

        /**
         * Enable or deactivate IdP-initiated flows
         */
        public Builder allowIdpInitiated(boolean allowIdpInitiated) {
            Utils.checkNotNull(allowIdpInitiated, "allowIdpInitiated");
            this.allowIdpInitiated = JsonNullable.of(allowIdpInitiated);
            return this;
        }

        /**
         * Enable or deactivate IdP-initiated flows
         */
        public Builder allowIdpInitiated(JsonNullable<? extends Boolean> allowIdpInitiated) {
            Utils.checkNotNull(allowIdpInitiated, "allowIdpInitiated");
            this.allowIdpInitiated = allowIdpInitiated;
            return this;
        }
        
        public UpdateSAMLConnectionRequestBody build() {
            return new UpdateSAMLConnectionRequestBody(
                name,
                domain,
                idpEntityId,
                idpSsoUrl,
                idpCertificate,
                idpMetadataUrl,
                idpMetadata,
                attributeMapping,
                active,
                syncUserAttributes,
                allowSubdomains,
                allowIdpInitiated);
        }
    }
}

