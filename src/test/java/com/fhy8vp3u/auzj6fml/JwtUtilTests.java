package com.fhy8vp3u.auzj6fml;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fhy8vp3u.auzj6fml.util.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class JwtUtilTests {
  @Autowired
  JwtUtil jwtUtil;

  void contextLoads() throws Exception {
  }

  @DisplayName("compareToken")
  @Test
  void compareToken() throws Exception {
    String userId = "demo1";
    String userName = "auzj6fml-test";
    String token = jwtUtil.createToken(userId, userName);
    log.info("token={}", token);
    log.info("userNameToken={}", jwtUtil.decodeToken(token).getClaim("userName").asString());
    log.info("userName={}", userName);
    Assertions.assertEquals(jwtUtil.decodeToken(token).getClaim("userName").asString(), userName);
  }
}
