# EmailSMSTemplates
(*emailSMSTemplates()*)

## Overview

### Available Operations

* [~~get~~](#get) - Retrieve a template :warning: **Deprecated**
* [~~toggleTemplateDelivery~~](#toggletemplatedelivery) - Toggle the delivery by Clerk for a template of a given type and slug :warning: **Deprecated**

## ~~get~~

Returns the details of a template

> :warning: **DEPRECATED**: This will be removed in a future release, please migrate away from it as soon as possible.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.GetTemplateResponse;
import com.clerk.backend_api.models.operations.PathParamTemplateType;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            GetTemplateResponse res = sdk.emailSMSTemplates().get()
                .templateType(PathParamTemplateType.SMS)
                .slug("<value>")
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

| Parameter                                                                 | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `templateType`                                                            | [PathParamTemplateType](../../models/operations/PathParamTemplateType.md) | :heavy_check_mark:                                                        | The type of templates to retrieve (email or SMS)                          |
| `slug`                                                                    | *String*                                                                  | :heavy_check_mark:                                                        | The slug (i.e. machine-friendly name) of the template to retrieve         |

### Response

**[GetTemplateResponse](../../models/operations/GetTemplateResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,401,404               | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## ~~toggleTemplateDelivery~~

Toggles the delivery by Clerk for a template of a given type and slug.
If disabled, Clerk will not deliver the resulting email or SMS.
The app developer will need to listen to the `email.created` or `sms.created` webhooks in order to handle delivery themselves.

> :warning: **DEPRECATED**: This will be removed in a future release, please migrate away from it as soon as possible.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.ToggleTemplateDeliveryPathParamTemplateType;
import com.clerk.backend_api.models.operations.ToggleTemplateDeliveryRequestBody;
import com.clerk.backend_api.models.operations.ToggleTemplateDeliveryResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            ToggleTemplateDeliveryResponse res = sdk.emailSMSTemplates().toggleTemplateDelivery()
                .templateType(ToggleTemplateDeliveryPathParamTemplateType.SMS)
                .slug("<value>")
                .requestBody(ToggleTemplateDeliveryRequestBody.builder()
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

| Parameter                                                                                                             | Type                                                                                                                  | Required                                                                                                              | Description                                                                                                           |
| --------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------- |
| `templateType`                                                                                                        | [ToggleTemplateDeliveryPathParamTemplateType](../../models/operations/ToggleTemplateDeliveryPathParamTemplateType.md) | :heavy_check_mark:                                                                                                    | The type of template to toggle delivery for                                                                           |
| `slug`                                                                                                                | *String*                                                                                                              | :heavy_check_mark:                                                                                                    | The slug of the template for which to toggle delivery                                                                 |
| `requestBody`                                                                                                         | [Optional<ToggleTemplateDeliveryRequestBody>](../../models/operations/ToggleTemplateDeliveryRequestBody.md)           | :heavy_minus_sign:                                                                                                    | N/A                                                                                                                   |

### Response

**[ToggleTemplateDeliveryResponse](../../models/operations/ToggleTemplateDeliveryResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,401,404               | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |
