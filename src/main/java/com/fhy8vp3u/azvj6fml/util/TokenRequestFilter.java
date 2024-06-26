package com.fhy8vp3u.azvj6fml.util;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.fhy8vp3u.azvj6fml.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class TokenRequestFilter extends OncePerRequestFilter {
  private final UserService userService;
  private final JwtUtil jwtUtil;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
  throws ServletException, IOException {
    String loginUrl = "/api/userlog/login";
    String swaggerUrl = "/swagger-ui.html";
    try {
      if (loginUrl.equals(request.getRequestURI())) {
        doFilter(request, response, filterChain);        
      } else if (swaggerUrl.equals(request.getRequestURI())) { 
        doFilter(request, response, filterChain);
      } else {
        doFilter(request, response, filterChain);
        /*
         * String token = parseJwt(request); if (token == null) {
         * response.sendError(403); } else { DecodedJWT tokenInfo =
         * jwtUtil.decodeToken(token); if (tokenInfo != null) { String userId =
         * tokenInfo.getClaim("userId").asString(); UserDetails loginUser =
         * userService.loadUserByUsername(userId); UsernamePasswordAuthenticationToken
         * authentication = new UsernamePasswordAuthenticationToken(loginUser, null,
         * loginUser.getAuthorities()); authentication.setDetails(new
         * WebAuthenticationDetailsSource().buildDetails(request));
         * SecurityContextHolder.getContext().setAuthentication(authentication);
         * doFilter(request, response, filterChain); } else {
         * log.error("tokeninfo is null"); } }
         */
      }
    } catch (Exception e) {
      log.error("Exception={}", e);
    }
  }

  private String parseJwt(HttpServletRequest request) {
    String headerAuth = request.getHeader("Authorization");
    if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
      return headerAuth.substring(7, headerAuth.length());
    }
    return null;
  }
}
