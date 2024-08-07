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


public class UpdatePhoneNumberRequestBuilder {

    private String phoneNumberId;
    private Optional<? extends UpdatePhoneNumberRequestBody> requestBody = Optional.empty();
    private final SDKMethodInterfaces.MethodCallUpdatePhoneNumber sdk;

    public UpdatePhoneNumberRequestBuilder(SDKMethodInterfaces.MethodCallUpdatePhoneNumber sdk) {
        this.sdk = sdk;
    }

    public UpdatePhoneNumberRequestBuilder phoneNumberId(String phoneNumberId) {
        Utils.checkNotNull(phoneNumberId, "phoneNumberId");
        this.phoneNumberId = phoneNumberId;
        return this;
    }
                
    public UpdatePhoneNumberRequestBuilder requestBody(UpdatePhoneNumberRequestBody requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = Optional.of(requestBody);
        return this;
    }

    public UpdatePhoneNumberRequestBuilder requestBody(Optional<? extends UpdatePhoneNumberRequestBody> requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = requestBody;
        return this;
    }

    public UpdatePhoneNumberResponse call() throws Exception {

        return sdk.update(
            phoneNumberId,
            requestBody);
    }
}
