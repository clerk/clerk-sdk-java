# Jwks
(*jwks()*)

## Overview

### Available Operations

* [get](#get) - Retrieve the JSON Web Key Set of the instance

## get

Retrieve the JSON Web Key Set of the instance

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.operations.GetJWKSResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        GetJWKSResponse res = sdk.jwks().get()
                .call();

        if (res.jwks().isPresent()) {
            // handle response
        }
    }
}
```

### Response

**[GetJWKSResponse](../../models/operations/GetJWKSResponse.md)**

### Errors

| Error Type             | Status Code            | Content Type           |
| ---------------------- | ---------------------- | ---------------------- |
| models/errors/SDKError | 4XX, 5XX               | \*/\*                  |