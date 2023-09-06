/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltp.gradesubmission.service;

import com.ltp.gradesubmission.pojos.Grade;
import com.ltp.gradesubmission.repository.GradeRepository;
import static com.ltp.gradesubmission.utils.Constants.NOT_FOUND;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Edison Teran
 */
@Service
public class GradeService {
    
    @Autowired
    private GradeRepository gradeRepository;
    
    public Grade getGrade(int index){
        return gradeRepository.getGrades().get(index);
    }
    
    public void addGrade(Grade grade){
        gradeRepository.addGrade(grade);
    }
    
    public void updateGrade(Grade grade, int index){
        gradeRepository.updateGrade(grade, index);
    }
    
    public List<Grade> getGrades(){
        return gradeRepository.getGrades();
    }
    
    public void deleteGrade(int index){
        gradeRepository.getGrades().remove(index);
    }
    
    public Grade getGradeById(String id){
        int index = gradeRepository.getStudentIndex(id);
        return index == NOT_FOUND ? new Grade() : getGrade(index);
    }
    
    public int getStudentIndex(String id){
        for(int i = 0; i < gradeRepository.getGrades().size(); i++){
            if(gradeRepository.getGrades().get(i).getId().equals(id))
                return i;
        }
        return NOT_FOUND;
    }
}
