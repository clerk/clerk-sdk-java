/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.operations;

import static com.clerk.backend_api.operations.Operations.RequestOperation;

import com.clerk.backend_api.SDKConfiguration;
import com.clerk.backend_api.operations.GetPublicInterstitialOperation;
import com.clerk.backend_api.utils.Options;
import com.clerk.backend_api.utils.RetryConfig;
import com.clerk.backend_api.utils.Utils;
import java.lang.Exception;
import java.util.Optional;

public class GetPublicInterstitialRequestBuilder {

    private GetPublicInterstitialRequest request;
    private Optional<RetryConfig> retryConfig = Optional.empty();
    private final SDKConfiguration sdkConfiguration;

    public GetPublicInterstitialRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }

    public GetPublicInterstitialRequestBuilder request(GetPublicInterstitialRequest request) {
        Utils.checkNotNull(request, "request");
        this.request = request;
        return this;
    }
                
    public GetPublicInterstitialRequestBuilder retryConfig(RetryConfig retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = Optional.of(retryConfig);
        return this;
    }

    public GetPublicInterstitialRequestBuilder retryConfig(Optional<RetryConfig> retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = retryConfig;
        return this;
    }

    public GetPublicInterstitialResponse call() throws Exception {
        Optional<Options> options = Optional.of(Options.builder()
            .retryConfig(retryConfig)
            .build());

        RequestOperation<GetPublicInterstitialRequest, GetPublicInterstitialResponse> operation
              = new GetPublicInterstitialOperation(
                sdkConfiguration,
                options);

        return operation.handleResponse(operation.doRequest(request));
    }
}
