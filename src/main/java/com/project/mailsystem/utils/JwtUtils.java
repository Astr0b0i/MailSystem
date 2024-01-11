package com.project.mailsystem.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.function.Function;

@Component
@Slf4j
public class JwtUtils {
    @Value("${jwt.secret.key}")
    private String secretKey;

    @Value("${jwt.time.expiration}")
    private String timeExpiration;

    public String generateAccessToken(String username){
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + Long.parseLong(timeExpiration)))
                .signWith(this.getSignatureKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public Boolean isTokenValid(String token){
        try{
            Jwts.parser()
                    .verifyWith((SecretKey) this.getSignatureKey())
                    .build()
                    .parseSignedClaims(token);
            return true;
        }catch (Exception e){
            log.error("Invalid token. Error: ".concat(e.getMessage()));
            return false;
        }
    }

    public <T> T getClaim(String token, Function<Jws<Claims>, T> claimsTFunction){
        Jws<Claims> claims = this.getAllClaims(token);
        return claimsTFunction.apply(claims);
    }

    public Jws<Claims> getAllClaims(String token){
        return Jwts.parser()
                .verifyWith((SecretKey) this.getSignatureKey())
                .build()
                .parseSignedClaims(token);
    }

    public Key getSignatureKey(){
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }


}
