# Domains
(*domains()*)

## Overview

### Available Operations

* [list](#list) - List all instance domains
* [add](#add) - Add a domain
* [delete](#delete) - Delete a satellite domain
* [update](#update) - Update a domain

## list

Use this endpoint to get a list of all domains for an instance.
The response will contain the primary domain for the instance and any satellite domains. Each domain in the response contains information about the URLs where Clerk operates and the required CNAME targets.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.ListDomainsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            ListDomainsResponse res = sdk.domains().list()
                .call();

            if (res.domains().isPresent()) {
                // handle response
            }
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

### Response

**[ListDomainsResponse](../../models/operations/ListDomainsResponse.md)**

### Errors

| Error Object           | Status Code            | Content Type           |
| ---------------------- | ---------------------- | ---------------------- |
| models/errors/SDKError | 4xx-5xx                | \*\/*                  |


## add

Add a new domain for your instance.
Useful in the case of multi-domain instances, allows adding satellite domains to an instance.
The new domain must have a `name`. The domain name can contain the port for development instances, like `localhost:3000`.
At the moment, instances can have only one primary domain, so the `is_satellite` parameter must be set to `true`.
If you're planning to configure the new satellite domain to run behind a proxy, pass the `proxy_url` parameter accordingly.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.AddDomainRequestBody;
import com.clerk.backend_api.models.operations.AddDomainResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            AddDomainRequestBody req = AddDomainRequestBody.builder()
                .name("<value>")
                .isSatellite(false)
                .build();

            AddDomainResponse res = sdk.domains().add()
                .request(req)
                .call();

            if (res.domain().isPresent()) {
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
| `request`                                                               | [AddDomainRequestBody](../../models/operations/AddDomainRequestBody.md) | :heavy_check_mark:                                                      | The request object to use for the request.                              |

### Response

**[AddDomainResponse](../../models/operations/AddDomainResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,402,422               | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## delete

Deletes a satellite domain for the instance.
It is currently not possible to delete the instance's primary domain.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.DeleteDomainResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            DeleteDomainResponse res = sdk.domains().delete()
                .domainId("<value>")
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

| Parameter                                                              | Type                                                                   | Required                                                               | Description                                                            |
| ---------------------------------------------------------------------- | ---------------------------------------------------------------------- | ---------------------------------------------------------------------- | ---------------------------------------------------------------------- |
| `domainId`                                                             | *String*                                                               | :heavy_check_mark:                                                     | The ID of the domain that will be deleted. Must be a satellite domain. |

### Response

**[DeleteDomainResponse](../../models/operations/DeleteDomainResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 403,404                   | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


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

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.UpdateDomainRequestBody;
import com.clerk.backend_api.models.operations.UpdateDomainResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            UpdateDomainResponse res = sdk.domains().update()
                .domainId("<value>")
                .requestBody(UpdateDomainRequestBody.builder()
                    .build())
                .call();

            if (res.domain().isPresent()) {
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

| Parameter                                                                     | Type                                                                          | Required                                                                      | Description                                                                   |
| ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- |
| `domainId`                                                                    | *String*                                                                      | :heavy_check_mark:                                                            | The ID of the domain that will be updated.                                    |
| `requestBody`                                                                 | [UpdateDomainRequestBody](../../models/operations/UpdateDomainRequestBody.md) | :heavy_check_mark:                                                            | N/A                                                                           |

### Response

**[UpdateDomainResponse](../../models/operations/UpdateDomainResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,404,422               | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |
