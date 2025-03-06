# OrganizationMemberships
(*organizationMemberships()*)

## Overview

### Available Operations

* [create](#create) - Create a new organization membership
* [list](#list) - Get a list of all members of an organization
* [update](#update) - Update an organization membership
* [delete](#delete) - Remove a member from an organization
* [updateMetadata](#updatemetadata) - Merge and update organization membership metadata

## create

Adds a user as a member to the given organization.
Only users in the same instance as the organization can be added as members.

This organization will be the user's [active organization] (https://clerk.com/docs/organizations/overview#active-organization)
the next time they create a session, presuming they don't explicitly set a
different organization as active before then.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CreateOrganizationMembershipRequestBody;
import com.clerk.backend_api.models.operations.CreateOrganizationMembershipResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        CreateOrganizationMembershipResponse res = sdk.organizationMemberships().create()
                .organizationId("<id>")
                .requestBody(CreateOrganizationMembershipRequestBody.builder()
                    .userId("<id>")
                    .role("<value>")
                    .build())
                .call();

        if (res.organizationMembership().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                     | Type                                                                                                          | Required                                                                                                      | Description                                                                                                   |
| ------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- |
| `organizationId`                                                                                              | *String*                                                                                                      | :heavy_check_mark:                                                                                            | The ID of the organization where the new membership will be created                                           |
| `requestBody`                                                                                                 | [CreateOrganizationMembershipRequestBody](../../models/operations/CreateOrganizationMembershipRequestBody.md) | :heavy_check_mark:                                                                                            | N/A                                                                                                           |

### Response

**[CreateOrganizationMembershipResponse](../../models/operations/CreateOrganizationMembershipResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 403, 404, 422        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## list

Retrieves all user memberships for the given organization

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.ListOrganizationMembershipsRequest;
import com.clerk.backend_api.models.operations.ListOrganizationMembershipsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        ListOrganizationMembershipsRequest req = ListOrganizationMembershipsRequest.builder()
                .organizationId("<id>")
                .lastActiveAtBefore(1700690400000L)
                .lastActiveAtAfter(1700690400000L)
                .createdAtBefore(1730160000000L)
                .createdAtAfter(1730160000000L)
                .build();

        ListOrganizationMembershipsResponse res = sdk.organizationMemberships().list()
                .request(req)
                .call();

        if (res.organizationMemberships().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                           | Type                                                                                                | Required                                                                                            | Description                                                                                         |
| --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- |
| `request`                                                                                           | [ListOrganizationMembershipsRequest](../../models/operations/ListOrganizationMembershipsRequest.md) | :heavy_check_mark:                                                                                  | The request object to use for the request.                                                          |

### Response

**[ListOrganizationMembershipsResponse](../../models/operations/ListOrganizationMembershipsResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 401, 422                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## update

Updates the properties of an existing organization membership

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UpdateOrganizationMembershipRequestBody;
import com.clerk.backend_api.models.operations.UpdateOrganizationMembershipResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        UpdateOrganizationMembershipResponse res = sdk.organizationMemberships().update()
                .organizationId("<id>")
                .userId("<id>")
                .requestBody(UpdateOrganizationMembershipRequestBody.builder()
                    .role("<value>")
                    .build())
                .call();

        if (res.organizationMembership().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                     | Type                                                                                                          | Required                                                                                                      | Description                                                                                                   |
| ------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- |
| `organizationId`                                                                                              | *String*                                                                                                      | :heavy_check_mark:                                                                                            | The ID of the organization the membership belongs to                                                          |
| `userId`                                                                                                      | *String*                                                                                                      | :heavy_check_mark:                                                                                            | The ID of the user that this membership belongs to                                                            |
| `requestBody`                                                                                                 | [UpdateOrganizationMembershipRequestBody](../../models/operations/UpdateOrganizationMembershipRequestBody.md) | :heavy_check_mark:                                                                                            | N/A                                                                                                           |

### Response

**[UpdateOrganizationMembershipResponse](../../models/operations/UpdateOrganizationMembershipResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 404, 422                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## delete

Removes the given membership from the organization

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.DeleteOrganizationMembershipResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        DeleteOrganizationMembershipResponse res = sdk.organizationMemberships().delete()
                .organizationId("<id>")
                .userId("<id>")
                .call();

        if (res.organizationMembership().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                            | Type                                                 | Required                                             | Description                                          |
| ---------------------------------------------------- | ---------------------------------------------------- | ---------------------------------------------------- | ---------------------------------------------------- |
| `organizationId`                                     | *String*                                             | :heavy_check_mark:                                   | The ID of the organization the membership belongs to |
| `userId`                                             | *String*                                             | :heavy_check_mark:                                   | The ID of the user that this membership belongs to   |

### Response

**[DeleteOrganizationMembershipResponse](../../models/operations/DeleteOrganizationMembershipResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 401, 404                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## updateMetadata

Update an organization membership's metadata attributes by merging existing values with the provided parameters.
Metadata values will be updated via a deep merge. Deep means that any nested JSON objects will be merged as well.
You can remove metadata keys at any level by setting their value to `null`.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UpdateOrganizationMembershipMetadataRequestBody;
import com.clerk.backend_api.models.operations.UpdateOrganizationMembershipMetadataResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        UpdateOrganizationMembershipMetadataResponse res = sdk.organizationMemberships().updateMetadata()
                .organizationId("<id>")
                .userId("<id>")
                .requestBody(UpdateOrganizationMembershipMetadataRequestBody.builder()
                    .build())
                .call();

        if (res.organizationMembership().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                | Type                                                                                                                                     | Required                                                                                                                                 | Description                                                                                                                              |
| ---------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------- |
| `organizationId`                                                                                                                         | *String*                                                                                                                                 | :heavy_check_mark:                                                                                                                       | The ID of the organization the membership belongs to                                                                                     |
| `userId`                                                                                                                                 | *String*                                                                                                                                 | :heavy_check_mark:                                                                                                                       | The ID of the user that this membership belongs to                                                                                       |
| `requestBody`                                                                                                                            | [Optional\<UpdateOrganizationMembershipMetadataRequestBody>](../../models/operations/UpdateOrganizationMembershipMetadataRequestBody.md) | :heavy_minus_sign:                                                                                                                       | N/A                                                                                                                                      |

### Response

**[UpdateOrganizationMembershipMetadataResponse](../../models/operations/UpdateOrganizationMembershipMetadataResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 404, 422             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |