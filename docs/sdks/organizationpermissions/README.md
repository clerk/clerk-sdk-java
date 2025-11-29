# OrganizationPermissions
(*organizationPermissions()*)

## Overview

### Available Operations

* [list](#list) - Get a list of all organization permissions
* [create](#create) - Create a new organization permission
* [get](#get) - Get an organization permission
* [update](#update) - Update an organization permission
* [delete](#delete) - Delete an organization permission

## list

Retrieves all organization permissions for the given instance.

### Example Usage

<!-- UsageSnippet language="java" operationID="ListOrganizationPermissions" method="get" path="/organization_permissions" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.ListOrganizationPermissionsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        ListOrganizationPermissionsResponse res = sdk.organizationPermissions().list()
                .limit(10L)
                .offset(0L)
                .call();

        if (res.permissions().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                                                                                                                                                                                                            | Type                                                                                                                                                                                                                                                                                                                                                                                                                 | Required                                                                                                                                                                                                                                                                                                                                                                                                             | Description                                                                                                                                                                                                                                                                                                                                                                                                          |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `query`                                                                                                                                                                                                                                                                                                                                                                                                              | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                                                  | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                                   | Returns organization permissions with ID, name, or key that match the given query.<br/>Uses exact match for permission ID and partial match for name and key.                                                                                                                                                                                                                                                        |
| `orderBy`                                                                                                                                                                                                                                                                                                                                                                                                            | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                                                  | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                                   | Allows to return organization permissions in a particular order.<br/>At the moment, you can order the returned permissions by their `created_at`, `name`, or `key`.<br/>In order to specify the direction, you can use the `+/-` symbols prepended in the property to order by.<br/>For example, if you want permissions to be returned in descending order according to their `created_at` property, you can use `-created_at`. |
| `limit`                                                                                                                                                                                                                                                                                                                                                                                                              | *Optional\<Long>*                                                                                                                                                                                                                                                                                                                                                                                                    | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                                   | Applies a limit to the number of results returned.<br/>Can be used for paginating the results together with `offset`.                                                                                                                                                                                                                                                                                                |
| `offset`                                                                                                                                                                                                                                                                                                                                                                                                             | *Optional\<Long>*                                                                                                                                                                                                                                                                                                                                                                                                    | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                                   | Skip the first `offset` results when paginating.<br/>Needs to be an integer greater or equal to zero.<br/>To be used in conjunction with `limit`.                                                                                                                                                                                                                                                                    |

### Response

**[ListOrganizationPermissionsResponse](../../models/operations/ListOrganizationPermissionsResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 401, 422                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## create

Creates a new organization permission for the given instance.

### Example Usage

<!-- UsageSnippet language="java" operationID="CreateOrganizationPermission" method="post" path="/organization_permissions" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CreateOrganizationPermissionRequestBody;
import com.clerk.backend_api.models.operations.CreateOrganizationPermissionResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        CreateOrganizationPermissionRequestBody req = CreateOrganizationPermissionRequestBody.builder()
                .name("<value>")
                .key("<key>")
                .build();

        CreateOrganizationPermissionResponse res = sdk.organizationPermissions().create()
                .request(req)
                .call();

        if (res.permission().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                     | Type                                                                                                          | Required                                                                                                      | Description                                                                                                   |
| ------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                     | [CreateOrganizationPermissionRequestBody](../../models/operations/CreateOrganizationPermissionRequestBody.md) | :heavy_check_mark:                                                                                            | The request object to use for the request.                                                                    |

### Response

**[CreateOrganizationPermissionResponse](../../models/operations/CreateOrganizationPermissionResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 402, 404, 422   | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## get

Retrieves the details of an organization permission.

### Example Usage

<!-- UsageSnippet language="java" operationID="GetOrganizationPermission" method="get" path="/organization_permissions/{permission_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.GetOrganizationPermissionResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        GetOrganizationPermissionResponse res = sdk.organizationPermissions().get()
                .permissionId("<id>")
                .call();

        if (res.permission().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                            | Type                                 | Required                             | Description                          |
| ------------------------------------ | ------------------------------------ | ------------------------------------ | ------------------------------------ |
| `permissionId`                       | *String*                             | :heavy_check_mark:                   | The ID of the permission to retrieve |

### Response

**[GetOrganizationPermissionResponse](../../models/operations/GetOrganizationPermissionResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 401, 404                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## update

Updates the properties of an existing organization permission.
System permissions cannot be updated.

### Example Usage

<!-- UsageSnippet language="java" operationID="UpdateOrganizationPermission" method="patch" path="/organization_permissions/{permission_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UpdateOrganizationPermissionRequestBody;
import com.clerk.backend_api.models.operations.UpdateOrganizationPermissionResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        UpdateOrganizationPermissionResponse res = sdk.organizationPermissions().update()
                .permissionId("<id>")
                .requestBody(UpdateOrganizationPermissionRequestBody.builder()
                    .build())
                .call();

        if (res.permission().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                     | Type                                                                                                          | Required                                                                                                      | Description                                                                                                   |
| ------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- |
| `permissionId`                                                                                                | *String*                                                                                                      | :heavy_check_mark:                                                                                            | The ID of the permission to update                                                                            |
| `requestBody`                                                                                                 | [UpdateOrganizationPermissionRequestBody](../../models/operations/UpdateOrganizationPermissionRequestBody.md) | :heavy_check_mark:                                                                                            | N/A                                                                                                           |

### Response

**[UpdateOrganizationPermissionResponse](../../models/operations/UpdateOrganizationPermissionResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404, 422   | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## delete

Deletes an organization permission.
System permissions cannot be deleted.

### Example Usage

<!-- UsageSnippet language="java" operationID="DeleteOrganizationPermission" method="delete" path="/organization_permissions/{permission_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.DeleteOrganizationPermissionResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        DeleteOrganizationPermissionResponse res = sdk.organizationPermissions().delete()
                .permissionId("<id>")
                .call();

        if (res.deletedObject().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                          | Type                               | Required                           | Description                        |
| ---------------------------------- | ---------------------------------- | ---------------------------------- | ---------------------------------- |
| `permissionId`                     | *String*                           | :heavy_check_mark:                 | The ID of the permission to delete |

### Response

**[DeleteOrganizationPermissionResponse](../../models/operations/DeleteOrganizationPermissionResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 401, 403, 404             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |