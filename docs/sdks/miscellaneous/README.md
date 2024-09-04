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
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.GetPublicInterstitialResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .build();

            GetPublicInterstitialResponse res = sdk.miscellaneous().getPublicInterstitial()
                .frontendApi("<value>")
                .publishableKey("<value>")
                .call();

            // handle response
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

| Parameter                             | Type                                  | Required                              | Description                           |
| ------------------------------------- | ------------------------------------- | ------------------------------------- | ------------------------------------- |
| `frontendApi`                         | *Optional<String>*                    | :heavy_minus_sign:                    | The Frontend API key of your instance |
| `publishableKey`                      | *Optional<String>*                    | :heavy_minus_sign:                    | The publishable key of your instance  |

### Response

**[GetPublicInterstitialResponse](../../models/operations/GetPublicInterstitialResponse.md)**

### Errors

| Error Object           | Status Code            | Content Type           |
| ---------------------- | ---------------------- | ---------------------- |
| models/errors/SDKError | 4xx-5xx                | \*\/*                  |
