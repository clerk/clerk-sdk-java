/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api;

import static com.clerk.backend_api.operations.Operations.RequestlessOperation;
import static com.clerk.backend_api.operations.Operations.RequestOperation;

import com.clerk.backend_api.models.operations.CreateBlocklistIdentifierRequestBody;
import com.clerk.backend_api.models.operations.CreateBlocklistIdentifierRequestBuilder;
import com.clerk.backend_api.models.operations.CreateBlocklistIdentifierResponse;
import com.clerk.backend_api.models.operations.DeleteBlocklistIdentifierRequest;
import com.clerk.backend_api.models.operations.DeleteBlocklistIdentifierRequestBuilder;
import com.clerk.backend_api.models.operations.DeleteBlocklistIdentifierResponse;
import com.clerk.backend_api.models.operations.ListBlocklistIdentifiersRequestBuilder;
import com.clerk.backend_api.models.operations.ListBlocklistIdentifiersResponse;
import com.clerk.backend_api.operations.CreateBlocklistIdentifierOperation;
import com.clerk.backend_api.operations.DeleteBlocklistIdentifierOperation;
import com.clerk.backend_api.operations.ListBlocklistIdentifiersOperation;
import com.clerk.backend_api.utils.Options;
import java.lang.Exception;
import java.lang.String;
import java.util.List;
import java.util.Optional;


public class BlocklistIdentifiers {
    private final SDKConfiguration sdkConfiguration;

    BlocklistIdentifiers(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }
    /**
     * List all identifiers on the block-list
     * 
     * <p>Get a list of all identifiers which are not allowed to access an instance
     * 
     * @return The call builder
     */
    public ListBlocklistIdentifiersRequestBuilder list() {
        return new ListBlocklistIdentifiersRequestBuilder(sdkConfiguration);
    }

    /**
     * List all identifiers on the block-list
     * 
     * <p>Get a list of all identifiers which are not allowed to access an instance
     * 
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public ListBlocklistIdentifiersResponse listDirect() throws Exception {
        return list(Optional.empty());
    }

    /**
     * List all identifiers on the block-list
     * 
     * <p>Get a list of all identifiers which are not allowed to access an instance
     * 
     * @param options additional options
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public ListBlocklistIdentifiersResponse list(Optional<Options> options) throws Exception {
        RequestlessOperation<ListBlocklistIdentifiersResponse> operation
            = new ListBlocklistIdentifiersOperation(
                sdkConfiguration,
                options);
        return operation.handleResponse(operation.doRequest());
    }

    /**
     * Add identifier to the block-list
     * 
     * <p>Create an identifier that is blocked from accessing an instance
     * 
     * @return The call builder
     */
    public CreateBlocklistIdentifierRequestBuilder create() {
        return new CreateBlocklistIdentifierRequestBuilder(sdkConfiguration);
    }

    /**
     * Add identifier to the block-list
     * 
     * <p>Create an identifier that is blocked from accessing an instance
     * 
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public CreateBlocklistIdentifierResponse createDirect() throws Exception {
        return create(Optional.empty(), Optional.empty());
    }

    /**
     * Add identifier to the block-list
     * 
     * <p>Create an identifier that is blocked from accessing an instance
     * 
     * @param request The request object containing all the parameters for the API call.
     * @param options additional options
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public CreateBlocklistIdentifierResponse create(
            Optional<? extends CreateBlocklistIdentifierRequestBody> request,
            Optional<Options> options) throws Exception {
        RequestOperation<Optional<? extends CreateBlocklistIdentifierRequestBody>, CreateBlocklistIdentifierResponse> operation
              = new CreateBlocklistIdentifierOperation(
                sdkConfiguration,
                options);
        return operation.handleResponse(operation.doRequest(request));
    }

    /**
     * Delete identifier from block-list
     * 
     * <p>Delete an identifier from the instance block-list
     * 
     * @return The call builder
     */
    public DeleteBlocklistIdentifierRequestBuilder delete() {
        return new DeleteBlocklistIdentifierRequestBuilder(sdkConfiguration);
    }

    /**
     * Delete identifier from block-list
     * 
     * <p>Delete an identifier from the instance block-list
     * 
     * @param identifierId The ID of the identifier to delete from the block-list
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public DeleteBlocklistIdentifierResponse delete(String identifierId) throws Exception {
        return delete(identifierId, Optional.empty());
    }

    /**
     * Delete identifier from block-list
     * 
     * <p>Delete an identifier from the instance block-list
     * 
     * @param identifierId The ID of the identifier to delete from the block-list
     * @param options additional options
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public DeleteBlocklistIdentifierResponse delete(
            String identifierId,
            Optional<Options> options) throws Exception {
        DeleteBlocklistIdentifierRequest request =
            DeleteBlocklistIdentifierRequest
                .builder()
                .identifierId(identifierId)
                .build();
        RequestOperation<DeleteBlocklistIdentifierRequest, DeleteBlocklistIdentifierResponse> operation
              = new DeleteBlocklistIdentifierOperation(
                sdkConfiguration,
                options);
        return operation.handleResponse(operation.doRequest(request));
    }

}
