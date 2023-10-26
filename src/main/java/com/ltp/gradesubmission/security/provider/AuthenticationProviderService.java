/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltp.gradesubmission.security.provider;

import com.ltp.gradesubmission.security.details.CustomUserDetails;
import com.ltp.gradesubmission.service.JpaUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Edison Teran
 */
@Service
public class AuthenticationProviderService implements AuthenticationProvider{
    
    @Autowired
    private JpaUserDetailsService userDetailsService;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        
        CustomUserDetails user = userDetailsService.loadUserByUsername(username);
        
        System.out.println("password: " + user.getPassword());
        System.out.println("encode: " + bCryptPasswordEncoder.encode(password));
        
        if(bCryptPasswordEncoder.matches(password, user.getPassword())){
            return new UsernamePasswordAuthenticationToken(username, password, user.getAuthorities());
        }else{
            throw new AuthenticationCredentialsNotFoundException("ERROR in authentication");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
    
}
