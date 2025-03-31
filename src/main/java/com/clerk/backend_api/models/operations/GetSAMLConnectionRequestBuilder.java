/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.utils.Options;
import com.clerk.backend_api.utils.RetryConfig;
import com.clerk.backend_api.utils.Utils;
import java.lang.Exception;
import java.lang.String;
import java.util.Optional;

public class GetSAMLConnectionRequestBuilder {

    private String samlConnectionId;
    private Optional<RetryConfig> retryConfig = Optional.empty();
    private final SDKMethodInterfaces.MethodCallGetSAMLConnection sdk;

    public GetSAMLConnectionRequestBuilder(SDKMethodInterfaces.MethodCallGetSAMLConnection sdk) {
        this.sdk = sdk;
    }

    public GetSAMLConnectionRequestBuilder samlConnectionId(String samlConnectionId) {
        Utils.checkNotNull(samlConnectionId, "samlConnectionId");
        this.samlConnectionId = samlConnectionId;
        return this;
    }
                
    public GetSAMLConnectionRequestBuilder retryConfig(RetryConfig retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = Optional.of(retryConfig);
        return this;
    }

    public GetSAMLConnectionRequestBuilder retryConfig(Optional<RetryConfig> retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = retryConfig;
        return this;
    }

    public GetSAMLConnectionResponse call() throws Exception {
        Optional<Options> options = Optional.of(Options.builder()
                                                    .retryConfig(retryConfig)
                                                    .build());
        return sdk.get(
            samlConnectionId,
            options);
    }
}
