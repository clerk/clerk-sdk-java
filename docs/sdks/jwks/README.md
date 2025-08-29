# Jwks
(*jwks()*)

## Overview

### Available Operations

* [getJWKS](#getjwks) - Retrieve the JSON Web Key Set of the instance

## getJWKS

Retrieve the JSON Web Key Set of the instance

### Example Usage

<!-- UsageSnippet language="java" operationID="GetJWKS" method="get" path="/jwks" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.operations.GetJWKSResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        GetJWKSResponse res = sdk.jwks().getJWKS()
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