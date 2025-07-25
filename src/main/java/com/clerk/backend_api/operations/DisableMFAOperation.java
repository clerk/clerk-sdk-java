/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.operations;

import static com.clerk.backend_api.operations.Operations.RequestOperation;

import com.clerk.backend_api.SDKConfiguration;
import com.clerk.backend_api.SecuritySource;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.DisableMFARequest;
import com.clerk.backend_api.models.operations.DisableMFAResponse;
import com.clerk.backend_api.models.operations.DisableMFAResponseBody;
import com.clerk.backend_api.utils.BackoffStrategy;
import com.clerk.backend_api.utils.HTTPClient;
import com.clerk.backend_api.utils.HTTPRequest;
import com.clerk.backend_api.utils.Hook.AfterErrorContextImpl;
import com.clerk.backend_api.utils.Hook.AfterSuccessContextImpl;
import com.clerk.backend_api.utils.Hook.BeforeRequestContextImpl;
import com.clerk.backend_api.utils.Options;
import com.clerk.backend_api.utils.Retries.NonRetryableException;
import com.clerk.backend_api.utils.Retries;
import com.clerk.backend_api.utils.RetryConfig;
import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.InputStream;
import java.lang.Exception;
import java.lang.String;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;


public class DisableMFAOperation implements RequestOperation<DisableMFARequest, DisableMFAResponse> {
    
    private final SDKConfiguration sdkConfiguration;
    private final Optional<Options> options;

    public DisableMFAOperation(
            SDKConfiguration sdkConfiguration,
            Optional<Options> options) {
        this.sdkConfiguration = sdkConfiguration;
        this.options = options;
    }
    
    @Override
    public HttpResponse<InputStream> doRequest(DisableMFARequest request) throws Exception {
        options
                .ifPresent(o -> o.validate(List.of(Options.Option.RETRY_CONFIG)));
        String baseUrl = this.sdkConfiguration.serverUrl();
        String url = Utils.generateURL(
                DisableMFARequest.class,
                baseUrl,
                "/users/{user_id}/mfa",
                request, null);
        
        HTTPRequest req = new HTTPRequest(url, "DELETE");
        req.addHeader("Accept", "application/json")
            .addHeader("user-agent", 
                SDKConfiguration.USER_AGENT);
        
        Optional<SecuritySource> hookSecuritySource = Optional.of(this.sdkConfiguration.securitySource());
        Utils.configureSecurity(req,  
                this.sdkConfiguration.securitySource().getSecurity());
        HTTPClient client = this.sdkConfiguration.client();
        HTTPRequest finalReq = req;
        RetryConfig retryConfig = options
                .flatMap(Options::retryConfig)
                .or(this.sdkConfiguration::retryConfig)
                .orElse(RetryConfig.builder()
                        .backoff(BackoffStrategy.builder()
                            .initialInterval(500, TimeUnit.MILLISECONDS)
                            .maxInterval(60000, TimeUnit.MILLISECONDS)
                            .baseFactor((double)(1.5))
                            .maxElapsedTime(3600000, TimeUnit.MILLISECONDS)
                            .retryConnectError(true)
                            .build())
                        .build());
        List<String> statusCodes = new ArrayList<>();
        statusCodes.add("5XX");
        Retries retries = Retries.builder()
            .action(() -> {
                HttpRequest r = null;
                try {
                    r = sdkConfiguration.hooks()
                        .beforeRequest(
                            new BeforeRequestContextImpl(
                                this.sdkConfiguration,
                                baseUrl,
                                "DisableMFA", 
                                java.util.Optional.of(java.util.List.of()), 
                                hookSecuritySource),
                            finalReq.build());
                } catch (Exception e) {
                    throw new NonRetryableException(e);
                }
                try {
                    return client.send(r);
                } catch (Exception e) {
                    return sdkConfiguration.hooks()
                        .afterError(
                            new AfterErrorContextImpl(
                                this.sdkConfiguration,
                                baseUrl,
                                "DisableMFA",
                                 java.util.Optional.of(java.util.List.of()),
                                 hookSecuritySource), 
                            Optional.empty(),
                            Optional.of(e));
                }
            })
            .retryConfig(retryConfig)
            .statusCodes(statusCodes)
            .build();
        HttpResponse<InputStream> httpRes = sdkConfiguration.hooks()
                 .afterSuccess(
                     new AfterSuccessContextImpl(
                         this.sdkConfiguration,
                          baseUrl,
                         "DisableMFA", 
                         java.util.Optional.of(java.util.List.of()), 
                         hookSecuritySource),
                     retries.run());
    
        return httpRes;
    }

    @Override
    public DisableMFAResponse handleResponse(HttpResponse<InputStream> response) throws Exception {
        String contentType = response
            .headers()
            .firstValue("Content-Type")
            .orElse("application/octet-stream");
        DisableMFAResponse.Builder resBuilder = 
            DisableMFAResponse
                .builder()
                .contentType(contentType)
                .statusCode(response.statusCode())
                .rawResponse(response);

        DisableMFAResponse res = resBuilder.build();
        
        if (Utils.statusCodeMatches(response.statusCode(), "200")) {
            if (Utils.contentTypeMatches(contentType, "application/json")) {
                DisableMFAResponseBody out = Utils.mapper().readValue(
                    response.body(),
                    new TypeReference<>() {
                    });
                res.withObject(out);
                return res;
            } else {
                throw new SDKError(
                    response, 
                    response.statusCode(), 
                    "Unexpected content-type received: " + contentType, 
                    Utils.extractByteArrayFromBody(response));
            }
        }
        if (Utils.statusCodeMatches(response.statusCode(), "404")) {
            if (Utils.contentTypeMatches(contentType, "application/json")) {
                ClerkErrors out = Utils.mapper().readValue(
                    response.body(),
                    new TypeReference<>() {
                    });
                throw out;
            } else {
                throw new SDKError(
                    response, 
                    response.statusCode(), 
                    "Unexpected content-type received: " + contentType, 
                    Utils.extractByteArrayFromBody(response));
            }
        }
        if (Utils.statusCodeMatches(response.statusCode(), "500")) {
            if (Utils.contentTypeMatches(contentType, "application/json")) {
                ClerkErrors out = Utils.mapper().readValue(
                    response.body(),
                    new TypeReference<>() {
                    });
                throw out;
            } else {
                throw new SDKError(
                    response, 
                    response.statusCode(), 
                    "Unexpected content-type received: " + contentType, 
                    Utils.extractByteArrayFromBody(response));
            }
        }
        if (Utils.statusCodeMatches(response.statusCode(), "4XX")) {
            // no content 
            throw new SDKError(
                    response, 
                    response.statusCode(), 
                    "API error occurred", 
                    Utils.extractByteArrayFromBody(response));
        }
        if (Utils.statusCodeMatches(response.statusCode(), "5XX")) {
            // no content 
            throw new SDKError(
                    response, 
                    response.statusCode(), 
                    "API error occurred", 
                    Utils.extractByteArrayFromBody(response));
        }
        throw new SDKError(
            response, 
            response.statusCode(), 
            "Unexpected status code received: " + response.statusCode(), 
            Utils.extractByteArrayFromBody(response));
    }
}
