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

public class UpdateSAMLConnectionRequest {

    /**
     * The ID of the SAML Connection to update
     */
    @SpeakeasyMetadata("pathParam:style=simple,explode=false,name=saml_connection_id")
    private String samlConnectionId;

    @SpeakeasyMetadata("request:mediaType=application/json")
    private UpdateSAMLConnectionRequestBody requestBody;

    @JsonCreator
    public UpdateSAMLConnectionRequest(
            String samlConnectionId,
            UpdateSAMLConnectionRequestBody requestBody) {
        Utils.checkNotNull(samlConnectionId, "samlConnectionId");
        Utils.checkNotNull(requestBody, "requestBody");
        this.samlConnectionId = samlConnectionId;
        this.requestBody = requestBody;
    }

    /**
     * The ID of the SAML Connection to update
     */
    @JsonIgnore
    public String samlConnectionId() {
        return samlConnectionId;
    }

    @JsonIgnore
    public UpdateSAMLConnectionRequestBody requestBody() {
        return requestBody;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * The ID of the SAML Connection to update
     */
    public UpdateSAMLConnectionRequest withSamlConnectionId(String samlConnectionId) {
        Utils.checkNotNull(samlConnectionId, "samlConnectionId");
        this.samlConnectionId = samlConnectionId;
        return this;
    }

    public UpdateSAMLConnectionRequest withRequestBody(UpdateSAMLConnectionRequestBody requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = requestBody;
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
        UpdateSAMLConnectionRequest other = (UpdateSAMLConnectionRequest) o;
        return 
            Objects.deepEquals(this.samlConnectionId, other.samlConnectionId) &&
            Objects.deepEquals(this.requestBody, other.requestBody);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            samlConnectionId,
            requestBody);
    }
    
    @Override
    public String toString() {
        return Utils.toString(UpdateSAMLConnectionRequest.class,
                "samlConnectionId", samlConnectionId,
                "requestBody", requestBody);
    }
    
    public final static class Builder {
 
        private String samlConnectionId;
 
        private UpdateSAMLConnectionRequestBody requestBody;
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * The ID of the SAML Connection to update
         */
        public Builder samlConnectionId(String samlConnectionId) {
            Utils.checkNotNull(samlConnectionId, "samlConnectionId");
            this.samlConnectionId = samlConnectionId;
            return this;
        }

        public Builder requestBody(UpdateSAMLConnectionRequestBody requestBody) {
            Utils.checkNotNull(requestBody, "requestBody");
            this.requestBody = requestBody;
            return this;
        }
        
        public UpdateSAMLConnectionRequest build() {
            return new UpdateSAMLConnectionRequest(
                samlConnectionId,
                requestBody);
        }
    }
}
