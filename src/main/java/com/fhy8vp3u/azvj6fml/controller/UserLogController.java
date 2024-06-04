package com.fhy8vp3u.azvj6fml.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fhy8vp3u.azvj6fml.service.UserService;
import com.fhy8vp3u.azvj6fml.util.JwtUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api(tags = { "UserLog" })
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class UserLogController {
  private final JwtUtil jwtUtil;
  private final UserService userService;
  private final AuthenticationManager authenticationManager;

  @ApiOperation(value = "UserLog Login", notes = "")
  @PostMapping("/api/userlog/login")
  public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> reqMap) {
    String userId = reqMap.get("user_id");
    String userPw = reqMap.get("user_pw");
    UserDetails loginUser = userService.loadUserByUsername(userId);
    Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser, userPw));
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String accessToken = jwtUtil.createToken(loginUser.getUsername(), loginUser.getUsername());
    /// XXX: Optional value should only be accessed after calling isPresent() 
    String userRole = loginUser.getAuthorities().stream().findFirst().get().getAuthority();   
    Map<String, Object> result = new HashMap<>();
    result.put("user_id", loginUser.getUsername());
    result.put("user_token", accessToken);
    result.put("user_role", userRole);
    return ResponseEntity.ok(result);
  }
}