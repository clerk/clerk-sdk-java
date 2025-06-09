package com.clerk.backend_api.helpers.security.token_verifiers.impl;

import com.clerk.backend_api.helpers.security.models.MachineAuthVerificationData;
import com.clerk.backend_api.helpers.security.models.TokenVerificationErrorReason;
import com.clerk.backend_api.helpers.security.models.TokenVerificationException;
import com.clerk.backend_api.helpers.security.models.TokenVerificationResponse;
import com.clerk.backend_api.helpers.security.models.VerifyTokenOptions;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

class MachineTokenVerifierTests {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void verify_shouldReturnValidResponse_whenHttpStatusIs200() throws Exception {
        String token = "mt_test_token";

        HttpClient mockClient = mock(HttpClient.class);
        HttpResponse<String> mockResponse = mock(HttpResponse.class);

        when(mockResponse.statusCode()).thenReturn(200);
        when(mockResponse.body()).thenReturn(getMockResponse());
        when(mockClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
            .thenReturn(mockResponse);

        try (MockedStatic<HttpClient> staticHttpClient = mockStatic(HttpClient.class)) {
            staticHttpClient.when(HttpClient::newHttpClient).thenReturn(mockClient);

            MachineTokenVerifier verifier = new MachineTokenVerifier();

            VerifyTokenOptions options =VerifyTokenOptions.secretKey("test_key")
                .build();

            TokenVerificationResponse<MachineAuthVerificationData> result = verifier.verify(token, options);

            assertNotNull(result);
            MachineAuthVerificationData payload = result.payload();
            assertNotNull(payload);
            assertEquals("api_key", payload.getObject());
            assertEquals("key_id", payload.getId());
            assertEquals("machine", payload.getType());
            assertEquals("MyKey", payload.getName());
            assertEquals("sub_123", payload.getSubject());
            assertEquals(Arrays.asList("read", "write"), payload.getScopes());
            assertNotNull(payload.getClaims());
            assertEquals(Arrays.asList("org:read", "org:write"), payload.getClaims().getPermissions());
            assertEquals(Long.valueOf(1625158800L), payload.getCreatedAt());
            assertEquals(Long.valueOf(1625162400L), payload.getUpdatedAt());
            assertEquals(Long.valueOf(1725162400L), payload.getExpiration());
            assertFalse(payload.getRevoked());
            assertNull(payload.getRevocationReason());
            assertFalse(payload.getExpired());
            assertEquals("admin_user_id", payload.getCreatedBy());
        }
    }

    @Test
    void verify_shouldThrowTokenVerificationException_whenHttpStatusIsNot200() throws Exception {
        HttpClient mockClient = mock(HttpClient.class);
        HttpResponse<String> mockResponse = mock(HttpResponse.class);

        when(mockResponse.statusCode()).thenReturn(401);
        when(mockClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
            .thenReturn(mockResponse);

        try (MockedStatic<HttpClient> staticHttpClient = mockStatic(HttpClient.class)) {
            staticHttpClient.when(HttpClient::newHttpClient).thenReturn(mockClient);

            MachineTokenVerifier verifier = new MachineTokenVerifier();
            VerifyTokenOptions options =VerifyTokenOptions.secretKey("test_key")
                .build();

            assertThrows(TokenVerificationException.class, () -> verifier.verify("mt_token", options));
        }
    }

    @Test
    void verify_shouldThrowTokenVerificationException_whenJsonParsingFails() throws Exception {
        HttpClient mockClient = mock(HttpClient.class);
        HttpResponse<String> mockResponse = mock(HttpResponse.class);

        when(mockResponse.statusCode()).thenReturn(200);
        when(mockResponse.body()).thenReturn("this is not json");
        when(mockClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
            .thenReturn(mockResponse);

        try (MockedStatic<HttpClient> staticHttpClient = mockStatic(HttpClient.class)) {
            staticHttpClient.when(HttpClient::newHttpClient).thenReturn(mockClient);

            MachineTokenVerifier verifier = new MachineTokenVerifier();

            VerifyTokenOptions options =VerifyTokenOptions.secretKey("test_key")
                .build();

            TokenVerificationException ex = assertThrows(TokenVerificationException.class,
                () -> verifier.verify("mt_token", options));
            assertEquals(TokenVerificationErrorReason.FAILED_TO_PROCESS_RESPONSE, ex.reason());
        }
    }

    private static String getMockResponse(){
        return  "{"
            + "\"object\":\"api_key\","
            + "\"id\":\"key_id\","
            + "\"type\":\"machine\","
            + "\"name\":\"MyKey\","
            + "\"subject\":\"sub_123\","
            + "\"scopes\":[\"read\",\"write\"],"
            + "\"claims\":{"
            + "\"permissions\":[\"org:read\",\"org:write\"]"
            + "},"
            + "\"created_at\":1625158800,"
            + "\"updated_at\":1625162400,"
            + "\"expiration\":1725162400,"
            + "\"revoked\":false,"
            + "\"revocation_reason\":null,"
            + "\"expired\":false,"
            + "\"created_by\":\"admin_user_id\""
            + "}";
    }
}

