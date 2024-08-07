/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.InputStream;
import java.lang.Deprecated;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;
/**
 * PreviewTemplateRequestBody - Required parameters
 */

public class PreviewTemplateRequestBody {

    /**
     * The email subject.
     * Applicable only to email templates.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("subject")
    private JsonNullable<? extends String> subject;

    /**
     * The template body before variable interpolation
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("body")
    private Optional<? extends String> body;

    /**
     * The local part of the From email address that will be used for emails.
     * For example, in the address 'hello@example.com', the local part is 'hello'.
     * Applicable only to email templates.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("from_email_name")
    private Optional<? extends String> fromEmailName;

    /**
     * The local part of the Reply To email address that will be used for emails.
     * For example, in the address 'hello@example.com', the local part is 'hello'.
     * Applicable only to email templates.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("reply_to_email_name")
    private Optional<? extends String> replyToEmailName;

    @JsonCreator
    public PreviewTemplateRequestBody(
            @JsonProperty("subject") JsonNullable<? extends String> subject,
            @JsonProperty("body") Optional<? extends String> body,
            @JsonProperty("from_email_name") Optional<? extends String> fromEmailName,
            @JsonProperty("reply_to_email_name") Optional<? extends String> replyToEmailName) {
        Utils.checkNotNull(subject, "subject");
        Utils.checkNotNull(body, "body");
        Utils.checkNotNull(fromEmailName, "fromEmailName");
        Utils.checkNotNull(replyToEmailName, "replyToEmailName");
        this.subject = subject;
        this.body = body;
        this.fromEmailName = fromEmailName;
        this.replyToEmailName = replyToEmailName;
    }
    
    public PreviewTemplateRequestBody() {
        this(JsonNullable.undefined(), Optional.empty(), Optional.empty(), Optional.empty());
    }

    /**
     * The email subject.
     * Applicable only to email templates.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<String> subject() {
        return (JsonNullable<String>) subject;
    }

    /**
     * The template body before variable interpolation
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<String> body() {
        return (Optional<String>) body;
    }

    /**
     * The local part of the From email address that will be used for emails.
     * For example, in the address 'hello@example.com', the local part is 'hello'.
     * Applicable only to email templates.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<String> fromEmailName() {
        return (Optional<String>) fromEmailName;
    }

    /**
     * The local part of the Reply To email address that will be used for emails.
     * For example, in the address 'hello@example.com', the local part is 'hello'.
     * Applicable only to email templates.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<String> replyToEmailName() {
        return (Optional<String>) replyToEmailName;
    }

    public final static Builder builder() {
        return new Builder();
    }

    /**
     * The email subject.
     * Applicable only to email templates.
     */
    public PreviewTemplateRequestBody withSubject(String subject) {
        Utils.checkNotNull(subject, "subject");
        this.subject = JsonNullable.of(subject);
        return this;
    }

    /**
     * The email subject.
     * Applicable only to email templates.
     */
    public PreviewTemplateRequestBody withSubject(JsonNullable<? extends String> subject) {
        Utils.checkNotNull(subject, "subject");
        this.subject = subject;
        return this;
    }

    /**
     * The template body before variable interpolation
     */
    public PreviewTemplateRequestBody withBody(String body) {
        Utils.checkNotNull(body, "body");
        this.body = Optional.ofNullable(body);
        return this;
    }

    /**
     * The template body before variable interpolation
     */
    public PreviewTemplateRequestBody withBody(Optional<? extends String> body) {
        Utils.checkNotNull(body, "body");
        this.body = body;
        return this;
    }

    /**
     * The local part of the From email address that will be used for emails.
     * For example, in the address 'hello@example.com', the local part is 'hello'.
     * Applicable only to email templates.
     */
    public PreviewTemplateRequestBody withFromEmailName(String fromEmailName) {
        Utils.checkNotNull(fromEmailName, "fromEmailName");
        this.fromEmailName = Optional.ofNullable(fromEmailName);
        return this;
    }

    /**
     * The local part of the From email address that will be used for emails.
     * For example, in the address 'hello@example.com', the local part is 'hello'.
     * Applicable only to email templates.
     */
    public PreviewTemplateRequestBody withFromEmailName(Optional<? extends String> fromEmailName) {
        Utils.checkNotNull(fromEmailName, "fromEmailName");
        this.fromEmailName = fromEmailName;
        return this;
    }

    /**
     * The local part of the Reply To email address that will be used for emails.
     * For example, in the address 'hello@example.com', the local part is 'hello'.
     * Applicable only to email templates.
     */
    public PreviewTemplateRequestBody withReplyToEmailName(String replyToEmailName) {
        Utils.checkNotNull(replyToEmailName, "replyToEmailName");
        this.replyToEmailName = Optional.ofNullable(replyToEmailName);
        return this;
    }

    /**
     * The local part of the Reply To email address that will be used for emails.
     * For example, in the address 'hello@example.com', the local part is 'hello'.
     * Applicable only to email templates.
     */
    public PreviewTemplateRequestBody withReplyToEmailName(Optional<? extends String> replyToEmailName) {
        Utils.checkNotNull(replyToEmailName, "replyToEmailName");
        this.replyToEmailName = replyToEmailName;
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
        PreviewTemplateRequestBody other = (PreviewTemplateRequestBody) o;
        return 
            java.util.Objects.deepEquals(this.subject, other.subject) &&
            java.util.Objects.deepEquals(this.body, other.body) &&
            java.util.Objects.deepEquals(this.fromEmailName, other.fromEmailName) &&
            java.util.Objects.deepEquals(this.replyToEmailName, other.replyToEmailName);
    }
    
    @Override
    public int hashCode() {
        return java.util.Objects.hash(
            subject,
            body,
            fromEmailName,
            replyToEmailName);
    }
    
    @Override
    public String toString() {
        return Utils.toString(PreviewTemplateRequestBody.class,
                "subject", subject,
                "body", body,
                "fromEmailName", fromEmailName,
                "replyToEmailName", replyToEmailName);
    }
    
    public final static class Builder {
 
        private JsonNullable<? extends String> subject = JsonNullable.undefined();
 
        private Optional<? extends String> body = Optional.empty();
 
        private Optional<? extends String> fromEmailName = Optional.empty();
 
        private Optional<? extends String> replyToEmailName = Optional.empty();  
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * The email subject.
         * Applicable only to email templates.
         */
        public Builder subject(String subject) {
            Utils.checkNotNull(subject, "subject");
            this.subject = JsonNullable.of(subject);
            return this;
        }

        /**
         * The email subject.
         * Applicable only to email templates.
         */
        public Builder subject(JsonNullable<? extends String> subject) {
            Utils.checkNotNull(subject, "subject");
            this.subject = subject;
            return this;
        }

        /**
         * The template body before variable interpolation
         */
        public Builder body(String body) {
            Utils.checkNotNull(body, "body");
            this.body = Optional.ofNullable(body);
            return this;
        }

        /**
         * The template body before variable interpolation
         */
        public Builder body(Optional<? extends String> body) {
            Utils.checkNotNull(body, "body");
            this.body = body;
            return this;
        }

        /**
         * The local part of the From email address that will be used for emails.
         * For example, in the address 'hello@example.com', the local part is 'hello'.
         * Applicable only to email templates.
         */
        public Builder fromEmailName(String fromEmailName) {
            Utils.checkNotNull(fromEmailName, "fromEmailName");
            this.fromEmailName = Optional.ofNullable(fromEmailName);
            return this;
        }

        /**
         * The local part of the From email address that will be used for emails.
         * For example, in the address 'hello@example.com', the local part is 'hello'.
         * Applicable only to email templates.
         */
        public Builder fromEmailName(Optional<? extends String> fromEmailName) {
            Utils.checkNotNull(fromEmailName, "fromEmailName");
            this.fromEmailName = fromEmailName;
            return this;
        }

        /**
         * The local part of the Reply To email address that will be used for emails.
         * For example, in the address 'hello@example.com', the local part is 'hello'.
         * Applicable only to email templates.
         */
        public Builder replyToEmailName(String replyToEmailName) {
            Utils.checkNotNull(replyToEmailName, "replyToEmailName");
            this.replyToEmailName = Optional.ofNullable(replyToEmailName);
            return this;
        }

        /**
         * The local part of the Reply To email address that will be used for emails.
         * For example, in the address 'hello@example.com', the local part is 'hello'.
         * Applicable only to email templates.
         */
        public Builder replyToEmailName(Optional<? extends String> replyToEmailName) {
            Utils.checkNotNull(replyToEmailName, "replyToEmailName");
            this.replyToEmailName = replyToEmailName;
            return this;
        }
        
        public PreviewTemplateRequestBody build() {
            return new PreviewTemplateRequestBody(
                subject,
                body,
                fromEmailName,
                replyToEmailName);
        }
    }
}

