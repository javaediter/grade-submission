/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltp.gradesubmission.repository;

import com.ltp.gradesubmission.pojos.Grade;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Edison Teran
 */
public class DataStore {
    private List<Grade> grades = new ArrayList<>();

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
    
}
