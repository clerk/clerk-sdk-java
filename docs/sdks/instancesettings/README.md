# InstanceSettings

## Overview

Modify the settings of your instance.

### Available Operations

* [get](#get) - Fetch the current instance
* [update](#update) - Update instance settings
* [updateRestrictions](#updaterestrictions) - Update instance restrictions
* [getCommunication](#getcommunication) - Get instance communication settings
* [updateCommunication](#updatecommunication) - Update instance communication settings
* [getOAuthApplicationSettings](#getoauthapplicationsettings) - Get OAuth application settings
* [updateOAuthApplicationSettings](#updateoauthapplicationsettings) - Update OAuth application settings
* [changeDomain](#changedomain) - Update production instance domain
* [getOrganizationSettings](#getorganizationsettings) - Get instance organization settings
* [updateOrganizationSettings](#updateorganizationsettings) - Update instance organization settings
* [getInstanceProtect](#getinstanceprotect) - Get instance protect settings
* [updateInstanceProtect](#updateinstanceprotect) - Update instance protect settings

## get

Fetches the current instance

### Example Usage

<!-- UsageSnippet language="java" operationID="GetInstance" method="get" path="/instance" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.operations.GetInstanceResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        GetInstanceResponse res = sdk.instanceSettings().get()
                .call();

        if (res.instance().isPresent()) {
            System.out.println(res.instance().get());
        }
    }
}
```

### Response

**[GetInstanceResponse](../../models/operations/GetInstanceResponse.md)**

### Errors

| Error Type             | Status Code            | Content Type           |
| ---------------------- | ---------------------- | ---------------------- |
| models/errors/SDKError | 4XX, 5XX               | \*/\*                  |

## update

Updates the settings of an instance

### Example Usage

<!-- UsageSnippet language="java" operationID="UpdateInstance" method="patch" path="/instance" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UpdateInstanceResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        UpdateInstanceResponse res = sdk.instanceSettings().update()
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                         | Type                                                                              | Required                                                                          | Description                                                                       |
| --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| `request`                                                                         | [UpdateInstanceRequestBody](../../models/operations/UpdateInstanceRequestBody.md) | :heavy_check_mark:                                                                | The request object to use for the request.                                        |

### Response

**[UpdateInstanceResponse](../../models/operations/UpdateInstanceResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 422                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## updateRestrictions

Updates the restriction settings of an instance

### Example Usage

<!-- UsageSnippet language="java" operationID="UpdateInstanceRestrictions" method="patch" path="/instance/restrictions" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UpdateInstanceRestrictionsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        UpdateInstanceRestrictionsResponse res = sdk.instanceSettings().updateRestrictions()
                .call();

        if (res.instanceRestrictions().isPresent()) {
            System.out.println(res.instanceRestrictions().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                 | Type                                                                                                      | Required                                                                                                  | Description                                                                                               |
| --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                 | [UpdateInstanceRestrictionsRequestBody](../../models/operations/UpdateInstanceRestrictionsRequestBody.md) | :heavy_check_mark:                                                                                        | The request object to use for the request.                                                                |

### Response

**[UpdateInstanceRestrictionsResponse](../../models/operations/UpdateInstanceRestrictionsResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 402, 422                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## getCommunication

Retrieves the per-instance SMS communication settings, including the SMS country blocklist.

### Example Usage

<!-- UsageSnippet language="java" operationID="GetInstanceCommunication" method="get" path="/instance/communication" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.operations.GetInstanceCommunicationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        GetInstanceCommunicationResponse res = sdk.instanceSettings().getCommunication()
                .call();

        if (res.instanceCommunication().isPresent()) {
            System.out.println(res.instanceCommunication().get());
        }
    }
}
```

### Response

**[GetInstanceCommunicationResponse](../../models/operations/GetInstanceCommunicationResponse.md)**

### Errors

| Error Type             | Status Code            | Content Type           |
| ---------------------- | ---------------------- | ---------------------- |
| models/errors/SDKError | 4XX, 5XX               | \*/\*                  |

## updateCommunication

Replaces the SMS country blocklist for this instance. Pass the full set of ISO 3166-1
alpha-2 country codes that should be blocked; codes that aren't recognized as SMS-tier
countries are silently dropped from the persisted list. Omitting `blocked_country_codes`
is a no-op.


### Example Usage

<!-- UsageSnippet language="java" operationID="UpdateInstanceCommunication" method="patch" path="/instance/communication" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UpdateInstanceCommunicationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        UpdateInstanceCommunicationResponse res = sdk.instanceSettings().updateCommunication()
                .call();

        if (res.instanceCommunication().isPresent()) {
            System.out.println(res.instanceCommunication().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                   | Type                                                                                                        | Required                                                                                                    | Description                                                                                                 |
| ----------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                   | [UpdateInstanceCommunicationRequestBody](../../models/operations/UpdateInstanceCommunicationRequestBody.md) | :heavy_check_mark:                                                                                          | The request object to use for the request.                                                                  |

### Response

**[UpdateInstanceCommunicationResponse](../../models/operations/UpdateInstanceCommunicationResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 422                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## getOAuthApplicationSettings

Retrieves the settings for OAuth applications for the instance (dynamic client registration, JWT access tokens, etc.).

### Example Usage

<!-- UsageSnippet language="java" operationID="GetInstanceOAuthApplicationSettings" method="get" path="/instance/oauth_application_settings" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.operations.GetInstanceOAuthApplicationSettingsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        GetInstanceOAuthApplicationSettingsResponse res = sdk.instanceSettings().getOAuthApplicationSettings()
                .call();

        if (res.oAuthApplicationSettings().isPresent()) {
            System.out.println(res.oAuthApplicationSettings().get());
        }
    }
}
```

### Response

**[GetInstanceOAuthApplicationSettingsResponse](../../models/operations/GetInstanceOAuthApplicationSettingsResponse.md)**

### Errors

| Error Type             | Status Code            | Content Type           |
| ---------------------- | ---------------------- | ---------------------- |
| models/errors/SDKError | 4XX, 5XX               | \*/\*                  |

## updateOAuthApplicationSettings

Updates the OAuth application settings for the instance.

### Example Usage

<!-- UsageSnippet language="java" operationID="UpdateInstanceOAuthApplicationSettings" method="patch" path="/instance/oauth_application_settings" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UpdateInstanceOAuthApplicationSettingsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        UpdateInstanceOAuthApplicationSettingsResponse res = sdk.instanceSettings().updateOAuthApplicationSettings()
                .call();

        if (res.oAuthApplicationSettings().isPresent()) {
            System.out.println(res.oAuthApplicationSettings().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                         | Type                                                                                                                              | Required                                                                                                                          | Description                                                                                                                       |
| --------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                                         | [UpdateInstanceOAuthApplicationSettingsRequestBody](../../models/operations/UpdateInstanceOAuthApplicationSettingsRequestBody.md) | :heavy_check_mark:                                                                                                                | The request object to use for the request.                                                                                        |

### Response

**[UpdateInstanceOAuthApplicationSettingsResponse](../../models/operations/UpdateInstanceOAuthApplicationSettingsResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 422                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## changeDomain

Change the domain of a production instance.

Changing the domain requires updating the [DNS records](https://clerk.com/docs/deployments/overview#dns-records) accordingly, deploying new [SSL certificates](https://clerk.com/docs/deployments/overview#deploy-certificates), updating your Social Connection's redirect URLs and setting the new keys in your code.

WARNING: Changing your domain will invalidate all current user sessions (i.e. users will be logged out). Also, while your application is being deployed, a small downtime is expected to occur.

### Example Usage

<!-- UsageSnippet language="java" operationID="ChangeProductionInstanceDomain" method="post" path="/instance/change_domain" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.ChangeProductionInstanceDomainResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        ChangeProductionInstanceDomainResponse res = sdk.instanceSettings().changeDomain()
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                                         | Type                                                                                                              | Required                                                                                                          | Description                                                                                                       |
| ----------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                         | [ChangeProductionInstanceDomainRequestBody](../../models/operations/ChangeProductionInstanceDomainRequestBody.md) | :heavy_check_mark:                                                                                                | The request object to use for the request.                                                                        |

### Response

**[ChangeProductionInstanceDomainResponse](../../models/operations/ChangeProductionInstanceDomainResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 422                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## getOrganizationSettings

Retrieves the organization settings of the instance

### Example Usage

<!-- UsageSnippet language="java" operationID="GetInstanceOrganizationSettings" method="get" path="/instance/organization_settings" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.GetInstanceOrganizationSettingsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        GetInstanceOrganizationSettingsResponse res = sdk.instanceSettings().getOrganizationSettings()
                .call();

        if (res.organizationSettings().isPresent()) {
            System.out.println(res.organizationSettings().get());
        }
    }
}
```

### Response

**[GetInstanceOrganizationSettingsResponse](../../models/operations/GetInstanceOrganizationSettingsResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 402, 404, 422             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## updateOrganizationSettings

Updates the organization settings of the instance

### Example Usage

<!-- UsageSnippet language="java" operationID="UpdateInstanceOrganizationSettings" method="patch" path="/instance/organization_settings" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UpdateInstanceOrganizationSettingsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        UpdateInstanceOrganizationSettingsResponse res = sdk.instanceSettings().updateOrganizationSettings()
                .call();

        if (res.organizationSettings().isPresent()) {
            System.out.println(res.organizationSettings().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                 | Type                                                                                                                      | Required                                                                                                                  | Description                                                                                                               |
| ------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                                 | [UpdateInstanceOrganizationSettingsRequestBody](../../models/operations/UpdateInstanceOrganizationSettingsRequestBody.md) | :heavy_check_mark:                                                                                                        | The request object to use for the request.                                                                                |

### Response

**[UpdateInstanceOrganizationSettingsResponse](../../models/operations/UpdateInstanceOrganizationSettingsResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 402, 404, 422        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## getInstanceProtect

Get instance protect settings

### Example Usage

<!-- UsageSnippet language="java" operationID="GetInstanceProtect" method="get" path="/instance/protect" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.operations.GetInstanceProtectResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        GetInstanceProtectResponse res = sdk.instanceSettings().getInstanceProtect()
                .call();

        if (res.instanceProtect().isPresent()) {
            System.out.println(res.instanceProtect().get());
        }
    }
}
```

### Response

**[GetInstanceProtectResponse](../../models/operations/GetInstanceProtectResponse.md)**

### Errors

| Error Type             | Status Code            | Content Type           |
| ---------------------- | ---------------------- | ---------------------- |
| models/errors/SDKError | 4XX, 5XX               | \*/\*                  |

## updateInstanceProtect

Update instance protect settings

### Example Usage

<!-- UsageSnippet language="java" operationID="UpdateInstanceProtect" method="patch" path="/instance/protect" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UpdateInstanceProtectResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        UpdateInstanceProtectResponse res = sdk.instanceSettings().updateInstanceProtect()
                .call();

        if (res.instanceProtect().isPresent()) {
            System.out.println(res.instanceProtect().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                       | Type                                                                                            | Required                                                                                        | Description                                                                                     |
| ----------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- |
| `request`                                                                                       | [UpdateInstanceProtectRequestBody](../../models/operations/UpdateInstanceProtectRequestBody.md) | :heavy_check_mark:                                                                              | The request object to use for the request.                                                      |

### Response

**[UpdateInstanceProtectResponse](../../models/operations/UpdateInstanceProtectResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 422                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |