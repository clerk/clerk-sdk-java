/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.operations;

import static com.clerk.backend_api.operations.Operations.RequestOperation;

import com.clerk.backend_api.SDKConfiguration;
import com.clerk.backend_api.operations.UpdateJWTTemplateOperation;
import com.clerk.backend_api.utils.Options;
import com.clerk.backend_api.utils.RetryConfig;
import com.clerk.backend_api.utils.Utils;
import java.lang.Exception;
import java.lang.String;
import java.util.Optional;

public class UpdateJWTTemplateRequestBuilder {

    private String templateId;
    private Optional<? extends UpdateJWTTemplateRequestBody> requestBody = Optional.empty();
    private Optional<RetryConfig> retryConfig = Optional.empty();
    private final SDKConfiguration sdkConfiguration;

    public UpdateJWTTemplateRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }

    public UpdateJWTTemplateRequestBuilder templateId(String templateId) {
        Utils.checkNotNull(templateId, "templateId");
        this.templateId = templateId;
        return this;
    }
                
    public UpdateJWTTemplateRequestBuilder requestBody(UpdateJWTTemplateRequestBody requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = Optional.of(requestBody);
        return this;
    }

    public UpdateJWTTemplateRequestBuilder requestBody(Optional<? extends UpdateJWTTemplateRequestBody> requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = requestBody;
        return this;
    }
                
    public UpdateJWTTemplateRequestBuilder retryConfig(RetryConfig retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = Optional.of(retryConfig);
        return this;
    }

    public UpdateJWTTemplateRequestBuilder retryConfig(Optional<RetryConfig> retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = retryConfig;
        return this;
    }


    private UpdateJWTTemplateRequest buildRequest() {

        UpdateJWTTemplateRequest request = new UpdateJWTTemplateRequest(templateId,
            requestBody);

        return request;
    }

    public UpdateJWTTemplateResponse call() throws Exception {
        Optional<Options> options = Optional.of(Options.builder()
            .retryConfig(retryConfig)
            .build());

        RequestOperation<UpdateJWTTemplateRequest, UpdateJWTTemplateResponse> operation
              = new UpdateJWTTemplateOperation(
                sdkConfiguration,
                options);
        UpdateJWTTemplateRequest request = buildRequest();

        return operation.handleResponse(operation.doRequest(request));
    }
}
