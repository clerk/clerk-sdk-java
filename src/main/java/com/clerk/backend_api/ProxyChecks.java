/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api;

import com.clerk.backend_api.models.components.ProxyCheck;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.SDKMethodInterfaces.*;
import com.clerk.backend_api.models.operations.VerifyDomainProxyRequestBody;
import com.clerk.backend_api.models.operations.VerifyDomainProxyRequestBuilder;
import com.clerk.backend_api.models.operations.VerifyDomainProxyResponse;
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
import com.clerk.backend_api.utils.SerializedBody;
import com.clerk.backend_api.utils.Utils.JsonShape;
import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.InputStream;
import java.lang.Exception;
import java.lang.Object;
import java.lang.String;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

 

public class ProxyChecks implements
            MethodCallVerifyDomainProxy {

    private final SDKConfiguration sdkConfiguration;

    ProxyChecks(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }


    /**
     * Verify the proxy configuration for your domain
     * 
     * <p>This endpoint can be used to validate that a proxy-enabled domain is operational.
     * It tries to verify that the proxy URL provided in the parameters maps to a functional proxy that can reach the Clerk Frontend API.
     * 
     * <p>You can use this endpoint before you set a proxy URL for a domain. This way you can ensure that switching to proxy-based
     * configuration will not lead to downtime for your instance.
     * 
     * <p>The `proxy_url` parameter allows for testing proxy configurations for domains that don't have a proxy URL yet, or operate on
     * a different proxy URL than the one provided. It can also be used to re-validate a domain that is already configured to work with a proxy.
     * 
     * @return The call builder
     */
    public VerifyDomainProxyRequestBuilder verify() {
        return new VerifyDomainProxyRequestBuilder(this);
    }

    /**
     * Verify the proxy configuration for your domain
     * 
     * <p>This endpoint can be used to validate that a proxy-enabled domain is operational.
     * It tries to verify that the proxy URL provided in the parameters maps to a functional proxy that can reach the Clerk Frontend API.
     * 
     * <p>You can use this endpoint before you set a proxy URL for a domain. This way you can ensure that switching to proxy-based
     * configuration will not lead to downtime for your instance.
     * 
     * <p>The `proxy_url` parameter allows for testing proxy configurations for domains that don't have a proxy URL yet, or operate on
     * a different proxy URL than the one provided. It can also be used to re-validate a domain that is already configured to work with a proxy.
     * 
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public VerifyDomainProxyResponse verifyDirect() throws Exception {
        return verify(Optional.empty(), Optional.empty());
    }
    
    /**
     * Verify the proxy configuration for your domain
     * 
     * <p>This endpoint can be used to validate that a proxy-enabled domain is operational.
     * It tries to verify that the proxy URL provided in the parameters maps to a functional proxy that can reach the Clerk Frontend API.
     * 
     * <p>You can use this endpoint before you set a proxy URL for a domain. This way you can ensure that switching to proxy-based
     * configuration will not lead to downtime for your instance.
     * 
     * <p>The `proxy_url` parameter allows for testing proxy configurations for domains that don't have a proxy URL yet, or operate on
     * a different proxy URL than the one provided. It can also be used to re-validate a domain that is already configured to work with a proxy.
     * 
     * @param request The request object containing all of the parameters for the API call.
     * @param options additional options
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public VerifyDomainProxyResponse verify(
            Optional<? extends VerifyDomainProxyRequestBody> request,
            Optional<Options> options) throws Exception {

        if (options.isPresent()) {
          options.get().validate(Arrays.asList(Options.Option.RETRY_CONFIG));
        }
        String _baseUrl = this.sdkConfiguration.serverUrl;
        String _url = Utils.generateURL(
                _baseUrl,
                "/proxy_checks");
        
        HTTPRequest _req = new HTTPRequest(_url, "POST");
        Object _convertedRequest = Utils.convertToShape(
                request, 
                JsonShape.DEFAULT,
                new TypeReference<Optional<? extends VerifyDomainProxyRequestBody>>() {});
        SerializedBody _serializedRequestBody = Utils.serializeRequestBody(
                _convertedRequest, 
                "request",
                "json",
                false);
        _req.setBody(Optional.ofNullable(_serializedRequestBody));
        _req.addHeader("Accept", "application/json")
            .addHeader("user-agent", 
                SDKConfiguration.USER_AGENT);
        
        Optional<SecuritySource> _hookSecuritySource = this.sdkConfiguration.securitySource();
        Utils.configureSecurity(_req,  
                this.sdkConfiguration.securitySource.getSecurity());
        HTTPClient _client = this.sdkConfiguration.defaultClient;
        HTTPRequest _finalReq = _req;
        RetryConfig _retryConfig;
        if (options.isPresent() && options.get().retryConfig().isPresent()) {
            _retryConfig = options.get().retryConfig().get();
        } else if (this.sdkConfiguration.retryConfig.isPresent()) {
            _retryConfig = this.sdkConfiguration.retryConfig.get();
        } else {
            _retryConfig = RetryConfig.builder()
                .backoff(BackoffStrategy.builder()
                            .initialInterval(500, TimeUnit.MILLISECONDS)
                            .maxInterval(60000, TimeUnit.MILLISECONDS)
                            .baseFactor((double)(1.5))
                            .maxElapsedTime(3600000, TimeUnit.MILLISECONDS)
                            .retryConnectError(true)
                            .build())
                .build();
        }
        List<String> _statusCodes = new ArrayList<>();
        _statusCodes.add("5XX");
        Retries _retries = Retries.builder()
            .action(() -> {
                HttpRequest _r = null;
                try {
                    _r = sdkConfiguration.hooks()
                        .beforeRequest(
                            new BeforeRequestContextImpl(
                                _baseUrl,
                                "VerifyDomainProxy", 
                                Optional.of(List.of()), 
                                _hookSecuritySource),
                            _finalReq.build());
                } catch (Exception _e) {
                    throw new NonRetryableException(_e);
                }
                try {
                    return _client.send(_r);
                } catch (Exception _e) {
                    return sdkConfiguration.hooks()
                        .afterError(
                            new AfterErrorContextImpl(
                                _baseUrl,
                                "VerifyDomainProxy",
                                 Optional.of(List.of()),
                                 _hookSecuritySource), 
                            Optional.empty(),
                            Optional.of(_e));
                }
            })
            .retryConfig(_retryConfig)
            .statusCodes(_statusCodes)
            .build();
        HttpResponse<InputStream> _httpRes = sdkConfiguration.hooks()
                 .afterSuccess(
                     new AfterSuccessContextImpl(
                          _baseUrl,
                         "VerifyDomainProxy", 
                         Optional.of(List.of()), 
                         _hookSecuritySource),
                     _retries.run());
        String _contentType = _httpRes
            .headers()
            .firstValue("Content-Type")
            .orElse("application/octet-stream");
        VerifyDomainProxyResponse.Builder _resBuilder = 
            VerifyDomainProxyResponse
                .builder()
                .contentType(_contentType)
                .statusCode(_httpRes.statusCode())
                .rawResponse(_httpRes);

        VerifyDomainProxyResponse _res = _resBuilder.build();
        
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "200")) {
            if (Utils.contentTypeMatches(_contentType, "application/json")) {
                ProxyCheck _out = Utils.mapper().readValue(
                    Utils.toUtf8AndClose(_httpRes.body()),
                    new TypeReference<ProxyCheck>() {});
                _res.withProxyCheck(Optional.ofNullable(_out));
                return _res;
            } else {
                throw new SDKError(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "Unexpected content-type received: " + _contentType, 
                    Utils.extractByteArrayFromBody(_httpRes));
            }
        }
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "400", "422")) {
            if (Utils.contentTypeMatches(_contentType, "application/json")) {
                ClerkErrors _out = Utils.mapper().readValue(
                    Utils.toUtf8AndClose(_httpRes.body()),
                    new TypeReference<ClerkErrors>() {});
                throw _out;
            } else {
                throw new SDKError(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "Unexpected content-type received: " + _contentType, 
                    Utils.extractByteArrayFromBody(_httpRes));
            }
        }
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "4XX")) {
            // no content 
            throw new SDKError(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "API error occurred", 
                    Utils.extractByteArrayFromBody(_httpRes));
        }
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "5XX")) {
            // no content 
            throw new SDKError(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "API error occurred", 
                    Utils.extractByteArrayFromBody(_httpRes));
        }
        throw new SDKError(
            _httpRes, 
            _httpRes.statusCode(), 
            "Unexpected status code received: " + _httpRes.statusCode(), 
            Utils.extractByteArrayFromBody(_httpRes));
    }

}
