# Sessions
(*sessions()*)

## Overview

### Available Operations

* [list](#list) - List all sessions
* [create](#create) - Create a new active session
* [get](#get) - Retrieve a session
* [refresh](#refresh) - Refresh a session
* [revoke](#revoke) - Revoke a session
* [~~verify~~](#verify) - Verify a session :warning: **Deprecated**
* [createToken](#createtoken) - Create a session token
* [createTokenFromTemplate](#createtokenfromtemplate) - Create a session token from a jwt template

## list

Returns a list of all sessions.
The sessions are returned sorted by creation date, with the newest sessions appearing first.
**Deprecation Notice (2024-01-01):** All parameters were initially considered optional, however
moving forward at least one of `client_id` or `user_id` parameters should be provided.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.GetSessionListRequest;
import com.clerk.backend_api.models.operations.GetSessionListResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        GetSessionListRequest req = GetSessionListRequest.builder()
                .build();

        GetSessionListResponse res = sdk.sessions().list()
                .request(req)
                .call();

        if (res.sessionList().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                 | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `request`                                                                 | [GetSessionListRequest](../../models/operations/GetSessionListRequest.md) | :heavy_check_mark:                                                        | The request object to use for the request.                                |

### Response

**[GetSessionListResponse](../../models/operations/GetSessionListResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 422             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## create

Create a new active session for the provided user ID.

**This operation is intended only for use in testing, and is not available for production instances.** If you are looking to generate a user session from the backend,
we recommend using the [Sign-in Tokens](https://clerk.com/docs/reference/backend-api/tag/Sign-in-Tokens#operation/CreateSignInToken) resource instead.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CreateSessionResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        CreateSessionResponse res = sdk.sessions().create()
                .call();

        if (res.session().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                       | Type                                                                            | Required                                                                        | Description                                                                     |
| ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| `request`                                                                       | [CreateSessionRequestBody](../../models/operations/CreateSessionRequestBody.md) | :heavy_check_mark:                                                              | The request object to use for the request.                                      |

### Response

**[CreateSessionResponse](../../models/operations/CreateSessionResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 404, 422        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## get

Retrieve the details of a session

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.GetSessionResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        GetSessionResponse res = sdk.sessions().get()
                .sessionId("<id>")
                .call();

        if (res.session().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter             | Type                  | Required              | Description           |
| --------------------- | --------------------- | --------------------- | --------------------- |
| `sessionId`           | *String*              | :heavy_check_mark:    | The ID of the session |

### Response

**[GetSessionResponse](../../models/operations/GetSessionResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 404             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## refresh

Refreshes a session by creating a new session token. A 401 is returned when there
are validation errors, which signals the SDKs to fallback to the handshake flow.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.RefreshSessionResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        RefreshSessionResponse res = sdk.sessions().refresh()
                .sessionId("<id>")
                .call();

        if (res.sessionRefresh().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                    | Type                                                                                         | Required                                                                                     | Description                                                                                  |
| -------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------- |
| `sessionId`                                                                                  | *String*                                                                                     | :heavy_check_mark:                                                                           | The ID of the session                                                                        |
| `requestBody`                                                                                | [Optional\<RefreshSessionRequestBody>](../../models/operations/RefreshSessionRequestBody.md) | :heavy_minus_sign:                                                                           | Refresh session parameters                                                                   |

### Response

**[RefreshSessionResponse](../../models/operations/RefreshSessionResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## revoke

Sets the status of a session as "revoked", which is an unauthenticated state.
In multi-session mode, a revoked session will still be returned along with its client object, however the user will need to sign in again.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.RevokeSessionResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        RevokeSessionResponse res = sdk.sessions().revoke()
                .sessionId("<id>")
                .call();

        if (res.session().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter             | Type                  | Required              | Description           |
| --------------------- | --------------------- | --------------------- | --------------------- |
| `sessionId`           | *String*              | :heavy_check_mark:    | The ID of the session |

### Response

**[RevokeSessionResponse](../../models/operations/RevokeSessionResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 404             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## ~~verify~~

Returns the session if it is authenticated, otherwise returns an error.
WARNING: This endpoint is deprecated and will be removed in future versions. We strongly recommend switching to networkless verification using short-lived session tokens,
         which is implemented transparently in all recent SDK versions (e.g. [NodeJS SDK](https://clerk.com/docs/backend-requests/handling/nodejs#clerk-express-require-auth)).
         For more details on how networkless verification works, refer to our [Session Tokens documentation](https://clerk.com/docs/backend-requests/resources/session-tokens).

> :warning: **DEPRECATED**: This will be removed in a future release, please migrate away from it as soon as possible.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.VerifySessionResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        VerifySessionResponse res = sdk.sessions().verify()
                .sessionId("<id>")
                .call();

        if (res.session().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                  | Type                                                                                       | Required                                                                                   | Description                                                                                |
| ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ |
| `sessionId`                                                                                | *String*                                                                                   | :heavy_check_mark:                                                                         | The ID of the session                                                                      |
| `requestBody`                                                                              | [Optional\<VerifySessionRequestBody>](../../models/operations/VerifySessionRequestBody.md) | :heavy_minus_sign:                                                                         | Parameters.                                                                                |

### Response

**[VerifySessionResponse](../../models/operations/VerifySessionResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 404, 410        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## createToken

Creates a session JSON Web Token (JWT) based on a session.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CreateSessionTokenResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        CreateSessionTokenResponse res = sdk.sessions().createToken()
                .sessionId("<id>")
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                            | Type                                                                                                 | Required                                                                                             | Description                                                                                          |
| ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- |
| `sessionId`                                                                                          | *String*                                                                                             | :heavy_check_mark:                                                                                   | The ID of the session                                                                                |
| `requestBody`                                                                                        | [Optional\<CreateSessionTokenRequestBody>](../../models/operations/CreateSessionTokenRequestBody.md) | :heavy_minus_sign:                                                                                   | N/A                                                                                                  |

### Response

**[CreateSessionTokenResponse](../../models/operations/CreateSessionTokenResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 401, 404                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## createTokenFromTemplate

Creates a JSON Web Token(JWT) based on a session and a JWT Template name defined for your instance

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CreateSessionTokenFromTemplateResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        CreateSessionTokenFromTemplateResponse res = sdk.sessions().createTokenFromTemplate()
                .sessionId("<id>")
                .templateName("<value>")
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                    | Type                                                                                                                         | Required                                                                                                                     | Description                                                                                                                  |
| ---------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------- |
| `sessionId`                                                                                                                  | *String*                                                                                                                     | :heavy_check_mark:                                                                                                           | The ID of the session                                                                                                        |
| `templateName`                                                                                                               | *String*                                                                                                                     | :heavy_check_mark:                                                                                                           | The name of the JWT Template defined in your instance (e.g. `custom_hasura`).                                                |
| `requestBody`                                                                                                                | [Optional\<CreateSessionTokenFromTemplateRequestBody>](../../models/operations/CreateSessionTokenFromTemplateRequestBody.md) | :heavy_minus_sign:                                                                                                           | N/A                                                                                                                          |

### Response

**[CreateSessionTokenFromTemplateResponse](../../models/operations/CreateSessionTokenFromTemplateResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 401, 404                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |