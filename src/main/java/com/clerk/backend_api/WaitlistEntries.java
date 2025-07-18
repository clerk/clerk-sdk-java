/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api;

import static com.clerk.backend_api.operations.Operations.RequestOperation;

import com.clerk.backend_api.models.operations.CreateWaitlistEntryRequestBody;
import com.clerk.backend_api.models.operations.CreateWaitlistEntryRequestBuilder;
import com.clerk.backend_api.models.operations.CreateWaitlistEntryResponse;
import com.clerk.backend_api.models.operations.ListWaitlistEntriesRequest;
import com.clerk.backend_api.models.operations.ListWaitlistEntriesRequestBuilder;
import com.clerk.backend_api.models.operations.ListWaitlistEntriesResponse;
import com.clerk.backend_api.operations.CreateWaitlistEntryOperation;
import com.clerk.backend_api.operations.ListWaitlistEntriesOperation;
import com.clerk.backend_api.utils.Options;
import java.lang.Exception;
import java.util.List;
import java.util.Optional;


public class WaitlistEntries {
    private final SDKConfiguration sdkConfiguration;

    WaitlistEntries(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }
    /**
     * List all waitlist entries
     * 
     * <p>Retrieve a list of waitlist entries for the instance.
     * Entries are ordered by creation date in descending order by default.
     * Supports filtering by email address or status and pagination with limit and offset parameters.
     * 
     * @return The call builder
     */
    public ListWaitlistEntriesRequestBuilder list() {
        return new ListWaitlistEntriesRequestBuilder(sdkConfiguration);
    }

    /**
     * List all waitlist entries
     * 
     * <p>Retrieve a list of waitlist entries for the instance.
     * Entries are ordered by creation date in descending order by default.
     * Supports filtering by email address or status and pagination with limit and offset parameters.
     * 
     * @param request The request object containing all the parameters for the API call.
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public ListWaitlistEntriesResponse list(ListWaitlistEntriesRequest request) throws Exception {
        return list(request, Optional.empty());
    }

    /**
     * List all waitlist entries
     * 
     * <p>Retrieve a list of waitlist entries for the instance.
     * Entries are ordered by creation date in descending order by default.
     * Supports filtering by email address or status and pagination with limit and offset parameters.
     * 
     * @param request The request object containing all the parameters for the API call.
     * @param options additional options
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public ListWaitlistEntriesResponse list(
            ListWaitlistEntriesRequest request,
            Optional<Options> options) throws Exception {
        RequestOperation<ListWaitlistEntriesRequest, ListWaitlistEntriesResponse> operation
              = new ListWaitlistEntriesOperation(
                sdkConfiguration,
                options);
        return operation.handleResponse(operation.doRequest(request));
    }

    /**
     * Create a waitlist entry
     * 
     * <p>Creates a new waitlist entry for the given email address.
     * If the email address is already on the waitlist, no new entry will be created and the existing waitlist entry will be returned.
     * 
     * @return The call builder
     */
    public CreateWaitlistEntryRequestBuilder create() {
        return new CreateWaitlistEntryRequestBuilder(sdkConfiguration);
    }

    /**
     * Create a waitlist entry
     * 
     * <p>Creates a new waitlist entry for the given email address.
     * If the email address is already on the waitlist, no new entry will be created and the existing waitlist entry will be returned.
     * 
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public CreateWaitlistEntryResponse createDirect() throws Exception {
        return create(Optional.empty(), Optional.empty());
    }

    /**
     * Create a waitlist entry
     * 
     * <p>Creates a new waitlist entry for the given email address.
     * If the email address is already on the waitlist, no new entry will be created and the existing waitlist entry will be returned.
     * 
     * @param request The request object containing all the parameters for the API call.
     * @param options additional options
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public CreateWaitlistEntryResponse create(
            Optional<? extends CreateWaitlistEntryRequestBody> request,
            Optional<Options> options) throws Exception {
        RequestOperation<Optional<? extends CreateWaitlistEntryRequestBody>, CreateWaitlistEntryResponse> operation
              = new CreateWaitlistEntryOperation(
                sdkConfiguration,
                options);
        return operation.handleResponse(operation.doRequest(request));
    }

}
