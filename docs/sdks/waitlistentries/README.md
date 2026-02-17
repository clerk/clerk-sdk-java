# WaitlistEntries

## Overview

### Available Operations

* [list](#list) - List all waitlist entries
* [create](#create) - Create a waitlist entry
* [bulkCreate](#bulkcreate) - Create multiple waitlist entries
* [delete](#delete) - Delete a pending waitlist entry
* [invite](#invite) - Invite a waitlist entry
* [reject](#reject) - Reject a waitlist entry

## list

Retrieve a list of waitlist entries for the instance.
Entries are ordered by creation date in descending order by default.
Supports filtering by email address or status and pagination with limit and offset parameters.

### Example Usage

<!-- UsageSnippet language="java" operationID="ListWaitlistEntries" method="get" path="/waitlist_entries" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.operations.ListWaitlistEntriesRequest;
import com.clerk.backend_api.models.operations.ListWaitlistEntriesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
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

<!-- UsageSnippet language="java" operationID="CreateWaitlistEntry" method="post" path="/waitlist_entries" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CreateWaitlistEntryResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        CreateWaitlistEntryResponse res = sdk.waitlistEntries().create()
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

## bulkCreate

Creates multiple waitlist entries for the provided email addresses.
You can choose whether to send confirmation emails by setting the `notify` parameter to `true` or `false` for each entry.
If the `notify` parameter is omitted, it defaults to `true`.

If an email address is already on the waitlist, no new entry will be created and the existing waitlist entry will be returned.
Duplicate email addresses within the same request are not allowed.

This endpoint is limited to a maximum of 50 entries per API call. If you need to add more entries, please make multiple requests.

### Example Usage

<!-- UsageSnippet language="java" operationID="CreateBulkWaitlistEntries" method="post" path="/waitlist_entries/bulk" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CreateBulkWaitlistEntriesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        CreateBulkWaitlistEntriesResponse res = sdk.waitlistEntries().bulkCreate()
                .call();

        if (res.waitlistEntryList().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                       | Type                                                            | Required                                                        | Description                                                     |
| --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- |
| `request`                                                       | [List<CreateBulkWaitlistEntriesRequestBody>](../../models//.md) | :heavy_check_mark:                                              | The request object to use for the request.                      |

### Response

**[CreateBulkWaitlistEntriesResponse](../../models/operations/CreateBulkWaitlistEntriesResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 422                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## delete

Delete a pending waitlist entry.

### Example Usage

<!-- UsageSnippet language="java" operationID="DeleteWaitlistEntry" method="delete" path="/waitlist_entries/{waitlist_entry_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.DeleteWaitlistEntryResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        DeleteWaitlistEntryResponse res = sdk.waitlistEntries().delete()
                .waitlistEntryId("<id>")
                .call();

        if (res.deletedObject().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                              | Type                                   | Required                               | Description                            |
| -------------------------------------- | -------------------------------------- | -------------------------------------- | -------------------------------------- |
| `waitlistEntryId`                      | *String*                               | :heavy_check_mark:                     | The ID of the waitlist entry to delete |

### Response

**[DeleteWaitlistEntryResponse](../../models/operations/DeleteWaitlistEntryResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 404, 409, 422        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## invite

Send an invite to the email address in a waitlist entry.

### Example Usage

<!-- UsageSnippet language="java" operationID="InviteWaitlistEntry" method="post" path="/waitlist_entries/{waitlist_entry_id}/invite" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.InviteWaitlistEntryResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        InviteWaitlistEntryResponse res = sdk.waitlistEntries().invite()
                .waitlistEntryId("<id>")
                .call();

        if (res.waitlistEntry().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                              | Type                                                                                                   | Required                                                                                               | Description                                                                                            |
| ------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------ |
| `waitlistEntryId`                                                                                      | *String*                                                                                               | :heavy_check_mark:                                                                                     | The ID of the waitlist entry to invite                                                                 |
| `requestBody`                                                                                          | [Optional\<InviteWaitlistEntryRequestBody>](../../models/operations/InviteWaitlistEntryRequestBody.md) | :heavy_minus_sign:                                                                                     | N/A                                                                                                    |

### Response

**[InviteWaitlistEntryResponse](../../models/operations/InviteWaitlistEntryResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 404, 409, 422        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## reject

Reject a waitlist entry.

### Example Usage

<!-- UsageSnippet language="java" operationID="RejectWaitlistEntry" method="post" path="/waitlist_entries/{waitlist_entry_id}/reject" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.RejectWaitlistEntryResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        RejectWaitlistEntryResponse res = sdk.waitlistEntries().reject()
                .waitlistEntryId("<id>")
                .call();

        if (res.waitlistEntry().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                              | Type                                   | Required                               | Description                            |
| -------------------------------------- | -------------------------------------- | -------------------------------------- | -------------------------------------- |
| `waitlistEntryId`                      | *String*                               | :heavy_check_mark:                     | The ID of the waitlist entry to reject |

### Response

**[RejectWaitlistEntryResponse](../../models/operations/RejectWaitlistEntryResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 404, 409, 422        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |