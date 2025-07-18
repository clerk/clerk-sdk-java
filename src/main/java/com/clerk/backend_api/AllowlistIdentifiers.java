/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api;

import static com.clerk.backend_api.operations.Operations.RequestOperation;

import com.clerk.backend_api.models.operations.CreateAllowlistIdentifierRequestBody;
import com.clerk.backend_api.models.operations.CreateAllowlistIdentifierRequestBuilder;
import com.clerk.backend_api.models.operations.CreateAllowlistIdentifierResponse;
import com.clerk.backend_api.models.operations.DeleteAllowlistIdentifierRequest;
import com.clerk.backend_api.models.operations.DeleteAllowlistIdentifierRequestBuilder;
import com.clerk.backend_api.models.operations.DeleteAllowlistIdentifierResponse;
import com.clerk.backend_api.models.operations.ListAllowlistIdentifiersRequest;
import com.clerk.backend_api.models.operations.ListAllowlistIdentifiersRequestBuilder;
import com.clerk.backend_api.models.operations.ListAllowlistIdentifiersResponse;
import com.clerk.backend_api.operations.CreateAllowlistIdentifierOperation;
import com.clerk.backend_api.operations.DeleteAllowlistIdentifierOperation;
import com.clerk.backend_api.operations.ListAllowlistIdentifiersOperation;
import com.clerk.backend_api.utils.Options;
import java.lang.Boolean;
import java.lang.Exception;
import java.lang.Long;
import java.lang.String;
import java.util.List;
import java.util.Optional;


public class AllowlistIdentifiers {
    private final SDKConfiguration sdkConfiguration;

    AllowlistIdentifiers(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }
    /**
     * List all identifiers on the allow-list
     * 
     * <p>Get a list of all identifiers allowed to sign up to an instance
     * 
     * @return The call builder
     */
    public ListAllowlistIdentifiersRequestBuilder list() {
        return new ListAllowlistIdentifiersRequestBuilder(sdkConfiguration);
    }

    /**
     * List all identifiers on the allow-list
     * 
     * <p>Get a list of all identifiers allowed to sign up to an instance
     * 
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public ListAllowlistIdentifiersResponse listDirect() throws Exception {
        return list(Optional.empty(), Optional.empty(), Optional.empty(),
            Optional.empty());
    }

    /**
     * List all identifiers on the allow-list
     * 
     * <p>Get a list of all identifiers allowed to sign up to an instance
     * 
     * @param paginated Whether to paginate the results.
     *         If true, the results will be paginated.
     *         If false, the results will not be paginated.
     * @param limit Applies a limit to the number of results returned.
     *         Can be used for paginating the results together with `offset`.
     * @param offset Skip the first `offset` results when paginating.
     *         Needs to be an integer greater or equal to zero.
     *         To be used in conjunction with `limit`.
     * @param options additional options
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public ListAllowlistIdentifiersResponse list(
            Optional<Boolean> paginated,
            Optional<Long> limit,
            Optional<Long> offset,
            Optional<Options> options) throws Exception {
        ListAllowlistIdentifiersRequest request =
            ListAllowlistIdentifiersRequest
                .builder()
                .paginated(paginated)
                .limit(limit)
                .offset(offset)
                .build();
        RequestOperation<ListAllowlistIdentifiersRequest, ListAllowlistIdentifiersResponse> operation
              = new ListAllowlistIdentifiersOperation(
                sdkConfiguration,
                options);
        return operation.handleResponse(operation.doRequest(request));
    }

    /**
     * Add identifier to the allow-list
     * 
     * <p>Create an identifier allowed to sign up to an instance
     * 
     * @return The call builder
     */
    public CreateAllowlistIdentifierRequestBuilder create() {
        return new CreateAllowlistIdentifierRequestBuilder(sdkConfiguration);
    }

    /**
     * Add identifier to the allow-list
     * 
     * <p>Create an identifier allowed to sign up to an instance
     * 
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public CreateAllowlistIdentifierResponse createDirect() throws Exception {
        return create(Optional.empty(), Optional.empty());
    }

    /**
     * Add identifier to the allow-list
     * 
     * <p>Create an identifier allowed to sign up to an instance
     * 
     * @param request The request object containing all the parameters for the API call.
     * @param options additional options
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public CreateAllowlistIdentifierResponse create(
            Optional<? extends CreateAllowlistIdentifierRequestBody> request,
            Optional<Options> options) throws Exception {
        RequestOperation<Optional<? extends CreateAllowlistIdentifierRequestBody>, CreateAllowlistIdentifierResponse> operation
              = new CreateAllowlistIdentifierOperation(
                sdkConfiguration,
                options);
        return operation.handleResponse(operation.doRequest(request));
    }

    /**
     * Delete identifier from allow-list
     * 
     * <p>Delete an identifier from the instance allow-list
     * 
     * @return The call builder
     */
    public DeleteAllowlistIdentifierRequestBuilder delete() {
        return new DeleteAllowlistIdentifierRequestBuilder(sdkConfiguration);
    }

    /**
     * Delete identifier from allow-list
     * 
     * <p>Delete an identifier from the instance allow-list
     * 
     * @param identifierId The ID of the identifier to delete from the allow-list
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public DeleteAllowlistIdentifierResponse delete(String identifierId) throws Exception {
        return delete(identifierId, Optional.empty());
    }

    /**
     * Delete identifier from allow-list
     * 
     * <p>Delete an identifier from the instance allow-list
     * 
     * @param identifierId The ID of the identifier to delete from the allow-list
     * @param options additional options
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public DeleteAllowlistIdentifierResponse delete(
            String identifierId,
            Optional<Options> options) throws Exception {
        DeleteAllowlistIdentifierRequest request =
            DeleteAllowlistIdentifierRequest
                .builder()
                .identifierId(identifierId)
                .build();
        RequestOperation<DeleteAllowlistIdentifierRequest, DeleteAllowlistIdentifierResponse> operation
              = new DeleteAllowlistIdentifierOperation(
                sdkConfiguration,
                options);
        return operation.handleResponse(operation.doRequest(request));
    }

}
