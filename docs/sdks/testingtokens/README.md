# TestingTokens
(*testingTokens()*)

## Overview

### Available Operations

* [create](#create) - Retrieve a new testing token

## create

Retrieve a new testing token.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.operations.CreateTestingTokenResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        CreateTestingTokenResponse res = sdk.testingTokens().create()
                .call();

        if (res.testingToken().isPresent()) {
            // handle response
        }
    }
}
```

### Response

**[CreateTestingTokenResponse](../../models/operations/CreateTestingTokenResponse.md)**

### Errors

| Error Type             | Status Code            | Content Type           |
| ---------------------- | ---------------------- | ---------------------- |
| models/errors/SDKError | 4XX, 5XX               | \*/\*                  |