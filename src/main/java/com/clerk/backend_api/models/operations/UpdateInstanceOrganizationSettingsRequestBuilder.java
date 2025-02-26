/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.utils.Utils;
import java.util.Optional;

public class UpdateInstanceOrganizationSettingsRequestBuilder {

    private Optional<? extends UpdateInstanceOrganizationSettingsRequestBody> request = Optional.empty();
    private final SDKMethodInterfaces.MethodCallUpdateInstanceOrganizationSettings sdk;

    public UpdateInstanceOrganizationSettingsRequestBuilder(SDKMethodInterfaces.MethodCallUpdateInstanceOrganizationSettings sdk) {
        this.sdk = sdk;
    }
                
    public UpdateInstanceOrganizationSettingsRequestBuilder request(UpdateInstanceOrganizationSettingsRequestBody request) {
        Utils.checkNotNull(request, "request");
        this.request = Optional.of(request);
        return this;
    }

    public UpdateInstanceOrganizationSettingsRequestBuilder request(Optional<? extends UpdateInstanceOrganizationSettingsRequestBody> request) {
        Utils.checkNotNull(request, "request");
        this.request = request;
        return this;
    }

    public UpdateInstanceOrganizationSettingsResponse call() throws Exception {

        return sdk.updateOrganizationSettings(
            request);
    }
}
