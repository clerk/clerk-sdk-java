# WaitlistEntries
(*waitlistEntries()*)

## Overview

### Available Operations

* [list](#list) - List all waitlist entries
* [create](#create) - Create a waitlist entry

## list

Retrieve a list of waitlist entries for the instance.
Entries are ordered by creation date in descending order by default.
Supports filtering by email address or status and pagination with limit and offset parameters.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.operations.ListWaitlistEntriesRequest;
import com.clerk.backend_api.models.operations.ListWaitlistEntriesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        ListWaitlistEntriesRequest req = ListWaitlistEntriesRequest.builder()
                .build();

        ListWaitlistEntriesResponse res = sdk.waitlistEntries().list()
                .request(req)
                .call();

        if (res.waitlistEntries().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                           | Type                                                                                | Required                                                                            | Description                                                                         |
| ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- |
| `request`                                                                           | [ListWaitlistEntriesRequest](../../models/operations/ListWaitlistEntriesRequest.md) | :heavy_check_mark:                                                                  | The request object to use for the request.                                          |

### Response

**[ListWaitlistEntriesResponse](../../models/operations/ListWaitlistEntriesResponse.md)**

### Errors

| Error Type             | Status Code            | Content Type           |
| ---------------------- | ---------------------- | ---------------------- |
| models/errors/SDKError | 4XX, 5XX               | \*/\*                  |

## create

Creates a new waitlist entry for the given email address.
If the email address is already on the waitlist, no new entry will be created and the existing waitlist entry will be returned.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CreateWaitlistEntryRequestBody;
import com.clerk.backend_api.models.operations.CreateWaitlistEntryResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        CreateWaitlistEntryRequestBody req = CreateWaitlistEntryRequestBody.builder()
                .emailAddress("Loyal79@yahoo.com")
                .build();

        CreateWaitlistEntryResponse res = sdk.waitlistEntries().create()
                .request(req)
                .call();

        if (res.waitlistEntry().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                   | Type                                                                                        | Required                                                                                    | Description                                                                                 |
| ------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------- |
| `request`                                                                                   | [CreateWaitlistEntryRequestBody](../../models/operations/CreateWaitlistEntryRequestBody.md) | :heavy_check_mark:                                                                          | The request object to use for the request.                                                  |

### Response

**[CreateWaitlistEntryResponse](../../models/operations/CreateWaitlistEntryResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 422                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |