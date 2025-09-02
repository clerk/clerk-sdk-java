package com.clerk.backend_api.helpers.security.token_verifiers.impl;

import com.clerk.backend_api.helpers.security.models.TokenVerificationErrorReason;
import com.clerk.backend_api.helpers.security.models.TokenVerificationException;
import com.clerk.backend_api.helpers.security.models.TokenVerificationResponse;
import com.clerk.backend_api.helpers.security.models.VerifyTokenOptions;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.JwtParserBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.PrematureJwtException;
import io.jsonwebtoken.impl.DefaultClaims;
import io.jsonwebtoken.impl.security.ConstantKeyLocator;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JwtSessionTokenVerifier {

    /**
     * Verifies a Clerk-generated token signature. Networkless if the options.jwtKey
     * is provided.
     * Otherwise, performs a network call to retrieve the JWKS from Clerk's Backend
     * API.
     *
     * @param token   The token to verify.
     * @param options The options associated with parsing and verifying the JWT.
     * @return Claims (being a map of properties with specialized accessors for
     *         standard claim properties).
     * @throws TokenVerificationException if token does not verify. A
     *                causing exception if present should not be considered part of
     *                the public API (subject to change).
     */
    public static TokenVerificationResponse<Claims> verify(String token, VerifyTokenOptions options) throws TokenVerificationException {

        Key key;
        if (options.jwtKey().isPresent()) {
            key = getLocalJwtKey(options.jwtKey().get());
        } else if (options.secretKey().isPresent()) {
            key = getRemoteJwtKey(token, options);
        }
        else {
            throw new TokenVerificationException(TokenVerificationErrorReason.SECRET_KEY_MISSING);
        }

        JwtParserBuilder builder = Jwts //
            .parser() //
            .clockSkewSeconds(options.clockSkewInMs() / 1000) //
            .keyLocator(new ConstantKeyLocator(key, null));

        options.audience().ifPresent(builder::requireAudience);

        JwtParser parser = builder.build();

        Claims payload;

        try {
            // note that exp (expiration) and nbf (not before) are enforced by the parser
            // so we don't have to make additional checks for them
            // ExpiredJwtException, PrematureJwtException are thrown

            // the presence of a subject field is also enforced by the parser
            // JwtException is thrown

            payload = parser.parseSignedClaims(token).getPayload();
        } catch (ExpiredJwtException e) {
            throw new TokenVerificationException(TokenVerificationErrorReason.TOKEN_EXPIRED, e);
        } catch (PrematureJwtException e) {
            throw new TokenVerificationException(TokenVerificationErrorReason.TOKEN_NOT_ACTIVE_YET, e);
        } catch (JwtException e) {
            throw new TokenVerificationException(TokenVerificationErrorReason.TOKEN_INVALID, e);
        }

        String azp = (String) payload.get("azp");
        if (azp != null && !options.authorizedParties().isEmpty()) {
            if (!options.authorizedParties().contains(azp)) {
                throw new TokenVerificationException(TokenVerificationErrorReason.TOKEN_INVALID_AUTHORIZED_PARTIES);
            }
        }

        Date iat = payload.getIssuedAt();
        Date now = new Date();
        if (iat != null && iat.getTime() > now.getTime() + options.clockSkewInMs()) {
            throw new TokenVerificationException(TokenVerificationErrorReason.TOKEN_IAT_IN_THE_FUTURE);
        }

        Claims claims = payload;
        Map<String, Object> updatedClaimsMap = new HashMap<>(claims);

        if ("2".equals(String.valueOf(claims.get("v")))) {
            Object orgObject = claims.get("o");
            if (orgObject instanceof Map) {
                @SuppressWarnings("unchecked")
                Map<String, Object> orgClaims = (Map<String, Object>) orgObject;

                updatedClaimsMap.put("org_id", orgClaims.get("id"));
                updatedClaimsMap.put("org_slug", orgClaims.get("slg"));
                updatedClaimsMap.put("org_role", orgClaims.get("rol"));

                List<String> orgPermissions = computeOrgPermissions(claims);
                if (!orgPermissions.isEmpty()) {
                    updatedClaimsMap.put("org_permissions", orgPermissions);
                }
            }
        }

        Claims updatedClaims = new DefaultClaims(updatedClaimsMap);

        return new TokenVerificationResponse<>(updatedClaims);
    }

    @SuppressWarnings("unchecked")
    private static List<String> computeOrgPermissions(Claims claims) {
        String featuresStr = (String) claims.get("fea");
        if (featuresStr == null) {
            return new ArrayList<>();
        }
        String permissionsStr = (String) ((Map<String, Object>) claims.get("o")).get("per");
        String mappingsStr = (String) ((Map<String, Object>) claims.get("o")).get("fpm");

        String[] features = featuresStr.split(",");
        String[] permissions = permissionsStr.split(",");
        String[] mappings = mappingsStr.split(",");

        List<String> orgPermissions = new ArrayList<>();

        for (int idx = 0; idx < mappings.length; idx++) {
            String mapping = mappings[idx];
            String[] featureParts = features[idx].split(":");
            if (featureParts.length != 2) continue;

            String scope = featureParts[0];
            String feature = featureParts[1];

            if (!scope.contains("o")) continue;

            String binary = Integer.toBinaryString(Integer.parseInt(mapping)).replaceAll("^0+", "");
            String reversedBinary = new StringBuilder(binary).reverse().toString();

            for (int i = 0; i < reversedBinary.length(); i++) {
                if (reversedBinary.charAt(i) == '1' && i < permissions.length) {
                    orgPermissions.add("org:" + feature + ":" + permissions[i]);
                }
            }
        }

        return orgPermissions;
    }

    /**
     * Converts a RSA PEM formatted public key to a Key object
     * that can be used for networkless verification.
     *
     * @param jwtKey The PEM formatted public key.
     * @return The RSA public key
     * @throws TokenVerificationException if the public key could not be resolved.
     */
    private static Key getLocalJwtKey(String jwtKey) throws TokenVerificationException {

        String pemContent = jwtKey.replace("-----BEGIN PUBLIC KEY-----", "")
            .replace("-----END PUBLIC KEY-----", "")
            .replaceAll("\\s", "");

        try {
            byte[] decodedKey = Base64.getDecoder().decode(pemContent);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decodedKey);
            KeyFactory kf = KeyFactory.getInstance("RSA");
            return kf.generatePublic(keySpec);
        } catch (Exception e) {
            throw new TokenVerificationException(TokenVerificationErrorReason.JWK_LOCAL_INVALID, e);
        }
    }

    /**
     * Retrieves the RSA public key used to sign the token from Clerk's Backend API.
     *
     * First the key identifier (kid) is parsed from the token header.
     * Then the public key is retrieved from Clerk's JWKS by looking for a matching
     * kid.
     *
     * @param token   The token to parse.
     * @param options The options used for token verification.
     * @return The RSA public key.
     * @throws TokenVerificationException if the public key could not be resolved.
     */
    private static Key getRemoteJwtKey(String token, VerifyTokenOptions options) throws TokenVerificationException {

        String kid = parseKid(token);

        for (JsonNode node : fetchJwks(options)) {
            if (kid.equals(node.get("kid").asText())) {
                try {
                    KeyFactory kf = KeyFactory.getInstance("RSA");
                    BigInteger n = new BigInteger(1, Base64.getUrlDecoder().decode(node.get("n").asText()));
                    BigInteger e = new BigInteger(1, Base64.getUrlDecoder().decode(node.get("e").asText()));
                    return kf.generatePublic(new RSAPublicKeySpec(n, e));

                } catch (Exception e) {
                    throw new TokenVerificationException(TokenVerificationErrorReason.JWK_FAILED_TO_RESOLVE, e);
                }
            }
        }

        throw new TokenVerificationException(TokenVerificationErrorReason.JWK_KID_MISMATCH);
    }

    /**
     * Retrives the key identifier (kid) from the token header.
     *
     * @param token The token to parse.
     * @return The key identifier (kid).
     * @throws TokenVerificationException if the kid cannot be parsed.
     */
    private static String parseKid(String token) throws TokenVerificationException {

        // https://github.com/jwtk/jjwt/discussions/923
        // parseClaimsJwt() is deprecated since version 0.12.0 and
        // parseUnsecuredClaims()
        // does not allow to parse the token header without verifying the JWS signature.
        // Since we are only interested in the kid, the header is parsed manually.

        String[] parts = token.split("\\.");
        if (parts.length != 3) {
            throw new TokenVerificationException(TokenVerificationErrorReason.TOKEN_INVALID);
        }

        String header = new String(Base64.getUrlDecoder().decode(parts[0]));
        ObjectMapper mapper = new ObjectMapper();
        String kid;
        try {
            kid = mapper.readTree(header).get("kid").asText();
        } catch (IOException | NullPointerException e) {
            throw new TokenVerificationException(TokenVerificationErrorReason.TOKEN_INVALID, e);
        }

        return kid;
    }

    /**
     * Fetches the JSON Web Key Set (JWKS) from Clerk's Backend API.
     *
     * @param options The options used for token verification.
     * @return The JWKS keys array as a JSON node.
     * @throws TokenVerificationException if the JWKS cannot be fetched.
     */
    private static JsonNode fetchJwks(VerifyTokenOptions options) throws TokenVerificationException {

        if (options.secretKey().isEmpty()) {
            throw new TokenVerificationException(TokenVerificationErrorReason.SECRET_KEY_MISSING);
        }

        String jwksUrl = String.format("%s/%s/jwks", options.apiUrl(), options.apiVersion());
        String bearerAuth = String.format("Bearer %s", options.secretKey().get());

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(jwksUrl))
            .header("Accept", "application/json")
            .header("Authorization", bearerAuth)
            .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new TokenVerificationException(TokenVerificationErrorReason.JWK_FAILED_TO_LOAD);
            }

            ObjectMapper mapper = new ObjectMapper();
            JsonNode keysNode = mapper.readTree(response.body()).get("keys");

            if (keysNode.isArray()) {
                return keysNode;
            }
            throw new TokenVerificationException(TokenVerificationErrorReason.JWK_REMOTE_INVALID);

        } catch (IOException | InterruptedException e) {
            throw new TokenVerificationException(TokenVerificationErrorReason.JWK_FAILED_TO_LOAD, e);
        }
    }
}
