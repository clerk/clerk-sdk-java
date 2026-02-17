# RoleSets

## Overview

### Available Operations

* [list](#list) - Get a list of role sets
* [create](#create) - Create a role set
* [get](#get) - Retrieve a role set
* [update](#update) - Update a role set
* [replace](#replace) - Replace a role set
* [addRoles](#addroles) - Add roles to a role set
* [replaceRole](#replacerole) - Replace a role in a role set

## list

Returns a list of role sets for the instance.
Results can be paginated using the optional `limit` and `offset` query parameters.
The role sets are ordered by descending creation date by default.

### Example Usage

<!-- UsageSnippet language="java" operationID="ListRoleSets" method="get" path="/role_sets" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.ListRoleSetsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        ListRoleSetsResponse res = sdk.roleSets().list()
                .orderBy("-created_at")
                .limit(10L)
                .offset(0L)
                .call();

        if (res.roleSets().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                                                                                                                                                                                                                                                                      | Type                                                                                                                                                                                                                                                                                                                                                                                                                                                                           | Required                                                                                                                                                                                                                                                                                                                                                                                                                                                                       | Description                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| `query`                                                                                                                                                                                                                                                                                                                                                                                                                                                                        | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                                                                                                            | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                                                                                             | Returns role sets with ID, name, or key that match the given query.<br/>Uses exact match for role set ID and partial match for name and key.                                                                                                                                                                                                                                                                                                                                   |
| `orderBy`                                                                                                                                                                                                                                                                                                                                                                                                                                                                      | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                                                                                                            | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                                                                                             | Allows to return role sets in a particular order.<br/>At the moment, you can order the returned role sets by their `created_at`, `name`, or `key`.<br/>In order to specify the direction, you can use the `+/-` symbols prepended in the property to order by.<br/>For example, if you want role sets to be returned in descending order according to their `created_at` property, you can use `-created_at`.<br/>If you don't use `+` or `-`, then `+` is implied.<br/>Defaults to `-created_at`. |
| `limit`                                                                                                                                                                                                                                                                                                                                                                                                                                                                        | *Optional\<Long>*                                                                                                                                                                                                                                                                                                                                                                                                                                                              | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                                                                                             | Applies a limit to the number of results returned.<br/>Can be used for paginating the results together with `offset`.                                                                                                                                                                                                                                                                                                                                                          |
| `offset`                                                                                                                                                                                                                                                                                                                                                                                                                                                                       | *Optional\<Long>*                                                                                                                                                                                                                                                                                                                                                                                                                                                              | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                                                                                             | Skip the first `offset` results when paginating.<br/>Needs to be an integer greater or equal to zero.<br/>To be used in conjunction with `limit`.                                                                                                                                                                                                                                                                                                                              |

### Response

**[ListRoleSetsResponse](../../models/operations/ListRoleSetsResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 422        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## create

Creates a new role set with the given name and roles.
The key must be unique for the instance and start with the 'role_set:' prefix, followed by lowercase alphanumeric characters and underscores only.
You must provide at least one role and specify a default role key and creator role key.

### Example Usage

<!-- UsageSnippet language="java" operationID="CreateRoleSet" method="post" path="/role_sets" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CreateRoleSetRequestBody;
import com.clerk.backend_api.models.operations.CreateRoleSetResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        CreateRoleSetRequestBody req = CreateRoleSetRequestBody.builder()
                .name("<value>")
                .defaultRoleKey("<value>")
                .creatorRoleKey("<value>")
                .roles(List.of(
                    "<value 1>",
                    "<value 2>"))
                .build();

        CreateRoleSetResponse res = sdk.roleSets().create()
                .request(req)
                .call();

        if (res.roleSet().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                       | Type                                                                            | Required                                                                        | Description                                                                     |
| ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| `request`                                                                       | [CreateRoleSetRequestBody](../../models/operations/CreateRoleSetRequestBody.md) | :heavy_check_mark:                                                              | The request object to use for the request.                                      |

### Response

**[CreateRoleSetResponse](../../models/operations/CreateRoleSetResponse.md)**

### Errors

| Error Type                   | Status Code                  | Content Type                 |
| ---------------------------- | ---------------------------- | ---------------------------- |
| models/errors/ClerkErrors    | 400, 401, 402, 403, 404, 422 | application/json             |
| models/errors/SDKError       | 4XX, 5XX                     | \*/\*                        |

## get

Retrieves an existing role set by its key or ID.

### Example Usage

<!-- UsageSnippet language="java" operationID="GetRoleSet" method="get" path="/role_sets/{role_set_key_or_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.GetRoleSetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        GetRoleSetResponse res = sdk.roleSets().get()
                .roleSetKeyOrId("<id>")
                .call();

        if (res.roleSet().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                     | Type                          | Required                      | Description                   |
| ----------------------------- | ----------------------------- | ----------------------------- | ----------------------------- |
| `roleSetKeyOrId`              | *String*                      | :heavy_check_mark:            | The key or ID of the role set |

### Response

**[GetRoleSetResponse](../../models/operations/GetRoleSetResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 401, 403, 404             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## update

Updates an existing role set.
You can update the name, key, description, type, default role, or creator role.
All parameters are optional - you can update only the fields you want to change.

### Example Usage

<!-- UsageSnippet language="java" operationID="UpdateRoleSet" method="patch" path="/role_sets/{role_set_key_or_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UpdateRoleSetRequestBody;
import com.clerk.backend_api.models.operations.UpdateRoleSetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        UpdateRoleSetResponse res = sdk.roleSets().update()
                .roleSetKeyOrId("<id>")
                .requestBody(UpdateRoleSetRequestBody.builder()
                    .build())
                .call();

        if (res.roleSet().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                       | Type                                                                            | Required                                                                        | Description                                                                     |
| ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| `roleSetKeyOrId`                                                                | *String*                                                                        | :heavy_check_mark:                                                              | The key or ID of the role set to update                                         |
| `requestBody`                                                                   | [UpdateRoleSetRequestBody](../../models/operations/UpdateRoleSetRequestBody.md) | :heavy_check_mark:                                                              | N/A                                                                             |

### Response

**[UpdateRoleSetResponse](../../models/operations/UpdateRoleSetResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404, 422   | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## replace

Replaces a role set with another role set. This is functionally equivalent to deleting
the role set but allows for atomic replacement with migration support.
Organizations using this role set will be migrated to the destination role set.

### Example Usage

<!-- UsageSnippet language="java" operationID="ReplaceRoleSet" method="post" path="/role_sets/{role_set_key_or_id}/replace" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.ReplaceRoleSetRequestBody;
import com.clerk.backend_api.models.operations.ReplaceRoleSetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        ReplaceRoleSetResponse res = sdk.roleSets().replace()
                .roleSetKeyOrId("<id>")
                .requestBody(ReplaceRoleSetRequestBody.builder()
                    .destRoleSetKey("<value>")
                    .build())
                .call();

        if (res.deletedObject().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                         | Type                                                                              | Required                                                                          | Description                                                                       |
| --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| `roleSetKeyOrId`                                                                  | *String*                                                                          | :heavy_check_mark:                                                                | The key or ID of the role set to replace                                          |
| `requestBody`                                                                     | [ReplaceRoleSetRequestBody](../../models/operations/ReplaceRoleSetRequestBody.md) | :heavy_check_mark:                                                                | N/A                                                                               |

### Response

**[ReplaceRoleSetResponse](../../models/operations/ReplaceRoleSetResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404, 422   | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## addRoles

Adds one or more roles to an existing role set.
You can optionally update the default role or creator role when adding new roles.

### Example Usage

<!-- UsageSnippet language="java" operationID="AddRolesToRoleSet" method="post" path="/role_sets/{role_set_key_or_id}/roles" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.AddRolesToRoleSetRequestBody;
import com.clerk.backend_api.models.operations.AddRolesToRoleSetResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        AddRolesToRoleSetResponse res = sdk.roleSets().addRoles()
                .roleSetKeyOrId("<id>")
                .requestBody(AddRolesToRoleSetRequestBody.builder()
                    .roleKeys(List.of(
                        "<value 1>",
                        "<value 2>"))
                    .build())
                .call();

        if (res.roleSet().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                               | Type                                                                                    | Required                                                                                | Description                                                                             |
| --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- |
| `roleSetKeyOrId`                                                                        | *String*                                                                                | :heavy_check_mark:                                                                      | The key or ID of the role set                                                           |
| `requestBody`                                                                           | [AddRolesToRoleSetRequestBody](../../models/operations/AddRolesToRoleSetRequestBody.md) | :heavy_check_mark:                                                                      | N/A                                                                                     |

### Response

**[AddRolesToRoleSetResponse](../../models/operations/AddRolesToRoleSetResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404, 422   | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## replaceRole

Replaces a role in a role set with another role. This atomically removes
the source role and reassigns any members to the destination role.

### Example Usage

<!-- UsageSnippet language="java" operationID="ReplaceRoleInRoleSet" method="post" path="/role_sets/{role_set_key_or_id}/roles/replace" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.ReplaceRoleInRoleSetRequestBody;
import com.clerk.backend_api.models.operations.ReplaceRoleInRoleSetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        ReplaceRoleInRoleSetResponse res = sdk.roleSets().replaceRole()
                .roleSetKeyOrId("<id>")
                .requestBody(ReplaceRoleInRoleSetRequestBody.builder()
                    .roleKey("<value>")
                    .toRoleKey("<value>")
                    .build())
                .call();

        if (res.roleSet().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                     | Type                                                                                          | Required                                                                                      | Description                                                                                   |
| --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- |
| `roleSetKeyOrId`                                                                              | *String*                                                                                      | :heavy_check_mark:                                                                            | The key or ID of the role set                                                                 |
| `requestBody`                                                                                 | [ReplaceRoleInRoleSetRequestBody](../../models/operations/ReplaceRoleInRoleSetRequestBody.md) | :heavy_check_mark:                                                                            | N/A                                                                                           |

### Response

**[ReplaceRoleInRoleSetResponse](../../models/operations/ReplaceRoleInRoleSetResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404, 422   | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |