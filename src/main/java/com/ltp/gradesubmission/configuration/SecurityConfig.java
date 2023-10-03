/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltp.gradesubmission.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author Edison Teran
 */
@Configuration
public class SecurityConfig {
 
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .antMatchers(HttpMethod.DELETE).hasRole("ADMIN")
                        .antMatchers(HttpMethod.POST).hasAnyRole("ADMIN", "USER")
                        .antMatchers(HttpMethod.GET).permitAll()
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }
    
    @Bean
    public UserDetailsService users(BCryptPasswordEncoder bCryptPasswordEncoder){
        UserDetails admin = User.builder()
                .username("admin")
                .password(bCryptPasswordEncoder.encode("admin-pass"))
                .roles("ADMIN")
                .build();
        
        UserDetails user = User.builder()
                .username("user")
                .password(bCryptPasswordEncoder.encode("user-pass"))
                .roles("USER")
                .build();
        
        return new InMemoryUserDetailsManager(admin, user);
    }
    
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
