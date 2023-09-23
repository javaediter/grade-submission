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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Edison Teran
 */
@Repository
public class GradeRepository {
    
    @Autowired
    private DataStore dataStore;
    
    public Grade getGrade(int index){
        return dataStore.getGrades().get(index);
    }
    
    public void addGrade(Grade grade){
        dataStore.getGrades().add(grade);
    }
    
    public void updateGrade(Grade grade, int index){
        dataStore.getGrades().set(index, grade);
    }
    
    public List<Grade> getGrades(){
        return dataStore.getGrades();
    }
    
    public void deleteGrade(int index){
        dataStore.getGrades().remove(index);
    }
    
    public int getStudentIndex(String id){
        for(int i = 0; i < dataStore.getGrades().size(); i++){
            if(dataStore.getGrades().get(i).getId().equals(id))
                return i;
        }
        return NOT_FOUND;
    }
}
