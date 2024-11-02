/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.utils.Utils;
import java.lang.Boolean;
import java.lang.String;
import java.util.Optional;

public class GetOrganizationRequestBuilder {

    private String organizationId;
    private Optional<Boolean> includeMembersCount = Optional.empty();
    private final SDKMethodInterfaces.MethodCallGetOrganization sdk;

    public GetOrganizationRequestBuilder(SDKMethodInterfaces.MethodCallGetOrganization sdk) {
        this.sdk = sdk;
    }

    public GetOrganizationRequestBuilder organizationId(java.lang.String organizationId) {
        Utils.checkNotNull(organizationId, "organizationId");
        this.organizationId = organizationId;
        return this;
    }
                
    public GetOrganizationRequestBuilder includeMembersCount(boolean includeMembersCount) {
        Utils.checkNotNull(includeMembersCount, "includeMembersCount");
        this.includeMembersCount = Optional.of(includeMembersCount);
        return this;
    }

    public GetOrganizationRequestBuilder includeMembersCount(java.util.Optional<java.lang.Boolean> includeMembersCount) {
        Utils.checkNotNull(includeMembersCount, "includeMembersCount");
        this.includeMembersCount = includeMembersCount;
        return this;
    }

    public GetOrganizationResponse call() throws Exception {

        return sdk.get(
            organizationId,
            includeMembersCount);
    }
}
