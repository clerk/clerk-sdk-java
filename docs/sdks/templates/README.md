# Templates
(*templates()*)

## Overview

### Available Operations

* [~~preview~~](#preview) - Preview changes to a template :warning: **Deprecated**

## ~~preview~~

Returns a preview of a template for a given template_type, slug and body

> :warning: **DEPRECATED**: This will be removed in a future release, please migrate away from it as soon as possible.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.PreviewTemplateResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        PreviewTemplateResponse res = sdk.templates().preview()
                .templateType("<value>")
                .slug("<value>")
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                      | Type                                                                                           | Required                                                                                       | Description                                                                                    |
| ---------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- |
| `templateType`                                                                                 | *String*                                                                                       | :heavy_check_mark:                                                                             | The type of template to preview                                                                |
| `slug`                                                                                         | *String*                                                                                       | :heavy_check_mark:                                                                             | The slug of the template to preview                                                            |
| `requestBody`                                                                                  | [Optional\<PreviewTemplateRequestBody>](../../models/operations/PreviewTemplateRequestBody.md) | :heavy_minus_sign:                                                                             | Required parameters                                                                            |

### Response

**[PreviewTemplateResponse](../../models/operations/PreviewTemplateResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 404, 422        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |