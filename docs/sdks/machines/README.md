# Machines
(*machines()*)

## Overview

### Available Operations

* [list](#list) - Get a list of machines for an instance
* [create](#create) - Create a machine
* [get](#get) - Retrieve a machine
* [update](#update) - Update a machine
* [delete](#delete) - Delete a machine
* [getSecretKey](#getsecretkey) - Retrieve a machine secret key
* [createScope](#createscope) - Create a machine scope
* [deleteScope](#deletescope) - Delete a machine scope

## list

This request returns the list of machines for an instance. The machines are
ordered by descending creation date (i.e. most recent machines will be
returned first)

### Example Usage

<!-- UsageSnippet language="java" operationID="ListMachines" method="get" path="/machines" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.ListMachinesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        ListMachinesResponse res = sdk.machines().list()
                .limit(10L)
                .offset(0L)
                .orderBy("-created_at")
                .call();

        if (res.machineList().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                                                                                                                                                                              | Type                                                                                                                                                                                                                                                                                                                                                                                   | Required                                                                                                                                                                                                                                                                                                                                                                               | Description                                                                                                                                                                                                                                                                                                                                                                            |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `limit`                                                                                                                                                                                                                                                                                                                                                                                | *Optional\<Long>*                                                                                                                                                                                                                                                                                                                                                                      | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Applies a limit to the number of results returned.<br/>Can be used for paginating the results together with `offset`.                                                                                                                                                                                                                                                                  |
| `offset`                                                                                                                                                                                                                                                                                                                                                                               | *Optional\<Long>*                                                                                                                                                                                                                                                                                                                                                                      | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Skip the first `offset` results when paginating.<br/>Needs to be an integer greater or equal to zero.<br/>To be used in conjunction with `limit`.                                                                                                                                                                                                                                      |
| `query`                                                                                                                                                                                                                                                                                                                                                                                | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                    | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Returns machines with ID or name that match the given query. Uses exact match for machine ID and partial match for name.                                                                                                                                                                                                                                                               |
| `orderBy`                                                                                                                                                                                                                                                                                                                                                                              | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                    | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Allows to return machines in a particular order.<br/>You can order the returned machines by their `name` or `created_at`.<br/>To specify the direction, use the `+` or `-` symbols prepended to the property to order by.<br/>For example, to return machines in descending order by `created_at`, use `-created_at`.<br/>If you don't use `+` or `-`, then `+` is implied.<br/>Defaults to `-created_at`. |

### Response

**[ListMachinesResponse](../../models/operations/ListMachinesResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 422        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## create

Creates a new machine.

### Example Usage

<!-- UsageSnippet language="java" operationID="CreateMachine" method="post" path="/machines" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CreateMachineResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        CreateMachineResponse res = sdk.machines().create()
                .call();

        if (res.machineCreated().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                       | Type                                                                            | Required                                                                        | Description                                                                     |
| ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| `request`                                                                       | [CreateMachineRequestBody](../../models/operations/CreateMachineRequestBody.md) | :heavy_check_mark:                                                              | The request object to use for the request.                                      |

### Response

**[CreateMachineResponse](../../models/operations/CreateMachineResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 422        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## get

Returns the details of a machine.

### Example Usage

<!-- UsageSnippet language="java" operationID="GetMachine" method="get" path="/machines/{machine_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.GetMachineResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        GetMachineResponse res = sdk.machines().get()
                .machineId("<id>")
                .call();

        if (res.machine().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `machineId`                       | *String*                          | :heavy_check_mark:                | The ID of the machine to retrieve |

### Response

**[GetMachineResponse](../../models/operations/GetMachineResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404, 422   | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## update

Updates an existing machine.
Only the provided fields will be updated.

### Example Usage

<!-- UsageSnippet language="java" operationID="UpdateMachine" method="patch" path="/machines/{machine_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UpdateMachineResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        UpdateMachineResponse res = sdk.machines().update()
                .machineId("<id>")
                .call();

        if (res.machine().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                  | Type                                                                                       | Required                                                                                   | Description                                                                                |
| ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ |
| `machineId`                                                                                | *String*                                                                                   | :heavy_check_mark:                                                                         | The ID of the machine to update                                                            |
| `requestBody`                                                                              | [Optional\<UpdateMachineRequestBody>](../../models/operations/UpdateMachineRequestBody.md) | :heavy_minus_sign:                                                                         | N/A                                                                                        |

### Response

**[UpdateMachineResponse](../../models/operations/UpdateMachineResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404, 422   | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## delete

Deletes a machine.

### Example Usage

<!-- UsageSnippet language="java" operationID="DeleteMachine" method="delete" path="/machines/{machine_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.DeleteMachineResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        DeleteMachineResponse res = sdk.machines().delete()
                .machineId("<id>")
                .call();

        if (res.machineDeleted().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                       | Type                            | Required                        | Description                     |
| ------------------------------- | ------------------------------- | ------------------------------- | ------------------------------- |
| `machineId`                     | *String*                        | :heavy_check_mark:              | The ID of the machine to delete |

### Response

**[DeleteMachineResponse](../../models/operations/DeleteMachineResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404, 422   | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## getSecretKey

Returns the secret key for a machine.

### Example Usage

<!-- UsageSnippet language="java" operationID="GetMachineSecretKey" method="get" path="/machines/{machine_id}/secret_key" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.GetMachineSecretKeyResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        GetMachineSecretKeyResponse res = sdk.machines().getSecretKey()
                .machineId("<id>")
                .call();

        if (res.machineSecretKey().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                            | Type                                                 | Required                                             | Description                                          |
| ---------------------------------------------------- | ---------------------------------------------------- | ---------------------------------------------------- | ---------------------------------------------------- |
| `machineId`                                          | *String*                                             | :heavy_check_mark:                                   | The ID of the machine to retrieve the secret key for |

### Response

**[GetMachineSecretKeyResponse](../../models/operations/GetMachineSecretKeyResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## createScope

Creates a new machine scope, allowing the specified machine to access another machine.
Maximum of 25 scopes per machine.

### Example Usage

<!-- UsageSnippet language="java" operationID="CreateMachineScope" method="post" path="/machines/{machine_id}/scopes" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CreateMachineScopeResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        CreateMachineScopeResponse res = sdk.machines().createScope()
                .machineId("<id>")
                .call();

        if (res.machineScope().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                            | Type                                                                                                 | Required                                                                                             | Description                                                                                          |
| ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- |
| `machineId`                                                                                          | *String*                                                                                             | :heavy_check_mark:                                                                                   | The ID of the machine that will have access to another machine                                       |
| `requestBody`                                                                                        | [Optional\<CreateMachineScopeRequestBody>](../../models/operations/CreateMachineScopeRequestBody.md) | :heavy_minus_sign:                                                                                   | N/A                                                                                                  |

### Response

**[CreateMachineScopeResponse](../../models/operations/CreateMachineScopeResponse.md)**

### Errors

| Error Type                   | Status Code                  | Content Type                 |
| ---------------------------- | ---------------------------- | ---------------------------- |
| models/errors/ClerkErrors    | 400, 401, 403, 404, 409, 422 | application/json             |
| models/errors/SDKError       | 4XX, 5XX                     | \*/\*                        |

## deleteScope

Deletes a machine scope, removing access from one machine to another.

### Example Usage

<!-- UsageSnippet language="java" operationID="DeleteMachineScope" method="delete" path="/machines/{machine_id}/scopes/{other_machine_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.DeleteMachineScopeResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        DeleteMachineScopeResponse res = sdk.machines().deleteScope()
                .machineId("<id>")
                .otherMachineId("<id>")
                .call();

        if (res.machineScopeDeleted().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                | Type                                                     | Required                                                 | Description                                              |
| -------------------------------------------------------- | -------------------------------------------------------- | -------------------------------------------------------- | -------------------------------------------------------- |
| `machineId`                                              | *String*                                                 | :heavy_check_mark:                                       | The ID of the machine that has access to another machine |
| `otherMachineId`                                         | *String*                                                 | :heavy_check_mark:                                       | The ID of the machine that is being accessed             |

### Response

**[DeleteMachineScopeResponse](../../models/operations/DeleteMachineScopeResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404, 422   | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |