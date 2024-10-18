# OrganizationDomain
(*organizationDomain()*)

## Overview

### Available Operations

* [update](#update) - Update an organization domain.

## update

Updates the properties of an existing organization domain.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.UpdateOrganizationDomainRequestBody;
import com.clerk.backend_api.models.operations.UpdateOrganizationDomainResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            UpdateOrganizationDomainResponse res = sdk.organizationDomain().update()
                .organizationId("<value>")
                .domainId("<value>")
                .requestBody(UpdateOrganizationDomainRequestBody.builder()
                    .build())
                .call();

            if (res.organizationDomain().isPresent()) {
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
| `organizationId`                                                                                      | *String*                                                                                              | :heavy_check_mark:                                                                                    | The ID of the organization the domain belongs to                                                      |
| `domainId`                                                                                            | *String*                                                                                              | :heavy_check_mark:                                                                                    | The ID of the domain                                                                                  |
| `requestBody`                                                                                         | [UpdateOrganizationDomainRequestBody](../../models/operations/UpdateOrganizationDomainRequestBody.md) | :heavy_check_mark:                                                                                    | N/A                                                                                                   |

### Response

**[UpdateOrganizationDomainResponse](../../models/operations/UpdateOrganizationDomainResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,404,422               | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |
