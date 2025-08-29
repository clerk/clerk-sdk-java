# InstanceSettings
(*instanceSettings()*)

## Overview

### Available Operations

* [get](#get) - Fetch the current instance
* [update](#update) - Update instance settings
* [updateRestrictions](#updaterestrictions) - Update instance restrictions
* [changeDomain](#changedomain) - Update production instance domain
* [updateOrganizationSettings](#updateorganizationsettings) - Update instance organization settings

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
            // handle response
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
            // handle response
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
            // handle response
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