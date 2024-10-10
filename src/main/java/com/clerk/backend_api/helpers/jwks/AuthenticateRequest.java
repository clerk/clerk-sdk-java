package com.clerk.backend_api.helpers.jwks;

import java.net.HttpCookie;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

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
    public static final RequestState authenticateRequest(HttpRequest request, AuthenticateRequestOptions options) {

        String sessionToken = getSessionToken(request);
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
            VerifyToken.verifyToken(sessionToken, verifyTokenOptions);
        } catch (TokenVerificationException e) {
            return RequestState.signedOut(e.reason());
        }

        return RequestState.signedIn(sessionToken);
    }

    /**
     * Retrieve token from __session cookie or Authorization header.
     *
     * @param request The HTTP request
     * @return The session token, if present
     */
    private static String getSessionToken(HttpRequest request) {
        HttpHeaders headers = request.headers();

        Optional<String> bearerToken = headers.firstValue("Authorization");
        if (bearerToken.isPresent()) {
            return bearerToken.get().replace("Bearer ", "");
        }

        Optional<String> cookieHeader = headers.firstValue("cookie");
        if (cookieHeader.isPresent()) {
            String cookieHeaderValue = cookieHeader.get();
            List<HttpCookie> cookies = HttpCookie.parse(cookieHeaderValue);
            for (HttpCookie cookie : cookies) {
                if (SESSION_COOKIE_NAME.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }

        return null;
    }
}
