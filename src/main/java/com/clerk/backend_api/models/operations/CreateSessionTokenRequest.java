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
import java.util.Optional;


public class CreateSessionTokenRequest {
    /**
     * The ID of the session
     */
    @SpeakeasyMetadata("pathParam:style=simple,explode=false,name=session_id")
    private String sessionId;


    @SpeakeasyMetadata("request:mediaType=application/json")
    private Optional<? extends CreateSessionTokenRequestBody> requestBody;

    @JsonCreator
    public CreateSessionTokenRequest(
            String sessionId,
            Optional<? extends CreateSessionTokenRequestBody> requestBody) {
        Utils.checkNotNull(sessionId, "sessionId");
        Utils.checkNotNull(requestBody, "requestBody");
        this.sessionId = sessionId;
        this.requestBody = requestBody;
    }
    
    public CreateSessionTokenRequest(
            String sessionId) {
        this(sessionId, Optional.empty());
    }

    /**
     * The ID of the session
     */
    @JsonIgnore
    public String sessionId() {
        return sessionId;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<CreateSessionTokenRequestBody> requestBody() {
        return (Optional<CreateSessionTokenRequestBody>) requestBody;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * The ID of the session
     */
    public CreateSessionTokenRequest withSessionId(String sessionId) {
        Utils.checkNotNull(sessionId, "sessionId");
        this.sessionId = sessionId;
        return this;
    }

    public CreateSessionTokenRequest withRequestBody(CreateSessionTokenRequestBody requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = Optional.ofNullable(requestBody);
        return this;
    }


    public CreateSessionTokenRequest withRequestBody(Optional<? extends CreateSessionTokenRequestBody> requestBody) {
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
        CreateSessionTokenRequest other = (CreateSessionTokenRequest) o;
        return 
            Utils.enhancedDeepEquals(this.sessionId, other.sessionId) &&
            Utils.enhancedDeepEquals(this.requestBody, other.requestBody);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            sessionId, requestBody);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CreateSessionTokenRequest.class,
                "sessionId", sessionId,
                "requestBody", requestBody);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String sessionId;

        private Optional<? extends CreateSessionTokenRequestBody> requestBody = Optional.empty();

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


        public Builder requestBody(CreateSessionTokenRequestBody requestBody) {
            Utils.checkNotNull(requestBody, "requestBody");
            this.requestBody = Optional.ofNullable(requestBody);
            return this;
        }

        public Builder requestBody(Optional<? extends CreateSessionTokenRequestBody> requestBody) {
            Utils.checkNotNull(requestBody, "requestBody");
            this.requestBody = requestBody;
            return this;
        }

        public CreateSessionTokenRequest build() {

            return new CreateSessionTokenRequest(
                sessionId, requestBody);
        }

    }
}
