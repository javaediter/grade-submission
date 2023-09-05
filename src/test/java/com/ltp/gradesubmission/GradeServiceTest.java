/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltp.gradesubmission;

import com.ltp.gradesubmission.pojos.Grade;
import com.ltp.gradesubmission.repository.DataStore;
import com.ltp.gradesubmission.repository.GradeRepository;
import com.ltp.gradesubmission.service.GradeService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author Edison Teran
 */
@RunWith(MockitoJUnitRunner.class)
public class GradeServiceTest {
    
    @Mock
    private DataStore dataStore;
    
    @Mock
    @InjectMocks
    private GradeRepository gradeRepository;
    
    @InjectMocks
    private GradeService gradeService;
    
    @Test
    public void getGradesFromRepositoryTest(){
        //1. se cargan los datos para la prueba
        List<Grade> data = new ArrayList<>();
        data.add(new Grade("Harry", "Maths", "C+"));
        data.add(new Grade("Elsa", "Spanish", "A+"));
        dataStore.getGrades().addAll(data);
        
        when(gradeRepository.getGrades()).thenReturn(dataStore.getGrades());
        
        //2. se llama al metodo que se quiere probar
        List<Grade> result = gradeService.getGrades();
        
        //3. se comparan los resultados con los datos del punto 1
        Assertions.assertEquals("Harry", result.get(0).getStudent());
    }
}
