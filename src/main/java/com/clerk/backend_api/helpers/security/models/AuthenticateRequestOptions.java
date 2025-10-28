package com.clerk.backend_api.helpers.security.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.clerk.backend_api.utils.Utils;
import java.util.stream.Collectors;

/**
 * AuthenticateRequestOptions - Options to configure AuthenticateRequest.
 */
public final class AuthenticateRequestOptions {

    private static final long DEFAULT_CLOCK_SKEW_MS = 5000L;

    private final Optional<String> secretKey;
    private final Optional<String> jwtKey;
    private final Optional<String> machineSecretKey;
    private final Optional<String> audience;
    private final Set<String> authorizedParties;
    private final long clockSkewInMs;
    private final List<String> acceptsToken;
    private final boolean skipJwksCache;

    /**
     * Options to configure AuthenticateRequest.
     *
     * @param secretKey         The Clerk secret key from the API Keys page in the
     *                          Clerk Dashboard. (Optional)
     * @param jwtKey            PEM Public String used to verify the session token
     *                          in a networkless manner. (Optional)
     * @param audience          An audience to verify against. (Optional)
     * @param authorizedParties An allowlist of origins to verify against.
     *                          (Optional)
     * @param clockSkewInMs     Allowed time difference (in milliseconds) between
     *                          the Clerk server (which generates the token)
     *                          and the clock of the user's application server when
     *                          validating a token. Defaults to 5000 ms.
     */
    public AuthenticateRequestOptions(
            Optional<String> secretKey,
            Optional<String> jwtKey,
            Optional<String> machineSecretKey,
            Optional<String> audience,
            Set<String> authorizedParties,
            Optional<Long> clockSkewInMs,
            Optional<List<String>> acceptsToken,
            boolean skipJwksCache
        ) {

        Utils.checkNotNull(secretKey, "secretKey");
        Utils.checkNotNull(jwtKey, "jwtKey");
        Utils.checkNotNull(machineSecretKey, "machineSecretKey");
        Utils.checkNotNull(audience, "audience");
        Utils.checkNotNull(authorizedParties, "authorizedParties");
        Utils.checkNotNull(clockSkewInMs, "clockSkewInMs");

        this.secretKey = secretKey;
        this.jwtKey = jwtKey;
        this.machineSecretKey = machineSecretKey;
        this.audience = audience;
        this.authorizedParties = authorizedParties;
        this.clockSkewInMs = clockSkewInMs.orElse(DEFAULT_CLOCK_SKEW_MS);
        this.acceptsToken = acceptsToken.orElse(TokenType.getAllTypes().stream().map(TokenType::getType).collect(
            Collectors.toList())
        );
        this.skipJwksCache = skipJwksCache;
    }

    public Optional<String> secretKey() {
        return secretKey;
    }

    public Optional<String> jwtKey() {
        return jwtKey;
    }

    public Optional<String> machineSecretKey() {
        return machineSecretKey;
    }

    public Optional<String> audience() {
        return audience;
    }

    public Set<String> authorizedParties() {
        return authorizedParties;
    }

    public long clockSkewInMs() {
        return clockSkewInMs;
    }

    public List<String> acceptsToken() {
        return acceptsToken;
    }

    public boolean skipJwksCache() {
        return skipJwksCache;
    }

    public static Builder secretKey(String secretKey) {
        return Builder.withSecretKey(secretKey);
    }

    public static Builder jwtKey(String jwtKey) {
        return Builder.withJwtKey(jwtKey);
    }

    public static Builder acceptsToken(List<String> acceptsToken) {
        Utils.checkNotNull(acceptsToken, "acceptsToken");
        return new Builder().acceptsTokens(acceptsToken);
    }

    public static final class Builder {

        private Optional<String> secretKey = Optional.empty();
        private Optional<String> jwtKey = Optional.empty();
        private Optional<String> machineSecretKey = Optional.empty();
        private Optional<String> audience = Optional.empty();
        private Set<String> authorizedParties = new HashSet<>();
        private Optional<List<String>> acceptsToken = Optional.empty();
        private long clockSkewInMs = DEFAULT_CLOCK_SKEW_MS;
        private boolean skipJwksCache = false;
        private Builder() {}

        public static Builder withSecretKey(String secretKey) {
            Utils.checkNotNull(secretKey, "secretKey");
            Builder builder = new Builder();
            builder.secretKey = Optional.of(secretKey);
            return builder;
        }

        public static Builder withJwtKey(String jwtKey) {
            Utils.checkNotNull(jwtKey, "jwtKey");
            Builder builder = new Builder();
            builder.jwtKey = Optional.of(jwtKey);
            return builder;
        }

        public static Builder withMachineSecretKey(String machineSecretKey) {
            Utils.checkNotNull(machineSecretKey, "machineSecretKey");
            Builder builder = new Builder();
            builder.machineSecretKey = Optional.of(machineSecretKey);
            return builder;
        }

        public Builder audience(String audience) {
            Utils.checkNotNull(audience, "audience");
            return audience(Optional.of(audience));
        }

        public Builder audience(Optional<String> audience) {
            Utils.checkNotNull(audience, "audience");
            this.audience = audience;
            return this;
        }

        public Builder authorizedParty(String authorizedParty) {
            Utils.checkNotNull(authorizedParty, "authorizedParty");
            this.authorizedParties.add(authorizedParty);
            return this;
        }

        public Builder authorizedParties(Collection<String> authorizedParties) {
            Utils.checkNotNull(authorizedParties, "authorizedParties");
            this.authorizedParties.addAll(authorizedParties);
            return this;
        }

        public Builder clockSkew(long duration, TimeUnit unit) {
            this.clockSkewInMs = unit.toMillis(duration);
            return this;
        }

        public Builder clockSkew(Optional<Long> duration, TimeUnit unit) {
            Utils.checkNotNull(clockSkewInMs, "clockSkewInMs");
            if (duration.isPresent()) {
                return clockSkew(duration.get(), unit);
            }
            return clockSkew(DEFAULT_CLOCK_SKEW_MS, TimeUnit.MILLISECONDS);
        }

        public Builder acceptsTokens(List<String> acceptsToken) {
            Utils.checkNotNull(acceptsToken, "acceptsToken");
            this.acceptsToken = Optional.of(acceptsToken);
            return this;
        }

        public Builder skipJwksCache(boolean skipJwksCache) {
            this.skipJwksCache = skipJwksCache;
            return this;
        }

        public AuthenticateRequestOptions build() {
            return new AuthenticateRequestOptions(secretKey,
                    jwtKey,
                    machineSecretKey,
                    audience,
                    authorizedParties,
                    Optional.of(clockSkewInMs),acceptsToken, skipJwksCache);
        }
    }
}
