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
import java.lang.Override;
import java.lang.String;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;

/**
 * PreviewTemplateRequestBody
 * 
 * <p>Required parameters
 */
public class PreviewTemplateRequestBody {
    /**
     * The email subject.
     * Applicable only to email templates.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("subject")
    private JsonNullable<String> subject;

    /**
     * The template body before variable interpolation
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("body")
    private Optional<String> body;

    /**
     * The local part of the From email address that will be used for emails.
     * For example, in the address 'hello@example.com', the local part is 'hello'.
     * Applicable only to email templates.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("from_email_name")
    private Optional<String> fromEmailName;

    /**
     * The local part of the Reply To email address that will be used for emails.
     * For example, in the address 'hello@example.com', the local part is 'hello'.
     * Applicable only to email templates.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("reply_to_email_name")
    private Optional<String> replyToEmailName;

    @JsonCreator
    public PreviewTemplateRequestBody(
            @JsonProperty("subject") JsonNullable<String> subject,
            @JsonProperty("body") Optional<String> body,
            @JsonProperty("from_email_name") Optional<String> fromEmailName,
            @JsonProperty("reply_to_email_name") Optional<String> replyToEmailName) {
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
        this(JsonNullable.undefined(), Optional.empty(), Optional.empty(),
            Optional.empty());
    }

    /**
     * The email subject.
     * Applicable only to email templates.
     */
    @JsonIgnore
    public JsonNullable<String> subject() {
        return subject;
    }

    /**
     * The template body before variable interpolation
     */
    @JsonIgnore
    public Optional<String> body() {
        return body;
    }

    /**
     * The local part of the From email address that will be used for emails.
     * For example, in the address 'hello@example.com', the local part is 'hello'.
     * Applicable only to email templates.
     */
    @JsonIgnore
    public Optional<String> fromEmailName() {
        return fromEmailName;
    }

    /**
     * The local part of the Reply To email address that will be used for emails.
     * For example, in the address 'hello@example.com', the local part is 'hello'.
     * Applicable only to email templates.
     */
    @JsonIgnore
    public Optional<String> replyToEmailName() {
        return replyToEmailName;
    }

    public static Builder builder() {
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
    public PreviewTemplateRequestBody withSubject(JsonNullable<String> subject) {
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
    public PreviewTemplateRequestBody withBody(Optional<String> body) {
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
    public PreviewTemplateRequestBody withFromEmailName(Optional<String> fromEmailName) {
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
    public PreviewTemplateRequestBody withReplyToEmailName(Optional<String> replyToEmailName) {
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
            Utils.enhancedDeepEquals(this.subject, other.subject) &&
            Utils.enhancedDeepEquals(this.body, other.body) &&
            Utils.enhancedDeepEquals(this.fromEmailName, other.fromEmailName) &&
            Utils.enhancedDeepEquals(this.replyToEmailName, other.replyToEmailName);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            subject, body, fromEmailName,
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

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private JsonNullable<String> subject = JsonNullable.undefined();

        private Optional<String> body = Optional.empty();

        private Optional<String> fromEmailName = Optional.empty();

        private Optional<String> replyToEmailName = Optional.empty();

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
        public Builder subject(JsonNullable<String> subject) {
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
        public Builder body(Optional<String> body) {
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
        public Builder fromEmailName(Optional<String> fromEmailName) {
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
        public Builder replyToEmailName(Optional<String> replyToEmailName) {
            Utils.checkNotNull(replyToEmailName, "replyToEmailName");
            this.replyToEmailName = replyToEmailName;
            return this;
        }

        public PreviewTemplateRequestBody build() {

            return new PreviewTemplateRequestBody(
                subject, body, fromEmailName,
                replyToEmailName);
        }

    }
}
