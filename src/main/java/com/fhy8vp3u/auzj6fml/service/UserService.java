package com.fhy8vp3u.auzj6fml.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fhy8vp3u.auzj6fml.entity.UserLogEntity;
import com.fhy8vp3u.auzj6fml.entity.UserLogRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {
  private final UserLogRepository userLogRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    List<GrantedAuthority> authorities = new ArrayList<>();
    UserLogEntity userLogEntity = userLogRepository.findByUserId(username)
    .orElseThrow(() -> new UsernameNotFoundException("no data"));
    if (userLogEntity.getUserId().equals(username)) {
      authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
    }
    return new User(userLogEntity.getUserId(), userLogEntity.getUserPw(), authorities);
  }
}
