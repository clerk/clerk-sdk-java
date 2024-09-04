# RedirectURLs
(*redirectURLs()*)

## Overview

### Available Operations

* [list](#list) - List all redirect URLs
* [create](#create) - Create a redirect URL
* [get](#get) - Retrieve a redirect URL
* [delete](#delete) - Delete a redirect URL

## list

Lists all whitelisted redirect_urls for the instance

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.ListRedirectURLsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            ListRedirectURLsResponse res = sdk.redirectURLs().list()
                .call();

            if (res.redirectURLList().isPresent()) {
                // handle response
            }
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

### Response

**[ListRedirectURLsResponse](../../models/operations/ListRedirectURLsResponse.md)**

### Errors

| Error Object           | Status Code            | Content Type           |
| ---------------------- | ---------------------- | ---------------------- |
| models/errors/SDKError | 4xx-5xx                | \*\/*                  |


## create

Create a redirect URL

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.CreateRedirectURLRequestBody;
import com.clerk.backend_api.models.operations.CreateRedirectURLResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            CreateRedirectURLRequestBody req = CreateRedirectURLRequestBody.builder()
                .build();

            CreateRedirectURLResponse res = sdk.redirectURLs().create()
                .request(req)
                .call();

            if (res.redirectURL().isPresent()) {
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

| Parameter                                                                               | Type                                                                                    | Required                                                                                | Description                                                                             |
| --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- |
| `request`                                                                               | [CreateRedirectURLRequestBody](../../models/operations/CreateRedirectURLRequestBody.md) | :heavy_check_mark:                                                                      | The request object to use for the request.                                              |

### Response

**[CreateRedirectURLResponse](../../models/operations/CreateRedirectURLResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,422                   | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## get

Retrieve the details of the redirect URL with the given ID

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.GetRedirectURLResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            GetRedirectURLResponse res = sdk.redirectURLs().get()
                .id("<id>")
                .call();

            if (res.redirectURL().isPresent()) {
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

| Parameter                  | Type                       | Required                   | Description                |
| -------------------------- | -------------------------- | -------------------------- | -------------------------- |
| `id`                       | *String*                   | :heavy_check_mark:         | The ID of the redirect URL |

### Response

**[GetRedirectURLResponse](../../models/operations/GetRedirectURLResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 404                       | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## delete

Remove the selected redirect URL from the whitelist of the instance

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.DeleteRedirectURLResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            DeleteRedirectURLResponse res = sdk.redirectURLs().delete()
                .id("<id>")
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

| Parameter                  | Type                       | Required                   | Description                |
| -------------------------- | -------------------------- | -------------------------- | -------------------------- |
| `id`                       | *String*                   | :heavy_check_mark:         | The ID of the redirect URL |

### Response

**[DeleteRedirectURLResponse](../../models/operations/DeleteRedirectURLResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 404                       | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |
