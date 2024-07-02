# EmailAddresses
(*emailAddresses()*)

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
import com.clerk.backend_api.models.components.*;
import com.clerk.backend_api.models.components.Security;
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

            CreateEmailAddressRequestBody req = CreateEmailAddressRequestBody.builder()
                .build();

            CreateEmailAddressResponse res = sdk.emailAddresses().create()
                .request(req)
                .call();

            if (res.emailAddress().isPresent()) {
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

| Parameter                                                                                                                         | Type                                                                                                                              | Required                                                                                                                          | Description                                                                                                                       |
| --------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                                         | [com.clerk.backend_api.models.operations.CreateEmailAddressRequestBody](../../models/operations/CreateEmailAddressRequestBody.md) | :heavy_check_mark:                                                                                                                | The request object to use for the request.                                                                                        |


### Response

**[com.clerk.backend_api.models.operations.CreateEmailAddressResponse](../../models/operations/CreateEmailAddressResponse.md)**
### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,401,403,404,422       | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |

## get

Returns the details of an email address.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.components.*;
import com.clerk.backend_api.models.components.Security;
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

            GetEmailAddressResponse res = sdk.emailAddresses().get()
                .emailAddressId("<value>")
                .call();

            if (res.emailAddress().isPresent()) {
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

| Parameter                               | Type                                    | Required                                | Description                             |
| --------------------------------------- | --------------------------------------- | --------------------------------------- | --------------------------------------- |
| `emailAddressId`                        | *String*                                | :heavy_check_mark:                      | The ID of the email address to retrieve |


### Response

**[com.clerk.backend_api.models.operations.GetEmailAddressResponse](../../models/operations/GetEmailAddressResponse.md)**
### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,401,403,404           | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |

## delete

Delete the email address with the given ID

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.components.*;
import com.clerk.backend_api.models.components.Security;
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

            DeleteEmailAddressResponse res = sdk.emailAddresses().delete()
                .emailAddressId("<value>")
                .call();

            if (res.deletedObject().isPresent()) {
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

| Parameter                             | Type                                  | Required                              | Description                           |
| ------------------------------------- | ------------------------------------- | ------------------------------------- | ------------------------------------- |
| `emailAddressId`                      | *String*                              | :heavy_check_mark:                    | The ID of the email address to delete |


### Response

**[com.clerk.backend_api.models.operations.DeleteEmailAddressResponse](../../models/operations/DeleteEmailAddressResponse.md)**
### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,401,403,404           | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |

## update

Updates an email address.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.components.*;
import com.clerk.backend_api.models.components.Security;
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

            UpdateEmailAddressResponse res = sdk.emailAddresses().update()
                .emailAddressId("<value>")
                .requestBody(UpdateEmailAddressRequestBody.builder()
                    .build())
                .call();

            if (res.emailAddress().isPresent()) {
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

| Parameter                                                                                                                                             | Type                                                                                                                                                  | Required                                                                                                                                              | Description                                                                                                                                           |
| ----------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------- |
| `emailAddressId`                                                                                                                                      | *String*                                                                                                                                              | :heavy_check_mark:                                                                                                                                    | The ID of the email address to update                                                                                                                 |
| `requestBody`                                                                                                                                         | [Optional<? extends com.clerk.backend_api.models.operations.UpdateEmailAddressRequestBody>](../../models/operations/UpdateEmailAddressRequestBody.md) | :heavy_minus_sign:                                                                                                                                    | N/A                                                                                                                                                   |


### Response

**[com.clerk.backend_api.models.operations.UpdateEmailAddressResponse](../../models/operations/UpdateEmailAddressResponse.md)**
### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,401,403,404           | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |
