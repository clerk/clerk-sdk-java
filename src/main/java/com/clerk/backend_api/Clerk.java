/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api;

import com.clerk.backend_api.models.operations.SDKMethodInterfaces.*;
import com.clerk.backend_api.utils.HTTPClient;
import com.clerk.backend_api.utils.RetryConfig;
import com.clerk.backend_api.utils.SpeakeasyHTTPClient;
import java.lang.String;
import java.util.Map;
import java.util.Optional;

/**
 * Clerk Backend API: The Clerk REST Backend API, meant to be accessed by backend
 * servers.
 * 
 * ### Versions
 * 
 * When the API changes in a way that isn't compatible with older versions, a new version is released.
 * Each version is identified by its release date, e.g. `2021-02-05`. For more information, please see [Clerk API Versions](https://clerk.com/docs/backend-requests/versioning/overview).
 * 
 * 
 * Please see https://clerk.com/docs for more information.
 * https://clerk.com/docs
 */
public class Clerk {


    /**
     * SERVERS contains the list of server urls available to the SDK.
     */
    public static final String[] SERVERS = {
        "https://api.clerk.com/v1",
    };

    private final Miscellaneous miscellaneous;

    private final Jwks jwks;

    private final Clients clients;

    private final EmailAddresses emailAddresses;

    private final PhoneNumbers phoneNumbers;

    private final Sessions sessions;

    private final Templates templates;

    private final Users users;

    private final Invitations invitations;

    private final Allowlist allowlist;

    private final Blocklist blocklist;

    private final Instance instance;

    private final Actors actors;

    private final Domains domains;

    private final Webhooks webhooks;

    private final JwtTemplates jwtTemplates;

    private final Organizations organizations;

    private final OrganizationInvitations organizationInvitations;

    private final OrganizationMemberships organizationMemberships;

    private final Proxy proxy;

    private final RedirectURLs redirectURLs;

    private final SignInTokens signInTokens;

    private final SignUps signUps;

    private final OAuthApplications oAuthApplications;

    private final SamlConnections samlConnections;

    private final TestingTokens testingTokens;

    public Miscellaneous miscellaneous() {
        return miscellaneous;
    }

    public Jwks jwks() {
        return jwks;
    }

    public Clients clients() {
        return clients;
    }

    public EmailAddresses emailAddresses() {
        return emailAddresses;
    }

    public PhoneNumbers phoneNumbers() {
        return phoneNumbers;
    }

    public Sessions sessions() {
        return sessions;
    }

    public Templates templates() {
        return templates;
    }

    public Users users() {
        return users;
    }

    public Invitations invitations() {
        return invitations;
    }

    public Allowlist allowlist() {
        return allowlist;
    }

    public Blocklist blocklist() {
        return blocklist;
    }

    public Instance instance() {
        return instance;
    }

    public Actors actors() {
        return actors;
    }

    public Domains domains() {
        return domains;
    }

    public Webhooks webhooks() {
        return webhooks;
    }

    public JwtTemplates jwtTemplates() {
        return jwtTemplates;
    }

    public Organizations organizations() {
        return organizations;
    }

    public OrganizationInvitations organizationInvitations() {
        return organizationInvitations;
    }

    public OrganizationMemberships organizationMemberships() {
        return organizationMemberships;
    }

    public Proxy proxy() {
        return proxy;
    }

    public RedirectURLs redirectURLs() {
        return redirectURLs;
    }

    public SignInTokens signInTokens() {
        return signInTokens;
    }

    public SignUps signUps() {
        return signUps;
    }

    public OAuthApplications oAuthApplications() {
        return oAuthApplications;
    }

    public SamlConnections samlConnections() {
        return samlConnections;
    }

    public TestingTokens testingTokens() {
        return testingTokens;
    }

    private final SDKConfiguration sdkConfiguration;

    /**
     * The Builder class allows the configuration of a new instance of the SDK.
     */
    public static class Builder {

        private final SDKConfiguration sdkConfiguration = new SDKConfiguration();

        private Builder() {
        }

        /**
         * Allows the default HTTP client to be overridden with a custom implementation.
         *
         * @param client The HTTP client to use for all requests.
         * @return The builder instance.
         */
        public Builder client(HTTPClient client) {
            this.sdkConfiguration.defaultClient = client;
            return this;
        }
        /**
         * Configures the SDK security to use the provided secret.
         *
         * @param bearerAuth The secret to use for all requests.
         * @return The builder instance.
         */
        public Builder bearerAuth(String bearerAuth) {
            this.sdkConfiguration.securitySource = SecuritySource.of(com.clerk.backend_api.models.components.Security.builder()
              .bearerAuth(bearerAuth)
              .build());
            return this;
        }

        /**
         * Configures the SDK to use a custom security source.
         * @param securitySource The security source to use for all requests.
         * @return The builder instance.
         */
        public Builder securitySource(SecuritySource securitySource) {
            this.sdkConfiguration.securitySource = securitySource;
            return this;
        }
        
        /**
         * Overrides the default server URL.
         *
         * @param serverUrl The server URL to use for all requests.
         * @return The builder instance.
         */
        public Builder serverURL(String serverUrl) {
            this.sdkConfiguration.serverUrl = serverUrl;
            return this;
        }

        /**
         * Overrides the default server URL  with a templated URL populated with the provided parameters.
         *
         * @param serverUrl The server URL to use for all requests.
         * @param params The parameters to use when templating the URL.
         * @return The builder instance.
         */
        public Builder serverURL(String serverUrl, Map<String, String> params) {
            this.sdkConfiguration.serverUrl = com.clerk.backend_api.utils.Utils.templateUrl(serverUrl, params);
            return this;
        }
        
        /**
         * Overrides the default server by index.
         *
         * @param serverIdx The server to use for all requests.
         * @return The builder instance.
         */
        public Builder serverIndex(int serverIdx) {
            this.sdkConfiguration.serverIdx = serverIdx;
            this.sdkConfiguration.serverUrl = SERVERS[serverIdx];
            return this;
        }
        
        /**
         * Overrides the default configuration for retries
         *
         * @param retryConfig The retry configuration to use for all requests.
         * @return The builder instance.
         */
        public Builder retryConfig(RetryConfig retryConfig) {
            this.sdkConfiguration.retryConfig = Optional.of(retryConfig);
            return this;
        }
        // Visible for testing, will be accessed via reflection
        void _hooks(com.clerk.backend_api.utils.Hooks hooks) {
            sdkConfiguration.setHooks(hooks);    
        }
        
        /**
         * Builds a new instance of the SDK.
         * @return The SDK instance.
         */
        public Clerk build() {
            if (sdkConfiguration.defaultClient == null) {
                sdkConfiguration.defaultClient = new SpeakeasyHTTPClient();
            }
	        if (sdkConfiguration.securitySource == null) {
	    	    sdkConfiguration.securitySource = SecuritySource.of(null);
	        }
            if (sdkConfiguration.serverUrl == null || sdkConfiguration.serverUrl.isBlank()) {
                sdkConfiguration.serverUrl = SERVERS[0];
                sdkConfiguration.serverIdx = 0;
            }
            if (sdkConfiguration.serverUrl.endsWith("/")) {
                sdkConfiguration.serverUrl = sdkConfiguration.serverUrl.substring(0, sdkConfiguration.serverUrl.length() - 1);
            }
            return new Clerk(sdkConfiguration);
        }
    }
    
    /**
     * Get a new instance of the SDK builder to configure a new instance of the SDK.
     * @return The SDK builder instance.
     */
    public static Builder builder() {
        return new Builder();
    }

    private Clerk(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
        this.miscellaneous = new Miscellaneous(sdkConfiguration);
        this.jwks = new Jwks(sdkConfiguration);
        this.clients = new Clients(sdkConfiguration);
        this.emailAddresses = new EmailAddresses(sdkConfiguration);
        this.phoneNumbers = new PhoneNumbers(sdkConfiguration);
        this.sessions = new Sessions(sdkConfiguration);
        this.templates = new Templates(sdkConfiguration);
        this.users = new Users(sdkConfiguration);
        this.invitations = new Invitations(sdkConfiguration);
        this.allowlist = new Allowlist(sdkConfiguration);
        this.blocklist = new Blocklist(sdkConfiguration);
        this.instance = new Instance(sdkConfiguration);
        this.actors = new Actors(sdkConfiguration);
        this.domains = new Domains(sdkConfiguration);
        this.webhooks = new Webhooks(sdkConfiguration);
        this.jwtTemplates = new JwtTemplates(sdkConfiguration);
        this.organizations = new Organizations(sdkConfiguration);
        this.organizationInvitations = new OrganizationInvitations(sdkConfiguration);
        this.organizationMemberships = new OrganizationMemberships(sdkConfiguration);
        this.proxy = new Proxy(sdkConfiguration);
        this.redirectURLs = new RedirectURLs(sdkConfiguration);
        this.signInTokens = new SignInTokens(sdkConfiguration);
        this.signUps = new SignUps(sdkConfiguration);
        this.oAuthApplications = new OAuthApplications(sdkConfiguration);
        this.samlConnections = new SamlConnections(sdkConfiguration);
        this.testingTokens = new TestingTokens(sdkConfiguration);
        this.sdkConfiguration.initialize();
    }}
