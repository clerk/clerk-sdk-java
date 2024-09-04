# OAuthApplications
(*oAuthApplications()*)

## Overview

### Available Operations

* [list](#list) - Get a list of OAuth applications for an instance
* [create](#create) - Create an OAuth application
* [get](#get) - Retrieve an OAuth application by ID
* [updateApplication](#updateapplication) - Update an OAuth application
* [delete](#delete) - Delete an OAuth application
* [rotateSecret](#rotatesecret) - Rotate the client secret of the given OAuth application

## list

This request returns the list of OAuth applications for an instance.
Results can be paginated using the optional `limit` and `offset` query parameters.
The OAuth applications are ordered by descending creation date.
Most recent OAuth applications will be returned first.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            sdk.oAuthApplications().list()
                .limit(10L)
                .offset(0L)
                .callAsStreamUnwrapped()
                .forEach(item -> {
                   // handle item
                });

        } catch (com.clerk.backend_api.models.errors.ClerkErrors e) {
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

| Parameter                                                                                                                                 | Type                                                                                                                                      | Required                                                                                                                                  | Description                                                                                                                               |
| ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- |
| `limit`                                                                                                                                   | *Optional<Long>*                                                                                                                          | :heavy_minus_sign:                                                                                                                        | Applies a limit to the number of results returned.<br/>Can be used for paginating the results together with `offset`.                     |
| `offset`                                                                                                                                  | *Optional<Long>*                                                                                                                          | :heavy_minus_sign:                                                                                                                        | Skip the first `offset` results when paginating.<br/>Needs to be an integer greater or equal to zero.<br/>To be used in conjunction with `limit`. |

### Response

**[ListOAuthApplicationsResponse](../../models/operations/ListOAuthApplicationsResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,403,422               | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## create

Creates a new OAuth application with the given name and callback URL for an instance.
The callback URL must be a valid url.
All URL schemes are allowed such as `http://`, `https://`, `myapp://`, etc...

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.CreateOAuthApplicationRequestBody;
import com.clerk.backend_api.models.operations.CreateOAuthApplicationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            CreateOAuthApplicationRequestBody req = CreateOAuthApplicationRequestBody.builder()
                .name("<value>")
                .callbackUrl("<value>")
                .scopes("profile email public_metadata")
                .build();

            CreateOAuthApplicationResponse res = sdk.oAuthApplications().create()
                .request(req)
                .call();

            if (res.oAuthApplicationWithSecret().isPresent()) {
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

| Parameter                                                                                         | Type                                                                                              | Required                                                                                          | Description                                                                                       |
| ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- |
| `request`                                                                                         | [CreateOAuthApplicationRequestBody](../../models/operations/CreateOAuthApplicationRequestBody.md) | :heavy_check_mark:                                                                                | The request object to use for the request.                                                        |

### Response

**[CreateOAuthApplicationResponse](../../models/operations/CreateOAuthApplicationResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,403,422               | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## get

Fetches the OAuth application whose ID matches the provided `id` in the path.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.GetOAuthApplicationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            GetOAuthApplicationResponse res = sdk.oAuthApplications().get()
                .oauthApplicationId("<value>")
                .call();

            if (res.oAuthApplication().isPresent()) {
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

| Parameter                       | Type                            | Required                        | Description                     |
| ------------------------------- | ------------------------------- | ------------------------------- | ------------------------------- |
| `oauthApplicationId`            | *String*                        | :heavy_check_mark:              | The ID of the OAuth application |

### Response

**[GetOAuthApplicationResponse](../../models/operations/GetOAuthApplicationResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 403,404                   | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## updateApplication

Updates an existing OAuth application

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.UpdateOAuthApplicationRequestBody;
import com.clerk.backend_api.models.operations.UpdateOAuthApplicationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            UpdateOAuthApplicationResponse res = sdk.oAuthApplications().updateApplication()
                .oauthApplicationId("<value>")
                .requestBody(UpdateOAuthApplicationRequestBody.builder()
                    .scopes("profile email public_metadata private_metadata")
                    .build())
                .call();

            if (res.oAuthApplication().isPresent()) {
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

| Parameter                                                                                         | Type                                                                                              | Required                                                                                          | Description                                                                                       |
| ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- |
| `oauthApplicationId`                                                                              | *String*                                                                                          | :heavy_check_mark:                                                                                | The ID of the OAuth application to update                                                         |
| `requestBody`                                                                                     | [UpdateOAuthApplicationRequestBody](../../models/operations/UpdateOAuthApplicationRequestBody.md) | :heavy_check_mark:                                                                                | N/A                                                                                               |

### Response

**[UpdateOAuthApplicationResponse](../../models/operations/UpdateOAuthApplicationResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 403,404,422               | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## delete

Deletes the given OAuth application.
This is not reversible.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.DeleteOAuthApplicationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            DeleteOAuthApplicationResponse res = sdk.oAuthApplications().delete()
                .oauthApplicationId("<value>")
                .call();

            if (res.deletedObject().isPresent()) {
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

| Parameter                                 | Type                                      | Required                                  | Description                               |
| ----------------------------------------- | ----------------------------------------- | ----------------------------------------- | ----------------------------------------- |
| `oauthApplicationId`                      | *String*                                  | :heavy_check_mark:                        | The ID of the OAuth application to delete |

### Response

**[DeleteOAuthApplicationResponse](../../models/operations/DeleteOAuthApplicationResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 403,404                   | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## rotateSecret

Rotates the OAuth application's client secret.
When the client secret is rotated, make sure to update it in authorized OAuth clients.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.RotateOAuthApplicationSecretResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            RotateOAuthApplicationSecretResponse res = sdk.oAuthApplications().rotateSecret()
                .oauthApplicationId("<value>")
                .call();

            if (res.oAuthApplicationWithSecret().isPresent()) {
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

| Parameter                                                             | Type                                                                  | Required                                                              | Description                                                           |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| `oauthApplicationId`                                                  | *String*                                                              | :heavy_check_mark:                                                    | The ID of the OAuth application for which to rotate the client secret |

### Response

**[RotateOAuthApplicationSecretResponse](../../models/operations/RotateOAuthApplicationSecretResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 403,404                   | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |
