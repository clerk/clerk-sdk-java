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

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.CreateOrganizationMembershipRequestBody;
import com.clerk.backend_api.models.operations.CreateOrganizationMembershipResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            CreateOrganizationMembershipResponse res = sdk.organizationMemberships().create()
                .organizationId("<value>")
                .requestBody(CreateOrganizationMembershipRequestBody.builder()
                    .userId("<value>")
                    .role("<value>")
                    .build())
                .call();

            if (res.organizationMembership().isPresent()) {
                // handle response
            }
        } catch (com.clerk.backend_api.models.errors.ClerkErrors e) {
            // handle exception
            throw e;
        } catch (SDKError e) {
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

| Parameter                                                                                                     | Type                                                                                                          | Required                                                                                                      | Description                                                                                                   |
| ------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- |
| `organizationId`                                                                                              | *String*                                                                                                      | :heavy_check_mark:                                                                                            | The ID of the organization where the new membership will be created                                           |
| `requestBody`                                                                                                 | [CreateOrganizationMembershipRequestBody](../../models/operations/CreateOrganizationMembershipRequestBody.md) | :heavy_check_mark:                                                                                            | N/A                                                                                                           |

### Response

**[CreateOrganizationMembershipResponse](../../models/operations/CreateOrganizationMembershipResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,403,404,422           | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## list

Retrieves all user memberships for the given organization

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            sdk.organizationMemberships().list()
                .organizationId("<value>")
                .limit(10L)
                .offset(0L)
                .orderBy("<value>")
                .callAsStreamUnwrapped()
                .forEach(item -> {
                   // handle item
                });

        } catch (com.clerk.backend_api.models.errors.ClerkErrors e) {
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

| Parameter                                                                                                                                                                                                                           | Type                                                                                                                                                                                                                                | Required                                                                                                                                                                                                                            | Description                                                                                                                                                                                                                         |
| ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `organizationId`                                                                                                                                                                                                                    | *String*                                                                                                                                                                                                                            | :heavy_check_mark:                                                                                                                                                                                                                  | The organization ID.                                                                                                                                                                                                                |
| `limit`                                                                                                                                                                                                                             | *Optional<Long>*                                                                                                                                                                                                                    | :heavy_minus_sign:                                                                                                                                                                                                                  | Applies a limit to the number of results returned.<br/>Can be used for paginating the results together with `offset`.                                                                                                               |
| `offset`                                                                                                                                                                                                                            | *Optional<Long>*                                                                                                                                                                                                                    | :heavy_minus_sign:                                                                                                                                                                                                                  | Skip the first `offset` results when paginating.<br/>Needs to be an integer greater or equal to zero.<br/>To be used in conjunction with `limit`.                                                                                   |
| `orderBy`                                                                                                                                                                                                                           | *Optional<String>*                                                                                                                                                                                                                  | :heavy_minus_sign:                                                                                                                                                                                                                  | Sorts organizations memberships by phone_number, email_address, created_at, first_name, last_name or username.<br/>By prepending one of those values with + or -,<br/>we can choose to sort in ascending (ASC) or descending (DESC) order." |

### Response

**[ListOrganizationMembershipsResponse](../../models/operations/ListOrganizationMembershipsResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 401,422                   | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## update

Updates the properties of an existing organization membership

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.UpdateOrganizationMembershipRequestBody;
import com.clerk.backend_api.models.operations.UpdateOrganizationMembershipResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            UpdateOrganizationMembershipResponse res = sdk.organizationMemberships().update()
                .organizationId("<value>")
                .userId("<value>")
                .requestBody(UpdateOrganizationMembershipRequestBody.builder()
                    .role("<value>")
                    .build())
                .call();

            if (res.organizationMembership().isPresent()) {
                // handle response
            }
        } catch (com.clerk.backend_api.models.errors.ClerkErrors e) {
            // handle exception
            throw e;
        } catch (SDKError e) {
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

| Parameter                                                                                                     | Type                                                                                                          | Required                                                                                                      | Description                                                                                                   |
| ------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- |
| `organizationId`                                                                                              | *String*                                                                                                      | :heavy_check_mark:                                                                                            | The ID of the organization the membership belongs to                                                          |
| `userId`                                                                                                      | *String*                                                                                                      | :heavy_check_mark:                                                                                            | The ID of the user that this membership belongs to                                                            |
| `requestBody`                                                                                                 | [UpdateOrganizationMembershipRequestBody](../../models/operations/UpdateOrganizationMembershipRequestBody.md) | :heavy_check_mark:                                                                                            | N/A                                                                                                           |

### Response

**[UpdateOrganizationMembershipResponse](../../models/operations/UpdateOrganizationMembershipResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,404,422               | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## delete

Removes the given membership from the organization

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.DeleteOrganizationMembershipResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            DeleteOrganizationMembershipResponse res = sdk.organizationMemberships().delete()
                .organizationId("<value>")
                .userId("<value>")
                .call();

            if (res.organizationMembership().isPresent()) {
                // handle response
            }
        } catch (com.clerk.backend_api.models.errors.ClerkErrors e) {
            // handle exception
            throw e;
        } catch (SDKError e) {
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

| Parameter                                            | Type                                                 | Required                                             | Description                                          |
| ---------------------------------------------------- | ---------------------------------------------------- | ---------------------------------------------------- | ---------------------------------------------------- |
| `organizationId`                                     | *String*                                             | :heavy_check_mark:                                   | The ID of the organization the membership belongs to |
| `userId`                                             | *String*                                             | :heavy_check_mark:                                   | The ID of the user that this membership belongs to   |

### Response

**[DeleteOrganizationMembershipResponse](../../models/operations/DeleteOrganizationMembershipResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,401,404               | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## updateMetadata

Update an organization membership's metadata attributes by merging existing values with the provided parameters.
Metadata values will be updated via a deep merge. Deep means that any nested JSON objects will be merged as well.
You can remove metadata keys at any level by setting their value to `null`.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.UpdateOrganizationMembershipMetadataRequestBody;
import com.clerk.backend_api.models.operations.UpdateOrganizationMembershipMetadataResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            UpdateOrganizationMembershipMetadataResponse res = sdk.organizationMemberships().updateMetadata()
                .organizationId("<value>")
                .userId("<value>")
                .requestBody(UpdateOrganizationMembershipMetadataRequestBody.builder()
                    .build())
                .call();

            if (res.organizationMembership().isPresent()) {
                // handle response
            }
        } catch (com.clerk.backend_api.models.errors.ClerkErrors e) {
            // handle exception
            throw e;
        } catch (SDKError e) {
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

| Parameter                                                                                                                     | Type                                                                                                                          | Required                                                                                                                      | Description                                                                                                                   |
| ----------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------- |
| `organizationId`                                                                                                              | *String*                                                                                                                      | :heavy_check_mark:                                                                                                            | The ID of the organization the membership belongs to                                                                          |
| `userId`                                                                                                                      | *String*                                                                                                                      | :heavy_check_mark:                                                                                                            | The ID of the user that this membership belongs to                                                                            |
| `requestBody`                                                                                                                 | [UpdateOrganizationMembershipMetadataRequestBody](../../models/operations/UpdateOrganizationMembershipMetadataRequestBody.md) | :heavy_check_mark:                                                                                                            | N/A                                                                                                                           |

### Response

**[UpdateOrganizationMembershipMetadataResponse](../../models/operations/UpdateOrganizationMembershipMetadataResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,404,422               | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |
