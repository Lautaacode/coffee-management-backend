package com.buensabor.coffeemanagement.jwt.service.impl;

import com.buensabor.coffeemanagement.jwt.service.JwtService;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
public class JwtServiceImplement implements JwtService {

    private final String secretKey;

    public JwtServiceImplement(@Value("${jwt.secret}") String secretKey) {
        this.secretKey = secretKey;
    }

    @Override
    public String generateToken(UserDetails userDetails) {

        Map<String, Object> claims = new HashMap<>();

        claims.put("roles", userDetails
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList());

        return Jwts
                .builder()
                .claims(claims)
                .subject(userDetails.getUsername())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(getSigningKey())
                .compact();
    }

    @Override
    public String extractEmail(String token) {
        return Jwts
                .parser()
                .verifyWith(getSigningKey())
                .build().parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        String username = extractEmail(token);
        return username.equals(userDetails.getUsername());
    }

    private SecretKey getSigningKey() {
        return Keys.
                hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }
}
