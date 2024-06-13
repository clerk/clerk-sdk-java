# OrganizationInvitations
(*organizationInvitations()*)

### Available Operations

* [create](#create) - Create and send an organization invitation
* [list](#list) - Get a list of organization invitations
* [createBulk](#createbulk) - Bulk create and send organization invitations
* [~~listPending~~](#listpending) - Get a list of pending organization invitations :warning: **Deprecated**
* [get](#get) - Retrieve an organization invitation by ID
* [revoke](#revoke) - Revoke a pending organization invitation

## create

Creates a new organization invitation and sends an email to the provided `email_address` with a link to accept the invitation and join the organization.
You can specify the `role` for the invited organization member.

New organization invitations get a "pending" status until they are revoked by an organization administrator or accepted by the invitee.

The request body supports passing an optional `redirect_url` parameter.
When the invited user clicks the link to accept the invitation, they will be redirected to the URL provided.
Use this parameter to implement a custom invitation acceptance flow.

You must specify the ID of the user that will send the invitation with the `inviter_user_id` parameter.
That user must be a member with administrator privileges in the organization.
Only "admin" members can create organization invitations.

You can optionally provide public and private metadata for the organization invitation.
The public metadata are visible by both the Frontend and the Backend whereas the private ones only by the Backend.
When the organization invitation is accepted, the metadata will be transferred to the newly created organization membership.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.components.*;
import com.clerk.backend_api.models.components.Security;
import com.clerk.backend_api.models.operations.*;
import com.clerk.backend_api.utils.EventStream;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;
import static java.util.Map.entry;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            CreateOrganizationInvitationResponse res = sdk.organizationInvitations().create()
                .organizationId("<value>")
                .requestBody(CreateOrganizationInvitationRequestBody.builder()
                    .emailAddress("<value>")
                    .inviterUserId("<value>")
                    .role("<value>")
                    .build())
                .call();

            if (res.organizationInvitation().isPresent()) {
                // handle response
            }
        } catch (com.clerk.backend_api.models.errors.ClerkErrors e) {
            // handle exception
            throw e;
        } catch (com.clerk.backend_api.models.errors.SDKError e) {
            // handle exception
            throw e;
        } catch (Exception e) {
            // handle exception
            throw e;
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                             | Type                                                                                                                                                  | Required                                                                                                                                              | Description                                                                                                                                           |
| ----------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------- |
| `organizationId`                                                                                                                                      | *String*                                                                                                                                              | :heavy_check_mark:                                                                                                                                    | The ID of the organization for which to send the invitation                                                                                           |
| `requestBody`                                                                                                                                         | [com.clerk.backend_api.models.operations.CreateOrganizationInvitationRequestBody](../../models/operations/CreateOrganizationInvitationRequestBody.md) | :heavy_check_mark:                                                                                                                                    | N/A                                                                                                                                                   |


### Response

**[Optional<? extends com.clerk.backend_api.models.operations.CreateOrganizationInvitationResponse>](../../models/operations/CreateOrganizationInvitationResponse.md)**
### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,403,404,422           | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | */*                       |

## list

This request returns the list of organization invitations.
Results can be paginated using the optional `limit` and `offset` query parameters.
You can filter them by providing the 'status' query parameter, that accepts multiple values.
The organization invitations are ordered by descending creation date.
Most recent invitations will be returned first.
Any invitations created as a result of an Organization Domain are not included in the results.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.components.*;
import com.clerk.backend_api.models.components.Security;
import com.clerk.backend_api.models.operations.*;
import com.clerk.backend_api.utils.EventStream;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;
import static java.util.Map.entry;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            ListOrganizationInvitationsResponse res = sdk.organizationInvitations().list()
                .organizationId("<value>")
                .limit(10L)
                .offset(0L)
                .status(ListOrganizationInvitationsQueryParamStatus.REVOKED)
                .call();

            while (true) {
                if (res.organizationInvitations().isPresent()) {
                    // handle response
                    Optional<ListOrganizationInvitationsResponse> nextRes = res.next();
                    if (nextRes.isPresent()) {
                        res = nextRes.get();
                    } else {
                        break;
                    }
                }
            }
        } catch (com.clerk.backend_api.models.errors.ClerkErrors e) {
            // handle exception
            throw e;
        } catch (com.clerk.backend_api.models.errors.SDKError e) {
            // handle exception
            throw e;
        } catch (Exception e) {
            // handle exception
            throw e;
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                         | Type                                                                                                                                                                              | Required                                                                                                                                                                          | Description                                                                                                                                                                       |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `organizationId`                                                                                                                                                                  | *String*                                                                                                                                                                          | :heavy_check_mark:                                                                                                                                                                | The organization ID.                                                                                                                                                              |
| `limit`                                                                                                                                                                           | *Optional<? extends Long>*                                                                                                                                                        | :heavy_minus_sign:                                                                                                                                                                | Applies a limit to the number of results returned.<br/>Can be used for paginating the results together with `offset`.                                                             |
| `offset`                                                                                                                                                                          | *Optional<? extends Long>*                                                                                                                                                        | :heavy_minus_sign:                                                                                                                                                                | Skip the first `offset` results when paginating.<br/>Needs to be an integer greater or equal to zero.<br/>To be used in conjunction with `limit`.                                 |
| `status`                                                                                                                                                                          | [Optional<? extends com.clerk.backend_api.models.operations.ListOrganizationInvitationsQueryParamStatus>](../../models/operations/ListOrganizationInvitationsQueryParamStatus.md) | :heavy_minus_sign:                                                                                                                                                                | Filter organization invitations based on their status                                                                                                                             |


### Response

**[Optional<? extends com.clerk.backend_api.models.operations.ListOrganizationInvitationsResponse>](../../models/operations/ListOrganizationInvitationsResponse.md)**
### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,404                   | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | */*                       |

## createBulk

Creates new organization invitations in bulk and sends out emails to the provided email addresses with a link to accept the invitation and join the organization.
You can specify a different `role` for each invited organization member.
New organization invitations get a "pending" status until they are revoked by an organization administrator or accepted by the invitee.
The request body supports passing an optional `redirect_url` parameter for each invitation.
When the invited user clicks the link to accept the invitation, they will be redirected to the provided URL.
Use this parameter to implement a custom invitation acceptance flow.
You must specify the ID of the user that will send the invitation with the `inviter_user_id` parameter. Each invitation
can have a different inviter user.
Inviter users must be members with administrator privileges in the organization.
Only "admin" members can create organization invitations.
You can optionally provide public and private metadata for each organization invitation. The public metadata are visible
by both the Frontend and the Backend, whereas the private metadata are only visible by the Backend.
When the organization invitation is accepted, the metadata will be transferred to the newly created organization membership.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.components.*;
import com.clerk.backend_api.models.components.Security;
import com.clerk.backend_api.models.operations.*;
import com.clerk.backend_api.utils.EventStream;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;
import static java.util.Map.entry;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            CreateOrganizationInvitationBulkResponse res = sdk.organizationInvitations().createBulk()
                .organizationId("<value>")
                .requestBody(java.util.List.of(
                    RequestBody.builder()
                        .emailAddress("<value>")
                        .inviterUserId("<value>")
                        .role("<value>")
                        .build()))
                .call();

            if (res.organizationInvitations().isPresent()) {
                // handle response
            }
        } catch (com.clerk.backend_api.models.errors.ClerkErrors e) {
            // handle exception
            throw e;
        } catch (com.clerk.backend_api.models.errors.SDKError e) {
            // handle exception
            throw e;
        } catch (Exception e) {
            // handle exception
            throw e;
        }
    }
}
```

### Parameters

| Parameter                                                                                           | Type                                                                                                | Required                                                                                            | Description                                                                                         |
| --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- |
| `organizationId`                                                                                    | *String*                                                                                            | :heavy_check_mark:                                                                                  | The organization ID.                                                                                |
| `requestBody`                                                                                       | List<[com.clerk.backend_api.models.operations.RequestBody](../../models/operations/RequestBody.md)> | :heavy_check_mark:                                                                                  | N/A                                                                                                 |


### Response

**[Optional<? extends com.clerk.backend_api.models.operations.CreateOrganizationInvitationBulkResponse>](../../models/operations/CreateOrganizationInvitationBulkResponse.md)**
### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,403,404,422           | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | */*                       |

## ~~listPending~~

This request returns the list of organization invitations with "pending" status.
These are the organization invitations that can still be used to join the organization, but have not been accepted by the invited user yet.
Results can be paginated using the optional `limit` and `offset` query parameters.
The organization invitations are ordered by descending creation date.
Most recent invitations will be returned first.
Any invitations created as a result of an Organization Domain are not included in the results.

> :warning: **DEPRECATED**: This will be removed in a future release, please migrate away from it as soon as possible.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.components.*;
import com.clerk.backend_api.models.components.Security;
import com.clerk.backend_api.models.operations.*;
import com.clerk.backend_api.utils.EventStream;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;
import static java.util.Map.entry;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            ListPendingOrganizationInvitationsResponse res = sdk.organizationInvitations().listPending()
                .organizationId("<value>")
                .limit(10L)
                .offset(0L)
                .call();

            while (true) {
                if (res.organizationInvitations().isPresent()) {
                    // handle response
                    Optional<ListPendingOrganizationInvitationsResponse> nextRes = res.next();
                    if (nextRes.isPresent()) {
                        res = nextRes.get();
                    } else {
                        break;
                    }
                }
            }
        } catch (com.clerk.backend_api.models.errors.ClerkErrors e) {
            // handle exception
            throw e;
        } catch (com.clerk.backend_api.models.errors.SDKError e) {
            // handle exception
            throw e;
        } catch (Exception e) {
            // handle exception
            throw e;
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                 | Type                                                                                                                                      | Required                                                                                                                                  | Description                                                                                                                               |
| ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- |
| `organizationId`                                                                                                                          | *String*                                                                                                                                  | :heavy_check_mark:                                                                                                                        | The organization ID.                                                                                                                      |
| `limit`                                                                                                                                   | *Optional<? extends Long>*                                                                                                                | :heavy_minus_sign:                                                                                                                        | Applies a limit to the number of results returned.<br/>Can be used for paginating the results together with `offset`.                     |
| `offset`                                                                                                                                  | *Optional<? extends Long>*                                                                                                                | :heavy_minus_sign:                                                                                                                        | Skip the first `offset` results when paginating.<br/>Needs to be an integer greater or equal to zero.<br/>To be used in conjunction with `limit`. |


### Response

**[Optional<? extends com.clerk.backend_api.models.operations.ListPendingOrganizationInvitationsResponse>](../../models/operations/ListPendingOrganizationInvitationsResponse.md)**
### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,404                   | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | */*                       |

## get

Use this request to get an existing organization invitation by ID.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.components.*;
import com.clerk.backend_api.models.components.Security;
import com.clerk.backend_api.models.operations.*;
import com.clerk.backend_api.utils.EventStream;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;
import static java.util.Map.entry;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            GetOrganizationInvitationResponse res = sdk.organizationInvitations().get()
                .organizationId("<value>")
                .invitationId("<value>")
                .call();

            if (res.organizationInvitation().isPresent()) {
                // handle response
            }
        } catch (com.clerk.backend_api.models.errors.ClerkErrors e) {
            // handle exception
            throw e;
        } catch (com.clerk.backend_api.models.errors.SDKError e) {
            // handle exception
            throw e;
        } catch (Exception e) {
            // handle exception
            throw e;
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

**[Optional<? extends com.clerk.backend_api.models.operations.GetOrganizationInvitationResponse>](../../models/operations/GetOrganizationInvitationResponse.md)**
### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,403,404               | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | */*                       |

## revoke

Use this request to revoke a previously issued organization invitation.
Revoking an organization invitation makes it invalid; the invited user will no longer be able to join the organization with the revoked invitation.
Only organization invitations with "pending" status can be revoked.
The request needs the `requesting_user_id` parameter to specify the user which revokes the invitation.
Only users with "admin" role can revoke invitations.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.components.*;
import com.clerk.backend_api.models.components.Security;
import com.clerk.backend_api.models.operations.*;
import com.clerk.backend_api.utils.EventStream;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;
import static java.util.Map.entry;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            RevokeOrganizationInvitationResponse res = sdk.organizationInvitations().revoke()
                .organizationId("<value>")
                .invitationId("<value>")
                .requestBody(RevokeOrganizationInvitationRequestBody.builder()
                    .requestingUserId("<value>")
                    .build())
                .call();

            if (res.organizationInvitation().isPresent()) {
                // handle response
            }
        } catch (com.clerk.backend_api.models.errors.ClerkErrors e) {
            // handle exception
            throw e;
        } catch (com.clerk.backend_api.models.errors.SDKError e) {
            // handle exception
            throw e;
        } catch (Exception e) {
            // handle exception
            throw e;
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                             | Type                                                                                                                                                  | Required                                                                                                                                              | Description                                                                                                                                           |
| ----------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------- |
| `organizationId`                                                                                                                                      | *String*                                                                                                                                              | :heavy_check_mark:                                                                                                                                    | The organization ID.                                                                                                                                  |
| `invitationId`                                                                                                                                        | *String*                                                                                                                                              | :heavy_check_mark:                                                                                                                                    | The organization invitation ID.                                                                                                                       |
| `requestBody`                                                                                                                                         | [com.clerk.backend_api.models.operations.RevokeOrganizationInvitationRequestBody](../../models/operations/RevokeOrganizationInvitationRequestBody.md) | :heavy_check_mark:                                                                                                                                    | N/A                                                                                                                                                   |


### Response

**[Optional<? extends com.clerk.backend_api.models.operations.RevokeOrganizationInvitationResponse>](../../models/operations/RevokeOrganizationInvitationResponse.md)**
### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,403,404               | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | */*                       |
