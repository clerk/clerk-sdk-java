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

public class PreviewTemplateRequest {

    /**
     * The type of template to preview
     */
    @SpeakeasyMetadata("pathParam:style=simple,explode=false,name=template_type")
    private String templateType;

    /**
     * The slug of the template to preview
     */
    @SpeakeasyMetadata("pathParam:style=simple,explode=false,name=slug")
    private String slug;

    /**
     * Required parameters
     */
    @SpeakeasyMetadata("request:mediaType=application/json")
    private Optional<? extends PreviewTemplateRequestBody> requestBody;

    @JsonCreator
    public PreviewTemplateRequest(
            String templateType,
            String slug,
            Optional<? extends PreviewTemplateRequestBody> requestBody) {
        Utils.checkNotNull(templateType, "templateType");
        Utils.checkNotNull(slug, "slug");
        Utils.checkNotNull(requestBody, "requestBody");
        this.templateType = templateType;
        this.slug = slug;
        this.requestBody = requestBody;
    }
    
    public PreviewTemplateRequest(
            String templateType,
            String slug) {
        this(templateType, slug, Optional.empty());
    }

    /**
     * The type of template to preview
     */
    @JsonIgnore
    public String templateType() {
        return templateType;
    }

    /**
     * The slug of the template to preview
     */
    @JsonIgnore
    public String slug() {
        return slug;
    }

    /**
     * Required parameters
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<PreviewTemplateRequestBody> requestBody() {
        return (Optional<PreviewTemplateRequestBody>) requestBody;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * The type of template to preview
     */
    public PreviewTemplateRequest withTemplateType(String templateType) {
        Utils.checkNotNull(templateType, "templateType");
        this.templateType = templateType;
        return this;
    }

    /**
     * The slug of the template to preview
     */
    public PreviewTemplateRequest withSlug(String slug) {
        Utils.checkNotNull(slug, "slug");
        this.slug = slug;
        return this;
    }

    /**
     * Required parameters
     */
    public PreviewTemplateRequest withRequestBody(PreviewTemplateRequestBody requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = Optional.ofNullable(requestBody);
        return this;
    }

    /**
     * Required parameters
     */
    public PreviewTemplateRequest withRequestBody(Optional<? extends PreviewTemplateRequestBody> requestBody) {
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
        PreviewTemplateRequest other = (PreviewTemplateRequest) o;
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
        return Utils.toString(PreviewTemplateRequest.class,
                "templateType", templateType,
                "slug", slug,
                "requestBody", requestBody);
    }
    
    public final static class Builder {
 
        private String templateType;
 
        private String slug;
 
        private Optional<? extends PreviewTemplateRequestBody> requestBody = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * The type of template to preview
         */
        public Builder templateType(String templateType) {
            Utils.checkNotNull(templateType, "templateType");
            this.templateType = templateType;
            return this;
        }

        /**
         * The slug of the template to preview
         */
        public Builder slug(String slug) {
            Utils.checkNotNull(slug, "slug");
            this.slug = slug;
            return this;
        }

        /**
         * Required parameters
         */
        public Builder requestBody(PreviewTemplateRequestBody requestBody) {
            Utils.checkNotNull(requestBody, "requestBody");
            this.requestBody = Optional.ofNullable(requestBody);
            return this;
        }

        /**
         * Required parameters
         */
        public Builder requestBody(Optional<? extends PreviewTemplateRequestBody> requestBody) {
            Utils.checkNotNull(requestBody, "requestBody");
            this.requestBody = requestBody;
            return this;
        }
        
        public PreviewTemplateRequest build() {
            return new PreviewTemplateRequest(
                templateType,
                slug,
                requestBody);
        }
    }
}
