/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.utils.Utils;
import java.lang.String;

public class GetJWTTemplateRequestBuilder {

    private String templateId;
    private final SDKMethodInterfaces.MethodCallGetJWTTemplate sdk;

    public GetJWTTemplateRequestBuilder(SDKMethodInterfaces.MethodCallGetJWTTemplate sdk) {
        this.sdk = sdk;
    }

    public GetJWTTemplateRequestBuilder templateId(String templateId) {
        Utils.checkNotNull(templateId, "templateId");
        this.templateId = templateId;
        return this;
    }

    public GetJWTTemplateResponse call() throws Exception {

        return sdk.get(
            templateId);
    }
}
