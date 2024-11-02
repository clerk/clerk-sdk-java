/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.utils.Utils;

public class ListOrganizationDomainsRequestBuilder {

    private ListOrganizationDomainsRequest request;
    private final SDKMethodInterfaces.MethodCallListOrganizationDomains sdk;

    public ListOrganizationDomainsRequestBuilder(SDKMethodInterfaces.MethodCallListOrganizationDomains sdk) {
        this.sdk = sdk;
    }

    public ListOrganizationDomainsRequestBuilder request(com.clerk.backend_api.models.operations.ListOrganizationDomainsRequest request) {
        Utils.checkNotNull(request, "request");
        this.request = request;
        return this;
    }

    public ListOrganizationDomainsResponse call() throws Exception {

        return sdk.list(
            request);
    }
}
