# OrganizationInvitations
(*organizationInvitations()*)

## Overview

### Available Operations

* [getAll](#getall) - Get a list of organization invitations for the current instance
* [create](#create) - Create and send an organization invitation
* [list](#list) - Get a list of organization invitations
* [bulkCreate](#bulkcreate) - Bulk create and send organization invitations
* [~~listPending~~](#listpending) - Get a list of pending organization invitations :warning: **Deprecated**
* [get](#get) - Retrieve an organization invitation by ID
* [revoke](#revoke) - Revoke a pending organization invitation

## getAll

This request returns the list of organization invitations for the instance.
Results can be paginated using the optional `limit` and `offset` query parameters.
You can filter them by providing the 'status' query parameter, that accepts multiple values.
You can change the order by providing the 'order' query parameter, that accepts multiple values.
You can filter by the invited user email address providing the `query` query parameter.
The organization invitations are ordered by descending creation date by default.

### Example Usage

<!-- UsageSnippet language="java" operationID="ListInstanceOrganizationInvitations" method="get" path="/organization_invitations" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.ListInstanceOrganizationInvitationsRequest;
import com.clerk.backend_api.models.operations.ListInstanceOrganizationInvitationsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        ListInstanceOrganizationInvitationsRequest req = ListInstanceOrganizationInvitationsRequest.builder()
                .build();

        ListInstanceOrganizationInvitationsResponse res = sdk.organizationInvitations().getAll()
                .request(req)
                .call();

        if (res.organizationInvitationsWithPublicOrganizationData().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                           | Type                                                                                                                | Required                                                                                                            | Description                                                                                                         |
| ------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                           | [ListInstanceOrganizationInvitationsRequest](../../models/operations/ListInstanceOrganizationInvitationsRequest.md) | :heavy_check_mark:                                                                                                  | The request object to use for the request.                                                                          |

### Response

**[ListInstanceOrganizationInvitationsResponse](../../models/operations/ListInstanceOrganizationInvitationsResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 404, 422             | application/json          |
| models/errors/ClerkErrors | 500                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## create

Creates a new organization invitation and sends an email to the provided `email_address` with a link to accept the invitation and join the organization.
You can specify the `role` for the invited organization member.

New organization invitations get a "pending" status until they are revoked by an organization administrator or accepted by the invitee.

The request body supports passing an optional `redirect_url` parameter.
When the invited user clicks the link to accept the invitation, they will be redirected to the URL provided.
Use this parameter to implement a custom invitation acceptance flow.

You can specify the ID of the user that will send the invitation with the `inviter_user_id` parameter.
That user must be a member with administrator privileges in the organization.
Only "admin" members can create organization invitations.

You can optionally provide public and private metadata for the organization invitation.
The public metadata are visible by both the Frontend and the Backend whereas the private ones only by the Backend.
When the organization invitation is accepted, the metadata will be transferred to the newly created organization membership.

### Example Usage

<!-- UsageSnippet language="java" operationID="CreateOrganizationInvitation" method="post" path="/organizations/{organization_id}/invitations" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CreateOrganizationInvitationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        CreateOrganizationInvitationResponse res = sdk.organizationInvitations().create()
                .organizationId("<id>")
                .call();

        if (res.organizationInvitation().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `organizationId`                                                                                                         | *String*                                                                                                                 | :heavy_check_mark:                                                                                                       | The ID of the organization for which to send the invitation                                                              |
| `requestBody`                                                                                                            | [Optional\<CreateOrganizationInvitationRequestBody>](../../models/operations/CreateOrganizationInvitationRequestBody.md) | :heavy_minus_sign:                                                                                                       | N/A                                                                                                                      |

### Response

**[CreateOrganizationInvitationResponse](../../models/operations/CreateOrganizationInvitationResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 403, 404, 422        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## list

This request returns the list of organization invitations.
Results can be paginated using the optional `limit` and `offset` query parameters.
You can filter them by providing the 'status' query parameter, that accepts multiple values.
The organization invitations are ordered by descending creation date.
Most recent invitations will be returned first.
Any invitations created as a result of an Organization Domain are not included in the results.

### Example Usage

<!-- UsageSnippet language="java" operationID="ListOrganizationInvitations" method="get" path="/organizations/{organization_id}/invitations" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.ListOrganizationInvitationsRequest;
import com.clerk.backend_api.models.operations.ListOrganizationInvitationsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        ListOrganizationInvitationsRequest req = ListOrganizationInvitationsRequest.builder()
                .organizationId("<id>")
                .build();

        ListOrganizationInvitationsResponse res = sdk.organizationInvitations().list()
                .request(req)
                .call();

        if (res.organizationInvitations().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                           | Type                                                                                                | Required                                                                                            | Description                                                                                         |
| --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- |
| `request`                                                                                           | [ListOrganizationInvitationsRequest](../../models/operations/ListOrganizationInvitationsRequest.md) | :heavy_check_mark:                                                                                  | The request object to use for the request.                                                          |

### Response

**[ListOrganizationInvitationsResponse](../../models/operations/ListOrganizationInvitationsResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 404, 422             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## bulkCreate

Creates new organization invitations in bulk and sends out emails to the provided email addresses with a link to accept the invitation and join the organization.
You can specify a different `role` for each invited organization member.
New organization invitations get a "pending" status until they are revoked by an organization administrator or accepted by the invitee.
The request body supports passing an optional `redirect_url` parameter for each invitation.
When the invited user clicks the link to accept the invitation, they will be redirected to the provided URL.
Use this parameter to implement a custom invitation acceptance flow.
You can specify the ID of the user that will send the invitation with the `inviter_user_id` parameter. Each invitation
can have a different inviter user.
Inviter users must be members with administrator privileges in the organization.
Only "admin" members can create organization invitations.
You can optionally provide public and private metadata for each organization invitation. The public metadata are visible
by both the Frontend and the Backend, whereas the private metadata are only visible by the Backend.
When the organization invitation is accepted, the metadata will be transferred to the newly created organization membership.

### Example Usage

<!-- UsageSnippet language="java" operationID="CreateOrganizationInvitationBulk" method="post" path="/organizations/{organization_id}/invitations/bulk" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CreateOrganizationInvitationBulkRequestBody;
import com.clerk.backend_api.models.operations.CreateOrganizationInvitationBulkResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        CreateOrganizationInvitationBulkResponse res = sdk.organizationInvitations().bulkCreate()
                .organizationId("<id>")
                .requestBody(List.of(
                    CreateOrganizationInvitationBulkRequestBody.builder()
                        .emailAddress("Jeffrey.Skiles27@hotmail.com")
                        .role("<value>")
                        .build()))
                .call();

        if (res.organizationInvitations().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                    | Type                                                                                                                         | Required                                                                                                                     | Description                                                                                                                  |
| ---------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------- |
| `organizationId`                                                                                                             | *String*                                                                                                                     | :heavy_check_mark:                                                                                                           | The organization ID.                                                                                                         |
| `requestBody`                                                                                                                | List\<[CreateOrganizationInvitationBulkRequestBody](../../models/operations/CreateOrganizationInvitationBulkRequestBody.md)> | :heavy_check_mark:                                                                                                           | N/A                                                                                                                          |

### Response

**[CreateOrganizationInvitationBulkResponse](../../models/operations/CreateOrganizationInvitationBulkResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 403, 404, 422        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## ~~listPending~~

This request returns the list of organization invitations with "pending" status.
These are the organization invitations that can still be used to join the organization, but have not been accepted by the invited user yet.
Results can be paginated using the optional `limit` and `offset` query parameters.
The organization invitations are ordered by descending creation date.
Most recent invitations will be returned first.
Any invitations created as a result of an Organization Domain are not included in the results.

> :warning: **DEPRECATED**: This will be removed in a future release, please migrate away from it as soon as possible.

### Example Usage

<!-- UsageSnippet language="java" operationID="ListPendingOrganizationInvitations" method="get" path="/organizations/{organization_id}/invitations/pending" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.ListPendingOrganizationInvitationsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        ListPendingOrganizationInvitationsResponse res = sdk.organizationInvitations().listPending()
                .organizationId("<id>")
                .limit(10L)
                .offset(0L)
                .call();

        if (res.organizationInvitations().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                 | Type                                                                                                                                      | Required                                                                                                                                  | Description                                                                                                                               |
| ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- |
| `organizationId`                                                                                                                          | *String*                                                                                                                                  | :heavy_check_mark:                                                                                                                        | The organization ID.                                                                                                                      |
| `limit`                                                                                                                                   | *Optional\<Long>*                                                                                                                         | :heavy_minus_sign:                                                                                                                        | Applies a limit to the number of results returned.<br/>Can be used for paginating the results together with `offset`.                     |
| `offset`                                                                                                                                  | *Optional\<Long>*                                                                                                                         | :heavy_minus_sign:                                                                                                                        | Skip the first `offset` results when paginating.<br/>Needs to be an integer greater or equal to zero.<br/>To be used in conjunction with `limit`. |

### Response

**[ListPendingOrganizationInvitationsResponse](../../models/operations/ListPendingOrganizationInvitationsResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 404                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## get

Use this request to get an existing organization invitation by ID.

### Example Usage

<!-- UsageSnippet language="java" operationID="GetOrganizationInvitation" method="get" path="/organizations/{organization_id}/invitations/{invitation_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.GetOrganizationInvitationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        GetOrganizationInvitationResponse res = sdk.organizationInvitations().get()
                .organizationId("<id>")
                .invitationId("<id>")
                .call();

        if (res.organizationInvitation().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                       | Type                            | Required                        | Description                     |
| ------------------------------- | ------------------------------- | ------------------------------- | ------------------------------- |
| `organizationId`                | *String*                        | :heavy_check_mark:              | The organization ID.            |
| `invitationId`                  | *String*                        | :heavy_check_mark:              | The organization invitation ID. |

### Response

**[GetOrganizationInvitationResponse](../../models/operations/GetOrganizationInvitationResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 403, 404             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## revoke

Use this request to revoke a previously issued organization invitation.
Revoking an organization invitation makes it invalid; the invited user will no longer be able to join the organization with the revoked invitation.
Only organization invitations with "pending" status can be revoked.
The request accepts the `requesting_user_id` parameter to specify the user which revokes the invitation.
Only users with "admin" role can revoke invitations.

### Example Usage

<!-- UsageSnippet language="java" operationID="RevokeOrganizationInvitation" method="post" path="/organizations/{organization_id}/invitations/{invitation_id}/revoke" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.RevokeOrganizationInvitationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        RevokeOrganizationInvitationResponse res = sdk.organizationInvitations().revoke()
                .organizationId("<id>")
                .invitationId("<id>")
                .call();

        if (res.organizationInvitation().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                | Type                                                                                                                     | Required                                                                                                                 | Description                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| `organizationId`                                                                                                         | *String*                                                                                                                 | :heavy_check_mark:                                                                                                       | The organization ID.                                                                                                     |
| `invitationId`                                                                                                           | *String*                                                                                                                 | :heavy_check_mark:                                                                                                       | The organization invitation ID.                                                                                          |
| `requestBody`                                                                                                            | [Optional\<RevokeOrganizationInvitationRequestBody>](../../models/operations/RevokeOrganizationInvitationRequestBody.md) | :heavy_minus_sign:                                                                                                       | N/A                                                                                                                      |

### Response

**[RevokeOrganizationInvitationResponse](../../models/operations/RevokeOrganizationInvitationResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 403, 404             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |