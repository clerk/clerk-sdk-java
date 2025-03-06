# OrganizationDomains
(*organizationDomains()*)

## Overview

### Available Operations

* [create](#create) - Create a new organization domain.
* [list](#list) - Get a list of all domains of an organization.
* [update](#update) - Update an organization domain.
* [delete](#delete) - Remove a domain from an organization.

## create

Creates a new organization domain. By default the domain is verified, but can be optionally set to unverified.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CreateOrganizationDomainRequestBody;
import com.clerk.backend_api.models.operations.CreateOrganizationDomainResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        CreateOrganizationDomainResponse res = sdk.organizationDomains().create()
                .organizationId("<id>")
                .requestBody(CreateOrganizationDomainRequestBody.builder()
                    .build())
                .call();

        if (res.organizationDomain().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                             | Type                                                                                                  | Required                                                                                              | Description                                                                                           |
| ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- |
| `organizationId`                                                                                      | *String*                                                                                              | :heavy_check_mark:                                                                                    | The ID of the organization where the new domain will be created.                                      |
| `requestBody`                                                                                         | [CreateOrganizationDomainRequestBody](../../models/operations/CreateOrganizationDomainRequestBody.md) | :heavy_check_mark:                                                                                    | N/A                                                                                                   |

### Response

**[CreateOrganizationDomainResponse](../../models/operations/CreateOrganizationDomainResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 403, 404, 422        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## list

Get a list of all domains of an organization.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.ListOrganizationDomainsRequest;
import com.clerk.backend_api.models.operations.ListOrganizationDomainsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        ListOrganizationDomainsRequest req = ListOrganizationDomainsRequest.builder()
                .organizationId("<id>")
                .build();

        ListOrganizationDomainsResponse res = sdk.organizationDomains().list()
                .request(req)
                .call();

        if (res.organizationDomains().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                   | Type                                                                                        | Required                                                                                    | Description                                                                                 |
| ------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------- |
| `request`                                                                                   | [ListOrganizationDomainsRequest](../../models/operations/ListOrganizationDomainsRequest.md) | :heavy_check_mark:                                                                          | The request object to use for the request.                                                  |

### Response

**[ListOrganizationDomainsResponse](../../models/operations/ListOrganizationDomainsResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 401, 422                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## update

Updates the properties of an existing organization domain.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UpdateOrganizationDomainRequestBody;
import com.clerk.backend_api.models.operations.UpdateOrganizationDomainResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        UpdateOrganizationDomainResponse res = sdk.organizationDomains().update()
                .organizationId("<id>")
                .domainId("<id>")
                .requestBody(UpdateOrganizationDomainRequestBody.builder()
                    .build())
                .call();

        if (res.organizationDomain().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                             | Type                                                                                                  | Required                                                                                              | Description                                                                                           |
| ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- |
| `organizationId`                                                                                      | *String*                                                                                              | :heavy_check_mark:                                                                                    | The ID of the organization the domain belongs to                                                      |
| `domainId`                                                                                            | *String*                                                                                              | :heavy_check_mark:                                                                                    | The ID of the domain                                                                                  |
| `requestBody`                                                                                         | [UpdateOrganizationDomainRequestBody](../../models/operations/UpdateOrganizationDomainRequestBody.md) | :heavy_check_mark:                                                                                    | N/A                                                                                                   |

### Response

**[UpdateOrganizationDomainResponse](../../models/operations/UpdateOrganizationDomainResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 404, 422             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## delete

Removes the given domain from the organization.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.DeleteOrganizationDomainResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        DeleteOrganizationDomainResponse res = sdk.organizationDomains().delete()
                .organizationId("<id>")
                .domainId("<id>")
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
| `organizationId`                                 | *String*                                         | :heavy_check_mark:                               | The ID of the organization the domain belongs to |
| `domainId`                                       | *String*                                         | :heavy_check_mark:                               | The ID of the domain                             |

### Response

**[DeleteOrganizationDomainResponse](../../models/operations/DeleteOrganizationDomainResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 404             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |