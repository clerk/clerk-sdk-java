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
import java.util.Objects;
import java.util.Optional;


public class ListSAMLConnectionsRequest {

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
    public ListSAMLConnectionsRequest(
            Optional<Long> limit,
            Optional<Long> offset) {
        Utils.checkNotNull(limit, "limit");
        Utils.checkNotNull(offset, "offset");
        this.limit = limit;
        this.offset = offset;
    }
    
    public ListSAMLConnectionsRequest() {
        this(Optional.empty(), Optional.empty());
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
     * Applies a limit to the number of results returned.
     * Can be used for paginating the results together with `offset`.
     */
    public ListSAMLConnectionsRequest withLimit(long limit) {
        Utils.checkNotNull(limit, "limit");
        this.limit = Optional.ofNullable(limit);
        return this;
    }

    /**
     * Applies a limit to the number of results returned.
     * Can be used for paginating the results together with `offset`.
     */
    public ListSAMLConnectionsRequest withLimit(Optional<Long> limit) {
        Utils.checkNotNull(limit, "limit");
        this.limit = limit;
        return this;
    }

    /**
     * Skip the first `offset` results when paginating.
     * Needs to be an integer greater or equal to zero.
     * To be used in conjunction with `limit`.
     */
    public ListSAMLConnectionsRequest withOffset(long offset) {
        Utils.checkNotNull(offset, "offset");
        this.offset = Optional.ofNullable(offset);
        return this;
    }

    /**
     * Skip the first `offset` results when paginating.
     * Needs to be an integer greater or equal to zero.
     * To be used in conjunction with `limit`.
     */
    public ListSAMLConnectionsRequest withOffset(Optional<Long> offset) {
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
        ListSAMLConnectionsRequest other = (ListSAMLConnectionsRequest) o;
        return 
            Objects.deepEquals(this.limit, other.limit) &&
            Objects.deepEquals(this.offset, other.offset);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            limit,
            offset);
    }
    
    @Override
    public String toString() {
        return Utils.toString(ListSAMLConnectionsRequest.class,
                "limit", limit,
                "offset", offset);
    }
    
    public final static class Builder {
 
        private Optional<Long> limit;
 
        private Optional<Long> offset;  
        
        private Builder() {
          // force use of static builder() method
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
        
        public ListSAMLConnectionsRequest build() {
            if (limit == null) {
                limit = _SINGLETON_VALUE_Limit.value();
            }
            if (offset == null) {
                offset = _SINGLETON_VALUE_Offset.value();
            }
            return new ListSAMLConnectionsRequest(
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

