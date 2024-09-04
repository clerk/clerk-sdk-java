/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.operations;


import com.clerk.backend_api.utils.LazySingletonValue;
import com.clerk.backend_api.utils.SpeakeasyMetadata;
import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Objects;
import java.util.Optional;


public class GetSessionListRequest {

    /**
     * List sessions for the given client
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=client_id")
    private Optional<String> clientId;

    /**
     * List sessions for the given user
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=user_id")
    private Optional<String> userId;

    /**
     * Filter sessions by the provided status
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=status")
    private Optional<? extends Status> status;

    /**
     * Applies a limit to the number of results returned.
     * Can be used for paginating the results together with `offset`.
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=limit")
    private Optional<Long> limit;

    /**
     * Skip the first `offset` results when paginating.
     * Needs to be an integer greater or equal to zero.
     * To be used in conjunction with `limit`.
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=offset")
    private Optional<Long> offset;

    @JsonCreator
    public GetSessionListRequest(
            Optional<String> clientId,
            Optional<String> userId,
            Optional<? extends Status> status,
            Optional<Long> limit,
            Optional<Long> offset) {
        Utils.checkNotNull(clientId, "clientId");
        Utils.checkNotNull(userId, "userId");
        Utils.checkNotNull(status, "status");
        Utils.checkNotNull(limit, "limit");
        Utils.checkNotNull(offset, "offset");
        this.clientId = clientId;
        this.userId = userId;
        this.status = status;
        this.limit = limit;
        this.offset = offset;
    }
    
    public GetSessionListRequest() {
        this(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty());
    }

    /**
     * List sessions for the given client
     */
    @JsonIgnore
    public Optional<String> clientId() {
        return clientId;
    }

    /**
     * List sessions for the given user
     */
    @JsonIgnore
    public Optional<String> userId() {
        return userId;
    }

    /**
     * Filter sessions by the provided status
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<Status> status() {
        return (Optional<Status>) status;
    }

    /**
     * Applies a limit to the number of results returned.
     * Can be used for paginating the results together with `offset`.
     */
    @JsonIgnore
    public Optional<Long> limit() {
        return limit;
    }

    /**
     * Skip the first `offset` results when paginating.
     * Needs to be an integer greater or equal to zero.
     * To be used in conjunction with `limit`.
     */
    @JsonIgnore
    public Optional<Long> offset() {
        return offset;
    }

    public final static Builder builder() {
        return new Builder();
    }

    /**
     * List sessions for the given client
     */
    public GetSessionListRequest withClientId(String clientId) {
        Utils.checkNotNull(clientId, "clientId");
        this.clientId = Optional.ofNullable(clientId);
        return this;
    }

    /**
     * List sessions for the given client
     */
    public GetSessionListRequest withClientId(Optional<String> clientId) {
        Utils.checkNotNull(clientId, "clientId");
        this.clientId = clientId;
        return this;
    }

    /**
     * List sessions for the given user
     */
    public GetSessionListRequest withUserId(String userId) {
        Utils.checkNotNull(userId, "userId");
        this.userId = Optional.ofNullable(userId);
        return this;
    }

    /**
     * List sessions for the given user
     */
    public GetSessionListRequest withUserId(Optional<String> userId) {
        Utils.checkNotNull(userId, "userId");
        this.userId = userId;
        return this;
    }

    /**
     * Filter sessions by the provided status
     */
    public GetSessionListRequest withStatus(Status status) {
        Utils.checkNotNull(status, "status");
        this.status = Optional.ofNullable(status);
        return this;
    }

    /**
     * Filter sessions by the provided status
     */
    public GetSessionListRequest withStatus(Optional<? extends Status> status) {
        Utils.checkNotNull(status, "status");
        this.status = status;
        return this;
    }

    /**
     * Applies a limit to the number of results returned.
     * Can be used for paginating the results together with `offset`.
     */
    public GetSessionListRequest withLimit(long limit) {
        Utils.checkNotNull(limit, "limit");
        this.limit = Optional.ofNullable(limit);
        return this;
    }

    /**
     * Applies a limit to the number of results returned.
     * Can be used for paginating the results together with `offset`.
     */
    public GetSessionListRequest withLimit(Optional<Long> limit) {
        Utils.checkNotNull(limit, "limit");
        this.limit = limit;
        return this;
    }

    /**
     * Skip the first `offset` results when paginating.
     * Needs to be an integer greater or equal to zero.
     * To be used in conjunction with `limit`.
     */
    public GetSessionListRequest withOffset(long offset) {
        Utils.checkNotNull(offset, "offset");
        this.offset = Optional.ofNullable(offset);
        return this;
    }

