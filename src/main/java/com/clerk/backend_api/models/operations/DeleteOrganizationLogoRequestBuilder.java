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

public class DeleteOrganizationLogoRequestBuilder {

    private String organizationId;
    private Optional<RetryConfig> retryConfig = Optional.empty();
    private final SDKMethodInterfaces.MethodCallDeleteOrganizationLogo sdk;

    public DeleteOrganizationLogoRequestBuilder(SDKMethodInterfaces.MethodCallDeleteOrganizationLogo sdk) {
        this.sdk = sdk;
    }

    public DeleteOrganizationLogoRequestBuilder organizationId(String organizationId) {
        Utils.checkNotNull(organizationId, "organizationId");
        this.organizationId = organizationId;
        return this;
    }
                
    public DeleteOrganizationLogoRequestBuilder retryConfig(RetryConfig retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = Optional.of(retryConfig);
        return this;
    }

    public DeleteOrganizationLogoRequestBuilder retryConfig(Optional<RetryConfig> retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = retryConfig;
        return this;
    }

    public DeleteOrganizationLogoResponse call() throws Exception {
        Optional<Options> options = Optional.of(Options.builder()
                                                    .retryConfig(retryConfig)
                                                    .build());
        return sdk.deleteLogo(
            organizationId,
            options);
    }
}
