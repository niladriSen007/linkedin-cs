package com.niladri.linkedin.user_service.service;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.niladri.linkedin.user_service.entity.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

  @Value("${jwt.secretKey}")
  private String jwtSecret;

  private SecretKey getSecretKey() {
    return Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
  }

  public String generateAccessToken(User user) {
    return Jwts.builder().subject(user.getId().toString())
        .claim("email", user.getEmail())
        .issuedAt(new Date())
        .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 10))
        .signWith(getSecretKey())
        .compact();
  }

  public Long extractUserIdFromToken(String token) {
    return Long.valueOf(Jwts.parser().verifyWith(getSecretKey()).build().parseSignedClaims(token).getPayload()
        .getSubject());
  }
}
