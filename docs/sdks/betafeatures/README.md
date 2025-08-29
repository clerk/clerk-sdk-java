# BetaFeatures
(*betaFeatures()*)

## Overview

### Available Operations

* [updateInstanceSettings](#updateinstancesettings) - Update instance settings
* [~~updateProductionInstanceDomain~~](#updateproductioninstancedomain) - Update production instance domain :warning: **Deprecated**

## updateInstanceSettings

Updates the settings of an instance

### Example Usage

<!-- UsageSnippet language="java" operationID="UpdateInstanceAuthConfig" method="patch" path="/beta_features/instance_settings" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UpdateInstanceAuthConfigResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        UpdateInstanceAuthConfigResponse res = sdk.betaFeatures().updateInstanceSettings()
                .call();

        if (res.instanceSettings().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                             | Type                                                                                                  | Required                                                                                              | Description                                                                                           |
| ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- |
| `request`                                                                                             | [UpdateInstanceAuthConfigRequestBody](../../models/operations/UpdateInstanceAuthConfigRequestBody.md) | :heavy_check_mark:                                                                                    | The request object to use for the request.                                                            |

### Response

**[UpdateInstanceAuthConfigResponse](../../models/operations/UpdateInstanceAuthConfigResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 402, 422                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## ~~updateProductionInstanceDomain~~

Change the domain of a production instance.

Changing the domain requires updating the [DNS records](https://clerk.com/docs/deployments/overview#dns-records) accordingly, deploying new [SSL certificates](https://clerk.com/docs/deployments/overview#deploy-certificates), updating your Social Connection's redirect URLs and setting the new keys in your code.

WARNING: Changing your domain will invalidate all current user sessions (i.e. users will be logged out). Also, while your application is being deployed, a small downtime is expected to occur.

> :warning: **DEPRECATED**: This will be removed in a future release, please migrate away from it as soon as possible.

### Example Usage

<!-- UsageSnippet language="java" operationID="UpdateProductionInstanceDomain" method="put" path="/beta_features/domain" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UpdateProductionInstanceDomainResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        UpdateProductionInstanceDomainResponse res = sdk.betaFeatures().updateProductionInstanceDomain()
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                                         | Type                                                                                                              | Required                                                                                                          | Description                                                                                                       |
| ----------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                         | [UpdateProductionInstanceDomainRequestBody](../../models/operations/UpdateProductionInstanceDomainRequestBody.md) | :heavy_check_mark:                                                                                                | The request object to use for the request.                                                                        |

### Response

**[UpdateProductionInstanceDomainResponse](../../models/operations/UpdateProductionInstanceDomainResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 422                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |