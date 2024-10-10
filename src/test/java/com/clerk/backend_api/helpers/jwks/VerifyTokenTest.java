package com.clerk.backend_api.helpers.jwks;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.ConnectException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.IncorrectClaimException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.PrematureJwtException;
import io.jsonwebtoken.UnsupportedJwtException;


public class VerifyTokenTest {

    private static PrivateKey privateKey;  // private key used to sign JWTs
    private static String jwtKey;  // PEM formatted public key
    private static String validToken;

    @BeforeAll
    static void setupAll() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            privateKey = keyPair.getPrivate();

            PublicKey rsaPublicKey = keyPair.getPublic();
            String base64EncodedKey = Base64.getEncoder().encodeToString(rsaPublicKey.getEncoded());
            jwtKey = "-----BEGIN PUBLIC KEY-----\n";
            jwtKey += base64EncodedKey;
            jwtKey += "\n-----END PUBLIC KEY-----";
        } catch (Exception e) {
            System.out.println("ERROR: could not generate RSA KeyPair. " + e.getMessage());
        }

        validToken = Jwts.builder() //
                .subject("Joe") //
                .audience().add("aud1") //
                .and() //
                .header().add("kid", "ins_abcdefghijklmnopqrstuvwxyz0") //
                .and() //
                .expiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(1))) //
                .notBefore(new Date(System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(1))) //
                .issuedAt(new Date(System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(1))) //
                .signWith(privateKey) //
                .compact();
    }

    @Test
    public void testVerifiesOk() {
        assertDoesNotThrow(() -> VerifyToken.verifyToken(validToken, VerifyTokenOptions.jwtKey(jwtKey).build()));
    }

    @Test
    public void testInvalidApiUrl() {

        TokenVerificationException t = assertThrows(TokenVerificationException.class,
                () -> VerifyToken.verifyToken(validToken, VerifyTokenOptions //
                        .secretKey("sk_test_SecretKey") //
                        .apiUrl("https://invalid.com") //
                        .build()));
        assertEquals(TokenVerificationErrorReason.JWK_FAILED_TO_LOAD, t.reason());
        assertTrue(t.getCause() instanceof ConnectException);
    }

    @Test
    public void testInvalidSecretKey() {

        TokenVerificationException t = assertThrows(TokenVerificationException.class,
                () -> VerifyToken.verifyToken(validToken, VerifyTokenOptions //
                        .secretKey("sk_test_InvalidKey") //
                        .build()));
        assertEquals(TokenVerificationErrorReason.JWK_FAILED_TO_LOAD, t.reason());
        assertNull(t.getCause());
    }

    @Test
    public void testFailsNoSubject() {
        String token = Jwts.builder() //
                .signWith(privateKey) //
                .compact();
        TokenVerificationException t = assertThrows(TokenVerificationException.class,
                () -> VerifyToken.verifyToken(token, VerifyTokenOptions.jwtKey(jwtKey).build()));
        // not part of public API but worth checking
        assertTrue(t.getCause() instanceof UnsupportedJwtException);
    }

    @Test
    public void testFailsNullKey() {
        assertThrows(IllegalArgumentException.class, () -> VerifyTokenOptions.jwtKey(null));
    }

    @Test
    public void testFailsVerifyExpired() {
        String token = Jwts.builder() //
                .subject("Joe") //
                .expiration(new Date(System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(1))) //
                .signWith(privateKey) //
                .compact();
        TokenVerificationException t = assertThrows(TokenVerificationException.class,
                () -> VerifyToken.verifyToken(token, VerifyTokenOptions //
                        .jwtKey(jwtKey) //
                        .clockSkew(Optional.empty(), TimeUnit.MILLISECONDS) //
                        .build()));
        assertEquals(TokenVerificationErrorReason.TOKEN_EXPIRED, t.reason());
        assertTrue(t.getCause() instanceof ExpiredJwtException);
    }

    @Test
    public void testVerifyDoesNotExpireWithLargeClockSkew() {
        String token = Jwts.builder() //
                .subject("Joe") //
                .expiration(new Date(System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(1))) //
                .signWith(privateKey) //
                .compact();
        assertDoesNotThrow(() -> VerifyToken.verifyToken(token, VerifyTokenOptions //
                .jwtKey(jwtKey) //
                .clockSkew(Optional.of(3L), TimeUnit.MINUTES) //
                .build()));
    }

    @Test
    public void testFailsVerifyNotBefore() {
        String token = Jwts.builder() //
                .subject("Joe") //
                .notBefore(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(1))) //
                .issuedAt(new Date(System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(1))) //
                .signWith(privateKey) //
                .compact();
        TokenVerificationException t = assertThrows(TokenVerificationException.class,
                () -> VerifyToken.verifyToken(token, VerifyTokenOptions.jwtKey(jwtKey).build()));

        assertEquals(TokenVerificationErrorReason.TOKEN_NOT_ACTIVE_YET, t.reason());
        assertTrue(t.getCause() instanceof PrematureJwtException);
    }

    @Test
    public void testFailsIssuedAt() {
        String token = Jwts.builder() //
                .subject("Joe") //
                .issuedAt(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(1))) //
                .signWith(privateKey) //
                .compact();
        TokenVerificationException t = assertThrows(TokenVerificationException.class,
                () -> VerifyToken.verifyToken(token, VerifyTokenOptions.jwtKey(jwtKey).build()));
        assertEquals(TokenVerificationErrorReason.TOKEN_IAT_IN_THE_FUTURE, t.reason());
        assertNull(t.getCause());
    }

    @Test
    public void testFailsAudience() {
        String token = Jwts.builder() //
                .subject("Joe") //
                .audience().add("aud1").add("aud2") //
                .and() //
                .signWith(privateKey) //
                .compact();
        TokenVerificationException t = assertThrows(TokenVerificationException.class,
                () -> VerifyToken.verifyToken(token, VerifyTokenOptions //
                        .jwtKey(jwtKey) //
                        .audience("aud3") //
                        .build()));
        assertEquals(TokenVerificationErrorReason.TOKEN_INVALID, t.reason());
        assertTrue(t.getCause() instanceof IncorrectClaimException);
    }

    @Test
    public void testVerifiesEmptyAuthorizedParties() {
        String token = Jwts.builder() //
                .subject("Joe") //
                .claim("azp", "partyparty") //
                .audience().add("aud1").add("aud2") //
                .and() //
                .signWith(privateKey) //
                .compact();

        assertDoesNotThrow(() -> VerifyToken.verifyToken(token, VerifyTokenOptions.jwtKey(jwtKey).build()));
    }

    @Test
    public void testVerifiesNonEmptyAuthorizedParties() {
        String token = Jwts.builder() //
                .subject("Joe") //
                .claim("azp", "partyparty") //
                .audience().add("aud1").add("aud2") //
                .and() //
                .signWith(privateKey) //
                .compact();

        assertDoesNotThrow(() -> VerifyToken.verifyToken(token, VerifyTokenOptions //
                .jwtKey(jwtKey) //
                .authorizedParties(List.of("boo")) //
                .authorizedParty("partyparty") //
                .build()));
    }

    @Test
    public void testFailsAuthorizedParties() {
        String token = Jwts.builder() //
                .subject("Joe") //
                .claim("azp", "partyparty") //
                .audience().add("aud1").add("aud2") //
                .and() //
                .signWith(privateKey) //
                .compact();
        TokenVerificationException t = assertThrows(TokenVerificationException.class,
                () -> VerifyToken.verifyToken(token, VerifyTokenOptions //
                        .jwtKey(jwtKey) //
                        .authorizedParty("bill") //
                        .build()));
        assertEquals(TokenVerificationErrorReason.TOKEN_INVALID_AUTHORIZED_PARTIES, t.reason());
        assertNull(t.getCause());
    }

}
