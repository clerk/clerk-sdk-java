# BetaFeatures
(*betaFeatures()*)

## Overview

### Available Operations

* [updateInstanceSettings](#updateinstancesettings) - Update instance settings
* [~~updateDomain~~](#updatedomain) - Update production instance domain :warning: **Deprecated**
* [changeProductionInstanceDomain](#changeproductioninstancedomain) - Update production instance domain

## updateInstanceSettings

Updates the settings of an instance

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.UpdateInstanceAuthConfigRequestBody;
import com.clerk.backend_api.models.operations.UpdateInstanceAuthConfigResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            UpdateInstanceAuthConfigRequestBody req = UpdateInstanceAuthConfigRequestBody.builder()
                .build();

            UpdateInstanceAuthConfigResponse res = sdk.betaFeatures().updateInstanceSettings()
                .request(req)
                .call();

            if (res.instanceSettings().isPresent()) {
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

| Parameter                                                                                             | Type                                                                                                  | Required                                                                                              | Description                                                                                           |
| ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- |
| `request`                                                                                             | [UpdateInstanceAuthConfigRequestBody](../../models/operations/UpdateInstanceAuthConfigRequestBody.md) | :heavy_check_mark:                                                                                    | The request object to use for the request.                                                            |

### Response

**[UpdateInstanceAuthConfigResponse](../../models/operations/UpdateInstanceAuthConfigResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 402,422                   | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## ~~updateDomain~~

Change the domain of a production instance.

Changing the domain requires updating the [DNS records](https://clerk.com/docs/deployments/overview#dns-records) accordingly, deploying new [SSL certificates](https://clerk.com/docs/deployments/overview#deploy), updating your Social Connection's redirect URLs and setting the new keys in your code.

WARNING: Changing your domain will invalidate all current user sessions (i.e. users will be logged out). Also, while your application is being deployed, a small downtime is expected to occur.

> :warning: **DEPRECATED**: This will be removed in a future release, please migrate away from it as soon as possible.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.UpdateProductionInstanceDomainRequestBody;
import com.clerk.backend_api.models.operations.UpdateProductionInstanceDomainResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            UpdateProductionInstanceDomainRequestBody req = UpdateProductionInstanceDomainRequestBody.builder()
                .build();

            UpdateProductionInstanceDomainResponse res = sdk.betaFeatures().updateDomain()
                .request(req)
                .call();

            // handle response
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

| Parameter                                                                                                         | Type                                                                                                              | Required                                                                                                          | Description                                                                                                       |
| ----------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                         | [UpdateProductionInstanceDomainRequestBody](../../models/operations/UpdateProductionInstanceDomainRequestBody.md) | :heavy_check_mark:                                                                                                | The request object to use for the request.                                                                        |

### Response

**[UpdateProductionInstanceDomainResponse](../../models/operations/UpdateProductionInstanceDomainResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,422                   | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## changeProductionInstanceDomain

Change the domain of a production instance.

Changing the domain requires updating the [DNS records](https://clerk.com/docs/deployments/overview#dns-records) accordingly, deploying new [SSL certificates](https://clerk.com/docs/deployments/overview#deploy), updating your Social Connection's redirect URLs and setting the new keys in your code.

WARNING: Changing your domain will invalidate all current user sessions (i.e. users will be logged out). Also, while your application is being deployed, a small downtime is expected to occur.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.ChangeProductionInstanceDomainRequestBody;
import com.clerk.backend_api.models.operations.ChangeProductionInstanceDomainResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            ChangeProductionInstanceDomainRequestBody req = ChangeProductionInstanceDomainRequestBody.builder()
                .build();

            ChangeProductionInstanceDomainResponse res = sdk.betaFeatures().changeProductionInstanceDomain()
                .request(req)
                .call();

            // handle response
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

| Parameter                                                                                                         | Type                                                                                                              | Required                                                                                                          | Description                                                                                                       |
| ----------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                         | [ChangeProductionInstanceDomainRequestBody](../../models/operations/ChangeProductionInstanceDomainRequestBody.md) | :heavy_check_mark:                                                                                                | The request object to use for the request.                                                                        |

### Response

**[ChangeProductionInstanceDomainResponse](../../models/operations/ChangeProductionInstanceDomainResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,422                   | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |
