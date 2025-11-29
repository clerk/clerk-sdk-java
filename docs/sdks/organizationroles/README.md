# OrganizationRoles
(*organizationRoles()*)

## Overview

### Available Operations

* [list](#list) - Get a list of organization roles
* [create](#create) - Create an organization role
* [get](#get) - Retrieve an organization role
* [update](#update) - Update an organization role
* [delete](#delete) - Delete an organization role
* [assignPermission](#assignpermission) - Assign a permission to an organization role
* [removePermission](#removepermission) - Remove a permission from an organization role

## list

This request returns the list of organization roles for the instance.
Results can be paginated using the optional `limit` and `offset` query parameters.
The organization roles are ordered by descending creation date.
Most recent roles will be returned first.

### Example Usage

<!-- UsageSnippet language="java" operationID="ListOrganizationRoles" method="get" path="/organization_roles" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.ListOrganizationRolesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        ListOrganizationRolesResponse res = sdk.organizationRoles().list()
                .orderBy("-created_at")
                .limit(10L)
                .offset(0L)
                .call();

        if (res.roles().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 | Type                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      | Required                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  | Description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `query`                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        | Returns organization roles with ID, name, or key that match the given query.<br/>Uses exact match for organization role ID and partial match for name and key.                                                                                                                                                                                                                                                                                                                                            |
| `orderBy`                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        | Allows to return organization roles in a particular order.<br/>At the moment, you can order the returned organization roles by their `created_at`, `name`, or `key`.<br/>In order to specify the direction, you can use the `+/-` symbols prepended in the property to order by.<br/>For example, if you want organization roles to be returned in descending order according to their `created_at` property, you can use `-created_at`.<br/>If you don't use `+` or `-`, then `+` is implied.<br/>Defaults to `-created_at`. |
| `limit`                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   | *Optional\<Long>*                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        | Applies a limit to the number of results returned.<br/>Can be used for paginating the results together with `offset`.                                                                                                                                                                                                                                                                                                                                                                                     |
| `offset`                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  | *Optional\<Long>*                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        | Skip the first `offset` results when paginating.<br/>Needs to be an integer greater or equal to zero.<br/>To be used in conjunction with `limit`.                                                                                                                                                                                                                                                                                                                                                         |

### Response

**[ListOrganizationRolesResponse](../../models/operations/ListOrganizationRolesResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 422        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## create

Creates a new organization role with the given name and permissions for an instance.
The key must be unique for the instance and start with the 'org:' prefix, followed by lowercase alphanumeric characters and underscores only.
You can optionally provide a description for the role and specify whether it should be included in the initial role set.
Organization roles support permissions that can be assigned to control access within the organization.

### Example Usage

<!-- UsageSnippet language="java" operationID="CreateOrganizationRole" method="post" path="/organization_roles" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CreateOrganizationRoleRequestBody;
import com.clerk.backend_api.models.operations.CreateOrganizationRoleResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        CreateOrganizationRoleRequestBody req = CreateOrganizationRoleRequestBody.builder()
                .name("<value>")
                .key("<key>")
                .build();

        CreateOrganizationRoleResponse res = sdk.organizationRoles().create()
                .request(req)
                .call();

        if (res.role().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                         | Type                                                                                              | Required                                                                                          | Description                                                                                       |
| ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- |
| `request`                                                                                         | [CreateOrganizationRoleRequestBody](../../models/operations/CreateOrganizationRoleRequestBody.md) | :heavy_check_mark:                                                                                | The request object to use for the request.                                                        |

### Response

**[CreateOrganizationRoleResponse](../../models/operations/CreateOrganizationRoleResponse.md)**

### Errors

| Error Type                   | Status Code                  | Content Type                 |
| ---------------------------- | ---------------------------- | ---------------------------- |
| models/errors/ClerkErrors    | 400, 401, 402, 403, 404, 422 | application/json             |
| models/errors/SDKError       | 4XX, 5XX                     | \*/\*                        |

## get

Use this request to retrieve an existing organization role by its ID.

### Example Usage

<!-- UsageSnippet language="java" operationID="GetOrganizationRole" method="get" path="/organization_roles/{organization_role_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.GetOrganizationRoleResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        GetOrganizationRoleResponse res = sdk.organizationRoles().get()
                .organizationRoleId("<id>")
                .call();

        if (res.role().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                       | Type                            | Required                        | Description                     |
| ------------------------------- | ------------------------------- | ------------------------------- | ------------------------------- |
| `organizationRoleId`            | *String*                        | :heavy_check_mark:              | The ID of the organization role |

### Response

**[GetOrganizationRoleResponse](../../models/operations/GetOrganizationRoleResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 401, 403, 404             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## update

Updates an existing organization role.
You can update the name, key, description, and permissions of the role.
All parameters are optional - you can update only the fields you want to change.
If the role is used as a creator role or domain default role, updating the key will cascade the update to the organization settings.

### Example Usage

<!-- UsageSnippet language="java" operationID="UpdateOrganizationRole" method="patch" path="/organization_roles/{organization_role_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UpdateOrganizationRoleRequestBody;
import com.clerk.backend_api.models.operations.UpdateOrganizationRoleResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        UpdateOrganizationRoleResponse res = sdk.organizationRoles().update()
                .organizationRoleId("<id>")
                .requestBody(UpdateOrganizationRoleRequestBody.builder()
                    .build())
                .call();

        if (res.role().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                         | Type                                                                                              | Required                                                                                          | Description                                                                                       |
| ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- |
| `organizationRoleId`                                                                              | *String*                                                                                          | :heavy_check_mark:                                                                                | The ID of the organization role to update                                                         |
| `requestBody`                                                                                     | [UpdateOrganizationRoleRequestBody](../../models/operations/UpdateOrganizationRoleRequestBody.md) | :heavy_check_mark:                                                                                | N/A                                                                                               |

### Response

**[UpdateOrganizationRoleResponse](../../models/operations/UpdateOrganizationRoleResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404, 422   | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## delete

Deletes the organization role.
The role cannot be deleted if it is currently used as the default creator role, domain default role, assigned to any members, or exists in any invitations.

### Example Usage

<!-- UsageSnippet language="java" operationID="DeleteOrganizationRole" method="delete" path="/organization_roles/{organization_role_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.DeleteOrganizationRoleResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        DeleteOrganizationRoleResponse res = sdk.organizationRoles().delete()
                .organizationRoleId("<id>")
                .call();

        if (res.deletedObject().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                 | Type                                      | Required                                  | Description                               |
| ----------------------------------------- | ----------------------------------------- | ----------------------------------------- | ----------------------------------------- |
| `organizationRoleId`                      | *String*                                  | :heavy_check_mark:                        | The ID of the organization role to delete |

### Response

**[DeleteOrganizationRoleResponse](../../models/operations/DeleteOrganizationRoleResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 401, 403, 404, 422        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## assignPermission

Assigns a permission to an organization role

### Example Usage

<!-- UsageSnippet language="java" operationID="AssignPermissionToOrganizationRole" method="post" path="/organization_roles/{organization_role_id}/permissions/{permission_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.AssignPermissionToOrganizationRoleResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        AssignPermissionToOrganizationRoleResponse res = sdk.organizationRoles().assignPermission()
                .organizationRoleId("<id>")
                .permissionId("<id>")
                .call();

        if (res.role().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                          | Type                               | Required                           | Description                        |
| ---------------------------------- | ---------------------------------- | ---------------------------------- | ---------------------------------- |
| `organizationRoleId`               | *String*                           | :heavy_check_mark:                 | The ID of the organization role    |
| `permissionId`                     | *String*                           | :heavy_check_mark:                 | The ID of the permission to assign |

### Response

**[AssignPermissionToOrganizationRoleResponse](../../models/operations/AssignPermissionToOrganizationRoleResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 401, 403, 404, 409        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## removePermission

Removes a permission from an organization role

### Example Usage

<!-- UsageSnippet language="java" operationID="RemovePermissionFromOrganizationRole" method="delete" path="/organization_roles/{organization_role_id}/permissions/{permission_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.RemovePermissionFromOrganizationRoleResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        RemovePermissionFromOrganizationRoleResponse res = sdk.organizationRoles().removePermission()
                .organizationRoleId("<id>")
                .permissionId("<id>")
                .call();

        if (res.role().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                          | Type                               | Required                           | Description                        |
| ---------------------------------- | ---------------------------------- | ---------------------------------- | ---------------------------------- |
| `organizationRoleId`               | *String*                           | :heavy_check_mark:                 | The ID of the organization role    |
| `permissionId`                     | *String*                           | :heavy_check_mark:                 | The ID of the permission to remove |

### Response

**[RemovePermissionFromOrganizationRoleResponse](../../models/operations/RemovePermissionFromOrganizationRoleResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 401, 403, 404, 422        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |