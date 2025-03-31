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

public class UserPasskeyDeleteRequestBuilder {

    private String userId;
    private String passkeyIdentificationId;
    private Optional<RetryConfig> retryConfig = Optional.empty();
    private final SDKMethodInterfaces.MethodCallUserPasskeyDelete sdk;

    public UserPasskeyDeleteRequestBuilder(SDKMethodInterfaces.MethodCallUserPasskeyDelete sdk) {
        this.sdk = sdk;
    }

    public UserPasskeyDeleteRequestBuilder userId(String userId) {
        Utils.checkNotNull(userId, "userId");
        this.userId = userId;
        return this;
    }

    public UserPasskeyDeleteRequestBuilder passkeyIdentificationId(String passkeyIdentificationId) {
        Utils.checkNotNull(passkeyIdentificationId, "passkeyIdentificationId");
        this.passkeyIdentificationId = passkeyIdentificationId;
        return this;
    }
                
    public UserPasskeyDeleteRequestBuilder retryConfig(RetryConfig retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = Optional.of(retryConfig);
        return this;
    }

    public UserPasskeyDeleteRequestBuilder retryConfig(Optional<RetryConfig> retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = retryConfig;
        return this;
    }

    public UserPasskeyDeleteResponse call() throws Exception {
        Optional<Options> options = Optional.of(Options.builder()
                                                    .retryConfig(retryConfig)
                                                    .build());
        return sdk.deletePasskey(
            userId,
            passkeyIdentificationId,
            options);
    }
}
