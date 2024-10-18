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
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.UpsertTemplatePathParamTemplateType;
import com.clerk.backend_api.models.operations.UpsertTemplateRequestBody;
import com.clerk.backend_api.models.operations.UpsertTemplateResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
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

| Parameter                                                                                             | Type                                                                                                  | Required                                                                                              | Description                                                                                           |
| ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- |
| `templateType`                                                                                        | [UpsertTemplatePathParamTemplateType](../../models/operations/UpsertTemplatePathParamTemplateType.md) | :heavy_check_mark:                                                                                    | The type of template to update                                                                        |
| `slug`                                                                                                | *String*                                                                                              | :heavy_check_mark:                                                                                    | The slug of the template to update                                                                    |
| `requestBody`                                                                                         | [Optional<UpsertTemplateRequestBody>](../../models/operations/UpsertTemplateRequestBody.md)           | :heavy_minus_sign:                                                                                    | N/A                                                                                                   |

### Response

**[UpsertTemplateResponse](../../models/operations/UpsertTemplateResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,401,402,403,404,422   | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |
