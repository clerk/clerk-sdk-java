# PhoneNumbers
(*phoneNumbers()*)

## Overview

### Available Operations

* [create](#create) - Create a phone number
* [get](#get) - Retrieve a phone number
* [delete](#delete) - Delete a phone number
* [update](#update) - Update a phone number

## create

Create a new phone number

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.CreatePhoneNumberRequestBody;
import com.clerk.backend_api.models.operations.CreatePhoneNumberResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            CreatePhoneNumberRequestBody req = CreatePhoneNumberRequestBody.builder()
                .build();

            CreatePhoneNumberResponse res = sdk.phoneNumbers().create()
                .request(req)
                .call();

            if (res.phoneNumber().isPresent()) {
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
| `request`                                                                               | [CreatePhoneNumberRequestBody](../../models/operations/CreatePhoneNumberRequestBody.md) | :heavy_check_mark:                                                                      | The request object to use for the request.                                              |

### Response

**[CreatePhoneNumberResponse](../../models/operations/CreatePhoneNumberResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,401,403,404,422       | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## get

Returns the details of a phone number

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.GetPhoneNumberResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            GetPhoneNumberResponse res = sdk.phoneNumbers().get()
                .phoneNumberId("<value>")
                .call();

            if (res.phoneNumber().isPresent()) {
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

| Parameter                              | Type                                   | Required                               | Description                            |
| -------------------------------------- | -------------------------------------- | -------------------------------------- | -------------------------------------- |
| `phoneNumberId`                        | *String*                               | :heavy_check_mark:                     | The ID of the phone number to retrieve |

### Response

**[GetPhoneNumberResponse](../../models/operations/GetPhoneNumberResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,401,403,404           | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## delete

Delete the phone number with the given ID

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.DeletePhoneNumberResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            DeletePhoneNumberResponse res = sdk.phoneNumbers().delete()
                .phoneNumberId("<value>")
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

| Parameter                            | Type                                 | Required                             | Description                          |
| ------------------------------------ | ------------------------------------ | ------------------------------------ | ------------------------------------ |
| `phoneNumberId`                      | *String*                             | :heavy_check_mark:                   | The ID of the phone number to delete |

### Response

**[DeletePhoneNumberResponse](../../models/operations/DeletePhoneNumberResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,401,403,404           | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## update

Updates a phone number

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.UpdatePhoneNumberRequestBody;
import com.clerk.backend_api.models.operations.UpdatePhoneNumberResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            UpdatePhoneNumberResponse res = sdk.phoneNumbers().update()
                .phoneNumberId("<value>")
                .requestBody(UpdatePhoneNumberRequestBody.builder()
                    .build())
                .call();

            if (res.phoneNumber().isPresent()) {
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
| `phoneNumberId`                                                                                   | *String*                                                                                          | :heavy_check_mark:                                                                                | The ID of the phone number to update                                                              |
| `requestBody`                                                                                     | [Optional<UpdatePhoneNumberRequestBody>](../../models/operations/UpdatePhoneNumberRequestBody.md) | :heavy_minus_sign:                                                                                | N/A                                                                                               |

### Response

**[UpdatePhoneNumberResponse](../../models/operations/UpdatePhoneNumberResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,401,403,404           | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |
