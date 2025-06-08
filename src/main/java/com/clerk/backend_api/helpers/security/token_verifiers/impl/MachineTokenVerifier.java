package com.clerk.backend_api.helpers.security.token_verifiers.impl;

import com.clerk.backend_api.helpers.security.models.MachineAuthVerificationData;
import com.clerk.backend_api.helpers.security.models.TokenVerificationErrorReason;
import com.clerk.backend_api.helpers.security.models.TokenVerificationException;
import com.clerk.backend_api.helpers.security.models.TokenVerificationResponse;
import com.clerk.backend_api.helpers.security.models.VerifyTokenOptions;
import com.clerk.backend_api.helpers.security.token_verifiers.TokenVerifier;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class MachineTokenVerifier implements TokenVerifier {

    private final static String MACHINE_TOKEN_VERIFICATION_URL = "/oauth_applications/access_tokens/verify";
    private final static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public TokenVerificationResponse<MachineAuthVerificationData> verify(String token, VerifyTokenOptions options)
        throws IOException, InterruptedException, TokenVerificationException {
        Map<String, String> payload = new HashMap<>();
        payload.put("secret", token);
        String jsonPayload = objectMapper.writeValueAsString(payload);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(options.apiUrl() + MACHINE_TOKEN_VERIFICATION_URL))
            .header("Content-Type", "application/json")
            .header("Authorization", "Bearer " + options.secretKey())
            .timeout(Duration.ofSeconds(30))
            .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
            .build();

        HttpResponse<String> response = client.send(request,
            HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            try {
                return new TokenVerificationResponse<>(objectMapper.readValue(response.body(),
                    MachineAuthVerificationData.class));
            } catch (JsonProcessingException e) {
                throw new TokenVerificationException(TokenVerificationErrorReason.FAILED_TO_PROCESS_RESPONSE, e);
            }
        } else {
            throw new TokenVerificationException(TokenVerificationErrorReason.TOKEN_INVALID);
        }
    }


}
