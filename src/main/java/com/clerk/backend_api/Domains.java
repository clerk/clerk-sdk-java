/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api;

import static com.clerk.backend_api.operations.Operations.RequestlessOperation;
import static com.clerk.backend_api.operations.Operations.RequestOperation;

import com.clerk.backend_api.models.operations.AddDomainRequestBody;
import com.clerk.backend_api.models.operations.AddDomainRequestBuilder;
import com.clerk.backend_api.models.operations.AddDomainResponse;
import com.clerk.backend_api.models.operations.DeleteDomainRequest;
import com.clerk.backend_api.models.operations.DeleteDomainRequestBuilder;
import com.clerk.backend_api.models.operations.DeleteDomainResponse;
import com.clerk.backend_api.models.operations.ListDomainsRequestBuilder;
import com.clerk.backend_api.models.operations.ListDomainsResponse;
import com.clerk.backend_api.models.operations.UpdateDomainRequest;
import com.clerk.backend_api.models.operations.UpdateDomainRequestBody;
import com.clerk.backend_api.models.operations.UpdateDomainRequestBuilder;
import com.clerk.backend_api.models.operations.UpdateDomainResponse;
import com.clerk.backend_api.operations.AddDomainOperation;
import com.clerk.backend_api.operations.DeleteDomainOperation;
import com.clerk.backend_api.operations.ListDomainsOperation;
import com.clerk.backend_api.operations.UpdateDomainOperation;
import com.clerk.backend_api.utils.Options;
import java.lang.Exception;
import java.lang.String;
import java.util.List;
import java.util.Optional;


public class Domains {
    private final SDKConfiguration sdkConfiguration;

    Domains(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }
    /**
     * List all instance domains
     * 
     * <p>Use this endpoint to get a list of all domains for an instance.
     * The response will contain the primary domain for the instance and any satellite domains. Each domain in the response contains information about the URLs where Clerk operates and the required CNAME targets.
     * 
     * @return The call builder
     */
    public ListDomainsRequestBuilder list() {
        return new ListDomainsRequestBuilder(sdkConfiguration);
    }

    /**
     * List all instance domains
     * 
     * <p>Use this endpoint to get a list of all domains for an instance.
     * The response will contain the primary domain for the instance and any satellite domains. Each domain in the response contains information about the URLs where Clerk operates and the required CNAME targets.
     * 
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public ListDomainsResponse listDirect() throws Exception {
        return list(Optional.empty());
    }

    /**
     * List all instance domains
     * 
     * <p>Use this endpoint to get a list of all domains for an instance.
     * The response will contain the primary domain for the instance and any satellite domains. Each domain in the response contains information about the URLs where Clerk operates and the required CNAME targets.
     * 
     * @param options additional options
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public ListDomainsResponse list(Optional<Options> options) throws Exception {
        RequestlessOperation<ListDomainsResponse> operation
            = new ListDomainsOperation(
                sdkConfiguration,
                options);
        return operation.handleResponse(operation.doRequest());
    }

    /**
     * Add a domain
     * 
     * <p>Add a new domain for your instance.
     * Useful in the case of multi-domain instances, allows adding satellite domains to an instance.
     * The new domain must have a `name`. The domain name can contain the port for development instances, like `localhost:3000`.
     * At the moment, instances can have only one primary domain, so the `is_satellite` parameter must be set to `true`.
     * If you're planning to configure the new satellite domain to run behind a proxy, pass the `proxy_url` parameter accordingly.
     * 
     * @return The call builder
     */
    public AddDomainRequestBuilder add() {
        return new AddDomainRequestBuilder(sdkConfiguration);
    }

    /**
     * Add a domain
     * 
     * <p>Add a new domain for your instance.
     * Useful in the case of multi-domain instances, allows adding satellite domains to an instance.
     * The new domain must have a `name`. The domain name can contain the port for development instances, like `localhost:3000`.
     * At the moment, instances can have only one primary domain, so the `is_satellite` parameter must be set to `true`.
     * If you're planning to configure the new satellite domain to run behind a proxy, pass the `proxy_url` parameter accordingly.
     * 
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public AddDomainResponse addDirect() throws Exception {
        return add(Optional.empty(), Optional.empty());
    }

    /**
     * Add a domain
     * 
     * <p>Add a new domain for your instance.
     * Useful in the case of multi-domain instances, allows adding satellite domains to an instance.
     * The new domain must have a `name`. The domain name can contain the port for development instances, like `localhost:3000`.
     * At the moment, instances can have only one primary domain, so the `is_satellite` parameter must be set to `true`.
     * If you're planning to configure the new satellite domain to run behind a proxy, pass the `proxy_url` parameter accordingly.
     * 
     * @param request The request object containing all the parameters for the API call.
     * @param options additional options
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public AddDomainResponse add(
            Optional<? extends AddDomainRequestBody> request,
            Optional<Options> options) throws Exception {
        RequestOperation<Optional<? extends AddDomainRequestBody>, AddDomainResponse> operation
              = new AddDomainOperation(
                sdkConfiguration,
                options);
        return operation.handleResponse(operation.doRequest(request));
    }

    /**
     * Delete a satellite domain
     * 
     * <p>Deletes a satellite domain for the instance.
     * It is currently not possible to delete the instance's primary domain.
     * 
     * @return The call builder
     */
    public DeleteDomainRequestBuilder delete() {
        return new DeleteDomainRequestBuilder(sdkConfiguration);
    }

    /**
     * Delete a satellite domain
     * 
     * <p>Deletes a satellite domain for the instance.
     * It is currently not possible to delete the instance's primary domain.
     * 
     * @param domainId The ID of the domain that will be deleted. Must be a satellite domain.
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public DeleteDomainResponse delete(String domainId) throws Exception {
        return delete(domainId, Optional.empty());
    }

    /**
     * Delete a satellite domain
     * 
     * <p>Deletes a satellite domain for the instance.
     * It is currently not possible to delete the instance's primary domain.
     * 
     * @param domainId The ID of the domain that will be deleted. Must be a satellite domain.
     * @param options additional options
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public DeleteDomainResponse delete(
            String domainId,
            Optional<Options> options) throws Exception {
        DeleteDomainRequest request =
            DeleteDomainRequest
                .builder()
                .domainId(domainId)
                .build();
        RequestOperation<DeleteDomainRequest, DeleteDomainResponse> operation
              = new DeleteDomainOperation(
                sdkConfiguration,
                options);
        return operation.handleResponse(operation.doRequest(request));
    }

    /**
     * Update a domain
     * 
     * <p>The `proxy_url` can be updated only for production instances.
     * Update one of the instance's domains. Both primary and satellite domains can be updated.
     * If you choose to use Clerk via proxy, use this endpoint to specify the `proxy_url`.
     * Whenever you decide you'd rather switch to DNS setup for Clerk, simply set `proxy_url`
     * to `null` for the domain. When you update a production instance's primary domain name,
     * you have to make sure that you've completed all the necessary setup steps for DNS and
     * emails to work. Expect downtime otherwise. Updating a primary domain's name will also
     * update the instance's home origin, affecting the default application paths.
     * 
     * @return The call builder
     */
    public UpdateDomainRequestBuilder update() {
        return new UpdateDomainRequestBuilder(sdkConfiguration);
    }

    /**
     * Update a domain
     * 
     * <p>The `proxy_url` can be updated only for production instances.
     * Update one of the instance's domains. Both primary and satellite domains can be updated.
     * If you choose to use Clerk via proxy, use this endpoint to specify the `proxy_url`.
     * Whenever you decide you'd rather switch to DNS setup for Clerk, simply set `proxy_url`
     * to `null` for the domain. When you update a production instance's primary domain name,
     * you have to make sure that you've completed all the necessary setup steps for DNS and
     * emails to work. Expect downtime otherwise. Updating a primary domain's name will also
     * update the instance's home origin, affecting the default application paths.
     * 
     * @param domainId The ID of the domain that will be updated.
     * @param requestBody 
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public UpdateDomainResponse update(
            String domainId,
            UpdateDomainRequestBody requestBody) throws Exception {
        return update(domainId, requestBody, Optional.empty());
    }

    /**
     * Update a domain
     * 
     * <p>The `proxy_url` can be updated only for production instances.
     * Update one of the instance's domains. Both primary and satellite domains can be updated.
     * If you choose to use Clerk via proxy, use this endpoint to specify the `proxy_url`.
     * Whenever you decide you'd rather switch to DNS setup for Clerk, simply set `proxy_url`
     * to `null` for the domain. When you update a production instance's primary domain name,
     * you have to make sure that you've completed all the necessary setup steps for DNS and
     * emails to work. Expect downtime otherwise. Updating a primary domain's name will also
     * update the instance's home origin, affecting the default application paths.
     * 
     * @param domainId The ID of the domain that will be updated.
     * @param requestBody 
     * @param options additional options
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public UpdateDomainResponse update(
            String domainId,
            UpdateDomainRequestBody requestBody,
            Optional<Options> options) throws Exception {
        UpdateDomainRequest request =
            UpdateDomainRequest
                .builder()
                .domainId(domainId)
                .requestBody(requestBody)
                .build();
        RequestOperation<UpdateDomainRequest, UpdateDomainResponse> operation
              = new UpdateDomainOperation(
                sdkConfiguration,
                options);
        return operation.handleResponse(operation.doRequest(request));
    }

}
