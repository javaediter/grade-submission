/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltp.gradesubmission;

import com.ltp.gradesubmission.pojos.Grade;
import com.ltp.gradesubmission.repository.GradeRepository;
import com.ltp.gradesubmission.service.GradeService;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author Edison Teran
 */
@ExtendWith(MockitoExtension.class)
public class GradeServiceTest {
       
    @Mock
    private GradeRepository gradeRepository;
    
    @InjectMocks
    private GradeService gradeService;
    
    //@Test
    public void getGradesFromRepositoryTest(){
        //1. se cargan los datos para la prueba 
        //when the service call to method then return list of grades
        when(gradeRepository.getGrades()).thenReturn(Arrays.asList(
                new Grade("Harry", "Maths", "C+"),
                new Grade("Elsa", "Spanish", "A+")
        ));
        
        //2. se llama al metodo que se quiere probar
        List<Grade> result = gradeService.getGrades();
        
        //3. se comparan los resultados con los datos del punto 1
        Assertions.assertEquals("Harry", result.get(0).getStudent());
        Assertions.assertEquals("Spanish", result.get(1).getSubject());
    }
    
    //@Test
    public void addTest(){
        Grade newGrade = new Grade("Elsa", "Spanish", "A+");
        gradeService.addGrade(newGrade);
        verify(gradeRepository, times(1)).addGrade(newGrade);
    }
    
    //@Test
    public void updateTest(){
        Grade grade = new Grade("Elsa", "Spanish", "B+");        
        grade.setScore("A+");
        gradeService.updateGrade(grade, 0);        
        verify(gradeRepository, times(1)).updateGrade(grade, 0);
    }
    
    //@Test
    public void deleteTest(){
        gradeService.deleteGrade(0);
        verify(gradeRepository, times(1)).deleteGrade(0);
    }
}
