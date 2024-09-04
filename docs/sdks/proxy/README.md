# Proxy
(*proxy()*)

## Overview

### Available Operations

* [verifyDomain](#verifydomain) - Verify the proxy configuration for your domain

## verifyDomain

This endpoint can be used to validate that a proxy-enabled domain is operational.
It tries to verify that the proxy URL provided in the parameters maps to a functional proxy that can reach the Clerk Frontend API.

You can use this endpoint before you set a proxy URL for a domain. This way you can ensure that switching to proxy-based
configuration will not lead to downtime for your instance.

The `proxy_url` parameter allows for testing proxy configurations for domains that don't have a proxy URL yet, or operate on
a different proxy URL than the one provided. It can also be used to re-validate a domain that is already configured to work with a proxy.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.VerifyDomainProxyRequestBody;
import com.clerk.backend_api.models.operations.VerifyDomainProxyResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            VerifyDomainProxyRequestBody req = VerifyDomainProxyRequestBody.builder()
                .build();

            VerifyDomainProxyResponse res = sdk.proxy().verifyDomain()
                .request(req)
                .call();

            if (res.proxyCheck().isPresent()) {
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
| `request`                                                                               | [VerifyDomainProxyRequestBody](../../models/operations/VerifyDomainProxyRequestBody.md) | :heavy_check_mark:                                                                      | The request object to use for the request.                                              |

### Response

**[VerifyDomainProxyResponse](../../models/operations/VerifyDomainProxyResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,422                   | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |
