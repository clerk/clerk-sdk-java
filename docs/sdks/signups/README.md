# SignUps
(*signUps()*)

## Overview

### Available Operations

* [update](#update) - Update a sign-up

## update

Update the sign-up with the given ID

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.UpdateSignUpRequestBody;
import com.clerk.backend_api.models.operations.UpdateSignUpResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            UpdateSignUpResponse res = sdk.signUps().update()
                .id("<id>")
                .requestBody(UpdateSignUpRequestBody.builder()
                    .build())
                .call();

            if (res.signUp().isPresent()) {
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

### Parameters

| Parameter                                                                               | Type                                                                                    | Required                                                                                | Description                                                                             |
| --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- |
| `id`                                                                                    | *String*                                                                                | :heavy_check_mark:                                                                      | The ID of the sign-up to update                                                         |
| `requestBody`                                                                           | [Optional<UpdateSignUpRequestBody>](../../models/operations/UpdateSignUpRequestBody.md) | :heavy_minus_sign:                                                                      | N/A                                                                                     |

### Response

**[UpdateSignUpResponse](../../models/operations/UpdateSignUpResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 403                       | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |
