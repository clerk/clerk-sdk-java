# ScimDirectories

## Overview

### Available Operations

* [list](#list) - List all directories
* [create](#create) - Create a directory
* [get](#get) - Retrieve a directory
* [update](#update) - Update a directory
* [delete](#delete) - Delete a directory
* [rotateApiKey](#rotateapikey) - Rotate a directory's API key
* [listGroupRoleMappings](#listgrouprolemappings) - List SCIM group role mappings
* [createGroupRoleMapping](#creategrouprolemapping) - Create a SCIM group role mapping
* [replaceGroupRoleMappings](#replacegrouprolemappings) - Replace SCIM group role mappings
* [deleteGroupRoleMapping](#deletegrouprolemapping) - Delete a SCIM group role mapping

## list

Returns a list of all directories for the instance.

### Example Usage

<!-- UsageSnippet language="java" operationID="ListSCIMDirectories" method="get" path="/scim_directories" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.ListSCIMDirectoriesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        ListSCIMDirectoriesResponse res = sdk.scimDirectories().list()
                .limit(10L)
                .offset(0L)
                .call();

        if (res.scimDirectoryList().isPresent()) {
            System.out.println(res.scimDirectoryList().get());
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

**[ListSCIMDirectoriesResponse](../../models/operations/ListSCIMDirectoriesResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 401, 403                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## create

Create a new directory for the instance.

### Example Usage

<!-- UsageSnippet language="java" operationID="CreateSCIMDirectory" method="post" path="/scim_directories" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CreateSCIMDirectoryResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        CreateSCIMDirectoryResponse res = sdk.scimDirectories().create()
                .call();

        if (res.scimDirectory().isPresent()) {
            System.out.println(res.scimDirectory().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                   | Type                                                                                        | Required                                                                                    | Description                                                                                 |
| ------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------- |
| `request`                                                                                   | [CreateSCIMDirectoryRequestBody](../../models/operations/CreateSCIMDirectoryRequestBody.md) | :heavy_check_mark:                                                                          | The request object to use for the request.                                                  |

### Response

**[CreateSCIMDirectoryResponse](../../models/operations/CreateSCIMDirectoryResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 422        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## get

Returns the details of a directory.

### Example Usage

<!-- UsageSnippet language="java" operationID="GetSCIMDirectory" method="get" path="/scim_directories/{scim_directory_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.GetSCIMDirectoryResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        GetSCIMDirectoryResponse res = sdk.scimDirectories().get()
                .scimDirectoryId("<id>")
                .call();

        if (res.scimDirectory().isPresent()) {
            System.out.println(res.scimDirectory().get());
        }
    }
}
```

### Parameters

| Parameter                           | Type                                | Required                            | Description                         |
| ----------------------------------- | ----------------------------------- | ----------------------------------- | ----------------------------------- |
| `scimDirectoryId`                   | *String*                            | :heavy_check_mark:                  | The ID of the directory to retrieve |

### Response

**[GetSCIMDirectoryResponse](../../models/operations/GetSCIMDirectoryResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 401, 403, 404             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## update

Updates a directory.

### Example Usage

<!-- UsageSnippet language="java" operationID="UpdateSCIMDirectory" method="patch" path="/scim_directories/{scim_directory_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UpdateSCIMDirectoryResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        UpdateSCIMDirectoryResponse res = sdk.scimDirectories().update()
                .scimDirectoryId("<id>")
                .call();

        if (res.scimDirectory().isPresent()) {
            System.out.println(res.scimDirectory().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                              | Type                                                                                                   | Required                                                                                               | Description                                                                                            |
| ------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------ |
| `scimDirectoryId`                                                                                      | *String*                                                                                               | :heavy_check_mark:                                                                                     | The ID of the directory to update                                                                      |
| `requestBody`                                                                                          | [Optional\<UpdateSCIMDirectoryRequestBody>](../../models/operations/UpdateSCIMDirectoryRequestBody.md) | :heavy_minus_sign:                                                                                     | N/A                                                                                                    |

### Response

**[UpdateSCIMDirectoryResponse](../../models/operations/UpdateSCIMDirectoryResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404, 422   | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## delete

Deletes a directory and stops provisioning for it. SCIM requests authenticated
with the directory's API key are rejected afterwards.

### Example Usage

<!-- UsageSnippet language="java" operationID="DeleteSCIMDirectory" method="delete" path="/scim_directories/{scim_directory_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.DeleteSCIMDirectoryResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        DeleteSCIMDirectoryResponse res = sdk.scimDirectories().delete()
                .scimDirectoryId("<id>")
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
| `scimDirectoryId`                 | *String*                          | :heavy_check_mark:                | The ID of the directory to delete |

### Response

**[DeleteSCIMDirectoryResponse](../../models/operations/DeleteSCIMDirectoryResponse.md)**

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

<!-- UsageSnippet language="java" operationID="RotateSCIMDirectoryAPIKey" method="post" path="/scim_directories/{scim_directory_id}/rotate_api_key" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.RotateSCIMDirectoryAPIKeyResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        RotateSCIMDirectoryAPIKeyResponse res = sdk.scimDirectories().rotateApiKey()
                .scimDirectoryId("<id>")
                .call();

        if (res.scimDirectory().isPresent()) {
            System.out.println(res.scimDirectory().get());
        }
    }
}
```

### Parameters

| Parameter                                       | Type                                            | Required                                        | Description                                     |
| ----------------------------------------------- | ----------------------------------------------- | ----------------------------------------------- | ----------------------------------------------- |
| `scimDirectoryId`                               | *String*                                        | :heavy_check_mark:                              | The ID of the directory whose API key to rotate |

### Response

**[RotateSCIMDirectoryAPIKeyResponse](../../models/operations/RotateSCIMDirectoryAPIKeyResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 401, 403, 404             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## listGroupRoleMappings

Returns the list of SCIM group to organization role mappings for a directory, ordered by precedence.

### Example Usage

<!-- UsageSnippet language="java" operationID="ListSCIMGroupRoleMappings" method="get" path="/scim_directories/{scim_directory_id}/group_role_mappings" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.ListSCIMGroupRoleMappingsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        ListSCIMGroupRoleMappingsResponse res = sdk.scimDirectories().listGroupRoleMappings()
                .scimDirectoryId("<id>")
                .call();

        if (res.scimGroupRoleMappingList().isPresent()) {
            System.out.println(res.scimGroupRoleMappingList().get());
        }
    }
}
```

### Parameters

| Parameter                | Type                     | Required                 | Description              |
| ------------------------ | ------------------------ | ------------------------ | ------------------------ |
| `scimDirectoryId`        | *String*                 | :heavy_check_mark:       | The ID of the directory. |

### Response

**[ListSCIMGroupRoleMappingsResponse](../../models/operations/ListSCIMGroupRoleMappingsResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 401, 403, 404             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## createGroupRoleMapping

Creates a new SCIM group to organization role mapping for a directory.
Group role mapping must be enabled on the directory.

### Example Usage

<!-- UsageSnippet language="java" operationID="CreateSCIMGroupRoleMapping" method="post" path="/scim_directories/{scim_directory_id}/group_role_mappings" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CreateSCIMGroupRoleMappingRequestBody;
import com.clerk.backend_api.models.operations.CreateSCIMGroupRoleMappingResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        CreateSCIMGroupRoleMappingResponse res = sdk.scimDirectories().createGroupRoleMapping()
                .scimDirectoryId("<id>")
                .requestBody(CreateSCIMGroupRoleMappingRequestBody.builder()
                    .scimGroupId("<id>")
                    .roleId("<id>")
                    .build())
                .call();

        if (res.scimGroupRoleMapping().isPresent()) {
            System.out.println(res.scimGroupRoleMapping().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                 | Type                                                                                                      | Required                                                                                                  | Description                                                                                               |
| --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- |
| `scimDirectoryId`                                                                                         | *String*                                                                                                  | :heavy_check_mark:                                                                                        | The ID of the directory.                                                                                  |
| `requestBody`                                                                                             | [CreateSCIMGroupRoleMappingRequestBody](../../models/operations/CreateSCIMGroupRoleMappingRequestBody.md) | :heavy_check_mark:                                                                                        | N/A                                                                                                       |

### Response

**[CreateSCIMGroupRoleMappingResponse](../../models/operations/CreateSCIMGroupRoleMappingResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404, 422   | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## replaceGroupRoleMappings

Replaces the entire set of SCIM group role mappings for a directory. The position of
each item in the `mappings` array determines its precedence (the first item gets
precedence 1). Passing an empty array removes all mappings. Group role mapping must be
enabled on the directory.

### Example Usage

<!-- UsageSnippet language="java" operationID="ReplaceSCIMGroupRoleMappings" method="put" path="/scim_directories/{scim_directory_id}/group_role_mappings" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.ReplaceSCIMGroupRoleMappingsRequestBody;
import com.clerk.backend_api.models.operations.ReplaceSCIMGroupRoleMappingsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        ReplaceSCIMGroupRoleMappingsResponse res = sdk.scimDirectories().replaceGroupRoleMappings()
                .scimDirectoryId("<id>")
                .requestBody(ReplaceSCIMGroupRoleMappingsRequestBody.builder()
                    .mappings(List.of())
                    .build())
                .call();

        if (res.scimGroupRoleMappingList().isPresent()) {
            System.out.println(res.scimGroupRoleMappingList().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                     | Type                                                                                                          | Required                                                                                                      | Description                                                                                                   |
| ------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- |
| `scimDirectoryId`                                                                                             | *String*                                                                                                      | :heavy_check_mark:                                                                                            | The ID of the directory.                                                                                      |
| `requestBody`                                                                                                 | [ReplaceSCIMGroupRoleMappingsRequestBody](../../models/operations/ReplaceSCIMGroupRoleMappingsRequestBody.md) | :heavy_check_mark:                                                                                            | N/A                                                                                                           |

### Response

**[ReplaceSCIMGroupRoleMappingsResponse](../../models/operations/ReplaceSCIMGroupRoleMappingsResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404, 422   | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## deleteGroupRoleMapping

Deletes a single SCIM group role mapping. Group role mapping must be enabled on the
directory.

### Example Usage

<!-- UsageSnippet language="java" operationID="DeleteSCIMGroupRoleMapping" method="delete" path="/scim_directories/{scim_directory_id}/group_role_mappings/{mapping_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.DeleteSCIMGroupRoleMappingResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        DeleteSCIMGroupRoleMappingResponse res = sdk.scimDirectories().deleteGroupRoleMapping()
                .scimDirectoryId("<id>")
                .mappingId("<id>")
                .call();

        if (res.scimGroupRoleMappingDeleted().isPresent()) {
            System.out.println(res.scimGroupRoleMappingDeleted().get());
        }
    }
}
```

### Parameters

| Parameter                                        | Type                                             | Required                                         | Description                                      |
| ------------------------------------------------ | ------------------------------------------------ | ------------------------------------------------ | ------------------------------------------------ |
| `scimDirectoryId`                                | *String*                                         | :heavy_check_mark:                               | The ID of the directory.                         |
| `mappingId`                                      | *String*                                         | :heavy_check_mark:                               | The ID of the SCIM group role mapping to delete. |

### Response

**[DeleteSCIMGroupRoleMappingResponse](../../models/operations/DeleteSCIMGroupRoleMappingResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |