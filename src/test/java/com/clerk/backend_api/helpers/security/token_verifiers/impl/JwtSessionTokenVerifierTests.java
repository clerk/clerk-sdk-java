package com.clerk.backend_api.helpers.security.token_verifiers.impl;

import com.clerk.backend_api.helpers.security.models.TokenVerificationErrorReason;
import com.clerk.backend_api.helpers.security.models.TokenVerificationException;
import com.clerk.backend_api.helpers.security.models.TokenVerificationResponse;
import com.clerk.backend_api.helpers.security.models.VerifyTokenOptions;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPublicKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

class JwtSessionTokenVerifierTest {

    private Key privateKey;
    private RSAPublicKey publicKey;
    private String pemPublicKey;
    private HttpClient mockHttpClient;
    private HttpResponse<String> mockHttpResponse;
    private AutoCloseable mocks;

    @BeforeEach
    void setUp() throws Exception {

        mocks = MockitoAnnotations.openMocks(this);
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        privateKey = keyPair.getPrivate();
        publicKey = (RSAPublicKey) keyPair.getPublic();

        byte[] encoded = publicKey.getEncoded();
        String base64Encoded = Base64.getEncoder().encodeToString(encoded);
        pemPublicKey = "-----BEGIN PUBLIC KEY-----\n" + base64Encoded + "\n-----END PUBLIC KEY-----";

        mockHttpClient = mock(HttpClient.class);
        mockHttpResponse = mock(HttpResponse.class);
    }

    @AfterEach
    void tearDown() throws Exception {
        if (mocks != null) {
            mocks.close();
        }
    }

    @Test
    void verify_WithValidTokenAndLocalKey_ShouldReturnClaims() throws Exception {
        // Arrange
        String subject = "user_123";
        String issuer = "https://clerk.test";
        Date issuedAt = new Date();
        Date expiration = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));

        String token = createToken(subject, issuer, issuedAt, expiration, null);

        VerifyTokenOptions options = VerifyTokenOptions
            .jwtKey(pemPublicKey)
            .build();

        // Act
        TokenVerificationResponse<Claims> result = JwtSessionTokenVerifier.verify(token, options);

        // Assert
        assertNotNull(result);
        Claims claims = result.payload();
        assertEquals(subject, claims.getSubject());
        assertEquals(issuer, claims.getIssuer());
        assertEquals(issuedAt.getTime() / 1000, claims.getIssuedAt().getTime() / 1000); // Compare seconds
    }

    @Test
    void verify_WithValidTokenAndRemoteKey_ShouldReturnClaims() throws Exception {
        // Arrange
        String subject = "user_123";
        String kid = "key_123";
        String token = createTokenWithKid(subject, kid);

        String jwksResponse = createJwksResponse(kid, publicKey);

        when(mockHttpResponse.statusCode()).thenReturn(200);
        when(mockHttpResponse.body()).thenReturn(jwksResponse);
        when(mockHttpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
            .thenReturn(mockHttpResponse);

        VerifyTokenOptions options = VerifyTokenOptions
            .secretKey("sk_test_123")
            .apiUrl("https://api.clerk.test")
            .apiVersion("v1")
            .build();

        // Act
        try (MockedStatic<HttpClient> mockedHttpClient = mockStatic(HttpClient.class)) {
            mockedHttpClient.when(HttpClient::newHttpClient).thenReturn(mockHttpClient);

            TokenVerificationResponse<Claims> result = JwtSessionTokenVerifier.verify(token, options);

            // Assert
            assertNotNull(result);
            assertEquals(subject, result.payload().getSubject());
        }
    }

    @Test
    void verify_WithExpiredToken_ShouldThrowTokenExpiredException() {
        // Arrange
        Date expiration = Date.from(Instant.now().minus(1, ChronoUnit.HOURS));
        String token = createToken("user_123", "https://clerk.test", new Date(), expiration, null);

        VerifyTokenOptions options = VerifyTokenOptions
            .jwtKey(pemPublicKey)
            .build();

        // Act & Assert
        TokenVerificationException exception = assertThrows(
            TokenVerificationException.class,
            () -> JwtSessionTokenVerifier.verify(token, options)
        );
        assertEquals(TokenVerificationErrorReason.TOKEN_EXPIRED, exception.reason());
    }

    @Test
    void verify_WithTokenNotActiveYet_ShouldThrowPrematureException() {
        // Arrange
        Date notBefore = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));
        Date expiration = Date.from(Instant.now().plus(2, ChronoUnit.HOURS));

        JwtBuilder builder = Jwts.builder()
            .subject("user_123")
            .issuer("https://clerk.test")
            .issuedAt(new Date())
            .expiration(expiration)
            .notBefore(notBefore)
            .signWith(privateKey);

        String token = builder.compact();

        VerifyTokenOptions options = VerifyTokenOptions
            .jwtKey(pemPublicKey)
            .build();

        // Act & Assert
        TokenVerificationException exception = assertThrows(
            TokenVerificationException.class,
            () -> JwtSessionTokenVerifier.verify(token, options)
        );
        assertEquals(TokenVerificationErrorReason.TOKEN_NOT_ACTIVE_YET, exception.reason());
    }

    @Test
    void verify_WithInvalidSignature_ShouldThrowTokenInvalidException() throws Exception {
        // Arrange
        KeyPair differentKeyPair = KeyPairGenerator.getInstance("RSA").generateKeyPair();
        String token = createTokenWithDifferentKey(differentKeyPair.getPrivate());

        VerifyTokenOptions options = VerifyTokenOptions
            .jwtKey(pemPublicKey)
            .build();

        // Act & Assert
        TokenVerificationException exception = assertThrows(
            TokenVerificationException.class,
            () -> JwtSessionTokenVerifier.verify(token, options)
        );
        assertEquals(TokenVerificationErrorReason.TOKEN_INVALID, exception.reason());
    }

    @Test
    void verify_WithInvalidAudience_ShouldThrowTokenInvalidException() {
        // Arrange
        String token = createToken("user_123", "https://clerk.test", new Date(),
            Date.from(Instant.now().plus(1, ChronoUnit.HOURS)), "wrong_audience");

        VerifyTokenOptions options = VerifyTokenOptions
            .jwtKey(pemPublicKey)
            .audience("correct_audience")
            .build();

        // Act & Assert
        TokenVerificationException exception = assertThrows(
            TokenVerificationException.class,
            () -> JwtSessionTokenVerifier.verify(token, options)
        );
        assertEquals(TokenVerificationErrorReason.TOKEN_INVALID, exception.reason());
    }

    @Test
    void verify_WithInvalidAuthorizedParties_ShouldThrowException() {
        // Arrange
        Map<String, Object> customClaims = new HashMap<>();
        customClaims.put("azp", "invalid_party");

        String token = createTokenWithCustomClaims(customClaims);

        VerifyTokenOptions options = VerifyTokenOptions
            .jwtKey(pemPublicKey)
            .authorizedParties(List.of("valid_party"))
            .build();

        // Act & Assert
        TokenVerificationException exception = assertThrows(
            TokenVerificationException.class,
            () -> JwtSessionTokenVerifier.verify(token, options)
        );
        assertEquals(TokenVerificationErrorReason.TOKEN_INVALID_AUTHORIZED_PARTIES, exception.reason());
    }

    @Test
    void verify_WithValidAuthorizedParties_ShouldSucceed() throws Exception {
        // Arrange
        Map<String, Object> customClaims = new HashMap<>();
        customClaims.put("azp", "valid_party");

        String token = createTokenWithCustomClaims(customClaims);

        VerifyTokenOptions options = VerifyTokenOptions
            .jwtKey(pemPublicKey)
            .authorizedParties(List.of("valid_party", "another_party"))
            .build();

        // Act
        TokenVerificationResponse<Claims> result = JwtSessionTokenVerifier.verify(token, options);

        // Assert
        assertNotNull(result);
        assertEquals("user_123", result.payload().getSubject());
    }

    @Test
    void verify_WithFutureIssuedAt_ShouldThrowException() {
        // Arrange
        Date futureIssuedAt = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));
        String token = createToken("user_123", "https://clerk.test", futureIssuedAt,
            Date.from(Instant.now().plus(2, ChronoUnit.HOURS)), null);

        VerifyTokenOptions options = VerifyTokenOptions
            .jwtKey(pemPublicKey)
            .build();

        // Act & Assert
        TokenVerificationException exception = assertThrows(
            TokenVerificationException.class,
            () -> JwtSessionTokenVerifier.verify(token, options)
        );
        assertEquals(TokenVerificationErrorReason.TOKEN_IAT_IN_THE_FUTURE, exception.reason());
    }

    @Test
    void verify_WithVersion2TokenAndOrgClaims_ShouldExtractOrgInfo() throws Exception {
        // Arrange
        Map<String, Object> orgClaims = new HashMap<>();
        orgClaims.put("id", "org_123");
        orgClaims.put("slg", "test-org");
        orgClaims.put("rol", "admin");
        orgClaims.put("per", "read,write,delete");
        orgClaims.put("fpm", "7,3");

        Map<String, Object> customClaims = new HashMap<>();
        customClaims.put("v", "2");
        customClaims.put("o", orgClaims);
        customClaims.put("fea", "o:users,o:billing");

        String token = createTokenWithCustomClaims(customClaims);

        VerifyTokenOptions options = VerifyTokenOptions
            .jwtKey(pemPublicKey)
            .build();

        // Act
        TokenVerificationResponse<Claims> result = JwtSessionTokenVerifier.verify(token, options);

        // Assert
        assertNotNull(result);
        Claims claims = result.payload();
        assertEquals("org_123", claims.get("org_id"));
        assertEquals("test-org", claims.get("org_slug"));
        assertEquals("admin", claims.get("org_role"));

        @SuppressWarnings("unchecked")
        List<String> orgPermissions = (List<String>) claims.get("org_permissions");
        assertNotNull(orgPermissions);
        assertTrue(orgPermissions.contains("org:users:read"));
        assertTrue(orgPermissions.contains("org:users:write"));
        assertTrue(orgPermissions.contains("org:users:delete"));
        assertTrue(orgPermissions.contains("org:billing:read"));
        assertTrue(orgPermissions.contains("org:billing:write"));
    }

    @Test
    void verify_WithInvalidPemKey_ShouldThrowException() {
        // Arrange
        String invalidPemKey = "-----BEGIN PUBLIC KEY-----\nINVALID_KEY\n-----END PUBLIC KEY-----";
        String token = "dummy.token.here";

        VerifyTokenOptions options = VerifyTokenOptions
            .jwtKey(invalidPemKey)
            .build();

        // Act & Assert
        TokenVerificationException exception = assertThrows(
            TokenVerificationException.class,
            () -> JwtSessionTokenVerifier.verify(token, options)
        );
        assertEquals(TokenVerificationErrorReason.JWK_LOCAL_INVALID, exception.reason());
    }

    @Test
    void verify_WithMissingSecretKey_ShouldThrowException() {
        // Arrange
        String token = "header.payload.signature";

        VerifyTokenOptions options = new VerifyTokenOptions.Builder()
            .apiUrl("https://api.clerk.test")
            .apiVersion("v1")
            .build();

        // Act & Assert
        TokenVerificationException exception = assertThrows(
            TokenVerificationException.class,
            () -> JwtSessionTokenVerifier.verify(token, options)
        );
        assertEquals(TokenVerificationErrorReason.SECRET_KEY_MISSING, exception.reason());
    }

    @Test
    void verify_WithHttpError_ShouldThrowException() throws Exception {
        // Arrange
        String kid = "key_123";
        String token = createTokenWithKid("user_123", kid);

        when(mockHttpResponse.statusCode()).thenReturn(401);
        when(mockHttpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
            .thenReturn(mockHttpResponse);

        VerifyTokenOptions options = VerifyTokenOptions
            .secretKey("sk_test_123")
            .apiUrl("https://api.clerk.test")
            .apiVersion("v1")
            .build();

        // Act & Assert
        try (MockedStatic<HttpClient> mockedHttpClient = mockStatic(HttpClient.class)) {
            mockedHttpClient.when(HttpClient::newHttpClient).thenReturn(mockHttpClient);

            TokenVerificationException exception = assertThrows(
                TokenVerificationException.class,
                () -> JwtSessionTokenVerifier.verify(token, options)
            );
            assertEquals(TokenVerificationErrorReason.JWK_FAILED_TO_LOAD, exception.reason());
        }
    }

    @Test
    void verify_WithKidMismatch_ShouldThrowException() throws Exception {
        // Arrange
        String kid = "key_123";
        String token = createTokenWithKid("user_123", kid);

        String jwksResponse = createJwksResponse("different_key_456", publicKey);

        when(mockHttpResponse.statusCode()).thenReturn(200);
        when(mockHttpResponse.body()).thenReturn(jwksResponse);
        when(mockHttpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
            .thenReturn(mockHttpResponse);

        VerifyTokenOptions options = VerifyTokenOptions
            .secretKey("sk_test_123")
            .apiUrl("https://api.clerk.test")
            .apiVersion("v1")
            .build();

        // Act & Assert
        try (MockedStatic<HttpClient> mockedHttpClient = mockStatic(HttpClient.class)) {
            mockedHttpClient.when(HttpClient::newHttpClient).thenReturn(mockHttpClient);

            TokenVerificationException exception = assertThrows(
                TokenVerificationException.class,
                () -> JwtSessionTokenVerifier.verify(token, options)
            );
            assertEquals(TokenVerificationErrorReason.JWK_KID_MISMATCH, exception.reason());
        }
    }

    @Test
    void verify_WithInvalidTokenFormat_ShouldThrowException() {
        // Arrange
        String invalidToken = "invalid.token";

        VerifyTokenOptions options = VerifyTokenOptions
            .secretKey("sk_test_123")
            .apiUrl("https://api.clerk.test")
            .apiVersion("v1")
            .build();

        // Act & Assert
        TokenVerificationException exception = assertThrows(
            TokenVerificationException.class,
            () -> JwtSessionTokenVerifier.verify(invalidToken, options)
        );
        assertEquals(TokenVerificationErrorReason.TOKEN_INVALID, exception.reason());
    }

    // Helper methods
    private String createToken(String subject, String issuer, Date issuedAt, Date expiration, String audience) {
        JwtBuilder builder = Jwts.builder()
            .subject(subject)
            .issuer(issuer)
            .issuedAt(issuedAt)
            .expiration(expiration)
            .signWith(privateKey);

        if (audience != null) {
            builder.audience().add(audience);
        }

        return builder.compact();
    }

    private String createTokenWithCustomClaims(Map<String, Object> customClaims) {
        JwtBuilder builder = Jwts.builder()
            .subject("user_123")
            .issuer("https://clerk.test")
            .issuedAt(new Date())
            .expiration(Date.from(Instant.now().plus(1, ChronoUnit.HOURS)))
            .signWith(privateKey);

        customClaims.forEach(builder::claim);

        return builder.compact();
    }

    private String createTokenWithKid(String subject, String kid) {
        return Jwts.builder()
            .header().keyId(kid).and()
            .subject(subject)
            .issuer("https://clerk.test")
            .issuedAt(new Date())
            .expiration(Date.from(Instant.now().plus(1, ChronoUnit.HOURS)))
            .signWith(privateKey)
            .compact();
    }

    private String createTokenWithDifferentKey(Key differentPrivateKey) {
        return Jwts.builder()
            .subject("user_123")
            .issuer("https://clerk.test")
            .issuedAt(new Date())
            .expiration(Date.from(Instant.now().plus(1, ChronoUnit.HOURS)))
            .signWith(differentPrivateKey)
            .compact();
    }

    private String createJwksResponse(String kid, RSAPublicKey publicKey) {
        String n = Base64.getUrlEncoder().withoutPadding().encodeToString(publicKey.getModulus().toByteArray());
        String e = Base64.getUrlEncoder().withoutPadding().encodeToString(publicKey.getPublicExponent().toByteArray());

        return String.format("{\n" +
            "  \"keys\": [\n" +
            "    {\n" +
            "      \"kty\": \"RSA\",\n" +
            "      \"use\": \"sig\",\n" +
            "      \"kid\": \"%s\",\n" +
            "      \"n\": \"%s\",\n" +
            "      \"e\": \"%s\"\n" +
            "    }\n" +
            "  ]\n" +
            "}", kid, n, e);
    }
}