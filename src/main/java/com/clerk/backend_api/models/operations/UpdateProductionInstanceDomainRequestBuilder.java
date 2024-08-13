/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.utils.Utils;
import java.util.Optional;

public class UpdateProductionInstanceDomainRequestBuilder {

    private Optional<? extends UpdateProductionInstanceDomainRequestBody> request = Optional.empty();
    private final SDKMethodInterfaces.MethodCallUpdateProductionInstanceDomain sdk;

    public UpdateProductionInstanceDomainRequestBuilder(SDKMethodInterfaces.MethodCallUpdateProductionInstanceDomain sdk) {
        this.sdk = sdk;
    }
                
    public UpdateProductionInstanceDomainRequestBuilder request(com.clerk.backend_api.models.operations.UpdateProductionInstanceDomainRequestBody request) {
        Utils.checkNotNull(request, "request");
        this.request = Optional.of(request);
        return this;
    }

    public UpdateProductionInstanceDomainRequestBuilder request(java.util.Optional<? extends com.clerk.backend_api.models.operations.UpdateProductionInstanceDomainRequestBody> request) {
        Utils.checkNotNull(request, "request");
        this.request = request;
        return this;
    }

    public UpdateProductionInstanceDomainResponse call() throws Exception {

        return sdk.updateProductionDomain(
            request);
    }
}
