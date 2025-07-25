/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.components;

import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.Optional;

/**
 * ActorToken
 * 
 * <p>Success
 */
public class ActorToken {

    @JsonProperty("object")
    private ActorTokenObject object;


    @JsonProperty("id")
    private String id;


    @JsonProperty("status")
    private ActorTokenStatus status;


    @JsonProperty("user_id")
    private String userId;


    @JsonProperty("actor")
    private ActorTokenActor actor;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("token")
    private Optional<String> token;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("url")
    private Optional<String> url;

    /**
     * Unix timestamp of creation.
     */
    @JsonProperty("created_at")
    private long createdAt;

    /**
     * Unix timestamp of last update.
     */
    @JsonProperty("updated_at")
    private long updatedAt;

    @JsonCreator
    public ActorToken(
            @JsonProperty("object") ActorTokenObject object,
            @JsonProperty("id") String id,
            @JsonProperty("status") ActorTokenStatus status,
            @JsonProperty("user_id") String userId,
            @JsonProperty("actor") ActorTokenActor actor,
            @JsonProperty("token") Optional<String> token,
            @JsonProperty("url") Optional<String> url,
            @JsonProperty("created_at") long createdAt,
            @JsonProperty("updated_at") long updatedAt) {
        Utils.checkNotNull(object, "object");
        Utils.checkNotNull(id, "id");
        Utils.checkNotNull(status, "status");
        Utils.checkNotNull(userId, "userId");
        Utils.checkNotNull(actor, "actor");
        Utils.checkNotNull(token, "token");
        Utils.checkNotNull(url, "url");
        Utils.checkNotNull(createdAt, "createdAt");
        Utils.checkNotNull(updatedAt, "updatedAt");
        this.object = object;
        this.id = id;
        this.status = status;
        this.userId = userId;
        this.actor = actor;
        this.token = token;
        this.url = url;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    public ActorToken(
            ActorTokenObject object,
            String id,
            ActorTokenStatus status,
            String userId,
            ActorTokenActor actor,
            long createdAt,
            long updatedAt) {
        this(object, id, status,
            userId, actor, Optional.empty(),
            Optional.empty(), createdAt, updatedAt);
    }

    @JsonIgnore
    public ActorTokenObject object() {
        return object;
    }

    @JsonIgnore
    public String id() {
        return id;
    }

    @JsonIgnore
    public ActorTokenStatus status() {
        return status;
    }

    @JsonIgnore
    public String userId() {
        return userId;
    }

    @JsonIgnore
    public ActorTokenActor actor() {
        return actor;
    }

    @JsonIgnore
    public Optional<String> token() {
        return token;
    }

    @JsonIgnore
    public Optional<String> url() {
        return url;
    }

    /**
     * Unix timestamp of creation.
     */
    @JsonIgnore
    public long createdAt() {
        return createdAt;
    }

    /**
     * Unix timestamp of last update.
     */
    @JsonIgnore
    public long updatedAt() {
        return updatedAt;
    }

    public static Builder builder() {
        return new Builder();
    }


    public ActorToken withObject(ActorTokenObject object) {
        Utils.checkNotNull(object, "object");
        this.object = object;
        return this;
    }

    public ActorToken withId(String id) {
        Utils.checkNotNull(id, "id");
        this.id = id;
        return this;
    }

    public ActorToken withStatus(ActorTokenStatus status) {
        Utils.checkNotNull(status, "status");
        this.status = status;
        return this;
    }

    public ActorToken withUserId(String userId) {
        Utils.checkNotNull(userId, "userId");
        this.userId = userId;
        return this;
    }

    public ActorToken withActor(ActorTokenActor actor) {
        Utils.checkNotNull(actor, "actor");
        this.actor = actor;
        return this;
    }

    public ActorToken withToken(String token) {
        Utils.checkNotNull(token, "token");
        this.token = Optional.ofNullable(token);
        return this;
    }


    public ActorToken withToken(Optional<String> token) {
        Utils.checkNotNull(token, "token");
        this.token = token;
        return this;
    }

    public ActorToken withUrl(String url) {
        Utils.checkNotNull(url, "url");
        this.url = Optional.ofNullable(url);
        return this;
    }


    public ActorToken withUrl(Optional<String> url) {
        Utils.checkNotNull(url, "url");
        this.url = url;
        return this;
    }

    /**
     * Unix timestamp of creation.
     */
    public ActorToken withCreatedAt(long createdAt) {
        Utils.checkNotNull(createdAt, "createdAt");
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Unix timestamp of last update.
     */
    public ActorToken withUpdatedAt(long updatedAt) {
        Utils.checkNotNull(updatedAt, "updatedAt");
        this.updatedAt = updatedAt;
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
        ActorToken other = (ActorToken) o;
        return 
            Utils.enhancedDeepEquals(this.object, other.object) &&
            Utils.enhancedDeepEquals(this.id, other.id) &&
            Utils.enhancedDeepEquals(this.status, other.status) &&
            Utils.enhancedDeepEquals(this.userId, other.userId) &&
            Utils.enhancedDeepEquals(this.actor, other.actor) &&
            Utils.enhancedDeepEquals(this.token, other.token) &&
            Utils.enhancedDeepEquals(this.url, other.url) &&
            Utils.enhancedDeepEquals(this.createdAt, other.createdAt) &&
            Utils.enhancedDeepEquals(this.updatedAt, other.updatedAt);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            object, id, status,
            userId, actor, token,
            url, createdAt, updatedAt);
    }
    
    @Override
    public String toString() {
        return Utils.toString(ActorToken.class,
                "object", object,
                "id", id,
                "status", status,
                "userId", userId,
                "actor", actor,
                "token", token,
                "url", url,
                "createdAt", createdAt,
                "updatedAt", updatedAt);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private ActorTokenObject object;

        private String id;

        private ActorTokenStatus status;

        private String userId;

        private ActorTokenActor actor;

        private Optional<String> token = Optional.empty();

        private Optional<String> url = Optional.empty();

        private Long createdAt;

        private Long updatedAt;

        private Builder() {
          // force use of static builder() method
        }


        public Builder object(ActorTokenObject object) {
            Utils.checkNotNull(object, "object");
            this.object = object;
            return this;
        }


        public Builder id(String id) {
            Utils.checkNotNull(id, "id");
            this.id = id;
            return this;
        }


        public Builder status(ActorTokenStatus status) {
            Utils.checkNotNull(status, "status");
            this.status = status;
            return this;
        }


        public Builder userId(String userId) {
            Utils.checkNotNull(userId, "userId");
            this.userId = userId;
            return this;
        }


        public Builder actor(ActorTokenActor actor) {
            Utils.checkNotNull(actor, "actor");
            this.actor = actor;
            return this;
        }


        public Builder token(String token) {
            Utils.checkNotNull(token, "token");
            this.token = Optional.ofNullable(token);
            return this;
        }

        public Builder token(Optional<String> token) {
            Utils.checkNotNull(token, "token");
            this.token = token;
            return this;
        }


        public Builder url(String url) {
            Utils.checkNotNull(url, "url");
            this.url = Optional.ofNullable(url);
            return this;
        }

        public Builder url(Optional<String> url) {
            Utils.checkNotNull(url, "url");
            this.url = url;
            return this;
        }


        /**
         * Unix timestamp of creation.
         */
        public Builder createdAt(long createdAt) {
            Utils.checkNotNull(createdAt, "createdAt");
            this.createdAt = createdAt;
            return this;
        }


        /**
         * Unix timestamp of last update.
         */
        public Builder updatedAt(long updatedAt) {
            Utils.checkNotNull(updatedAt, "updatedAt");
            this.updatedAt = updatedAt;
            return this;
        }

        public ActorToken build() {

            return new ActorToken(
                object, id, status,
                userId, actor, token,
                url, createdAt, updatedAt);
        }

    }
}
