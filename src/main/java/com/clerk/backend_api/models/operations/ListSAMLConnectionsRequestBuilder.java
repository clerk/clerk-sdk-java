/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.utils.LazySingletonValue;
import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.Long;
import java.util.Optional;

public class ListSAMLConnectionsRequestBuilder {

    private Optional<Long> limit = Utils.readDefaultOrConstValue(
                            "limit",
                            "10",
                            new TypeReference<Optional<Long>>() {});
    private Optional<Long> offset = Utils.readDefaultOrConstValue(
                            "offset",
                            "0",
                            new TypeReference<Optional<Long>>() {});
    private final SDKMethodInterfaces.MethodCallListSAMLConnections sdk;

    public ListSAMLConnectionsRequestBuilder(SDKMethodInterfaces.MethodCallListSAMLConnections sdk) {
        this.sdk = sdk;
    }
                
    public ListSAMLConnectionsRequestBuilder limit(long limit) {
        Utils.checkNotNull(limit, "limit");
        this.limit = Optional.of(limit);
        return this;
    }

    public ListSAMLConnectionsRequestBuilder limit(java.util.Optional<java.lang.Long> limit) {
        Utils.checkNotNull(limit, "limit");
        this.limit = limit;
        return this;
    }
                
    public ListSAMLConnectionsRequestBuilder offset(long offset) {
        Utils.checkNotNull(offset, "offset");
        this.offset = Optional.of(offset);
        return this;
    }

    public ListSAMLConnectionsRequestBuilder offset(java.util.Optional<java.lang.Long> offset) {
        Utils.checkNotNull(offset, "offset");
        this.offset = offset;
        return this;
    }

    public ListSAMLConnectionsResponse call() throws Exception {
        if (limit == null) {
            limit = _SINGLETON_VALUE_Limit.value();
        }
        if (offset == null) {
            offset = _SINGLETON_VALUE_Offset.value();
        }
        return sdk.list(
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
