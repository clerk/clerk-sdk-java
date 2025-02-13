/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.utils.Utils;
import java.lang.String;

public class UserPasskeyDeleteRequestBuilder {

    private String userId;
    private String passkeyIdentificationId;
    private final SDKMethodInterfaces.MethodCallUserPasskeyDelete sdk;

    public UserPasskeyDeleteRequestBuilder(SDKMethodInterfaces.MethodCallUserPasskeyDelete sdk) {
        this.sdk = sdk;
    }

    public UserPasskeyDeleteRequestBuilder userId(String userId) {
        Utils.checkNotNull(userId, "userId");
        this.userId = userId;
        return this;
    }

    public UserPasskeyDeleteRequestBuilder passkeyIdentificationId(String passkeyIdentificationId) {
        Utils.checkNotNull(passkeyIdentificationId, "passkeyIdentificationId");
        this.passkeyIdentificationId = passkeyIdentificationId;
        return this;
    }

    public UserPasskeyDeleteResponse call() throws Exception {

        return sdk.deletePasskey(
            userId,
            passkeyIdentificationId);
    }
}
