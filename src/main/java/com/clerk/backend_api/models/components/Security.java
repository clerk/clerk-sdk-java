/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.components;

import com.clerk.backend_api.utils.HasSecurity;
import com.clerk.backend_api.utils.SpeakeasyMetadata;
import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.lang.Override;
import java.lang.String;
import java.util.Optional;


public class Security implements HasSecurity {

    @SpeakeasyMetadata("security:scheme=true,type=http,subtype=bearer,name=Authorization")
    private Optional<String> bearerAuth;

    @JsonCreator
    public Security(
            Optional<String> bearerAuth) {
        Utils.checkNotNull(bearerAuth, "bearerAuth");
        this.bearerAuth = bearerAuth;
    }
    
    public Security() {
        this(Optional.empty());
    }

    @JsonIgnore
    public Optional<String> bearerAuth() {
        return bearerAuth;
    }

    public static Builder builder() {
        return new Builder();
    }


    public Security withBearerAuth(String bearerAuth) {
        Utils.checkNotNull(bearerAuth, "bearerAuth");
        this.bearerAuth = Optional.ofNullable(bearerAuth);
        return this;
    }


    public Security withBearerAuth(Optional<String> bearerAuth) {
        Utils.checkNotNull(bearerAuth, "bearerAuth");
        this.bearerAuth = bearerAuth;
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
        Security other = (Security) o;
        return 
            Utils.enhancedDeepEquals(this.bearerAuth, other.bearerAuth);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            bearerAuth);
    }
    
    @Override
    public String toString() {
        return Utils.toString(Security.class,
                "bearerAuth", bearerAuth);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private Optional<String> bearerAuth = Optional.empty();

        private Builder() {
          // force use of static builder() method
        }


        public Builder bearerAuth(String bearerAuth) {
            Utils.checkNotNull(bearerAuth, "bearerAuth");
            this.bearerAuth = Optional.ofNullable(bearerAuth);
            return this;
        }

        public Builder bearerAuth(Optional<String> bearerAuth) {
            Utils.checkNotNull(bearerAuth, "bearerAuth");
            this.bearerAuth = bearerAuth;
            return this;
        }

        public Security build() {

            return new Security(
                bearerAuth);
        }

    }
}
