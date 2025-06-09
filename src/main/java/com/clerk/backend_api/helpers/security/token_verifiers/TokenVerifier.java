package com.clerk.backend_api.helpers.security.token_verifiers;

import com.clerk.backend_api.helpers.security.models.TokenVerificationException;
import com.clerk.backend_api.helpers.security.models.TokenVerificationResponse;
import com.clerk.backend_api.helpers.security.models.VerifyTokenOptions;
import java.io.IOException;

public interface TokenVerifier {

    TokenVerificationResponse<?> verify(String token, VerifyTokenOptions options)
        throws IOException, InterruptedException, TokenVerificationException;

}
