/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.utils.LazySingletonValue;
import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.core.type.TypeReference;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.stream.Stream;
import org.openapitools.jackson.nullable.JsonNullable;


public class RevokeInvitationRequestBuilder {

    private String invitationId;
    private final SDKMethodInterfaces.MethodCallRevokeInvitation sdk;

    public RevokeInvitationRequestBuilder(SDKMethodInterfaces.MethodCallRevokeInvitation sdk) {
        this.sdk = sdk;
    }

    public RevokeInvitationRequestBuilder invitationId(String invitationId) {
        Utils.checkNotNull(invitationId, "invitationId");
        this.invitationId = invitationId;
        return this;
    }

    public RevokeInvitationResponse call() throws Exception {

        return sdk.revoke(
            invitationId);
    }
}
