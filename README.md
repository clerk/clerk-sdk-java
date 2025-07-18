<div align="center">
        <img src="https://github.com/user-attachments/assets/bdff80ad-42b9-4176-8b35-c05c551f57ac" width="150">
   <p>The most comprehensive User Management Platform</p>
   <a href="https://clerk.com/docs/reference/backend-api"><img src="https://img.shields.io/static/v1?label=Docs&message=API Ref&color=000000&style=for-the-badge" /></a>
  <a href="https://opensource.org/licenses/MIT"><img src="https://img.shields.io/badge/License-MIT-blue.svg?style=for-the-badge" /></a>
</div>
<br></br>

The Clerk Java library provides convenient access to the Clerk REST API from from a Java application. The library includes type definitions for all request params and response fields, and is powered by [Apache Httpclient](https://hc.apache.org/httpcomponents-client-4.5.x/index.html).

<!-- Start Summary [summary] -->
## Summary

Clerk Backend API: The Clerk REST Backend API, meant to be accessed by backend servers.

### Versions

When the API changes in a way that isn't compatible with older versions, a new version is released.
Each version is identified by its release date, e.g. `2025-03-12`. For more information, please see [Clerk API Versions](https://clerk.com/docs/versioning/available-versions).

Please see https://clerk.com/docs for more information.

More information about the API can be found at https://clerk.com/docs
<!-- End Summary [summary] -->

<!-- Start Table of Contents [toc] -->
## Table of Contents
<!-- $toc-max-depth=2 -->
  * [SDK Installation](#sdk-installation)
  * [SDK Example Usage](#sdk-example-usage)
  * [Authentication](#authentication)
  * [Request Authentication](#request-authentication)
  * [Available Resources and Operations](#available-resources-and-operations)
  * [Retries](#retries)
  * [Error Handling](#error-handling)
  * [Server Selection](#server-selection)
  * [Debugging](#debugging)
* [Development](#development)
  * [Contributions](#contributions)

<!-- End Table of Contents [toc] -->

<!-- Start SDK Installation [installation] -->
## SDK Installation

### Getting started

JDK 11 or later is required.

The samples below show how a published SDK artifact is used:

Gradle:
```groovy
implementation 'com.clerk:backend-api:3.1.0'
```

Maven:
```xml
<dependency>
    <groupId>com.clerk</groupId>
    <artifactId>backend-api</artifactId>
    <version>3.1.0</version>
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

### Example

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.operations.GetPublicInterstitialResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Clerk sdk = Clerk.builder()
            .build();

        GetPublicInterstitialResponse res = sdk.miscellaneous().getPublicInterstitial()
                .call();

        // handle response
    }
}
```
<!-- End SDK Example Usage [usage] -->

<!-- Start Authentication [security] -->
## Authentication

### Per-Client Security Schemes

This SDK supports the following security scheme globally:

| Name         | Type | Scheme      |
| ------------ | ---- | ----------- |
| `bearerAuth` | http | HTTP Bearer |

To authenticate with the API the `bearerAuth` parameter must be set when initializing the SDK client instance. For example:
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.operations.GetPublicInterstitialResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        GetPublicInterstitialResponse res = sdk.miscellaneous().getPublicInterstitial()
                .call();

        // handle response
    }
}
```
<!-- End Authentication [security] -->

## Request Authentication

Use the [authenticateRequest](https://github.com/clerk/clerk-sdk-java/blob/main/src/main/java/com/clerk/backend_api/helpers/jwks/AuthenticateRequest.java) method to authenticate a request from your app's frontend (when using a Clerk frontend SDK) to Clerk's Backend API. For example the following utility function checks if the user is effectively signed in:

```java
import java.net.http.HttpRequest;
import com.clerk.backend_api.helpers.security.AuthenticateRequest;
import com.clerk.backend_api.helpers.security.models.AuthenticateRequestOptions;
import com.clerk.backend_api.helpers.security.models.RequestState;

public class UserAuthentication {

    public static boolean isSignedIn(HttpRequest request) {
        RequestState requestState = AuthenticateRequest.authenticateRequest(request, AuthenticateRequestOptions
            .secretKey(System.getenv("CLERK_SECRET_KEY"))
            .authorizedParty("https://example.com")
            .build());
        return requestState.isSignedIn();
    }
```

If the request is correctly authenticated, the token's claims are made available in `requestState.claims()`. Otherwise the reason for the token verification failure is given by `requestState.reason()`.

### Machine Authentication

The SDK also supports machine-to-machine authentication through machine tokens. To authenticate machine requests, specify the accepted token types when building the authentication options:

```java
import java.net.http.HttpRequest;
import com.clerk.backend_api.helpers.security.AuthenticateRequest;
import com.clerk.backend_api.helpers.security.models.AuthenticateRequestOptions;
import com.clerk.backend_api.helpers.security.models.RequestState;
import java.util.Arrays;

public class MachineAuthentication {

    public static boolean isAuthenticated(HttpRequest request) {
        RequestState requestState = AuthenticateRequest.authenticateRequest(request, AuthenticateRequestOptions
            .secretKey(System.getenv("CLERK_SECRET_KEY"))
            .acceptsTokens(Arrays.asList("oauth_token"))
            .build());
        return requestState.isSignedIn();
    }
}
```

<!-- Start Available Resources and Operations [operations] -->
## Available Resources and Operations

<details open>
<summary>Available methods</summary>

### [actorTokens()](docs/sdks/actortokens/README.md)

* [create](docs/sdks/actortokens/README.md#create) - Create actor token
* [revoke](docs/sdks/actortokens/README.md#revoke) - Revoke actor token

### [allowlistIdentifiers()](docs/sdks/allowlistidentifiers/README.md)

* [list](docs/sdks/allowlistidentifiers/README.md#list) - List all identifiers on the allow-list
* [create](docs/sdks/allowlistidentifiers/README.md#create) - Add identifier to the allow-list
* [delete](docs/sdks/allowlistidentifiers/README.md#delete) - Delete identifier from allow-list

### [betaFeatures()](docs/sdks/betafeatures/README.md)

* [updateInstanceSettings](docs/sdks/betafeatures/README.md#updateinstancesettings) - Update instance settings
* [~~updateProductionInstanceDomain~~](docs/sdks/betafeatures/README.md#updateproductioninstancedomain) - Update production instance domain :warning: **Deprecated**

### [blocklistIdentifiers()](docs/sdks/blocklistidentifiers/README.md)

* [list](docs/sdks/blocklistidentifiers/README.md#list) - List all identifiers on the block-list
* [create](docs/sdks/blocklistidentifiers/README.md#create) - Add identifier to the block-list
* [delete](docs/sdks/blocklistidentifiers/README.md#delete) - Delete identifier from block-list


### [clients()](docs/sdks/clients/README.md)

* [~~list~~](docs/sdks/clients/README.md#list) - List all clients :warning: **Deprecated**
* [verify](docs/sdks/clients/README.md#verify) - Verify a client
* [get](docs/sdks/clients/README.md#get) - Get a client

### [domains()](docs/sdks/domains/README.md)

* [list](docs/sdks/domains/README.md#list) - List all instance domains
* [add](docs/sdks/domains/README.md#add) - Add a domain
* [delete](docs/sdks/domains/README.md#delete) - Delete a satellite domain
* [update](docs/sdks/domains/README.md#update) - Update a domain

### [emailAddresses()](docs/sdks/emailaddresses/README.md)

* [create](docs/sdks/emailaddresses/README.md#create) - Create an email address
* [get](docs/sdks/emailaddresses/README.md#get) - Retrieve an email address
* [delete](docs/sdks/emailaddresses/README.md#delete) - Delete an email address
* [update](docs/sdks/emailaddresses/README.md#update) - Update an email address

### [~~emailAndSmsTemplates()~~](docs/sdks/emailandsmstemplates/README.md)

* [~~upsert~~](docs/sdks/emailandsmstemplates/README.md#upsert) - Update a template for a given type and slug :warning: **Deprecated**

### [~~emailSMSTemplates()~~](docs/sdks/emailsmstemplates/README.md)

* [~~list~~](docs/sdks/emailsmstemplates/README.md#list) - List all templates :warning: **Deprecated**
* [~~get~~](docs/sdks/emailsmstemplates/README.md#get) - Retrieve a template :warning: **Deprecated**
* [~~revert~~](docs/sdks/emailsmstemplates/README.md#revert) - Revert a template :warning: **Deprecated**
* [~~toggleTemplateDelivery~~](docs/sdks/emailsmstemplates/README.md#toggletemplatedelivery) - Toggle the delivery by Clerk for a template of a given type and slug :warning: **Deprecated**

### [experimentalAccountlessApplications()](docs/sdks/experimentalaccountlessapplications/README.md)

* [create](docs/sdks/experimentalaccountlessapplications/README.md#create) - Create an accountless application [EXPERIMENTAL]
* [complete](docs/sdks/experimentalaccountlessapplications/README.md#complete) - Complete an accountless application [EXPERIMENTAL]

### [instanceSettings()](docs/sdks/instancesettings/README.md)

* [get](docs/sdks/instancesettings/README.md#get) - Fetch the current instance
* [update](docs/sdks/instancesettings/README.md#update) - Update instance settings
* [updateRestrictions](docs/sdks/instancesettings/README.md#updaterestrictions) - Update instance restrictions
* [changeDomain](docs/sdks/instancesettings/README.md#changedomain) - Update production instance domain
* [updateOrganizationSettings](docs/sdks/instancesettings/README.md#updateorganizationsettings) - Update instance organization settings

### [invitations()](docs/sdks/invitations/README.md)

* [create](docs/sdks/invitations/README.md#create) - Create an invitation
* [list](docs/sdks/invitations/README.md#list) - List all invitations
* [bulkCreate](docs/sdks/invitations/README.md#bulkcreate) - Create multiple invitations
* [revoke](docs/sdks/invitations/README.md#revoke) - Revokes an invitation

### [jwks()](docs/sdks/jwks/README.md)

* [getJWKS](docs/sdks/jwks/README.md#getjwks) - Retrieve the JSON Web Key Set of the instance

### [jwtTemplates()](docs/sdks/jwttemplates/README.md)

* [list](docs/sdks/jwttemplates/README.md#list) - List all templates
* [create](docs/sdks/jwttemplates/README.md#create) - Create a JWT template
* [get](docs/sdks/jwttemplates/README.md#get) - Retrieve a template
* [update](docs/sdks/jwttemplates/README.md#update) - Update a JWT template
* [delete](docs/sdks/jwttemplates/README.md#delete) - Delete a Template

### [miscellaneous()](docs/sdks/miscellaneous/README.md)

* [getPublicInterstitial](docs/sdks/miscellaneous/README.md#getpublicinterstitial) - Returns the markup for the interstitial page

### [oauthApplications()](docs/sdks/oauthapplications/README.md)

* [list](docs/sdks/oauthapplications/README.md#list) - Get a list of OAuth applications for an instance
* [create](docs/sdks/oauthapplications/README.md#create) - Create an OAuth application
* [get](docs/sdks/oauthapplications/README.md#get) - Retrieve an OAuth application by ID
* [update](docs/sdks/oauthapplications/README.md#update) - Update an OAuth application
* [delete](docs/sdks/oauthapplications/README.md#delete) - Delete an OAuth application
* [rotateSecret](docs/sdks/oauthapplications/README.md#rotatesecret) - Rotate the client secret of the given OAuth application

### [organizationDomains()](docs/sdks/organizationdomains/README.md)

* [create](docs/sdks/organizationdomains/README.md#create) - Create a new organization domain.
* [list](docs/sdks/organizationdomains/README.md#list) - Get a list of all domains of an organization.
* [update](docs/sdks/organizationdomains/README.md#update) - Update an organization domain.
* [delete](docs/sdks/organizationdomains/README.md#delete) - Remove a domain from an organization.

### [organizationInvitations()](docs/sdks/organizationinvitations/README.md)

* [getAll](docs/sdks/organizationinvitations/README.md#getall) - Get a list of organization invitations for the current instance
* [create](docs/sdks/organizationinvitations/README.md#create) - Create and send an organization invitation
* [list](docs/sdks/organizationinvitations/README.md#list) - Get a list of organization invitations
* [bulkCreate](docs/sdks/organizationinvitations/README.md#bulkcreate) - Bulk create and send organization invitations
* [~~listPending~~](docs/sdks/organizationinvitations/README.md#listpending) - Get a list of pending organization invitations :warning: **Deprecated**
* [get](docs/sdks/organizationinvitations/README.md#get) - Retrieve an organization invitation by ID
* [revoke](docs/sdks/organizationinvitations/README.md#revoke) - Revoke a pending organization invitation

### [organizationMemberships()](docs/sdks/organizationmemberships/README.md)

* [create](docs/sdks/organizationmemberships/README.md#create) - Create a new organization membership
* [list](docs/sdks/organizationmemberships/README.md#list) - Get a list of all members of an organization
* [update](docs/sdks/organizationmemberships/README.md#update) - Update an organization membership
* [delete](docs/sdks/organizationmemberships/README.md#delete) - Remove a member from an organization
* [updateMetadata](docs/sdks/organizationmemberships/README.md#updatemetadata) - Merge and update organization membership metadata

### [organizations()](docs/sdks/organizations/README.md)

* [list](docs/sdks/organizations/README.md#list) - Get a list of organizations for an instance
* [create](docs/sdks/organizations/README.md#create) - Create an organization
* [get](docs/sdks/organizations/README.md#get) - Retrieve an organization by ID or slug
* [update](docs/sdks/organizations/README.md#update) - Update an organization
* [delete](docs/sdks/organizations/README.md#delete) - Delete an organization
* [mergeMetadata](docs/sdks/organizations/README.md#mergemetadata) - Merge and update metadata for an organization
* [uploadLogo](docs/sdks/organizations/README.md#uploadlogo) - Upload a logo for the organization
* [deleteLogo](docs/sdks/organizations/README.md#deletelogo) - Delete the organization's logo.

### [phoneNumbers()](docs/sdks/phonenumbers/README.md)

* [create](docs/sdks/phonenumbers/README.md#create) - Create a phone number
* [get](docs/sdks/phonenumbers/README.md#get) - Retrieve a phone number
* [delete](docs/sdks/phonenumbers/README.md#delete) - Delete a phone number
* [update](docs/sdks/phonenumbers/README.md#update) - Update a phone number

### [proxyChecks()](docs/sdks/proxychecks/README.md)

* [verify](docs/sdks/proxychecks/README.md#verify) - Verify the proxy configuration for your domain

### [redirectUrls()](docs/sdks/redirecturls/README.md)

* [list](docs/sdks/redirecturls/README.md#list) - List all redirect URLs
* [create](docs/sdks/redirecturls/README.md#create) - Create a redirect URL
* [get](docs/sdks/redirecturls/README.md#get) - Retrieve a redirect URL
* [delete](docs/sdks/redirecturls/README.md#delete) - Delete a redirect URL

### [samlConnections()](docs/sdks/samlconnections/README.md)

* [list](docs/sdks/samlconnections/README.md#list) - Get a list of SAML Connections for an instance
* [create](docs/sdks/samlconnections/README.md#create) - Create a SAML Connection
* [get](docs/sdks/samlconnections/README.md#get) - Retrieve a SAML Connection by ID
* [update](docs/sdks/samlconnections/README.md#update) - Update a SAML Connection
* [delete](docs/sdks/samlconnections/README.md#delete) - Delete a SAML Connection

### [sessions()](docs/sdks/sessions/README.md)

* [list](docs/sdks/sessions/README.md#list) - List all sessions
* [create](docs/sdks/sessions/README.md#create) - Create a new active session
* [get](docs/sdks/sessions/README.md#get) - Retrieve a session
* [refresh](docs/sdks/sessions/README.md#refresh) - Refresh a session
* [revoke](docs/sdks/sessions/README.md#revoke) - Revoke a session
* [~~verify~~](docs/sdks/sessions/README.md#verify) - Verify a session :warning: **Deprecated**
* [createToken](docs/sdks/sessions/README.md#createtoken) - Create a session token
* [createTokenFromTemplate](docs/sdks/sessions/README.md#createtokenfromtemplate) - Create a session token from a jwt template

### [signInTokens()](docs/sdks/signintokens/README.md)

* [create](docs/sdks/signintokens/README.md#create) - Create sign-in token
* [revoke](docs/sdks/signintokens/README.md#revoke) - Revoke the given sign-in token

### [signUps()](docs/sdks/signups/README.md)

* [get](docs/sdks/signups/README.md#get) - Retrieve a sign-up by ID
* [update](docs/sdks/signups/README.md#update) - Update a sign-up

### [~~templates()~~](docs/sdks/templates/README.md)

* [~~preview~~](docs/sdks/templates/README.md#preview) - Preview changes to a template :warning: **Deprecated**

### [testingTokens()](docs/sdks/testingtokens/README.md)

* [create](docs/sdks/testingtokens/README.md#create) - Retrieve a new testing token

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
* [getOrganizationInvitations](docs/sdks/users/README.md#getorganizationinvitations) - Retrieve all invitations for a user
* [verifyPassword](docs/sdks/users/README.md#verifypassword) - Verify the password of a user
* [verifyTotp](docs/sdks/users/README.md#verifytotp) - Verify a TOTP or backup code for a user
* [disableMfa](docs/sdks/users/README.md#disablemfa) - Disable a user's MFA methods
* [deleteBackupCodes](docs/sdks/users/README.md#deletebackupcodes) - Disable all user's Backup codes
* [deletePasskey](docs/sdks/users/README.md#deletepasskey) - Delete a user passkey
* [deleteWeb3Wallet](docs/sdks/users/README.md#deleteweb3wallet) - Delete a user web3 wallet
* [deleteTOTP](docs/sdks/users/README.md#deletetotp) - Delete all the user's TOTPs
* [deleteExternalAccount](docs/sdks/users/README.md#deleteexternalaccount) - Delete External Account
* [getInstanceOrganizationMemberships](docs/sdks/users/README.md#getinstanceorganizationmemberships) - Get a list of all organization memberships within an instance.

### [waitlistEntries()](docs/sdks/waitlistentries/README.md)

* [list](docs/sdks/waitlistentries/README.md#list) - List all waitlist entries
* [create](docs/sdks/waitlistentries/README.md#create) - Create a waitlist entry

### [webhooks()](docs/sdks/webhooks/README.md)

* [createSvixApp](docs/sdks/webhooks/README.md#createsvixapp) - Create a Svix app
* [deleteSvixApp](docs/sdks/webhooks/README.md#deletesvixapp) - Delete a Svix app
* [generateSvixAuthURL](docs/sdks/webhooks/README.md#generatesvixauthurl) - Create a Svix Dashboard URL

</details>
<!-- End Available Resources and Operations [operations] -->

<!-- Start Retries [retries] -->
## Retries

Some of the endpoints in this SDK support retries. If you use the SDK without any configuration, it will fall back to the default retry strategy provided by the API. However, the default retry strategy can be overridden on a per-operation basis, or across the entire SDK.

To change the default retry strategy for a single API call, you can provide a `RetryConfig` object through the `retryConfig` builder method:
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.operations.GetPublicInterstitialResponse;
import com.clerk.backend_api.utils.BackoffStrategy;
import com.clerk.backend_api.utils.RetryConfig;
import java.lang.Exception;
import java.util.concurrent.TimeUnit;

public class Application {

    public static void main(String[] args) throws Exception {

        Clerk sdk = Clerk.builder()
            .build();

        GetPublicInterstitialResponse res = sdk.miscellaneous().getPublicInterstitial()
                .retryConfig(RetryConfig.builder()
                    .backoff(BackoffStrategy.builder()
                        .initialInterval(1L, TimeUnit.MILLISECONDS)
                        .maxInterval(50L, TimeUnit.MILLISECONDS)
                        .maxElapsedTime(1000L, TimeUnit.MILLISECONDS)
                        .baseFactor(1.1)
                        .jitterFactor(0.15)
                        .retryConnectError(false)
                        .build())
                    .build())
                .call();

        // handle response
    }
}
```

If you'd like to override the default retry strategy for all operations that support retries, you can provide a configuration at SDK initialization:
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.operations.GetPublicInterstitialResponse;
import com.clerk.backend_api.utils.BackoffStrategy;
import com.clerk.backend_api.utils.RetryConfig;
import java.lang.Exception;
import java.util.concurrent.TimeUnit;

public class Application {

    public static void main(String[] args) throws Exception {

        Clerk sdk = Clerk.builder()
                .retryConfig(RetryConfig.builder()
                    .backoff(BackoffStrategy.builder()
                        .initialInterval(1L, TimeUnit.MILLISECONDS)
                        .maxInterval(50L, TimeUnit.MILLISECONDS)
                        .maxElapsedTime(1000L, TimeUnit.MILLISECONDS)
                        .baseFactor(1.1)
                        .jitterFactor(0.15)
                        .retryConnectError(false)
                        .build())
                    .build())
            .build();

        GetPublicInterstitialResponse res = sdk.miscellaneous().getPublicInterstitial()
                .call();

        // handle response
    }
}
```
<!-- End Retries [retries] -->

<!-- Start Error Handling [errors] -->
## Error Handling

Handling errors in this SDK should largely match your expectations. All operations return a response object or raise an exception.

By default, an API error will throw a `models/errors/SDKError` exception. When custom error responses are specified for an operation, the SDK may also throw their associated exception. You can refer to respective *Errors* tables in SDK docs for more details on possible exception types for each operation. For example, the `verify` method throws the following exceptions:

| Error Type                | Status Code   | Content Type     |
| ------------------------- | ------------- | ---------------- |
| models/errors/ClerkErrors | 400, 401, 404 | application/json |
| models/errors/SDKError    | 4XX, 5XX      | \*/\*            |

### Example

```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.VerifyClientResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        VerifyClientResponse res = sdk.clients().verify()
                .call();

        if (res.client().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End Error Handling [errors] -->

<!-- Start Server Selection [server] -->
## Server Selection

### Override Server URL Per-Client

The default server can be overridden globally using the `.serverURL(String serverUrl)` builder method when initializing the SDK client instance. For example:
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.operations.GetPublicInterstitialResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Clerk sdk = Clerk.builder()
                .serverURL("https://api.clerk.com/v1")
            .build();

        GetPublicInterstitialResponse res = sdk.miscellaneous().getPublicInterstitial()
                .call();

        // handle response
    }
}
```
<!-- End Server Selection [server] -->


<!-- Start Debugging [debug] -->
## Debugging

### Debug
You can setup your SDK to emit debug logs for SDK requests and responses.

For request and response logging (especially json bodies), call `enableHTTPDebugLogging(boolean)` on the SDK builder like so:
```java
SDK.builder()
    .enableHTTPDebugLogging(true)
    .build();
```
Example output:
```
Sending request: http://localhost:35123/bearer#global GET
Request headers: {Accept=[application/json], Authorization=[******], Client-Level-Header=[added by client], Idempotency-Key=[some-key], x-speakeasy-user-agent=[speakeasy-sdk/java 0.0.1 internal 0.1.0 org.openapis.openapi]}
Received response: (GET http://localhost:35123/bearer#global) 200
Response headers: {access-control-allow-credentials=[true], access-control-allow-origin=[*], connection=[keep-alive], content-length=[50], content-type=[application/json], date=[Wed, 09 Apr 2025 01:43:29 GMT], server=[gunicorn/19.9.0]}
Response body:
{
  "authenticated": true, 
  "token": "global"
}
```
__WARNING__: This should only used for temporary debugging purposes. Leaving this option on in a production system could expose credentials/secrets in logs. <i>Authorization</i> headers are redacted by default and there is the ability to specify redacted header names via `SpeakeasyHTTPClient.setRedactedHeaders`.

__NOTE__: This is a convenience method that calls `HTTPClient.enableDebugLogging()`. The `SpeakeasyHTTPClient` honors this setting. If you are using a custom HTTP client, it is up to the custom client to honor this setting.

Another option is to set the System property `-Djdk.httpclient.HttpClient.log=all`. However, this second option does not log bodies.
<!-- End Debugging [debug] -->

<!-- Placeholder for Future Speakeasy SDK Sections -->

# Development

## Contributions

While we value open-source contributions to this SDK, this library is generated programmatically.
Feel free to open a PR or a Github issue as a proof of concept and we'll do our best to include it in a future release!

### SDK Created by [Speakeasy](https://docs.speakeasyapi.dev/docs/using-speakeasy/client-sdks)
