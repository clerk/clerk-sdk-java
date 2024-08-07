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


public class AddDomainRequestBuilder {

    private Optional<? extends AddDomainRequestBody> request = Optional.empty();
    private final SDKMethodInterfaces.MethodCallAddDomain sdk;

    public AddDomainRequestBuilder(SDKMethodInterfaces.MethodCallAddDomain sdk) {
        this.sdk = sdk;
    }
                
    public AddDomainRequestBuilder request(AddDomainRequestBody request) {
        Utils.checkNotNull(request, "request");
        this.request = Optional.of(request);
        return this;
    }

    public AddDomainRequestBuilder request(Optional<? extends AddDomainRequestBody> request) {
        Utils.checkNotNull(request, "request");
        this.request = request;
        return this;
    }

    public AddDomainResponse call() throws Exception {

        return sdk.add(
            request);
    }
}
