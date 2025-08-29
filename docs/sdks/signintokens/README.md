# SignInTokens
(*signInTokens()*)

## Overview

### Available Operations

* [create](#create) - Create sign-in token
* [revoke](#revoke) - Revoke the given sign-in token

## create

Creates a new sign-in token and associates it with the given user.
By default, sign-in tokens expire in 30 days.
You can optionally supply a different duration in seconds using the `expires_in_seconds` property.

### Example Usage

<!-- UsageSnippet language="java" operationID="CreateSignInToken" method="post" path="/sign_in_tokens" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CreateSignInTokenResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        CreateSignInTokenResponse res = sdk.signInTokens().create()
                .call();

        if (res.signInToken().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                               | Type                                                                                    | Required                                                                                | Description                                                                             |
| --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- |
| `request`                                                                               | [CreateSignInTokenRequestBody](../../models/operations/CreateSignInTokenRequestBody.md) | :heavy_check_mark:                                                                      | The request object to use for the request.                                              |

### Response

**[CreateSignInTokenResponse](../../models/operations/CreateSignInTokenResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 404, 422                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## revoke

Revokes a pending sign-in token

### Example Usage

<!-- UsageSnippet language="java" operationID="RevokeSignInToken" method="post" path="/sign_in_tokens/{sign_in_token_id}/revoke" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.RevokeSignInTokenResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        RevokeSignInTokenResponse res = sdk.signInTokens().revoke()
                .signInTokenId("<id>")
                .call();

        if (res.signInToken().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                 | Type                                      | Required                                  | Description                               |
| ----------------------------------------- | ----------------------------------------- | ----------------------------------------- | ----------------------------------------- |
| `signInTokenId`                           | *String*                                  | :heavy_check_mark:                        | The ID of the sign-in token to be revoked |

### Response

**[RevokeSignInTokenResponse](../../models/operations/RevokeSignInTokenResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 404                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |