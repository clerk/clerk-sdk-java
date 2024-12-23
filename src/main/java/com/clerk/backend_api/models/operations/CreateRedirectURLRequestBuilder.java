/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.utils.Utils;

public class CreateRedirectURLRequestBuilder {

    private CreateRedirectURLRequestBody request;
    private final SDKMethodInterfaces.MethodCallCreateRedirectURL sdk;

    public CreateRedirectURLRequestBuilder(SDKMethodInterfaces.MethodCallCreateRedirectURL sdk) {
        this.sdk = sdk;
    }

    public CreateRedirectURLRequestBuilder request(CreateRedirectURLRequestBody request) {
        Utils.checkNotNull(request, "request");
        this.request = request;
        return this;
    }

    public CreateRedirectURLResponse call() throws Exception {

        return sdk.create(
            request);
    }
}
