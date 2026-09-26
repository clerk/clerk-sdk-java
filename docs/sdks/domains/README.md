# Domains

## Overview

### Available Operations

* [list](#list) - List all instance domains
* [add](#add) - Add a domain
* [delete](#delete) - Delete a domain
* [update](#update) - Update a domain

## list

Use this endpoint to get a list of all domains for an instance.
The response will contain the primary domain for the instance and any satellite domains. Each domain in the response contains information about the URLs where Clerk operates and the required CNAME targets.

### Example Usage

<!-- UsageSnippet language="java" operationID="ListDomains" method="get" path="/domains" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.operations.ListDomainsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        ListDomainsResponse res = sdk.domains().list()
                .call();

        if (res.domains().isPresent()) {
            System.out.println(res.domains().get());
        }
    }
}
```

### Response

**[ListDomainsResponse](../../models/operations/ListDomainsResponse.md)**

### Errors

| Error Type             | Status Code            | Content Type           |
| ---------------------- | ---------------------- | ---------------------- |
| models/errors/SDKError | 4XX, 5XX               | \*/\*                  |

## add

Add a new domain for your instance.
Useful in the case of multi-domain instances, allows adding satellite domains to an instance.
The new domain must have a `name`. The domain name can contain the port for development instances, like `localhost:3000`.
Set `is_satellite` to `true` to add a satellite domain.
To migrate a production instance from an active provider domain to its first custom primary domain,
set `is_satellite` to `false`. The custom domain becomes active and the provider domain stays attached.
Additional custom primary domains are not supported.
If you're planning to configure the new satellite domain to run behind a proxy, pass the `proxy_url` parameter accordingly.

### Example Usage

<!-- UsageSnippet language="java" operationID="AddDomain" method="post" path="/domains" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.AddDomainResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        AddDomainResponse res = sdk.domains().add()
                .call();

        if (res.domain().isPresent()) {
            System.out.println(res.domain().get());
        }
    }
}
```

### Parameters

| Parameter                                                               | Type                                                                    | Required                                                                | Description                                                             |
| ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- |
| `request`                                                               | [AddDomainRequestBody](../../models/operations/AddDomainRequestBody.md) | :heavy_check_mark:                                                      | The request object to use for the request.                              |

### Response

**[AddDomainResponse](../../models/operations/AddDomainResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 402, 422             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## delete

Deletes a domain for the instance.
The instance's active domain cannot be deleted.

### Example Usage

<!-- UsageSnippet language="java" operationID="DeleteDomain" method="delete" path="/domains/{domain_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.DeleteDomainResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        DeleteDomainResponse res = sdk.domains().delete()
                .domainId("<id>")
                .call();

        if (res.deletedObject().isPresent()) {
            System.out.println(res.deletedObject().get());
        }
    }
}
```

### Parameters

| Parameter                                  | Type                                       | Required                                   | Description                                |
| ------------------------------------------ | ------------------------------------------ | ------------------------------------------ | ------------------------------------------ |
| `domainId`                                 | *String*                                   | :heavy_check_mark:                         | The ID of the domain that will be deleted. |

### Response

**[DeleteDomainResponse](../../models/operations/DeleteDomainResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 403, 404                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## update

The `proxy_url` can be updated only for production instances.
Update one of the instance's domains. Both primary and satellite domains can be updated.
If you choose to use Clerk via proxy, use this endpoint to specify the `proxy_url`.
Whenever you decide you'd rather switch to DNS setup for Clerk, simply set `proxy_url`
to `null` for the domain. When you update a production instance's primary domain name,
you have to make sure that you've completed all the necessary setup steps for DNS and
emails to work. Expect downtime otherwise. Updating a primary domain's name will also
update the instance's home origin, affecting the default application paths.

### Example Usage

<!-- UsageSnippet language="java" operationID="UpdateDomain" method="patch" path="/domains/{domain_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UpdateDomainRequestBody;
import com.clerk.backend_api.models.operations.UpdateDomainResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        UpdateDomainResponse res = sdk.domains().update()
                .domainId("<id>")
                .requestBody(UpdateDomainRequestBody.builder()
                    .build())
                .call();

        if (res.domain().isPresent()) {
            System.out.println(res.domain().get());
        }
    }
}
```

### Parameters

| Parameter                                                                     | Type                                                                          | Required                                                                      | Description                                                                   |
| ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- |
| `domainId`                                                                    | *String*                                                                      | :heavy_check_mark:                                                            | The ID of the domain that will be updated.                                    |
| `requestBody`                                                                 | [UpdateDomainRequestBody](../../models/operations/UpdateDomainRequestBody.md) | :heavy_check_mark:                                                            | N/A                                                                           |

### Response

**[UpdateDomainResponse](../../models/operations/UpdateDomainResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 404, 422             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |