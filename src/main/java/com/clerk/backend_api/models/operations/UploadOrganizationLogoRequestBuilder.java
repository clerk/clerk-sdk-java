/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.utils.Utils;
import java.lang.String;
import java.util.Optional;

public class UploadOrganizationLogoRequestBuilder {

    private String organizationId;
    private Optional<? extends UploadOrganizationLogoRequestBody> requestBody = Optional.empty();
    private final SDKMethodInterfaces.MethodCallUploadOrganizationLogo sdk;

    public UploadOrganizationLogoRequestBuilder(SDKMethodInterfaces.MethodCallUploadOrganizationLogo sdk) {
        this.sdk = sdk;
    }

    public UploadOrganizationLogoRequestBuilder organizationId(java.lang.String organizationId) {
        Utils.checkNotNull(organizationId, "organizationId");
        this.organizationId = organizationId;
        return this;
    }
                
    public UploadOrganizationLogoRequestBuilder requestBody(com.clerk.backend_api.models.operations.UploadOrganizationLogoRequestBody requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = Optional.of(requestBody);
        return this;
    }

    public UploadOrganizationLogoRequestBuilder requestBody(java.util.Optional<? extends com.clerk.backend_api.models.operations.UploadOrganizationLogoRequestBody> requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = requestBody;
        return this;
    }

    public UploadOrganizationLogoResponse call() throws Exception {

        return sdk.uploadLogo(
            organizationId,
            requestBody);
    }
}
