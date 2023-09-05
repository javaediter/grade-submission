/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltp.gradesubmission.configuration;

import com.ltp.gradesubmission.repository.DataStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Edison Teran
 */
@Configuration
public class AppConfig {
    
    @Bean
    public DataStore getDataStore(){
        return new DataStore();
    }
}
