# AllowlistBlocklist
(*allowlistBlocklist()*)

## Overview

### Available Operations

* [listAllowlistIdentifiers](#listallowlistidentifiers) - List all identifiers on the allow-list
* [createAllowlistIdentifier](#createallowlistidentifier) - Add identifier to the allow-list
* [createBlocklistIdentifier](#createblocklistidentifier) - Add identifier to the block-list
* [deleteBlocklistIdentifier](#deleteblocklistidentifier) - Delete identifier from block-list

## listAllowlistIdentifiers

Get a list of all identifiers allowed to sign up to an instance

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.ListAllowlistIdentifiersResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        ListAllowlistIdentifiersResponse res = sdk.allowlistBlocklist().listAllowlistIdentifiers()
                .call();

        if (res.allowlistIdentifierList().isPresent()) {
            // handle response
        }
    }
}
```

### Response

**[ListAllowlistIdentifiersResponse](../../models/operations/ListAllowlistIdentifiersResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 401, 402                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## createAllowlistIdentifier

Create an identifier allowed to sign up to an instance

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CreateAllowlistIdentifierRequestBody;
import com.clerk.backend_api.models.operations.CreateAllowlistIdentifierResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        CreateAllowlistIdentifierRequestBody req = CreateAllowlistIdentifierRequestBody.builder()
                .identifier("<value>")
                .build();

        CreateAllowlistIdentifierResponse res = sdk.allowlistBlocklist().createAllowlistIdentifier()
                .request(req)
                .call();

        if (res.allowlistIdentifier().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                               | Type                                                                                                    | Required                                                                                                | Description                                                                                             |
| ------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- |
| `request`                                                                                               | [CreateAllowlistIdentifierRequestBody](../../models/operations/CreateAllowlistIdentifierRequestBody.md) | :heavy_check_mark:                                                                                      | The request object to use for the request.                                                              |

### Response

**[CreateAllowlistIdentifierResponse](../../models/operations/CreateAllowlistIdentifierResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 402, 422             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## createBlocklistIdentifier

Create an identifier that is blocked from accessing an instance

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CreateBlocklistIdentifierRequestBody;
import com.clerk.backend_api.models.operations.CreateBlocklistIdentifierResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        CreateBlocklistIdentifierRequestBody req = CreateBlocklistIdentifierRequestBody.builder()
                .identifier("<value>")
                .build();

        CreateBlocklistIdentifierResponse res = sdk.allowlistBlocklist().createBlocklistIdentifier()
                .request(req)
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

## deleteBlocklistIdentifier

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
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        DeleteBlocklistIdentifierResponse res = sdk.allowlistBlocklist().deleteBlocklistIdentifier()
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