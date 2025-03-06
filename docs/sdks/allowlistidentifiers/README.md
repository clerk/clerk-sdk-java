# AllowlistIdentifiers
(*allowlistIdentifiers()*)

## Overview

### Available Operations

* [list](#list) - List all identifiers on the allow-list
* [create](#create) - Add identifier to the allow-list
* [delete](#delete) - Delete identifier from allow-list

## list

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

        ListAllowlistIdentifiersResponse res = sdk.allowlistIdentifiers().list()
                .paginated(false)
                .limit(10L)
                .offset(0L)
                .call();

        if (res.allowlistIdentifierList().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                 | Type                                                                                                                                      | Required                                                                                                                                  | Description                                                                                                                               |
| ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- |
| `paginated`                                                                                                                               | *Optional\<Boolean>*                                                                                                                      | :heavy_minus_sign:                                                                                                                        | Whether to paginate the results.<br/>If true, the results will be paginated.<br/>If false, the results will not be paginated.             |
| `limit`                                                                                                                                   | *Optional\<Long>*                                                                                                                         | :heavy_minus_sign:                                                                                                                        | Applies a limit to the number of results returned.<br/>Can be used for paginating the results together with `offset`.                     |
| `offset`                                                                                                                                  | *Optional\<Long>*                                                                                                                         | :heavy_minus_sign:                                                                                                                        | Skip the first `offset` results when paginating.<br/>Needs to be an integer greater or equal to zero.<br/>To be used in conjunction with `limit`. |

### Response

**[ListAllowlistIdentifiersResponse](../../models/operations/ListAllowlistIdentifiersResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 401, 402                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## create

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

        CreateAllowlistIdentifierResponse res = sdk.allowlistIdentifiers().create()
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

## delete

Delete an identifier from the instance allow-list

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.DeleteAllowlistIdentifierResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        DeleteAllowlistIdentifierResponse res = sdk.allowlistIdentifiers().delete()
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
| `identifierId`                                         | *String*                                               | :heavy_check_mark:                                     | The ID of the identifier to delete from the allow-list |

### Response

**[DeleteAllowlistIdentifierResponse](../../models/operations/DeleteAllowlistIdentifierResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 402, 404                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |