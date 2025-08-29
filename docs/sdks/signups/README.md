# SignUps
(*signUps()*)

## Overview

### Available Operations

* [get](#get) - Retrieve a sign-up by ID
* [update](#update) - Update a sign-up

## get

Retrieve the details of the sign-up with the given ID

### Example Usage

<!-- UsageSnippet language="java" operationID="GetSignUp" method="get" path="/sign_ups/{id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.GetSignUpResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        GetSignUpResponse res = sdk.signUps().get()
                .id("<id>")
                .call();

        if (res.signUp().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `id`                              | *String*                          | :heavy_check_mark:                | The ID of the sign-up to retrieve |

### Response

**[GetSignUpResponse](../../models/operations/GetSignUpResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 403                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## update

Update the sign-up with the given ID

### Example Usage

<!-- UsageSnippet language="java" operationID="UpdateSignUp" method="patch" path="/sign_ups/{id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UpdateSignUpResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        UpdateSignUpResponse res = sdk.signUps().update()
                .id("<id>")
                .call();

        if (res.signUp().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                | Type                                                                                     | Required                                                                                 | Description                                                                              |
| ---------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------- |
| `id`                                                                                     | *String*                                                                                 | :heavy_check_mark:                                                                       | The ID of the sign-up to update                                                          |
| `requestBody`                                                                            | [Optional\<UpdateSignUpRequestBody>](../../models/operations/UpdateSignUpRequestBody.md) | :heavy_minus_sign:                                                                       | N/A                                                                                      |

### Response

**[UpdateSignUpResponse](../../models/operations/UpdateSignUpResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 403                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |