/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.operations;

import static com.clerk.backend_api.operations.Operations.RequestOperation;

import com.clerk.backend_api.SDKConfiguration;
import com.clerk.backend_api.operations.ToggleTemplateDeliveryOperation;
import com.clerk.backend_api.utils.Options;
import com.clerk.backend_api.utils.RetryConfig;
import com.clerk.backend_api.utils.Utils;
import java.lang.Exception;
import java.lang.String;
import java.util.Optional;

public class ToggleTemplateDeliveryRequestBuilder {

    private ToggleTemplateDeliveryPathParamTemplateType templateType;
    private String slug;
    private Optional<? extends ToggleTemplateDeliveryRequestBody> requestBody = Optional.empty();
    private Optional<RetryConfig> retryConfig = Optional.empty();
    private final SDKConfiguration sdkConfiguration;

    public ToggleTemplateDeliveryRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }

    public ToggleTemplateDeliveryRequestBuilder templateType(ToggleTemplateDeliveryPathParamTemplateType templateType) {
        Utils.checkNotNull(templateType, "templateType");
        this.templateType = templateType;
        return this;
    }

    public ToggleTemplateDeliveryRequestBuilder slug(String slug) {
        Utils.checkNotNull(slug, "slug");
        this.slug = slug;
        return this;
    }
                
    public ToggleTemplateDeliveryRequestBuilder requestBody(ToggleTemplateDeliveryRequestBody requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = Optional.of(requestBody);
        return this;
    }

    public ToggleTemplateDeliveryRequestBuilder requestBody(Optional<? extends ToggleTemplateDeliveryRequestBody> requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = requestBody;
        return this;
    }
                
    public ToggleTemplateDeliveryRequestBuilder retryConfig(RetryConfig retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = Optional.of(retryConfig);
        return this;
    }

    public ToggleTemplateDeliveryRequestBuilder retryConfig(Optional<RetryConfig> retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = retryConfig;
        return this;
    }


    private ToggleTemplateDeliveryRequest buildRequest() {

        ToggleTemplateDeliveryRequest request = new ToggleTemplateDeliveryRequest(templateType,
            slug,
            requestBody);

        return request;
    }

    public ToggleTemplateDeliveryResponse call() throws Exception {
        Optional<Options> options = Optional.of(Options.builder()
            .retryConfig(retryConfig)
            .build());

        RequestOperation<ToggleTemplateDeliveryRequest, ToggleTemplateDeliveryResponse> operation
              = new ToggleTemplateDeliveryOperation(
                sdkConfiguration,
                options);
        ToggleTemplateDeliveryRequest request = buildRequest();

        return operation.handleResponse(operation.doRequest(request));
    }
}
