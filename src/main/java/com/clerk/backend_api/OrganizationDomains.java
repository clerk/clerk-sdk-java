/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api;

import com.clerk.backend_api.models.components.DeletedObject;
import com.clerk.backend_api.models.components.OrganizationDomain;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.CreateOrganizationDomainRequest;
import com.clerk.backend_api.models.operations.CreateOrganizationDomainRequestBody;
import com.clerk.backend_api.models.operations.CreateOrganizationDomainRequestBuilder;
import com.clerk.backend_api.models.operations.CreateOrganizationDomainResponse;
import com.clerk.backend_api.models.operations.DeleteOrganizationDomainRequest;
import com.clerk.backend_api.models.operations.DeleteOrganizationDomainRequestBuilder;
import com.clerk.backend_api.models.operations.DeleteOrganizationDomainResponse;
import com.clerk.backend_api.models.operations.ListOrganizationDomainsRequest;
import com.clerk.backend_api.models.operations.ListOrganizationDomainsRequestBuilder;
import com.clerk.backend_api.models.operations.ListOrganizationDomainsResponse;
import com.clerk.backend_api.models.operations.SDKMethodInterfaces.*;
import com.clerk.backend_api.models.operations.UpdateOrganizationDomainRequest;
import com.clerk.backend_api.models.operations.UpdateOrganizationDomainRequestBody;
import com.clerk.backend_api.models.operations.UpdateOrganizationDomainRequestBuilder;
import com.clerk.backend_api.models.operations.UpdateOrganizationDomainResponse;
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

 

public class OrganizationDomains implements
            MethodCallCreateOrganizationDomain,
            MethodCallListOrganizationDomains,
            MethodCallUpdateOrganizationDomain,
            MethodCallDeleteOrganizationDomain {

    private final SDKConfiguration sdkConfiguration;

    OrganizationDomains(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }


    /**
     * Create a new organization domain.
     * 
     * <p>Creates a new organization domain. By default the domain is verified, but can be optionally set to unverified.
     * 
     * @return The call builder
     */
    public CreateOrganizationDomainRequestBuilder create() {
        return new CreateOrganizationDomainRequestBuilder(this);
    }

    /**
     * Create a new organization domain.
     * 
     * <p>Creates a new organization domain. By default the domain is verified, but can be optionally set to unverified.
     * 
     * @param organizationId The ID of the organization where the new domain will be created.
     * @param requestBody 
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public CreateOrganizationDomainResponse create(
            String organizationId,
            CreateOrganizationDomainRequestBody requestBody) throws Exception {
        return create(organizationId, requestBody, Optional.empty());
    }
    
    /**
     * Create a new organization domain.
     * 
     * <p>Creates a new organization domain. By default the domain is verified, but can be optionally set to unverified.
     * 
     * @param organizationId The ID of the organization where the new domain will be created.
     * @param requestBody 
     * @param options additional options
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public CreateOrganizationDomainResponse create(
            String organizationId,
            CreateOrganizationDomainRequestBody requestBody,
            Optional<Options> options) throws Exception {

        if (options.isPresent()) {
          options.get().validate(Arrays.asList(Options.Option.RETRY_CONFIG));
        }
        CreateOrganizationDomainRequest request =
            CreateOrganizationDomainRequest
                .builder()
                .organizationId(organizationId)
                .requestBody(requestBody)
                .build();
        
        String _baseUrl = this.sdkConfiguration.serverUrl;
        String _url = Utils.generateURL(
                CreateOrganizationDomainRequest.class,
                _baseUrl,
                "/organizations/{organization_id}/domains",
                request, null);
        
        HTTPRequest _req = new HTTPRequest(_url, "POST");
        Object _convertedRequest = Utils.convertToShape(
                request, 
                JsonShape.DEFAULT,
                new TypeReference<Object>() {});
        SerializedBody _serializedRequestBody = Utils.serializeRequestBody(
                _convertedRequest, 
                "requestBody",
                "json",
                false);
        if (_serializedRequestBody == null) {
            throw new Exception("Request body is required");
        }
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
                                "CreateOrganizationDomain", 
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
                                "CreateOrganizationDomain",
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
                         "CreateOrganizationDomain", 
                         Optional.of(List.of()), 
                         _hookSecuritySource),
                     _retries.run());
        String _contentType = _httpRes
            .headers()
            .firstValue("Content-Type")
            .orElse("application/octet-stream");
        CreateOrganizationDomainResponse.Builder _resBuilder = 
            CreateOrganizationDomainResponse
                .builder()
                .contentType(_contentType)
                .statusCode(_httpRes.statusCode())
                .rawResponse(_httpRes);

        CreateOrganizationDomainResponse _res = _resBuilder.build();
        
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "200")) {
            if (Utils.contentTypeMatches(_contentType, "application/json")) {
                OrganizationDomain _out = Utils.mapper().readValue(
                    Utils.toUtf8AndClose(_httpRes.body()),
                    new TypeReference<OrganizationDomain>() {});
                _res.withOrganizationDomain(Optional.ofNullable(_out));
                return _res;
            } else {
                throw new SDKError(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "Unexpected content-type received: " + _contentType, 
                    Utils.extractByteArrayFromBody(_httpRes));
            }
        }
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "400", "403", "404", "422")) {
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



    /**
     * Get a list of all domains of an organization.
     * 
     * <p>Get a list of all domains of an organization.
     * 
     * @return The call builder
     */
    public ListOrganizationDomainsRequestBuilder list() {
        return new ListOrganizationDomainsRequestBuilder(this);
    }

    /**
     * Get a list of all domains of an organization.
     * 
     * <p>Get a list of all domains of an organization.
     * 
     * @param request The request object containing all of the parameters for the API call.
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public ListOrganizationDomainsResponse list(
            ListOrganizationDomainsRequest request) throws Exception {
        return list(request, Optional.empty());
    }
    
    /**
     * Get a list of all domains of an organization.
     * 
     * <p>Get a list of all domains of an organization.
     * 
     * @param request The request object containing all of the parameters for the API call.
     * @param options additional options
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public ListOrganizationDomainsResponse list(
            ListOrganizationDomainsRequest request,
            Optional<Options> options) throws Exception {

        if (options.isPresent()) {
          options.get().validate(Arrays.asList(Options.Option.RETRY_CONFIG));
        }
        String _baseUrl = this.sdkConfiguration.serverUrl;
        String _url = Utils.generateURL(
                ListOrganizationDomainsRequest.class,
                _baseUrl,
                "/organizations/{organization_id}/domains",
                request, null);
        
        HTTPRequest _req = new HTTPRequest(_url, "GET");
        _req.addHeader("Accept", "application/json")
            .addHeader("user-agent", 
                SDKConfiguration.USER_AGENT);

        _req.addQueryParams(Utils.getQueryParams(
                ListOrganizationDomainsRequest.class,
                request, 
                null));
        
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
                                "ListOrganizationDomains", 
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
                                "ListOrganizationDomains",
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
                         "ListOrganizationDomains", 
                         Optional.of(List.of()), 
                         _hookSecuritySource),
                     _retries.run());
        String _contentType = _httpRes
            .headers()
            .firstValue("Content-Type")
            .orElse("application/octet-stream");
        ListOrganizationDomainsResponse.Builder _resBuilder = 
            ListOrganizationDomainsResponse
                .builder()
                .contentType(_contentType)
                .statusCode(_httpRes.statusCode())
                .rawResponse(_httpRes);

        ListOrganizationDomainsResponse _res = _resBuilder.build();
        
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "200")) {
            if (Utils.contentTypeMatches(_contentType, "application/json")) {
                com.clerk.backend_api.models.components.OrganizationDomains _out = Utils.mapper().readValue(
                    Utils.toUtf8AndClose(_httpRes.body()),
                    new TypeReference<com.clerk.backend_api.models.components.OrganizationDomains>() {});
                _res.withOrganizationDomains(Optional.ofNullable(_out));
                return _res;
            } else {
                throw new SDKError(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "Unexpected content-type received: " + _contentType, 
                    Utils.extractByteArrayFromBody(_httpRes));
            }
        }
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "401", "422")) {
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



    /**
     * Update an organization domain.
     * 
     * <p>Updates the properties of an existing organization domain.
     * 
     * @return The call builder
     */
    public UpdateOrganizationDomainRequestBuilder update() {
        return new UpdateOrganizationDomainRequestBuilder(this);
    }

    /**
     * Update an organization domain.
     * 
     * <p>Updates the properties of an existing organization domain.
     * 
     * @param organizationId The ID of the organization the domain belongs to
     * @param domainId The ID of the domain
     * @param requestBody 
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public UpdateOrganizationDomainResponse update(
            String organizationId,
            String domainId,
            UpdateOrganizationDomainRequestBody requestBody) throws Exception {
        return update(organizationId, domainId, requestBody, Optional.empty());
    }
    
    /**
     * Update an organization domain.
     * 
     * <p>Updates the properties of an existing organization domain.
     * 
     * @param organizationId The ID of the organization the domain belongs to
     * @param domainId The ID of the domain
     * @param requestBody 
     * @param options additional options
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public UpdateOrganizationDomainResponse update(
            String organizationId,
            String domainId,
            UpdateOrganizationDomainRequestBody requestBody,
            Optional<Options> options) throws Exception {

        if (options.isPresent()) {
          options.get().validate(Arrays.asList(Options.Option.RETRY_CONFIG));
        }
        UpdateOrganizationDomainRequest request =
            UpdateOrganizationDomainRequest
                .builder()
                .organizationId(organizationId)
                .domainId(domainId)
                .requestBody(requestBody)
                .build();
        
        String _baseUrl = this.sdkConfiguration.serverUrl;
        String _url = Utils.generateURL(
                UpdateOrganizationDomainRequest.class,
                _baseUrl,
                "/organizations/{organization_id}/domains/{domain_id}",
                request, null);
        
        HTTPRequest _req = new HTTPRequest(_url, "PATCH");
        Object _convertedRequest = Utils.convertToShape(
                request, 
                JsonShape.DEFAULT,
                new TypeReference<Object>() {});
        SerializedBody _serializedRequestBody = Utils.serializeRequestBody(
                _convertedRequest, 
                "requestBody",
                "json",
                false);
        if (_serializedRequestBody == null) {
            throw new Exception("Request body is required");
        }
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
                                "UpdateOrganizationDomain", 
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
                                "UpdateOrganizationDomain",
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
                         "UpdateOrganizationDomain", 
                         Optional.of(List.of()), 
                         _hookSecuritySource),
                     _retries.run());
        String _contentType = _httpRes
            .headers()
            .firstValue("Content-Type")
            .orElse("application/octet-stream");
        UpdateOrganizationDomainResponse.Builder _resBuilder = 
            UpdateOrganizationDomainResponse
                .builder()
                .contentType(_contentType)
                .statusCode(_httpRes.statusCode())
                .rawResponse(_httpRes);

        UpdateOrganizationDomainResponse _res = _resBuilder.build();
        
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "200")) {
            if (Utils.contentTypeMatches(_contentType, "application/json")) {
                OrganizationDomain _out = Utils.mapper().readValue(
                    Utils.toUtf8AndClose(_httpRes.body()),
                    new TypeReference<OrganizationDomain>() {});
                _res.withOrganizationDomain(Optional.ofNullable(_out));
                return _res;
            } else {
                throw new SDKError(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "Unexpected content-type received: " + _contentType, 
                    Utils.extractByteArrayFromBody(_httpRes));
            }
        }
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "400", "404", "422")) {
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



    /**
     * Remove a domain from an organization.
     * 
     * <p>Removes the given domain from the organization.
     * 
     * @return The call builder
     */
    public DeleteOrganizationDomainRequestBuilder delete() {
        return new DeleteOrganizationDomainRequestBuilder(this);
    }

    /**
     * Remove a domain from an organization.
     * 
     * <p>Removes the given domain from the organization.
     * 
     * @param organizationId The ID of the organization the domain belongs to
     * @param domainId The ID of the domain
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public DeleteOrganizationDomainResponse delete(
            String organizationId,
            String domainId) throws Exception {
        return delete(organizationId, domainId, Optional.empty());
    }
    
    /**
     * Remove a domain from an organization.
     * 
     * <p>Removes the given domain from the organization.
     * 
     * @param organizationId The ID of the organization the domain belongs to
     * @param domainId The ID of the domain
     * @param options additional options
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public DeleteOrganizationDomainResponse delete(
            String organizationId,
            String domainId,
            Optional<Options> options) throws Exception {

        if (options.isPresent()) {
          options.get().validate(Arrays.asList(Options.Option.RETRY_CONFIG));
        }
        DeleteOrganizationDomainRequest request =
            DeleteOrganizationDomainRequest
                .builder()
                .organizationId(organizationId)
                .domainId(domainId)
                .build();
        
        String _baseUrl = this.sdkConfiguration.serverUrl;
        String _url = Utils.generateURL(
                DeleteOrganizationDomainRequest.class,
                _baseUrl,
                "/organizations/{organization_id}/domains/{domain_id}",
                request, null);
        
        HTTPRequest _req = new HTTPRequest(_url, "DELETE");
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
                                "DeleteOrganizationDomain", 
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
                                "DeleteOrganizationDomain",
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
                         "DeleteOrganizationDomain", 
                         Optional.of(List.of()), 
                         _hookSecuritySource),
                     _retries.run());
        String _contentType = _httpRes
            .headers()
            .firstValue("Content-Type")
            .orElse("application/octet-stream");
        DeleteOrganizationDomainResponse.Builder _resBuilder = 
            DeleteOrganizationDomainResponse
                .builder()
                .contentType(_contentType)
                .statusCode(_httpRes.statusCode())
                .rawResponse(_httpRes);

        DeleteOrganizationDomainResponse _res = _resBuilder.build();
        
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "200")) {
            if (Utils.contentTypeMatches(_contentType, "application/json")) {
                DeletedObject _out = Utils.mapper().readValue(
                    Utils.toUtf8AndClose(_httpRes.body()),
                    new TypeReference<DeletedObject>() {});
                _res.withDeletedObject(Optional.ofNullable(_out));
                return _res;
            } else {
                throw new SDKError(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "Unexpected content-type received: " + _contentType, 
                    Utils.extractByteArrayFromBody(_httpRes));
            }
        }
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "400", "401", "404")) {
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
