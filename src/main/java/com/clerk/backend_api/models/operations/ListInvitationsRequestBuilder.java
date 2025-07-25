/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.operations;

import static com.clerk.backend_api.operations.Operations.RequestOperation;

import com.clerk.backend_api.SDKConfiguration;
import com.clerk.backend_api.operations.ListInvitationsOperation;
import com.clerk.backend_api.utils.Options;
import com.clerk.backend_api.utils.RetryConfig;
import com.clerk.backend_api.utils.Utils;
import java.lang.Exception;
import java.util.Optional;

public class ListInvitationsRequestBuilder {

    private ListInvitationsRequest request;
    private Optional<RetryConfig> retryConfig = Optional.empty();
    private final SDKConfiguration sdkConfiguration;

    public ListInvitationsRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }

    public ListInvitationsRequestBuilder request(ListInvitationsRequest request) {
        Utils.checkNotNull(request, "request");
        this.request = request;
        return this;
    }
                
    public ListInvitationsRequestBuilder retryConfig(RetryConfig retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = Optional.of(retryConfig);
        return this;
    }

    public ListInvitationsRequestBuilder retryConfig(Optional<RetryConfig> retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = retryConfig;
        return this;
    }

    public ListInvitationsResponse call() throws Exception {
        Optional<Options> options = Optional.of(Options.builder()
            .retryConfig(retryConfig)
            .build());

        RequestOperation<ListInvitationsRequest, ListInvitationsResponse> operation
              = new ListInvitationsOperation(
                sdkConfiguration,
                options);

        return operation.handleResponse(operation.doRequest(request));
    }
}
