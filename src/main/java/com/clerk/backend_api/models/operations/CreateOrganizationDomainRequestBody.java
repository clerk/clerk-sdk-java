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
import java.lang.Override;
import java.lang.String;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;


public class CreateOrganizationDomainRequestBody {
    /**
     * The name of the new domain
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("name")
    private Optional<String> name;

    /**
     * The enrollment_mode for the new domain. This can be `automatic_invitation`, `automatic_suggestion` or `manual_invitation`
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("enrollment_mode")
    private Optional<String> enrollmentMode;

    /**
     * The status of domain's verification. Defaults to true
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("verified")
    private JsonNullable<Boolean> verified;

    @JsonCreator
    public CreateOrganizationDomainRequestBody(
            @JsonProperty("name") Optional<String> name,
            @JsonProperty("enrollment_mode") Optional<String> enrollmentMode,
            @JsonProperty("verified") JsonNullable<Boolean> verified) {
        Utils.checkNotNull(name, "name");
        Utils.checkNotNull(enrollmentMode, "enrollmentMode");
        Utils.checkNotNull(verified, "verified");
        this.name = name;
        this.enrollmentMode = enrollmentMode;
        this.verified = verified;
    }
    
    public CreateOrganizationDomainRequestBody() {
        this(Optional.empty(), Optional.empty(), JsonNullable.undefined());
    }

    /**
     * The name of the new domain
     */
    @JsonIgnore
    public Optional<String> name() {
        return name;
    }

    /**
     * The enrollment_mode for the new domain. This can be `automatic_invitation`, `automatic_suggestion` or `manual_invitation`
     */
    @JsonIgnore
    public Optional<String> enrollmentMode() {
        return enrollmentMode;
    }

    /**
     * The status of domain's verification. Defaults to true
     */
    @JsonIgnore
    public JsonNullable<Boolean> verified() {
        return verified;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * The name of the new domain
     */
    public CreateOrganizationDomainRequestBody withName(String name) {
        Utils.checkNotNull(name, "name");
        this.name = Optional.ofNullable(name);
        return this;
    }


    /**
     * The name of the new domain
     */
    public CreateOrganizationDomainRequestBody withName(Optional<String> name) {
        Utils.checkNotNull(name, "name");
        this.name = name;
        return this;
    }

    /**
     * The enrollment_mode for the new domain. This can be `automatic_invitation`, `automatic_suggestion` or `manual_invitation`
     */
    public CreateOrganizationDomainRequestBody withEnrollmentMode(String enrollmentMode) {
        Utils.checkNotNull(enrollmentMode, "enrollmentMode");
        this.enrollmentMode = Optional.ofNullable(enrollmentMode);
        return this;
    }


    /**
     * The enrollment_mode for the new domain. This can be `automatic_invitation`, `automatic_suggestion` or `manual_invitation`
     */
    public CreateOrganizationDomainRequestBody withEnrollmentMode(Optional<String> enrollmentMode) {
        Utils.checkNotNull(enrollmentMode, "enrollmentMode");
        this.enrollmentMode = enrollmentMode;
        return this;
    }

    /**
     * The status of domain's verification. Defaults to true
     */
    public CreateOrganizationDomainRequestBody withVerified(boolean verified) {
        Utils.checkNotNull(verified, "verified");
        this.verified = JsonNullable.of(verified);
        return this;
    }

    /**
     * The status of domain's verification. Defaults to true
     */
    public CreateOrganizationDomainRequestBody withVerified(JsonNullable<Boolean> verified) {
        Utils.checkNotNull(verified, "verified");
        this.verified = verified;
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
        CreateOrganizationDomainRequestBody other = (CreateOrganizationDomainRequestBody) o;
        return 
            Utils.enhancedDeepEquals(this.name, other.name) &&
            Utils.enhancedDeepEquals(this.enrollmentMode, other.enrollmentMode) &&
            Utils.enhancedDeepEquals(this.verified, other.verified);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            name, enrollmentMode, verified);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CreateOrganizationDomainRequestBody.class,
                "name", name,
                "enrollmentMode", enrollmentMode,
                "verified", verified);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private Optional<String> name = Optional.empty();

        private Optional<String> enrollmentMode = Optional.empty();

        private JsonNullable<Boolean> verified = JsonNullable.undefined();

        private Builder() {
          // force use of static builder() method
        }


        /**
         * The name of the new domain
         */
        public Builder name(String name) {
            Utils.checkNotNull(name, "name");
            this.name = Optional.ofNullable(name);
            return this;
        }

        /**
         * The name of the new domain
         */
        public Builder name(Optional<String> name) {
            Utils.checkNotNull(name, "name");
            this.name = name;
            return this;
        }


        /**
         * The enrollment_mode for the new domain. This can be `automatic_invitation`, `automatic_suggestion` or `manual_invitation`
         */
        public Builder enrollmentMode(String enrollmentMode) {
            Utils.checkNotNull(enrollmentMode, "enrollmentMode");
            this.enrollmentMode = Optional.ofNullable(enrollmentMode);
            return this;
        }

        /**
         * The enrollment_mode for the new domain. This can be `automatic_invitation`, `automatic_suggestion` or `manual_invitation`
         */
        public Builder enrollmentMode(Optional<String> enrollmentMode) {
            Utils.checkNotNull(enrollmentMode, "enrollmentMode");
            this.enrollmentMode = enrollmentMode;
            return this;
        }


        /**
         * The status of domain's verification. Defaults to true
         */
        public Builder verified(boolean verified) {
            Utils.checkNotNull(verified, "verified");
            this.verified = JsonNullable.of(verified);
            return this;
        }

        /**
         * The status of domain's verification. Defaults to true
         */
        public Builder verified(JsonNullable<Boolean> verified) {
            Utils.checkNotNull(verified, "verified");
            this.verified = verified;
            return this;
        }

        public CreateOrganizationDomainRequestBody build() {

            return new CreateOrganizationDomainRequestBody(
                name, enrollmentMode, verified);
        }

    }
}