    /**
     * Skip the first `offset` results when paginating.
     * Needs to be an integer greater or equal to zero.
     * To be used in conjunction with `limit`.
     */
    public GetSessionListRequest withOffset(Optional<Long> offset) {
        Utils.checkNotNull(offset, "offset");
        this.offset = offset;
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
        GetSessionListRequest other = (GetSessionListRequest) o;
        return 
            Objects.deepEquals(this.clientId, other.clientId) &&
            Objects.deepEquals(this.userId, other.userId) &&
            Objects.deepEquals(this.status, other.status) &&
            Objects.deepEquals(this.limit, other.limit) &&
            Objects.deepEquals(this.offset, other.offset);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            clientId,
            userId,
            status,
            limit,
            offset);
    }
    
    @Override
    public String toString() {
        return Utils.toString(GetSessionListRequest.class,
                "clientId", clientId,
                "userId", userId,
                "status", status,
                "limit", limit,
                "offset", offset);
    }
    
    public final static class Builder {
 
        private Optional<String> clientId = Optional.empty();
 
        private Optional<String> userId = Optional.empty();
 
        private Optional<? extends Status> status = Optional.empty();
 
        private Optional<Long> limit;
 
        private Optional<Long> offset;  
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * List sessions for the given client
         */
        public Builder clientId(String clientId) {
            Utils.checkNotNull(clientId, "clientId");
            this.clientId = Optional.ofNullable(clientId);
            return this;
        }

        /**
         * List sessions for the given client
         */
        public Builder clientId(Optional<String> clientId) {
            Utils.checkNotNull(clientId, "clientId");
            this.clientId = clientId;
            return this;
        }

        /**
         * List sessions for the given user
         */
        public Builder userId(String userId) {
            Utils.checkNotNull(userId, "userId");
            this.userId = Optional.ofNullable(userId);
            return this;
        }

        /**
         * List sessions for the given user
         */
        public Builder userId(Optional<String> userId) {
            Utils.checkNotNull(userId, "userId");
            this.userId = userId;
            return this;
        }

        /**
         * Filter sessions by the provided status
         */
        public Builder status(Status status) {
            Utils.checkNotNull(status, "status");
            this.status = Optional.ofNullable(status);
            return this;
        }

        /**
         * Filter sessions by the provided status
         */
        public Builder status(Optional<? extends Status> status) {
            Utils.checkNotNull(status, "status");
            this.status = status;
            return this;
        }

        /**
         * Applies a limit to the number of results returned.
         * Can be used for paginating the results together with `offset`.
         */
        public Builder limit(long limit) {
            Utils.checkNotNull(limit, "limit");
            this.limit = Optional.ofNullable(limit);
            return this;
        }

        /**
         * Applies a limit to the number of results returned.
         * Can be used for paginating the results together with `offset`.
         */
        public Builder limit(Optional<Long> limit) {
            Utils.checkNotNull(limit, "limit");
            this.limit = limit;
            return this;
        }

        /**
         * Skip the first `offset` results when paginating.
         * Needs to be an integer greater or equal to zero.
         * To be used in conjunction with `limit`.
         */
        public Builder offset(long offset) {
            Utils.checkNotNull(offset, "offset");
            this.offset = Optional.ofNullable(offset);
            return this;
        }

        /**
         * Skip the first `offset` results when paginating.
         * Needs to be an integer greater or equal to zero.
         * To be used in conjunction with `limit`.
         */
        public Builder offset(Optional<Long> offset) {
            Utils.checkNotNull(offset, "offset");
            this.offset = offset;
            return this;
        }
        
        public GetSessionListRequest build() {
            if (limit == null) {
                limit = _SINGLETON_VALUE_Limit.value();
            }
            if (offset == null) {
                offset = _SINGLETON_VALUE_Offset.value();
            }            return new GetSessionListRequest(
                clientId,
                userId,
                status,
                limit,
                offset);
        }

        private static final LazySingletonValue<Optional<Long>> _SINGLETON_VALUE_Limit =
                new LazySingletonValue<>(
                        "limit",
                        "10",
                        new TypeReference<Optional<Long>>() {});

        private static final LazySingletonValue<Optional<Long>> _SINGLETON_VALUE_Offset =
                new LazySingletonValue<>(
                        "offset",
                        "0",
                        new TypeReference<Optional<Long>>() {});
    }
}

