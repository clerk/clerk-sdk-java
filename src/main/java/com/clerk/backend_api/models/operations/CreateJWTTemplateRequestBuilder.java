/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.utils.Utils;

public class CreateJWTTemplateRequestBuilder {

    private CreateJWTTemplateRequestBody request;
    private final SDKMethodInterfaces.MethodCallCreateJWTTemplate sdk;

    public CreateJWTTemplateRequestBuilder(SDKMethodInterfaces.MethodCallCreateJWTTemplate sdk) {
        this.sdk = sdk;
    }

    public CreateJWTTemplateRequestBuilder request(CreateJWTTemplateRequestBody request) {
        Utils.checkNotNull(request, "request");
        this.request = request;
        return this;
    }

    public CreateJWTTemplateResponse call() throws Exception {

        return sdk.create(
            request);
    }
}
