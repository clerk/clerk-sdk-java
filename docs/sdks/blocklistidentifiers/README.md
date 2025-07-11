# BlocklistIdentifiers
(*blocklistIdentifiers()*)

## Overview

### Available Operations

* [list](#list) - List all identifiers on the block-list
* [create](#create) - Add identifier to the block-list
* [delete](#delete) - Delete identifier from block-list

## list

Get a list of all identifiers which are not allowed to access an instance

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.ListBlocklistIdentifiersResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        ListBlocklistIdentifiersResponse res = sdk.blocklistIdentifiers().list()
                .call();

        if (res.blocklistIdentifiers().isPresent()) {
            // handle response
        }
    }
}
```

### Response

**[ListBlocklistIdentifiersResponse](../../models/operations/ListBlocklistIdentifiersResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 401, 402                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## create

Create an identifier that is blocked from accessing an instance

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CreateBlocklistIdentifierResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        CreateBlocklistIdentifierResponse res = sdk.blocklistIdentifiers().create()
                .call();

        if (res.blocklistIdentifier().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                               | Type                                                                                                    | Required                                                                                                | Description                                                                                             |
| ------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- |
| `request`                                                                                               | [CreateBlocklistIdentifierRequestBody](../../models/operations/CreateBlocklistIdentifierRequestBody.md) | :heavy_check_mark:                                                                                      | The request object to use for the request.                                                              |

### Response

**[CreateBlocklistIdentifierResponse](../../models/operations/CreateBlocklistIdentifierResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 402, 422             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## delete

Delete an identifier from the instance block-list

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.DeleteBlocklistIdentifierResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        DeleteBlocklistIdentifierResponse res = sdk.blocklistIdentifiers().delete()
                .identifierId("<id>")
                .call();

        if (res.deletedObject().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                              | Type                                                   | Required                                               | Description                                            |
| ------------------------------------------------------ | ------------------------------------------------------ | ------------------------------------------------------ | ------------------------------------------------------ |
| `identifierId`                                         | *String*                                               | :heavy_check_mark:                                     | The ID of the identifier to delete from the block-list |

### Response

**[DeleteBlocklistIdentifierResponse](../../models/operations/DeleteBlocklistIdentifierResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 402, 404                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |