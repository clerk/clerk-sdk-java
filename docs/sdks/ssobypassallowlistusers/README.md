# SsoBypassAllowlistUsers

## Overview

### Available Operations

* [list](#list) - List the SSO bypass allowlist
* [create](#create) - Add a user to the SSO bypass allowlist
* [delete](#delete) - Remove a user from the SSO bypass allowlist

## list

Returns the users who may verify an email code instead of reaching their identity provider when
enterprise SSO is unreachable.

### Example Usage

<!-- UsageSnippet language="java" operationID="ListSSOBypassAllowlistUsers" method="get" path="/sso_bypass_allowlist_users" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.ListSSOBypassAllowlistUsersResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        ListSSOBypassAllowlistUsersResponse res = sdk.ssoBypassAllowlistUsers().list()
                .call();

        if (res.ssoBypassAllowlistUsers().isPresent()) {
            System.out.println(res.ssoBypassAllowlistUsers().get());
        }
    }
}
```

### Parameters

| Parameter                                                         | Type                                                              | Required                                                          | Description                                                       |
| ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- |
| `enterpriseConnectionId`                                          | *Optional\<String>*                                               | :heavy_minus_sign:                                                | Restrict the list to the users this enterprise connection serves. |

### Response

**[ListSSOBypassAllowlistUsersResponse](../../models/operations/ListSSOBypassAllowlistUsersResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 403, 404                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## create

Puts a user on the allowlist. The request is rejected unless the user holds a verified email
address on a domain one of the instance's enterprise connections serves.

### Example Usage

<!-- UsageSnippet language="java" operationID="CreateSSOBypassAllowlistUser" method="post" path="/sso_bypass_allowlist_users" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CreateSSOBypassAllowlistUserRequestBody;
import com.clerk.backend_api.models.operations.CreateSSOBypassAllowlistUserResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        CreateSSOBypassAllowlistUserRequestBody req = CreateSSOBypassAllowlistUserRequestBody.builder()
                .userId("<id>")
                .build();

        CreateSSOBypassAllowlistUserResponse res = sdk.ssoBypassAllowlistUsers().create()
                .request(req)
                .call();

        if (res.ssoBypassAllowlistUser().isPresent()) {
            System.out.println(res.ssoBypassAllowlistUser().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                     | Type                                                                                                          | Required                                                                                                      | Description                                                                                                   |
| ------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                     | [CreateSSOBypassAllowlistUserRequestBody](../../models/operations/CreateSSOBypassAllowlistUserRequestBody.md) | :heavy_check_mark:                                                                                            | The request object to use for the request.                                                                    |

### Response

**[CreateSSOBypassAllowlistUserResponse](../../models/operations/CreateSSOBypassAllowlistUserResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 402, 403, 404, 422        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## delete

Removes the user from the allowlist, across every enterprise connection that serves them.

### Example Usage

<!-- UsageSnippet language="java" operationID="DeleteSSOBypassAllowlistUser" method="delete" path="/sso_bypass_allowlist_users/{userID}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.DeleteSSOBypassAllowlistUserResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        DeleteSSOBypassAllowlistUserResponse res = sdk.ssoBypassAllowlistUsers().delete()
                .userID("<id>")
                .call();

        if (res.deletedObject().isPresent()) {
            System.out.println(res.deletedObject().get());
        }
    }
}
```

### Parameters

| Parameter                      | Type                           | Required                       | Description                    |
| ------------------------------ | ------------------------------ | ------------------------------ | ------------------------------ |
| `userID`                       | *String*                       | :heavy_check_mark:             | The ID of the allowlisted user |

### Response

**[DeleteSSOBypassAllowlistUserResponse](../../models/operations/DeleteSSOBypassAllowlistUserResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 403, 404                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |