# AwsCredentials
(*awsCredentials()*)

## Overview

### Available Operations

* [delete](#delete) - Delete an AWS Credential
* [update](#update) - Update an AWS Credential

## delete

Delete the AWS Credential with the given ID

### Example Usage

<!-- UsageSnippet language="java" operationID="DeleteAWSCredential" method="delete" path="/aws_credentials/{id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.DeleteAWSCredentialResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        DeleteAWSCredentialResponse res = sdk.awsCredentials().delete()
                .id("<id>")
                .call();

        if (res.deletedObject().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                              | Type                                   | Required                               | Description                            |
| -------------------------------------- | -------------------------------------- | -------------------------------------- | -------------------------------------- |
| `id`                                   | *String*                               | :heavy_check_mark:                     | The ID of the AWS Credential to delete |

### Response

**[DeleteAWSCredentialResponse](../../models/operations/DeleteAWSCredentialResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## update

Updates an AWS credential.

### Example Usage

<!-- UsageSnippet language="java" operationID="UpdateAWSCredential" method="patch" path="/aws_credentials/{id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.UpdateAWSCredentialResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        UpdateAWSCredentialResponse res = sdk.awsCredentials().update()
                .id("<id>")
                .call();

        if (res.awsCredential().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                              | Type                                                                                                   | Required                                                                                               | Description                                                                                            |
| ------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------ |
| `id`                                                                                                   | *String*                                                                                               | :heavy_check_mark:                                                                                     | The ID of the AWS Credential to update                                                                 |
| `requestBody`                                                                                          | [Optional\<UpdateAWSCredentialRequestBody>](../../models/operations/UpdateAWSCredentialRequestBody.md) | :heavy_minus_sign:                                                                                     | N/A                                                                                                    |

### Response

**[UpdateAWSCredentialResponse](../../models/operations/UpdateAWSCredentialResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404        | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |