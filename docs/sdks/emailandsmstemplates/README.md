# EmailAndSmsTemplates
(*emailAndSmsTemplates()*)

## Overview

### Available Operations

* [~~upsert~~](#upsert) - Update a template for a given type and slug :warning: **Deprecated**

## ~~upsert~~

Updates the existing template of the given type and slug

> :warning: **DEPRECATED**: This will be removed in a future release, please migrate away from it as soon as possible.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UpsertTemplatePathParamTemplateType;
import com.clerk.backend_api.models.operations.UpsertTemplateRequestBody;
import com.clerk.backend_api.models.operations.UpsertTemplateResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        UpsertTemplateResponse res = sdk.emailAndSmsTemplates().upsert()
                .templateType(UpsertTemplatePathParamTemplateType.SMS)
                .slug("<value>")
                .requestBody(UpsertTemplateRequestBody.builder()
                    .build())
                .call();

        if (res.template().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                             | Type                                                                                                  | Required                                                                                              | Description                                                                                           |
| ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- |
| `templateType`                                                                                        | [UpsertTemplatePathParamTemplateType](../../models/operations/UpsertTemplatePathParamTemplateType.md) | :heavy_check_mark:                                                                                    | The type of template to update                                                                        |
| `slug`                                                                                                | *String*                                                                                              | :heavy_check_mark:                                                                                    | The slug of the template to update                                                                    |
| `requestBody`                                                                                         | [Optional\<UpsertTemplateRequestBody>](../../models/operations/UpsertTemplateRequestBody.md)          | :heavy_minus_sign:                                                                                    | N/A                                                                                                   |

### Response

**[UpsertTemplateResponse](../../models/operations/UpsertTemplateResponse.md)**

### Errors

| Error Type                   | Status Code                  | Content Type                 |
| ---------------------------- | ---------------------------- | ---------------------------- |
| models/errors/ClerkErrors    | 400, 401, 402, 403, 404, 422 | application/json             |
| models/errors/SDKError       | 4XX, 5XX                     | \*/\*                        |