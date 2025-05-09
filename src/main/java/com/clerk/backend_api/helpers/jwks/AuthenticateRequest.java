package com.clerk.backend_api.helpers.jwks;

import io.jsonwebtoken.impl.DefaultClaims;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Claims;

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
    public static final RequestState authenticateRequest(Map<String, List<String>> requestHeaders, AuthenticateRequestOptions options) {

        String sessionToken = getSessionToken(requestHeaders);
        if (sessionToken == null) {
            return RequestState.signedOut(AuthErrorReason.SESSION_TOKEN_MISSING);
        }

        VerifyTokenOptions verifyTokenOptions;

        if (options.jwtKey().isPresent()) {
            verifyTokenOptions = VerifyTokenOptions //
                    .jwtKey(options.jwtKey().get()) //
                    .audience(options.audience()) //
                    .authorizedParties(options.authorizedParties()) //
                    .clockSkew(options.clockSkewInMs(), TimeUnit.MILLISECONDS) //
                    .build();
        } else if (options.secretKey().isPresent()) {
            verifyTokenOptions = VerifyTokenOptions //
                    .secretKey(options.secretKey().get()) //
                    .audience(options.audience()) //
                    .authorizedParties(options.authorizedParties()) //
                    .clockSkew(options.clockSkewInMs(), TimeUnit.MILLISECONDS) //
                    .build();
        } else {
            return RequestState.signedOut(AuthErrorReason.SECRET_KEY_MISSING);
        }

        try {
            Claims claims = VerifyToken.verifyToken(sessionToken, verifyTokenOptions);
            Map<String, Object> updatedClaimsMap = new HashMap<>(claims);

            if ("2".equals(claims.get("v"))) {
                Object orgObject = claims.get("o");
                if (orgObject instanceof Map) {
                    @SuppressWarnings("unchecked")
                    Map<String, Object> claimsMap = (Map<String, Object>) orgObject;

                    updatedClaimsMap.put("org_id", claimsMap.get("id"));
                    updatedClaimsMap.put("org_slug", claimsMap.get("slg"));
                    updatedClaimsMap.put("org_roles", claimsMap.get("rol"));

                    List<String> orgPermissions = computedOrgPermissions(claims);
                    if (!orgPermissions.isEmpty()) {
                        updatedClaimsMap.put("org_permissions", orgPermissions);
                    }
                }
            }

            Claims updatedClaims = new DefaultClaims(updatedClaimsMap);
            return RequestState.signedIn(sessionToken, updatedClaims);
        } catch (TokenVerificationException e) {
            return RequestState.signedOut(e.reason());
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
        if (cookieHeaders != null && !cookieHeaders.isEmpty()) {
            String cookieHeaderValue = cookieHeaders.get(0);
            List<HttpCookie> cookies = HttpCookie.parse(cookieHeaderValue);
            for (HttpCookie cookie : cookies) {
                if (cookie.getName().startsWith(SESSION_COOKIE_NAME)) {
                    return cookie.getValue();
                }
            }
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    private static List<String> computedOrgPermissions(Claims claims) {
        String featuresStr = (String) claims.get("fea");
        String permissionsStr = (String) ((Map<String, Object>) claims.get("o")).get("per");
        String mappingsStr = (String) ((Map<String, Object>) claims.get("o")).get("fpm");

        String[] features = featuresStr.split(",");
        String[] permissions = permissionsStr.split(",");
        String[] mappings = mappingsStr.split(",");

        List<String> orgPermissions = new ArrayList<>();

        for (int idx = 0; idx < mappings.length; idx++) {
            String mapping = mappings[idx];
            String[] featureParts = features[idx].split(":");
            if (featureParts.length != 2) continue;

            String scope = featureParts[0];
            String feature = featureParts[1];

            if (!scope.contains("o")) continue;

            String binary = Integer.toBinaryString(Integer.parseInt(mapping)).replaceAll("^0+", "");
            String reversedBinary = new StringBuilder(binary).reverse().toString();

            for (int i = 0; i < reversedBinary.length(); i++) {
                if (reversedBinary.charAt(i) == '1' && i < permissions.length) {
                    orgPermissions.add("org:" + feature + ":" + permissions[i]);
                }
            }
        }

        return orgPermissions;
    }

}
