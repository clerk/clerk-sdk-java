package com.clerk.backend_api.helpers.jwks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

public class AuthenticateRequestTest {

    private static Optional<String> secretKey = Optional.empty();
    private static Optional<String> jwtKey = Optional.empty();
    private static Optional<String> sessionToken = Optional.empty();
    private static String requestUrl = "http://localhost:3000";
    private static Set<String> authorizedParties = Set.of("http://localhost:3000");
    private static Optional<String> audience = Optional.empty();

    @BeforeAll
    static void setupAll() {
        boolean skippedTests = false;

        String token = System.getenv("CLERK_SESSION_TOKEN");
        if (token != null) {
            sessionToken = Optional.of(token);
        } else {
            skippedTests = true;
            System.out.println("WARNING: CLERK_SESSION_TOKEN is not set");
        }

        String clerkSecretKey = System.getenv("CLERK_SECRET_KEY");
        if (clerkSecretKey != null) {
            secretKey = Optional.of(clerkSecretKey);
        } else {
            skippedTests = true;
            System.out.println("WARNING: CLERK_SECRET_KEY is not set");
        }

        String clerkJwtKey = System.getenv("CLERK_JWT_KEY");
        if (clerkJwtKey != null) {
            jwtKey = Optional.of(clerkJwtKey);
        } else {
            skippedTests = true;
            System.out.println("WARNING: CLERK_JWT_KEY is not set");
        }

        if (skippedTests) {
            System.out.println("WARNING: some tests are skipped due to missing environment variables.");
        }
    }

    private static void assertRequestState(RequestState state, String token) {
        if (state.isSignedIn()) {
            assertTrue(state.reason().isEmpty());
            assertEquals(token, state.token().get());
            assertTrue(state.claims().isPresent());
            assertTrue(state.claims().get().getSubject().contains("user_"));

        } else {
            assertTrue(state.isSignedOut());
            assertEquals(TokenVerificationErrorReason.TOKEN_EXPIRED, state.reason().get());
            assertTrue(state.token().isEmpty());
            assertTrue(state.claims().isEmpty());
            System.out.println("WARNING: the provided session token is expired.");
        }
    }

    @Test
    public void testAuthenticateRequestNoSessionToken() throws URISyntaxException {
        AuthenticateRequestOptions arOptions = AuthenticateRequestOptions //
                .secretKey("sk_test_SecretKey") //
                .build();

        HttpRequest request = HttpRequest.newBuilder() //
                .uri(new URI(requestUrl)) //
                .GET() //
                .build(); //

        RequestState state = AuthenticateRequest.authenticateRequest(request, arOptions);
        assertTrue(state.isSignedOut());
        assertEquals(AuthErrorReason.SESSION_TOKEN_MISSING, state.reason().get());
        assertTrue(state.token().isEmpty());
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "CLERK_SECRET_KEY", matches = ".+")
    @EnabledIfEnvironmentVariable(named = "CLERK_SESSION_TOKEN", matches = ".+")
    public void testAuthenticateRequestCookie() throws URISyntaxException {
        String token = sessionToken.get();

        AuthenticateRequestOptions arOptions = AuthenticateRequestOptions //
                .secretKey(secretKey.get()) //
                .authorizedParties(authorizedParties) //
                .audience(audience) //
                .build();

        HttpRequest request = HttpRequest.newBuilder() //
                .uri(new URI(requestUrl)) //
                .header("Cookie", "__session=" + token) //
                .GET() //
                .build(); //

        RequestState state = AuthenticateRequest.authenticateRequest(request, arOptions);
        assertRequestState(state, token);
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "CLERK_SECRET_KEY", matches = ".+")
    @EnabledIfEnvironmentVariable(named = "CLERK_SESSION_TOKEN", matches = ".+")
    public void testAuthenticateRequestBearer() throws URISyntaxException {
        String token = sessionToken.get();

        AuthenticateRequestOptions arOptions = AuthenticateRequestOptions //
                .secretKey(secretKey.get()) //
                .authorizedParties(authorizedParties) //
                .audience(audience) //
                .build();

        HttpRequest request = HttpRequest.newBuilder() //
                .uri(new URI(requestUrl)) //
                .header("Authorization", "Bearer " + token) //
                .GET() //
                .build(); //

        RequestState state = AuthenticateRequest.authenticateRequest(request, arOptions);
        assertRequestState(state, token);
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "CLERK_JWT_KEY", matches = ".+")
    @EnabledIfEnvironmentVariable(named = "CLERK_SESSION_TOKEN", matches = ".+")
    public void testAuthenticateRequestLocal() throws URISyntaxException {
        String token = sessionToken.get();

        AuthenticateRequestOptions arOptions = AuthenticateRequestOptions //
                .jwtKey(jwtKey.get()) //
                .authorizedParties(authorizedParties) //
                .audience(audience) //
                .build();

        HttpRequest request = HttpRequest.newBuilder() //
                .uri(new URI(requestUrl)) //
                .header("Authorization", "Bearer " + token) //
                .GET() //
                .build(); //

        RequestState state = AuthenticateRequest.authenticateRequest(request, arOptions);
        assertRequestState(state, token);
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "CLERK_SESSION_TOKEN", matches = ".+")
    public void testAuthenticateRequestNoSecretKey() throws URISyntaxException {
        String token = sessionToken.get();

        AuthenticateRequestOptions arOptions = new AuthenticateRequestOptions(Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Set.of(),
                Optional.empty());

        HttpRequest request = HttpRequest.newBuilder() //
                .uri(new URI(requestUrl)) //
                .header("Authorization", "Bearer " + token) //
                .GET() //
                .build(); //

        RequestState state = AuthenticateRequest.authenticateRequest(request, arOptions);
        assertTrue(state.isSignedOut());
        assertEquals(AuthErrorReason.SECRET_KEY_MISSING, state.reason().get());
        assertTrue(state.token().isEmpty());
    }

}
