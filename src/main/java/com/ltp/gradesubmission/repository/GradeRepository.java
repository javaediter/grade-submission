/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltp.gradesubmission.repository;

import com.ltp.gradesubmission.pojos.Grade;
import static com.ltp.gradesubmission.utils.Constants.NOT_FOUND;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Edison Teran
 */
@Repository
public class GradeRepository {
    
    private List<Grade> grades = new ArrayList<>();
    
    public Grade getGrade(int index){
        return grades.get(index);
    }
    
    public void addGrade(Grade grade){
        grades.add(grade);
    }
    
    public void updateGrade(Grade grade, int index){
        grades.set(index, grade);
    }
    
    public List<Grade> getGrades(){
        return grades;
    }
    
    public void deleteGrade(int index){
        grades.remove(index);
    }
    
    public int getStudentIndex(String id){
        for(int i = 0; i < grades.size(); i++){
            if(grades.get(i).getId().equals(id))
                return i;
        }
        return NOT_FOUND;
    }
}
