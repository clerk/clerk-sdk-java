# Webhooks
(*webhooks()*)

## Overview

### Available Operations

* [createSvixApp](#createsvixapp) - Create a Svix app
* [deleteSvixApp](#deletesvixapp) - Delete a Svix app
* [generateSvixAuthURL](#generatesvixauthurl) - Create a Svix Dashboard URL

## createSvixApp

Create a Svix app and associate it with the current instance

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CreateSvixAppResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        CreateSvixAppResponse res = sdk.webhooks().createSvixApp()
                .call();

        if (res.svixURL().isPresent()) {
            // handle response
        }
    }
}
```

### Response

**[CreateSvixAppResponse](../../models/operations/CreateSvixAppResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## deleteSvixApp

Delete a Svix app and disassociate it from the current instance

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.DeleteSvixAppResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        DeleteSvixAppResponse res = sdk.webhooks().deleteSvixApp()
                .call();

        // handle response
    }
}
```

### Response

**[DeleteSvixAppResponse](../../models/operations/DeleteSvixAppResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## generateSvixAuthURL

Generate a new url for accessing the Svix's management dashboard for that particular instance

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.GenerateSvixAuthURLResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        GenerateSvixAuthURLResponse res = sdk.webhooks().generateSvixAuthURL()
                .call();

        if (res.svixURL().isPresent()) {
            // handle response
        }
    }
}
```

### Response

**[GenerateSvixAuthURLResponse](../../models/operations/GenerateSvixAuthURLResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |