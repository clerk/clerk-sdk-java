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

public class RevokeSessionRequestBuilder {

    private String sessionId;
    private Optional<RetryConfig> retryConfig = Optional.empty();
    private final SDKMethodInterfaces.MethodCallRevokeSession sdk;

    public RevokeSessionRequestBuilder(SDKMethodInterfaces.MethodCallRevokeSession sdk) {
        this.sdk = sdk;
    }

    public RevokeSessionRequestBuilder sessionId(String sessionId) {
        Utils.checkNotNull(sessionId, "sessionId");
        this.sessionId = sessionId;
        return this;
    }
                
    public RevokeSessionRequestBuilder retryConfig(RetryConfig retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = Optional.of(retryConfig);
        return this;
    }

    public RevokeSessionRequestBuilder retryConfig(Optional<RetryConfig> retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = retryConfig;
        return this;
    }

    public RevokeSessionResponse call() throws Exception {
        Optional<Options> options = Optional.of(Options.builder()
                                                    .retryConfig(retryConfig)
                                                    .build());
        return sdk.revoke(
            sessionId,
            options);
    }
}
