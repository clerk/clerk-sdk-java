# Blocklist
(*blocklist()*)

## Overview

### Available Operations

* [list](#list) - List all identifiers on the block-list
* [create](#create) - Add identifier to the block-list
* [delete](#delete) - Delete identifier from block-list

## list

Get a list of all identifiers which are not allowed to access an instance

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.ListBlocklistIdentifiersResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            ListBlocklistIdentifiersResponse res = sdk.blocklist().list()
                .call();

            if (res.blocklistIdentifiers().isPresent()) {
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

### Response

**[ListBlocklistIdentifiersResponse](../../models/operations/ListBlocklistIdentifiersResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 401,402                   | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## create

Create an identifier that is blocked from accessing an instance

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.CreateBlocklistIdentifierRequestBody;
import com.clerk.backend_api.models.operations.CreateBlocklistIdentifierResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            CreateBlocklistIdentifierRequestBody req = CreateBlocklistIdentifierRequestBody.builder()
                .identifier("<value>")
                .build();

            CreateBlocklistIdentifierResponse res = sdk.blocklist().create()
                .request(req)
                .call();

            if (res.blocklistIdentifier().isPresent()) {
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

| Parameter                                                                                               | Type                                                                                                    | Required                                                                                                | Description                                                                                             |
| ------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- |
| `request`                                                                                               | [CreateBlocklistIdentifierRequestBody](../../models/operations/CreateBlocklistIdentifierRequestBody.md) | :heavy_check_mark:                                                                                      | The request object to use for the request.                                                              |

### Response

**[CreateBlocklistIdentifierResponse](../../models/operations/CreateBlocklistIdentifierResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,402,422               | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## delete

Delete an identifier from the instance block-list

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.DeleteBlocklistIdentifierResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            DeleteBlocklistIdentifierResponse res = sdk.blocklist().delete()
                .identifierId("<value>")
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

| Parameter                                              | Type                                                   | Required                                               | Description                                            |
| ------------------------------------------------------ | ------------------------------------------------------ | ------------------------------------------------------ | ------------------------------------------------------ |
| `identifierId`                                         | *String*                                               | :heavy_check_mark:                                     | The ID of the identifier to delete from the block-list |

### Response

**[DeleteBlocklistIdentifierResponse](../../models/operations/DeleteBlocklistIdentifierResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 402,404                   | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |
