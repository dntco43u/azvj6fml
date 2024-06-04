package com.fhy8vp3u.azvj6fml.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtUtil {
  @Value("${jwt.secret}")
  String secret;

  public String createToken(String userId, String userName) {
    Algorithm algorithm = Algorithm.HMAC256(secret);
    return JWT.create().withIssuer("azvj6fml").withClaim("userId", userId).withClaim("userName", userName)
    .withIssuedAt(new Date()).sign(algorithm);
  }

  public DecodedJWT decodeToken(String token) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      JWTVerifier verifier = JWT.require(algorithm).withIssuer("azvj6fml").build();
      return verifier.verify(token);
    } catch (JWTVerificationException e) {
      log.error("JWTVerificationException={}", e);
    } catch (IllegalArgumentException e) {
      log.error("IllegalArgumentException={}", e);
    }
    return null;
  }
}
