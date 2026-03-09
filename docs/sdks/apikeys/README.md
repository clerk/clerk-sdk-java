# APIKeys

## Overview

Endpoints for managing API Keys

### Available Operations

* [createApiKey](#createapikey) - Create an API Key
* [getApiKeys](#getapikeys) - Get API Keys
* [getApiKey](#getapikey) - Get an API Key by ID
* [updateApiKey](#updateapikey) - Update an API Key
* [deleteApiKey](#deleteapikey) - Delete an API Key
* [getApiKeySecret](#getapikeysecret) - Get an API Key Secret
* [revokeApiKey](#revokeapikey) - Revoke an API Key
* [verifyApiKey](#verifyapikey) - Verify an API Key

## createApiKey

Create an API Key

### Example Usage

<!-- UsageSnippet language="java" operationID="createApiKey" method="post" path="/api_keys" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.CreateAPIKeyAPIKeysResponseBody;
import com.clerk.backend_api.models.errors.CreateApiKeyResponseBody;
import com.clerk.backend_api.models.operations.CreateApiKeyRequestBody;
import com.clerk.backend_api.models.operations.CreateApiKeyResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws CreateApiKeyResponseBody, CreateAPIKeyAPIKeysResponseBody, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        CreateApiKeyRequestBody req = CreateApiKeyRequestBody.builder()
                .name("<value>")
                .subject("<value>")
                .build();

        CreateApiKeyResponse res = sdk.apiKeys().createApiKey()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```

### Parameters

| Parameter                                                                     | Type                                                                          | Required                                                                      | Description                                                                   |
| ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- |
| `request`                                                                     | [CreateApiKeyRequestBody](../../models/operations/CreateApiKeyRequestBody.md) | :heavy_check_mark:                                                            | The request object to use for the request.                                    |

### Response

**[CreateApiKeyResponse](../../models/operations/CreateApiKeyResponse.md)**

### Errors

| Error Type                                    | Status Code                                   | Content Type                                  |
| --------------------------------------------- | --------------------------------------------- | --------------------------------------------- |
| models/errors/CreateApiKeyResponseBody        | 400                                           | application/json                              |
| models/errors/CreateAPIKeyAPIKeysResponseBody | 409                                           | application/json                              |
| models/errors/SDKError                        | 4XX, 5XX                                      | \*/\*                                         |

## getApiKeys

Get API Keys

### Example Usage

<!-- UsageSnippet language="java" operationID="getApiKeys" method="get" path="/api_keys" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.GetAPIKeysAPIKeysResponseBody;
import com.clerk.backend_api.models.errors.GetApiKeysResponseBody;
import com.clerk.backend_api.models.operations.GetApiKeysRequest;
import com.clerk.backend_api.models.operations.GetApiKeysResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetApiKeysResponseBody, GetAPIKeysAPIKeysResponseBody, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        GetApiKeysRequest req = GetApiKeysRequest.builder()
                .subject("<value>")
                .build();

        GetApiKeysResponse res = sdk.apiKeys().getApiKeys()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```

### Parameters

| Parameter                                                         | Type                                                              | Required                                                          | Description                                                       |
| ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- |
| `request`                                                         | [GetApiKeysRequest](../../models/operations/GetApiKeysRequest.md) | :heavy_check_mark:                                                | The request object to use for the request.                        |

### Response

**[GetApiKeysResponse](../../models/operations/GetApiKeysResponse.md)**

### Errors

| Error Type                                  | Status Code                                 | Content Type                                |
| ------------------------------------------- | ------------------------------------------- | ------------------------------------------- |
| models/errors/GetApiKeysResponseBody        | 400                                         | application/json                            |
| models/errors/GetAPIKeysAPIKeysResponseBody | 404                                         | application/json                            |
| models/errors/SDKError                      | 4XX, 5XX                                    | \*/\*                                       |

## getApiKey

Get an API Key by ID

### Example Usage

<!-- UsageSnippet language="java" operationID="getApiKey" method="get" path="/api_keys/{apiKeyID}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.GetAPIKeyAPIKeysResponseBody;
import com.clerk.backend_api.models.errors.GetApiKeyResponseBody;
import com.clerk.backend_api.models.operations.GetApiKeyResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetApiKeyResponseBody, GetAPIKeyAPIKeysResponseBody, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        GetApiKeyResponse res = sdk.apiKeys().getApiKey()
                .apiKeyID("<id>")
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```

### Parameters

| Parameter          | Type               | Required           | Description        |
| ------------------ | ------------------ | ------------------ | ------------------ |
| `apiKeyID`         | *String*           | :heavy_check_mark: | N/A                |

### Response

**[GetApiKeyResponse](../../models/operations/GetApiKeyResponse.md)**

### Errors

| Error Type                                 | Status Code                                | Content Type                               |
| ------------------------------------------ | ------------------------------------------ | ------------------------------------------ |
| models/errors/GetApiKeyResponseBody        | 400                                        | application/json                           |
| models/errors/GetAPIKeyAPIKeysResponseBody | 404                                        | application/json                           |
| models/errors/SDKError                     | 4XX, 5XX                                   | \*/\*                                      |

## updateApiKey

Update an API Key

### Example Usage

<!-- UsageSnippet language="java" operationID="updateApiKey" method="patch" path="/api_keys/{apiKeyID}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.UpdateAPIKeyAPIKeysResponseBody;
import com.clerk.backend_api.models.errors.UpdateApiKeyResponseBody;
import com.clerk.backend_api.models.operations.UpdateApiKeyRequestBody;
import com.clerk.backend_api.models.operations.UpdateApiKeyResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws UpdateApiKeyResponseBody, UpdateAPIKeyAPIKeysResponseBody, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        UpdateApiKeyResponse res = sdk.apiKeys().updateApiKey()
                .apiKeyID("<id>")
                .requestBody(UpdateApiKeyRequestBody.builder()
                    .build())
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```

### Parameters

| Parameter                                                                     | Type                                                                          | Required                                                                      | Description                                                                   |
| ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- |
| `apiKeyID`                                                                    | *String*                                                                      | :heavy_check_mark:                                                            | N/A                                                                           |
| `requestBody`                                                                 | [UpdateApiKeyRequestBody](../../models/operations/UpdateApiKeyRequestBody.md) | :heavy_check_mark:                                                            | N/A                                                                           |

### Response

**[UpdateApiKeyResponse](../../models/operations/UpdateApiKeyResponse.md)**

### Errors

| Error Type                                    | Status Code                                   | Content Type                                  |
| --------------------------------------------- | --------------------------------------------- | --------------------------------------------- |
| models/errors/UpdateApiKeyResponseBody        | 400                                           | application/json                              |
| models/errors/UpdateAPIKeyAPIKeysResponseBody | 404                                           | application/json                              |
| models/errors/SDKError                        | 4XX, 5XX                                      | \*/\*                                         |

## deleteApiKey

Delete an API Key

### Example Usage

<!-- UsageSnippet language="java" operationID="deleteApiKey" method="delete" path="/api_keys/{apiKeyID}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.DeleteAPIKeyAPIKeysResponseBody;
import com.clerk.backend_api.models.errors.DeleteApiKeyResponseBody;
import com.clerk.backend_api.models.operations.DeleteApiKeyResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws DeleteApiKeyResponseBody, DeleteAPIKeyAPIKeysResponseBody, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        DeleteApiKeyResponse res = sdk.apiKeys().deleteApiKey()
                .apiKeyID("<id>")
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```

### Parameters

| Parameter          | Type               | Required           | Description        |
| ------------------ | ------------------ | ------------------ | ------------------ |
| `apiKeyID`         | *String*           | :heavy_check_mark: | N/A                |

### Response

**[DeleteApiKeyResponse](../../models/operations/DeleteApiKeyResponse.md)**

### Errors

| Error Type                                    | Status Code                                   | Content Type                                  |
| --------------------------------------------- | --------------------------------------------- | --------------------------------------------- |
| models/errors/DeleteApiKeyResponseBody        | 400                                           | application/json                              |
| models/errors/DeleteAPIKeyAPIKeysResponseBody | 404                                           | application/json                              |
| models/errors/SDKError                        | 4XX, 5XX                                      | \*/\*                                         |

## getApiKeySecret

Get an API Key Secret

### Example Usage

<!-- UsageSnippet language="java" operationID="getApiKeySecret" method="get" path="/api_keys/{apiKeyID}/secret" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.GetAPIKeySecretAPIKeysResponseBody;
import com.clerk.backend_api.models.errors.GetApiKeySecretResponseBody;
import com.clerk.backend_api.models.operations.GetApiKeySecretResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetApiKeySecretResponseBody, GetAPIKeySecretAPIKeysResponseBody, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        GetApiKeySecretResponse res = sdk.apiKeys().getApiKeySecret()
                .apiKeyID("<id>")
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```

### Parameters

| Parameter          | Type               | Required           | Description        |
| ------------------ | ------------------ | ------------------ | ------------------ |
| `apiKeyID`         | *String*           | :heavy_check_mark: | N/A                |

### Response

**[GetApiKeySecretResponse](../../models/operations/GetApiKeySecretResponse.md)**

### Errors

| Error Type                                       | Status Code                                      | Content Type                                     |
| ------------------------------------------------ | ------------------------------------------------ | ------------------------------------------------ |
| models/errors/GetApiKeySecretResponseBody        | 400                                              | application/json                                 |
| models/errors/GetAPIKeySecretAPIKeysResponseBody | 404                                              | application/json                                 |
| models/errors/SDKError                           | 4XX, 5XX                                         | \*/\*                                            |

## revokeApiKey

Revoke an API Key

### Example Usage

<!-- UsageSnippet language="java" operationID="revokeApiKey" method="post" path="/api_keys/{apiKeyID}/revoke" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.RevokeAPIKeyAPIKeysResponseBody;
import com.clerk.backend_api.models.errors.RevokeApiKeyResponseBody;
import com.clerk.backend_api.models.operations.RevokeApiKeyRequestBody;
import com.clerk.backend_api.models.operations.RevokeApiKeyResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws RevokeApiKeyResponseBody, RevokeAPIKeyAPIKeysResponseBody, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        RevokeApiKeyResponse res = sdk.apiKeys().revokeApiKey()
                .apiKeyID("<id>")
                .requestBody(RevokeApiKeyRequestBody.builder()
                    .build())
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```

### Parameters

| Parameter                                                                     | Type                                                                          | Required                                                                      | Description                                                                   |
| ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- |
| `apiKeyID`                                                                    | *String*                                                                      | :heavy_check_mark:                                                            | N/A                                                                           |
| `requestBody`                                                                 | [RevokeApiKeyRequestBody](../../models/operations/RevokeApiKeyRequestBody.md) | :heavy_check_mark:                                                            | N/A                                                                           |

### Response

**[RevokeApiKeyResponse](../../models/operations/RevokeApiKeyResponse.md)**

### Errors

| Error Type                                    | Status Code                                   | Content Type                                  |
| --------------------------------------------- | --------------------------------------------- | --------------------------------------------- |
| models/errors/RevokeApiKeyResponseBody        | 400                                           | application/json                              |
| models/errors/RevokeAPIKeyAPIKeysResponseBody | 404                                           | application/json                              |
| models/errors/SDKError                        | 4XX, 5XX                                      | \*/\*                                         |

## verifyApiKey

Verify an API Key

### Example Usage

<!-- UsageSnippet language="java" operationID="verifyApiKey" method="post" path="/api_keys/verify" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.VerifyAPIKeyAPIKeysResponseBody;
import com.clerk.backend_api.models.errors.VerifyApiKeyResponseBody;
import com.clerk.backend_api.models.operations.VerifyApiKeyRequestBody;
import com.clerk.backend_api.models.operations.VerifyApiKeyResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws VerifyApiKeyResponseBody, VerifyAPIKeyAPIKeysResponseBody, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        VerifyApiKeyRequestBody req = VerifyApiKeyRequestBody.builder()
                .secret("<value>")
                .build();

        VerifyApiKeyResponse res = sdk.apiKeys().verifyApiKey()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```

### Parameters

| Parameter                                                                     | Type                                                                          | Required                                                                      | Description                                                                   |
| ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- |
| `request`                                                                     | [VerifyApiKeyRequestBody](../../models/operations/VerifyApiKeyRequestBody.md) | :heavy_check_mark:                                                            | The request object to use for the request.                                    |

### Response

**[VerifyApiKeyResponse](../../models/operations/VerifyApiKeyResponse.md)**

### Errors

| Error Type                                    | Status Code                                   | Content Type                                  |
| --------------------------------------------- | --------------------------------------------- | --------------------------------------------- |
| models/errors/VerifyApiKeyResponseBody        | 400                                           | application/json                              |
| models/errors/VerifyAPIKeyAPIKeysResponseBody | 404                                           | application/json                              |
| models/errors/SDKError                        | 4XX, 5XX                                      | \*/\*                                         |