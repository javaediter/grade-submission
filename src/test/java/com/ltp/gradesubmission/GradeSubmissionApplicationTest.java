/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltp.gradesubmission;

import com.ltp.gradesubmission.pojos.Grade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 *
 * @author Edison Teran
 */
@SpringBootTest
@AutoConfigureMockMvc
public class GradeSubmissionApplicationTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void loadContexts(){
        Assertions.assertNotNull(mockMvc);
    }
    
    @Test
    public void getFormTest()throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.get("/?id=123");
        
        mockMvc.perform(request)
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("form"))
                .andExpect(model().attributeExists("grade"));
    }
    
    @Test
    public void submitFormTest() throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.post("/handleSubmit")
                .param("student", "Else")
                .param("subject", "Spanish")
                .param("score", "A+");
        
        mockMvc.perform(request)
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/grades"));
    }
    
    @Test
    public void deleteGradeTest() throws Exception{
        Grade grade = new Grade("Elsa", "Spanish", "A+");
        RequestBuilder request = MockMvcRequestBuilders.get("/handleDelete")
                .param("id", grade.getId());
        
        mockMvc.perform(request)
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/grades"));
    }
}
