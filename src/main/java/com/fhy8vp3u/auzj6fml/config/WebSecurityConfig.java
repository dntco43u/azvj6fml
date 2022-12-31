package com.fhy8vp3u.auzj6fml.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fhy8vp3u.auzj6fml.service.UserService;
import com.fhy8vp3u.auzj6fml.util.TokenRequestFilter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  private final UserService userService;
  private final TokenRequestFilter tokenRequestFilter;
  private static final String[] PERMIT_URL_ARRAY = {
    /* swagger v2 */
    "/v2/api-docs", "/swagger-resources", "/swagger-resources/**", "/configuration/ui", "/configuration/security",
    "/swagger-ui.html", "/webjars/**",
    /* swagger v3 */
    "/v3/api-docs/**", "/swagger-ui/**" };
  
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    //http.csrf().disable().authorizeRequests().anyRequest().permitAll().and().sessionManagement()
    //.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().formLogin().disable()
    //.addFilterBefore(tokenRequestFilter, UsernamePasswordAuthenticationFilter.class);
   
    /*
     * http .csrf().disable() // swagger API 호출시 403 에러 발생 방지 .authorizeRequests()
     * .antMatchers(PERMIT_URL_ARRAY).permitAll() .anyRequest().authenticated();
     */
    http.cors()
    .and()
    .csrf().disable().authorizeRequests()
      //.antMatchers("/").permitAll()
      //.antMatchers("/**").permitAll()
      //.antMatchers("/swagger-ui.html").permitAll()
      //.antMatchers("/api/userlog/login", "/static/**", "/").permitAll()
      .antMatchers("/**").permitAll()
      .antMatchers("/common/login").permitAll()
      .antMatchers(PERMIT_URL_ARRAY).permitAll()
      //.antMatchers(HttpMethod.POST, "/api/userlog/login").permitAll()
      .anyRequest().authenticated()
      .and()
      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      .and()
      .formLogin().disable();
      //http.addFilterBefore(tokenRequestFilter, UsernamePasswordAuthenticationFilter.class);
      
      
  }
}
