package com.clerk.backend_api.helpers.security.models;

import io.jsonwebtoken.Claims;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.clerk.backend_api.utils.Utils;

import static com.clerk.backend_api.helpers.security.util.TokenTypeHelper.getTokenType;

/**
 * RequestState - Authentication State of the request.
 */
public final class RequestState {

    private final AuthStatus status;
    private final Optional<AuthErrorReason> authErrorReason;
    private final Optional<TokenVerificationErrorReason> tokenVerificationErrorReason;
    private final Optional<String> token;
    private final Optional<TokenVerificationResponse<?>> tokenVerificationResponse;

    public RequestState(AuthStatus status,
                        Optional<AuthErrorReason> authErrorReason,
                        Optional<TokenVerificationErrorReason> tokenVerificationErrorReason,
                        Optional<String> token,
                        Optional<TokenVerificationResponse<?>> tokenVerificationResponse) {
        Utils.checkNotNull(status, "status");
        Utils.checkNotNull(authErrorReason, "authErrorReason");
        Utils.checkNotNull(tokenVerificationErrorReason, "tokenVerificationErrorReason");
        Utils.checkNotNull(token, "token");

        if (authErrorReason.isPresent() && tokenVerificationErrorReason.isPresent()) {
            throw new IllegalArgumentException("Only one of authErrorReason or tokenVerificationErrorReason should be provided.");
        }

        this.status = status;
        this.authErrorReason = authErrorReason;
        this.tokenVerificationErrorReason = tokenVerificationErrorReason;
        this.token = token;
        this.tokenVerificationResponse = tokenVerificationResponse;
    }

    public static RequestState signedIn(String token, TokenVerificationResponse<?> tokenVerificationResponse) {
        return new RequestState(AuthStatus.SIGNED_IN,
                                Optional.empty(),
                                Optional.empty(),
                                Optional.of(token),
                                Optional.of(tokenVerificationResponse));
    }

    public static RequestState signedOut(AuthErrorReason reason) {
        return new RequestState(AuthStatus.SIGNED_OUT,
                                Optional.of(reason),
                                Optional.empty(),
                                Optional.empty(),
            Optional.empty());
    }

    public static RequestState signedOut(TokenVerificationErrorReason reason) {
        return new RequestState(AuthStatus.SIGNED_OUT,
                                Optional.empty(),
                                Optional.of(reason),
                                Optional.empty(),
            Optional.empty());
    }

    public AuthStatus status() {
        return status;
    }

    public boolean isSignedIn() {
        return status == AuthStatus.SIGNED_IN;
    }

    public boolean isAuthenticated() {
        return isSignedIn();
    }

    public boolean isSignedOut() {
        return status == AuthStatus.SIGNED_OUT;
    }

    public Optional<ErrorReason> reason() {
        if (authErrorReason.isPresent()) {
            return Optional.of(authErrorReason.get());
        }

        if (tokenVerificationErrorReason.isPresent()) {
            return Optional.of(tokenVerificationErrorReason.get());
        }

        return Optional.empty();
    }

    public Optional<String> token() {
        return token;
    }

    public Optional<Claims> claims() {

        if (tokenVerificationResponse.isPresent()) {
            TokenVerificationResponse<?> response = tokenVerificationResponse.get();
            if (response.payload() instanceof Claims) {
                return Optional.of((Claims) response.payload());
            }
        }
        return Optional.empty();
    }

    public Optional<TokenVerificationResponse<?>> tokenVerificationResponse() {return tokenVerificationResponse;}

    public AuthObject toAuth() {
        if (status != AuthStatus.SIGNED_IN) {
            throw new IllegalStateException("Cannot convert to AuthObject in unauthenticated state.");
        }

        if (tokenVerificationResponse.isEmpty()) {
            throw new IllegalArgumentException("Payload must be provided for authenticated states.");
        }

        TokenType tokenType = getTokenType(token.get());

        switch (tokenType) {
            case SESSION_TOKEN:
                Map<String, Object> payload = new HashMap<>((Map<String, Object>) tokenVerificationResponse.get().payload());
                Integer version = (Integer) payload.getOrDefault("v", null);
                if (version != null && version == 2) {
                    return new SessionAuthObjectV2(
                        (Integer) payload.getOrDefault("exp", null),
                        (Integer) payload.getOrDefault("iat", null),
                        (String) payload.getOrDefault("iss", null),
                        (String) payload.getOrDefault("sid", null),
                        (String) payload.getOrDefault("sub", null),
                        version,
                        (String) payload.getOrDefault("jti", null),
                        (String) payload.getOrDefault("role", null),
                        (List<Integer>) payload.getOrDefault("fva", null),
                        (Integer) payload.getOrDefault("nbf", null),
                        (String) payload.getOrDefault("email", null),
                        (String) payload.getOrDefault("azp", null)
                    );
                } else {
                    return new SessionAuthObjectV1(
                        (String) payload.getOrDefault("sid", null),
                        (String) payload.getOrDefault("sub", null),
                        (String) payload.getOrDefault("org_id", null),
                        (String) payload.getOrDefault("org_role", null),
                        (List<String>) payload.getOrDefault("org_permissions", null),
                        (List<Integer>) payload.getOrDefault("fva", null),
                        payload
                    );
                }

            case OAUTH_TOKEN:
                MachineAuthVerificationData oAuthData = (MachineAuthVerificationData) tokenVerificationResponse.get().payload();
                return new OAuthMachineAuthObject(
                    oAuthData.getId(),
                    oAuthData.getSubject(),
                     oAuthData.getClientId(),
                    oAuthData.getName(),
                    oAuthData.getScopes()
                );

            case API_KEY:
                MachineAuthVerificationData apiKeyData = (MachineAuthVerificationData) tokenVerificationResponse.get().payload();
                return new APIKeyMachineAuthObject(
                    apiKeyData.getId(),
                    apiKeyData.getSubject(),
                    null,
                    apiKeyData.getName(),
                    apiKeyData.getScopes(),
                    apiKeyData.getClaims()
                );


            case MACHINE_TOKEN:
                MachineAuthVerificationData machineData = (MachineAuthVerificationData) tokenVerificationResponse.get().payload();
                return new M2MMachineAuthObject(
                    machineData.getId(),
                    machineData.getSubject(),
                    machineData.getClientId(),
                    machineData.getName(),
                    machineData.getScopes(),
                    machineData.getClaims()
                );

            default:
                throw new IllegalArgumentException("Unsupported token type: " + tokenType);
        }
    }

}
