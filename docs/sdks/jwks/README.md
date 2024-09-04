# Jwks
(*jwks()*)

## Overview

### Available Operations

* [getJWKS](#getjwks) - Retrieve the JSON Web Key Set of the instance

## getJWKS

Retrieve the JSON Web Key Set of the instance

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.GetJWKSResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            GetJWKSResponse res = sdk.jwks().getJWKS()
                .call();

            // handle response
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

**[GetJWKSResponse](../../models/operations/GetJWKSResponse.md)**

### Errors

| Error Object           | Status Code            | Content Type           |
| ---------------------- | ---------------------- | ---------------------- |
| models/errors/SDKError | 4xx-5xx                | \*\/*                  |
