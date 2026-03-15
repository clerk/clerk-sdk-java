# EnterpriseConnections

## Overview

### Available Operations

* [list](#list) - List enterprise connections
* [create](#create) - Create an enterprise connection
* [get](#get) - Retrieve an enterprise connection
* [update](#update) - Update an enterprise connection
* [delete](#delete) - Delete an enterprise connection

## list

Returns the list of enterprise connections for the instance.
Results can be paginated using the optional `limit` and `offset` query parameters.

### Example Usage

<!-- UsageSnippet language="java" operationID="ListEnterpriseConnections" method="get" path="/enterprise_connections" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.ListEnterpriseConnectionsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        ListEnterpriseConnectionsResponse res = sdk.enterpriseConnections().list()
                .limit(10L)
                .offset(0L)
                .call();

        if (res.enterpriseConnections().isPresent()) {
            System.out.println(res.enterpriseConnections().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                           | Type                                                                                                                                                                | Required                                                                                                                                                            | Description                                                                                                                                                         |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `limit`                                                                                                                                                             | *Optional\<Long>*                                                                                                                                                   | :heavy_minus_sign:                                                                                                                                                  | Applies a limit to the number of results returned.<br/>Can be used for paginating the results together with `offset`.                                               |
| `offset`                                                                                                                                                            | *Optional\<Long>*                                                                                                                                                   | :heavy_minus_sign:                                                                                                                                                  | Skip the first `offset` results when paginating.<br/>Needs to be an integer greater or equal to zero.<br/>To be used in conjunction with `limit`.                   |
| `organizationId`                                                                                                                                                    | *Optional\<String>*                                                                                                                                                 | :heavy_minus_sign:                                                                                                                                                  | Filter enterprise connections by organization ID                                                                                                                    |
| `active`                                                                                                                                                            | *Optional\<Boolean>*                                                                                                                                                | :heavy_minus_sign:                                                                                                                                                  | Filter by active status. If true, only active connections are returned. If false, only inactive connections are returned. If omitted, all connections are returned. |

### Response

**[ListEnterpriseConnectionsResponse](../../models/operations/ListEnterpriseConnectionsResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 402, 403, 422             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## create

Create a new enterprise connection.

### Example Usage

<!-- UsageSnippet language="java" operationID="CreateEnterpriseConnection" method="post" path="/enterprise_connections" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CreateEnterpriseConnectionResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        CreateEnterpriseConnectionResponse res = sdk.enterpriseConnections().create()
                .call();

        if (res.schemasEnterpriseConnection().isPresent()) {
            System.out.println(res.schemasEnterpriseConnection().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                 | Type                                                                                                      | Required                                                                                                  | Description                                                                                               |
| --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                 | [CreateEnterpriseConnectionRequestBody](../../models/operations/CreateEnterpriseConnectionRequestBody.md) | :heavy_check_mark:                                                                                        | The request object to use for the request.                                                                |

### Response

**[CreateEnterpriseConnectionResponse](../../models/operations/CreateEnterpriseConnectionResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 402, 403, 404, 422        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## get

Fetches the enterprise connection whose ID matches the provided `enterprise_connection_id` in the path.

### Example Usage

<!-- UsageSnippet language="java" operationID="GetEnterpriseConnection" method="get" path="/enterprise_connections/{enterprise_connection_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.GetEnterpriseConnectionResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        GetEnterpriseConnectionResponse res = sdk.enterpriseConnections().get()
                .enterpriseConnectionId("<id>")
                .call();

        if (res.schemasEnterpriseConnection().isPresent()) {
            System.out.println(res.schemasEnterpriseConnection().get());
        }
    }
}
```

### Parameters

| Parameter                           | Type                                | Required                            | Description                         |
| ----------------------------------- | ----------------------------------- | ----------------------------------- | ----------------------------------- |
| `enterpriseConnectionId`            | *String*                            | :heavy_check_mark:                  | The ID of the enterprise connection |

### Response

**[GetEnterpriseConnectionResponse](../../models/operations/GetEnterpriseConnectionResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 402, 403, 404             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## update

Updates the enterprise connection whose ID matches the provided `enterprise_connection_id` in the path.
When enabling the connection (setting `active` to true), any existing verified organization domains that match the connection's domains (e.g. used for enrollment modes like automatic invitation) may be deleted so the connection can be enabled.

### Example Usage

<!-- UsageSnippet language="java" operationID="UpdateEnterpriseConnection" method="patch" path="/enterprise_connections/{enterprise_connection_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UpdateEnterpriseConnectionRequestBody;
import com.clerk.backend_api.models.operations.UpdateEnterpriseConnectionResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        UpdateEnterpriseConnectionResponse res = sdk.enterpriseConnections().update()
                .enterpriseConnectionId("<id>")
                .requestBody(UpdateEnterpriseConnectionRequestBody.builder()
                    .build())
                .call();

        if (res.schemasEnterpriseConnection().isPresent()) {
            System.out.println(res.schemasEnterpriseConnection().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                 | Type                                                                                                      | Required                                                                                                  | Description                                                                                               |
| --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- |
| `enterpriseConnectionId`                                                                                  | *String*                                                                                                  | :heavy_check_mark:                                                                                        | The ID of the enterprise connection to update                                                             |
| `requestBody`                                                                                             | [UpdateEnterpriseConnectionRequestBody](../../models/operations/UpdateEnterpriseConnectionRequestBody.md) | :heavy_check_mark:                                                                                        | N/A                                                                                                       |

### Response

**[UpdateEnterpriseConnectionResponse](../../models/operations/UpdateEnterpriseConnectionResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 402, 403, 404, 422   | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## delete

Deletes the enterprise connection whose ID matches the provided `enterprise_connection_id` in the path.

### Example Usage

<!-- UsageSnippet language="java" operationID="DeleteEnterpriseConnection" method="delete" path="/enterprise_connections/{enterprise_connection_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.DeleteEnterpriseConnectionResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        DeleteEnterpriseConnectionResponse res = sdk.enterpriseConnections().delete()
                .enterpriseConnectionId("<id>")
                .call();

        if (res.deletedObject().isPresent()) {
            System.out.println(res.deletedObject().get());
        }
    }
}
```

### Parameters

| Parameter                                     | Type                                          | Required                                      | Description                                   |
| --------------------------------------------- | --------------------------------------------- | --------------------------------------------- | --------------------------------------------- |
| `enterpriseConnectionId`                      | *String*                                      | :heavy_check_mark:                            | The ID of the enterprise connection to delete |

### Response

**[DeleteEnterpriseConnectionResponse](../../models/operations/DeleteEnterpriseConnectionResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 402, 403, 404             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |