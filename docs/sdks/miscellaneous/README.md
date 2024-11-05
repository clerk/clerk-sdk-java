# Miscellaneous
(*miscellaneous()*)

## Overview

Various endpoints that do not belong in any particular category.

### Available Operations

* [getInterstitial](#getinterstitial) - Returns the markup for the interstitial page

## getInterstitial

The Clerk interstitial endpoint serves an html page that loads clerk.js in order to check the user's authentication state.
It is used by Clerk SDKs when the user's authentication state cannot be immediately determined.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.operations.GetPublicInterstitialResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Clerk sdk = Clerk.builder()
            .build();

        GetPublicInterstitialResponse res = sdk.miscellaneous().getInterstitial()
                .frontendApi("<value>")
                .publishableKey("<value>")
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                             | Type                                  | Required                              | Description                           |
| ------------------------------------- | ------------------------------------- | ------------------------------------- | ------------------------------------- |
| `frontendApi`                         | *Optional\<String>*                   | :heavy_minus_sign:                    | The Frontend API key of your instance |
| `publishableKey`                      | *Optional\<String>*                   | :heavy_minus_sign:                    | The publishable key of your instance  |

### Response

**[GetPublicInterstitialResponse](../../models/operations/GetPublicInterstitialResponse.md)**

### Errors

| Error Type             | Status Code            | Content Type           |
| ---------------------- | ---------------------- | ---------------------- |
| models/errors/SDKError | 4XX, 5XX               | \*/\*                  |