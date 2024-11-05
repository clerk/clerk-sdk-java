# RedirectURLs
(*redirectURLs()*)

## Overview

### Available Operations

* [list](#list) - List all redirect URLs

## list

Lists all whitelisted redirect_urls for the instance

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.operations.ListRedirectURLsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        ListRedirectURLsResponse res = sdk.redirectURLs().list()
                .call();

        if (res.redirectURLList().isPresent()) {
            // handle response
        }
    }
}
```

### Response

**[ListRedirectURLsResponse](../../models/operations/ListRedirectURLsResponse.md)**

### Errors

| Error Type             | Status Code            | Content Type           |
| ---------------------- | ---------------------- | ---------------------- |
| models/errors/SDKError | 4XX, 5XX               | \*/\*                  |