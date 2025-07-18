/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.operations;

import static com.clerk.backend_api.operations.Operations.RequestOperation;

import com.clerk.backend_api.SDKConfiguration;
import com.clerk.backend_api.operations.GetOrganizationInvitationOperation;
import com.clerk.backend_api.utils.Options;
import com.clerk.backend_api.utils.RetryConfig;
import com.clerk.backend_api.utils.Utils;
import java.lang.Exception;
import java.lang.String;
import java.util.Optional;

public class GetOrganizationInvitationRequestBuilder {

    private String organizationId;
    private String invitationId;
    private Optional<RetryConfig> retryConfig = Optional.empty();
    private final SDKConfiguration sdkConfiguration;

    public GetOrganizationInvitationRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }

    public GetOrganizationInvitationRequestBuilder organizationId(String organizationId) {
        Utils.checkNotNull(organizationId, "organizationId");
        this.organizationId = organizationId;
        return this;
    }

    public GetOrganizationInvitationRequestBuilder invitationId(String invitationId) {
        Utils.checkNotNull(invitationId, "invitationId");
        this.invitationId = invitationId;
        return this;
    }
                
    public GetOrganizationInvitationRequestBuilder retryConfig(RetryConfig retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = Optional.of(retryConfig);
        return this;
    }

    public GetOrganizationInvitationRequestBuilder retryConfig(Optional<RetryConfig> retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = retryConfig;
        return this;
    }


    private GetOrganizationInvitationRequest buildRequest() {

        GetOrganizationInvitationRequest request = new GetOrganizationInvitationRequest(organizationId,
            invitationId);

        return request;
    }

    public GetOrganizationInvitationResponse call() throws Exception {
        Optional<Options> options = Optional.of(Options.builder()
            .retryConfig(retryConfig)
            .build());

        RequestOperation<GetOrganizationInvitationRequest, GetOrganizationInvitationResponse> operation
              = new GetOrganizationInvitationOperation(
                sdkConfiguration,
                options);
        GetOrganizationInvitationRequest request = buildRequest();

        return operation.handleResponse(operation.doRequest(request));
    }
}
