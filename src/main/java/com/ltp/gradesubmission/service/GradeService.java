/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltp.gradesubmission.service;

import com.ltp.gradesubmission.entity.Grade;
import com.ltp.gradesubmission.repository.GradeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Edison Teran
 */
@Service
public class GradeService implements IGradeService{  
    
    @Autowired
    private GradeRepository repository;

    @Override
    public Optional<Grade> getGrade(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Grade> getGrades() {
        return (List<Grade>) repository.findAll();
    }

    @Override
    public Grade saveGrade(Grade grade) {
        return repository.save(grade);
    }

    @Override
    public void deleteGrade(Long id) {
        repository.deleteById(id);
    }
}
