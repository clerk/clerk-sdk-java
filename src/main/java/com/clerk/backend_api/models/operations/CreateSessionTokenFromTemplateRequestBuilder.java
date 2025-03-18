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

public class CreateSessionTokenFromTemplateRequestBuilder {

    private String sessionId;
    private String templateName;
    private Optional<? extends CreateSessionTokenFromTemplateRequestBody> requestBody = Optional.empty();
    private Optional<RetryConfig> retryConfig = Optional.empty();
    private final SDKMethodInterfaces.MethodCallCreateSessionTokenFromTemplate sdk;

    public CreateSessionTokenFromTemplateRequestBuilder(SDKMethodInterfaces.MethodCallCreateSessionTokenFromTemplate sdk) {
        this.sdk = sdk;
    }

    public CreateSessionTokenFromTemplateRequestBuilder sessionId(String sessionId) {
        Utils.checkNotNull(sessionId, "sessionId");
        this.sessionId = sessionId;
        return this;
    }

    public CreateSessionTokenFromTemplateRequestBuilder templateName(String templateName) {
        Utils.checkNotNull(templateName, "templateName");
        this.templateName = templateName;
        return this;
    }
                
    public CreateSessionTokenFromTemplateRequestBuilder requestBody(CreateSessionTokenFromTemplateRequestBody requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = Optional.of(requestBody);
        return this;
    }

    public CreateSessionTokenFromTemplateRequestBuilder requestBody(Optional<? extends CreateSessionTokenFromTemplateRequestBody> requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = requestBody;
        return this;
    }
                
    public CreateSessionTokenFromTemplateRequestBuilder retryConfig(RetryConfig retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = Optional.of(retryConfig);
        return this;
    }

    public CreateSessionTokenFromTemplateRequestBuilder retryConfig(Optional<RetryConfig> retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = retryConfig;
        return this;
    }

    public CreateSessionTokenFromTemplateResponse call() throws Exception {
        Optional<Options> options = Optional.of(Options.builder()
                                                    .retryConfig(retryConfig)
                                                    .build());
        return sdk.createTokenFromTemplate(
            sessionId,
            templateName,
            requestBody,
            options);
    }
}
