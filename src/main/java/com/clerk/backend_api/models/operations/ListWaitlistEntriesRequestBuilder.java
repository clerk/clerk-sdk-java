/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.utils.Utils;

public class ListWaitlistEntriesRequestBuilder {

    private ListWaitlistEntriesRequest request;
    private final SDKMethodInterfaces.MethodCallListWaitlistEntries sdk;

    public ListWaitlistEntriesRequestBuilder(SDKMethodInterfaces.MethodCallListWaitlistEntries sdk) {
        this.sdk = sdk;
    }

    public ListWaitlistEntriesRequestBuilder request(ListWaitlistEntriesRequest request) {
        Utils.checkNotNull(request, "request");
        this.request = request;
        return this;
    }

    public ListWaitlistEntriesResponse call() throws Exception {

        return sdk.listWaitlistEntries(
            request);
    }
}
