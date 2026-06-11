# PhoneNumbers

## Overview

### Available Operations

* [create](#create) - Create a phone number
* [get](#get) - Retrieve a phone number
* [delete](#delete) - Delete a phone number
* [update](#update) - Update a phone number
* [prepareVerification](#prepareverification) - Send a verification code to a phone number
* [attemptVerification](#attemptverification) - Verify a code sent to a phone number
* [replaceForUser](#replaceforuser) - Replace a user's phone number

## create

Create a new phone number

### Example Usage

<!-- UsageSnippet language="java" operationID="CreatePhoneNumber" method="post" path="/phone_numbers" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CreatePhoneNumberResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        CreatePhoneNumberResponse res = sdk.phoneNumbers().create()
                .call();

        if (res.phoneNumber().isPresent()) {
            System.out.println(res.phoneNumber().get());
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

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404, 422   | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## get

Returns the details of a phone number

### Example Usage

<!-- UsageSnippet language="java" operationID="GetPhoneNumber" method="get" path="/phone_numbers/{phone_number_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.GetPhoneNumberResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        GetPhoneNumberResponse res = sdk.phoneNumbers().get()
                .phoneNumberId("<id>")
                .call();

        if (res.phoneNumber().isPresent()) {
            System.out.println(res.phoneNumber().get());
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

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## delete

Delete the phone number with the given ID

### Example Usage

<!-- UsageSnippet language="java" operationID="DeletePhoneNumber" method="delete" path="/phone_numbers/{phone_number_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.DeletePhoneNumberResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        DeletePhoneNumberResponse res = sdk.phoneNumbers().delete()
                .phoneNumberId("<id>")
                .call();

        if (res.deletedObject().isPresent()) {
            System.out.println(res.deletedObject().get());
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

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## update

Updates a phone number

### Example Usage

<!-- UsageSnippet language="java" operationID="UpdatePhoneNumber" method="patch" path="/phone_numbers/{phone_number_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UpdatePhoneNumberResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        UpdatePhoneNumberResponse res = sdk.phoneNumbers().update()
                .phoneNumberId("<id>")
                .call();

        if (res.phoneNumber().isPresent()) {
            System.out.println(res.phoneNumber().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                          | Type                                                                                               | Required                                                                                           | Description                                                                                        |
| -------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------- |
| `phoneNumberId`                                                                                    | *String*                                                                                           | :heavy_check_mark:                                                                                 | The ID of the phone number to update                                                               |
| `requestBody`                                                                                      | [Optional\<UpdatePhoneNumberRequestBody>](../../models/operations/UpdatePhoneNumberRequestBody.md) | :heavy_minus_sign:                                                                                 | N/A                                                                                                |

### Response

**[UpdatePhoneNumberResponse](../../models/operations/UpdatePhoneNumberResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## prepareVerification

Sends a one-time code to the given phone number so that a backend can
verify the user controls it (for example, in a custom, backend-driven
sign-in flow). The code is tracked on its own verification; confirm it
with attempt_verification.

### Example Usage

<!-- UsageSnippet language="java" operationID="PreparePhoneNumberVerification" method="post" path="/phone_numbers/{phone_number_id}/prepare_verification" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.PreparePhoneNumberVerificationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        PreparePhoneNumberVerificationResponse res = sdk.phoneNumbers().prepareVerification()
                .phoneNumberId("<id>")
                .call();

        if (res.verificationResponse().isPresent()) {
            System.out.println(res.verificationResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                   | Type                                                        | Required                                                    | Description                                                 |
| ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- |
| `phoneNumberId`                                             | *String*                                                    | :heavy_check_mark:                                          | The ID of the phone number to send the verification code to |

### Response

**[PreparePhoneNumberVerificationResponse](../../models/operations/PreparePhoneNumberVerificationResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404, 429   | application/json          |
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
is correct and the phone number is not already verified, it is also marked
as verified as a side effect (just as it would be in a frontend verification
flow); an already verified phone number is left unchanged. It never creates
a session; to sign the user in afterwards, mint a sign-in token.

### Example Usage

<!-- UsageSnippet language="java" operationID="AttemptPhoneNumberVerification" method="post" path="/phone_numbers/{phone_number_id}/attempt_verification" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.AttemptPhoneNumberVerificationRequestBody;
import com.clerk.backend_api.models.operations.AttemptPhoneNumberVerificationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        AttemptPhoneNumberVerificationResponse res = sdk.phoneNumbers().attemptVerification()
                .phoneNumberId("<id>")
                .requestBody(AttemptPhoneNumberVerificationRequestBody.builder()
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

| Parameter                                                                                                         | Type                                                                                                              | Required                                                                                                          | Description                                                                                                       |
| ----------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- |
| `phoneNumberId`                                                                                                   | *String*                                                                                                          | :heavy_check_mark:                                                                                                | The ID of the phone number whose code is being verified                                                           |
| `requestBody`                                                                                                     | [AttemptPhoneNumberVerificationRequestBody](../../models/operations/AttemptPhoneNumberVerificationRequestBody.md) | :heavy_check_mark:                                                                                                | N/A                                                                                                               |

### Response

**[AttemptPhoneNumberVerificationResponse](../../models/operations/AttemptPhoneNumberVerificationResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404        | application/json          |
| models/errors/ClerkErrors | 500                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## replaceForUser

Replaces all of the user's phone numbers with a single primary phone number.
By default the new phone number is created verified, with the admin verification strategy.
When `identification_status` is `reserved` it is created reserved instead: unverified but usable
for sign-in and locked so no other user can claim it. The new phone number is never reserved for
second factor. Any existing phone numbers are deleted; replacing a phone number that is reserved
for second factor disables the user's MFA.

### Example Usage

<!-- UsageSnippet language="java" operationID="ReplaceUserPhoneNumber" method="put" path="/users/{user_id}/phone_number" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.ReplaceUserPhoneNumberRequestBody;
import com.clerk.backend_api.models.operations.ReplaceUserPhoneNumberResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        ReplaceUserPhoneNumberResponse res = sdk.phoneNumbers().replaceForUser()
                .userId("<id>")
                .requestBody(ReplaceUserPhoneNumberRequestBody.builder()
                    .phoneNumber("1-440-484-8878 x689")
                    .build())
                .call();

        if (res.phoneNumber().isPresent()) {
            System.out.println(res.phoneNumber().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                         | Type                                                                                              | Required                                                                                          | Description                                                                                       |
| ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- |
| `userId`                                                                                          | *String*                                                                                          | :heavy_check_mark:                                                                                | The ID of the user whose phone number to replace                                                  |
| `requestBody`                                                                                     | [ReplaceUserPhoneNumberRequestBody](../../models/operations/ReplaceUserPhoneNumberRequestBody.md) | :heavy_check_mark:                                                                                | N/A                                                                                               |

### Response

**[ReplaceUserPhoneNumberResponse](../../models/operations/ReplaceUserPhoneNumberResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404, 422   | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |