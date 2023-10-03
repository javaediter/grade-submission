/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltp.gradesubmission.service;

import com.ltp.gradesubmission.entities.Grade;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Edison Teran
 */
public interface IGradeService {
    public Optional<Grade> getGrade(Long id);
    public List<Grade> getGrades();
    public Grade saveGrade(Grade grade);
    public void deleteGrade(Long id);
}
