/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.utils.Utils;

public class CreateOAuthApplicationRequestBuilder {

    private CreateOAuthApplicationRequestBody request;
    private final SDKMethodInterfaces.MethodCallCreateOAuthApplication sdk;

    public CreateOAuthApplicationRequestBuilder(SDKMethodInterfaces.MethodCallCreateOAuthApplication sdk) {
        this.sdk = sdk;
    }

    public CreateOAuthApplicationRequestBuilder request(CreateOAuthApplicationRequestBody request) {
        Utils.checkNotNull(request, "request");
        this.request = request;
        return this;
    }

    public CreateOAuthApplicationResponse call() throws Exception {

        return sdk.create(
            request);
    }
}
