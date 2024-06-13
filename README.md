<div align="center">
        <img src="https://github.com/speakeasy-sdks/clerk-ts/assets/68016351/62e27b17-7a99-46cf-a09e-13d2f06f733e" width="500">
   <p>The most comprehensive User Management Platform</p>
   <a href="https://clerk.com/docs/reference/backend-api"><img src="https://img.shields.io/static/v1?label=Docs&message=API Ref&color=000000&style=for-the-badge" /></a>
  <a href="https://opensource.org/licenses/MIT"><img src="https://img.shields.io/badge/License-MIT-blue.svg?style=for-the-badge" /></a>
</div>
<br></br>

The Clerk Java library provides convenient access to the Clerk REST API from any Java application running Java8 or above. The library includes type definitions for all request params and response fields, and offers universal typescript runtime support powered by [Apache Httpclient](https://hc.apache.org/httpcomponents-client-4.5.x/index.html)

> ⚠️ This SDK is not yet published to Maven Central. 

<!-- Start SDK Installation [installation] -->
## SDK Installation

### Getting started

The samples below show how a published SDK artifact is used:

Gradle:
```groovy
implementation 'com.clerk.backend_api:api:0.0.3'
```

Maven:
```xml
<dependency>
    <groupId>com.clerk.backend_api</groupId>
    <artifactId>api</artifactId>
    <version>0.0.3</version>
</dependency>
```

### How to build
After cloning the git repository to your file system you can build the SDK artifact from source to the `build` directory by running `./gradlew build` on *nix systems or `gradlew.bat` on Windows systems.

If you wish to build from source and publish the SDK artifact to your local Maven repository (on your filesystem) then use the following command (after cloning the git repo locally):

On *nix:
```bash
./gradlew publishToMavenLocal -Pskip.signing
```
On Windows:
```bash
gradlew.bat publishToMavenLocal -Pskip.signing
```
<!-- End SDK Installation [installation] -->

<!-- Start SDK Example Usage [usage] -->
## SDK Example Usage

### Example 1

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.components.*;
import com.clerk.backend_api.models.components.Security;
import com.clerk.backend_api.models.operations.*;
import com.clerk.backend_api.utils.EventStream;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;
import static java.util.Map.entry;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            GetClientListResponse res = sdk.clients().list()
                .limit(10L)
                .offset(0L)
                .call();

            while (true) {
                if (res.clientList().isPresent()) {
                    // handle response
                    Optional<GetClientListResponse> nextRes = res.next();
                    if (nextRes.isPresent()) {
                        res = nextRes.get();
                    } else {
                        break;
                    }
                }
            }
        } catch (com.clerk.backend_api.models.errors.ClerkErrors e) {
            // handle exception
            throw e;
        } catch (com.clerk.backend_api.models.errors.SDKError e) {
            // handle exception
            throw e;
        } catch (Exception e) {
            // handle exception
            throw e;
        }
    }
}
```

### Create Actor Tokens

This example shows how to create an actor token that can be used to impersonate the given user.

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.components.*;
import com.clerk.backend_api.models.components.Security;
import com.clerk.backend_api.models.operations.*;
import com.clerk.backend_api.utils.EventStream;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;
import static java.util.Map.entry;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            CreateActorTokenRequestBody req = CreateActorTokenRequestBody.builder()
                .userId("<value>")
                .actor(java.util.Map.ofEntries(
                        entry("sub", "user_2OEpKhcCN1Lat9NQ0G6puh7q5Rb")))
                .build();

            CreateActorTokenResponse res = sdk.actors().createToken()
                .request(req)
                .call();

            if (res.actorToken().isPresent()) {
                // handle response
            }
        } catch (com.clerk.backend_api.models.errors.ClerkErrors e) {
            // handle exception
            throw e;
        } catch (com.clerk.backend_api.models.errors.SDKError e) {
            // handle exception
            throw e;
        } catch (Exception e) {
            // handle exception
            throw e;
        }
    }
}
```
<!-- End SDK Example Usage [usage] -->

<!-- Start Available Resources and Operations [operations] -->
## Available Resources and Operations

### [miscellaneous()](docs/sdks/miscellaneous/README.md)

* [getPublicInterstitial](docs/sdks/miscellaneous/README.md#getpublicinterstitial) - Returns the markup for the interstitial page

### [jwks()](docs/sdks/jwks/README.md)

* [getJWKS](docs/sdks/jwks/README.md#getjwks) - Retrieve the JSON Web Key Set of the instance

### [clients()](docs/sdks/clients/README.md)

* [~~list~~](docs/sdks/clients/README.md#list) - List all clients :warning: **Deprecated**
* [verify](docs/sdks/clients/README.md#verify) - Verify a client
* [get](docs/sdks/clients/README.md#get) - Get a client

### [emailAddresses()](docs/sdks/emailaddresses/README.md)

* [create](docs/sdks/emailaddresses/README.md#create) - Create an email address
* [get](docs/sdks/emailaddresses/README.md#get) - Retrieve an email address
* [delete](docs/sdks/emailaddresses/README.md#delete) - Delete an email address
* [update](docs/sdks/emailaddresses/README.md#update) - Update an email address

### [phoneNumbers()](docs/sdks/phonenumbers/README.md)

* [create](docs/sdks/phonenumbers/README.md#create) - Create a phone number
* [get](docs/sdks/phonenumbers/README.md#get) - Retrieve a phone number
* [delete](docs/sdks/phonenumbers/README.md#delete) - Delete a phone number
* [update](docs/sdks/phonenumbers/README.md#update) - Update a phone number

### [sessions()](docs/sdks/sessions/README.md)

* [list](docs/sdks/sessions/README.md#list) - List all sessions
* [get](docs/sdks/sessions/README.md#get) - Retrieve a session
* [revoke](docs/sdks/sessions/README.md#revoke) - Revoke a session
* [~~verify~~](docs/sdks/sessions/README.md#verify) - Verify a session :warning: **Deprecated**
* [createTokenFromTemplate](docs/sdks/sessions/README.md#createtokenfromtemplate) - Create a session token from a jwt template

### [templates()](docs/sdks/templates/README.md)

* [list](docs/sdks/templates/README.md#list) - List all templates
* [get](docs/sdks/templates/README.md#get) - Retrieve a template
* [upsert](docs/sdks/templates/README.md#upsert) - Update a template for a given type and slug
* [revert](docs/sdks/templates/README.md#revert) - Revert a template
* [preview](docs/sdks/templates/README.md#preview) - Preview changes to a template
* [toggleDelivery](docs/sdks/templates/README.md#toggledelivery) - Toggle the delivery by Clerk for a template of a given type and slug

### [users()](docs/sdks/users/README.md)

* [list](docs/sdks/users/README.md#list) - List all users
* [create](docs/sdks/users/README.md#create) - Create a new user
* [count](docs/sdks/users/README.md#count) - Count users
* [get](docs/sdks/users/README.md#get) - Retrieve a user
* [update](docs/sdks/users/README.md#update) - Update a user
* [delete](docs/sdks/users/README.md#delete) - Delete a user
* [ban](docs/sdks/users/README.md#ban) - Ban a user
* [unban](docs/sdks/users/README.md#unban) - Unban a user
* [lock](docs/sdks/users/README.md#lock) - Lock a user
* [unlock](docs/sdks/users/README.md#unlock) - Unlock a user
* [setProfileImage](docs/sdks/users/README.md#setprofileimage) - Set user profile image
* [deleteProfileImage](docs/sdks/users/README.md#deleteprofileimage) - Delete user profile image
* [updateMetadata](docs/sdks/users/README.md#updatemetadata) - Merge and update a user's metadata
* [getOAuthAccessToken](docs/sdks/users/README.md#getoauthaccesstoken) - Retrieve the OAuth access token of a user
* [getOrganizationMemberships](docs/sdks/users/README.md#getorganizationmemberships) - Retrieve all memberships for a user
* [verifyPassword](docs/sdks/users/README.md#verifypassword) - Verify the password of a user
* [verifyTOTP](docs/sdks/users/README.md#verifytotp) - Verify a TOTP or backup code for a user
* [disableMFA](docs/sdks/users/README.md#disablemfa) - Disable a user's MFA methods

### [invitations()](docs/sdks/invitations/README.md)

* [create](docs/sdks/invitations/README.md#create) - Create an invitation
* [list](docs/sdks/invitations/README.md#list) - List all invitations
* [revoke](docs/sdks/invitations/README.md#revoke) - Revokes an invitation

### [allowlist()](docs/sdks/allowlist/README.md)

* [list](docs/sdks/allowlist/README.md#list) - List all identifiers on the allow-list
* [create](docs/sdks/allowlist/README.md#create) - Add identifier to the allow-list
* [delete](docs/sdks/allowlist/README.md#delete) - Delete identifier from allow-list

### [blocklist()](docs/sdks/blocklist/README.md)

* [list](docs/sdks/blocklist/README.md#list) - List all identifiers on the block-list
* [create](docs/sdks/blocklist/README.md#create) - Add identifier to the block-list
* [delete](docs/sdks/blocklist/README.md#delete) - Delete identifier from block-list

### [instance()](docs/sdks/instance/README.md)

* [updateAuthConfig](docs/sdks/instance/README.md#updateauthconfig) - Update instance settings
* [~~updateProductionDomain~~](docs/sdks/instance/README.md#updateproductiondomain) - Update production instance domain :warning: **Deprecated**
* [update](docs/sdks/instance/README.md#update) - Update instance settings
* [updateRestrictions](docs/sdks/instance/README.md#updaterestrictions) - Update instance restrictions
* [changeProductionDomain](docs/sdks/instance/README.md#changeproductiondomain) - Update production instance domain
* [updateOrganizationSettings](docs/sdks/instance/README.md#updateorganizationsettings) - Update instance organization settings

### [actors()](docs/sdks/actors/README.md)

* [createToken](docs/sdks/actors/README.md#createtoken) - Create actor token
* [revokeToken](docs/sdks/actors/README.md#revoketoken) - Revoke actor token

### [domains()](docs/sdks/domains/README.md)

* [list](docs/sdks/domains/README.md#list) - List all instance domains
* [add](docs/sdks/domains/README.md#add) - Add a domain
* [delete](docs/sdks/domains/README.md#delete) - Delete a satellite domain
* [update](docs/sdks/domains/README.md#update) - Update a domain

### [webhooks()](docs/sdks/webhooks/README.md)

* [createSvixApp](docs/sdks/webhooks/README.md#createsvixapp) - Create a Svix app
* [deleteSvixApp](docs/sdks/webhooks/README.md#deletesvixapp) - Delete a Svix app
* [generateSvixAuthURL](docs/sdks/webhooks/README.md#generatesvixauthurl) - Create a Svix Dashboard URL

### [jwtTemplates()](docs/sdks/jwttemplates/README.md)

* [list](docs/sdks/jwttemplates/README.md#list) - List all templates
* [create](docs/sdks/jwttemplates/README.md#create) - Create a JWT template
* [get](docs/sdks/jwttemplates/README.md#get) - Retrieve a template
* [update](docs/sdks/jwttemplates/README.md#update) - Update a JWT template
* [delete](docs/sdks/jwttemplates/README.md#delete) - Delete a Template

### [organizations()](docs/sdks/organizations/README.md)

* [list](docs/sdks/organizations/README.md#list) - Get a list of organizations for an instance
* [create](docs/sdks/organizations/README.md#create) - Create an organization
* [get](docs/sdks/organizations/README.md#get) - Retrieve an organization by ID or slug
* [update](docs/sdks/organizations/README.md#update) - Update an organization
* [delete](docs/sdks/organizations/README.md#delete) - Delete an organization
* [mergeMetadata](docs/sdks/organizations/README.md#mergemetadata) - Merge and update metadata for an organization
* [uploadLogo](docs/sdks/organizations/README.md#uploadlogo) - Upload a logo for the organization
* [deleteLogo](docs/sdks/organizations/README.md#deletelogo) - Delete the organization's logo.

### [organizationInvitations()](docs/sdks/organizationinvitations/README.md)

* [create](docs/sdks/organizationinvitations/README.md#create) - Create and send an organization invitation
* [list](docs/sdks/organizationinvitations/README.md#list) - Get a list of organization invitations
* [createBulk](docs/sdks/organizationinvitations/README.md#createbulk) - Bulk create and send organization invitations
* [~~listPending~~](docs/sdks/organizationinvitations/README.md#listpending) - Get a list of pending organization invitations :warning: **Deprecated**
* [get](docs/sdks/organizationinvitations/README.md#get) - Retrieve an organization invitation by ID
* [revoke](docs/sdks/organizationinvitations/README.md#revoke) - Revoke a pending organization invitation

### [organizationMemberships()](docs/sdks/organizationmemberships/README.md)

* [create](docs/sdks/organizationmemberships/README.md#create) - Create a new organization membership
* [list](docs/sdks/organizationmemberships/README.md#list) - Get a list of all members of an organization
* [update](docs/sdks/organizationmemberships/README.md#update) - Update an organization membership
* [delete](docs/sdks/organizationmemberships/README.md#delete) - Remove a member from an organization
* [updateMetadata](docs/sdks/organizationmemberships/README.md#updatemetadata) - Merge and update organization membership metadata

### [proxy()](docs/sdks/proxy/README.md)

* [verifyDomain](docs/sdks/proxy/README.md#verifydomain) - Verify the proxy configuration for your domain

### [redirectURLs()](docs/sdks/redirecturls/README.md)

* [list](docs/sdks/redirecturls/README.md#list) - List all redirect URLs
* [create](docs/sdks/redirecturls/README.md#create) - Create a redirect URL
* [get](docs/sdks/redirecturls/README.md#get) - Retrieve a redirect URL
* [delete](docs/sdks/redirecturls/README.md#delete) - Delete a redirect URL

### [signInTokens()](docs/sdks/signintokens/README.md)

* [create](docs/sdks/signintokens/README.md#create) - Create sign-in token
* [revoke](docs/sdks/signintokens/README.md#revoke) - Revoke the given sign-in token

### [signUps()](docs/sdks/signups/README.md)

* [update](docs/sdks/signups/README.md#update) - Update a sign-up

### [oAuthApplications()](docs/sdks/oauthapplications/README.md)

* [list](docs/sdks/oauthapplications/README.md#list) - Get a list of OAuth applications for an instance
* [create](docs/sdks/oauthapplications/README.md#create) - Create an OAuth application
* [get](docs/sdks/oauthapplications/README.md#get) - Retrieve an OAuth application by ID
* [updateApplication](docs/sdks/oauthapplications/README.md#updateapplication) - Update an OAuth application
* [delete](docs/sdks/oauthapplications/README.md#delete) - Delete an OAuth application
* [rotateSecret](docs/sdks/oauthapplications/README.md#rotatesecret) - Rotate the client secret of the given OAuth application

### [samlConnections()](docs/sdks/samlconnections/README.md)

* [list](docs/sdks/samlconnections/README.md#list) - Get a list of SAML Connections for an instance
* [create](docs/sdks/samlconnections/README.md#create) - Create a SAML Connection
* [get](docs/sdks/samlconnections/README.md#get) - Retrieve a SAML Connection by ID
* [update](docs/sdks/samlconnections/README.md#update) - Update a SAML Connection
* [delete](docs/sdks/samlconnections/README.md#delete) - Delete a SAML Connection

### [testingTokens()](docs/sdks/testingtokens/README.md)

* [create](docs/sdks/testingtokens/README.md#create) - Retrieve a new testing token
<!-- End Available Resources and Operations [operations] -->

<!-- Start Pagination [pagination] -->
## Pagination

Some of the endpoints in this SDK support pagination. To use pagination, you make your SDK calls as usual, but the
returned response object will have a `next` method that can be called to pull down the next group of results. The `next`
function returns an `Optional` value, which `isPresent` until there are no more pages to be fetched.

Here's an example of one such pagination call:
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.components.*;
import com.clerk.backend_api.models.components.Security;
import com.clerk.backend_api.models.operations.*;
import com.clerk.backend_api.utils.EventStream;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;
import static java.util.Map.entry;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            GetClientListResponse res = sdk.clients().list()
                .limit(10L)
                .offset(0L)
                .call();

            while (true) {
                if (res.clientList().isPresent()) {
                    // handle response
                    Optional<GetClientListResponse> nextRes = res.next();
                    if (nextRes.isPresent()) {
                        res = nextRes.get();
                    } else {
                        break;
                    }
                }
            }
        } catch (com.clerk.backend_api.models.errors.ClerkErrors e) {
            // handle exception
            throw e;
        } catch (com.clerk.backend_api.models.errors.SDKError e) {
            // handle exception
            throw e;
        } catch (Exception e) {
            // handle exception
            throw e;
        }
    }
}
```
<!-- End Pagination [pagination] -->

<!-- Start Error Handling [errors] -->
## Error Handling

Handling errors in this SDK should largely match your expectations.  All operations return a response object or raise an error.  If Error objects are specified in your OpenAPI Spec, the SDK will throw the appropriate Exception type.

| Error Object              | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400,401,410,422           | application/json          |
| models/errors/SDKError    | 4xx-5xx                   | */*                       |

### Example

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.components.*;
import com.clerk.backend_api.models.components.Security;
import com.clerk.backend_api.models.operations.*;
import com.clerk.backend_api.utils.EventStream;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;
import static java.util.Map.entry;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            GetClientListResponse res = sdk.clients().list()
                .limit(10L)
                .offset(0L)
                .call();

            while (true) {
                if (res.clientList().isPresent()) {
                    // handle response
                    Optional<GetClientListResponse> nextRes = res.next();
                    if (nextRes.isPresent()) {
                        res = nextRes.get();
                    } else {
                        break;
                    }
                }
            }
        } catch (com.clerk.backend_api.models.errors.ClerkErrors e) {
            // handle exception
            throw e;
        } catch (com.clerk.backend_api.models.errors.SDKError e) {
            // handle exception
            throw e;
        } catch (Exception e) {
            // handle exception
            throw e;
        }
    }
}
```
<!-- End Error Handling [errors] -->

<!-- Start Server Selection [server] -->
## Server Selection

### Select Server by Index

You can override the default server globally by passing a server index to the `serverIndex` builder method when initializing the SDK client instance. The selected server will then be used as the default on the operations that use it. This table lists the indexes associated with the available servers:

| # | Server | Variables |
| - | ------ | --------- |
| 0 | `https://api.clerk.com/v1` | None |

#### Example

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.components.*;
import com.clerk.backend_api.models.operations.*;
import com.clerk.backend_api.utils.EventStream;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;
import static java.util.Map.entry;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .serverIndex(0)
                .build();

            GetPublicInterstitialResponse res = sdk.miscellaneous().getPublicInterstitial()
                .frontendApi("<value>")
                .publishableKey("<value>")
                .call();

            // handle response
        } catch (com.clerk.backend_api.models.errors.SDKError e) {
            // handle exception
            throw e;
        } catch (Exception e) {
            // handle exception
            throw e;
        }
    }
}
```


### Override Server URL Per-Client

The default server can also be overridden globally by passing a URL to the `serverURL` builder method when initializing the SDK client instance. For example:
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.components.*;
import com.clerk.backend_api.models.operations.*;
import com.clerk.backend_api.utils.EventStream;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;
import static java.util.Map.entry;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .serverURL("https://api.clerk.com/v1")
                .build();

            GetPublicInterstitialResponse res = sdk.miscellaneous().getPublicInterstitial()
                .frontendApi("<value>")
                .publishableKey("<value>")
                .call();

            // handle response
        } catch (com.clerk.backend_api.models.errors.SDKError e) {
            // handle exception
            throw e;
        } catch (Exception e) {
            // handle exception
            throw e;
        }
    }
}
```
<!-- End Server Selection [server] -->

<!-- Start Authentication [security] -->
## Authentication

### Per-Client Security Schemes

This SDK supports the following security scheme globally:

| Name         | Type         | Scheme       |
| ------------ | ------------ | ------------ |
| `bearerAuth` | http         | HTTP Bearer  |

To authenticate with the API the `bearerAuth` parameter must be set when initializing the SDK client instance. For example:
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.components.*;
import com.clerk.backend_api.models.operations.*;
import com.clerk.backend_api.utils.EventStream;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;
import static java.util.Map.entry;

public class Application {

    public static void main(String[] args) throws Exception {
        try {
            Clerk sdk = Clerk.builder()
                .bearerAuth("<YOUR_BEARER_TOKEN_HERE>")
                .build();

            GetPublicInterstitialResponse res = sdk.miscellaneous().getPublicInterstitial()
                .frontendApi("<value>")
                .publishableKey("<value>")
                .call();

            // handle response
        } catch (com.clerk.backend_api.models.errors.SDKError e) {
            // handle exception
            throw e;
        } catch (Exception e) {
            // handle exception
            throw e;
        }
    }
}
```
<!-- End Authentication [security] -->

<!-- Placeholder for Future Speakeasy SDK Sections -->

# Development

## Maturity

This SDK is in beta, and there may be breaking changes between versions without a major version update. Therefore, we recommend pinning usage
to a specific package version. This way, you can install the same version each time without breaking changes unless you are intentionally
looking for the latest version.

## Contributions

While we value open-source contributions to this SDK, this library is generated programmatically.
Feel free to open a PR or a Github issue as a proof of concept and we'll do our best to include it in a future release!

### SDK Created by [Speakeasy](https://docs.speakeasyapi.dev/docs/using-speakeasy/client-sdks)
# clerk-sdk-java
