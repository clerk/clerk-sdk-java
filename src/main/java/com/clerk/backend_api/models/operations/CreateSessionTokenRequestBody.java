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
import java.lang.Double;
import java.lang.Override;
import java.lang.String;
import org.openapitools.jackson.nullable.JsonNullable;


public class CreateSessionTokenRequestBody {
    /**
     * Use this parameter to override the default session token lifetime.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("expires_in_seconds")
    private JsonNullable<Double> expiresInSeconds;

    @JsonCreator
    public CreateSessionTokenRequestBody(
            @JsonProperty("expires_in_seconds") JsonNullable<Double> expiresInSeconds) {
        Utils.checkNotNull(expiresInSeconds, "expiresInSeconds");
        this.expiresInSeconds = expiresInSeconds;
    }
    
    public CreateSessionTokenRequestBody() {
        this(JsonNullable.undefined());
    }

    /**
     * Use this parameter to override the default session token lifetime.
     */
    @JsonIgnore
    public JsonNullable<Double> expiresInSeconds() {
        return expiresInSeconds;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * Use this parameter to override the default session token lifetime.
     */
    public CreateSessionTokenRequestBody withExpiresInSeconds(double expiresInSeconds) {
        Utils.checkNotNull(expiresInSeconds, "expiresInSeconds");
        this.expiresInSeconds = JsonNullable.of(expiresInSeconds);
        return this;
    }

    /**
     * Use this parameter to override the default session token lifetime.
     */
    public CreateSessionTokenRequestBody withExpiresInSeconds(JsonNullable<Double> expiresInSeconds) {
        Utils.checkNotNull(expiresInSeconds, "expiresInSeconds");
        this.expiresInSeconds = expiresInSeconds;
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
        CreateSessionTokenRequestBody other = (CreateSessionTokenRequestBody) o;
        return 
            Utils.enhancedDeepEquals(this.expiresInSeconds, other.expiresInSeconds);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            expiresInSeconds);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CreateSessionTokenRequestBody.class,
                "expiresInSeconds", expiresInSeconds);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private JsonNullable<Double> expiresInSeconds = JsonNullable.undefined();

        private Builder() {
          // force use of static builder() method
        }


        /**
         * Use this parameter to override the default session token lifetime.
         */
        public Builder expiresInSeconds(double expiresInSeconds) {
            Utils.checkNotNull(expiresInSeconds, "expiresInSeconds");
            this.expiresInSeconds = JsonNullable.of(expiresInSeconds);
            return this;
        }

        /**
         * Use this parameter to override the default session token lifetime.
         */
        public Builder expiresInSeconds(JsonNullable<Double> expiresInSeconds) {
            Utils.checkNotNull(expiresInSeconds, "expiresInSeconds");
            this.expiresInSeconds = expiresInSeconds;
            return this;
        }

        public CreateSessionTokenRequestBody build() {

            return new CreateSessionTokenRequestBody(
                expiresInSeconds);
        }

    }
}
