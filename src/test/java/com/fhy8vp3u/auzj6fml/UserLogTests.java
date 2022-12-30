package com.fhy8vp3u.auzj6fml;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fhy8vp3u.auzj6fml.entity.UserLogEntity;
import com.fhy8vp3u.auzj6fml.entity.UserLogRepository;
import com.fhy8vp3u.auzj6fml.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class UserLogTests {
  @Autowired
  private UserLogRepository userLogRepository;
  @Autowired
  private UserService userService;
  @Autowired
  private AuthenticationManager authenticationManager;
  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  void contextLoads() throws Exception {
  }

  @DisplayName("insert001")
  @Test
  void insert001() throws Exception {
    String encPassword = passwordEncoder.encode("changeme2");
    UserLogEntity reqEntity = UserLogEntity.builder()
    .userId("demo1")
    .userPw(encPassword)
    .userName("auzj6fml-test")
    .createUser("testuser")
    .createTime(LocalDateTime.now())
    .build();    
    UserLogEntity resEntity = userLogRepository.save(reqEntity);
    Assertions.assertEquals(reqEntity.getUserId(), resEntity.getUserId());
  }
    
  @DisplayName("select001")
  @Test
  void select001() throws Exception {
    String userId = "demo1";
    String userPw = "changeme2";
    String encPassword = passwordEncoder.encode(userPw);
    UserLogEntity resEntity = userLogRepository.findByUserId(userId).orElseThrow(() -> new UsernameNotFoundException("no data"));
    log.info("resEntity.getUserPw()={}", resEntity.getUserPw());
    log.info("encPassword={}", encPassword);
    Assertions.assertEquals(resEntity.getUserPw(), encPassword);
  }
  
  @DisplayName("select002")
  @Test
  void select002() throws Exception {
    String userId = "demo1";
    String userPw = "changeme2";
    UserDetails user = userService.loadUserByUsername(userId);
    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, userPw);
    authenticationManager.authenticate(authenticationToken);
    log.info("authenticationToken.getCredentials()={}", authenticationToken.getCredentials());
    log.info("userPw={}", userPw);
    Assertions.assertEquals(authenticationToken.getCredentials(), userPw);
  }
}
