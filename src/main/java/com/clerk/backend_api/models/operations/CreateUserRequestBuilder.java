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


public class CreateUserRequestBuilder {

    private CreateUserRequestBody request;
    private final SDKMethodInterfaces.MethodCallCreateUser sdk;

    public CreateUserRequestBuilder(SDKMethodInterfaces.MethodCallCreateUser sdk) {
        this.sdk = sdk;
    }

    public CreateUserRequestBuilder request(CreateUserRequestBody request) {
        Utils.checkNotNull(request, "request");
        this.request = request;
        return this;
    }

    public CreateUserResponse call() throws Exception {

        return sdk.create(
            request);
    }
}
