# Users
(*users()*)

## Overview

### Available Operations

* [list](#list) - List all users
* [create](#create) - Create a new user
* [count](#count) - Count users
* [get](#get) - Retrieve a user
* [update](#update) - Update a user
* [delete](#delete) - Delete a user
* [ban](#ban) - Ban a user
* [unban](#unban) - Unban a user
* [lock](#lock) - Lock a user
* [unlock](#unlock) - Unlock a user
* [setProfileImage](#setprofileimage) - Set user profile image
* [deleteProfileImage](#deleteprofileimage) - Delete user profile image
* [updateMetadata](#updatemetadata) - Merge and update a user's metadata
* [getOAuthAccessToken](#getoauthaccesstoken) - Retrieve the OAuth access token of a user
* [getOrganizationMemberships](#getorganizationmemberships) - Retrieve all memberships for a user
* [verifyPassword](#verifypassword) - Verify the password of a user
* [verifyTOTP](#verifytotp) - Verify a TOTP or backup code for a user
* [disableMFA](#disablemfa) - Disable a user's MFA methods

## list

Returns a list of all users.
The users are returned sorted by creation date, with the newest users appearing first.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.GetUserListRequest;
import com.clerk.backend_api.models.operations.GetUserListResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            GetUserListRequest req = GetUserListRequest.builder()
                .lastActiveAtSince(1700690400000L)
                .build();

            GetUserListResponse res = sdk.users().list()
                .request(req)
                .call();

            if (res.userList().isPresent()) {
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

| Parameter                                                           | Type                                                                | Required                                                            | Description                                                         |
| ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- |
| `request`                                                           | [GetUserListRequest](../../models/operations/GetUserListRequest.md) | :heavy_check_mark:                                                  | The request object to use for the request.                          |

### Response

**[GetUserListResponse](../../models/operations/GetUserListResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,401,422               | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## create

Creates a new user. Your user management settings determine how you should setup your user model.

Any email address and phone number created using this method will be marked as verified.

Note: If you are performing a migration, check out our guide on [zero downtime migrations](https://clerk.com/docs/deployments/migrate-overview).

A rate limit rule of 20 requests per 10 seconds is applied to this endpoint.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.CreateUserRequestBody;
import com.clerk.backend_api.models.operations.CreateUserResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            CreateUserRequestBody req = CreateUserRequestBody.builder()
                .build();

            CreateUserResponse res = sdk.users().create()
                .request(req)
                .call();

            if (res.user().isPresent()) {
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

| Parameter                                                                 | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `request`                                                                 | [CreateUserRequestBody](../../models/operations/CreateUserRequestBody.md) | :heavy_check_mark:                                                        | The request object to use for the request.                                |

### Response

**[CreateUserResponse](../../models/operations/CreateUserResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,401,403,422           | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## count

Returns a total count of all users that match the given filtering criteria.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.GetUsersCountRequest;
import com.clerk.backend_api.models.operations.GetUsersCountResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            GetUsersCountRequest req = GetUsersCountRequest.builder()
                .build();

            GetUsersCountResponse res = sdk.users().count()
                .request(req)
                .call();

            if (res.totalCount().isPresent()) {
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

| Parameter                                                               | Type                                                                    | Required                                                                | Description                                                             |
| ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- |
| `request`                                                               | [GetUsersCountRequest](../../models/operations/GetUsersCountRequest.md) | :heavy_check_mark:                                                      | The request object to use for the request.                              |

### Response

**[GetUsersCountResponse](../../models/operations/GetUsersCountResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 422                       | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## get

Retrieve the details of a user

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.GetUserResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            GetUserResponse res = sdk.users().get()
                .userId("<value>")
                .call();

            if (res.user().isPresent()) {
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

| Parameter                      | Type                           | Required                       | Description                    |
| ------------------------------ | ------------------------------ | ------------------------------ | ------------------------------ |
| `userId`                       | *String*                       | :heavy_check_mark:             | The ID of the user to retrieve |

### Response

**[GetUserResponse](../../models/operations/GetUserResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,401,404               | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## update

Update a user's attributes.

You can set the user's primary contact identifiers (email address and phone numbers) by updating the `primary_email_address_id` and `primary_phone_number_id` attributes respectively.
Both IDs should correspond to verified identifications that belong to the user.

You can remove a user's username by setting the username attribute to null or the blank string "".
This is a destructive action; the identification will be deleted forever.
Usernames can be removed only if they are optional in your instance settings and there's at least one other identifier which can be used for authentication.

This endpoint allows changing a user's password. When passing the `password` parameter directly you have two further options.
You can ignore the password policy checks for your instance by setting the `skip_password_checks` parameter to `true`.
You can also choose to sign the user out of all their active sessions on any device once the password is updated. Just set `sign_out_of_other_sessions` to `true`.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.UpdateUserRequestBody;
import com.clerk.backend_api.models.operations.UpdateUserResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            UpdateUserResponse res = sdk.users().update()
                .userId("<value>")
                .requestBody(UpdateUserRequestBody.builder()
                    .build())
                .call();

            if (res.user().isPresent()) {
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

| Parameter                                                                 | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `userId`                                                                  | *String*                                                                  | :heavy_check_mark:                                                        | The ID of the user to update                                              |
| `requestBody`                                                             | [UpdateUserRequestBody](../../models/operations/UpdateUserRequestBody.md) | :heavy_check_mark:                                                        | N/A                                                                       |

### Response

**[UpdateUserResponse](../../models/operations/UpdateUserResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,401,404,422           | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## delete

Delete the specified user

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.DeleteUserResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            DeleteUserResponse res = sdk.users().delete()
                .userId("<value>")
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

| Parameter                    | Type                         | Required                     | Description                  |
| ---------------------------- | ---------------------------- | ---------------------------- | ---------------------------- |
| `userId`                     | *String*                     | :heavy_check_mark:           | The ID of the user to delete |

### Response

**[DeleteUserResponse](../../models/operations/DeleteUserResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,401,404               | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## ban

Marks the given user as banned, which means that all their sessions are revoked and they are not allowed to sign in again.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.BanUserResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            BanUserResponse res = sdk.users().ban()
                .userId("<value>")
                .call();

            if (res.user().isPresent()) {
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

| Parameter                 | Type                      | Required                  | Description               |
| ------------------------- | ------------------------- | ------------------------- | ------------------------- |
| `userId`                  | *String*                  | :heavy_check_mark:        | The ID of the user to ban |

### Response

**[BanUserResponse](../../models/operations/BanUserResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 402                       | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## unban

Removes the ban mark from the given user.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.UnbanUserResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            UnbanUserResponse res = sdk.users().unban()
                .userId("<value>")
                .call();

            if (res.user().isPresent()) {
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

| Parameter                   | Type                        | Required                    | Description                 |
| --------------------------- | --------------------------- | --------------------------- | --------------------------- |
| `userId`                    | *String*                    | :heavy_check_mark:          | The ID of the user to unban |

### Response

**[UnbanUserResponse](../../models/operations/UnbanUserResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 402                       | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## lock

Marks the given user as locked, which means they are not allowed to sign in again until the lock expires.
Lock duration can be configured in the instance's restrictions settings.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.LockUserResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            LockUserResponse res = sdk.users().lock()
                .userId("<value>")
                .call();

            if (res.user().isPresent()) {
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
| `userId`                   | *String*                   | :heavy_check_mark:         | The ID of the user to lock |

### Response

**[LockUserResponse](../../models/operations/LockUserResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 403                       | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## unlock

Removes the lock from the given user.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.UnlockUserResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            UnlockUserResponse res = sdk.users().unlock()
                .userId("<value>")
                .call();

            if (res.user().isPresent()) {
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

| Parameter                    | Type                         | Required                     | Description                  |
| ---------------------------- | ---------------------------- | ---------------------------- | ---------------------------- |
| `userId`                     | *String*                     | :heavy_check_mark:           | The ID of the user to unlock |

### Response

**[UnlockUserResponse](../../models/operations/UnlockUserResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 403                       | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## setProfileImage

Update a user's profile image

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.SetUserProfileImageRequestBody;
import com.clerk.backend_api.models.operations.SetUserProfileImageResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            SetUserProfileImageResponse res = sdk.users().setProfileImage()
                .userId("<value>")
                .requestBody(SetUserProfileImageRequestBody.builder()
                    .build())
                .call();

            if (res.user().isPresent()) {
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

| Parameter                                                                                   | Type                                                                                        | Required                                                                                    | Description                                                                                 |
| ------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------- |
| `userId`                                                                                    | *String*                                                                                    | :heavy_check_mark:                                                                          | The ID of the user to update the profile image for                                          |
| `requestBody`                                                                               | [SetUserProfileImageRequestBody](../../models/operations/SetUserProfileImageRequestBody.md) | :heavy_check_mark:                                                                          | N/A                                                                                         |

### Response

**[SetUserProfileImageResponse](../../models/operations/SetUserProfileImageResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,401,404               | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## deleteProfileImage

Delete a user's profile image

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.DeleteUserProfileImageResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            DeleteUserProfileImageResponse res = sdk.users().deleteProfileImage()
                .userId("<value>")
                .call();

            if (res.user().isPresent()) {
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

| Parameter                                          | Type                                               | Required                                           | Description                                        |
| -------------------------------------------------- | -------------------------------------------------- | -------------------------------------------------- | -------------------------------------------------- |
| `userId`                                           | *String*                                           | :heavy_check_mark:                                 | The ID of the user to delete the profile image for |

### Response

**[DeleteUserProfileImageResponse](../../models/operations/DeleteUserProfileImageResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 404                       | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## updateMetadata

Update a user's metadata attributes by merging existing values with the provided parameters.

This endpoint behaves differently than the *Update a user* endpoint.
Metadata values will not be replaced entirely.
Instead, a deep merge will be performed.
Deep means that any nested JSON objects will be merged as well.

You can remove metadata keys at any level by setting their value to `null`.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.UpdateUserMetadataRequestBody;
import com.clerk.backend_api.models.operations.UpdateUserMetadataResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            UpdateUserMetadataResponse res = sdk.users().updateMetadata()
                .userId("<value>")
                .requestBody(UpdateUserMetadataRequestBody.builder()
                    .build())
                .call();

            if (res.user().isPresent()) {
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

| Parameter                                                                                           | Type                                                                                                | Required                                                                                            | Description                                                                                         |
| --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- |
| `userId`                                                                                            | *String*                                                                                            | :heavy_check_mark:                                                                                  | The ID of the user whose metadata will be updated and merged                                        |
| `requestBody`                                                                                       | [Optional<UpdateUserMetadataRequestBody>](../../models/operations/UpdateUserMetadataRequestBody.md) | :heavy_minus_sign:                                                                                  | N/A                                                                                                 |

### Response

**[UpdateUserMetadataResponse](../../models/operations/UpdateUserMetadataResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,401,404,422           | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## getOAuthAccessToken

Fetch the corresponding OAuth access token for a user that has previously authenticated with a particular OAuth provider.
For OAuth 2.0, if the access token has expired and we have a corresponding refresh token, the access token will be refreshed transparently the new one will be returned.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.GetOAuthAccessTokenResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            GetOAuthAccessTokenResponse res = sdk.users().getOAuthAccessToken()
                .userId("<value>")
                .provider("<value>")
                .call();

            if (res.responseBodies().isPresent()) {
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

| Parameter                                                       | Type                                                            | Required                                                        | Description                                                     |
| --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- |
| `userId`                                                        | *String*                                                        | :heavy_check_mark:                                              | The ID of the user for which to retrieve the OAuth access token |
| `provider`                                                      | *String*                                                        | :heavy_check_mark:                                              | The ID of the OAuth provider (e.g. `oauth_google`)              |

### Response

**[GetOAuthAccessTokenResponse](../../models/operations/GetOAuthAccessTokenResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 422                       | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## getOrganizationMemberships

Retrieve a paginated list of the user's organization memberships

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

            sdk.users().getOrganizationMemberships()
                .userId("<value>")
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
| `userId`                                                                                                                                  | *String*                                                                                                                                  | :heavy_check_mark:                                                                                                                        | The ID of the user whose organization memberships we want to retrieve                                                                     |
| `limit`                                                                                                                                   | *Optional<Long>*                                                                                                                          | :heavy_minus_sign:                                                                                                                        | Applies a limit to the number of results returned.<br/>Can be used for paginating the results together with `offset`.                     |
| `offset`                                                                                                                                  | *Optional<Long>*                                                                                                                          | :heavy_minus_sign:                                                                                                                        | Skip the first `offset` results when paginating.<br/>Needs to be an integer greater or equal to zero.<br/>To be used in conjunction with `limit`. |

### Response

**[UsersGetOrganizationMembershipsResponse](../../models/operations/UsersGetOrganizationMembershipsResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 403                       | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## verifyPassword

Check that the user's password matches the supplied input.
Useful for custom auth flows and re-verification.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.VerifyPasswordRequestBody;
import com.clerk.backend_api.models.operations.VerifyPasswordResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            VerifyPasswordResponse res = sdk.users().verifyPassword()
                .userId("<value>")
                .requestBody(VerifyPasswordRequestBody.builder()
                    .password("<value>")
                    .build())
                .call();

            if (res.object().isPresent()) {
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

| Parameter                                                                                   | Type                                                                                        | Required                                                                                    | Description                                                                                 |
| ------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------- |
| `userId`                                                                                    | *String*                                                                                    | :heavy_check_mark:                                                                          | The ID of the user for whom to verify the password                                          |
| `requestBody`                                                                               | [Optional<VerifyPasswordRequestBody>](../../models/operations/VerifyPasswordRequestBody.md) | :heavy_minus_sign:                                                                          | N/A                                                                                         |

### Response

**[VerifyPasswordResponse](../../models/operations/VerifyPasswordResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 500                       | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## verifyTOTP

Verify that the provided TOTP or backup code is valid for the user.
Verifying a backup code will result it in being consumed (i.e. it will
become invalid).
Useful for custom auth flows and re-verification.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.VerifyTOTPRequestBody;
import com.clerk.backend_api.models.operations.VerifyTOTPResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            VerifyTOTPResponse res = sdk.users().verifyTOTP()
                .userId("<value>")
                .requestBody(VerifyTOTPRequestBody.builder()
                    .code("<value>")
                    .build())
                .call();

            if (res.object().isPresent()) {
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

| Parameter                                                                           | Type                                                                                | Required                                                                            | Description                                                                         |
| ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- |
| `userId`                                                                            | *String*                                                                            | :heavy_check_mark:                                                                  | The ID of the user for whom to verify the TOTP                                      |
| `requestBody`                                                                       | [Optional<VerifyTOTPRequestBody>](../../models/operations/VerifyTOTPRequestBody.md) | :heavy_minus_sign:                                                                  | N/A                                                                                 |

### Response

**[VerifyTOTPResponse](../../models/operations/VerifyTOTPResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 500                       | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## disableMFA

Disable all of a user's MFA methods (e.g. OTP sent via SMS, TOTP on their authenticator app) at once.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.DisableMFAResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            DisableMFAResponse res = sdk.users().disableMFA()
                .userId("<value>")
                .call();

            if (res.object().isPresent()) {
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

| Parameter                                               | Type                                                    | Required                                                | Description                                             |
| ------------------------------------------------------- | ------------------------------------------------------- | ------------------------------------------------------- | ------------------------------------------------------- |
| `userId`                                                | *String*                                                | :heavy_check_mark:                                      | The ID of the user whose MFA methods are to be disabled |

### Response

**[DisableMFAResponse](../../models/operations/DisableMFAResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 404,500                   | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |
