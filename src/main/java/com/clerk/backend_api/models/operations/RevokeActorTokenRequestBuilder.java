/* 
 * Code generated by Speakeasy (https://speakeasyapi.dev). DO NOT EDIT.
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


public class RevokeActorTokenRequestBuilder {

    private String actorTokenId;
    private final SDKMethodInterfaces.MethodCallRevokeActorToken sdk;

    public RevokeActorTokenRequestBuilder(SDKMethodInterfaces.MethodCallRevokeActorToken sdk) {
        this.sdk = sdk;
    }

    public RevokeActorTokenRequestBuilder actorTokenId(String actorTokenId) {
        Utils.checkNotNull(actorTokenId, "actorTokenId");
        this.actorTokenId = actorTokenId;
        return this;
    }

    public RevokeActorTokenResponse call() throws Exception {

        return sdk.revokeToken(
            actorTokenId);
    }
}