# AdminPortalLinkTokens

## Overview

### Available Operations

* [createAdminPortalLinkToken](#createadminportallinktoken) - Create an Admin Portal Link Token
* [revokeAdminPortalLinkToken](#revokeadminportallinktoken) - Revoke an Admin Portal Link Token

## createAdminPortalLinkToken

Create an Admin Portal Link Token

### Example Usage

<!-- UsageSnippet language="java" operationID="createAdminPortalLinkToken" method="post" path="/admin_portal_link_tokens" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.*;
import com.clerk.backend_api.models.operations.CreateAdminPortalLinkTokenRequestBody;
import com.clerk.backend_api.models.operations.CreateAdminPortalLinkTokenResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws CreateAdminPortalLinkTokenResponseBody, CreateAdminPortalLinkTokenAdminPortalLinkTokensResponseBody, CreateAdminPortalLinkTokenAdminPortalLinkTokensResponseResponseBody, CreateAdminPortalLinkTokenAdminPortalLinkTokensResponse409ResponseBody, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        CreateAdminPortalLinkTokenRequestBody req = CreateAdminPortalLinkTokenRequestBody.builder()
                .build();

        CreateAdminPortalLinkTokenResponse res = sdk.adminPortalLinkTokens().createAdminPortalLinkToken()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                 | Type                                                                                                      | Required                                                                                                  | Description                                                                                               |
| --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                 | [CreateAdminPortalLinkTokenRequestBody](../../models/operations/CreateAdminPortalLinkTokenRequestBody.md) | :heavy_check_mark:                                                                                        | The request object to use for the request.                                                                |

### Response

**[CreateAdminPortalLinkTokenResponse](../../models/operations/CreateAdminPortalLinkTokenResponse.md)**

### Errors

| Error Type                                                                           | Status Code                                                                          | Content Type                                                                         |
| ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ |
| models/errors/CreateAdminPortalLinkTokenResponseBody                                 | 400                                                                                  | application/json                                                                     |
| models/errors/CreateAdminPortalLinkTokenAdminPortalLinkTokensResponseBody            | 401                                                                                  | application/json                                                                     |
| models/errors/CreateAdminPortalLinkTokenAdminPortalLinkTokensResponseResponseBody    | 403                                                                                  | application/json                                                                     |
| models/errors/CreateAdminPortalLinkTokenAdminPortalLinkTokensResponse409ResponseBody | 409                                                                                  | application/json                                                                     |
| models/errors/SDKError                                                               | 4XX, 5XX                                                                             | \*/\*                                                                                |

## revokeAdminPortalLinkToken

Revoke an Admin Portal Link Token

### Example Usage

<!-- UsageSnippet language="java" operationID="revokeAdminPortalLinkToken" method="post" path="/admin_portal_link_tokens/{adminPortalLinkTokenID}/revoke" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.*;
import com.clerk.backend_api.models.operations.RevokeAdminPortalLinkTokenRequestBody;
import com.clerk.backend_api.models.operations.RevokeAdminPortalLinkTokenResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws RevokeAdminPortalLinkTokenResponseBody, RevokeAdminPortalLinkTokenAdminPortalLinkTokensResponseBody, RevokeAdminPortalLinkTokenAdminPortalLinkTokensResponseResponseBody, RevokeAdminPortalLinkTokenAdminPortalLinkTokensResponse404ResponseBody, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        RevokeAdminPortalLinkTokenResponse res = sdk.adminPortalLinkTokens().revokeAdminPortalLinkToken()
                .adminPortalLinkTokenID("<id>")
                .requestBody(RevokeAdminPortalLinkTokenRequestBody.builder()
                    .build())
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                 | Type                                                                                                      | Required                                                                                                  | Description                                                                                               |
| --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- |
| `adminPortalLinkTokenID`                                                                                  | *String*                                                                                                  | :heavy_check_mark:                                                                                        | N/A                                                                                                       |
| `requestBody`                                                                                             | [RevokeAdminPortalLinkTokenRequestBody](../../models/operations/RevokeAdminPortalLinkTokenRequestBody.md) | :heavy_check_mark:                                                                                        | N/A                                                                                                       |

### Response

**[RevokeAdminPortalLinkTokenResponse](../../models/operations/RevokeAdminPortalLinkTokenResponse.md)**

### Errors

| Error Type                                                                           | Status Code                                                                          | Content Type                                                                         |
| ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ |
| models/errors/RevokeAdminPortalLinkTokenResponseBody                                 | 400                                                                                  | application/json                                                                     |
| models/errors/RevokeAdminPortalLinkTokenAdminPortalLinkTokensResponseBody            | 401                                                                                  | application/json                                                                     |
| models/errors/RevokeAdminPortalLinkTokenAdminPortalLinkTokensResponseResponseBody    | 403                                                                                  | application/json                                                                     |
| models/errors/RevokeAdminPortalLinkTokenAdminPortalLinkTokensResponse404ResponseBody | 404                                                                                  | application/json                                                                     |
| models/errors/SDKError                                                               | 4XX, 5XX                                                                             | \*/\*                                                                                |