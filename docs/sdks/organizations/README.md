# Organizations
(*organizations()*)

## Overview

### Available Operations

* [list](#list) - Get a list of organizations for an instance
* [create](#create) - Create an organization
* [get](#get) - Retrieve an organization by ID or slug
* [update](#update) - Update an organization
* [delete](#delete) - Delete an organization
* [mergeMetadata](#mergemetadata) - Merge and update metadata for an organization
* [uploadLogo](#uploadlogo) - Upload a logo for the organization
* [deleteLogo](#deletelogo) - Delete the organization's logo.

## list

This request returns the list of organizations for an instance.
Results can be paginated using the optional `limit` and `offset` query parameters.
The organizations are ordered by descending creation date.
Most recent organizations will be returned first.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.ListOrganizationsRequest;
import com.clerk.backend_api.models.operations.ListOrganizationsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            ListOrganizationsRequest req = ListOrganizationsRequest.builder()
                .build();

            ListOrganizationsResponse res = sdk.organizations().list()
                .request(req)
                .call();

            if (res.organizations().isPresent()) {
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

| Parameter                                                                       | Type                                                                            | Required                                                                        | Description                                                                     |
| ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| `request`                                                                       | [ListOrganizationsRequest](../../models/operations/ListOrganizationsRequest.md) | :heavy_check_mark:                                                              | The request object to use for the request.                                      |

### Response

**[ListOrganizationsResponse](../../models/operations/ListOrganizationsResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,403,422               | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## create

Creates a new organization with the given name for an instance.
In order to successfully create an organization you need to provide the ID of the User who will become the organization administrator.
You can specify an optional slug for the new organization.
If provided, the organization slug can contain only lowercase alphanumeric characters (letters and digits) and the dash "-".
Organization slugs must be unique for the instance.
You can provide additional metadata for the organization and set any custom attribute you want.
Organizations support private and public metadata.
Private metadata can only be accessed from the Backend API.
Public metadata can be accessed from the Backend API, and are read-only from the Frontend API.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.CreateOrganizationRequestBody;
import com.clerk.backend_api.models.operations.CreateOrganizationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            CreateOrganizationRequestBody req = CreateOrganizationRequestBody.builder()
                .name("<value>")
                .createdBy("<value>")
                .build();

            CreateOrganizationResponse res = sdk.organizations().create()
                .request(req)
                .call();

            if (res.organization().isPresent()) {
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

| Parameter                                                                                 | Type                                                                                      | Required                                                                                  | Description                                                                               |
| ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- |
| `request`                                                                                 | [CreateOrganizationRequestBody](../../models/operations/CreateOrganizationRequestBody.md) | :heavy_check_mark:                                                                        | The request object to use for the request.                                                |

### Response

**[CreateOrganizationResponse](../../models/operations/CreateOrganizationResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,403,422               | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## get

Fetches the organization whose ID or slug matches the provided `id_or_slug` URL query parameter.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.GetOrganizationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            GetOrganizationResponse res = sdk.organizations().get()
                .organizationId("<value>")
                .call();

            if (res.organization().isPresent()) {
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

| Parameter                          | Type                               | Required                           | Description                        |
| ---------------------------------- | ---------------------------------- | ---------------------------------- | ---------------------------------- |
| `organizationId`                   | *String*                           | :heavy_check_mark:                 | The ID or slug of the organization |

### Response

**[GetOrganizationResponse](../../models/operations/GetOrganizationResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 403,404                   | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## update

Updates an existing organization

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.UpdateOrganizationRequestBody;
import com.clerk.backend_api.models.operations.UpdateOrganizationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            UpdateOrganizationResponse res = sdk.organizations().update()
                .organizationId("<value>")
                .requestBody(UpdateOrganizationRequestBody.builder()
                    .build())
                .call();

            if (res.organization().isPresent()) {
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

| Parameter                                                                                 | Type                                                                                      | Required                                                                                  | Description                                                                               |
| ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- |
| `organizationId`                                                                          | *String*                                                                                  | :heavy_check_mark:                                                                        | The ID of the organization to update                                                      |
| `requestBody`                                                                             | [UpdateOrganizationRequestBody](../../models/operations/UpdateOrganizationRequestBody.md) | :heavy_check_mark:                                                                        | N/A                                                                                       |

### Response

**[UpdateOrganizationResponse](../../models/operations/UpdateOrganizationResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 402,404,422               | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## delete

Deletes the given organization.
Please note that deleting an organization will also delete all memberships and invitations.
This is not reversible.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.DeleteOrganizationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            DeleteOrganizationResponse res = sdk.organizations().delete()
                .organizationId("<value>")
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

| Parameter                            | Type                                 | Required                             | Description                          |
| ------------------------------------ | ------------------------------------ | ------------------------------------ | ------------------------------------ |
| `organizationId`                     | *String*                             | :heavy_check_mark:                   | The ID of the organization to delete |

### Response

**[DeleteOrganizationResponse](../../models/operations/DeleteOrganizationResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 404                       | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## mergeMetadata

Update organization metadata attributes by merging existing values with the provided parameters.
Metadata values will be updated via a deep merge.
Deep meaning that any nested JSON objects will be merged as well.
You can remove metadata keys at any level by setting their value to `null`.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.MergeOrganizationMetadataRequestBody;
import com.clerk.backend_api.models.operations.MergeOrganizationMetadataResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            MergeOrganizationMetadataResponse res = sdk.organizations().mergeMetadata()
                .organizationId("<value>")
                .requestBody(MergeOrganizationMetadataRequestBody.builder()
                    .build())
                .call();

            if (res.organization().isPresent()) {
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
| `organizationId`                                                                                        | *String*                                                                                                | :heavy_check_mark:                                                                                      | The ID of the organization for which metadata will be merged or updated                                 |
| `requestBody`                                                                                           | [MergeOrganizationMetadataRequestBody](../../models/operations/MergeOrganizationMetadataRequestBody.md) | :heavy_check_mark:                                                                                      | N/A                                                                                                     |

### Response

**[MergeOrganizationMetadataResponse](../../models/operations/MergeOrganizationMetadataResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,401,404,422           | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## uploadLogo

Set or replace an organization's logo, by uploading an image file.
This endpoint uses the `multipart/form-data` request content type and accepts a file of image type.
The file size cannot exceed 10MB.
Only the following file content types are supported: `image/jpeg`, `image/png`, `image/gif`, `image/webp`, `image/x-icon`, `image/vnd.microsoft.icon`.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.UploadOrganizationLogoFile;
import com.clerk.backend_api.models.operations.UploadOrganizationLogoRequestBody;
import com.clerk.backend_api.models.operations.UploadOrganizationLogoResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            UploadOrganizationLogoResponse res = sdk.organizations().uploadLogo()
                .organizationId("<value>")
                .requestBody(UploadOrganizationLogoRequestBody.builder()
                    .uploaderUserId("<value>")
                    .file(UploadOrganizationLogoFile.builder()
                            .fileName("<value>")
                            .content("0x07D3D6E1EC".getBytes())
                            .build())
                    .build())
                .call();

            if (res.organizationWithLogo().isPresent()) {
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

| Parameter                                                                                                   | Type                                                                                                        | Required                                                                                                    | Description                                                                                                 |
| ----------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------- |
| `organizationId`                                                                                            | *String*                                                                                                    | :heavy_check_mark:                                                                                          | The ID of the organization for which to upload a logo                                                       |
| `requestBody`                                                                                               | [Optional<UploadOrganizationLogoRequestBody>](../../models/operations/UploadOrganizationLogoRequestBody.md) | :heavy_minus_sign:                                                                                          | N/A                                                                                                         |

### Response

**[UploadOrganizationLogoResponse](../../models/operations/UploadOrganizationLogoResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,403,404,413           | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |


## deleteLogo

Delete the organization's logo.

### Example Usage

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.SDKError;
import com.clerk.backend_api.models.operations.DeleteOrganizationLogoResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            DeleteOrganizationLogoResponse res = sdk.organizations().deleteLogo()
                .organizationId("<value>")
                .call();

            if (res.organization().isPresent()) {
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

| Parameter                                                      | Type                                                           | Required                                                       | Description                                                    |
| -------------------------------------------------------------- | -------------------------------------------------------------- | -------------------------------------------------------------- | -------------------------------------------------------------- |
| `organizationId`                                               | *String*                                                       | :heavy_check_mark:                                             | The ID of the organization for which the logo will be deleted. |

### Response

**[DeleteOrganizationLogoResponse](../../models/operations/DeleteOrganizationLogoResponse.md)**

### Errors

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 404                       | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | \*\/*                     |
