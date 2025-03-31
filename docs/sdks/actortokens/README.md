# ActorTokens
(*actorTokens()*)

## Overview

### Available Operations

* [create](#create) - Create actor token
* [revoke](#revoke) - Revoke actor token

## create

Create an actor token that can be used to impersonate the given user.
The `actor` parameter needs to include at least a "sub" key whose value is the ID of the actor (impersonating) user.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        CreateActorTokenRequestBody req = CreateActorTokenRequestBody.builder()
                .userId("<id>")
                .actor(Actor.builder()
                    .sub("user_2OEpKhcCN1Lat9NQ0G6puh7q5Rb")
                    .build())
                .build();

        CreateActorTokenResponse res = sdk.actorTokens().create()
                .request(req)
                .call();

        if (res.actorToken().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                             | Type                                                                                  | Required                                                                              | Description                                                                           |
| ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- |
| `request`                                                                             | [CreateActorTokenRequestBody](../../models/operations/CreateActorTokenRequestBody.md) | :heavy_check_mark:                                                                    | The request object to use for the request.                                            |

### Response

**[CreateActorTokenResponse](../../models/operations/CreateActorTokenResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 402, 422             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## revoke

Revokes a pending actor token.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.RevokeActorTokenResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        RevokeActorTokenResponse res = sdk.actorTokens().revoke()
                .actorTokenId("<id>")
                .call();

        if (res.actorToken().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                | Type                                     | Required                                 | Description                              |
| ---------------------------------------- | ---------------------------------------- | ---------------------------------------- | ---------------------------------------- |
| `actorTokenId`                           | *String*                                 | :heavy_check_mark:                       | The ID of the actor token to be revoked. |

### Response

**[RevokeActorTokenResponse](../../models/operations/RevokeActorTokenResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 404                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |