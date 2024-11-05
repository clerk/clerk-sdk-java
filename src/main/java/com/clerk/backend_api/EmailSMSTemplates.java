/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api;

import com.clerk.backend_api.models.components.Template;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.GetTemplateListRequest;
import com.clerk.backend_api.models.operations.GetTemplateListRequestBuilder;
import com.clerk.backend_api.models.operations.GetTemplateListResponse;
import com.clerk.backend_api.models.operations.GetTemplateRequest;
import com.clerk.backend_api.models.operations.GetTemplateRequestBuilder;
import com.clerk.backend_api.models.operations.GetTemplateResponse;
import com.clerk.backend_api.models.operations.PathParamTemplateType;
import com.clerk.backend_api.models.operations.RevertTemplatePathParamTemplateType;
import com.clerk.backend_api.models.operations.RevertTemplateRequest;
import com.clerk.backend_api.models.operations.RevertTemplateRequestBuilder;
import com.clerk.backend_api.models.operations.RevertTemplateResponse;
import com.clerk.backend_api.models.operations.SDKMethodInterfaces.*;
import com.clerk.backend_api.models.operations.TemplateType;
import com.clerk.backend_api.models.operations.ToggleTemplateDeliveryPathParamTemplateType;
import com.clerk.backend_api.models.operations.ToggleTemplateDeliveryRequest;
import com.clerk.backend_api.models.operations.ToggleTemplateDeliveryRequestBody;
import com.clerk.backend_api.models.operations.ToggleTemplateDeliveryRequestBuilder;
import com.clerk.backend_api.models.operations.ToggleTemplateDeliveryResponse;
import com.clerk.backend_api.utils.HTTPClient;
import com.clerk.backend_api.utils.HTTPRequest;
import com.clerk.backend_api.utils.Hook.AfterErrorContextImpl;
import com.clerk.backend_api.utils.Hook.AfterSuccessContextImpl;
import com.clerk.backend_api.utils.Hook.BeforeRequestContextImpl;
import com.clerk.backend_api.utils.SerializedBody;
import com.clerk.backend_api.utils.Utils.JsonShape;
import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.InputStream;
import java.lang.Deprecated;
import java.lang.Exception;
import java.lang.Object;
import java.lang.String;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional; 

public class EmailSMSTemplates implements
            MethodCallGetTemplateList,
            MethodCallRevertTemplate,
            MethodCallGetTemplate,
            MethodCallToggleTemplateDelivery {

    private final SDKConfiguration sdkConfiguration;

    EmailSMSTemplates(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }


    /**
     * List all templates
     * Returns a list of all templates.
     * The templates are returned sorted by position.
     * @return The call builder
     * @deprecated method: This will be removed in a future release, please migrate away from it as soon as possible.
     */
    @Deprecated
    public GetTemplateListRequestBuilder list() {
        return new GetTemplateListRequestBuilder(this);
    }

    /**
     * List all templates
     * Returns a list of all templates.
     * The templates are returned sorted by position.
     * @param templateType The type of templates to list (email or SMS)
     * @return The response from the API call
     * @throws Exception if the API call fails
     * @deprecated method: This will be removed in a future release, please migrate away from it as soon as possible.
     */
    @Deprecated
    public GetTemplateListResponse list(
            TemplateType templateType) throws Exception {
        GetTemplateListRequest request =
            GetTemplateListRequest
                .builder()
                .templateType(templateType)
                .build();
        
        String _baseUrl = this.sdkConfiguration.serverUrl;
        String _url = Utils.generateURL(
                GetTemplateListRequest.class,
                _baseUrl,
                "/templates/{template_type}",
                request, null);
        
        HTTPRequest _req = new HTTPRequest(_url, "GET");
        _req.addHeader("Accept", "application/json")
            .addHeader("user-agent", 
                SDKConfiguration.USER_AGENT);

        Utils.configureSecurity(_req,  
                this.sdkConfiguration.securitySource.getSecurity());

        HTTPClient _client = this.sdkConfiguration.defaultClient;
        HttpRequest _r = 
            sdkConfiguration.hooks()
               .beforeRequest(
                  new BeforeRequestContextImpl(
                      "GetTemplateList", 
                      Optional.of(List.of()), 
                      sdkConfiguration.securitySource()),
                  _req.build());
        HttpResponse<InputStream> _httpRes;
        try {
            _httpRes = _client.send(_r);
            if (Utils.statusCodeMatches(_httpRes.statusCode(), "400", "401", "422", "4XX", "5XX")) {
                _httpRes = sdkConfiguration.hooks()
                    .afterError(
                        new AfterErrorContextImpl(
                            "GetTemplateList",
                            Optional.of(List.of()),
                            sdkConfiguration.securitySource()),
                        Optional.of(_httpRes),
                        Optional.empty());
            } else {
                _httpRes = sdkConfiguration.hooks()
                    .afterSuccess(
                        new AfterSuccessContextImpl(
                            "GetTemplateList",
                            Optional.of(List.of()), 
                            sdkConfiguration.securitySource()),
                         _httpRes);
            }
        } catch (Exception _e) {
            _httpRes = sdkConfiguration.hooks()
                    .afterError(
                        new AfterErrorContextImpl(
                            "GetTemplateList",
                            Optional.of(List.of()),
                            sdkConfiguration.securitySource()), 
                        Optional.empty(),
                        Optional.of(_e));
        }
        String _contentType = _httpRes
            .headers()
            .firstValue("Content-Type")
            .orElse("application/octet-stream");
        GetTemplateListResponse.Builder _resBuilder = 
            GetTemplateListResponse
                .builder()
                .contentType(_contentType)
                .statusCode(_httpRes.statusCode())
                .rawResponse(_httpRes);

        GetTemplateListResponse _res = _resBuilder.build();
        
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "200")) {
            if (Utils.contentTypeMatches(_contentType, "application/json")) {
                List<Template> _out = Utils.mapper().readValue(
                    Utils.toUtf8AndClose(_httpRes.body()),
                    new TypeReference<List<Template>>() {});
                _res.withTemplateList(Optional.ofNullable(_out));
                return _res;
            } else {
                throw new SDKError(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "Unexpected content-type received: " + _contentType, 
                    Utils.extractByteArrayFromBody(_httpRes));
            }
        }
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "400", "401", "422")) {
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
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "4XX", "5XX")) {
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
     * Revert a template
     * Reverts an updated template to its default state
     * @return The call builder
     * @deprecated method: This will be removed in a future release, please migrate away from it as soon as possible.
     */
    @Deprecated
    public RevertTemplateRequestBuilder revert() {
        return new RevertTemplateRequestBuilder(this);
    }

    /**
     * Revert a template
     * Reverts an updated template to its default state
     * @param templateType The type of template to revert
     * @param slug The slug of the template to revert
     * @return The response from the API call
     * @throws Exception if the API call fails
     * @deprecated method: This will be removed in a future release, please migrate away from it as soon as possible.
     */
    @Deprecated
    public RevertTemplateResponse revert(
            RevertTemplatePathParamTemplateType templateType,
            String slug) throws Exception {
        RevertTemplateRequest request =
            RevertTemplateRequest
                .builder()
                .templateType(templateType)
                .slug(slug)
                .build();
        
        String _baseUrl = this.sdkConfiguration.serverUrl;
        String _url = Utils.generateURL(
                RevertTemplateRequest.class,
                _baseUrl,
                "/templates/{template_type}/{slug}/revert",
                request, null);
        
        HTTPRequest _req = new HTTPRequest(_url, "POST");
        _req.addHeader("Accept", "application/json")
            .addHeader("user-agent", 
                SDKConfiguration.USER_AGENT);

        Utils.configureSecurity(_req,  
                this.sdkConfiguration.securitySource.getSecurity());

        HTTPClient _client = this.sdkConfiguration.defaultClient;
        HttpRequest _r = 
            sdkConfiguration.hooks()
               .beforeRequest(
                  new BeforeRequestContextImpl(
                      "RevertTemplate", 
                      Optional.of(List.of()), 
                      sdkConfiguration.securitySource()),
                  _req.build());
        HttpResponse<InputStream> _httpRes;
        try {
            _httpRes = _client.send(_r);
            if (Utils.statusCodeMatches(_httpRes.statusCode(), "400", "401", "402", "404", "4XX", "5XX")) {
                _httpRes = sdkConfiguration.hooks()
                    .afterError(
                        new AfterErrorContextImpl(
                            "RevertTemplate",
                            Optional.of(List.of()),
                            sdkConfiguration.securitySource()),
                        Optional.of(_httpRes),
                        Optional.empty());
            } else {
                _httpRes = sdkConfiguration.hooks()
                    .afterSuccess(
                        new AfterSuccessContextImpl(
                            "RevertTemplate",
                            Optional.of(List.of()), 
                            sdkConfiguration.securitySource()),
                         _httpRes);
            }
        } catch (Exception _e) {
            _httpRes = sdkConfiguration.hooks()
                    .afterError(
                        new AfterErrorContextImpl(
                            "RevertTemplate",
                            Optional.of(List.of()),
                            sdkConfiguration.securitySource()), 
                        Optional.empty(),
                        Optional.of(_e));
        }
        String _contentType = _httpRes
            .headers()
            .firstValue("Content-Type")
            .orElse("application/octet-stream");
        RevertTemplateResponse.Builder _resBuilder = 
            RevertTemplateResponse
                .builder()
                .contentType(_contentType)
                .statusCode(_httpRes.statusCode())
                .rawResponse(_httpRes);

        RevertTemplateResponse _res = _resBuilder.build();
        
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "200")) {
            if (Utils.contentTypeMatches(_contentType, "application/json")) {
                Template _out = Utils.mapper().readValue(
                    Utils.toUtf8AndClose(_httpRes.body()),
                    new TypeReference<Template>() {});
                _res.withTemplate(Optional.ofNullable(_out));
                return _res;
            } else {
                throw new SDKError(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "Unexpected content-type received: " + _contentType, 
                    Utils.extractByteArrayFromBody(_httpRes));
            }
        }
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "400", "401", "402", "404")) {
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
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "4XX", "5XX")) {
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
     * Retrieve a template
     * Returns the details of a template
     * @return The call builder
     * @deprecated method: This will be removed in a future release, please migrate away from it as soon as possible.
     */
    @Deprecated
    public GetTemplateRequestBuilder get() {
        return new GetTemplateRequestBuilder(this);
    }

    /**
     * Retrieve a template
     * Returns the details of a template
     * @param templateType The type of templates to retrieve (email or SMS)
     * @param slug The slug (i.e. machine-friendly name) of the template to retrieve
     * @return The response from the API call
     * @throws Exception if the API call fails
     * @deprecated method: This will be removed in a future release, please migrate away from it as soon as possible.
     */
    @Deprecated
    public GetTemplateResponse get(
            PathParamTemplateType templateType,
            String slug) throws Exception {
        GetTemplateRequest request =
            GetTemplateRequest
                .builder()
                .templateType(templateType)
                .slug(slug)
                .build();
        
        String _baseUrl = this.sdkConfiguration.serverUrl;
        String _url = Utils.generateURL(
                GetTemplateRequest.class,
                _baseUrl,
                "/templates/{template_type}/{slug}",
                request, null);
        
        HTTPRequest _req = new HTTPRequest(_url, "GET");
        _req.addHeader("Accept", "application/json")
            .addHeader("user-agent", 
                SDKConfiguration.USER_AGENT);

        Utils.configureSecurity(_req,  
                this.sdkConfiguration.securitySource.getSecurity());

        HTTPClient _client = this.sdkConfiguration.defaultClient;
        HttpRequest _r = 
            sdkConfiguration.hooks()
               .beforeRequest(
                  new BeforeRequestContextImpl(
                      "GetTemplate", 
                      Optional.of(List.of()), 
                      sdkConfiguration.securitySource()),
                  _req.build());
        HttpResponse<InputStream> _httpRes;
        try {
            _httpRes = _client.send(_r);
            if (Utils.statusCodeMatches(_httpRes.statusCode(), "400", "401", "404", "4XX", "5XX")) {
                _httpRes = sdkConfiguration.hooks()
                    .afterError(
                        new AfterErrorContextImpl(
                            "GetTemplate",
                            Optional.of(List.of()),
                            sdkConfiguration.securitySource()),
                        Optional.of(_httpRes),
                        Optional.empty());
            } else {
                _httpRes = sdkConfiguration.hooks()
                    .afterSuccess(
                        new AfterSuccessContextImpl(
                            "GetTemplate",
                            Optional.of(List.of()), 
                            sdkConfiguration.securitySource()),
                         _httpRes);
            }
        } catch (Exception _e) {
            _httpRes = sdkConfiguration.hooks()
                    .afterError(
                        new AfterErrorContextImpl(
                            "GetTemplate",
                            Optional.of(List.of()),
                            sdkConfiguration.securitySource()), 
                        Optional.empty(),
                        Optional.of(_e));
        }
        String _contentType = _httpRes
            .headers()
            .firstValue("Content-Type")
            .orElse("application/octet-stream");
        GetTemplateResponse.Builder _resBuilder = 
            GetTemplateResponse
                .builder()
                .contentType(_contentType)
                .statusCode(_httpRes.statusCode())
                .rawResponse(_httpRes);

        GetTemplateResponse _res = _resBuilder.build();
        
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "200")) {
            if (Utils.contentTypeMatches(_contentType, "application/json")) {
                Template _out = Utils.mapper().readValue(
                    Utils.toUtf8AndClose(_httpRes.body()),
                    new TypeReference<Template>() {});
                _res.withTemplate(Optional.ofNullable(_out));
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
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "4XX", "5XX")) {
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
     * Toggle the delivery by Clerk for a template of a given type and slug
     * Toggles the delivery by Clerk for a template of a given type and slug.
     * If disabled, Clerk will not deliver the resulting email or SMS.
     * The app developer will need to listen to the `email.created` or `sms.created` webhooks in order to handle delivery themselves.
     * @return The call builder
     * @deprecated method: This will be removed in a future release, please migrate away from it as soon as possible.
     */
    @Deprecated
    public ToggleTemplateDeliveryRequestBuilder toggleTemplateDelivery() {
        return new ToggleTemplateDeliveryRequestBuilder(this);
    }

    /**
     * Toggle the delivery by Clerk for a template of a given type and slug
     * Toggles the delivery by Clerk for a template of a given type and slug.
     * If disabled, Clerk will not deliver the resulting email or SMS.
     * The app developer will need to listen to the `email.created` or `sms.created` webhooks in order to handle delivery themselves.
     * @param templateType The type of template to toggle delivery for
     * @param slug The slug of the template for which to toggle delivery
     * @return The response from the API call
     * @throws Exception if the API call fails
     * @deprecated method: This will be removed in a future release, please migrate away from it as soon as possible.
     */
    @Deprecated
    public ToggleTemplateDeliveryResponse toggleTemplateDelivery(
            ToggleTemplateDeliveryPathParamTemplateType templateType,
            String slug) throws Exception {
        return toggleTemplateDelivery(templateType, slug, Optional.empty());
    }
    
    /**
     * Toggle the delivery by Clerk for a template of a given type and slug
     * Toggles the delivery by Clerk for a template of a given type and slug.
     * If disabled, Clerk will not deliver the resulting email or SMS.
     * The app developer will need to listen to the `email.created` or `sms.created` webhooks in order to handle delivery themselves.
     * @param templateType The type of template to toggle delivery for
     * @param slug The slug of the template for which to toggle delivery
     * @param requestBody
     * @return The response from the API call
     * @throws Exception if the API call fails
     * @deprecated method: This will be removed in a future release, please migrate away from it as soon as possible.
     */
    @Deprecated
    public ToggleTemplateDeliveryResponse toggleTemplateDelivery(
            ToggleTemplateDeliveryPathParamTemplateType templateType,
            String slug,
            Optional<? extends ToggleTemplateDeliveryRequestBody> requestBody) throws Exception {
        ToggleTemplateDeliveryRequest request =
            ToggleTemplateDeliveryRequest
                .builder()
                .templateType(templateType)
                .slug(slug)
                .requestBody(requestBody)
                .build();
        
        String _baseUrl = this.sdkConfiguration.serverUrl;
        String _url = Utils.generateURL(
                ToggleTemplateDeliveryRequest.class,
                _baseUrl,
                "/templates/{template_type}/{slug}/toggle_delivery",
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
        _req.setBody(Optional.ofNullable(_serializedRequestBody));
        _req.addHeader("Accept", "application/json")
            .addHeader("user-agent", 
                SDKConfiguration.USER_AGENT);

        Utils.configureSecurity(_req,  
                this.sdkConfiguration.securitySource.getSecurity());

        HTTPClient _client = this.sdkConfiguration.defaultClient;
        HttpRequest _r = 
            sdkConfiguration.hooks()
               .beforeRequest(
                  new BeforeRequestContextImpl(
                      "ToggleTemplateDelivery", 
                      Optional.of(List.of()), 
                      sdkConfiguration.securitySource()),
                  _req.build());
        HttpResponse<InputStream> _httpRes;
        try {
            _httpRes = _client.send(_r);
            if (Utils.statusCodeMatches(_httpRes.statusCode(), "400", "401", "404", "4XX", "5XX")) {
                _httpRes = sdkConfiguration.hooks()
                    .afterError(
                        new AfterErrorContextImpl(
                            "ToggleTemplateDelivery",
                            Optional.of(List.of()),
                            sdkConfiguration.securitySource()),
                        Optional.of(_httpRes),
                        Optional.empty());
            } else {
                _httpRes = sdkConfiguration.hooks()
                    .afterSuccess(
                        new AfterSuccessContextImpl(
                            "ToggleTemplateDelivery",
                            Optional.of(List.of()), 
                            sdkConfiguration.securitySource()),
                         _httpRes);
            }
        } catch (Exception _e) {
            _httpRes = sdkConfiguration.hooks()
                    .afterError(
                        new AfterErrorContextImpl(
                            "ToggleTemplateDelivery",
                            Optional.of(List.of()),
                            sdkConfiguration.securitySource()), 
                        Optional.empty(),
                        Optional.of(_e));
        }
        String _contentType = _httpRes
            .headers()
            .firstValue("Content-Type")
            .orElse("application/octet-stream");
        ToggleTemplateDeliveryResponse.Builder _resBuilder = 
            ToggleTemplateDeliveryResponse
                .builder()
                .contentType(_contentType)
                .statusCode(_httpRes.statusCode())
                .rawResponse(_httpRes);

        ToggleTemplateDeliveryResponse _res = _resBuilder.build();
        
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "200")) {
            if (Utils.contentTypeMatches(_contentType, "application/json")) {
                Template _out = Utils.mapper().readValue(
                    Utils.toUtf8AndClose(_httpRes.body()),
                    new TypeReference<Template>() {});
                _res.withTemplate(Optional.ofNullable(_out));
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
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "4XX", "5XX")) {
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
