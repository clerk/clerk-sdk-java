package com.clerk.backend_api.helpers.security;

import com.clerk.backend_api.helpers.security.models.APIKeyMachineAuthObject;
import com.clerk.backend_api.helpers.security.models.AuthErrorReason;
import com.clerk.backend_api.helpers.security.models.AuthObject;
import com.clerk.backend_api.helpers.security.models.AuthenticateRequestOptions;
import com.clerk.backend_api.helpers.security.models.M2MMachineAuthObject;
import com.clerk.backend_api.helpers.security.models.MachineAuthVerificationData;
import com.clerk.backend_api.helpers.security.models.OAuthMachineAuthObject;
import com.clerk.backend_api.helpers.security.models.RequestState;
import com.clerk.backend_api.helpers.security.models.SessionAuthObjectV1;
import com.clerk.backend_api.helpers.security.models.SessionAuthObjectV2;
import com.clerk.backend_api.helpers.security.models.TokenVerificationResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

public class AuthenticateRequestTest {

    @Mock
    private AuthenticateRequestOptions options;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(options.jwtKey()).thenReturn(Optional.empty());
        when(options.secretKey()).thenReturn(Optional.empty());
        when(options.audience()).thenReturn(Optional.of("test"));
        when(options.authorizedParties()).thenReturn(Collections.emptySet());
        when(options.clockSkewInMs()).thenReturn(0L);
    }

    @Test
    public void testMissingToken() {
        Map<String, List<String>> headers = new HashMap<>();
        RequestState result = AuthenticateRequest.authenticateRequest(headers, options);
        assertFalse(result.isSignedIn());
        assertEquals(AuthErrorReason.SESSION_TOKEN_MISSING, result.reason().get());
    }

    @Test
    public void testValidBearerToken() {
        Map<String, List<String>> headers = new HashMap<>();
        when(options.acceptsToken()).thenReturn(List.of("session_token"));
        headers.put("authorization", Collections.singletonList("Bearer test-token"));

        TokenVerificationResponse<?> mockResponse = mock(TokenVerificationResponse.class);

        try (MockedStatic<VerifyToken> mocked = mockStatic(VerifyToken.class)) {
            mocked.when(() -> VerifyToken.verifyToken(eq("test-token"), any())).thenReturn(mockResponse);

            RequestState result = AuthenticateRequest.authenticateRequest(headers, options);

            assertTrue(result.isSignedIn());
            assertEquals("test-token", result.token().get());
        }
    }

    @Test
    public void testValidSessionCookie() {
        Map<String, List<String>> headers = new HashMap<>();
        when(options.acceptsToken()).thenReturn(List.of("session_token"));
        headers.put("cookie", Collections.singletonList("__session=session-token"));

        TokenVerificationResponse<?> mockResponse = mock(TokenVerificationResponse.class);

        try (MockedStatic<VerifyToken> mocked = mockStatic(VerifyToken.class)) {
            mocked.when(() -> VerifyToken.verifyToken(eq("session-token"), any())).thenReturn(mockResponse);

            RequestState result = AuthenticateRequest.authenticateRequest(headers, options);

            assertTrue(result.isSignedIn());
            assertEquals("session-token", result.token().get());
        }
    }

    @Test
    public void testValidSessionCookieWithAnyAcceptedTokenType() {
        Map<String, List<String>> headers = new HashMap<>();
        when(options.acceptsToken()).thenReturn(List.of("any"));
        headers.put("cookie", Collections.singletonList("__session=session-token"));

        TokenVerificationResponse<?> mockResponse = mock(TokenVerificationResponse.class);

        try (MockedStatic<VerifyToken> mocked = mockStatic(VerifyToken.class)) {
            mocked.when(() -> VerifyToken.verifyToken(eq("session-token"), any())).thenReturn(mockResponse);

            RequestState result = AuthenticateRequest.authenticateRequest(headers, options);

            assertTrue(result.isSignedIn());
            assertEquals("session-token", result.token().get());
        }
    }

    @Test
    public void testUnsupportedTokenType() {
        when(options.acceptsToken()).thenReturn(List.of("machine_token", "api_key"));
        Map<String, List<String>> headers = new HashMap<>();
        headers.put("authorization", Collections.singletonList("Bearer unsupported-token"));
        RequestState result = AuthenticateRequest.authenticateRequest(headers, options);
        assertTrue(result.isSignedOut());
        assertEquals(AuthErrorReason.TOKEN_TYPE_NOT_SUPPORTED, result.reason().get());
    }

    @Test
    public void testIOException(){
        Map<String, List<String>> headers = new HashMap<>();
        when(options.acceptsToken()).thenReturn(List.of("session_token"));
        headers.put("authorization", Collections.singletonList("Bearer fail-token"));

        try (MockedStatic<VerifyToken> mocked = mockStatic(VerifyToken.class)) {
            mocked.when(() -> VerifyToken.verifyToken(eq("fail-token"), any())).thenThrow(new IOException());

            RequestState result = AuthenticateRequest.authenticateRequest(headers, options);

            assertFalse(result.isSignedIn());
            assertEquals(AuthErrorReason.INTERNAL_ERROR, result.reason().get());
        }
    }

    @Test
    public void testAPIKeyMachineAuthObjectConversion() {
        Map<String, List<String>> headers = new HashMap<>();
        when(options.acceptsToken()).thenReturn(List.of("api_key"));
        headers.put("authorization", Collections.singletonList("Bearer ak_api-key-token"));
        TokenVerificationResponse<MachineAuthVerificationData> mockResponse = mock(TokenVerificationResponse.class);
        when(mockResponse.payload()).thenReturn(new MachineAuthVerificationData(
            "machine_auth",
            "12345",
            "client-abc",
            "api_key",
            "Test Name",
            "subject-xyz",
            List.of("read", "write"),
            Map.of("role", "admin"),
            1710000000L,
            1710003600L,
            1710007200L,
            false,
            null,
            false,
            "creator-001"
        ));
        try (MockedStatic<VerifyToken> mocked = mockStatic(VerifyToken.class)) {
            mocked.when(() -> VerifyToken.verifyToken(eq("ak_api-key-token"), any()))
                .thenReturn(mockResponse);
            RequestState result = AuthenticateRequest.authenticateRequest(headers, options);
            assertTrue(result.isSignedIn());
            AuthObject authObject = result.toAuth();
            assertNotNull(authObject);
            assertTrue(authObject instanceof APIKeyMachineAuthObject);
            APIKeyMachineAuthObject apiKeyMachineAuthObject = (APIKeyMachineAuthObject) authObject;
            assertEquals("12345", apiKeyMachineAuthObject.getId());
            assertEquals("Test Name", apiKeyMachineAuthObject.getName());
            assertEquals("subject-xyz", apiKeyMachineAuthObject.getUserId());

        }
    }

    @Test
    public void testM2MMachineAuthObjectConversion() {
        Map<String, List<String>> headers = new HashMap<>();
        when(options.acceptsToken()).thenReturn(List.of("machine_token"));
        headers.put("authorization", Collections.singletonList("Bearer mt_machine-token"));
        TokenVerificationResponse<MachineAuthVerificationData> mockResponse = mock(TokenVerificationResponse.class);
        when(mockResponse.payload()).thenReturn(new MachineAuthVerificationData(
            "machine_auth",
            "67890",
            "client-def",
            "machine_token",
            "Test Machine",
            "subject-abc",
            List.of("read", "write"),
            Map.of("role", "user"),
            1710000000L,
            1710003600L,
            1710007200L,
            false,
            null,
            false,
            "creator-002"
        ));

        try (MockedStatic<VerifyToken> mocked = mockStatic(VerifyToken.class)) {
            mocked.when(() -> VerifyToken.verifyToken(eq("mt_machine-token"), any()))
                .thenReturn(mockResponse);
            RequestState result = AuthenticateRequest.authenticateRequest(headers, options);
            assertTrue(result.isSignedIn());
            AuthObject authObject = result.toAuth();
            assertNotNull(authObject);
            assertTrue(authObject instanceof M2MMachineAuthObject);
            M2MMachineAuthObject m2mMachineAuthObject = (M2MMachineAuthObject) authObject;
            assertEquals("67890", m2mMachineAuthObject.getId());
            assertEquals("Test Machine", m2mMachineAuthObject.getName());
            assertEquals("subject-abc", m2mMachineAuthObject.getMachineId());
        }
    }

    @Test
    public void testOAuthMachineAuthObjectConversion() {
        Map<String, List<String>> headers = new HashMap<>();
        when(options.acceptsToken()).thenReturn(List.of("oauth_token"));
        headers.put("authorization", Collections.singletonList("Bearer oat_oauth-token"));
        TokenVerificationResponse<MachineAuthVerificationData> mockResponse = mock(TokenVerificationResponse.class);
        when(mockResponse.payload()).thenReturn(new MachineAuthVerificationData(
            "machine_auth",
            "11223",
            "client-xyz",
            "oauth_token",
            "OAuth Client",
            "subject-oauth",
            List.of("read", "write"),
            Map.of("role", "oauth_user"),
            1710000000L,
            1710003600L,
            1710007200L,
            false,
            null,
            false,
            "creator-003"
        ));

        try (MockedStatic<VerifyToken> mocked = mockStatic(VerifyToken.class)) {
            mocked.when(() -> VerifyToken.verifyToken(eq("oat_oauth-token"), any()))
                .thenReturn(mockResponse);
            RequestState result = AuthenticateRequest.authenticateRequest(headers, options);
            assertTrue(result.isSignedIn());
            AuthObject authObject = result.toAuth();
            assertNotNull(authObject);
            assertTrue(authObject instanceof OAuthMachineAuthObject);
            OAuthMachineAuthObject oauthMachineAuthObject = (OAuthMachineAuthObject) authObject;
            assertEquals("11223", oauthMachineAuthObject.getId());
            assertEquals("OAuth Client", oauthMachineAuthObject.getName());
            assertEquals("subject-oauth", oauthMachineAuthObject.getUserId());
        }
    }

    @Test
    public void testSessionTokenV1Conversion() {
        Map<String, List<String>> headers = new HashMap<>();
        when(options.acceptsToken()).thenReturn(List.of("session_token"));
        headers.put("authorization", Collections.singletonList("Bearer session-token-v1"));

        TokenVerificationResponse<Map<String, Object>> mockResponse = mock(TokenVerificationResponse.class);
        when(mockResponse.payload()).thenReturn(Map.of(
            "sid", "session-id",
            "sub", "subject-id",
            "org_id", "org-id",
            "org_role", "admin",
            "org_permissions", List.of("read", "write"),
            "fva", List.of(1, 2),
            "v", 1
        ));

        try (MockedStatic<VerifyToken> mocked = mockStatic(VerifyToken.class)) {
            mocked.when(() -> VerifyToken.verifyToken(eq("session-token-v1"), any()))
                .thenReturn(mockResponse);
            RequestState result = AuthenticateRequest.authenticateRequest(headers, options);
            assertTrue(result.isSignedIn());
            AuthObject authObject = result.toAuth();
            assertNotNull(authObject);
            assertTrue(authObject instanceof SessionAuthObjectV1);
            SessionAuthObjectV1 sessionAuthObject = (SessionAuthObjectV1) authObject;
            assertEquals("session-id", sessionAuthObject.getSessionId());
            assertEquals("subject-id", sessionAuthObject.getUserId());
        }
    }

    @Test
    public void testSessionTokenV2Conversion() {
        Map<String, List<String>> headers = new HashMap<>();
        when(options.acceptsToken()).thenReturn(List.of("session_token"));
        headers.put("authorization", Collections.singletonList("Bearer session-token-v2"));

        TokenVerificationResponse<Map<String, Object>> mockResponse = mock(TokenVerificationResponse.class);
        when(mockResponse.payload()).thenReturn(Map.of(
            "sid", "session-id-v2",
            "sub", "subject-id-v2",
            "iss", "issuer-id",
            "exp", 1710000000,
            "iat", 1709996400,
            "jti", "jti-id",
            "role", "user",
            "fva", List.of(1, 2),
            "v", 2
        ));

        try (MockedStatic<VerifyToken> mocked = mockStatic(VerifyToken.class)) {
            mocked.when(() -> VerifyToken.verifyToken(eq("session-token-v2"), any()))
                .thenReturn(mockResponse);
            RequestState result = AuthenticateRequest.authenticateRequest(headers, options);
            assertTrue(result.isSignedIn());
            AuthObject authObject = result.toAuth();
            assertNotNull(authObject);
            assertTrue(authObject instanceof SessionAuthObjectV2);
            SessionAuthObjectV2 sessionAuthObject = (SessionAuthObjectV2) authObject;
            assertEquals("session-id-v2", sessionAuthObject.getSid());
            assertEquals("subject-id-v2", sessionAuthObject.getSub());
        }
    }

}
