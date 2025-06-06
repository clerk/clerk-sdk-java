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

public class GetPhoneNumberRequestBuilder {

    private String phoneNumberId;
    private Optional<RetryConfig> retryConfig = Optional.empty();
    private final SDKMethodInterfaces.MethodCallGetPhoneNumber sdk;

    public GetPhoneNumberRequestBuilder(SDKMethodInterfaces.MethodCallGetPhoneNumber sdk) {
        this.sdk = sdk;
    }

    public GetPhoneNumberRequestBuilder phoneNumberId(String phoneNumberId) {
        Utils.checkNotNull(phoneNumberId, "phoneNumberId");
        this.phoneNumberId = phoneNumberId;
        return this;
    }
                
    public GetPhoneNumberRequestBuilder retryConfig(RetryConfig retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = Optional.of(retryConfig);
        return this;
    }

    public GetPhoneNumberRequestBuilder retryConfig(Optional<RetryConfig> retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = retryConfig;
        return this;
    }

    public GetPhoneNumberResponse call() throws Exception {
        Optional<Options> options = Optional.of(Options.builder()
                                                    .retryConfig(retryConfig)
                                                    .build());
        return sdk.get(
            phoneNumberId,
            options);
    }
}
