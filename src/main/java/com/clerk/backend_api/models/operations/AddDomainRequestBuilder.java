/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.utils.Utils;
import java.util.Optional;

public class AddDomainRequestBuilder {

    private Optional<? extends AddDomainRequestBody> request = Optional.empty();
    private final SDKMethodInterfaces.MethodCallAddDomain sdk;

    public AddDomainRequestBuilder(SDKMethodInterfaces.MethodCallAddDomain sdk) {
        this.sdk = sdk;
    }
                
    public AddDomainRequestBuilder request(com.clerk.backend_api.models.operations.AddDomainRequestBody request) {
        Utils.checkNotNull(request, "request");
        this.request = Optional.of(request);
        return this;
    }

    public AddDomainRequestBuilder request(java.util.Optional<? extends com.clerk.backend_api.models.operations.AddDomainRequestBody> request) {
        Utils.checkNotNull(request, "request");
        this.request = request;
        return this;
    }

    public AddDomainResponse call() throws Exception {

        return sdk.add(
            request);
    }
}
