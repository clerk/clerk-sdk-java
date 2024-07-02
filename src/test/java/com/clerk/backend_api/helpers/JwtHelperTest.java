package com.clerk.backend_api.helpers;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import javax.crypto.SecretKey;

import org.junit.jupiter.api.Test;

import com.clerk.backend_api.helpers.JwtHelper.TokenVerificationException;
import com.clerk.backend_api.helpers.JwtHelper.VerifyJwtOptions;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.PrematureJwtException;
import io.jsonwebtoken.UnsupportedJwtException;

public class JwtHelperTest {

    @Test
    public void testVerifiesOk() {
        SecretKey key = Jwts.SIG.HS256.key().build();
        String token = Jwts.builder() //
                .subject("Joe") //
                .audience().add("aud1") //
                .and() //
                .expiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(1))) //
                .notBefore(new Date(System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(1))) //
                .issuedAt(new Date(System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(1))) //
                .signWith(key) //
                .compact();
        JwtHelper.verifyJwt(token, VerifyJwtOptions.key(key).build());
    }

    @Test
    public void testFailsNoSubject() {
        SecretKey key = Jwts.SIG.HS256.key().build();
        String token = Jwts.builder() //
                .signWith(key) //
                .compact();
        TokenVerificationException t = assertThrows(TokenVerificationException.class,
                () -> JwtHelper.verifyJwt(token, VerifyJwtOptions.key(key).build()));
        // not part of public API but worth checking
        assertTrue(t.getCause() instanceof UnsupportedJwtException);
    }
    
    @Test
    public void testFailsNullKey() {
        assertThrows(IllegalArgumentException.class, () -> VerifyJwtOptions.key(null));
    }


    @Test
    public void testFailsVerifyExpired() {
        SecretKey key = Jwts.SIG.HS256.key().build();
        String token = Jwts.builder() //
                .subject("Joe") //
                .expiration(new Date(System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(1))) //
                .signWith(key) //
                .compact();
        TokenVerificationException t = assertThrows(TokenVerificationException.class,
                () -> JwtHelper.verifyJwt(token, VerifyJwtOptions //
                        .key(key) //
                        .clockSkew(Optional.empty(), TimeUnit.MILLISECONDS) //
                        .build()));
        assertTrue(t.getCause() instanceof ExpiredJwtException);
    }

    @Test
    public void testVerifyDoesNotExpireWithLargeClockSkew() {
        SecretKey key = Jwts.SIG.HS256.key().build();
        String token = Jwts.builder() //
                .subject("Joe") //
                .expiration(new Date(System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(1))) //
                .signWith(key) //
                .compact();
        JwtHelper.verifyJwt(token, VerifyJwtOptions //
                .key(key) //
                .clockSkew(Optional.of(3L), TimeUnit.MINUTES) //
                .build());
    }

    @Test
    public void testFailsVerifyNotBefore() {
        SecretKey key = Jwts.SIG.HS256.key().build();
        String token = Jwts.builder() //
                .subject("Joe") //
                .notBefore(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(1))) //
                .issuedAt(new Date(System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(1))) //
                .signWith(key) //
                .compact();
        TokenVerificationException t = assertThrows(TokenVerificationException.class,
                () -> JwtHelper.verifyJwt(token, VerifyJwtOptions.key(key).build()));
        assertTrue(t.getCause() instanceof PrematureJwtException);
    }

    @Test
    public void testFailsIssuedAt() {
        SecretKey key = Jwts.SIG.HS256.key().build();
        String token = Jwts.builder() //
                .subject("Joe") //
                .issuedAt(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(1))) //
                .signWith(key) //
                .compact();
        TokenVerificationException t = assertThrows(TokenVerificationException.class,
                () -> JwtHelper.verifyJwt(token, VerifyJwtOptions.key(key).build()));
        assertTrue(t.getMessage().startsWith("JWT issued-at-date claim (iat) is in the future"));
        assertNull(t.getCause());
    }

    @Test
    public void testFailsAudience() {
        SecretKey key = Jwts.SIG.HS256.key().build();
        String token = Jwts.builder() //
                .subject("Joe") //
                .audience().add("aud1").add("aud2") //
                .and() //
                .signWith(key) //
                .compact();
        TokenVerificationException t = assertThrows(TokenVerificationException.class,
                () -> JwtHelper.verifyJwt(token, VerifyJwtOptions.key(key).audience("aud3").build()));
        assertTrue(t.getMessage().startsWith("Missing expected"));
    }

    @Test
    public void testVerifiesEmptyAuthorizedParties() {
        SecretKey key = Jwts.SIG.HS256.key().build();
        String token = Jwts.builder() //
                .subject("Joe") //
                .claim("azp", "partyparty") //
                .audience().add("aud1").add("aud2") //
                .and() //
                .signWith(key) //
                .compact();
        JwtHelper.verifyJwt(token, VerifyJwtOptions.key(key).build());
    }

    @Test
    public void testVerifiesNonEmptyAuthorizedParties() {
        SecretKey key = Jwts.SIG.HS256.key().build();
        String token = Jwts.builder() //
                .subject("Joe") //
                .claim("azp", "partyparty") //
                .audience().add("aud1").add("aud2") //
                .and() //
                .signWith(key) //
                .compact();
        JwtHelper.verifyJwt(token,
                VerifyJwtOptions.key(key).authorizedParties(List.of("boo")).authorizedParty("partyparty").build());
    }

    @Test
    public void testFailsAuthorizedParties() {
        SecretKey key = Jwts.SIG.HS256.key().build();
        String token = Jwts.builder() //
                .subject("Joe") //
                .claim("azp", "partyparty") //
                .audience().add("aud1").add("aud2") //
                .and() //
                .signWith(key) //
                .compact();
        TokenVerificationException t = assertThrows(TokenVerificationException.class,
                () -> JwtHelper.verifyJwt(token, VerifyJwtOptions.key(key).authorizedParty("bill").build()));
        assertTrue(t.getMessage().startsWith("Invalid JWT Authorized party claim (azp)"));
    }

}
