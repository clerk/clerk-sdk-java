# Miscellaneous
(*miscellaneous()*)

## Overview

### Available Operations

* [getPublicInterstitial](#getpublicinterstitial) - Returns the markup for the interstitial page

## getPublicInterstitial

The Clerk interstitial endpoint serves an html page that loads clerk.js in order to check the user's authentication state.
It is used by Clerk SDKs when the user's authentication state cannot be immediately determined.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.operations.GetPublicInterstitialRequest;
import com.clerk.backend_api.models.operations.GetPublicInterstitialResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Clerk sdk = Clerk.builder()
            .build();

        GetPublicInterstitialRequest req = GetPublicInterstitialRequest.builder()
                .build();

        GetPublicInterstitialResponse res = sdk.miscellaneous().getPublicInterstitial()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                               | Type                                                                                    | Required                                                                                | Description                                                                             |
| --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- |
| `request`                                                                               | [GetPublicInterstitialRequest](../../models/operations/GetPublicInterstitialRequest.md) | :heavy_check_mark:                                                                      | The request object to use for the request.                                              |

### Response

**[GetPublicInterstitialResponse](../../models/operations/GetPublicInterstitialResponse.md)**

### Errors

| Error Type             | Status Code            | Content Type           |
| ---------------------- | ---------------------- | ---------------------- |
| models/errors/SDKError | 4XX, 5XX               | \*/\*                  |