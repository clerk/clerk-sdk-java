/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.utils.LazySingletonValue;
import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.Optional;


public class CreateActorTokenRequestBody {
    /**
     * The ID of the user being impersonated.
     */
    @JsonProperty("user_id")
    private String userId;

    /**
     * The actor payload. It needs to include a sub property which should contain the ID of the actor.
     * This whole payload will be also included in the JWT session token.
     */
    @JsonProperty("actor")
    private Actor actor;

    /**
     * Optional parameter to specify the life duration of the actor token in seconds.
     * By default, the duration is 1 hour.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("expires_in_seconds")
    private Optional<Long> expiresInSeconds;

    /**
     * The maximum duration that the session which will be created by the generated actor token should last.
     * By default, the duration of a session created via an actor token, lasts 30 minutes.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("session_max_duration_in_seconds")
    private Optional<Long> sessionMaxDurationInSeconds;

    @JsonCreator
    public CreateActorTokenRequestBody(
            @JsonProperty("user_id") String userId,
            @JsonProperty("actor") Actor actor,
            @JsonProperty("expires_in_seconds") Optional<Long> expiresInSeconds,
            @JsonProperty("session_max_duration_in_seconds") Optional<Long> sessionMaxDurationInSeconds) {
        Utils.checkNotNull(userId, "userId");
        Utils.checkNotNull(actor, "actor");
        Utils.checkNotNull(expiresInSeconds, "expiresInSeconds");
        Utils.checkNotNull(sessionMaxDurationInSeconds, "sessionMaxDurationInSeconds");
        this.userId = userId;
        this.actor = actor;
        this.expiresInSeconds = expiresInSeconds;
        this.sessionMaxDurationInSeconds = sessionMaxDurationInSeconds;
    }
    
    public CreateActorTokenRequestBody(
            String userId,
            Actor actor) {
        this(userId, actor, Optional.empty(),
            Optional.empty());
    }

    /**
     * The ID of the user being impersonated.
     */
    @JsonIgnore
    public String userId() {
        return userId;
    }

    /**
     * The actor payload. It needs to include a sub property which should contain the ID of the actor.
     * This whole payload will be also included in the JWT session token.
     */
    @JsonIgnore
    public Actor actor() {
        return actor;
    }

    /**
     * Optional parameter to specify the life duration of the actor token in seconds.
     * By default, the duration is 1 hour.
     */
    @JsonIgnore
    public Optional<Long> expiresInSeconds() {
        return expiresInSeconds;
    }

    /**
     * The maximum duration that the session which will be created by the generated actor token should last.
     * By default, the duration of a session created via an actor token, lasts 30 minutes.
     */
    @JsonIgnore
    public Optional<Long> sessionMaxDurationInSeconds() {
        return sessionMaxDurationInSeconds;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * The ID of the user being impersonated.
     */
    public CreateActorTokenRequestBody withUserId(String userId) {
        Utils.checkNotNull(userId, "userId");
        this.userId = userId;
        return this;
    }

    /**
     * The actor payload. It needs to include a sub property which should contain the ID of the actor.
     * This whole payload will be also included in the JWT session token.
     */
    public CreateActorTokenRequestBody withActor(Actor actor) {
        Utils.checkNotNull(actor, "actor");
        this.actor = actor;
        return this;
    }

    /**
     * Optional parameter to specify the life duration of the actor token in seconds.
     * By default, the duration is 1 hour.
     */
    public CreateActorTokenRequestBody withExpiresInSeconds(long expiresInSeconds) {
        Utils.checkNotNull(expiresInSeconds, "expiresInSeconds");
        this.expiresInSeconds = Optional.ofNullable(expiresInSeconds);
        return this;
    }


    /**
     * Optional parameter to specify the life duration of the actor token in seconds.
     * By default, the duration is 1 hour.
     */
    public CreateActorTokenRequestBody withExpiresInSeconds(Optional<Long> expiresInSeconds) {
        Utils.checkNotNull(expiresInSeconds, "expiresInSeconds");
        this.expiresInSeconds = expiresInSeconds;
        return this;
    }

    /**
     * The maximum duration that the session which will be created by the generated actor token should last.
     * By default, the duration of a session created via an actor token, lasts 30 minutes.
     */
    public CreateActorTokenRequestBody withSessionMaxDurationInSeconds(long sessionMaxDurationInSeconds) {
        Utils.checkNotNull(sessionMaxDurationInSeconds, "sessionMaxDurationInSeconds");
        this.sessionMaxDurationInSeconds = Optional.ofNullable(sessionMaxDurationInSeconds);
        return this;
    }


    /**
     * The maximum duration that the session which will be created by the generated actor token should last.
     * By default, the duration of a session created via an actor token, lasts 30 minutes.
     */
    public CreateActorTokenRequestBody withSessionMaxDurationInSeconds(Optional<Long> sessionMaxDurationInSeconds) {
        Utils.checkNotNull(sessionMaxDurationInSeconds, "sessionMaxDurationInSeconds");
        this.sessionMaxDurationInSeconds = sessionMaxDurationInSeconds;
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
        CreateActorTokenRequestBody other = (CreateActorTokenRequestBody) o;
        return 
            Utils.enhancedDeepEquals(this.userId, other.userId) &&
            Utils.enhancedDeepEquals(this.actor, other.actor) &&
            Utils.enhancedDeepEquals(this.expiresInSeconds, other.expiresInSeconds) &&
            Utils.enhancedDeepEquals(this.sessionMaxDurationInSeconds, other.sessionMaxDurationInSeconds);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            userId, actor, expiresInSeconds,
            sessionMaxDurationInSeconds);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CreateActorTokenRequestBody.class,
                "userId", userId,
                "actor", actor,
                "expiresInSeconds", expiresInSeconds,
                "sessionMaxDurationInSeconds", sessionMaxDurationInSeconds);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String userId;

        private Actor actor;

        private Optional<Long> expiresInSeconds;

        private Optional<Long> sessionMaxDurationInSeconds;

        private Builder() {
          // force use of static builder() method
        }


        /**
         * The ID of the user being impersonated.
         */
        public Builder userId(String userId) {
            Utils.checkNotNull(userId, "userId");
            this.userId = userId;
            return this;
        }


        /**
         * The actor payload. It needs to include a sub property which should contain the ID of the actor.
         * This whole payload will be also included in the JWT session token.
         */
        public Builder actor(Actor actor) {
            Utils.checkNotNull(actor, "actor");
            this.actor = actor;
            return this;
        }


        /**
         * Optional parameter to specify the life duration of the actor token in seconds.
         * By default, the duration is 1 hour.
         */
        public Builder expiresInSeconds(long expiresInSeconds) {
            Utils.checkNotNull(expiresInSeconds, "expiresInSeconds");
            this.expiresInSeconds = Optional.ofNullable(expiresInSeconds);
            return this;
        }

        /**
         * Optional parameter to specify the life duration of the actor token in seconds.
         * By default, the duration is 1 hour.
         */
        public Builder expiresInSeconds(Optional<Long> expiresInSeconds) {
            Utils.checkNotNull(expiresInSeconds, "expiresInSeconds");
            this.expiresInSeconds = expiresInSeconds;
            return this;
        }


        /**
         * The maximum duration that the session which will be created by the generated actor token should last.
         * By default, the duration of a session created via an actor token, lasts 30 minutes.
         */
        public Builder sessionMaxDurationInSeconds(long sessionMaxDurationInSeconds) {
            Utils.checkNotNull(sessionMaxDurationInSeconds, "sessionMaxDurationInSeconds");
            this.sessionMaxDurationInSeconds = Optional.ofNullable(sessionMaxDurationInSeconds);
            return this;
        }

        /**
         * The maximum duration that the session which will be created by the generated actor token should last.
         * By default, the duration of a session created via an actor token, lasts 30 minutes.
         */
        public Builder sessionMaxDurationInSeconds(Optional<Long> sessionMaxDurationInSeconds) {
            Utils.checkNotNull(sessionMaxDurationInSeconds, "sessionMaxDurationInSeconds");
            this.sessionMaxDurationInSeconds = sessionMaxDurationInSeconds;
            return this;
        }

        public CreateActorTokenRequestBody build() {
            if (expiresInSeconds == null) {
                expiresInSeconds = _SINGLETON_VALUE_ExpiresInSeconds.value();
            }
            if (sessionMaxDurationInSeconds == null) {
                sessionMaxDurationInSeconds = _SINGLETON_VALUE_SessionMaxDurationInSeconds.value();
            }

            return new CreateActorTokenRequestBody(
                userId, actor, expiresInSeconds,
                sessionMaxDurationInSeconds);
        }


        private static final LazySingletonValue<Optional<Long>> _SINGLETON_VALUE_ExpiresInSeconds =
                new LazySingletonValue<>(
                        "expires_in_seconds",
                        "3600",
                        new TypeReference<Optional<Long>>() {});

        private static final LazySingletonValue<Optional<Long>> _SINGLETON_VALUE_SessionMaxDurationInSeconds =
                new LazySingletonValue<>(
                        "session_max_duration_in_seconds",
                        "1800",
                        new TypeReference<Optional<Long>>() {});
    }
}
