/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.operations;

import static com.clerk.backend_api.operations.Operations.RequestOperation;

import com.clerk.backend_api.SDKConfiguration;
import com.clerk.backend_api.operations.VerifyPasswordOperation;
import com.clerk.backend_api.utils.Options;
import com.clerk.backend_api.utils.RetryConfig;
import com.clerk.backend_api.utils.Utils;
import java.lang.Exception;
import java.lang.String;
import java.util.Optional;

public class VerifyPasswordRequestBuilder {

    private String userId;
    private Optional<? extends VerifyPasswordRequestBody> requestBody = Optional.empty();
    private Optional<RetryConfig> retryConfig = Optional.empty();
    private final SDKConfiguration sdkConfiguration;

    public VerifyPasswordRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }

    public VerifyPasswordRequestBuilder userId(String userId) {
        Utils.checkNotNull(userId, "userId");
        this.userId = userId;
        return this;
    }
                
    public VerifyPasswordRequestBuilder requestBody(VerifyPasswordRequestBody requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = Optional.of(requestBody);
        return this;
    }

    public VerifyPasswordRequestBuilder requestBody(Optional<? extends VerifyPasswordRequestBody> requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = requestBody;
        return this;
    }
                
    public VerifyPasswordRequestBuilder retryConfig(RetryConfig retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = Optional.of(retryConfig);
        return this;
    }

    public VerifyPasswordRequestBuilder retryConfig(Optional<RetryConfig> retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = retryConfig;
        return this;
    }


    private VerifyPasswordRequest buildRequest() {

        VerifyPasswordRequest request = new VerifyPasswordRequest(userId,
            requestBody);

        return request;
    }

    public VerifyPasswordResponse call() throws Exception {
        Optional<Options> options = Optional.of(Options.builder()
            .retryConfig(retryConfig)
            .build());

        RequestOperation<VerifyPasswordRequest, VerifyPasswordResponse> operation
              = new VerifyPasswordOperation(
                sdkConfiguration,
                options);
        VerifyPasswordRequest request = buildRequest();

        return operation.handleResponse(operation.doRequest(request));
    }
}
