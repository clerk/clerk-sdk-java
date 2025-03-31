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
import java.lang.SuppressWarnings;
import java.util.Objects;
import java.util.Optional;

public class ToggleTemplateDeliveryRequest {

    /**
     * The type of template to toggle delivery for
     */
    @SpeakeasyMetadata("pathParam:style=simple,explode=false,name=template_type")
    private ToggleTemplateDeliveryPathParamTemplateType templateType;

    /**
     * The slug of the template for which to toggle delivery
     */
    @SpeakeasyMetadata("pathParam:style=simple,explode=false,name=slug")
    private String slug;

    @SpeakeasyMetadata("request:mediaType=application/json")
    private Optional<? extends ToggleTemplateDeliveryRequestBody> requestBody;

    @JsonCreator
    public ToggleTemplateDeliveryRequest(
            ToggleTemplateDeliveryPathParamTemplateType templateType,
            String slug,
            Optional<? extends ToggleTemplateDeliveryRequestBody> requestBody) {
        Utils.checkNotNull(templateType, "templateType");
        Utils.checkNotNull(slug, "slug");
        Utils.checkNotNull(requestBody, "requestBody");
        this.templateType = templateType;
        this.slug = slug;
        this.requestBody = requestBody;
    }
    
    public ToggleTemplateDeliveryRequest(
            ToggleTemplateDeliveryPathParamTemplateType templateType,
            String slug) {
        this(templateType, slug, Optional.empty());
    }

    /**
     * The type of template to toggle delivery for
     */
    @JsonIgnore
    public ToggleTemplateDeliveryPathParamTemplateType templateType() {
        return templateType;
    }

    /**
     * The slug of the template for which to toggle delivery
     */
    @JsonIgnore
    public String slug() {
        return slug;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<ToggleTemplateDeliveryRequestBody> requestBody() {
        return (Optional<ToggleTemplateDeliveryRequestBody>) requestBody;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * The type of template to toggle delivery for
     */
    public ToggleTemplateDeliveryRequest withTemplateType(ToggleTemplateDeliveryPathParamTemplateType templateType) {
        Utils.checkNotNull(templateType, "templateType");
        this.templateType = templateType;
        return this;
    }

    /**
     * The slug of the template for which to toggle delivery
     */
    public ToggleTemplateDeliveryRequest withSlug(String slug) {
        Utils.checkNotNull(slug, "slug");
        this.slug = slug;
        return this;
    }

    public ToggleTemplateDeliveryRequest withRequestBody(ToggleTemplateDeliveryRequestBody requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = Optional.ofNullable(requestBody);
        return this;
    }

    public ToggleTemplateDeliveryRequest withRequestBody(Optional<? extends ToggleTemplateDeliveryRequestBody> requestBody) {
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
        ToggleTemplateDeliveryRequest other = (ToggleTemplateDeliveryRequest) o;
        return 
            Objects.deepEquals(this.templateType, other.templateType) &&
            Objects.deepEquals(this.slug, other.slug) &&
            Objects.deepEquals(this.requestBody, other.requestBody);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            templateType,
            slug,
            requestBody);
    }
    
    @Override
    public String toString() {
        return Utils.toString(ToggleTemplateDeliveryRequest.class,
                "templateType", templateType,
                "slug", slug,
                "requestBody", requestBody);
    }
    
    public final static class Builder {
 
        private ToggleTemplateDeliveryPathParamTemplateType templateType;
 
        private String slug;
 
        private Optional<? extends ToggleTemplateDeliveryRequestBody> requestBody = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * The type of template to toggle delivery for
         */
        public Builder templateType(ToggleTemplateDeliveryPathParamTemplateType templateType) {
            Utils.checkNotNull(templateType, "templateType");
            this.templateType = templateType;
            return this;
        }

        /**
         * The slug of the template for which to toggle delivery
         */
        public Builder slug(String slug) {
            Utils.checkNotNull(slug, "slug");
            this.slug = slug;
            return this;
        }

        public Builder requestBody(ToggleTemplateDeliveryRequestBody requestBody) {
            Utils.checkNotNull(requestBody, "requestBody");
            this.requestBody = Optional.ofNullable(requestBody);
            return this;
        }

        public Builder requestBody(Optional<? extends ToggleTemplateDeliveryRequestBody> requestBody) {
            Utils.checkNotNull(requestBody, "requestBody");
            this.requestBody = requestBody;
            return this;
        }
        
        public ToggleTemplateDeliveryRequest build() {
            return new ToggleTemplateDeliveryRequest(
                templateType,
                slug,
                requestBody);
        }
    }
}
