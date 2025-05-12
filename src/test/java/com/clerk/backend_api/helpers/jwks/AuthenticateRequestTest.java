package com.clerk.backend_api.helpers.jwks;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.impl.DefaultClaims;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.mockStatic;

public class AuthenticateRequestTest {

    private static final String TOKEN = "test.token.jwt";

    // Not a real secret key or JWT key, just for testing purposes
    private static final String SECRET_KEY = "sk_test_6Jwl18HHksrCusf88SaAczZywHzlcvGA3YQspKt53v";
    private static final String JWT_KEY = "-----BEGIN PUBLIC KEY-----\nMIIBIjANBgkqh...\n-----END PUBLIC KEY-----";

    private static final String ISSUER = "https://api.clerk.com";
    private static final String AUDIENCE = "test-client-id";

    private AuthenticateRequestOptions createOptionsWithSecret() {
        return new AuthenticateRequestOptions(
            Optional.of(SECRET_KEY),
            Optional.empty(),
            Optional.of(AUDIENCE),
            Set.of(AUDIENCE),
            Optional.of(5000L)
        );
    }

    private AuthenticateRequestOptions createOptionsWithJwtKey() {
        return new AuthenticateRequestOptions(
            Optional.empty(),
            Optional.of(JWT_KEY),
            Optional.of(AUDIENCE),
            Set.of(AUDIENCE),
            Optional.of(5000L)
        );
    }

    private Claims buildClaimsWithOrg(Map<String, Object> org, String fea, String fpm, String per) {
        Map<String, Object> claimsMap = new HashMap<>();
        claimsMap.put("iss", ISSUER);
        claimsMap.put("aud", AUDIENCE);
        claimsMap.put("sub", "user_123");
        claimsMap.put("sid", "sid_123");
        claimsMap.put("iat", System.currentTimeMillis() / 1000);
        claimsMap.put("exp", System.currentTimeMillis() / 1000 + 3600);
        claimsMap.put("v", "2");
        claimsMap.put("fea", fea);
        org.put("fpm", fpm);
        org.put("per", per);
        claimsMap.put("o", org);
        return new DefaultClaims(claimsMap);
    }

    private Claims buildClaimsWithoutOrg() {
        Map<String, Object> claimsMap = new HashMap<>();
        claimsMap.put("iss", ISSUER);
        claimsMap.put("aud", AUDIENCE);
        claimsMap.put("sub", "user_123");
        claimsMap.put("sid", "sid_123");
        claimsMap.put("iat", System.currentTimeMillis() / 1000);
        claimsMap.put("exp", System.currentTimeMillis() / 1000 + 3600);
        return new DefaultClaims(claimsMap);
    }

    @Test
    void testAuthenticateWithJwtKey_ValidClaimsWithoutOrg() {
        Map<String, List<String>> headers = Map.of("cookie", List.of("__session=" + TOKEN));

        Claims claims = buildClaimsWithoutOrg();

        try (MockedStatic<VerifyToken> mocked = mockStatic(VerifyToken.class)) {
            mocked.when(() -> VerifyToken.verifyToken(eq(TOKEN), any()))
                .thenReturn(claims);

            RequestState result = AuthenticateRequest.authenticateRequest(headers, createOptionsWithJwtKey());

            assertTrue(result.isSignedIn());
            Claims resultClaims = result.claims().get();

            assertEquals("user_123", resultClaims.getSubject());
            assertEquals(ISSUER, resultClaims.getIssuer());
            assertTrue(resultClaims.getAudience().contains(AUDIENCE));
        }
    }

    @Test
    void testAuthenticateWithSecretKey_ValidClaimsWithoutOrg() {
        Map<String, List<String>> headers = Map.of("Authorization", List.of("Bearer " + TOKEN));

        Claims claims = buildClaimsWithoutOrg();

        try (MockedStatic<VerifyToken> mocked = mockStatic(VerifyToken.class)) {
            mocked.when(() -> VerifyToken.verifyToken(eq(TOKEN), any()))
                .thenReturn(claims);

            RequestState result = AuthenticateRequest.authenticateRequest(headers, createOptionsWithSecret());

            assertTrue(result.isSignedIn());
            Claims resultClaims = result.claims().get();

            assertEquals("user_123", resultClaims.getSubject());
            assertEquals(ISSUER, resultClaims.getIssuer());
            assertTrue(resultClaims.getAudience().contains(AUDIENCE));
        }
    }

    @Test
    void testAuthenticateWithSecretKey_ValidClaims() {
        Map<String, List<String>> headers = Map.of("Authorization", List.of("Bearer " + TOKEN));

        Map<String, Object> org = new HashMap<>();
        org.put("id", "org_001");
        org.put("slg", "org-slug");
        org.put("rol", "admin");
        Claims claims = buildClaimsWithOrg(org, "o:billing,o:invoices", "3,1", "read,write");

        try (MockedStatic<VerifyToken> mocked = mockStatic(VerifyToken.class)) {
            mocked.when(() -> VerifyToken.verifyToken(eq(TOKEN), any()))
                .thenReturn(claims);

            RequestState result = AuthenticateRequest.authenticateRequest(headers, createOptionsWithSecret());

            assertTrue(result.isSignedIn());
            Claims resultClaims = result.claims().get();

            assertEquals("org_001", resultClaims.get("org_id"));
            assertEquals("org-slug", resultClaims.get("org_slug"));
            assertEquals("admin", resultClaims.get("org_role"));
            assertEquals(ISSUER, resultClaims.getIssuer());
            assertTrue(resultClaims.getAudience().contains(AUDIENCE));

            List<String> permissions = (List<String>) resultClaims.get("org_permissions");
            assertNotNull(permissions);
            assertTrue(permissions.contains("org:billing:read"));
        }
    }

    @Test
    void testAuthenticateWithSecretKey_ValidClaims_NoFeatureSet() {
        Map<String, List<String>> headers = Map.of("Authorization", List.of("Bearer " + TOKEN));

        Map<String, Object> org = new HashMap<>();
        org.put("id", "org_abc");
        org.put("slg", "slug-abc");
        org.put("rol", "editor");
        Claims claims = buildClaimsWithOrg(org, null, null, null);

        try (MockedStatic<VerifyToken> mocked = mockStatic(VerifyToken.class)) {
            mocked.when(() -> VerifyToken.verifyToken(eq(TOKEN), any()))
                .thenReturn(claims);

            RequestState result = AuthenticateRequest.authenticateRequest(headers, createOptionsWithSecret());

            assertTrue(result.isSignedIn());
            Claims resultClaims = result.claims().get();

            assertEquals("org_abc", resultClaims.get("org_id"));
            assertEquals("slug-abc", resultClaims.get("org_slug"));
            assertEquals("editor", resultClaims.get("org_role"));
            assertEquals(ISSUER, resultClaims.getIssuer());
            assertTrue(resultClaims.getAudience().contains(AUDIENCE));

            List<String> permissions = (List<String>) resultClaims.get("org_permissions");
            assertNull(permissions);
        }
    }

    @Test
    void testAuthenticateWithJwtKey_ValidClaims() {
        Map<String, List<String>> headers = Map.of("cookie", List.of("__session=" + TOKEN));

        Map<String, Object> org = new HashMap<>();
        org.put("id", "org_abc");
        org.put("slg", "slug-abc");
        org.put("rol", "editor");
        Claims claims = buildClaimsWithOrg(org, "o:settings", "1", "view,delete");

        try (MockedStatic<VerifyToken> mocked = mockStatic(VerifyToken.class)) {
            mocked.when(() -> VerifyToken.verifyToken(eq(TOKEN), any()))
                .thenReturn(claims);

            RequestState result = AuthenticateRequest.authenticateRequest(headers, createOptionsWithJwtKey());

            assertTrue(result.isSignedIn());
            Claims resultClaims = result.claims().get();

            assertEquals("org_abc", resultClaims.get("org_id"));
            assertEquals("slug-abc", resultClaims.get("org_slug"));
            assertEquals("editor", resultClaims.get("org_role"));
            assertEquals(ISSUER, resultClaims.getIssuer());
            assertTrue(resultClaims.getAudience().contains(AUDIENCE));

            List<String> permissions = (List<String>) resultClaims.get("org_permissions");
            assertNotNull(permissions);
            assertTrue(permissions.contains("org:settings:view"));
        }
    }

    @Test
    void testAuthenticateFails_MissingSessionToken() {
        Map<String, List<String>> headers = Map.of();
        RequestState result = AuthenticateRequest.authenticateRequest(headers, createOptionsWithSecret());
        assertTrue(result.isSignedOut());
        assertEquals(AuthErrorReason.SESSION_TOKEN_MISSING, result.reason().get());
    }

    @Test
    void testAuthenticateFails_MissingKey() {
        Map<String, List<String>> headers = Map.of("Authorization", List.of("Bearer " + TOKEN));
        AuthenticateRequestOptions options = new AuthenticateRequestOptions(
            Optional.empty(),
            Optional.empty(),
            Optional.of(AUDIENCE),
            Set.of(),
            Optional.of(5000L)
        );

        RequestState result = AuthenticateRequest.authenticateRequest(headers, options);
        assertTrue(result.isSignedOut());
        assertEquals(AuthErrorReason.SECRET_KEY_MISSING, result.reason().get());
    }

    @Test
    void testAuthenticateFails_TokenVerificationError() {
        Map<String, List<String>> headers = Map.of("Authorization", List.of("Bearer " + TOKEN));

        try (MockedStatic<VerifyToken> mocked = mockStatic(VerifyToken.class)) {
            mocked.when(() -> VerifyToken.verifyToken(eq(TOKEN), any()))
                .thenThrow(new TokenVerificationException(TokenVerificationErrorReason.TOKEN_EXPIRED));

            RequestState result = AuthenticateRequest.authenticateRequest(headers, createOptionsWithSecret());

            assertTrue(result.isSignedOut());
            assertEquals(TokenVerificationErrorReason.TOKEN_EXPIRED, result.reason().get());
        }
    }
}
