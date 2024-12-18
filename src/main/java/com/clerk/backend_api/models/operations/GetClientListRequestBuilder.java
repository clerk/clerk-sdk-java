/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.utils.LazySingletonValue;
import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.Long;
import java.util.Optional;

public class GetClientListRequestBuilder {

    private Optional<Long> limit = Utils.readDefaultOrConstValue(
                            "limit",
                            "10",
                            new TypeReference<Optional<Long>>() {});
    private Optional<Long> offset = Utils.readDefaultOrConstValue(
                            "offset",
                            "0",
                            new TypeReference<Optional<Long>>() {});
    private final SDKMethodInterfaces.MethodCallGetClientList sdk;

    public GetClientListRequestBuilder(SDKMethodInterfaces.MethodCallGetClientList sdk) {
        this.sdk = sdk;
    }
                
    public GetClientListRequestBuilder limit(long limit) {
        Utils.checkNotNull(limit, "limit");
        this.limit = Optional.of(limit);
        return this;
    }

    public GetClientListRequestBuilder limit(Optional<Long> limit) {
        Utils.checkNotNull(limit, "limit");
        this.limit = limit;
        return this;
    }
                
    public GetClientListRequestBuilder offset(long offset) {
        Utils.checkNotNull(offset, "offset");
        this.offset = Optional.of(offset);
        return this;
    }

    public GetClientListRequestBuilder offset(Optional<Long> offset) {
        Utils.checkNotNull(offset, "offset");
        this.offset = offset;
        return this;
    }

    public GetClientListResponse call() throws Exception {
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
