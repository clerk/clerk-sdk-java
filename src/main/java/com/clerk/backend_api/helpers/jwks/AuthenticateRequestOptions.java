package com.clerk.backend_api.helpers.jwks;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.clerk.backend_api.utils.Utils;

/**
 * AuthenticateRequestOptions - Options to configure AuthenticateRequest.
 */
public final class AuthenticateRequestOptions {

    private static final long DEFAULT_CLOCK_SKEW_MS = 5000L;

    private final Optional<String> secretKey;
    private final Optional<String> jwtKey;
    private final Optional<String> audience;
    private final Set<String> authorizedParties;
    private final long clockSkewInMs;

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
            Optional<String> audience,
            Set<String> authorizedParties,
            Optional<Long> clockSkewInMs) {

        Utils.checkNotNull(secretKey, "secretKey");
        Utils.checkNotNull(jwtKey, "jwtKey");
        Utils.checkNotNull(audience, "audience");
        Utils.checkNotNull(authorizedParties, "authorizedParties");
        Utils.checkNotNull(clockSkewInMs, "clockSkewInMs");

        this.secretKey = secretKey;
        this.jwtKey = jwtKey;
        this.audience = audience;
        this.authorizedParties = authorizedParties;
        this.clockSkewInMs = clockSkewInMs.orElse(DEFAULT_CLOCK_SKEW_MS);
    }

    public Optional<String> secretKey() {
        return secretKey;
    }

    public Optional<String> jwtKey() {
        return jwtKey;
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

    public static Builder builder() {
        return new Builder();
    }

    public static BuilderWithKey secretKey(String secretKey) {
        return builder().secretKey(secretKey);
    }

    public static BuilderWithJwtKey jwtKey(String jwtKey) {
        return builder().jwtKey(jwtKey);
    }

    public static final class Builder {

        public BuilderWithSecretKey secretKey(String secretKey) {
            Utils.checkNotNull(secretKey, "secretKey");
            return new BuilderWithSecretKey(secretKey);
        }

        public BuilderWithJwtKey jwtKey(String jwtKey) {
            Utils.checkNotNull(jwtKey, "jwtKey");
            return new BuilderWithJwtKey(jwtKey);
        }
    }

    public static final class BuilderWithSecretKey extends BuilderWithKey {
        BuilderWithSecretKey(String secretKey) {
            super(Optional.of(secretKey), Optional.empty());
        }
    }

    public static final class BuilderWithJwtKey extends BuilderWithKey {
        BuilderWithJwtKey(String jwtKey) {
            super(Optional.empty(), Optional.of(jwtKey));
        }
    }

    public static class BuilderWithKey {

        private Optional<String> secretKey = Optional.empty();
        private Optional<String> jwtKey = Optional.empty();

        private Optional<String> audience = Optional.empty();
        private Set<String> authorizedParties = new HashSet<>();
        private long clockSkewInMs = DEFAULT_CLOCK_SKEW_MS;

        private BuilderWithKey(Optional<String> secretKey, Optional<String> jwtKey) {
            Utils.checkNotNull(secretKey, "secretKey");
            Utils.checkNotNull(jwtKey, "jwtKey");
            this.secretKey = secretKey;
            this.jwtKey = jwtKey;
        }

        public BuilderWithKey audience(String audience) {
            Utils.checkNotNull(audience, "audience");
            return audience(Optional.of(audience));
        }

        public BuilderWithKey audience(Optional<String> audience) {
            Utils.checkNotNull(audience, "audience");
            this.audience = audience;
            return this;
        }

        public BuilderWithKey authorizedParty(String authorizedParty) {
            Utils.checkNotNull(authorizedParty, "authorizedParty");
            this.authorizedParties.add(authorizedParty);
            return this;
        }

        public BuilderWithKey authorizedParties(Collection<String> authorizedParties) {
            Utils.checkNotNull(authorizedParties, "authorizedParties");
            this.authorizedParties.addAll(authorizedParties);
            return this;
        }

        public BuilderWithKey clockSkew(long duration, TimeUnit unit) {
            this.clockSkewInMs = unit.toMillis(duration);
            return this;
        }

        public BuilderWithKey clockSkew(Optional<Long> duration, TimeUnit unit) {
            Utils.checkNotNull(clockSkewInMs, "clockSkewInMs");
            if (duration.isPresent()) {
                return clockSkew(duration.get(), unit);
            }
            return clockSkew(DEFAULT_CLOCK_SKEW_MS, TimeUnit.MILLISECONDS);
        }

        public AuthenticateRequestOptions build() {
            return new AuthenticateRequestOptions(secretKey,
                    jwtKey,
                    audience,
                    authorizedParties,
                    Optional.of(clockSkewInMs));
        }
    }
}
