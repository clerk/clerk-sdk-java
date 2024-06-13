/* 
 * Code generated by Speakeasy (https://speakeasyapi.dev). DO NOT EDIT.
 */

package com.clerk.backend_api;

import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.SDKMethodInterfaces.*;
import com.clerk.backend_api.utils.HTTPClient;
import com.clerk.backend_api.utils.HTTPRequest;
import com.clerk.backend_api.utils.Hook.AfterErrorContextImpl;
import com.clerk.backend_api.utils.Hook.AfterSuccessContextImpl;
import com.clerk.backend_api.utils.Hook.BeforeRequestContextImpl;
import com.clerk.backend_api.utils.JSON;
import com.clerk.backend_api.utils.Retries.NonRetryableException;
import com.clerk.backend_api.utils.SerializedBody;
import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
import java.io.InputStream;
import java.lang.Long;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import org.apache.http.NameValuePair;
import org.openapitools.jackson.nullable.JsonNullable;

public class SamlConnections implements
            MethodCallListSAMLConnections,
            MethodCallCreateSAMLConnection,
            MethodCallGetSAMLConnection,
            MethodCallUpdateSAMLConnection,
            MethodCallDeleteSAMLConnection {

    private final SDKConfiguration sdkConfiguration;

    SamlConnections(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }


    /**
     * Get a list of SAML Connections for an instance
     * Returns the list of SAML Connections for an instance.
     * Results can be paginated using the optional `limit` and `offset` query parameters.
     * The SAML Connections are ordered by descending creation date and the most recent will be returned first.
     * @return The call builder
     */
    public com.clerk.backend_api.models.operations.ListSAMLConnectionsRequestBuilder list() {
        return new com.clerk.backend_api.models.operations.ListSAMLConnectionsRequestBuilder(this);
    }

    /**
     * Get a list of SAML Connections for an instance
     * Returns the list of SAML Connections for an instance.
     * Results can be paginated using the optional `limit` and `offset` query parameters.
     * The SAML Connections are ordered by descending creation date and the most recent will be returned first.
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public com.clerk.backend_api.models.operations.ListSAMLConnectionsResponse listDirect() throws Exception {
        return list(Optional.empty(), Optional.empty());
    }
    /**
     * Get a list of SAML Connections for an instance
     * Returns the list of SAML Connections for an instance.
     * Results can be paginated using the optional `limit` and `offset` query parameters.
     * The SAML Connections are ordered by descending creation date and the most recent will be returned first.
     * @param limit Applies a limit to the number of results returned.
    Can be used for paginating the results together with `offset`.
     * @param offset Skip the first `offset` results when paginating.
    Needs to be an integer greater or equal to zero.
    To be used in conjunction with `limit`.
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public com.clerk.backend_api.models.operations.ListSAMLConnectionsResponse list(
            Optional<? extends Long> limit,
            Optional<? extends Long> offset) throws Exception {
        com.clerk.backend_api.models.operations.ListSAMLConnectionsRequest request =
            com.clerk.backend_api.models.operations.ListSAMLConnectionsRequest
                .builder()
                .limit(limit)
                .offset(offset)
                .build();
        
        String _baseUrl = this.sdkConfiguration.serverUrl;
        String _url = Utils.generateURL(
                _baseUrl,
                "/saml_connections");
        
        HTTPRequest _req = new HTTPRequest(_url, "GET");
        _req.addHeader("Accept", "application/json")
            .addHeader("user-agent", 
                this.sdkConfiguration.userAgent);

        _req.addQueryParams(Utils.getQueryParams(
                com.clerk.backend_api.models.operations.ListSAMLConnectionsRequest.class,
                request, 
                null));

        Utils.configureSecurity(_req,  
                this.sdkConfiguration.securitySource.getSecurity());

        HTTPClient _client = this.sdkConfiguration.defaultClient;
        HttpRequest _r = 
            sdkConfiguration.hooks()
               .beforeRequest(
                  new BeforeRequestContextImpl("ListSAMLConnections", Optional.empty(), sdkConfiguration.securitySource()),
                  _req.build());
        HttpResponse<InputStream> _httpRes;
        try {
            _httpRes = _client.send(_r);
            if (Utils.statusCodeMatches(_httpRes.statusCode(), "402", "403", "422", "4XX", "5XX")) {
                _httpRes = sdkConfiguration.hooks()
                    .afterError(
                        new AfterErrorContextImpl("ListSAMLConnections", Optional.empty(), sdkConfiguration.securitySource()),
                        Optional.of(_httpRes),
                        Optional.empty());
            } else {
                _httpRes = sdkConfiguration.hooks()
                    .afterSuccess(
                        new AfterSuccessContextImpl("ListSAMLConnections", Optional.empty(), sdkConfiguration.securitySource()),
                         _httpRes);
            }
        } catch (Exception _e) {
            _httpRes = sdkConfiguration.hooks()
                    .afterError(new AfterErrorContextImpl("ListSAMLConnections", Optional.empty(), sdkConfiguration.securitySource()), 
                        Optional.empty(),
                        Optional.of(_e));
        }
        String _contentType = _httpRes
            .headers()
            .firstValue("Content-Type")
            .orElse("application/octet-stream");
        byte[] _fullResponse = Utils.toByteArrayAndClose(_httpRes.body());
        
        @SuppressWarnings("deprecation")
        com.clerk.backend_api.models.operations.ListSAMLConnectionsResponse.Builder _resBuilder = 
            com.clerk.backend_api.models.operations.ListSAMLConnectionsResponse
                .builder()
                .contentType(_contentType)
                .statusCode(_httpRes.statusCode())
                .rawResponse(_httpRes)
                .next(() -> {
                    String _stringBody = new String(_fullResponse, StandardCharsets.UTF_8);
                    ReadContext _body = JsonPath.parse(_stringBody);

                    if (request == null) {
                        return Optional.empty();
                    }
                    long _requestOffset = request.offset().get();
                    @SuppressWarnings("unchecked")
                    List<Long> _firstResult = _body.read("$", List.class);
                    if (_firstResult == null || _firstResult.isEmpty()){
                        return Optional.empty();
                    };
                    long _resolvedLimit = limit.get();
                    
                    if (_firstResult.size() < _resolvedLimit) {
                        return Optional.empty();
                    };
                    long _newOffset = _requestOffset + _firstResult.size();
                    com.clerk.backend_api.models.operations.ListSAMLConnectionsRequestBuilder _ret = list();
                    _ret.limit(_resolvedLimit);
                    _ret.offset(_newOffset);
                    return Optional.of(_ret.call());
                });

        com.clerk.backend_api.models.operations.ListSAMLConnectionsResponse _res = _resBuilder.build();
        
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "200")) {
            if (Utils.contentTypeMatches(_contentType, "application/json")) {
                com.clerk.backend_api.models.components.SAMLConnections _out = Utils.mapper().readValue(
                    new String(_fullResponse, StandardCharsets.UTF_8),
                    new TypeReference<com.clerk.backend_api.models.components.SAMLConnections>() {});
                _res.withSAMLConnections(java.util.Optional.ofNullable(_out));
                return _res;
            } else {
                throw new SDKError(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "Unexpected content-type received: " + _contentType, 
                    _fullResponse);
            }
        }
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "402", "403", "422")) {
            if (Utils.contentTypeMatches(_contentType, "application/json")) {
                com.clerk.backend_api.models.errors.ClerkErrors _out = Utils.mapper().readValue(
                    new String(_fullResponse, StandardCharsets.UTF_8),
                    new TypeReference<com.clerk.backend_api.models.errors.ClerkErrors>() {});
                throw _out;
            } else {
                throw new SDKError(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "Unexpected content-type received: " + _contentType, 
                    _fullResponse);
            }
        }
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "4XX", "5XX")) {
            // no content 
            throw new SDKError(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "API error occurred", 
                    _fullResponse);
        }
        throw new SDKError(
            _httpRes, 
            _httpRes.statusCode(), 
            "Unexpected status code received: " + _httpRes.statusCode(), 
            _fullResponse);
    }



    /**
     * Create a SAML Connection
     * Create a new SAML Connection.
     * @return The call builder
     */
    public com.clerk.backend_api.models.operations.CreateSAMLConnectionRequestBuilder create() {
        return new com.clerk.backend_api.models.operations.CreateSAMLConnectionRequestBuilder(this);
    }

    /**
     * Create a SAML Connection
     * Create a new SAML Connection.
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public com.clerk.backend_api.models.operations.CreateSAMLConnectionResponse createDirect() throws Exception {
        return create(Optional.empty());
    }
    /**
     * Create a SAML Connection
     * Create a new SAML Connection.
     * @param request The request object containing all of the parameters for the API call.
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public com.clerk.backend_api.models.operations.CreateSAMLConnectionResponse create(
            Optional<? extends com.clerk.backend_api.models.operations.CreateSAMLConnectionRequestBody> request) throws Exception {
        String _baseUrl = this.sdkConfiguration.serverUrl;
        String _url = Utils.generateURL(
                _baseUrl,
                "/saml_connections");
        
        HTTPRequest _req = new HTTPRequest(_url, "POST");
        Object _convertedRequest = Utils.convertToShape(request, Utils.JsonShape.DEFAULT,
            new TypeReference<Optional<? extends com.clerk.backend_api.models.operations.CreateSAMLConnectionRequestBody>>() {});
        SerializedBody _serializedRequestBody = Utils.serializeRequestBody(
                _convertedRequest, "request", "json", false);
        _req.setBody(Optional.ofNullable(_serializedRequestBody));
        _req.addHeader("Accept", "application/json")
            .addHeader("user-agent", 
                this.sdkConfiguration.userAgent);

        Utils.configureSecurity(_req,  
                this.sdkConfiguration.securitySource.getSecurity());

        HTTPClient _client = this.sdkConfiguration.defaultClient;
        HttpRequest _r = 
            sdkConfiguration.hooks()
               .beforeRequest(
                  new BeforeRequestContextImpl("CreateSAMLConnection", Optional.empty(), sdkConfiguration.securitySource()),
                  _req.build());
        HttpResponse<InputStream> _httpRes;
        try {
            _httpRes = _client.send(_r);
            if (Utils.statusCodeMatches(_httpRes.statusCode(), "402", "403", "422", "4XX", "5XX")) {
                _httpRes = sdkConfiguration.hooks()
                    .afterError(
                        new AfterErrorContextImpl("CreateSAMLConnection", Optional.empty(), sdkConfiguration.securitySource()),
                        Optional.of(_httpRes),
                        Optional.empty());
            } else {
                _httpRes = sdkConfiguration.hooks()
                    .afterSuccess(
                        new AfterSuccessContextImpl("CreateSAMLConnection", Optional.empty(), sdkConfiguration.securitySource()),
                         _httpRes);
            }
        } catch (Exception _e) {
            _httpRes = sdkConfiguration.hooks()
                    .afterError(new AfterErrorContextImpl("CreateSAMLConnection", Optional.empty(), sdkConfiguration.securitySource()), 
                        Optional.empty(),
                        Optional.of(_e));
        }
        String _contentType = _httpRes
            .headers()
            .firstValue("Content-Type")
            .orElse("application/octet-stream");
        com.clerk.backend_api.models.operations.CreateSAMLConnectionResponse.Builder _resBuilder = 
            com.clerk.backend_api.models.operations.CreateSAMLConnectionResponse
                .builder()
                .contentType(_contentType)
                .statusCode(_httpRes.statusCode())
                .rawResponse(_httpRes);

        com.clerk.backend_api.models.operations.CreateSAMLConnectionResponse _res = _resBuilder.build();
        
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "200")) {
            if (Utils.contentTypeMatches(_contentType, "application/json")) {
                com.clerk.backend_api.models.components.SAMLConnection _out = Utils.mapper().readValue(
                    Utils.toUtf8AndClose(_httpRes.body()),
                    new TypeReference<com.clerk.backend_api.models.components.SAMLConnection>() {});
                _res.withSAMLConnection(java.util.Optional.ofNullable(_out));
                return _res;
            } else {
                throw new SDKError(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "Unexpected content-type received: " + _contentType, 
                    Utils.toByteArrayAndClose(_httpRes.body()));
            }
        }
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "402", "403", "422")) {
            if (Utils.contentTypeMatches(_contentType, "application/json")) {
                com.clerk.backend_api.models.errors.ClerkErrors _out = Utils.mapper().readValue(
                    Utils.toUtf8AndClose(_httpRes.body()),
                    new TypeReference<com.clerk.backend_api.models.errors.ClerkErrors>() {});
                throw _out;
            } else {
                throw new SDKError(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "Unexpected content-type received: " + _contentType, 
                    Utils.toByteArrayAndClose(_httpRes.body()));
            }
        }
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "4XX", "5XX")) {
            // no content 
            throw new SDKError(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "API error occurred", 
                    Utils.toByteArrayAndClose(_httpRes.body()));
        }
        throw new SDKError(
            _httpRes, 
            _httpRes.statusCode(), 
            "Unexpected status code received: " + _httpRes.statusCode(), 
            Utils.toByteArrayAndClose(_httpRes.body()));
    }



    /**
     * Retrieve a SAML Connection by ID
     * Fetches the SAML Connection whose ID matches the provided `saml_connection_id` in the path.
     * @return The call builder
     */
    public com.clerk.backend_api.models.operations.GetSAMLConnectionRequestBuilder get() {
        return new com.clerk.backend_api.models.operations.GetSAMLConnectionRequestBuilder(this);
    }

    /**
     * Retrieve a SAML Connection by ID
     * Fetches the SAML Connection whose ID matches the provided `saml_connection_id` in the path.
     * @param samlConnectionId The ID of the SAML Connection
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public com.clerk.backend_api.models.operations.GetSAMLConnectionResponse get(
            String samlConnectionId) throws Exception {
        com.clerk.backend_api.models.operations.GetSAMLConnectionRequest request =
            com.clerk.backend_api.models.operations.GetSAMLConnectionRequest
                .builder()
                .samlConnectionId(samlConnectionId)
                .build();
        
        String _baseUrl = this.sdkConfiguration.serverUrl;
        String _url = Utils.generateURL(
                com.clerk.backend_api.models.operations.GetSAMLConnectionRequest.class,
                _baseUrl,
                "/saml_connections/{saml_connection_id}",
                request, null);
        
        HTTPRequest _req = new HTTPRequest(_url, "GET");
        _req.addHeader("Accept", "application/json")
            .addHeader("user-agent", 
                this.sdkConfiguration.userAgent);

        Utils.configureSecurity(_req,  
                this.sdkConfiguration.securitySource.getSecurity());

        HTTPClient _client = this.sdkConfiguration.defaultClient;
        HttpRequest _r = 
            sdkConfiguration.hooks()
               .beforeRequest(
                  new BeforeRequestContextImpl("GetSAMLConnection", Optional.empty(), sdkConfiguration.securitySource()),
                  _req.build());
        HttpResponse<InputStream> _httpRes;
        try {
            _httpRes = _client.send(_r);
            if (Utils.statusCodeMatches(_httpRes.statusCode(), "402", "403", "404", "4XX", "5XX")) {
                _httpRes = sdkConfiguration.hooks()
                    .afterError(
                        new AfterErrorContextImpl("GetSAMLConnection", Optional.empty(), sdkConfiguration.securitySource()),
                        Optional.of(_httpRes),
                        Optional.empty());
            } else {
                _httpRes = sdkConfiguration.hooks()
                    .afterSuccess(
                        new AfterSuccessContextImpl("GetSAMLConnection", Optional.empty(), sdkConfiguration.securitySource()),
                         _httpRes);
            }
        } catch (Exception _e) {
            _httpRes = sdkConfiguration.hooks()
                    .afterError(new AfterErrorContextImpl("GetSAMLConnection", Optional.empty(), sdkConfiguration.securitySource()), 
                        Optional.empty(),
                        Optional.of(_e));
        }
        String _contentType = _httpRes
            .headers()
            .firstValue("Content-Type")
            .orElse("application/octet-stream");
        com.clerk.backend_api.models.operations.GetSAMLConnectionResponse.Builder _resBuilder = 
            com.clerk.backend_api.models.operations.GetSAMLConnectionResponse
                .builder()
                .contentType(_contentType)
                .statusCode(_httpRes.statusCode())
                .rawResponse(_httpRes);

        com.clerk.backend_api.models.operations.GetSAMLConnectionResponse _res = _resBuilder.build();
        
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "200")) {
            if (Utils.contentTypeMatches(_contentType, "application/json")) {
                com.clerk.backend_api.models.components.SAMLConnection _out = Utils.mapper().readValue(
                    Utils.toUtf8AndClose(_httpRes.body()),
                    new TypeReference<com.clerk.backend_api.models.components.SAMLConnection>() {});
                _res.withSAMLConnection(java.util.Optional.ofNullable(_out));
                return _res;
            } else {
                throw new SDKError(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "Unexpected content-type received: " + _contentType, 
                    Utils.toByteArrayAndClose(_httpRes.body()));
            }
        }
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "402", "403", "404")) {
            if (Utils.contentTypeMatches(_contentType, "application/json")) {
                com.clerk.backend_api.models.errors.ClerkErrors _out = Utils.mapper().readValue(
                    Utils.toUtf8AndClose(_httpRes.body()),
                    new TypeReference<com.clerk.backend_api.models.errors.ClerkErrors>() {});
                throw _out;
            } else {
                throw new SDKError(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "Unexpected content-type received: " + _contentType, 
                    Utils.toByteArrayAndClose(_httpRes.body()));
            }
        }
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "4XX", "5XX")) {
            // no content 
            throw new SDKError(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "API error occurred", 
                    Utils.toByteArrayAndClose(_httpRes.body()));
        }
        throw new SDKError(
            _httpRes, 
            _httpRes.statusCode(), 
            "Unexpected status code received: " + _httpRes.statusCode(), 
            Utils.toByteArrayAndClose(_httpRes.body()));
    }



    /**
     * Update a SAML Connection
     * Updates the SAML Connection whose ID matches the provided `id` in the path.
     * @return The call builder
     */
    public com.clerk.backend_api.models.operations.UpdateSAMLConnectionRequestBuilder update() {
        return new com.clerk.backend_api.models.operations.UpdateSAMLConnectionRequestBuilder(this);
    }

    /**
     * Update a SAML Connection
     * Updates the SAML Connection whose ID matches the provided `id` in the path.
     * @param samlConnectionId The ID of the SAML Connection to update
     * @param requestBody
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public com.clerk.backend_api.models.operations.UpdateSAMLConnectionResponse update(
            String samlConnectionId,
            com.clerk.backend_api.models.operations.UpdateSAMLConnectionRequestBody requestBody) throws Exception {
        com.clerk.backend_api.models.operations.UpdateSAMLConnectionRequest request =
            com.clerk.backend_api.models.operations.UpdateSAMLConnectionRequest
                .builder()
                .samlConnectionId(samlConnectionId)
                .requestBody(requestBody)
                .build();
        
        String _baseUrl = this.sdkConfiguration.serverUrl;
        String _url = Utils.generateURL(
                com.clerk.backend_api.models.operations.UpdateSAMLConnectionRequest.class,
                _baseUrl,
                "/saml_connections/{saml_connection_id}",
                request, null);
        
        HTTPRequest _req = new HTTPRequest(_url, "PATCH");
        Object _convertedRequest = Utils.convertToShape(request, Utils.JsonShape.DEFAULT,
            new TypeReference<java.lang.Object>() {});
        SerializedBody _serializedRequestBody = Utils.serializeRequestBody(
                _convertedRequest, "requestBody", "json", false);
        if (_serializedRequestBody == null) {
            throw new Exception("Request body is required");
        }
        _req.setBody(Optional.ofNullable(_serializedRequestBody));
        _req.addHeader("Accept", "application/json")
            .addHeader("user-agent", 
                this.sdkConfiguration.userAgent);

        Utils.configureSecurity(_req,  
                this.sdkConfiguration.securitySource.getSecurity());

        HTTPClient _client = this.sdkConfiguration.defaultClient;
        HttpRequest _r = 
            sdkConfiguration.hooks()
               .beforeRequest(
                  new BeforeRequestContextImpl("UpdateSAMLConnection", Optional.empty(), sdkConfiguration.securitySource()),
                  _req.build());
        HttpResponse<InputStream> _httpRes;
        try {
            _httpRes = _client.send(_r);
            if (Utils.statusCodeMatches(_httpRes.statusCode(), "402", "403", "404", "422", "4XX", "5XX")) {
                _httpRes = sdkConfiguration.hooks()
                    .afterError(
                        new AfterErrorContextImpl("UpdateSAMLConnection", Optional.empty(), sdkConfiguration.securitySource()),
                        Optional.of(_httpRes),
                        Optional.empty());
            } else {
                _httpRes = sdkConfiguration.hooks()
                    .afterSuccess(
                        new AfterSuccessContextImpl("UpdateSAMLConnection", Optional.empty(), sdkConfiguration.securitySource()),
                         _httpRes);
            }
        } catch (Exception _e) {
            _httpRes = sdkConfiguration.hooks()
                    .afterError(new AfterErrorContextImpl("UpdateSAMLConnection", Optional.empty(), sdkConfiguration.securitySource()), 
                        Optional.empty(),
                        Optional.of(_e));
        }
        String _contentType = _httpRes
            .headers()
            .firstValue("Content-Type")
            .orElse("application/octet-stream");
        com.clerk.backend_api.models.operations.UpdateSAMLConnectionResponse.Builder _resBuilder = 
            com.clerk.backend_api.models.operations.UpdateSAMLConnectionResponse
                .builder()
                .contentType(_contentType)
                .statusCode(_httpRes.statusCode())
                .rawResponse(_httpRes);

        com.clerk.backend_api.models.operations.UpdateSAMLConnectionResponse _res = _resBuilder.build();
        
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "200")) {
            if (Utils.contentTypeMatches(_contentType, "application/json")) {
                com.clerk.backend_api.models.components.SAMLConnection _out = Utils.mapper().readValue(
                    Utils.toUtf8AndClose(_httpRes.body()),
                    new TypeReference<com.clerk.backend_api.models.components.SAMLConnection>() {});
                _res.withSAMLConnection(java.util.Optional.ofNullable(_out));
                return _res;
            } else {
                throw new SDKError(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "Unexpected content-type received: " + _contentType, 
                    Utils.toByteArrayAndClose(_httpRes.body()));
            }
        }
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "402", "403", "404", "422")) {
            if (Utils.contentTypeMatches(_contentType, "application/json")) {
                com.clerk.backend_api.models.errors.ClerkErrors _out = Utils.mapper().readValue(
                    Utils.toUtf8AndClose(_httpRes.body()),
                    new TypeReference<com.clerk.backend_api.models.errors.ClerkErrors>() {});
                throw _out;
            } else {
                throw new SDKError(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "Unexpected content-type received: " + _contentType, 
                    Utils.toByteArrayAndClose(_httpRes.body()));
            }
        }
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "4XX", "5XX")) {
            // no content 
            throw new SDKError(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "API error occurred", 
                    Utils.toByteArrayAndClose(_httpRes.body()));
        }
        throw new SDKError(
            _httpRes, 
            _httpRes.statusCode(), 
            "Unexpected status code received: " + _httpRes.statusCode(), 
            Utils.toByteArrayAndClose(_httpRes.body()));
    }



    /**
     * Delete a SAML Connection
     * Deletes the SAML Connection whose ID matches the provided `id` in the path.
     * @return The call builder
     */
    public com.clerk.backend_api.models.operations.DeleteSAMLConnectionRequestBuilder delete() {
        return new com.clerk.backend_api.models.operations.DeleteSAMLConnectionRequestBuilder(this);
    }

    /**
     * Delete a SAML Connection
     * Deletes the SAML Connection whose ID matches the provided `id` in the path.
     * @param samlConnectionId The ID of the SAML Connection to delete
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public com.clerk.backend_api.models.operations.DeleteSAMLConnectionResponse delete(
            String samlConnectionId) throws Exception {
        com.clerk.backend_api.models.operations.DeleteSAMLConnectionRequest request =
            com.clerk.backend_api.models.operations.DeleteSAMLConnectionRequest
                .builder()
                .samlConnectionId(samlConnectionId)
                .build();
        
        String _baseUrl = this.sdkConfiguration.serverUrl;
        String _url = Utils.generateURL(
                com.clerk.backend_api.models.operations.DeleteSAMLConnectionRequest.class,
                _baseUrl,
                "/saml_connections/{saml_connection_id}",
                request, null);
        
        HTTPRequest _req = new HTTPRequest(_url, "DELETE");
        _req.addHeader("Accept", "application/json")
            .addHeader("user-agent", 
                this.sdkConfiguration.userAgent);

        Utils.configureSecurity(_req,  
                this.sdkConfiguration.securitySource.getSecurity());

        HTTPClient _client = this.sdkConfiguration.defaultClient;
        HttpRequest _r = 
            sdkConfiguration.hooks()
               .beforeRequest(
                  new BeforeRequestContextImpl("DeleteSAMLConnection", Optional.empty(), sdkConfiguration.securitySource()),
                  _req.build());
        HttpResponse<InputStream> _httpRes;
        try {
            _httpRes = _client.send(_r);
            if (Utils.statusCodeMatches(_httpRes.statusCode(), "402", "403", "404", "4XX", "5XX")) {
                _httpRes = sdkConfiguration.hooks()
                    .afterError(
                        new AfterErrorContextImpl("DeleteSAMLConnection", Optional.empty(), sdkConfiguration.securitySource()),
                        Optional.of(_httpRes),
                        Optional.empty());
            } else {
                _httpRes = sdkConfiguration.hooks()
                    .afterSuccess(
                        new AfterSuccessContextImpl("DeleteSAMLConnection", Optional.empty(), sdkConfiguration.securitySource()),
                         _httpRes);
            }
        } catch (Exception _e) {
            _httpRes = sdkConfiguration.hooks()
                    .afterError(new AfterErrorContextImpl("DeleteSAMLConnection", Optional.empty(), sdkConfiguration.securitySource()), 
                        Optional.empty(),
                        Optional.of(_e));
        }
        String _contentType = _httpRes
            .headers()
            .firstValue("Content-Type")
            .orElse("application/octet-stream");
        com.clerk.backend_api.models.operations.DeleteSAMLConnectionResponse.Builder _resBuilder = 
            com.clerk.backend_api.models.operations.DeleteSAMLConnectionResponse
                .builder()
                .contentType(_contentType)
                .statusCode(_httpRes.statusCode())
                .rawResponse(_httpRes);

        com.clerk.backend_api.models.operations.DeleteSAMLConnectionResponse _res = _resBuilder.build();
        
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "200")) {
            if (Utils.contentTypeMatches(_contentType, "application/json")) {
                com.clerk.backend_api.models.components.DeletedObject _out = Utils.mapper().readValue(
                    Utils.toUtf8AndClose(_httpRes.body()),
                    new TypeReference<com.clerk.backend_api.models.components.DeletedObject>() {});
                _res.withDeletedObject(java.util.Optional.ofNullable(_out));
                return _res;
            } else {
                throw new SDKError(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "Unexpected content-type received: " + _contentType, 
                    Utils.toByteArrayAndClose(_httpRes.body()));
            }
        }
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "402", "403", "404")) {
            if (Utils.contentTypeMatches(_contentType, "application/json")) {
                com.clerk.backend_api.models.errors.ClerkErrors _out = Utils.mapper().readValue(
                    Utils.toUtf8AndClose(_httpRes.body()),
                    new TypeReference<com.clerk.backend_api.models.errors.ClerkErrors>() {});
                throw _out;
            } else {
                throw new SDKError(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "Unexpected content-type received: " + _contentType, 
                    Utils.toByteArrayAndClose(_httpRes.body()));
            }
        }
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "4XX", "5XX")) {
            // no content 
            throw new SDKError(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "API error occurred", 
                    Utils.toByteArrayAndClose(_httpRes.body()));
        }
        throw new SDKError(
            _httpRes, 
            _httpRes.statusCode(), 
            "Unexpected status code received: " + _httpRes.statusCode(), 
            Utils.toByteArrayAndClose(_httpRes.body()));
    }

}