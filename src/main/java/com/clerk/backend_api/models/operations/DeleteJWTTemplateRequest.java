/* 
 * Code generated by Speakeasy (https://speakeasyapi.dev). DO NOT EDIT.
 */

package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.utils.SpeakeasyMetadata;
import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.InputStream;
import java.lang.Deprecated;
import java.math.BigDecimal;
import java.math.BigInteger;

public class DeleteJWTTemplateRequest {

    /**
     * JWT Template ID
     */
    @SpeakeasyMetadata("pathParam:style=simple,explode=false,name=template_id")
    private String templateId;

    @JsonCreator
    public DeleteJWTTemplateRequest(
            String templateId) {
        Utils.checkNotNull(templateId, "templateId");
        this.templateId = templateId;
    }

    /**
     * JWT Template ID
     */
    @JsonIgnore
    public String templateId() {
        return templateId;
    }

    public final static Builder builder() {
        return new Builder();
    }

    /**
     * JWT Template ID
     */
    public DeleteJWTTemplateRequest withTemplateId(String templateId) {
        Utils.checkNotNull(templateId, "templateId");
        this.templateId = templateId;
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
        DeleteJWTTemplateRequest other = (DeleteJWTTemplateRequest) o;
        return 
            java.util.Objects.deepEquals(this.templateId, other.templateId);
    }
    
    @Override
    public int hashCode() {
        return java.util.Objects.hash(
            templateId);
    }
    
    @Override
    public String toString() {
        return Utils.toString(DeleteJWTTemplateRequest.class,
                "templateId", templateId);
    }
    
    public final static class Builder {
 
        private String templateId;  
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * JWT Template ID
         */
        public Builder templateId(String templateId) {
            Utils.checkNotNull(templateId, "templateId");
            this.templateId = templateId;
            return this;
        }
        
        public DeleteJWTTemplateRequest build() {
            return new DeleteJWTTemplateRequest(
                templateId);
        }
    }
}
