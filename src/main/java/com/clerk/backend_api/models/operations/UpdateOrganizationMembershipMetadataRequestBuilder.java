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

public class UpdateOrganizationMembershipMetadataRequestBuilder {

    private String organizationId;
    private String userId;
    private Optional<? extends UpdateOrganizationMembershipMetadataRequestBody> requestBody = Optional.empty();
    private Optional<RetryConfig> retryConfig = Optional.empty();
    private final SDKMethodInterfaces.MethodCallUpdateOrganizationMembershipMetadata sdk;

    public UpdateOrganizationMembershipMetadataRequestBuilder(SDKMethodInterfaces.MethodCallUpdateOrganizationMembershipMetadata sdk) {
        this.sdk = sdk;
    }

    public UpdateOrganizationMembershipMetadataRequestBuilder organizationId(String organizationId) {
        Utils.checkNotNull(organizationId, "organizationId");
        this.organizationId = organizationId;
        return this;
    }

    public UpdateOrganizationMembershipMetadataRequestBuilder userId(String userId) {
        Utils.checkNotNull(userId, "userId");
        this.userId = userId;
        return this;
    }
                
    public UpdateOrganizationMembershipMetadataRequestBuilder requestBody(UpdateOrganizationMembershipMetadataRequestBody requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = Optional.of(requestBody);
        return this;
    }

    public UpdateOrganizationMembershipMetadataRequestBuilder requestBody(Optional<? extends UpdateOrganizationMembershipMetadataRequestBody> requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = requestBody;
        return this;
    }
                
    public UpdateOrganizationMembershipMetadataRequestBuilder retryConfig(RetryConfig retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = Optional.of(retryConfig);
        return this;
    }

    public UpdateOrganizationMembershipMetadataRequestBuilder retryConfig(Optional<RetryConfig> retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = retryConfig;
        return this;
    }

    public UpdateOrganizationMembershipMetadataResponse call() throws Exception {
        Optional<Options> options = Optional.of(Options.builder()
                                                    .retryConfig(retryConfig)
                                                    .build());
        return sdk.updateMetadata(
            organizationId,
            userId,
            requestBody,
            options);
    }
}
