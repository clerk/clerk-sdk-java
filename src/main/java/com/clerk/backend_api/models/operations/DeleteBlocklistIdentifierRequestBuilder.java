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

public class DeleteBlocklistIdentifierRequestBuilder {

    private String identifierId;
    private Optional<RetryConfig> retryConfig = Optional.empty();
    private final SDKMethodInterfaces.MethodCallDeleteBlocklistIdentifier sdk;

    public DeleteBlocklistIdentifierRequestBuilder(SDKMethodInterfaces.MethodCallDeleteBlocklistIdentifier sdk) {
        this.sdk = sdk;
    }

    public DeleteBlocklistIdentifierRequestBuilder identifierId(String identifierId) {
        Utils.checkNotNull(identifierId, "identifierId");
        this.identifierId = identifierId;
        return this;
    }
                
    public DeleteBlocklistIdentifierRequestBuilder retryConfig(RetryConfig retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = Optional.of(retryConfig);
        return this;
    }

    public DeleteBlocklistIdentifierRequestBuilder retryConfig(Optional<RetryConfig> retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = retryConfig;
        return this;
    }

    public DeleteBlocklistIdentifierResponse call() throws Exception {
        Optional<Options> options = Optional.of(Options.builder()
                                                    .retryConfig(retryConfig)
                                                    .build());
        return sdk.delete(
            identifierId,
            options);
    }
}
