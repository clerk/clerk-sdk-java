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


public class DeleteAllowlistIdentifierRequestBuilder {

    private String identifierId;
    private final SDKMethodInterfaces.MethodCallDeleteAllowlistIdentifier sdk;

    public DeleteAllowlistIdentifierRequestBuilder(SDKMethodInterfaces.MethodCallDeleteAllowlistIdentifier sdk) {
        this.sdk = sdk;
    }

    public DeleteAllowlistIdentifierRequestBuilder identifierId(String identifierId) {
        Utils.checkNotNull(identifierId, "identifierId");
        this.identifierId = identifierId;
        return this;
    }

    public DeleteAllowlistIdentifierResponse call() throws Exception {

        return sdk.delete(
            identifierId);
    }
}
