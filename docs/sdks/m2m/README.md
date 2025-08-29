# M2m
(*m2m()*)

## Overview

### Available Operations

* [createToken](#createtoken) - Create a M2M Token
* [listTokens](#listtokens) - Get M2M Tokens
* [revokeToken](#revoketoken) - Revoke a M2M Token
* [verifyToken](#verifytoken) - Verify a M2M Token

## createToken

Creates a new M2M Token. Must be authenticated via a Machine Secret Key.

### Example Usage

<!-- UsageSnippet language="java" operationID="createM2MToken" method="post" path="/m2m_tokens" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.CreateM2MTokenM2mResponseBody;
import com.clerk.backend_api.models.errors.CreateM2MTokenResponseBody;
import com.clerk.backend_api.models.operations.CreateM2MTokenRequestBody;
import com.clerk.backend_api.models.operations.CreateM2MTokenResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws CreateM2MTokenResponseBody, CreateM2MTokenM2mResponseBody, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        CreateM2MTokenRequestBody req = CreateM2MTokenRequestBody.builder()
                .build();

        CreateM2MTokenResponse res = sdk.m2m().createToken()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                         | Type                                                                              | Required                                                                          | Description                                                                       |
| --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| `request`                                                                         | [CreateM2MTokenRequestBody](../../models/operations/CreateM2MTokenRequestBody.md) | :heavy_check_mark:                                                                | The request object to use for the request.                                        |

### Response

**[CreateM2MTokenResponse](../../models/operations/CreateM2MTokenResponse.md)**

### Errors

| Error Type                                  | Status Code                                 | Content Type                                |
| ------------------------------------------- | ------------------------------------------- | ------------------------------------------- |
| models/errors/CreateM2MTokenResponseBody    | 400                                         | application/json                            |
| models/errors/CreateM2MTokenM2mResponseBody | 409                                         | application/json                            |
| models/errors/SDKError                      | 4XX, 5XX                                    | \*/\*                                       |

## listTokens

Fetches M2M tokens for a specific machine.

This endpoint can be authenticated by either a Machine Secret Key or by a Clerk Secret Key.

- When fetching M2M tokens with a Machine Secret Key, only tokens associated with the authenticated machine can be retrieved.
- When fetching M2M tokens with a Clerk Secret Key, tokens for any machine in the instance can be retrieved.

### Example Usage

<!-- UsageSnippet language="java" operationID="getM2MTokens" method="get" path="/m2m_tokens" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.*;
import com.clerk.backend_api.models.operations.GetM2MTokensRequest;
import com.clerk.backend_api.models.operations.GetM2MTokensResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetM2MTokensResponseBody, GetM2MTokensM2mResponseBody, GetM2MTokensM2mResponseResponseBody, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        GetM2MTokensRequest req = GetM2MTokensRequest.builder()
                .subject("<value>")
                .build();

        GetM2MTokensResponse res = sdk.m2m().listTokens()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                             | Type                                                                  | Required                                                              | Description                                                           |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| `request`                                                             | [GetM2MTokensRequest](../../models/operations/GetM2MTokensRequest.md) | :heavy_check_mark:                                                    | The request object to use for the request.                            |

### Response

**[GetM2MTokensResponse](../../models/operations/GetM2MTokensResponse.md)**

### Errors

| Error Type                                        | Status Code                                       | Content Type                                      |
| ------------------------------------------------- | ------------------------------------------------- | ------------------------------------------------- |
| models/errors/GetM2MTokensResponseBody            | 400                                               | application/json                                  |
| models/errors/GetM2MTokensM2mResponseBody         | 403                                               | application/json                                  |
| models/errors/GetM2MTokensM2mResponseResponseBody | 404                                               | application/json                                  |
| models/errors/SDKError                            | 4XX, 5XX                                          | \*/\*                                             |

## revokeToken

Revokes a M2M Token.

This endpoint can be authenticated by either a Machine Secret Key or by a Clerk Secret Key.

- When revoking a M2M Token with a Machine Secret Key, the token must managed by the Machine associated with the Machine Secret Key.
- When revoking a M2M Token with a Clerk Secret Key, any token on the Instance can be revoked.

### Example Usage

<!-- UsageSnippet language="java" operationID="revokeM2MToken" method="post" path="/m2m_tokens/{m2m_token_id}/revoke" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.RevokeM2MTokenM2mResponseBody;
import com.clerk.backend_api.models.errors.RevokeM2MTokenResponseBody;
import com.clerk.backend_api.models.operations.RevokeM2MTokenRequestBody;
import com.clerk.backend_api.models.operations.RevokeM2MTokenResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws RevokeM2MTokenResponseBody, RevokeM2MTokenM2mResponseBody, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        RevokeM2MTokenResponse res = sdk.m2m().revokeToken()
                .m2mTokenId("<id>")
                .requestBody(RevokeM2MTokenRequestBody.builder()
                    .build())
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                         | Type                                                                              | Required                                                                          | Description                                                                       |
| --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| `m2mTokenId`                                                                      | *String*                                                                          | :heavy_check_mark:                                                                | N/A                                                                               |
| `requestBody`                                                                     | [RevokeM2MTokenRequestBody](../../models/operations/RevokeM2MTokenRequestBody.md) | :heavy_check_mark:                                                                | N/A                                                                               |

### Response

**[RevokeM2MTokenResponse](../../models/operations/RevokeM2MTokenResponse.md)**

### Errors

| Error Type                                  | Status Code                                 | Content Type                                |
| ------------------------------------------- | ------------------------------------------- | ------------------------------------------- |
| models/errors/RevokeM2MTokenResponseBody    | 400                                         | application/json                            |
| models/errors/RevokeM2MTokenM2mResponseBody | 404                                         | application/json                            |
| models/errors/SDKError                      | 4XX, 5XX                                    | \*/\*                                       |

## verifyToken

Verifies a M2M Token.

This endpoint can be authenticated by either a Machine Secret Key or by a Clerk Secret Key.

- When verifying a M2M Token with a Machine Secret Key, the token must be granted access to the Machine associated with the Machine Secret Key.
- When verifying a M2M Token with a Clerk Secret Key, any token on the Instance can be verified.

### Example Usage

<!-- UsageSnippet language="java" operationID="verifyM2MToken" method="post" path="/m2m_tokens/verify" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.VerifyM2MTokenM2mResponseBody;
import com.clerk.backend_api.models.errors.VerifyM2MTokenResponseBody;
import com.clerk.backend_api.models.operations.VerifyM2MTokenRequestBody;
import com.clerk.backend_api.models.operations.VerifyM2MTokenResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws VerifyM2MTokenResponseBody, VerifyM2MTokenM2mResponseBody, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        VerifyM2MTokenRequestBody req = VerifyM2MTokenRequestBody.builder()
                .token("<value>")
                .build();

        VerifyM2MTokenResponse res = sdk.m2m().verifyToken()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                         | Type                                                                              | Required                                                                          | Description                                                                       |
| --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| `request`                                                                         | [VerifyM2MTokenRequestBody](../../models/operations/VerifyM2MTokenRequestBody.md) | :heavy_check_mark:                                                                | The request object to use for the request.                                        |

### Response

**[VerifyM2MTokenResponse](../../models/operations/VerifyM2MTokenResponse.md)**

### Errors

| Error Type                                  | Status Code                                 | Content Type                                |
| ------------------------------------------- | ------------------------------------------- | ------------------------------------------- |
| models/errors/VerifyM2MTokenResponseBody    | 400                                         | application/json                            |
| models/errors/VerifyM2MTokenM2mResponseBody | 404                                         | application/json                            |
| models/errors/SDKError                      | 4XX, 5XX                                    | \*/\*                                       |