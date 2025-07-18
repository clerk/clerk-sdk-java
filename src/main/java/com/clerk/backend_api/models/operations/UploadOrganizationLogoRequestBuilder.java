/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.operations;

import static com.clerk.backend_api.operations.Operations.RequestOperation;

import com.clerk.backend_api.SDKConfiguration;
import com.clerk.backend_api.operations.UploadOrganizationLogoOperation;
import com.clerk.backend_api.utils.Options;
import com.clerk.backend_api.utils.RetryConfig;
import com.clerk.backend_api.utils.Utils;
import java.lang.Exception;
import java.lang.String;
import java.util.Optional;

public class UploadOrganizationLogoRequestBuilder {

    private String organizationId;
    private Optional<? extends UploadOrganizationLogoRequestBody> requestBody = Optional.empty();
    private Optional<RetryConfig> retryConfig = Optional.empty();
    private final SDKConfiguration sdkConfiguration;

    public UploadOrganizationLogoRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }

    public UploadOrganizationLogoRequestBuilder organizationId(String organizationId) {
        Utils.checkNotNull(organizationId, "organizationId");
        this.organizationId = organizationId;
        return this;
    }
                
    public UploadOrganizationLogoRequestBuilder requestBody(UploadOrganizationLogoRequestBody requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = Optional.of(requestBody);
        return this;
    }

    public UploadOrganizationLogoRequestBuilder requestBody(Optional<? extends UploadOrganizationLogoRequestBody> requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = requestBody;
        return this;
    }
                
    public UploadOrganizationLogoRequestBuilder retryConfig(RetryConfig retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = Optional.of(retryConfig);
        return this;
    }

    public UploadOrganizationLogoRequestBuilder retryConfig(Optional<RetryConfig> retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = retryConfig;
        return this;
    }


    private UploadOrganizationLogoRequest buildRequest() {

        UploadOrganizationLogoRequest request = new UploadOrganizationLogoRequest(organizationId,
            requestBody);

        return request;
    }

    public UploadOrganizationLogoResponse call() throws Exception {
        Optional<Options> options = Optional.of(Options.builder()
            .retryConfig(retryConfig)
            .build());

        RequestOperation<UploadOrganizationLogoRequest, UploadOrganizationLogoResponse> operation
              = new UploadOrganizationLogoOperation(
                sdkConfiguration,
                options);
        UploadOrganizationLogoRequest request = buildRequest();

        return operation.handleResponse(operation.doRequest(request));
    }
}
