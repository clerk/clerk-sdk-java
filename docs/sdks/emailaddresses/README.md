# EmailAddresses
(*emailAddresses()*)

## Overview

### Available Operations

* [create](#create) - Create an email address
* [get](#get) - Retrieve an email address
* [delete](#delete) - Delete an email address
* [update](#update) - Update an email address

## create

Create a new email address

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CreateEmailAddressRequestBody;
import com.clerk.backend_api.models.operations.CreateEmailAddressResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        CreateEmailAddressRequestBody req = CreateEmailAddressRequestBody.builder()
                .userId("<id>")
                .emailAddress("Loyal79@yahoo.com")
                .build();

        CreateEmailAddressResponse res = sdk.emailAddresses().create()
                .request(req)
                .call();

        if (res.emailAddress().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                 | Type                                                                                      | Required                                                                                  | Description                                                                               |
| ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- |
| `request`                                                                                 | [CreateEmailAddressRequestBody](../../models/operations/CreateEmailAddressRequestBody.md) | :heavy_check_mark:                                                                        | The request object to use for the request.                                                |

### Response

**[CreateEmailAddressResponse](../../models/operations/CreateEmailAddressResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404, 422   | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## get

Returns the details of an email address.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.GetEmailAddressResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        GetEmailAddressResponse res = sdk.emailAddresses().get()
                .emailAddressId("<id>")
                .call();

        if (res.emailAddress().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                               | Type                                    | Required                                | Description                             |
| --------------------------------------- | --------------------------------------- | --------------------------------------- | --------------------------------------- |
| `emailAddressId`                        | *String*                                | :heavy_check_mark:                      | The ID of the email address to retrieve |

### Response

**[GetEmailAddressResponse](../../models/operations/GetEmailAddressResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## delete

Delete the email address with the given ID

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.DeleteEmailAddressResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        DeleteEmailAddressResponse res = sdk.emailAddresses().delete()
                .emailAddressId("<id>")
                .call();

        if (res.deletedObject().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                             | Type                                  | Required                              | Description                           |
| ------------------------------------- | ------------------------------------- | ------------------------------------- | ------------------------------------- |
| `emailAddressId`                      | *String*                              | :heavy_check_mark:                    | The ID of the email address to delete |

### Response

**[DeleteEmailAddressResponse](../../models/operations/DeleteEmailAddressResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## update

Updates an email address.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UpdateEmailAddressRequestBody;
import com.clerk.backend_api.models.operations.UpdateEmailAddressResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        UpdateEmailAddressResponse res = sdk.emailAddresses().update()
                .emailAddressId("<id>")
                .requestBody(UpdateEmailAddressRequestBody.builder()
                    .build())
                .call();

        if (res.emailAddress().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                            | Type                                                                                                 | Required                                                                                             | Description                                                                                          |
| ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- |
| `emailAddressId`                                                                                     | *String*                                                                                             | :heavy_check_mark:                                                                                   | The ID of the email address to update                                                                |
| `requestBody`                                                                                        | [Optional\<UpdateEmailAddressRequestBody>](../../models/operations/UpdateEmailAddressRequestBody.md) | :heavy_minus_sign:                                                                                   | N/A                                                                                                  |

### Response

**[UpdateEmailAddressResponse](../../models/operations/UpdateEmailAddressResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |