/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltp.gradesubmission.security;

import com.ltp.gradesubmission.security.provider.AuthenticationProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author Edison Teran
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private AuthenticationProviderService authenticationProviderService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProviderService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.authorizeHttpRequests()
                .mvcMatchers(HttpMethod.GET, "/**").authenticated()
                .mvcMatchers(HttpMethod.POST, "/**").permitAll()
                .anyRequest().denyAll();
        
        http.csrf().disable();
    }
}
