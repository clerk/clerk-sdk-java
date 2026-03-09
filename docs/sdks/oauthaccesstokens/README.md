# OauthAccessTokens

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
import com.clerk.backend_api.models.operations.*;
import java.lang.Exception;
import java.lang.Object;

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

        if (res.oneOf().isPresent()) {
            com.clerk.backend_api.models.operations.VerifyOAuthAccessTokenResponseBody unionValue = res.oneOf().get();
            Object raw = unionValue.value();
            if (raw instanceof ResponseBody1) {
                ResponseBody1 responseBody1Value = (ResponseBody1) raw;
                // Handle responseBody1 variant
            } else if (raw instanceof ResponseBody2) {
                ResponseBody2 responseBody2Value = (ResponseBody2) raw;
                // Handle responseBody2 variant
            } else {
                // Unknown or unsupported variant
            }
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