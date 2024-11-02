/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.utils.Utils;
import java.util.Optional;

public class ChangeProductionInstanceDomainRequestBuilder {

    private Optional<? extends ChangeProductionInstanceDomainRequestBody> request = Optional.empty();
    private final SDKMethodInterfaces.MethodCallChangeProductionInstanceDomain sdk;

    public ChangeProductionInstanceDomainRequestBuilder(SDKMethodInterfaces.MethodCallChangeProductionInstanceDomain sdk) {
        this.sdk = sdk;
    }
                
    public ChangeProductionInstanceDomainRequestBuilder request(com.clerk.backend_api.models.operations.ChangeProductionInstanceDomainRequestBody request) {
        Utils.checkNotNull(request, "request");
        this.request = Optional.of(request);
        return this;
    }

    public ChangeProductionInstanceDomainRequestBuilder request(java.util.Optional<? extends com.clerk.backend_api.models.operations.ChangeProductionInstanceDomainRequestBody> request) {
        Utils.checkNotNull(request, "request");
        this.request = request;
        return this;
    }

    public ChangeProductionInstanceDomainResponse call() throws Exception {

        return sdk.changeProductionInstanceDomain(
            request);
    }
}
