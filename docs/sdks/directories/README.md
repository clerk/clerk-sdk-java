# Directories

## Overview

### Available Operations

* [list](#list) - List all directories
* [create](#create) - Create a directory
* [get](#get) - Retrieve a directory
* [update](#update) - Update a directory
* [delete](#delete) - Delete a directory
* [rotateApiKey](#rotateapikey) - Rotate a directory's API key
* [listGroupRoleMappings](#listgrouprolemappings) - List directory group role mappings
* [createGroupRoleMapping](#creategrouprolemapping) - Create a directory group role mapping
* [replaceGroupRoleMappings](#replacegrouprolemappings) - Replace directory group role mappings
* [deleteGroupRoleMapping](#deletegrouprolemapping) - Delete a directory group role mapping

## list

Returns a list of all directories for the instance.

### Example Usage

<!-- UsageSnippet language="java" operationID="ListDirectories" method="get" path="/directories" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.ListDirectoriesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        ListDirectoriesResponse res = sdk.directories().list()
                .limit(10L)
                .offset(0L)
                .call();

        if (res.directoryList().isPresent()) {
            System.out.println(res.directoryList().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                 | Type                                                                                                                                      | Required                                                                                                                                  | Description                                                                                                                               |
| ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- |
| `limit`                                                                                                                                   | *Optional\<Long>*                                                                                                                         | :heavy_minus_sign:                                                                                                                        | Applies a limit to the number of results returned.<br/>Can be used for paginating the results together with `offset`.                     |
| `offset`                                                                                                                                  | *Optional\<Long>*                                                                                                                         | :heavy_minus_sign:                                                                                                                        | Skip the first `offset` results when paginating.<br/>Needs to be an integer greater or equal to zero.<br/>To be used in conjunction with `limit`. |

### Response

**[ListDirectoriesResponse](../../models/operations/ListDirectoriesResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 401, 403                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## create

Create a new directory for the instance.

### Example Usage

<!-- UsageSnippet language="java" operationID="CreateDirectory" method="post" path="/directories" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CreateDirectoryResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        CreateDirectoryResponse res = sdk.directories().create()
                .call();

        if (res.directory().isPresent()) {
            System.out.println(res.directory().get());
        }
    }
}
```

### Parameters

| Parameter                                                                           | Type                                                                                | Required                                                                            | Description                                                                         |
| ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- |
| `request`                                                                           | [CreateDirectoryRequestBody](../../models/operations/CreateDirectoryRequestBody.md) | :heavy_check_mark:                                                                  | The request object to use for the request.                                          |

### Response

**[CreateDirectoryResponse](../../models/operations/CreateDirectoryResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 422        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## get

Returns the details of a directory.

### Example Usage

<!-- UsageSnippet language="java" operationID="GetDirectory" method="get" path="/directories/{directory_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.GetDirectoryResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        GetDirectoryResponse res = sdk.directories().get()
                .directoryId("<id>")
                .call();

        if (res.directory().isPresent()) {
            System.out.println(res.directory().get());
        }
    }
}
```

### Parameters

| Parameter                           | Type                                | Required                            | Description                         |
| ----------------------------------- | ----------------------------------- | ----------------------------------- | ----------------------------------- |
| `directoryId`                       | *String*                            | :heavy_check_mark:                  | The ID of the directory to retrieve |

### Response

**[GetDirectoryResponse](../../models/operations/GetDirectoryResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 401, 403, 404             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## update

Updates a directory.

### Example Usage

<!-- UsageSnippet language="java" operationID="UpdateDirectory" method="patch" path="/directories/{directory_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UpdateDirectoryResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        UpdateDirectoryResponse res = sdk.directories().update()
                .directoryId("<id>")
                .call();

        if (res.directory().isPresent()) {
            System.out.println(res.directory().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                      | Type                                                                                           | Required                                                                                       | Description                                                                                    |
| ---------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- |
| `directoryId`                                                                                  | *String*                                                                                       | :heavy_check_mark:                                                                             | The ID of the directory to update                                                              |
| `requestBody`                                                                                  | [Optional\<UpdateDirectoryRequestBody>](../../models/operations/UpdateDirectoryRequestBody.md) | :heavy_minus_sign:                                                                             | N/A                                                                                            |

### Response

**[UpdateDirectoryResponse](../../models/operations/UpdateDirectoryResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404, 422   | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## delete

Deletes a directory and stops provisioning for it. Provisioning requests authenticated
with the directory's API key are rejected afterwards.

### Example Usage

<!-- UsageSnippet language="java" operationID="DeleteDirectory" method="delete" path="/directories/{directory_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.DeleteDirectoryResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        DeleteDirectoryResponse res = sdk.directories().delete()
                .directoryId("<id>")
                .call();

        if (res.deletedObject().isPresent()) {
            System.out.println(res.deletedObject().get());
        }
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `directoryId`                     | *String*                          | :heavy_check_mark:                | The ID of the directory to delete |

### Response

**[DeleteDirectoryResponse](../../models/operations/DeleteDirectoryResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 401, 403, 404             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## rotateApiKey

Generates a new API key for the directory and returns it in the `api_key` field.
This is the only way to obtain the key after creation, so make sure to update it in
your identity provider. The previous key remains valid for a short grace period before
it expires.

### Example Usage

<!-- UsageSnippet language="java" operationID="RotateDirectoryAPIKey" method="post" path="/directories/{directory_id}/rotate_api_key" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.RotateDirectoryAPIKeyResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        RotateDirectoryAPIKeyResponse res = sdk.directories().rotateApiKey()
                .directoryId("<id>")
                .call();

        if (res.directory().isPresent()) {
            System.out.println(res.directory().get());
        }
    }
}
```

### Parameters

| Parameter                                       | Type                                            | Required                                        | Description                                     |
| ----------------------------------------------- | ----------------------------------------------- | ----------------------------------------------- | ----------------------------------------------- |
| `directoryId`                                   | *String*                                        | :heavy_check_mark:                              | The ID of the directory whose API key to rotate |

### Response

**[RotateDirectoryAPIKeyResponse](../../models/operations/RotateDirectoryAPIKeyResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 401, 403, 404             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## listGroupRoleMappings

Returns the list of directory group to organization role mappings for a directory, ordered by precedence.

### Example Usage

<!-- UsageSnippet language="java" operationID="ListDirectoryGroupRoleMappings" method="get" path="/directories/{directory_id}/group_role_mappings" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.ListDirectoryGroupRoleMappingsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        ListDirectoryGroupRoleMappingsResponse res = sdk.directories().listGroupRoleMappings()
                .directoryId("<id>")
                .call();

        if (res.directoryGroupRoleMappingList().isPresent()) {
            System.out.println(res.directoryGroupRoleMappingList().get());
        }
    }
}
```

### Parameters

| Parameter                | Type                     | Required                 | Description              |
| ------------------------ | ------------------------ | ------------------------ | ------------------------ |
| `directoryId`            | *String*                 | :heavy_check_mark:       | The ID of the directory. |

### Response

**[ListDirectoryGroupRoleMappingsResponse](../../models/operations/ListDirectoryGroupRoleMappingsResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 401, 403, 404             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## createGroupRoleMapping

Creates a new directory group to organization role mapping for a directory.
Group role mapping must be enabled on the directory.

### Example Usage

<!-- UsageSnippet language="java" operationID="CreateDirectoryGroupRoleMapping" method="post" path="/directories/{directory_id}/group_role_mappings" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CreateDirectoryGroupRoleMappingRequestBody;
import com.clerk.backend_api.models.operations.CreateDirectoryGroupRoleMappingResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        CreateDirectoryGroupRoleMappingResponse res = sdk.directories().createGroupRoleMapping()
                .directoryId("<id>")
                .requestBody(CreateDirectoryGroupRoleMappingRequestBody.builder()
                    .roleId("<id>")
                    .build())
                .call();

        if (res.directoryGroupRoleMapping().isPresent()) {
            System.out.println(res.directoryGroupRoleMapping().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                           | Type                                                                                                                | Required                                                                                                            | Description                                                                                                         |
| ------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------- |
| `directoryId`                                                                                                       | *String*                                                                                                            | :heavy_check_mark:                                                                                                  | The ID of the directory.                                                                                            |
| `requestBody`                                                                                                       | [CreateDirectoryGroupRoleMappingRequestBody](../../models/operations/CreateDirectoryGroupRoleMappingRequestBody.md) | :heavy_check_mark:                                                                                                  | N/A                                                                                                                 |

### Response

**[CreateDirectoryGroupRoleMappingResponse](../../models/operations/CreateDirectoryGroupRoleMappingResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404, 422   | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## replaceGroupRoleMappings

Replaces the entire set of directory group role mappings for a directory. The position of
each item in the `mappings` array determines its precedence (the first item gets
precedence 1). Passing an empty array removes all mappings. Group role mapping must be
enabled on the directory.

### Example Usage

<!-- UsageSnippet language="java" operationID="ReplaceDirectoryGroupRoleMappings" method="put" path="/directories/{directory_id}/group_role_mappings" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.*;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        ReplaceDirectoryGroupRoleMappingsResponse res = sdk.directories().replaceGroupRoleMappings()
                .directoryId("<id>")
                .requestBody(ReplaceDirectoryGroupRoleMappingsRequestBody.builder()
                    .mappings(List.of(
                        ReplaceDirectoryGroupRoleMappingsMappings.builder()
                            .roleId("<id>")
                            .build()))
                    .build())
                .call();

        if (res.directoryGroupRoleMappingList().isPresent()) {
            System.out.println(res.directoryGroupRoleMappingList().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                               | Type                                                                                                                    | Required                                                                                                                | Description                                                                                                             |
| ----------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------- |
| `directoryId`                                                                                                           | *String*                                                                                                                | :heavy_check_mark:                                                                                                      | The ID of the directory.                                                                                                |
| `requestBody`                                                                                                           | [ReplaceDirectoryGroupRoleMappingsRequestBody](../../models/operations/ReplaceDirectoryGroupRoleMappingsRequestBody.md) | :heavy_check_mark:                                                                                                      | N/A                                                                                                                     |

### Response

**[ReplaceDirectoryGroupRoleMappingsResponse](../../models/operations/ReplaceDirectoryGroupRoleMappingsResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404, 422   | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## deleteGroupRoleMapping

Deletes a single directory group role mapping. Group role mapping must be enabled on the
directory.

### Example Usage

<!-- UsageSnippet language="java" operationID="DeleteDirectoryGroupRoleMapping" method="delete" path="/directories/{directory_id}/group_role_mappings/{mapping_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.DeleteDirectoryGroupRoleMappingResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        DeleteDirectoryGroupRoleMappingResponse res = sdk.directories().deleteGroupRoleMapping()
                .directoryId("<id>")
                .mappingId("<id>")
                .call();

        if (res.directoryGroupRoleMappingDeleted().isPresent()) {
            System.out.println(res.directoryGroupRoleMappingDeleted().get());
        }
    }
}
```

### Parameters

| Parameter                                             | Type                                                  | Required                                              | Description                                           |
| ----------------------------------------------------- | ----------------------------------------------------- | ----------------------------------------------------- | ----------------------------------------------------- |
| `directoryId`                                         | *String*                                              | :heavy_check_mark:                                    | The ID of the directory.                              |
| `mappingId`                                           | *String*                                              | :heavy_check_mark:                                    | The ID of the directory group role mapping to delete. |

### Response

**[DeleteDirectoryGroupRoleMappingResponse](../../models/operations/DeleteDirectoryGroupRoleMappingResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |