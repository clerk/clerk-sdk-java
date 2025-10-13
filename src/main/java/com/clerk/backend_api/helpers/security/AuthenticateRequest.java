package com.clerk.backend_api.helpers.security;

import com.clerk.backend_api.helpers.security.models.AuthErrorReason;
import com.clerk.backend_api.helpers.security.models.AuthenticateRequestOptions;
import com.clerk.backend_api.helpers.security.models.RequestState;
import com.clerk.backend_api.helpers.security.models.TokenType;
import com.clerk.backend_api.helpers.security.models.TokenVerificationException;
import com.clerk.backend_api.helpers.security.models.TokenVerificationResponse;
import com.clerk.backend_api.helpers.security.models.VerifyTokenOptions;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.clerk.backend_api.helpers.security.util.TokenTypeHelper.getTokenType;

/**
 * AuthenticateRequest - Helper methods to authenticate requests.
 */
public final class AuthenticateRequest {

    private static final String SESSION_COOKIE_NAME = "__session";

    private AuthenticateRequest() {
        // prevent instantiation (this is a utility class)
    }

    /**
     * Checks if the HTTP request is authenticated.
     *
     * First the session token is retrieved from either the __session cookie
     * or the HTTP Authorization header.
     * Then the session token is verified: networklessly if the options.jwtKey
     * is provided, otherwise by fetching the JWKS from Clerk's Backend API.
     *
     * @param options The request authentication options
     * @return The request state.
     *
     *         WARNING: authenticateRequest is applicable in the context of Backend
     *         APIs only.
     */
    public static RequestState authenticateRequest(Map<String, List<String>> requestHeaders, AuthenticateRequestOptions options) {

        String sessionToken = getSessionToken(requestHeaders);
        if (sessionToken == null) {
            return RequestState.signedOut(AuthErrorReason.SESSION_TOKEN_MISSING);        }


        List<String> acceptsTokens = options.acceptsToken();
        TokenType tokenType = getTokenType(sessionToken);

        if (!acceptsTokens.contains(tokenType.getType()) && !acceptsTokens.contains("any")) {
            return RequestState.signedOut(AuthErrorReason.TOKEN_TYPE_NOT_SUPPORTED);
        }

        VerifyTokenOptions verifyTokenOptions = buildVerifyTokenOptions(options);

        try {
            TokenVerificationResponse<?> tokenVerificationResponse = VerifyToken.verifyToken(sessionToken, verifyTokenOptions);
            return RequestState.signedIn(sessionToken, tokenVerificationResponse);
        } catch (TokenVerificationException e) {
            return RequestState.signedOut(e.reason());
        } catch (IOException | InterruptedException e) {
            return RequestState.signedOut(AuthErrorReason.INTERNAL_ERROR);
        }

    }

    /**
     * Retrieve token from __session cookie or Authorization header.
     *
     * @param request The HTTP request
     * @return The session token, if present
     */
    private static String getSessionToken(Map<String, List<String>> requestHeaders) {

        Map<String, List<String>> lowerCaseHeaders = requestHeaders.entrySet().stream()
                .collect(HashMap::new, (m, e) -> m.put(e.getKey().toLowerCase(), e.getValue()), HashMap::putAll);
        List<String> authHeaders = lowerCaseHeaders.get("authorization");
        if (authHeaders != null && !authHeaders.isEmpty()) {
            String bearerToken = authHeaders.get(0);
            return bearerToken.replace("Bearer ", "");
        }

        List<String> cookieHeaders = lowerCaseHeaders.get("cookie");
        if (cookieHeaders == null || cookieHeaders.isEmpty()) {
            return null;
        }
        return Arrays.stream(cookieHeaders.get(0).split(";"))
                .map(String::trim)
                .map(s -> s.split("=", 2))       // ["name","value"]
                .filter(kv -> kv[0].startsWith("__session"))
                .map(kv -> kv[1])
                .findFirst()
                .orElse(null);
    }



    private static VerifyTokenOptions buildVerifyTokenOptions(AuthenticateRequestOptions options) {
        if (options.jwtKey().isPresent()) {
            return VerifyTokenOptions //
                    .jwtKey(options.jwtKey().get()) //
                    .audience(options.audience()) //
                    .authorizedParties(options.authorizedParties()) //
                    .clockSkew(options.clockSkewInMs(), TimeUnit.MILLISECONDS) //
                    .skipJwksCache(options.skipJwksCache()) //
                    .build();
        } else if (options.secretKey().isPresent()) {
            return VerifyTokenOptions //
                    .secretKey(options.secretKey().get()) //
                    .audience(options.audience()) //
                    .authorizedParties(options.authorizedParties()) //
                    .clockSkew(options.clockSkewInMs(), TimeUnit.MILLISECONDS) //
                    .skipJwksCache(options.skipJwksCache()) //
                    .build();
        }
        else if (options.machineSecretKey().isPresent()) {
            return VerifyTokenOptions
                .machineSecretKey(options.machineSecretKey().get())
                .audience(options.audience())
                .authorizedParties(options.authorizedParties())
                .clockSkew(options.clockSkewInMs(), TimeUnit.MILLISECONDS)
                .skipJwksCache(options.skipJwksCache()) //
                .build();
        }
        else {
            return new VerifyTokenOptions.Builder().build();
        }
    }

}
