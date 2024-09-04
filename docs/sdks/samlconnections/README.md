# SamlConnections
(*samlConnections()*)

## Overview

### Available Operations

* [list](#list) - Get a list of SAML Connections for an instance
* [create](#create) - Create a SAML Connection
* [get](#get) - Retrieve a SAML Connection by ID
* [update](#update) - Update a SAML Connection
* [delete](#delete) - Delete a SAML Connection

## list

Returns the list of SAML Connections for an instance.
Results can be paginated using the optional `limit` and `offset` query parameters.
The SAML Connections are ordered by descending creation date and the most recent will be returned first.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            sdk.samlConnections().list()
                .limit(10L)
                .offset(0L)
                .callAsStreamUnwrapped()
                .forEach(item -> {
                   // handle item
                });

        } catch (com.clerk.backend_api.models.errors.ClerkErrors e) {
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

| Parameter                                                                                                                                 | Type                                                                                                                                      | Required                                                                                                                                  | Description                                                                                                                               |
| ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- |
| `limit`                                                                                                                                   | *Optional<Long>*                                                                                                                          | :heavy_minus_sign:                                                                                                                        | Applies a limit to the number of results returned.<br/>Can be used for paginating the results together with `offset`.                     |
| `offset`                                                                                                                                  | *Optional<Long>*                                                                                                                          | :heavy_minus_sign:                                                                                                                        | Skip the first `offset` results when paginating.<br/>Needs to be an integer greater or equal to zero.<br/>To be used in conjunction with `limit`. |

### Response

**[ListSAMLConnectionsResponse](../../models/operations/ListSAMLConnectionsResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 402,403,422               | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## create

Create a new SAML Connection.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.CreateSAMLConnectionRequestBody;
import com.clerk.backend_api.models.operations.CreateSAMLConnectionResponse;
import com.clerk.backend_api.models.operations.Provider;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            CreateSAMLConnectionRequestBody req = CreateSAMLConnectionRequestBody.builder()
                .name("<value>")
                .domain("<value>")
                .provider(Provider.SAML_OKTA)
                .build();

            CreateSAMLConnectionResponse res = sdk.samlConnections().create()
                .request(req)
                .call();

            if (res.samlConnection().isPresent()) {
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

| Parameter                                                                                     | Type                                                                                          | Required                                                                                      | Description                                                                                   |
| --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- |
| `request`                                                                                     | [CreateSAMLConnectionRequestBody](../../models/operations/CreateSAMLConnectionRequestBody.md) | :heavy_check_mark:                                                                            | The request object to use for the request.                                                    |

### Response

**[CreateSAMLConnectionResponse](../../models/operations/CreateSAMLConnectionResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 402,403,422               | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## get

Fetches the SAML Connection whose ID matches the provided `saml_connection_id` in the path.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.GetSAMLConnectionResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            GetSAMLConnectionResponse res = sdk.samlConnections().get()
                .samlConnectionId("<value>")
                .call();

            if (res.samlConnection().isPresent()) {
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

| Parameter                     | Type                          | Required                      | Description                   |
| ----------------------------- | ----------------------------- | ----------------------------- | ----------------------------- |
| `samlConnectionId`            | *String*                      | :heavy_check_mark:            | The ID of the SAML Connection |

### Response

**[GetSAMLConnectionResponse](../../models/operations/GetSAMLConnectionResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 402,403,404               | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## update

Updates the SAML Connection whose ID matches the provided `id` in the path.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.UpdateSAMLConnectionRequestBody;
import com.clerk.backend_api.models.operations.UpdateSAMLConnectionResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            UpdateSAMLConnectionResponse res = sdk.samlConnections().update()
                .samlConnectionId("<value>")
                .requestBody(UpdateSAMLConnectionRequestBody.builder()
                    .build())
                .call();

            if (res.samlConnection().isPresent()) {
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

| Parameter                                                                                     | Type                                                                                          | Required                                                                                      | Description                                                                                   |
| --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- |
| `samlConnectionId`                                                                            | *String*                                                                                      | :heavy_check_mark:                                                                            | The ID of the SAML Connection to update                                                       |
| `requestBody`                                                                                 | [UpdateSAMLConnectionRequestBody](../../models/operations/UpdateSAMLConnectionRequestBody.md) | :heavy_check_mark:                                                                            | N/A                                                                                           |

### Response

**[UpdateSAMLConnectionResponse](../../models/operations/UpdateSAMLConnectionResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 402,403,404,422           | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## delete

Deletes the SAML Connection whose ID matches the provided `id` in the path.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.DeleteSAMLConnectionResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            DeleteSAMLConnectionResponse res = sdk.samlConnections().delete()
                .samlConnectionId("<value>")
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

| Parameter                               | Type                                    | Required                                | Description                             |
| --------------------------------------- | --------------------------------------- | --------------------------------------- | --------------------------------------- |
| `samlConnectionId`                      | *String*                                | :heavy_check_mark:                      | The ID of the SAML Connection to delete |

### Response

**[DeleteSAMLConnectionResponse](../../models/operations/DeleteSAMLConnectionResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 402,403,404               | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |
