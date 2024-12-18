/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.utils.Utils;
import java.lang.String;

public class DeleteOrganizationMembershipRequestBuilder {

    private String organizationId;
    private String userId;
    private final SDKMethodInterfaces.MethodCallDeleteOrganizationMembership sdk;

    public DeleteOrganizationMembershipRequestBuilder(SDKMethodInterfaces.MethodCallDeleteOrganizationMembership sdk) {
        this.sdk = sdk;
    }

    public DeleteOrganizationMembershipRequestBuilder organizationId(String organizationId) {
        Utils.checkNotNull(organizationId, "organizationId");
        this.organizationId = organizationId;
        return this;
    }

    public DeleteOrganizationMembershipRequestBuilder userId(String userId) {
        Utils.checkNotNull(userId, "userId");
        this.userId = userId;
        return this;
    }

    public DeleteOrganizationMembershipResponse call() throws Exception {

        return sdk.delete(
            organizationId,
            userId);
    }
}
