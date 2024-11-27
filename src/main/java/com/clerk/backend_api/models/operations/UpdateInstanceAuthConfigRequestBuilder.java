/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.utils.Utils;

public class UpdateInstanceAuthConfigRequestBuilder {

    private UpdateInstanceAuthConfigRequestBody request;
    private final SDKMethodInterfaces.MethodCallUpdateInstanceAuthConfig sdk;

    public UpdateInstanceAuthConfigRequestBuilder(SDKMethodInterfaces.MethodCallUpdateInstanceAuthConfig sdk) {
        this.sdk = sdk;
    }

    public UpdateInstanceAuthConfigRequestBuilder request(UpdateInstanceAuthConfigRequestBody request) {
        Utils.checkNotNull(request, "request");
        this.request = request;
        return this;
    }

    public UpdateInstanceAuthConfigResponse call() throws Exception {

        return sdk.updateInstanceSettings(
            request);
    }
}
