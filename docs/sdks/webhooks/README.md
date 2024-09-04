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
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.CreateSvixAppResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            CreateSvixAppResponse res = sdk.webhooks().createSvixApp()
                .call();

            if (res.svixURL().isPresent()) {
                // handle response
            }
        } catch (com.clerk.backend_api.models.errors.ClerkErrors e) {
            // handle exception
            throw e;
        } catch (SDKError e) {
            // handle exception
            throw e;
        } catch (Exception e) {
            // handle exception
            throw e;
        }

    }
}
```

### Response

**[CreateSvixAppResponse](../../models/operations/CreateSvixAppResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400                       | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## deleteSvixApp

Delete a Svix app and disassociate it from the current instance

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.DeleteSvixAppResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            DeleteSvixAppResponse res = sdk.webhooks().deleteSvixApp()
                .call();

            // handle response
        } catch (com.clerk.backend_api.models.errors.ClerkErrors e) {
            // handle exception
            throw e;
        } catch (SDKError e) {
            // handle exception
            throw e;
        } catch (Exception e) {
            // handle exception
            throw e;
        }

    }
}
```

### Response

**[DeleteSvixAppResponse](../../models/operations/DeleteSvixAppResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400                       | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## generateSvixAuthURL

Generate a new url for accessing the Svix's management dashboard for that particular instance

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.GenerateSvixAuthURLResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            GenerateSvixAuthURLResponse res = sdk.webhooks().generateSvixAuthURL()
                .call();

            if (res.svixURL().isPresent()) {
                // handle response
            }
        } catch (com.clerk.backend_api.models.errors.ClerkErrors e) {
            // handle exception
            throw e;
        } catch (SDKError e) {
            // handle exception
            throw e;
        } catch (Exception e) {
            // handle exception
            throw e;
        }

    }
}
```

### Response

**[GenerateSvixAuthURLResponse](../../models/operations/GenerateSvixAuthURLResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400                       | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |
