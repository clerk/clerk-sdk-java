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
import org.openapitools.jackson.nullable.JsonNullable;


public class CreateSAMLConnectionRequestBody {

    /**
     * The name to use as a label for this SAML Connection
     */
    @JsonProperty("name")
    private String name;

    /**
     * The domain of your organization. Sign in flows using an email with this domain, will use this SAML Connection.
     */
    @JsonProperty("domain")
    private String domain;

    /**
     * The IdP provider of the connection.
     */
    @JsonProperty("provider")
    private Provider provider;

    /**
     * The Entity ID as provided by the IdP
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("idp_entity_id")
    private JsonNullable<String> idpEntityId;

    /**
     * The Single-Sign On URL as provided by the IdP
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("idp_sso_url")
    private JsonNullable<String> idpSsoUrl;

    /**
     * The X.509 certificate as provided by the IdP
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("idp_certificate")
    private JsonNullable<String> idpCertificate;

    /**
     * The URL which serves the IdP metadata. If present, it takes priority over the corresponding individual properties
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("idp_metadata_url")
    private JsonNullable<String> idpMetadataUrl;

    /**
     * The XML content of the IdP metadata file. If present, it takes priority over the corresponding individual properties
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("idp_metadata")
    private JsonNullable<String> idpMetadata;

    /**
     * The ID of the organization to which users of this SAML Connection will be added
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("organization_id")
    private JsonNullable<String> organizationId;

    /**
     * Define the attribute name mapping between Identity Provider and Clerk's user properties
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("attribute_mapping")
    private JsonNullable<? extends AttributeMapping> attributeMapping;

    @JsonCreator
    public CreateSAMLConnectionRequestBody(
            @JsonProperty("name") String name,
            @JsonProperty("domain") String domain,
            @JsonProperty("provider") Provider provider,
            @JsonProperty("idp_entity_id") JsonNullable<String> idpEntityId,
            @JsonProperty("idp_sso_url") JsonNullable<String> idpSsoUrl,
            @JsonProperty("idp_certificate") JsonNullable<String> idpCertificate,
            @JsonProperty("idp_metadata_url") JsonNullable<String> idpMetadataUrl,
            @JsonProperty("idp_metadata") JsonNullable<String> idpMetadata,
            @JsonProperty("organization_id") JsonNullable<String> organizationId,
            @JsonProperty("attribute_mapping") JsonNullable<? extends AttributeMapping> attributeMapping) {
        Utils.checkNotNull(name, "name");
        Utils.checkNotNull(domain, "domain");
        Utils.checkNotNull(provider, "provider");
        Utils.checkNotNull(idpEntityId, "idpEntityId");
        Utils.checkNotNull(idpSsoUrl, "idpSsoUrl");
        Utils.checkNotNull(idpCertificate, "idpCertificate");
        Utils.checkNotNull(idpMetadataUrl, "idpMetadataUrl");
        Utils.checkNotNull(idpMetadata, "idpMetadata");
        Utils.checkNotNull(organizationId, "organizationId");
        Utils.checkNotNull(attributeMapping, "attributeMapping");
        this.name = name;
        this.domain = domain;
        this.provider = provider;
        this.idpEntityId = idpEntityId;
        this.idpSsoUrl = idpSsoUrl;
        this.idpCertificate = idpCertificate;
        this.idpMetadataUrl = idpMetadataUrl;
        this.idpMetadata = idpMetadata;
        this.organizationId = organizationId;
        this.attributeMapping = attributeMapping;
    }
    
    public CreateSAMLConnectionRequestBody(
            String name,
            String domain,
            Provider provider) {
        this(name, domain, provider, JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined());
    }

    /**
     * The name to use as a label for this SAML Connection
     */
    @JsonIgnore
    public String name() {
        return name;
    }

    /**
     * The domain of your organization. Sign in flows using an email with this domain, will use this SAML Connection.
     */
    @JsonIgnore
    public String domain() {
        return domain;
    }

    /**
     * The IdP provider of the connection.
     */
    @JsonIgnore
    public Provider provider() {
        return provider;
    }

    /**
     * The Entity ID as provided by the IdP
     */
    @JsonIgnore
    public JsonNullable<String> idpEntityId() {
        return idpEntityId;
    }

    /**
     * The Single-Sign On URL as provided by the IdP
     */
    @JsonIgnore
    public JsonNullable<String> idpSsoUrl() {
        return idpSsoUrl;
    }

    /**
     * The X.509 certificate as provided by the IdP
     */
    @JsonIgnore
    public JsonNullable<String> idpCertificate() {
        return idpCertificate;
    }

    /**
     * The URL which serves the IdP metadata. If present, it takes priority over the corresponding individual properties
     */
    @JsonIgnore
    public JsonNullable<String> idpMetadataUrl() {
        return idpMetadataUrl;
    }

    /**
     * The XML content of the IdP metadata file. If present, it takes priority over the corresponding individual properties
     */
    @JsonIgnore
    public JsonNullable<String> idpMetadata() {
        return idpMetadata;
    }

    /**
     * The ID of the organization to which users of this SAML Connection will be added
     */
    @JsonIgnore
    public JsonNullable<String> organizationId() {
        return organizationId;
    }

    /**
     * Define the attribute name mapping between Identity Provider and Clerk's user properties
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<AttributeMapping> attributeMapping() {
        return (JsonNullable<AttributeMapping>) attributeMapping;
    }

    public final static Builder builder() {
        return new Builder();
    }

    /**
     * The name to use as a label for this SAML Connection
     */
    public CreateSAMLConnectionRequestBody withName(String name) {
        Utils.checkNotNull(name, "name");
        this.name = name;
        return this;
    }

    /**
     * The domain of your organization. Sign in flows using an email with this domain, will use this SAML Connection.
     */
    public CreateSAMLConnectionRequestBody withDomain(String domain) {
        Utils.checkNotNull(domain, "domain");
        this.domain = domain;
        return this;
    }

    /**
     * The IdP provider of the connection.
     */
    public CreateSAMLConnectionRequestBody withProvider(Provider provider) {
        Utils.checkNotNull(provider, "provider");
        this.provider = provider;
        return this;
    }

    /**
     * The Entity ID as provided by the IdP
     */
    public CreateSAMLConnectionRequestBody withIdpEntityId(String idpEntityId) {
        Utils.checkNotNull(idpEntityId, "idpEntityId");
        this.idpEntityId = JsonNullable.of(idpEntityId);
        return this;
    }

    /**
     * The Entity ID as provided by the IdP
     */
    public CreateSAMLConnectionRequestBody withIdpEntityId(JsonNullable<String> idpEntityId) {
        Utils.checkNotNull(idpEntityId, "idpEntityId");
        this.idpEntityId = idpEntityId;
        return this;
    }

    /**
     * The Single-Sign On URL as provided by the IdP
     */
    public CreateSAMLConnectionRequestBody withIdpSsoUrl(String idpSsoUrl) {
        Utils.checkNotNull(idpSsoUrl, "idpSsoUrl");
        this.idpSsoUrl = JsonNullable.of(idpSsoUrl);
        return this;
    }

    /**
     * The Single-Sign On URL as provided by the IdP
     */
    public CreateSAMLConnectionRequestBody withIdpSsoUrl(JsonNullable<String> idpSsoUrl) {
        Utils.checkNotNull(idpSsoUrl, "idpSsoUrl");
        this.idpSsoUrl = idpSsoUrl;
        return this;
    }

    /**
     * The X.509 certificate as provided by the IdP
     */
    public CreateSAMLConnectionRequestBody withIdpCertificate(String idpCertificate) {
        Utils.checkNotNull(idpCertificate, "idpCertificate");
        this.idpCertificate = JsonNullable.of(idpCertificate);
        return this;
    }

    /**
     * The X.509 certificate as provided by the IdP
     */
    public CreateSAMLConnectionRequestBody withIdpCertificate(JsonNullable<String> idpCertificate) {
        Utils.checkNotNull(idpCertificate, "idpCertificate");
        this.idpCertificate = idpCertificate;
        return this;
    }

    /**
     * The URL which serves the IdP metadata. If present, it takes priority over the corresponding individual properties
     */
    public CreateSAMLConnectionRequestBody withIdpMetadataUrl(String idpMetadataUrl) {
        Utils.checkNotNull(idpMetadataUrl, "idpMetadataUrl");
        this.idpMetadataUrl = JsonNullable.of(idpMetadataUrl);
        return this;
    }

    /**
     * The URL which serves the IdP metadata. If present, it takes priority over the corresponding individual properties
     */
    public CreateSAMLConnectionRequestBody withIdpMetadataUrl(JsonNullable<String> idpMetadataUrl) {
        Utils.checkNotNull(idpMetadataUrl, "idpMetadataUrl");
        this.idpMetadataUrl = idpMetadataUrl;
        return this;
    }

    /**
     * The XML content of the IdP metadata file. If present, it takes priority over the corresponding individual properties
     */
    public CreateSAMLConnectionRequestBody withIdpMetadata(String idpMetadata) {
        Utils.checkNotNull(idpMetadata, "idpMetadata");
        this.idpMetadata = JsonNullable.of(idpMetadata);
        return this;
    }

    /**
     * The XML content of the IdP metadata file. If present, it takes priority over the corresponding individual properties
     */
    public CreateSAMLConnectionRequestBody withIdpMetadata(JsonNullable<String> idpMetadata) {
        Utils.checkNotNull(idpMetadata, "idpMetadata");
        this.idpMetadata = idpMetadata;
        return this;
    }

    /**
     * The ID of the organization to which users of this SAML Connection will be added
     */
    public CreateSAMLConnectionRequestBody withOrganizationId(String organizationId) {
        Utils.checkNotNull(organizationId, "organizationId");
        this.organizationId = JsonNullable.of(organizationId);
        return this;
    }

    /**
     * The ID of the organization to which users of this SAML Connection will be added
     */
    public CreateSAMLConnectionRequestBody withOrganizationId(JsonNullable<String> organizationId) {
        Utils.checkNotNull(organizationId, "organizationId");
        this.organizationId = organizationId;
        return this;
    }

    /**
     * Define the attribute name mapping between Identity Provider and Clerk's user properties
     */
    public CreateSAMLConnectionRequestBody withAttributeMapping(AttributeMapping attributeMapping) {
        Utils.checkNotNull(attributeMapping, "attributeMapping");
        this.attributeMapping = JsonNullable.of(attributeMapping);
        return this;
    }

    /**
     * Define the attribute name mapping between Identity Provider and Clerk's user properties
     */
    public CreateSAMLConnectionRequestBody withAttributeMapping(JsonNullable<? extends AttributeMapping> attributeMapping) {
        Utils.checkNotNull(attributeMapping, "attributeMapping");
        this.attributeMapping = attributeMapping;
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
        CreateSAMLConnectionRequestBody other = (CreateSAMLConnectionRequestBody) o;
        return 
            Objects.deepEquals(this.name, other.name) &&
            Objects.deepEquals(this.domain, other.domain) &&
            Objects.deepEquals(this.provider, other.provider) &&
            Objects.deepEquals(this.idpEntityId, other.idpEntityId) &&
            Objects.deepEquals(this.idpSsoUrl, other.idpSsoUrl) &&
            Objects.deepEquals(this.idpCertificate, other.idpCertificate) &&
            Objects.deepEquals(this.idpMetadataUrl, other.idpMetadataUrl) &&
            Objects.deepEquals(this.idpMetadata, other.idpMetadata) &&
            Objects.deepEquals(this.organizationId, other.organizationId) &&
            Objects.deepEquals(this.attributeMapping, other.attributeMapping);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            name,
            domain,
            provider,
            idpEntityId,
            idpSsoUrl,
            idpCertificate,
            idpMetadataUrl,
            idpMetadata,
            organizationId,
            attributeMapping);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CreateSAMLConnectionRequestBody.class,
                "name", name,
                "domain", domain,
                "provider", provider,
                "idpEntityId", idpEntityId,
                "idpSsoUrl", idpSsoUrl,
                "idpCertificate", idpCertificate,
                "idpMetadataUrl", idpMetadataUrl,
                "idpMetadata", idpMetadata,
                "organizationId", organizationId,
                "attributeMapping", attributeMapping);
    }
    
    public final static class Builder {
 
        private String name;
 
        private String domain;
 
        private Provider provider;
 
        private JsonNullable<String> idpEntityId = JsonNullable.undefined();
 
        private JsonNullable<String> idpSsoUrl = JsonNullable.undefined();
 
        private JsonNullable<String> idpCertificate = JsonNullable.undefined();
 
        private JsonNullable<String> idpMetadataUrl = JsonNullable.undefined();
 
        private JsonNullable<String> idpMetadata = JsonNullable.undefined();
 
        private JsonNullable<String> organizationId = JsonNullable.undefined();
 
        private JsonNullable<? extends AttributeMapping> attributeMapping = JsonNullable.undefined();  
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * The name to use as a label for this SAML Connection
         */
        public Builder name(String name) {
            Utils.checkNotNull(name, "name");
            this.name = name;
            return this;
        }

        /**
         * The domain of your organization. Sign in flows using an email with this domain, will use this SAML Connection.
         */
        public Builder domain(String domain) {
            Utils.checkNotNull(domain, "domain");
            this.domain = domain;
            return this;
        }

        /**
         * The IdP provider of the connection.
         */
        public Builder provider(Provider provider) {
            Utils.checkNotNull(provider, "provider");
            this.provider = provider;
            return this;
        }

        /**
         * The Entity ID as provided by the IdP
         */
        public Builder idpEntityId(String idpEntityId) {
            Utils.checkNotNull(idpEntityId, "idpEntityId");
            this.idpEntityId = JsonNullable.of(idpEntityId);
            return this;
        }

        /**
         * The Entity ID as provided by the IdP
         */
        public Builder idpEntityId(JsonNullable<String> idpEntityId) {
            Utils.checkNotNull(idpEntityId, "idpEntityId");
            this.idpEntityId = idpEntityId;
            return this;
        }

        /**
         * The Single-Sign On URL as provided by the IdP
         */
        public Builder idpSsoUrl(String idpSsoUrl) {
            Utils.checkNotNull(idpSsoUrl, "idpSsoUrl");
            this.idpSsoUrl = JsonNullable.of(idpSsoUrl);
            return this;
        }

        /**
         * The Single-Sign On URL as provided by the IdP
         */
        public Builder idpSsoUrl(JsonNullable<String> idpSsoUrl) {
            Utils.checkNotNull(idpSsoUrl, "idpSsoUrl");
            this.idpSsoUrl = idpSsoUrl;
            return this;
        }

        /**
         * The X.509 certificate as provided by the IdP
         */
        public Builder idpCertificate(String idpCertificate) {
            Utils.checkNotNull(idpCertificate, "idpCertificate");
            this.idpCertificate = JsonNullable.of(idpCertificate);
            return this;
        }

        /**
         * The X.509 certificate as provided by the IdP
         */
        public Builder idpCertificate(JsonNullable<String> idpCertificate) {
            Utils.checkNotNull(idpCertificate, "idpCertificate");
            this.idpCertificate = idpCertificate;
            return this;
        }

        /**
         * The URL which serves the IdP metadata. If present, it takes priority over the corresponding individual properties
         */
        public Builder idpMetadataUrl(String idpMetadataUrl) {
            Utils.checkNotNull(idpMetadataUrl, "idpMetadataUrl");
            this.idpMetadataUrl = JsonNullable.of(idpMetadataUrl);
            return this;
        }

        /**
         * The URL which serves the IdP metadata. If present, it takes priority over the corresponding individual properties
         */
        public Builder idpMetadataUrl(JsonNullable<String> idpMetadataUrl) {
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
        public Builder idpMetadata(JsonNullable<String> idpMetadata) {
            Utils.checkNotNull(idpMetadata, "idpMetadata");
            this.idpMetadata = idpMetadata;
            return this;
        }

        /**
         * The ID of the organization to which users of this SAML Connection will be added
         */
        public Builder organizationId(String organizationId) {
            Utils.checkNotNull(organizationId, "organizationId");
            this.organizationId = JsonNullable.of(organizationId);
            return this;
        }

        /**
         * The ID of the organization to which users of this SAML Connection will be added
         */
        public Builder organizationId(JsonNullable<String> organizationId) {
            Utils.checkNotNull(organizationId, "organizationId");
            this.organizationId = organizationId;
            return this;
        }

        /**
         * Define the attribute name mapping between Identity Provider and Clerk's user properties
         */
        public Builder attributeMapping(AttributeMapping attributeMapping) {
            Utils.checkNotNull(attributeMapping, "attributeMapping");
            this.attributeMapping = JsonNullable.of(attributeMapping);
            return this;
        }

        /**
         * Define the attribute name mapping between Identity Provider and Clerk's user properties
         */
        public Builder attributeMapping(JsonNullable<? extends AttributeMapping> attributeMapping) {
            Utils.checkNotNull(attributeMapping, "attributeMapping");
            this.attributeMapping = attributeMapping;
            return this;
        }
        
        public CreateSAMLConnectionRequestBody build() {
            return new CreateSAMLConnectionRequestBody(
                name,
                domain,
                provider,
                idpEntityId,
                idpSsoUrl,
                idpCertificate,
                idpMetadataUrl,
                idpMetadata,
                organizationId,
                attributeMapping);
        }
    }
}

