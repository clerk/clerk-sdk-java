# OauthAccessTokens
(*oauthAccessTokens()*)

## Overview

### Available Operations

* [verify](#verify) - Verify an OAuth Access Token

## verify

Verify an OAuth Access Token

### Example Usage

<!-- UsageSnippet language="java" operationID="verifyOAuthAccessToken" method="post" path="/oauth_applications/access_tokens/verify" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.VerifyOAuthAccessTokenOauthAccessTokensResponseBody;
import com.clerk.backend_api.models.errors.VerifyOAuthAccessTokenResponseBody;
import com.clerk.backend_api.models.operations.VerifyOAuthAccessTokenRequestBody;
import com.clerk.backend_api.models.operations.VerifyOAuthAccessTokenResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws VerifyOAuthAccessTokenResponseBody, VerifyOAuthAccessTokenOauthAccessTokensResponseBody, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        VerifyOAuthAccessTokenRequestBody req = VerifyOAuthAccessTokenRequestBody.builder()
                .accessToken("XXXXXXXXXXXXXX")
                .build();

        VerifyOAuthAccessTokenResponse res = sdk.oauthAccessTokens().verify()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                         | Type                                                                                              | Required                                                                                          | Description                                                                                       |
| ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- |
| `request`                                                                                         | [VerifyOAuthAccessTokenRequestBody](../../models/operations/VerifyOAuthAccessTokenRequestBody.md) | :heavy_check_mark:                                                                                | The request object to use for the request.                                                        |

### Response

**[VerifyOAuthAccessTokenResponse](../../models/operations/VerifyOAuthAccessTokenResponse.md)**

### Errors

| Error Type                                                        | Status Code                                                       | Content Type                                                      |
| ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- |
| models/errors/VerifyOAuthAccessTokenResponseBody                  | 400                                                               | application/json                                                  |
| models/errors/VerifyOAuthAccessTokenOauthAccessTokensResponseBody | 404                                                               | application/json                                                  |
| models/errors/SDKError                                            | 4XX, 5XX                                                          | \*/\*                                                             |