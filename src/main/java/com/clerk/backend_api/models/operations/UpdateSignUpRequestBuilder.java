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


public class UpdateSignUpRequestBuilder {

    private String id;
    private Optional<? extends UpdateSignUpRequestBody> requestBody = Optional.empty();
    private final SDKMethodInterfaces.MethodCallUpdateSignUp sdk;

    public UpdateSignUpRequestBuilder(SDKMethodInterfaces.MethodCallUpdateSignUp sdk) {
        this.sdk = sdk;
    }

    public UpdateSignUpRequestBuilder id(String id) {
        Utils.checkNotNull(id, "id");
        this.id = id;
        return this;
    }
                
    public UpdateSignUpRequestBuilder requestBody(UpdateSignUpRequestBody requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = Optional.of(requestBody);
        return this;
    }

    public UpdateSignUpRequestBuilder requestBody(Optional<? extends UpdateSignUpRequestBody> requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = requestBody;
        return this;
    }

    public UpdateSignUpResponse call() throws Exception {

        return sdk.update(
            id,
            requestBody);
    }
}
