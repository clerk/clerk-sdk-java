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


public class CreateSessionTokenFromTemplateRequest {

    /**
     * The ID of the session
     */
    @SpeakeasyMetadata("pathParam:style=simple,explode=false,name=session_id")
    private String sessionId;

    /**
     * The name of the JWT Template defined in your instance (e.g. `custom_hasura`).
     */
    @SpeakeasyMetadata("pathParam:style=simple,explode=false,name=template_name")
    private String templateName;

    @JsonCreator
    public CreateSessionTokenFromTemplateRequest(
            String sessionId,
            String templateName) {
        Utils.checkNotNull(sessionId, "sessionId");
        Utils.checkNotNull(templateName, "templateName");
        this.sessionId = sessionId;
        this.templateName = templateName;
    }

    /**
     * The ID of the session
     */
    @JsonIgnore
    public String sessionId() {
        return sessionId;
    }

    /**
     * The name of the JWT Template defined in your instance (e.g. `custom_hasura`).
     */
    @JsonIgnore
    public String templateName() {
        return templateName;
    }

    public final static Builder builder() {
        return new Builder();
    }

    /**
     * The ID of the session
     */
    public CreateSessionTokenFromTemplateRequest withSessionId(String sessionId) {
        Utils.checkNotNull(sessionId, "sessionId");
        this.sessionId = sessionId;
        return this;
    }

    /**
     * The name of the JWT Template defined in your instance (e.g. `custom_hasura`).
     */
    public CreateSessionTokenFromTemplateRequest withTemplateName(String templateName) {
        Utils.checkNotNull(templateName, "templateName");
        this.templateName = templateName;
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
        CreateSessionTokenFromTemplateRequest other = (CreateSessionTokenFromTemplateRequest) o;
        return 
            Objects.deepEquals(this.sessionId, other.sessionId) &&
            Objects.deepEquals(this.templateName, other.templateName);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            sessionId,
            templateName);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CreateSessionTokenFromTemplateRequest.class,
                "sessionId", sessionId,
                "templateName", templateName);
    }
    
    public final static class Builder {
 
        private String sessionId;
 
        private String templateName;  
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * The ID of the session
         */
        public Builder sessionId(String sessionId) {
            Utils.checkNotNull(sessionId, "sessionId");
            this.sessionId = sessionId;
            return this;
        }

        /**
         * The name of the JWT Template defined in your instance (e.g. `custom_hasura`).
         */
        public Builder templateName(String templateName) {
            Utils.checkNotNull(templateName, "templateName");
            this.templateName = templateName;
            return this;
        }
        
        public CreateSessionTokenFromTemplateRequest build() {
            return new CreateSessionTokenFromTemplateRequest(
                sessionId,
                templateName);
        }
    }
}

