package com.clerk.backend_api.helpers;

import java.security.Key;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.JwtParserBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.security.ConstantKeyLocator;

/**
 * Helper methods for use with JSON Web Token (JWT).
 */
public final class JwtHelper {

    private JwtHelper() {
        // prevent instantiation (this is a utility class)
    }

    /**
     * Verifies JWT according to the given options. If verified this method will
     * return the claims otherwise it will throw.
     * 
     * @param token   token to verify
     * @param options options associated with parsing and verifying the JWT
     * @return Claims (being a map of properties with specialized accessors for
     *         standard claim properties)
     * @throws {@link TokenVerificationException} if token does not verify. A
     *                causing exception if present should not be considered part of
     *                the public API (subject to change).
     */
    public static Claims verifyJwt(String token, VerifyJwtOptions options) {
        JwtParserBuilder builder = Jwts //
                .parser() //
                .clockSkewSeconds(options.clockSkewInMs() / 1000) //
                .keyLocator(new ConstantKeyLocator(options.key(), null));
        
        options.audience().ifPresent(a -> builder.requireAudience(a));

        JwtParser parser = builder.build();

        Claims payload;

        try {
            // note that exp (expiration) and nbf (not before) are enforced by the parser
            // so we don't have to make additional checks for them
            // ExpiredJwtException, PrematureJwtException are thrown

            // the presence of a subject field is also enforced by the parser
            // JwtException is thrown

            payload = parser.parseSignedClaims(token).getPayload();
        } catch (RuntimeException e) {
            throw new TokenVerificationException(e.getMessage(), e);
        }

        String azp = (String) payload.get("azp");
        if (azp != null && !options.authorizedParties.isEmpty()) {
            if (!options.authorizedParties().contains(azp)) {
                throw new TokenVerificationException("Invalid JWT Authorized party claim (azp) \"" + azp
                        + "\". Expected \"" + options.authorizedParties() + "\"");
            }
        }

        Date iat = payload.getIssuedAt();
        Date now = new Date();
        if (iat != null && iat.getTime() > now.getTime() + options.clockSkewInMs()) {
            throw new TokenVerificationException("JWT issued-at-date claim (iat) is in the future. Issued at date: "
                    + iat + "; Current date: " + now + ";");
        }
        return payload;
    }

    @SuppressWarnings("serial")
    public static final class TokenVerificationException extends RuntimeException {

        public TokenVerificationException(String message, Throwable cause) {
            super(message, cause);
        }

        public TokenVerificationException(String message) {
            super(message);
        }

    }

    public static final class VerifyJwtOptions {

        private static final long DEFAULT_CLOCK_SKEW_MS = 5000L;

        private final Optional<String> audience;
        private final Set<String> authorizedParties;
        private final long clockSkewInMs;
        private final Key key;

        public VerifyJwtOptions( //
                Optional<String> audience, //
                Set<String> authorizedParties, //
                Optional<Long> clockSkewInMs, //
                Key key) {
            checkNotNull(audience, "audience");
            checkNotNull(authorizedParties, "authorizedParties");
            checkNotNull(clockSkewInMs, "clockSkewInMs");
            checkNotNull(key, "key");
            this.audience = audience;
            this.authorizedParties = authorizedParties;
            this.clockSkewInMs = clockSkewInMs.orElse(DEFAULT_CLOCK_SKEW_MS);
            this.key = key;
        }

        public Key key() {
            return key;
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

        public static BuilderWithKey key(Key key) {
            return builder().key(key);
        }

        public static final class Builder {

            public BuilderWithKey key(Key key) {
                checkNotNull(key, "key");
                return new BuilderWithKey(key);
            }
        }

        public static final class BuilderWithKey {

            private final Key key;
            private Optional<String> audience = Optional.empty();
            private Set<String> authorizedParties = new HashSet<>();
            private long clockSkewInMs = 5000L;

            BuilderWithKey(Key key) {
                this.key = key;
            }

            public BuilderWithKey audience(String audience) {
                checkNotNull(audience, "audience");
                return audience(Optional.of(audience));
            }

            public BuilderWithKey audience(Optional<String> audience) {
                checkNotNull(audience, "audience");
                this.audience = audience;
                return this;
            }

            public BuilderWithKey authorizedParty(String authorizedParty) {
                checkNotNull(authorizedParty, "authorizedParty");
                this.authorizedParties.add(authorizedParty);
                return this;
            }

            public BuilderWithKey authorizedParties(Collection<String> authorizedParties) {
                checkNotNull(authorizedParties, "authorizedParties");
                this.authorizedParties.addAll(authorizedParties);
                return this;
            }

            public BuilderWithKey clockSkew(long duration, TimeUnit unit) {
                this.clockSkewInMs = unit.toMillis(duration);
                return this;
            }

            public BuilderWithKey clockSkew(Optional<Long> duration, TimeUnit unit) {
                checkNotNull(clockSkewInMs, "clockSkewInMs");
                if (duration.isPresent()) {
                    return clockSkew(duration.get(), unit);
                } else {
                    return clockSkew(DEFAULT_CLOCK_SKEW_MS, TimeUnit.MILLISECONDS);
                }
            }

            public VerifyJwtOptions build() {
                return new VerifyJwtOptions(audience, authorizedParties, Optional.of(clockSkewInMs), key);
            }
        }
    }

    private static <T> T checkNotNull(T t, String name) {
        if (t == null) {
            // IllegalArgumentException is more appropriate than NullPointerException
            // which is often associated with bugs.
            throw new IllegalArgumentException(name + " cannot be null");
        } else {
            return t;
        }
    }
}
