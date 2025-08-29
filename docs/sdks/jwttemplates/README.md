# JwtTemplates
(*jwtTemplates()*)

## Overview

### Available Operations

* [list](#list) - List all templates
* [create](#create) - Create a JWT template
* [get](#get) - Retrieve a template
* [update](#update) - Update a JWT template
* [delete](#delete) - Delete a Template

## list

List all templates

### Example Usage

<!-- UsageSnippet language="java" operationID="ListJWTTemplates" method="get" path="/jwt_templates" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.operations.ListJWTTemplatesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        ListJWTTemplatesResponse res = sdk.jwtTemplates().list()
                .limit(10L)
                .offset(0L)
                .call();

        if (res.jwtTemplateList().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                 | Type                                                                                                                                      | Required                                                                                                                                  | Description                                                                                                                               |
| ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- |
| `paginated`                                                                                                                               | *Optional\<Boolean>*                                                                                                                      | :heavy_minus_sign:                                                                                                                        | Whether to paginate the results.<br/>If true, the results will be paginated.<br/>If false, the results will not be paginated.             |
| `limit`                                                                                                                                   | *Optional\<Long>*                                                                                                                         | :heavy_minus_sign:                                                                                                                        | Applies a limit to the number of results returned.<br/>Can be used for paginating the results together with `offset`.                     |
| `offset`                                                                                                                                  | *Optional\<Long>*                                                                                                                         | :heavy_minus_sign:                                                                                                                        | Skip the first `offset` results when paginating.<br/>Needs to be an integer greater or equal to zero.<br/>To be used in conjunction with `limit`. |

### Response

**[ListJWTTemplatesResponse](../../models/operations/ListJWTTemplatesResponse.md)**

### Errors

| Error Type             | Status Code            | Content Type           |
| ---------------------- | ---------------------- | ---------------------- |
| models/errors/SDKError | 4XX, 5XX               | \*/\*                  |

## create

Create a new JWT template

### Example Usage

<!-- UsageSnippet language="java" operationID="CreateJWTTemplate" method="post" path="/jwt_templates" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CreateJWTTemplateResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        CreateJWTTemplateResponse res = sdk.jwtTemplates().create()
                .call();

        if (res.jwtTemplate().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                               | Type                                                                                    | Required                                                                                | Description                                                                             |
| --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- |
| `request`                                                                               | [CreateJWTTemplateRequestBody](../../models/operations/CreateJWTTemplateRequestBody.md) | :heavy_check_mark:                                                                      | The request object to use for the request.                                              |

### Response

**[CreateJWTTemplateResponse](../../models/operations/CreateJWTTemplateResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 402, 422             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## get

Retrieve the details of a given JWT template

### Example Usage

<!-- UsageSnippet language="java" operationID="GetJWTTemplate" method="get" path="/jwt_templates/{template_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.GetJWTTemplateResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        GetJWTTemplateResponse res = sdk.jwtTemplates().get()
                .templateId("<id>")
                .call();

        if (res.jwtTemplate().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter          | Type               | Required           | Description        |
| ------------------ | ------------------ | ------------------ | ------------------ |
| `templateId`       | *String*           | :heavy_check_mark: | JWT Template ID    |

### Response

**[GetJWTTemplateResponse](../../models/operations/GetJWTTemplateResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 404                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## update

Updates an existing JWT template

### Example Usage

<!-- UsageSnippet language="java" operationID="UpdateJWTTemplate" method="patch" path="/jwt_templates/{template_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UpdateJWTTemplateResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        UpdateJWTTemplateResponse res = sdk.jwtTemplates().update()
                .templateId("<id>")
                .call();

        if (res.jwtTemplate().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                          | Type                                                                                               | Required                                                                                           | Description                                                                                        |
| -------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------- |
| `templateId`                                                                                       | *String*                                                                                           | :heavy_check_mark:                                                                                 | The ID of the JWT template to update                                                               |
| `requestBody`                                                                                      | [Optional\<UpdateJWTTemplateRequestBody>](../../models/operations/UpdateJWTTemplateRequestBody.md) | :heavy_minus_sign:                                                                                 | N/A                                                                                                |

### Response

**[UpdateJWTTemplateResponse](../../models/operations/UpdateJWTTemplateResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 402, 422             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## delete

Delete a Template

### Example Usage

<!-- UsageSnippet language="java" operationID="DeleteJWTTemplate" method="delete" path="/jwt_templates/{template_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.DeleteJWTTemplateResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        DeleteJWTTemplateResponse res = sdk.jwtTemplates().delete()
                .templateId("<id>")
                .call();

        if (res.deletedObject().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter          | Type               | Required           | Description        |
| ------------------ | ------------------ | ------------------ | ------------------ |
| `templateId`       | *String*           | :heavy_check_mark: | JWT Template ID    |

### Response

**[DeleteJWTTemplateResponse](../../models/operations/DeleteJWTTemplateResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 403, 404                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |