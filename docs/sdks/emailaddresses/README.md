# EmailAddresses

## Overview

### Available Operations

* [create](#create) - Create an email address
* [get](#get) - Retrieve an email address
* [delete](#delete) - Delete an email address
* [update](#update) - Update an email address
* [prepareVerification](#prepareverification) - Send a verification code to an email address
* [attemptVerification](#attemptverification) - Verify a code sent to an email address
* [replaceForUser](#replaceforuser) - Replace a user's email address

## create

Create a new email address

### Example Usage

<!-- UsageSnippet language="java" operationID="CreateEmailAddress" method="post" path="/email_addresses" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CreateEmailAddressResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        CreateEmailAddressResponse res = sdk.emailAddresses().create()
                .call();

        if (res.emailAddress().isPresent()) {
            System.out.println(res.emailAddress().get());
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

| Error Type                   | Status Code                  | Content Type                 |
| ---------------------------- | ---------------------------- | ---------------------------- |
| models/errors/ClerkErrors    | 400, 401, 403, 404, 409, 422 | application/json             |
| models/errors/SDKError       | 4XX, 5XX                     | \*/\*                        |

## get

Returns the details of an email address.

### Example Usage

<!-- UsageSnippet language="java" operationID="GetEmailAddress" method="get" path="/email_addresses/{email_address_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.GetEmailAddressResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        GetEmailAddressResponse res = sdk.emailAddresses().get()
                .emailAddressId("<id>")
                .call();

        if (res.emailAddress().isPresent()) {
            System.out.println(res.emailAddress().get());
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

<!-- UsageSnippet language="java" operationID="DeleteEmailAddress" method="delete" path="/email_addresses/{email_address_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.DeleteEmailAddressResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        DeleteEmailAddressResponse res = sdk.emailAddresses().delete()
                .emailAddressId("<id>")
                .call();

        if (res.deletedObject().isPresent()) {
            System.out.println(res.deletedObject().get());
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
| models/errors/ClerkErrors | 400, 401, 403, 404, 409   | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## update

Updates an email address.

### Example Usage

<!-- UsageSnippet language="java" operationID="UpdateEmailAddress" method="patch" path="/email_addresses/{email_address_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UpdateEmailAddressResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        UpdateEmailAddressResponse res = sdk.emailAddresses().update()
                .emailAddressId("<id>")
                .call();

        if (res.emailAddress().isPresent()) {
            System.out.println(res.emailAddress().get());
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
| models/errors/ClerkErrors | 400, 401, 403, 404, 409   | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## prepareVerification

Sends a one-time code to the given email address so that a backend can
verify the user controls it (for example, in a custom, backend-driven
sign-in flow). The code is tracked on its own verification; confirm it
with attempt_verification.

### Example Usage

<!-- UsageSnippet language="java" operationID="PrepareEmailAddressVerification" method="post" path="/email_addresses/{email_address_id}/prepare_verification" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.PrepareEmailAddressVerificationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        PrepareEmailAddressVerificationResponse res = sdk.emailAddresses().prepareVerification()
                .emailAddressId("<id>")
                .call();

        if (res.verificationResponse().isPresent()) {
            System.out.println(res.verificationResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                    | Type                                                         | Required                                                     | Description                                                  |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| `emailAddressId`                                             | *String*                                                     | :heavy_check_mark:                                           | The ID of the email address to send the verification code to |

### Response

**[PrepareEmailAddressVerificationResponse](../../models/operations/PrepareEmailAddressVerificationResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404        | application/json          |
| models/errors/ClerkErrors | 500                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## attemptVerification

Checks a one-time code against the verification identified by
verification_id, and returns the verification with its updated status
(`verified`, `unverified`, `expired`, or `failed`) and attempt count, so a
backend driving its own frontend can react on every attempt — an incorrect
or expired code is reported through the status, not as an error. Resubmitting
a verification whose code was already accepted is rejected with a
`verification_already_verified` error. If the code
is correct and the email address is not already verified, it is also marked
as verified as a side effect (just as it would be in a frontend verification
flow); an already verified email address is left unchanged. It never creates
a session; to sign the user in afterwards, mint a sign-in token.

### Example Usage

<!-- UsageSnippet language="java" operationID="AttemptEmailAddressVerification" method="post" path="/email_addresses/{email_address_id}/attempt_verification" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.AttemptEmailAddressVerificationRequestBody;
import com.clerk.backend_api.models.operations.AttemptEmailAddressVerificationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        AttemptEmailAddressVerificationResponse res = sdk.emailAddresses().attemptVerification()
                .emailAddressId("<id>")
                .requestBody(AttemptEmailAddressVerificationRequestBody.builder()
                    .verificationId("<id>")
                    .code("<value>")
                    .build())
                .call();

        if (res.verificationResponse().isPresent()) {
            System.out.println(res.verificationResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                           | Type                                                                                                                | Required                                                                                                            | Description                                                                                                         |
| ------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------- |
| `emailAddressId`                                                                                                    | *String*                                                                                                            | :heavy_check_mark:                                                                                                  | The ID of the email address whose code is being verified                                                            |
| `requestBody`                                                                                                       | [AttemptEmailAddressVerificationRequestBody](../../models/operations/AttemptEmailAddressVerificationRequestBody.md) | :heavy_check_mark:                                                                                                  | N/A                                                                                                                 |

### Response

**[AttemptEmailAddressVerificationResponse](../../models/operations/AttemptEmailAddressVerificationResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404        | application/json          |
| models/errors/ClerkErrors | 500                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## replaceForUser

Replaces all of the user's email addresses with a single primary email address.
By default the new email address is created verified, with the admin verification strategy.
When `identification_status` is `reserved` it is created reserved instead: unverified but usable
for sign-in and locked so no other user can claim it. Any existing email addresses are deleted.
If an existing email address is linked to a connected account, the request is rejected; remove
the connected account first.

### Example Usage

<!-- UsageSnippet language="java" operationID="ReplaceUserEmailAddress" method="put" path="/users/{user_id}/email_address" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.ReplaceUserEmailAddressRequestBody;
import com.clerk.backend_api.models.operations.ReplaceUserEmailAddressResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        ReplaceUserEmailAddressResponse res = sdk.emailAddresses().replaceForUser()
                .userId("<id>")
                .requestBody(ReplaceUserEmailAddressRequestBody.builder()
                    .emailAddress("Ines83@gmail.com")
                    .build())
                .call();

        if (res.emailAddress().isPresent()) {
            System.out.println(res.emailAddress().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                           | Type                                                                                                | Required                                                                                            | Description                                                                                         |
| --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- |
| `userId`                                                                                            | *String*                                                                                            | :heavy_check_mark:                                                                                  | The ID of the user whose email address to replace                                                   |
| `requestBody`                                                                                       | [ReplaceUserEmailAddressRequestBody](../../models/operations/ReplaceUserEmailAddressRequestBody.md) | :heavy_check_mark:                                                                                  | N/A                                                                                                 |

### Response

**[ReplaceUserEmailAddressResponse](../../models/operations/ReplaceUserEmailAddressResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404, 422   | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |