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
* [bulkBan](#bulkban) - Ban multiple users
* [bulkUnban](#bulkunban) - Unban multiple users
* [lock](#lock) - Lock a user
* [unlock](#unlock) - Unlock a user
* [setProfileImage](#setprofileimage) - Set user profile image
* [deleteProfileImage](#deleteprofileimage) - Delete user profile image
* [updateMetadata](#updatemetadata) - Merge and update a user's metadata
* [getBillingSubscription](#getbillingsubscription) - Retrieve a user's billing subscription
* [getOAuthAccessToken](#getoauthaccesstoken) - Retrieve the OAuth access token of a user
* [getOrganizationMemberships](#getorganizationmemberships) - Retrieve all memberships for a user
* [getOrganizationInvitations](#getorganizationinvitations) - Retrieve all invitations for a user
* [verifyPassword](#verifypassword) - Verify the password of a user
* [verifyTotp](#verifytotp) - Verify a TOTP or backup code for a user
* [disableMfa](#disablemfa) - Disable a user's MFA methods
* [deleteBackupCodes](#deletebackupcodes) - Disable all user's Backup codes
* [deletePasskey](#deletepasskey) - Delete a user passkey
* [deleteWeb3Wallet](#deleteweb3wallet) - Delete a user web3 wallet
* [deleteTOTP](#deletetotp) - Delete all the user's TOTPs
* [deleteExternalAccount](#deleteexternalaccount) - Delete External Account
* [getInstanceOrganizationMemberships](#getinstanceorganizationmemberships) - Get a list of all organization memberships within an instance.

## list

Returns a list of all users.
The users are returned sorted by creation date, with the newest users appearing first.

### Example Usage

<!-- UsageSnippet language="java" operationID="GetUserList" method="get" path="/users" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.GetUserListRequest;
import com.clerk.backend_api.models.operations.GetUserListResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        GetUserListRequest req = GetUserListRequest.builder()
                .lastActiveAtBefore(1700690400000L)
                .lastActiveAtAfter(1700690400000L)
                .lastActiveAtSince(1700690400000L)
                .createdAtBefore(1730160000000L)
                .createdAtAfter(1730160000000L)
                .build();

        GetUserListResponse res = sdk.users().list()
                .request(req)
                .call();

        if (res.userList().isPresent()) {
            // handle response
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

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 422             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## create

Creates a new user. Your user management settings determine how you should setup your user model.

Any email address and phone number created using this method will be marked as verified.

Note: If you are performing a migration, check out our guide on [zero downtime migrations](https://clerk.com/docs/deployments/migrate-overview).

The following rate limit rules apply to this endpoint: 1000 requests per 10 seconds for production instances and 100 requests per 10 seconds for development instances

### Example Usage

<!-- UsageSnippet language="java" operationID="CreateUser" method="post" path="/users" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CreateUserRequestBody;
import com.clerk.backend_api.models.operations.CreateUserResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        CreateUserRequestBody req = CreateUserRequestBody.builder()
                .build();

        CreateUserResponse res = sdk.users().create()
                .request(req)
                .call();

        if (res.user().isPresent()) {
            // handle response
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

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 422        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## count

Returns a total count of all users that match the given filtering criteria.

### Example Usage

<!-- UsageSnippet language="java" operationID="GetUsersCount" method="get" path="/users/count" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.GetUsersCountRequest;
import com.clerk.backend_api.models.operations.GetUsersCountResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        GetUsersCountRequest req = GetUsersCountRequest.builder()
                .lastActiveAtBefore(1700690400000L)
                .lastActiveAtAfter(1700690400000L)
                .lastActiveAtSince(1700690400000L)
                .createdAtBefore(1730160000000L)
                .createdAtAfter(1730160000000L)
                .build();

        GetUsersCountResponse res = sdk.users().count()
                .request(req)
                .call();

        if (res.totalCount().isPresent()) {
            // handle response
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

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 422                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## get

Retrieve the details of a user

### Example Usage

<!-- UsageSnippet language="java" operationID="GetUser" method="get" path="/users/{user_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.GetUserResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        GetUserResponse res = sdk.users().get()
                .userId("<id>")
                .call();

        if (res.user().isPresent()) {
            // handle response
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

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 404             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

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

<!-- UsageSnippet language="java" operationID="UpdateUser" method="patch" path="/users/{user_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UpdateUserRequestBody;
import com.clerk.backend_api.models.operations.UpdateUserResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        UpdateUserResponse res = sdk.users().update()
                .userId("<id>")
                .requestBody(UpdateUserRequestBody.builder()
                    .build())
                .call();

        if (res.user().isPresent()) {
            // handle response
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

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 404, 422        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## delete

Delete the specified user

### Example Usage

<!-- UsageSnippet language="java" operationID="DeleteUser" method="delete" path="/users/{user_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.DeleteUserResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        DeleteUserResponse res = sdk.users().delete()
                .userId("<id>")
                .call();

        if (res.deletedObject().isPresent()) {
            // handle response
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

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 404             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## ban

Marks the given user as banned, which means that all their sessions are revoked and they are not allowed to sign in again.

### Example Usage

<!-- UsageSnippet language="java" operationID="BanUser" method="post" path="/users/{user_id}/ban" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.BanUserResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        BanUserResponse res = sdk.users().ban()
                .userId("<id>")
                .call();

        if (res.user().isPresent()) {
            // handle response
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

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 402                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## unban

Removes the ban mark from the given user.

### Example Usage

<!-- UsageSnippet language="java" operationID="UnbanUser" method="post" path="/users/{user_id}/unban" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UnbanUserResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        UnbanUserResponse res = sdk.users().unban()
                .userId("<id>")
                .call();

        if (res.user().isPresent()) {
            // handle response
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

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 402                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## bulkBan

Marks multiple users as banned, which means that all their sessions are revoked and they are not allowed to sign in again.

### Example Usage

<!-- UsageSnippet language="java" operationID="UsersBan" method="post" path="/users/ban" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UsersBanRequestBody;
import com.clerk.backend_api.models.operations.UsersBanResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        UsersBanRequestBody req = UsersBanRequestBody.builder()
                .userIds(List.of(
                    "<value 1>",
                    "<value 2>",
                    "<value 3>"))
                .build();

        UsersBanResponse res = sdk.users().bulkBan()
                .request(req)
                .call();

        if (res.userList().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                             | Type                                                                  | Required                                                              | Description                                                           |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| `request`                                                             | [UsersBanRequestBody](../../models/operations/UsersBanRequestBody.md) | :heavy_check_mark:                                                    | The request object to use for the request.                            |

### Response

**[UsersBanResponse](../../models/operations/UsersBanResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 402                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## bulkUnban

Removes the ban mark from multiple users.

### Example Usage

<!-- UsageSnippet language="java" operationID="UsersUnban" method="post" path="/users/unban" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UsersUnbanRequestBody;
import com.clerk.backend_api.models.operations.UsersUnbanResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        UsersUnbanRequestBody req = UsersUnbanRequestBody.builder()
                .userIds(List.of(
                    "<value 1>",
                    "<value 2>",
                    "<value 3>"))
                .build();

        UsersUnbanResponse res = sdk.users().bulkUnban()
                .request(req)
                .call();

        if (res.userList().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                 | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `request`                                                                 | [UsersUnbanRequestBody](../../models/operations/UsersUnbanRequestBody.md) | :heavy_check_mark:                                                        | The request object to use for the request.                                |

### Response

**[UsersUnbanResponse](../../models/operations/UsersUnbanResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 402                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## lock

Marks the given user as locked, which means they are not allowed to sign in again until the lock expires.
Lock duration can be configured in the instance's restrictions settings.

### Example Usage

<!-- UsageSnippet language="java" operationID="LockUser" method="post" path="/users/{user_id}/lock" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.LockUserResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        LockUserResponse res = sdk.users().lock()
                .userId("<id>")
                .call();

        if (res.user().isPresent()) {
            // handle response
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

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 403                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## unlock

Removes the lock from the given user.

### Example Usage

<!-- UsageSnippet language="java" operationID="UnlockUser" method="post" path="/users/{user_id}/unlock" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UnlockUserResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        UnlockUserResponse res = sdk.users().unlock()
                .userId("<id>")
                .call();

        if (res.user().isPresent()) {
            // handle response
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

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 403                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## setProfileImage

Update a user's profile image

### Example Usage

<!-- UsageSnippet language="java" operationID="SetUserProfileImage" method="post" path="/users/{user_id}/profile_image" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.SetUserProfileImageRequestBody;
import com.clerk.backend_api.models.operations.SetUserProfileImageResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        SetUserProfileImageResponse res = sdk.users().setProfileImage()
                .userId("<id>")
                .requestBody(SetUserProfileImageRequestBody.builder()
                    .build())
                .call();

        if (res.user().isPresent()) {
            // handle response
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

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 404             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## deleteProfileImage

Delete a user's profile image

### Example Usage

<!-- UsageSnippet language="java" operationID="DeleteUserProfileImage" method="delete" path="/users/{user_id}/profile_image" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.DeleteUserProfileImageResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        DeleteUserProfileImageResponse res = sdk.users().deleteProfileImage()
                .userId("<id>")
                .call();

        if (res.user().isPresent()) {
            // handle response
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

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 404                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## updateMetadata

Update a user's metadata attributes by merging existing values with the provided parameters.

This endpoint behaves differently than the *Update a user* endpoint.
Metadata values will not be replaced entirely.
Instead, a deep merge will be performed.
Deep means that any nested JSON objects will be merged as well.

You can remove metadata keys at any level by setting their value to `null`.

### Example Usage

<!-- UsageSnippet language="java" operationID="UpdateUserMetadata" method="patch" path="/users/{user_id}/metadata" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UpdateUserMetadataResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        UpdateUserMetadataResponse res = sdk.users().updateMetadata()
                .userId("<id>")
                .call();

        if (res.user().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                            | Type                                                                                                 | Required                                                                                             | Description                                                                                          |
| ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- |
| `userId`                                                                                             | *String*                                                                                             | :heavy_check_mark:                                                                                   | The ID of the user whose metadata will be updated and merged                                         |
| `requestBody`                                                                                        | [Optional\<UpdateUserMetadataRequestBody>](../../models/operations/UpdateUserMetadataRequestBody.md) | :heavy_minus_sign:                                                                                   | N/A                                                                                                  |

### Response

**[UpdateUserMetadataResponse](../../models/operations/UpdateUserMetadataResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 404, 422        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## getBillingSubscription

Retrieves the billing subscription for the specified user.
This includes subscription details, active plans, billing information, and payment status.
The subscription contains subscription items which represent the individual plans the user is subscribed to.

### Example Usage

<!-- UsageSnippet language="java" operationID="GetUserBillingSubscription" method="get" path="/users/{user_id}/billing/subscription" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.GetUserBillingSubscriptionResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        GetUserBillingSubscriptionResponse res = sdk.users().getBillingSubscription()
                .userId("<id>")
                .call();

        if (res.commerceSubscription().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                         | Type                                              | Required                                          | Description                                       |
| ------------------------------------------------- | ------------------------------------------------- | ------------------------------------------------- | ------------------------------------------------- |
| `userId`                                          | *String*                                          | :heavy_check_mark:                                | The ID of the user whose subscription to retrieve |

### Response

**[GetUserBillingSubscriptionResponse](../../models/operations/GetUserBillingSubscriptionResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404, 422   | application/json          |
| models/errors/ClerkErrors | 500                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## getOAuthAccessToken

Fetch the corresponding OAuth access token for a user that has previously authenticated with a particular OAuth provider.
For OAuth 2.0, if the access token has expired and we have a corresponding refresh token, the access token will be refreshed transparently the new one will be returned.

### Example Usage

<!-- UsageSnippet language="java" operationID="GetOAuthAccessToken" method="get" path="/users/{user_id}/oauth_access_tokens/{provider}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.GetOAuthAccessTokenRequest;
import com.clerk.backend_api.models.operations.GetOAuthAccessTokenResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        GetOAuthAccessTokenRequest req = GetOAuthAccessTokenRequest.builder()
                .userId("<id>")
                .provider("<value>")
                .build();

        GetOAuthAccessTokenResponse res = sdk.users().getOAuthAccessToken()
                .request(req)
                .call();

        if (res.oAuthAccessToken().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                           | Type                                                                                | Required                                                                            | Description                                                                         |
| ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- |
| `request`                                                                           | [GetOAuthAccessTokenRequest](../../models/operations/GetOAuthAccessTokenRequest.md) | :heavy_check_mark:                                                                  | The request object to use for the request.                                          |

### Response

**[GetOAuthAccessTokenResponse](../../models/operations/GetOAuthAccessTokenResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 404, 422             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## getOrganizationMemberships

Retrieve a paginated list of the user's organization memberships

### Example Usage

<!-- UsageSnippet language="java" operationID="UsersGetOrganizationMemberships" method="get" path="/users/{user_id}/organization_memberships" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UsersGetOrganizationMembershipsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        UsersGetOrganizationMembershipsResponse res = sdk.users().getOrganizationMemberships()
                .userId("<id>")
                .limit(10L)
                .offset(0L)
                .call();

        if (res.organizationMemberships().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                 | Type                                                                                                                                      | Required                                                                                                                                  | Description                                                                                                                               |
| ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- |
| `userId`                                                                                                                                  | *String*                                                                                                                                  | :heavy_check_mark:                                                                                                                        | The ID of the user whose organization memberships we want to retrieve                                                                     |
| `limit`                                                                                                                                   | *Optional\<Long>*                                                                                                                         | :heavy_minus_sign:                                                                                                                        | Applies a limit to the number of results returned.<br/>Can be used for paginating the results together with `offset`.                     |
| `offset`                                                                                                                                  | *Optional\<Long>*                                                                                                                         | :heavy_minus_sign:                                                                                                                        | Skip the first `offset` results when paginating.<br/>Needs to be an integer greater or equal to zero.<br/>To be used in conjunction with `limit`. |

### Response

**[UsersGetOrganizationMembershipsResponse](../../models/operations/UsersGetOrganizationMembershipsResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 403                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## getOrganizationInvitations

Retrieve a paginated list of the user's organization invitations

### Example Usage

<!-- UsageSnippet language="java" operationID="UsersGetOrganizationInvitations" method="get" path="/users/{user_id}/organization_invitations" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UsersGetOrganizationInvitationsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        UsersGetOrganizationInvitationsResponse res = sdk.users().getOrganizationInvitations()
                .userId("<id>")
                .limit(10L)
                .offset(0L)
                .call();

        if (res.organizationInvitationsWithPublicOrganizationData().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                 | Type                                                                                                                                      | Required                                                                                                                                  | Description                                                                                                                               |
| ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- |
| `userId`                                                                                                                                  | *String*                                                                                                                                  | :heavy_check_mark:                                                                                                                        | The ID of the user whose organization invitations we want to retrieve                                                                     |
| `limit`                                                                                                                                   | *Optional\<Long>*                                                                                                                         | :heavy_minus_sign:                                                                                                                        | Applies a limit to the number of results returned.<br/>Can be used for paginating the results together with `offset`.                     |
| `offset`                                                                                                                                  | *Optional\<Long>*                                                                                                                         | :heavy_minus_sign:                                                                                                                        | Skip the first `offset` results when paginating.<br/>Needs to be an integer greater or equal to zero.<br/>To be used in conjunction with `limit`. |
| `status`                                                                                                                                  | [Optional\<QueryParamStatus>](../../models/operations/QueryParamStatus.md)                                                                | :heavy_minus_sign:                                                                                                                        | Filter organization invitations based on their status                                                                                     |

### Response

**[UsersGetOrganizationInvitationsResponse](../../models/operations/UsersGetOrganizationInvitationsResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 403, 404             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## verifyPassword

Check that the user's password matches the supplied input.
Useful for custom auth flows and re-verification.

### Example Usage

<!-- UsageSnippet language="java" operationID="VerifyPassword" method="post" path="/users/{user_id}/verify_password" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.VerifyPasswordResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        VerifyPasswordResponse res = sdk.users().verifyPassword()
                .userId("<id>")
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                    | Type                                                                                         | Required                                                                                     | Description                                                                                  |
| -------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------- |
| `userId`                                                                                     | *String*                                                                                     | :heavy_check_mark:                                                                           | The ID of the user for whom to verify the password                                           |
| `requestBody`                                                                                | [Optional\<VerifyPasswordRequestBody>](../../models/operations/VerifyPasswordRequestBody.md) | :heavy_minus_sign:                                                                           | N/A                                                                                          |

### Response

**[VerifyPasswordResponse](../../models/operations/VerifyPasswordResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 500                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## verifyTotp

Verify that the provided TOTP or backup code is valid for the user.
Verifying a backup code will result it in being consumed (i.e. it will
become invalid).
Useful for custom auth flows and re-verification.

### Example Usage

<!-- UsageSnippet language="java" operationID="VerifyTOTP" method="post" path="/users/{user_id}/verify_totp" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.VerifyTOTPResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        VerifyTOTPResponse res = sdk.users().verifyTotp()
                .userId("<id>")
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                            | Type                                                                                 | Required                                                                             | Description                                                                          |
| ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ |
| `userId`                                                                             | *String*                                                                             | :heavy_check_mark:                                                                   | The ID of the user for whom to verify the TOTP                                       |
| `requestBody`                                                                        | [Optional\<VerifyTOTPRequestBody>](../../models/operations/VerifyTOTPRequestBody.md) | :heavy_minus_sign:                                                                   | N/A                                                                                  |

### Response

**[VerifyTOTPResponse](../../models/operations/VerifyTOTPResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 500                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## disableMfa

Disable all of a user's MFA methods (e.g. OTP sent via SMS, TOTP on their authenticator app) at once.

### Example Usage

<!-- UsageSnippet language="java" operationID="DisableMFA" method="delete" path="/users/{user_id}/mfa" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.DisableMFAResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        DisableMFAResponse res = sdk.users().disableMfa()
                .userId("<id>")
                .call();

        if (res.object().isPresent()) {
            // handle response
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

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 404                       | application/json          |
| models/errors/ClerkErrors | 500                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## deleteBackupCodes

Disable all of a user's backup codes.

### Example Usage

<!-- UsageSnippet language="java" operationID="DeleteBackupCode" method="delete" path="/users/{user_id}/backup_code" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.DeleteBackupCodeResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        DeleteBackupCodeResponse res = sdk.users().deleteBackupCodes()
                .userId("<id>")
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                | Type                                                     | Required                                                 | Description                                              |
| -------------------------------------------------------- | -------------------------------------------------------- | -------------------------------------------------------- | -------------------------------------------------------- |
| `userId`                                                 | *String*                                                 | :heavy_check_mark:                                       | The ID of the user whose backup codes are to be deleted. |

### Response

**[DeleteBackupCodeResponse](../../models/operations/DeleteBackupCodeResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 404                       | application/json          |
| models/errors/ClerkErrors | 500                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## deletePasskey

Delete the passkey identification for a given user and notify them through email.

### Example Usage

<!-- UsageSnippet language="java" operationID="UserPasskeyDelete" method="delete" path="/users/{user_id}/passkeys/{passkey_identification_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UserPasskeyDeleteResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        UserPasskeyDeleteResponse res = sdk.users().deletePasskey()
                .userId("<id>")
                .passkeyIdentificationId("<id>")
                .call();

        if (res.deletedObject().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                         | Type                                              | Required                                          | Description                                       |
| ------------------------------------------------- | ------------------------------------------------- | ------------------------------------------------- | ------------------------------------------------- |
| `userId`                                          | *String*                                          | :heavy_check_mark:                                | The ID of the user that owns the passkey identity |
| `passkeyIdentificationId`                         | *String*                                          | :heavy_check_mark:                                | The ID of the passkey identity to be deleted      |

### Response

**[UserPasskeyDeleteResponse](../../models/operations/UserPasskeyDeleteResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 403, 404                  | application/json          |
| models/errors/ClerkErrors | 500                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## deleteWeb3Wallet

Delete the web3 wallet identification for a given user.

### Example Usage

<!-- UsageSnippet language="java" operationID="UserWeb3WalletDelete" method="delete" path="/users/{user_id}/web3_wallets/{web3_wallet_identification_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UserWeb3WalletDeleteResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        UserWeb3WalletDeleteResponse res = sdk.users().deleteWeb3Wallet()
                .userId("<id>")
                .web3WalletIdentificationId("<id>")
                .call();

        if (res.deletedObject().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                        | Type                                             | Required                                         | Description                                      |
| ------------------------------------------------ | ------------------------------------------------ | ------------------------------------------------ | ------------------------------------------------ |
| `userId`                                         | *String*                                         | :heavy_check_mark:                               | The ID of the user that owns the web3 wallet     |
| `web3WalletIdentificationId`                     | *String*                                         | :heavy_check_mark:                               | The ID of the web3 wallet identity to be deleted |

### Response

**[UserWeb3WalletDeleteResponse](../../models/operations/UserWeb3WalletDeleteResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 403, 404             | application/json          |
| models/errors/ClerkErrors | 500                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## deleteTOTP

Deletes all of the user's TOTPs.

### Example Usage

<!-- UsageSnippet language="java" operationID="DeleteTOTP" method="delete" path="/users/{user_id}/totp" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.DeleteTOTPResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        DeleteTOTPResponse res = sdk.users().deleteTOTP()
                .userId("<id>")
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                        | Type                                             | Required                                         | Description                                      |
| ------------------------------------------------ | ------------------------------------------------ | ------------------------------------------------ | ------------------------------------------------ |
| `userId`                                         | *String*                                         | :heavy_check_mark:                               | The ID of the user whose TOTPs are to be deleted |

### Response

**[DeleteTOTPResponse](../../models/operations/DeleteTOTPResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 404                       | application/json          |
| models/errors/ClerkErrors | 500                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## deleteExternalAccount

Delete an external account by ID.

### Example Usage

<!-- UsageSnippet language="java" operationID="DeleteExternalAccount" method="delete" path="/users/{user_id}/external_accounts/{external_account_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.DeleteExternalAccountResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        DeleteExternalAccountResponse res = sdk.users().deleteExternalAccount()
                .userId("<id>")
                .externalAccountId("<id>")
                .call();

        if (res.deletedObject().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                | Type                                     | Required                                 | Description                              |
| ---------------------------------------- | ---------------------------------------- | ---------------------------------------- | ---------------------------------------- |
| `userId`                                 | *String*                                 | :heavy_check_mark:                       | The ID of the user's external account    |
| `externalAccountId`                      | *String*                                 | :heavy_check_mark:                       | The ID of the external account to delete |

### Response

**[DeleteExternalAccountResponse](../../models/operations/DeleteExternalAccountResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 403, 404             | application/json          |
| models/errors/ClerkErrors | 500                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## getInstanceOrganizationMemberships

Retrieves all organization user memberships for the given instance.

### Example Usage

<!-- UsageSnippet language="java" operationID="InstanceGetOrganizationMemberships" method="get" path="/organization_memberships" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.InstanceGetOrganizationMembershipsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        InstanceGetOrganizationMembershipsResponse res = sdk.users().getInstanceOrganizationMemberships()
                .limit(10L)
                .offset(0L)
                .call();

        if (res.organizationMemberships().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                          | Type                                                                                                                                                                                                                               | Required                                                                                                                                                                                                                           | Description                                                                                                                                                                                                                        |
| ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `orderBy`                                                                                                                                                                                                                          | *Optional\<String>*                                                                                                                                                                                                                | :heavy_minus_sign:                                                                                                                                                                                                                 | Sorts organizations memberships by phone_number, email_address, created_at, first_name, last_name or username.<br/>By prepending one of those values with + or -,<br/>we can choose to sort in ascending (ASC) or descending (DESC) order. |
| `limit`                                                                                                                                                                                                                            | *Optional\<Long>*                                                                                                                                                                                                                  | :heavy_minus_sign:                                                                                                                                                                                                                 | Applies a limit to the number of results returned.<br/>Can be used for paginating the results together with `offset`.                                                                                                              |
| `offset`                                                                                                                                                                                                                           | *Optional\<Long>*                                                                                                                                                                                                                  | :heavy_minus_sign:                                                                                                                                                                                                                 | Skip the first `offset` results when paginating.<br/>Needs to be an integer greater or equal to zero.<br/>To be used in conjunction with `limit`.                                                                                  |

### Response

**[InstanceGetOrganizationMembershipsResponse](../../models/operations/InstanceGetOrganizationMembershipsResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 422             | application/json          |
| models/errors/ClerkErrors | 500                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |