/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.operations;

import static com.clerk.backend_api.operations.Operations.RequestOperation;

import com.clerk.backend_api.SDKConfiguration;
import com.clerk.backend_api.operations.DeleteOAuthApplicationOperation;
import com.clerk.backend_api.utils.Options;
import com.clerk.backend_api.utils.RetryConfig;
import com.clerk.backend_api.utils.Utils;
import java.lang.Exception;
import java.lang.String;
import java.util.Optional;

public class DeleteOAuthApplicationRequestBuilder {

    private String oauthApplicationId;
    private Optional<RetryConfig> retryConfig = Optional.empty();
    private final SDKConfiguration sdkConfiguration;

    public DeleteOAuthApplicationRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }

    public DeleteOAuthApplicationRequestBuilder oauthApplicationId(String oauthApplicationId) {
        Utils.checkNotNull(oauthApplicationId, "oauthApplicationId");
        this.oauthApplicationId = oauthApplicationId;
        return this;
    }
                
    public DeleteOAuthApplicationRequestBuilder retryConfig(RetryConfig retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = Optional.of(retryConfig);
        return this;
    }

    public DeleteOAuthApplicationRequestBuilder retryConfig(Optional<RetryConfig> retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = retryConfig;
        return this;
    }


    private DeleteOAuthApplicationRequest buildRequest() {

        DeleteOAuthApplicationRequest request = new DeleteOAuthApplicationRequest(oauthApplicationId);

        return request;
    }

    public DeleteOAuthApplicationResponse call() throws Exception {
        Optional<Options> options = Optional.of(Options.builder()
            .retryConfig(retryConfig)
            .build());

        RequestOperation<DeleteOAuthApplicationRequest, DeleteOAuthApplicationResponse> operation
              = new DeleteOAuthApplicationOperation(
                sdkConfiguration,
                options);
        DeleteOAuthApplicationRequest request = buildRequest();

        return operation.handleResponse(operation.doRequest(request));
    }
}
