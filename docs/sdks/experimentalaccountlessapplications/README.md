# ExperimentalAccountlessApplications
(*experimentalAccountlessApplications()*)

## Overview

### Available Operations

* [create](#create) - Create an accountless application [EXPERIMENTAL]
* [complete](#complete) - Complete an accountless application [EXPERIMENTAL]

## create

Creates a new accountless application. [EXPERIMENTAL]

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CreateAccountlessApplicationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        CreateAccountlessApplicationResponse res = sdk.experimentalAccountlessApplications().create()
                .call();

        if (res.accountlessApplication().isPresent()) {
            // handle response
        }
    }
}
```

### Response

**[CreateAccountlessApplicationResponse](../../models/operations/CreateAccountlessApplicationResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 500                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## complete

Completes an accountless application. [EXPERIMENTAL]

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CompleteAccountlessApplicationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        CompleteAccountlessApplicationResponse res = sdk.experimentalAccountlessApplications().complete()
                .call();

        if (res.accountlessApplication().isPresent()) {
            // handle response
        }
    }
}
```

### Response

**[CompleteAccountlessApplicationResponse](../../models/operations/CompleteAccountlessApplicationResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 500                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |