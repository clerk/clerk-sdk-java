/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.operations;

import static com.clerk.backend_api.operations.Operations.RequestOperation;

import com.clerk.backend_api.SDKConfiguration;
import com.clerk.backend_api.operations.AddDomainOperation;
import com.clerk.backend_api.utils.Options;
import com.clerk.backend_api.utils.RetryConfig;
import com.clerk.backend_api.utils.Utils;
import java.lang.Exception;
import java.util.Optional;

public class AddDomainRequestBuilder {

    private Optional<? extends AddDomainRequestBody> request = Optional.empty();
    private Optional<RetryConfig> retryConfig = Optional.empty();
    private final SDKConfiguration sdkConfiguration;

    public AddDomainRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }
                
    public AddDomainRequestBuilder request(AddDomainRequestBody request) {
        Utils.checkNotNull(request, "request");
        this.request = Optional.of(request);
        return this;
    }

    public AddDomainRequestBuilder request(Optional<? extends AddDomainRequestBody> request) {
        Utils.checkNotNull(request, "request");
        this.request = request;
        return this;
    }
                
    public AddDomainRequestBuilder retryConfig(RetryConfig retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = Optional.of(retryConfig);
        return this;
    }

    public AddDomainRequestBuilder retryConfig(Optional<RetryConfig> retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = retryConfig;
        return this;
    }

    public AddDomainResponse call() throws Exception {
        Optional<Options> options = Optional.of(Options.builder()
            .retryConfig(retryConfig)
            .build());

        RequestOperation<Optional<? extends AddDomainRequestBody>, AddDomainResponse> operation
              = new AddDomainOperation(
                sdkConfiguration,
                options);

        return operation.handleResponse(operation.doRequest(request));
    }
}
