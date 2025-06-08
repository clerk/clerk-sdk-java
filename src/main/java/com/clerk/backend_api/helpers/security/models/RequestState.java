package com.clerk.backend_api.helpers.security.models;

import io.jsonwebtoken.Claims;
import java.util.Optional;
import com.clerk.backend_api.utils.Utils;

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

//    public static RequestState signedIn(String token, Claims claims) {
//        return new RequestState(AuthStatus.SIGNED_IN,
//                                Optional.empty(),
//                                Optional.empty(),
//                                Optional.of(token),
//                                Optional.of(claims),
//                                Optional.of(new TokenVerificationResponse<>(claims)));
//    }

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
}
