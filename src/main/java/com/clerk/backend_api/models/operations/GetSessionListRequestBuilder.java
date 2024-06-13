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


public class GetSessionListRequestBuilder {

    private GetSessionListRequest request;
    private final SDKMethodInterfaces.MethodCallGetSessionList sdk;

    public GetSessionListRequestBuilder(SDKMethodInterfaces.MethodCallGetSessionList sdk) {
        this.sdk = sdk;
    }

    public GetSessionListRequestBuilder request(GetSessionListRequest request) {
        Utils.checkNotNull(request, "request");
        this.request = request;
        return this;
    }

    public GetSessionListResponse call() throws Exception {

        return sdk.list(
            request);
    }
    
    /**
     * Returns a stream that performs next page calls till no more pages
     * are returned. Unlike the {@link #call()} method this method will
     * throw an {@link SDKError} if any page retrieval has an HTTP status 
     * code >= 300 (Note that 3XX is not an error range but will need 
     * special handling by the user if for example the HTTP client is 
     * not configured to follow redirects).
     * 
     * @throws {@link SDKError} if HTTP status code >= 300 is encountered
     **/  
    public Stream<GetSessionListResponse> callAsStream() {
        return Utils.stream(() -> Optional.of(call()), x -> {
            if (x.statusCode() >= 300) {
                byte[] body = Utils.toByteArrayAndClose(x.rawResponse().body());
                throw new SDKError(x.rawResponse(), x.statusCode(), x.contentType(), body);
            } else {
                return x.next();
            }
        });
    }
}