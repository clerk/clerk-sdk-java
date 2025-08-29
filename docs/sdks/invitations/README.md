# Invitations
(*invitations()*)

## Overview

### Available Operations

* [create](#create) - Create an invitation
* [list](#list) - List all invitations
* [bulkCreate](#bulkcreate) - Create multiple invitations
* [revoke](#revoke) - Revokes an invitation

## create

Creates a new invitation for the given email address and sends the invitation email.
Keep in mind that you cannot create an invitation if there is already one for the given email address.
Also, trying to create an invitation for an email address that already exists in your application will result to an error.

### Example Usage

<!-- UsageSnippet language="java" operationID="CreateInvitation" method="post" path="/invitations" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CreateInvitationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        CreateInvitationResponse res = sdk.invitations().create()
                .call();

        if (res.invitation().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                             | Type                                                                                  | Required                                                                              | Description                                                                           |
| ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- |
| `request`                                                                             | [CreateInvitationRequestBody](../../models/operations/CreateInvitationRequestBody.md) | :heavy_check_mark:                                                                    | The request object to use for the request.                                            |

### Response

**[CreateInvitationResponse](../../models/operations/CreateInvitationResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 422                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## list

Returns all non-revoked invitations for your application, sorted by creation date

### Example Usage

<!-- UsageSnippet language="java" operationID="ListInvitations" method="get" path="/invitations" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.operations.ListInvitationsRequest;
import com.clerk.backend_api.models.operations.ListInvitationsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        ListInvitationsRequest req = ListInvitationsRequest.builder()
                .build();

        ListInvitationsResponse res = sdk.invitations().list()
                .request(req)
                .call();

        if (res.invitationList().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                   | Type                                                                        | Required                                                                    | Description                                                                 |
| --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- |
| `request`                                                                   | [ListInvitationsRequest](../../models/operations/ListInvitationsRequest.md) | :heavy_check_mark:                                                          | The request object to use for the request.                                  |

### Response

**[ListInvitationsResponse](../../models/operations/ListInvitationsResponse.md)**

### Errors

| Error Type             | Status Code            | Content Type           |
| ---------------------- | ---------------------- | ---------------------- |
| models/errors/SDKError | 4XX, 5XX               | \*/\*                  |

## bulkCreate

Use this API operation to create multiple invitations for the provided email addresses. You can choose to send the
invitations as emails by setting the `notify` parameter to `true`. There cannot be an existing invitation for any
of the email addresses you provide unless you set `ignore_existing` to `true` for specific email addresses. Please
note that there must be no existing user for any of the email addresses you provide, and this rule cannot be bypassed.

### Example Usage

<!-- UsageSnippet language="java" operationID="CreateBulkInvitations" method="post" path="/invitations/bulk" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CreateBulkInvitationsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        CreateBulkInvitationsResponse res = sdk.invitations().bulkCreate()
                .call();

        if (res.invitationList().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                  | Type                                       | Required                                   | Description                                |
| ------------------------------------------ | ------------------------------------------ | ------------------------------------------ | ------------------------------------------ |
| `request`                                  | [List<RequestBody>](../../models//.md)     | :heavy_check_mark:                         | The request object to use for the request. |

### Response

**[CreateBulkInvitationsResponse](../../models/operations/CreateBulkInvitationsResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 422                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## revoke

Revokes the given invitation.
Revoking an invitation will prevent the user from using the invitation link that was sent to them.
However, it doesn't prevent the user from signing up if they follow the sign up flow.
Only active (i.e. non-revoked) invitations can be revoked.

### Example Usage

<!-- UsageSnippet language="java" operationID="RevokeInvitation" method="post" path="/invitations/{invitation_id}/revoke" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.RevokeInvitationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        RevokeInvitationResponse res = sdk.invitations().revoke()
                .invitationId("<id>")
                .call();

        if (res.invitationRevoked().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                              | Type                                   | Required                               | Description                            |
| -------------------------------------- | -------------------------------------- | -------------------------------------- | -------------------------------------- |
| `invitationId`                         | *String*                               | :heavy_check_mark:                     | The ID of the invitation to be revoked |

### Response

**[RevokeInvitationResponse](../../models/operations/RevokeInvitationResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 404                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |