# AllowlistIdentifiers
(*allowlistIdentifiers()*)

## Overview

### Available Operations

* [delete](#delete) - Delete identifier from allow-list

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