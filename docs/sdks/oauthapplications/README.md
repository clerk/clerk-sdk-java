# OauthApplications
(*oauthApplications()*)

## Overview

### Available Operations

* [list](#list) - Get a list of OAuth applications for an instance
* [create](#create) - Create an OAuth application
* [get](#get) - Retrieve an OAuth application by ID
* [update](#update) - Update an OAuth application
* [delete](#delete) - Delete an OAuth application
* [rotateSecret](#rotatesecret) - Rotate the client secret of the given OAuth application

## list

This request returns the list of OAuth applications for an instance.
Results can be paginated using the optional `limit` and `offset` query parameters.
The OAuth applications are ordered by descending creation date.
Most recent OAuth applications will be returned first.

### Example Usage

<!-- UsageSnippet language="java" operationID="ListOAuthApplications" method="get" path="/oauth_applications" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.ListOAuthApplicationsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        ListOAuthApplicationsResponse res = sdk.oauthApplications().list()
                .limit(10L)
                .offset(0L)
                .orderBy("+created_at")
                .call();

        if (res.oAuthApplications().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            | Type                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 | Required                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             | Description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          |
| ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `limit`                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              | *Optional\<Long>*                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   | Applies a limit to the number of results returned.<br/>Can be used for paginating the results together with `offset`.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
| `offset`                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             | *Optional\<Long>*                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   | Skip the first `offset` results when paginating.<br/>Needs to be an integer greater or equal to zero.<br/>To be used in conjunction with `limit`.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |
| `orderBy`                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   | Allows to return OAuth applications in a particular order.<br/>At the moment, you can order the returned OAuth applications by their `created_at` and `name`.<br/>In order to specify the direction, you can use the `+/-` symbols prepended in the property to order by.<br/>For example, if you want OAuth applications to be returned in descending order according to their `created_at` property, you can use `-created_at`.<br/>If you don't use `+` or `-`, then `+` is implied. We only support one `order_by` parameter, and if multiple `order_by` parameters are provided, we will only keep the first one. For example,<br/>if you pass `order_by=name&order_by=created_at`, we will consider only the first `order_by` parameter, which is `name`. The `created_at` parameter will be ignored in this case. |
| `nameQuery`                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   | Returns OAuth applications with names that match the given query, via case-insensitive partial match.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |

### Response

**[ListOAuthApplicationsResponse](../../models/operations/ListOAuthApplicationsResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 403, 422             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## create

Creates a new OAuth application with the given name and callback URL for an instance.
The callback URL must be a valid url.
All URL schemes are allowed such as `http://`, `https://`, `myapp://`, etc...

### Example Usage

<!-- UsageSnippet language="java" operationID="CreateOAuthApplication" method="post" path="/oauth_applications" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CreateOAuthApplicationRequestBody;
import com.clerk.backend_api.models.operations.CreateOAuthApplicationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        CreateOAuthApplicationRequestBody req = CreateOAuthApplicationRequestBody.builder()
                .name("<value>")
                .scopes("profile email public_metadata")
                .build();

        CreateOAuthApplicationResponse res = sdk.oauthApplications().create()
                .request(req)
                .call();

        if (res.oAuthApplicationWithSecret().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                         | Type                                                                                              | Required                                                                                          | Description                                                                                       |
| ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- |
| `request`                                                                                         | [CreateOAuthApplicationRequestBody](../../models/operations/CreateOAuthApplicationRequestBody.md) | :heavy_check_mark:                                                                                | The request object to use for the request.                                                        |

### Response

**[CreateOAuthApplicationResponse](../../models/operations/CreateOAuthApplicationResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 403, 422             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## get

Fetches the OAuth application whose ID matches the provided `id` in the path.

### Example Usage

<!-- UsageSnippet language="java" operationID="GetOAuthApplication" method="get" path="/oauth_applications/{oauth_application_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.GetOAuthApplicationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        GetOAuthApplicationResponse res = sdk.oauthApplications().get()
                .oauthApplicationId("<id>")
                .call();

        if (res.oAuthApplication().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                       | Type                            | Required                        | Description                     |
| ------------------------------- | ------------------------------- | ------------------------------- | ------------------------------- |
| `oauthApplicationId`            | *String*                        | :heavy_check_mark:              | The ID of the OAuth application |

### Response

**[GetOAuthApplicationResponse](../../models/operations/GetOAuthApplicationResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 403, 404                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## update

Updates an existing OAuth application

### Example Usage

<!-- UsageSnippet language="java" operationID="UpdateOAuthApplication" method="patch" path="/oauth_applications/{oauth_application_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UpdateOAuthApplicationRequestBody;
import com.clerk.backend_api.models.operations.UpdateOAuthApplicationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        UpdateOAuthApplicationResponse res = sdk.oauthApplications().update()
                .oauthApplicationId("<id>")
                .requestBody(UpdateOAuthApplicationRequestBody.builder()
                    .scopes("profile email public_metadata private_metadata")
                    .build())
                .call();

        if (res.oAuthApplication().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                         | Type                                                                                              | Required                                                                                          | Description                                                                                       |
| ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- |
| `oauthApplicationId`                                                                              | *String*                                                                                          | :heavy_check_mark:                                                                                | The ID of the OAuth application to update                                                         |
| `requestBody`                                                                                     | [UpdateOAuthApplicationRequestBody](../../models/operations/UpdateOAuthApplicationRequestBody.md) | :heavy_check_mark:                                                                                | N/A                                                                                               |

### Response

**[UpdateOAuthApplicationResponse](../../models/operations/UpdateOAuthApplicationResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 403, 404, 422        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## delete

Deletes the given OAuth application.
This is not reversible.

### Example Usage

<!-- UsageSnippet language="java" operationID="DeleteOAuthApplication" method="delete" path="/oauth_applications/{oauth_application_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.DeleteOAuthApplicationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        DeleteOAuthApplicationResponse res = sdk.oauthApplications().delete()
                .oauthApplicationId("<id>")
                .call();

        if (res.deletedObject().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                 | Type                                      | Required                                  | Description                               |
| ----------------------------------------- | ----------------------------------------- | ----------------------------------------- | ----------------------------------------- |
| `oauthApplicationId`                      | *String*                                  | :heavy_check_mark:                        | The ID of the OAuth application to delete |

### Response

**[DeleteOAuthApplicationResponse](../../models/operations/DeleteOAuthApplicationResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 403, 404                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## rotateSecret

Rotates the OAuth application's client secret.
When the client secret is rotated, make sure to update it in authorized OAuth clients.

### Example Usage

<!-- UsageSnippet language="java" operationID="RotateOAuthApplicationSecret" method="post" path="/oauth_applications/{oauth_application_id}/rotate_secret" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.RotateOAuthApplicationSecretResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        RotateOAuthApplicationSecretResponse res = sdk.oauthApplications().rotateSecret()
                .oauthApplicationId("<id>")
                .call();

        if (res.oAuthApplicationWithSecret().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                             | Type                                                                  | Required                                                              | Description                                                           |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| `oauthApplicationId`                                                  | *String*                                                              | :heavy_check_mark:                                                    | The ID of the OAuth application for which to rotate the client secret |

### Response

**[RotateOAuthApplicationSecretResponse](../../models/operations/RotateOAuthApplicationSecretResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 403, 404                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |