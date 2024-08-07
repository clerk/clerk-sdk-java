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


public class UploadOrganizationLogoRequestBuilder {

    private String organizationId;
    private Optional<? extends UploadOrganizationLogoRequestBody> requestBody = Optional.empty();
    private final SDKMethodInterfaces.MethodCallUploadOrganizationLogo sdk;

    public UploadOrganizationLogoRequestBuilder(SDKMethodInterfaces.MethodCallUploadOrganizationLogo sdk) {
        this.sdk = sdk;
    }

    public UploadOrganizationLogoRequestBuilder organizationId(String organizationId) {
        Utils.checkNotNull(organizationId, "organizationId");
        this.organizationId = organizationId;
        return this;
    }
                
    public UploadOrganizationLogoRequestBuilder requestBody(UploadOrganizationLogoRequestBody requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = Optional.of(requestBody);
        return this;
    }

    public UploadOrganizationLogoRequestBuilder requestBody(Optional<? extends UploadOrganizationLogoRequestBody> requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = requestBody;
        return this;
    }

    public UploadOrganizationLogoResponse call() throws Exception {

        return sdk.uploadLogo(
            organizationId,
            requestBody);
    }
}
