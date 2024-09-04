# Actors
(*actors()*)

## Overview

### Available Operations

* [createToken](#createtoken) - Create actor token
* [revokeToken](#revoketoken) - Revoke actor token

## createToken

Create an actor token that can be used to impersonate the given user.
The `actor` parameter needs to include at least a "sub" key whose value is the ID of the actor (impersonating) user.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.CreateActorTokenRequestBody;
import com.clerk.backend_api.models.operations.CreateActorTokenResponse;
import java.lang.Exception;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            CreateActorTokenRequestBody req = CreateActorTokenRequestBody.builder()
                .userId("<value>")
                .actor(Map.ofEntries(
                        Map.entry("sub", "user_2OEpKhcCN1Lat9NQ0G6puh7q5Rb")))
                .build();

            CreateActorTokenResponse res = sdk.actors().createToken()
                .request(req)
                .call();

            if (res.actorToken().isPresent()) {
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

| Parameter                                                                             | Type                                                                                  | Required                                                                              | Description                                                                           |
| ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- |
| `request`                                                                             | [CreateActorTokenRequestBody](../../models/operations/CreateActorTokenRequestBody.md) | :heavy_check_mark:                                                                    | The request object to use for the request.                                            |

### Response

**[CreateActorTokenResponse](../../models/operations/CreateActorTokenResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,402,422               | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## revokeToken

Revokes a pending actor token.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.RevokeActorTokenResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            RevokeActorTokenResponse res = sdk.actors().revokeToken()
                .actorTokenId("<value>")
                .call();

            if (res.actorToken().isPresent()) {
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

| Parameter                                | Type                                     | Required                                 | Description                              |
| ---------------------------------------- | ---------------------------------------- | ---------------------------------------- | ---------------------------------------- |
| `actorTokenId`                           | *String*                                 | :heavy_check_mark:                       | The ID of the actor token to be revoked. |

### Response

**[RevokeActorTokenResponse](../../models/operations/RevokeActorTokenResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,404                   | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |
