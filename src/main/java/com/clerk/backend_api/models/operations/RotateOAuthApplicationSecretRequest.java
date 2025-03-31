/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.utils.SpeakeasyMetadata;
import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

public class RotateOAuthApplicationSecretRequest {

    /**
     * The ID of the OAuth application for which to rotate the client secret
     */
    @SpeakeasyMetadata("pathParam:style=simple,explode=false,name=oauth_application_id")
    private String oauthApplicationId;

    @JsonCreator
    public RotateOAuthApplicationSecretRequest(
            String oauthApplicationId) {
        Utils.checkNotNull(oauthApplicationId, "oauthApplicationId");
        this.oauthApplicationId = oauthApplicationId;
    }

    /**
     * The ID of the OAuth application for which to rotate the client secret
     */
    @JsonIgnore
    public String oauthApplicationId() {
        return oauthApplicationId;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * The ID of the OAuth application for which to rotate the client secret
     */
    public RotateOAuthApplicationSecretRequest withOauthApplicationId(String oauthApplicationId) {
        Utils.checkNotNull(oauthApplicationId, "oauthApplicationId");
        this.oauthApplicationId = oauthApplicationId;
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
        RotateOAuthApplicationSecretRequest other = (RotateOAuthApplicationSecretRequest) o;
        return 
            Objects.deepEquals(this.oauthApplicationId, other.oauthApplicationId);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            oauthApplicationId);
    }
    
    @Override
    public String toString() {
        return Utils.toString(RotateOAuthApplicationSecretRequest.class,
                "oauthApplicationId", oauthApplicationId);
    }
    
    public final static class Builder {
 
        private String oauthApplicationId;
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * The ID of the OAuth application for which to rotate the client secret
         */
        public Builder oauthApplicationId(String oauthApplicationId) {
            Utils.checkNotNull(oauthApplicationId, "oauthApplicationId");
            this.oauthApplicationId = oauthApplicationId;
            return this;
        }
        
        public RotateOAuthApplicationSecretRequest build() {
            return new RotateOAuthApplicationSecretRequest(
                oauthApplicationId);
        }
    }
}
