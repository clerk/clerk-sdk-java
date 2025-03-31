# EmailSMSTemplates
(*emailSMSTemplates()*)

## Overview

### Available Operations

* [~~list~~](#list) - List all templates :warning: **Deprecated**
* [~~get~~](#get) - Retrieve a template :warning: **Deprecated**
* [~~revert~~](#revert) - Revert a template :warning: **Deprecated**
* [~~toggleTemplateDelivery~~](#toggletemplatedelivery) - Toggle the delivery by Clerk for a template of a given type and slug :warning: **Deprecated**

## ~~list~~

Returns a list of all templates.
The templates are returned sorted by position.

> :warning: **DEPRECATED**: This will be removed in a future release, please migrate away from it as soon as possible.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.GetTemplateListResponse;
import com.clerk.backend_api.models.operations.TemplateType;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        GetTemplateListResponse res = sdk.emailSMSTemplates().list()
                .templateType(TemplateType.SMS)
                .paginated(false)
                .limit(10L)
                .offset(0L)
                .call();

        if (res.templateList().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                 | Type                                                                                                                                      | Required                                                                                                                                  | Description                                                                                                                               |
| ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- |
| `templateType`                                                                                                                            | [TemplateType](../../models/operations/TemplateType.md)                                                                                   | :heavy_check_mark:                                                                                                                        | The type of templates to list (email or SMS)                                                                                              |
| `paginated`                                                                                                                               | *Optional\<Boolean>*                                                                                                                      | :heavy_minus_sign:                                                                                                                        | Whether to paginate the results.<br/>If true, the results will be paginated.<br/>If false, the results will not be paginated.             |
| `limit`                                                                                                                                   | *Optional\<Long>*                                                                                                                         | :heavy_minus_sign:                                                                                                                        | Applies a limit to the number of results returned.<br/>Can be used for paginating the results together with `offset`.                     |
| `offset`                                                                                                                                  | *Optional\<Long>*                                                                                                                         | :heavy_minus_sign:                                                                                                                        | Skip the first `offset` results when paginating.<br/>Needs to be an integer greater or equal to zero.<br/>To be used in conjunction with `limit`. |

### Response

**[GetTemplateListResponse](../../models/operations/GetTemplateListResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 422             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## ~~get~~

Returns the details of a template

> :warning: **DEPRECATED**: This will be removed in a future release, please migrate away from it as soon as possible.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.GetTemplateResponse;
import com.clerk.backend_api.models.operations.PathParamTemplateType;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

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

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 404             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## ~~revert~~

Reverts an updated template to its default state

> :warning: **DEPRECATED**: This will be removed in a future release, please migrate away from it as soon as possible.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.RevertTemplatePathParamTemplateType;
import com.clerk.backend_api.models.operations.RevertTemplateResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        RevertTemplateResponse res = sdk.emailSMSTemplates().revert()
                .templateType(RevertTemplatePathParamTemplateType.EMAIL)
                .slug("<value>")
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
| `templateType`                                                                                        | [RevertTemplatePathParamTemplateType](../../models/operations/RevertTemplatePathParamTemplateType.md) | :heavy_check_mark:                                                                                    | The type of template to revert                                                                        |
| `slug`                                                                                                | *String*                                                                                              | :heavy_check_mark:                                                                                    | The slug of the template to revert                                                                    |

### Response

**[RevertTemplateResponse](../../models/operations/RevertTemplateResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 402, 404        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## ~~toggleTemplateDelivery~~

Toggles the delivery by Clerk for a template of a given type and slug.
If disabled, Clerk will not deliver the resulting email or SMS.
The app developer will need to listen to the `email.created` or `sms.created` webhooks in order to handle delivery themselves.

> :warning: **DEPRECATED**: This will be removed in a future release, please migrate away from it as soon as possible.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

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
    }
}
```

### Parameters

| Parameter                                                                                                             | Type                                                                                                                  | Required                                                                                                              | Description                                                                                                           |
| --------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------- |
| `templateType`                                                                                                        | [ToggleTemplateDeliveryPathParamTemplateType](../../models/operations/ToggleTemplateDeliveryPathParamTemplateType.md) | :heavy_check_mark:                                                                                                    | The type of template to toggle delivery for                                                                           |
| `slug`                                                                                                                | *String*                                                                                                              | :heavy_check_mark:                                                                                                    | The slug of the template for which to toggle delivery                                                                 |
| `requestBody`                                                                                                         | [Optional\<ToggleTemplateDeliveryRequestBody>](../../models/operations/ToggleTemplateDeliveryRequestBody.md)          | :heavy_minus_sign:                                                                                                    | N/A                                                                                                                   |

### Response

**[ToggleTemplateDeliveryResponse](../../models/operations/ToggleTemplateDeliveryResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 404             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |