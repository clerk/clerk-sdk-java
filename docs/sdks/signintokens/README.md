# SignInTokens
(*signInTokens()*)

### Available Operations

* [create](#create) - Create sign-in token
* [revoke](#revoke) - Revoke the given sign-in token

## create

Creates a new sign-in token and associates it with the given user.
By default, sign-in tokens expire in 30 days.
You can optionally supply a different duration in seconds using the `expires_in_seconds` property.

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

            CreateSignInTokenRequestBody req = CreateSignInTokenRequestBody.builder()
                .build();

            CreateSignInTokenResponse res = sdk.signInTokens().create()
                .request(req)
                .call();

            if (res.signInToken().isPresent()) {
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

| Parameter                                                                                                                       | Type                                                                                                                            | Required                                                                                                                        | Description                                                                                                                     |
| ------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                                       | [com.clerk.backend_api.models.operations.CreateSignInTokenRequestBody](../../models/operations/CreateSignInTokenRequestBody.md) | :heavy_check_mark:                                                                                                              | The request object to use for the request.                                                                                      |


### Response

**[com.clerk.backend_api.models.operations.CreateSignInTokenResponse](../../models/operations/CreateSignInTokenResponse.md)**
### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 404,422                   | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |

## revoke

Revokes a pending sign-in token

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

            RevokeSignInTokenResponse res = sdk.signInTokens().revoke()
                .signInTokenId("<value>")
                .call();

            if (res.signInToken().isPresent()) {
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

| Parameter                                 | Type                                      | Required                                  | Description                               |
| ----------------------------------------- | ----------------------------------------- | ----------------------------------------- | ----------------------------------------- |
| `signInTokenId`                           | *String*                                  | :heavy_check_mark:                        | The ID of the sign-in token to be revoked |


### Response

**[com.clerk.backend_api.models.operations.RevokeSignInTokenResponse](../../models/operations/RevokeSignInTokenResponse.md)**
### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,404                   | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |
