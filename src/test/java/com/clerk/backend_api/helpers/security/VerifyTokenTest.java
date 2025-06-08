package com.clerk.backend_api.helpers.security;

import com.clerk.backend_api.helpers.security.models.MachineAuthVerificationData;
import com.clerk.backend_api.helpers.security.models.TokenVerificationErrorReason;
import com.clerk.backend_api.helpers.security.models.TokenVerificationException;
import com.clerk.backend_api.helpers.security.models.TokenVerificationResponse;
import com.clerk.backend_api.helpers.security.models.VerifyTokenOptions;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.IncorrectClaimException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.PrematureJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.net.ConnectException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;


public class VerifyTokenTest {

    private static PrivateKey privateKey;  // private key used to sign JWTs
    private static String jwtKey;  // PEM formatted public key
    private static String validToken;

    private HttpClient mockHttpClient;
    private HttpResponse<String> mockResponse;

    @BeforeEach
    void setUp() {
        // Initialize mocks manually
        mockHttpClient = mock(HttpClient.class);
        mockResponse = mock(HttpResponse.class);
    }

    @AfterEach
    void tearDown() {
        // Reset mocks after each test
        reset(mockHttpClient, mockResponse);
    }

    @BeforeAll
    static void setupAll() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            privateKey = keyPair.getPrivate();

            PublicKey rsaPublicKey = keyPair.getPublic();
            String base64EncodedKey = Base64.getEncoder().encodeToString(rsaPublicKey.getEncoded());
            jwtKey = "-----BEGIN PUBLIC KEY-----\n";
            jwtKey += base64EncodedKey;
            jwtKey += "\n-----END PUBLIC KEY-----";
        } catch (Exception e) {
            System.out.println("ERROR: could not generate RSA KeyPair. " + e.getMessage());
        }

        validToken = Jwts.builder() //
                .subject("Joe") //
                .audience().add("aud1") //
                .and() //
                .header().add("kid", "ins_abcdefghijklmnopqrstuvwxyz0") //
                .and() //
                .expiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(1))) //
                .notBefore(new Date(System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(1))) //
                .issuedAt(new Date(System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(1))) //
                .signWith(privateKey) //
                .compact();
    }

    @Test
    public void testVerifiesOk() {
        assertDoesNotThrow(() -> VerifyToken.verifyToken(validToken, VerifyTokenOptions.jwtKey(jwtKey).build()));
    }

    @Test
    public void testInvalidApiUrl() {

        TokenVerificationException t = assertThrows(TokenVerificationException.class,
                () -> VerifyToken.verifyToken(validToken, VerifyTokenOptions //
                        .secretKey("sk_test_SecretKey") //
                        .apiUrl("https://invalid.com") //
                        .build()));
        assertEquals(TokenVerificationErrorReason.JWK_FAILED_TO_LOAD, t.reason());
        assertTrue(t.getCause() instanceof ConnectException);
    }

    @Test
    public void testInvalidSecretKey() {

        TokenVerificationException t = assertThrows(TokenVerificationException.class,
                () -> VerifyToken.verifyToken(validToken, VerifyTokenOptions //
                        .secretKey("sk_test_InvalidKey") //
                        .build()));
        assertEquals(TokenVerificationErrorReason.JWK_FAILED_TO_LOAD, t.reason());
        assertNull(t.getCause());
    }

    @Test
    public void testFailsNoSubject() {
        String token = Jwts.builder() //
                .signWith(privateKey) //
                .compact();
        TokenVerificationException t = assertThrows(TokenVerificationException.class,
                () -> VerifyToken.verifyToken(token, VerifyTokenOptions.jwtKey(jwtKey).build()));
        // not part of public API but worth checking
        assertTrue(t.getCause() instanceof UnsupportedJwtException);
    }

    @Test
    public void testFailsNullKey() {
        assertThrows(IllegalArgumentException.class, () -> VerifyTokenOptions.jwtKey(null));
    }

    @Test
    public void testFailsVerifyExpired() {
        String token = Jwts.builder() //
                .subject("Joe") //
                .expiration(new Date(System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(1))) //
                .signWith(privateKey) //
                .compact();
        TokenVerificationException t = assertThrows(TokenVerificationException.class,
                () -> VerifyToken.verifyToken(token, VerifyTokenOptions //
                        .jwtKey(jwtKey) //
                        .clockSkew(Optional.empty(), TimeUnit.MILLISECONDS) //
                        .build()));
        assertEquals(TokenVerificationErrorReason.TOKEN_EXPIRED, t.reason());
        assertTrue(t.getCause() instanceof ExpiredJwtException);
    }

    @Test
    public void testVerifyDoesNotExpireWithLargeClockSkew() {
        String token = Jwts.builder() //
                .subject("Joe") //
                .expiration(new Date(System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(1))) //
                .signWith(privateKey) //
                .compact();
        assertDoesNotThrow(() -> VerifyToken.verifyToken(token, VerifyTokenOptions //
                .jwtKey(jwtKey) //
                .clockSkew(Optional.of(3L), TimeUnit.MINUTES) //
                .build()));
    }

    @Test
    public void testFailsVerifyNotBefore() {
        String token = Jwts.builder() //
                .subject("Joe") //
                .notBefore(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(1))) //
                .issuedAt(new Date(System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(1))) //
                .signWith(privateKey) //
                .compact();
        TokenVerificationException t = assertThrows(TokenVerificationException.class,
                () -> VerifyToken.verifyToken(token, VerifyTokenOptions.jwtKey(jwtKey).build()));

        assertEquals(TokenVerificationErrorReason.TOKEN_NOT_ACTIVE_YET, t.reason());
        assertTrue(t.getCause() instanceof PrematureJwtException);
    }

    @Test
    public void testFailsIssuedAt() {
        String token = Jwts.builder() //
                .subject("Joe") //
                .issuedAt(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(1))) //
                .signWith(privateKey) //
                .compact();
        TokenVerificationException t = assertThrows(TokenVerificationException.class,
                () -> VerifyToken.verifyToken(token, VerifyTokenOptions.jwtKey(jwtKey).build()));
        assertEquals(TokenVerificationErrorReason.TOKEN_IAT_IN_THE_FUTURE, t.reason());
        assertNull(t.getCause());
    }

    @Test
    public void testFailsAudience() {
        String token = Jwts.builder() //
                .subject("Joe") //
                .audience().add("aud1").add("aud2") //
                .and() //
                .signWith(privateKey) //
                .compact();
        TokenVerificationException t = assertThrows(TokenVerificationException.class,
                () -> VerifyToken.verifyToken(token, VerifyTokenOptions //
                        .jwtKey(jwtKey) //
                        .audience("aud3") //
                        .build()));
        assertEquals(TokenVerificationErrorReason.TOKEN_INVALID, t.reason());
        assertTrue(t.getCause() instanceof IncorrectClaimException);
    }

    @Test
    public void testVerifiesEmptyAuthorizedParties() {
        String token = Jwts.builder() //
                .subject("Joe") //
                .claim("azp", "partyparty") //
                .audience().add("aud1").add("aud2") //
                .and() //
                .signWith(privateKey) //
                .compact();

        assertDoesNotThrow(() -> VerifyToken.verifyToken(token, VerifyTokenOptions.jwtKey(jwtKey).build()));
    }

    @Test
    public void testVerifiesNonEmptyAuthorizedParties() {
        String token = Jwts.builder() //
                .subject("Joe") //
                .claim("azp", "partyparty") //
                .audience().add("aud1").add("aud2") //
                .and() //
                .signWith(privateKey) //
                .compact();

        assertDoesNotThrow(() -> VerifyToken.verifyToken(token, VerifyTokenOptions //
                .jwtKey(jwtKey) //
                .authorizedParties(List.of("boo")) //
                .authorizedParty("partyparty") //
                .build()));
    }

    @Test
    public void testFailsAuthorizedParties() {
        String token = Jwts.builder() //
                .subject("Joe") //
                .claim("azp", "partyparty") //
                .audience().add("aud1").add("aud2") //
                .and() //
                .signWith(privateKey) //
                .compact();
        TokenVerificationException t = assertThrows(TokenVerificationException.class,
                () -> VerifyToken.verifyToken(token, VerifyTokenOptions //
                        .jwtKey(jwtKey) //
                        .authorizedParty("bill") //
                        .build()));
        assertEquals(TokenVerificationErrorReason.TOKEN_INVALID_AUTHORIZED_PARTIES, t.reason());
        assertNull(t.getCause());
    }



    @Test
    public void testVerifyApiKeyTokenSuccess() throws Exception {
        // Create JSON response manually instead of serializing the object
        String responseJson = "{\n" +
            "    \"id\": \"test_id\",\n" +
            "    \"object\": \"api_key\",\n" +
            "    \"type\": \"api_key\",\n" +
            "    \"name\": \"Test API Key\",\n" +
            "    \"subject\": \"test_subject\",\n" +
            "    \"scopes\": [\"read\", \"write\"],\n" +
            "    \"created_at\": " + System.currentTimeMillis() + ",\n" +
            "    \"updated_at\": " + System.currentTimeMillis() + ",\n" +
            "    \"expiration\": " + (System.currentTimeMillis() + TimeUnit.HOURS.toMillis(1)) + ",\n" +
            "    \"revoked\": false,\n" +
            "    \"expired\": false,\n" +
            "    \"created_by\": \"test_user\",\n" +
            "    \"claims\": {\n" +
            "      \"permissions\": [\"users:read\", \"users:write\"]\n" +
            "    }\n" +
            "  }\n";

        when(mockResponse.statusCode()).thenReturn(200);
        when(mockResponse.body()).thenReturn(responseJson);
        when(mockHttpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
            .thenReturn(mockResponse);

        try (MockedStatic<HttpClient> httpClientMock = mockStatic(HttpClient.class)) {
            httpClientMock.when(HttpClient::newHttpClient).thenReturn(mockHttpClient);

            String apiKeyToken = "ak_apikey123";

            TokenVerificationResponse<?> result = VerifyToken.verifyToken(apiKeyToken,
                VerifyTokenOptions.secretKey("sk_test_valid")
                    .apiUrl("https://api.example.com")
                    .build());

            assertNotNull(result);
            assertNotNull(result.payload());
            assertTrue(result.payload() instanceof MachineAuthVerificationData);

            MachineAuthVerificationData resultData = (MachineAuthVerificationData) result.payload();
            assertEquals("test_id", resultData.getId());
            assertEquals("Test API Key", resultData.getName());
        }
    }

    @Test
    public void testVerifyApiKeyTokenInvalidResponse() throws Exception {
        // Mock HTTP response for invalid token
        when(mockResponse.statusCode()).thenReturn(401);
        when(mockResponse.body()).thenReturn("{\"error\": \"Invalid token\"}");
        when(mockHttpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
            .thenReturn(mockResponse);

        try (MockedStatic<HttpClient> httpClientMock = mockStatic(HttpClient.class)) {
            httpClientMock.when(HttpClient::newHttpClient).thenReturn(mockHttpClient);

            String apiKeyToken = "sk_test_invalid";

            TokenVerificationException exception = assertThrows(TokenVerificationException.class, () -> {
                VerifyToken.verifyToken(apiKeyToken,
                    VerifyTokenOptions.secretKey("sk_test_invalid")
                        .apiUrl("https://api.example.com")
                        .build());
            });

            assertEquals(TokenVerificationErrorReason.TOKEN_INVALID, exception.reason());
        }
    }

    @Test
    public void testVerifyMachineTokenSuccess() throws Exception {
        String responseJson = "{\n" +
            "    \"id\": \"test_id\",\n" +
            "    \"object\": \"api_key\",\n" +
            "    \"type\": \"machine_to_machine\",\n" +
            "    \"name\": \"Test API Key\",\n" +
            "    \"subject\": \"test_subject\",\n" +
            "    \"scopes\": [\"read\", \"write\"],\n" +
            "    \"created_at\": " + System.currentTimeMillis() + ",\n" +
            "    \"updated_at\": " + System.currentTimeMillis() + ",\n" +
            "    \"expiration\": " + (System.currentTimeMillis() + TimeUnit.HOURS.toMillis(1)) + ",\n" +
            "    \"revoked\": false,\n" +
            "    \"expired\": false,\n" +
            "    \"created_by\": \"test_user\",\n" +
            "    \"claims\": {\n" +
            "      \"permissions\": [\"users:read\", \"users:write\"]\n" +
            "    }\n" +
            "  }\n";

        when(mockResponse.statusCode()).thenReturn(200);
        when(mockResponse.body()).thenReturn(responseJson);
        when(mockHttpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
            .thenReturn(mockResponse);

        try (MockedStatic<HttpClient> httpClientMock = mockStatic(HttpClient.class)) {
            httpClientMock.when(HttpClient::newHttpClient).thenReturn(mockHttpClient);

            String machineToken = "mt_machine_token_123";

            TokenVerificationResponse<?> result = VerifyToken.verifyToken(machineToken,
                VerifyTokenOptions.secretKey("sk_test_valid")
                    .apiUrl("https://api.example.com")
                    .build());

            assertNotNull(result);
            assertNotNull(result.payload());
            assertTrue(result.payload() instanceof MachineAuthVerificationData);

            MachineAuthVerificationData resultData = (MachineAuthVerificationData) result.payload();
            assertEquals("machine_to_machine", resultData.getType());
        }
    }

    @Test
    public void testVerifyMachineTokenFailure() throws Exception {
        when(mockResponse.statusCode()).thenReturn(403);
        when(mockResponse.body()).thenReturn("{\"error\": \"Forbidden\"}");
        when(mockHttpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
            .thenReturn(mockResponse);

        try (MockedStatic<HttpClient> httpClientMock = mockStatic(HttpClient.class)) {
            httpClientMock.when(HttpClient::newHttpClient).thenReturn(mockHttpClient);

            String machineToken = "mt_invalid_token";

            assertThrows(TokenVerificationException.class, () -> {
                VerifyToken.verifyToken(machineToken,
                    VerifyTokenOptions.secretKey("sk_test_invalid")
                        .apiUrl("https://api.example.com")
                        .build());
            });
        }
    }

    @Test
    public void testVerifyOAuthTokenSuccess() throws Exception {
        String responseJson = "{\n" +
            "    \"id\": \"test_id\",\n" +
            "    \"object\": \"api_key\",\n" +
            "    \"type\": \"oauth\",\n" +
            "    \"name\": \"Test API Key\",\n" +
            "    \"subject\": \"test_subject\",\n" +
            "    \"scopes\": [\"read\", \"write\"],\n" +
            "    \"created_at\": " + System.currentTimeMillis() + ",\n" +
            "    \"updated_at\": " + System.currentTimeMillis() + ",\n" +
            "    \"expiration\": " + (System.currentTimeMillis() + TimeUnit.HOURS.toMillis(1)) + ",\n" +
            "    \"revoked\": false,\n" +
            "    \"expired\": false,\n" +
            "    \"created_by\": \"test_user\",\n" +
            "    \"claims\": {\n" +
            "      \"permissions\": [\"users:read\", \"users:write\"]\n" +
            "    }\n" +
            "  }";

        when(mockResponse.statusCode()).thenReturn(200);
        when(mockResponse.body()).thenReturn(responseJson);
        when(mockHttpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
            .thenReturn(mockResponse);

        try (MockedStatic<HttpClient> httpClientMock = mockStatic(HttpClient.class)) {
            httpClientMock.when(HttpClient::newHttpClient).thenReturn(mockHttpClient);

            String oauthToken = "oat_oauth_token_123";

            TokenVerificationResponse<?> result = VerifyToken.verifyToken(oauthToken,
                VerifyTokenOptions.secretKey("sk_test_valid")
                    .apiUrl("https://api.example.com")
                    .build());

            assertNotNull(result);
            assertNotNull(result.payload());
            assertTrue(result.payload() instanceof MachineAuthVerificationData);

            MachineAuthVerificationData resultData = (MachineAuthVerificationData) result.payload();
            assertEquals("oauth", resultData.getType());
        }
    }

    @Test
    public void testVerifyOAuthTokenFailure() throws Exception {
        when(mockResponse.statusCode()).thenReturn(400);
        when(mockResponse.body()).thenReturn("{\"error\": \"Bad Request\"}");
        when(mockHttpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
            .thenReturn(mockResponse);

        try (MockedStatic<HttpClient> httpClientMock = mockStatic(HttpClient.class)) {
            httpClientMock.when(HttpClient::newHttpClient).thenReturn(mockHttpClient);

            String oauthToken = "ot_invalid_token";

            assertThrows(TokenVerificationException.class, () -> {
                VerifyToken.verifyToken(oauthToken,
                    VerifyTokenOptions.secretKey("sk_test_invalid")
                        .apiUrl("https://api.example.com")
                        .build());
            });
        }
    }

    @Test
    public void testVerifyTokenWithMalformedJsonResponse() throws Exception {
        when(mockResponse.statusCode()).thenReturn(200);
        when(mockResponse.body()).thenReturn("{ invalid json }");
        when(mockHttpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
            .thenReturn(mockResponse);

        try (MockedStatic<HttpClient> httpClientMock = mockStatic(HttpClient.class)) {
            httpClientMock.when(HttpClient::newHttpClient).thenReturn(mockHttpClient);

            String apiKeyToken = "ak_apikey123";

            TokenVerificationException exception = assertThrows(TokenVerificationException.class, () -> {
                VerifyToken.verifyToken(apiKeyToken,
                    VerifyTokenOptions.secretKey("sk_test_valid")
                        .apiUrl("https://api.example.com")
                        .build());
            });

            assertEquals(TokenVerificationErrorReason.FAILED_TO_PROCESS_RESPONSE, exception.reason());
        }
    }

    @Test
    public void testVerifyTokenNetworkTimeout() throws Exception {
        when(mockHttpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
            .thenThrow(new java.net.http.HttpTimeoutException("Request timeout"));

        try (MockedStatic<HttpClient> httpClientMock = mockStatic(HttpClient.class)) {
            httpClientMock.when(HttpClient::newHttpClient).thenReturn(mockHttpClient);

            String apiKeyToken = "sk_test_apikey123";

            assertThrows(Exception.class, () -> {
                VerifyToken.verifyToken(apiKeyToken,
                    VerifyTokenOptions.secretKey("sk_test_valid")
                        .apiUrl("https://api.example.com")
                        .build());
            });
        }
    }

    @Test
    public void testVerifySessionTokenSuccess() throws Exception {
        TokenVerificationResponse<?> result = VerifyToken.verifyToken(validToken,
            VerifyTokenOptions.jwtKey(jwtKey).build());

        assertNotNull(result, "Result should not be null");
        assertNotNull(result.payload(), "Payload should not be null");
    }

    @Test
    public void testVerifyNullToken() {
        assertThrows(Exception.class, () -> {
            VerifyToken.verifyToken(null, VerifyTokenOptions.jwtKey(jwtKey).build());
        });
    }

    @Test
    public void testVerifyEmptyToken() {
        assertThrows(IllegalArgumentException.class, () -> {
            VerifyToken.verifyToken("", VerifyTokenOptions.jwtKey(jwtKey).build());
        });
    }

    @Test
    public void testVerifyWithNullOptions() {
        assertThrows(Exception.class, () -> {
            VerifyToken.verifyToken(validToken, null);
        });
    }

    @Test
    public void testTokenTypeDetection() throws Exception {
        when(mockResponse.statusCode()).thenReturn(401);
        when(mockResponse.body()).thenReturn("{\"error\": \"Invalid\"}");
        when(mockHttpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
            .thenReturn(mockResponse);

        try (MockedStatic<HttpClient> httpClientMock = mockStatic(HttpClient.class)) {
            httpClientMock.when(HttpClient::newHttpClient).thenReturn(mockHttpClient);

            String[] testCases = {
                "sk_test_123", // Should be API_KEY
                "mt_test_123", // Should be MACHINE_TOKEN
                "ot_test_123", // Should be OAUTH_TOKEN
            };

            for (String token : testCases) {
                assertThrows(Exception.class, () -> {
                    VerifyToken.verifyToken(token, VerifyTokenOptions.secretKey("sk_invalid")
                        .apiUrl("https://api.example.com").build());
                }, "Token: " + token + " should be processed and throw an exception due to invalid setup");
            }
            assertThrows(Exception.class, () -> {
                VerifyToken.verifyToken("jwt.token.here", VerifyTokenOptions.jwtKey("invalid").build());
            }, "JWT token should be processed and throw an exception due to invalid key");
        }
    }

    @Test
    public void testTokenPrefixEdgeCases() throws Exception {
        when(mockResponse.statusCode()).thenReturn(401);
        when(mockResponse.body()).thenReturn("{\"error\": \"Invalid\"}");
        when(mockHttpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
            .thenReturn(mockResponse);

        try (MockedStatic<HttpClient> httpClientMock = mockStatic(HttpClient.class)) {
            httpClientMock.when(HttpClient::newHttpClient).thenReturn(mockHttpClient);

            String[] edgeCaseTokens = {
                "sk_", // just the prefix
                "mt_", // just the prefix
                "ot_"  // just the prefix
            };

            for (String token : edgeCaseTokens) {
                assertThrows(TokenVerificationException.class, () -> {
                    VerifyToken.verifyToken(token,
                        VerifyTokenOptions.secretKey("sk_test")
                            .apiUrl("https://api.example.com")
                            .build());
                }, "Token: " + token + " should throw TokenVerificationException");
            }
        }
    }

    @Test
    public void testVerifyTokenServerError() throws Exception {
        when(mockResponse.statusCode()).thenReturn(500);
        when(mockResponse.body()).thenReturn("{\"error\": \"Internal Server Error\"}");
        when(mockHttpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
            .thenReturn(mockResponse);

        try (MockedStatic<HttpClient> httpClientMock = mockStatic(HttpClient.class)) {
            httpClientMock.when(HttpClient::newHttpClient).thenReturn(mockHttpClient);

            String apiKeyToken = "sk_test_apikey123";

            assertThrows(TokenVerificationException.class, () -> {
                VerifyToken.verifyToken(apiKeyToken,
                    VerifyTokenOptions.secretKey("sk_test_valid")
                        .apiUrl("https://api.example.com")
                        .build());
            });
        }
    }
}
