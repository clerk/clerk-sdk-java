package com.clerk.backend_api.helpers.security;

import com.clerk.backend_api.helpers.security.models.AuthErrorReason;
import com.clerk.backend_api.helpers.security.models.AuthenticateRequestOptions;
import com.clerk.backend_api.helpers.security.models.RequestState;
import com.clerk.backend_api.helpers.security.models.TokenVerificationResponse;
import java.io.IOException;
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
}
