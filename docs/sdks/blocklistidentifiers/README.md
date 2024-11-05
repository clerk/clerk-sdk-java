# BlocklistIdentifiers
(*blocklistIdentifiers()*)

## Overview

### Available Operations

* [list](#list) - List all identifiers on the block-list

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
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
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