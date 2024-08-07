# Templates
(*templates()*)

### Available Operations

* [list](#list) - List all templates
* [get](#get) - Retrieve a template
* [upsert](#upsert) - Update a template for a given type and slug
* [revert](#revert) - Revert a template
* [preview](#preview) - Preview changes to a template
* [toggleDelivery](#toggledelivery) - Toggle the delivery by Clerk for a template of a given type and slug

## list

Returns a list of all templates.
The templates are returned sorted by position.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.components.*;
import com.clerk.backend_api.models.operations.*;
import com.clerk.backend_api.utils.EventStream;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;
import static java.util.Map.entry;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            GetTemplateListResponse res = sdk.templates().list()
                .templateType(TemplateType.SMS)
                .call();

            if (res.templateList().isPresent()) {
                // handle response
            }
        } catch (com.clerk.backend_api.models.errors.ClerkErrors e) {
            // handle exception
            throw e;
        } catch (com.clerk.backend_api.models.errors.SDKError e) {
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

| Parameter                                                                                       | Type                                                                                            | Required                                                                                        | Description                                                                                     |
| ----------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- |
| `templateType`                                                                                  | [com.clerk.backend_api.models.operations.TemplateType](../../models/operations/TemplateType.md) | :heavy_check_mark:                                                                              | The type of templates to list (email or SMS)                                                    |


### Response

**[com.clerk.backend_api.models.operations.GetTemplateListResponse](../../models/operations/GetTemplateListResponse.md)**
### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,401,422               | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |

## get

Returns the details of a template

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.components.*;
import com.clerk.backend_api.models.operations.*;
import com.clerk.backend_api.utils.EventStream;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;
import static java.util.Map.entry;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            GetTemplateResponse res = sdk.templates().get()
                .templateType(PathParamTemplateType.SMS)
                .slug("<value>")
                .call();

            if (res.template().isPresent()) {
                // handle response
            }
        } catch (com.clerk.backend_api.models.errors.ClerkErrors e) {
            // handle exception
            throw e;
        } catch (com.clerk.backend_api.models.errors.SDKError e) {
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

| Parameter                                                                                                         | Type                                                                                                              | Required                                                                                                          | Description                                                                                                       |
| ----------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- |
| `templateType`                                                                                                    | [com.clerk.backend_api.models.operations.PathParamTemplateType](../../models/operations/PathParamTemplateType.md) | :heavy_check_mark:                                                                                                | The type of templates to retrieve (email or SMS)                                                                  |
| `slug`                                                                                                            | *String*                                                                                                          | :heavy_check_mark:                                                                                                | The slug (i.e. machine-friendly name) of the template to retrieve                                                 |


### Response

**[com.clerk.backend_api.models.operations.GetTemplateResponse](../../models/operations/GetTemplateResponse.md)**
### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,401,404               | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |

## upsert

Updates the existing template of the given type and slug

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.components.*;
import com.clerk.backend_api.models.operations.*;
import com.clerk.backend_api.utils.EventStream;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;
import static java.util.Map.entry;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            UpsertTemplateResponse res = sdk.templates().upsert()
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
        } catch (com.clerk.backend_api.models.errors.SDKError e) {
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

| Parameter                                                                                                                                     | Type                                                                                                                                          | Required                                                                                                                                      | Description                                                                                                                                   |
| --------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------- |
| `templateType`                                                                                                                                | [com.clerk.backend_api.models.operations.UpsertTemplatePathParamTemplateType](../../models/operations/UpsertTemplatePathParamTemplateType.md) | :heavy_check_mark:                                                                                                                            | The type of template to update                                                                                                                |
| `slug`                                                                                                                                        | *String*                                                                                                                                      | :heavy_check_mark:                                                                                                                            | The slug of the template to update                                                                                                            |
| `requestBody`                                                                                                                                 | [Optional<? extends com.clerk.backend_api.models.operations.UpsertTemplateRequestBody>](../../models/operations/UpsertTemplateRequestBody.md) | :heavy_minus_sign:                                                                                                                            | N/A                                                                                                                                           |


### Response

**[com.clerk.backend_api.models.operations.UpsertTemplateResponse](../../models/operations/UpsertTemplateResponse.md)**
### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,401,402,403,404,422   | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |

## revert

Reverts an updated template to its default state

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.components.*;
import com.clerk.backend_api.models.operations.*;
import com.clerk.backend_api.utils.EventStream;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;
import static java.util.Map.entry;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            RevertTemplateResponse res = sdk.templates().revert()
                .templateType(RevertTemplatePathParamTemplateType.EMAIL)
                .slug("<value>")
                .call();

            if (res.template().isPresent()) {
                // handle response
            }
        } catch (com.clerk.backend_api.models.errors.ClerkErrors e) {
            // handle exception
            throw e;
        } catch (com.clerk.backend_api.models.errors.SDKError e) {
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

| Parameter                                                                                                                                     | Type                                                                                                                                          | Required                                                                                                                                      | Description                                                                                                                                   |
| --------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------- |
| `templateType`                                                                                                                                | [com.clerk.backend_api.models.operations.RevertTemplatePathParamTemplateType](../../models/operations/RevertTemplatePathParamTemplateType.md) | :heavy_check_mark:                                                                                                                            | The type of template to revert                                                                                                                |
| `slug`                                                                                                                                        | *String*                                                                                                                                      | :heavy_check_mark:                                                                                                                            | The slug of the template to revert                                                                                                            |


### Response

**[com.clerk.backend_api.models.operations.RevertTemplateResponse](../../models/operations/RevertTemplateResponse.md)**
### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,401,402,404           | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |

## preview

Returns a preview of a template for a given template_type, slug and body

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.components.*;
import com.clerk.backend_api.models.operations.*;
import com.clerk.backend_api.utils.EventStream;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;
import static java.util.Map.entry;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            PreviewTemplateResponse res = sdk.templates().preview()
                .templateType("<value>")
                .slug("<value>")
                .requestBody(PreviewTemplateRequestBody.builder()
                    .build())
                .call();

            if (res.object().isPresent()) {
                // handle response
            }
        } catch (com.clerk.backend_api.models.errors.ClerkErrors e) {
            // handle exception
            throw e;
        } catch (com.clerk.backend_api.models.errors.SDKError e) {
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

| Parameter                                                                                                                                       | Type                                                                                                                                            | Required                                                                                                                                        | Description                                                                                                                                     |
| ----------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------- |
| `templateType`                                                                                                                                  | *String*                                                                                                                                        | :heavy_check_mark:                                                                                                                              | The type of template to preview                                                                                                                 |
| `slug`                                                                                                                                          | *String*                                                                                                                                        | :heavy_check_mark:                                                                                                                              | The slug of the template to preview                                                                                                             |
| `requestBody`                                                                                                                                   | [Optional<? extends com.clerk.backend_api.models.operations.PreviewTemplateRequestBody>](../../models/operations/PreviewTemplateRequestBody.md) | :heavy_minus_sign:                                                                                                                              | Required parameters                                                                                                                             |


### Response

**[com.clerk.backend_api.models.operations.PreviewTemplateResponse](../../models/operations/PreviewTemplateResponse.md)**
### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,401,404,422           | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |

## toggleDelivery

Toggles the delivery by Clerk for a template of a given type and slug.
If disabled, Clerk will not deliver the resulting email or SMS.
The app developer will need to listen to the `email.created` or `sms.created` webhooks in order to handle delivery themselves.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.components.*;
import com.clerk.backend_api.models.operations.*;
import com.clerk.backend_api.utils.EventStream;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;
import static java.util.Map.entry;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            ToggleTemplateDeliveryResponse res = sdk.templates().toggleDelivery()
                .templateType(ToggleTemplateDeliveryPathParamTemplateType.EMAIL)
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
        } catch (com.clerk.backend_api.models.errors.SDKError e) {
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

| Parameter                                                                                                                                                     | Type                                                                                                                                                          | Required                                                                                                                                                      | Description                                                                                                                                                   |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `templateType`                                                                                                                                                | [com.clerk.backend_api.models.operations.ToggleTemplateDeliveryPathParamTemplateType](../../models/operations/ToggleTemplateDeliveryPathParamTemplateType.md) | :heavy_check_mark:                                                                                                                                            | The type of template to toggle delivery for                                                                                                                   |
| `slug`                                                                                                                                                        | *String*                                                                                                                                                      | :heavy_check_mark:                                                                                                                                            | The slug of the template for which to toggle delivery                                                                                                         |
| `requestBody`                                                                                                                                                 | [Optional<? extends com.clerk.backend_api.models.operations.ToggleTemplateDeliveryRequestBody>](../../models/operations/ToggleTemplateDeliveryRequestBody.md) | :heavy_minus_sign:                                                                                                                                            | N/A                                                                                                                                                           |


### Response

**[com.clerk.backend_api.models.operations.ToggleTemplateDeliveryResponse](../../models/operations/ToggleTemplateDeliveryResponse.md)**
### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,401,404               | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |
