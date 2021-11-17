package com.curso.cursos;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
  
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
    .withUser("user1")
    .password("{noop}user1")
    .roles("USER")
    .and()
    .withUser("admin")
    .password("{noop}admin")
    .roles("USER","ADMIN");
  }
  
  @Override
  protected void configure(HttpSecurity http) throws Exception{
    http.csrf().disable()
    .authorizeRequests()
    .antMatchers(HttpMethod.POST, "/crear").hasRole("ADMIN")
    .antMatchers("/crear").authenticated()
    .and().httpBasic();
  }
  
}
