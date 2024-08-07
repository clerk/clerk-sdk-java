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


public class RevokeSessionRequestBuilder {

    private String sessionId;
    private final SDKMethodInterfaces.MethodCallRevokeSession sdk;

    public RevokeSessionRequestBuilder(SDKMethodInterfaces.MethodCallRevokeSession sdk) {
        this.sdk = sdk;
    }

    public RevokeSessionRequestBuilder sessionId(String sessionId) {
        Utils.checkNotNull(sessionId, "sessionId");
        this.sessionId = sessionId;
        return this;
    }

    public RevokeSessionResponse call() throws Exception {

        return sdk.revoke(
            sessionId);
    }
}
