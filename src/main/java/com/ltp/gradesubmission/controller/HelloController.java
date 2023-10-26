/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltp.gradesubmission.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Edison Teran
 */
@RestController
public class HelloController {
    
    @GetMapping("/hello")
    public String hello(){
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication a = securityContext.getAuthentication();
        return "Hello " + a.getName() + "!";
    }
    
    @GetMapping("/hello2")
    public String hello2(Authentication authentication){
        return "Hello2 " + authentication.getName() + "!";
    }
}
