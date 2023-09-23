/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltp.gradesubmission.controller;

import com.ltp.gradesubmission.pojos.Grade;
import com.ltp.gradesubmission.service.GradeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Edison Teran
 */
@RestController
@CrossOrigin(origins = "*")
public class GradeController {
    
    @Autowired
    private GradeService gradeService;
    
    @GetMapping("/grades")
    public ResponseEntity<List<Grade>> getGrades(){
        return new ResponseEntity<>(gradeService.getGrades(), HttpStatus.OK);
    }
    
    @GetMapping("/grades/{id}")
    public ResponseEntity<Grade> getGrade(@PathVariable String id){
        Grade grade = gradeService.getGradeById(id);
        return new ResponseEntity<>(grade, HttpStatus.OK);
    }

    @PostMapping("/grades/save")
    public ResponseEntity<Grade> postGrade(@RequestBody Grade grade){
        gradeService.addGrade(grade);
        return new ResponseEntity<>(grade, HttpStatus.CREATED);
    }
    
    @PutMapping("/grades/update/{id}")
    public ResponseEntity<Grade> putGrade(@PathVariable String id, @RequestBody Grade grade){
        int index = gradeService.getStudentIndex(id);
        gradeService.updateGrade(grade, index);
        return new ResponseEntity<>(grade, HttpStatus.OK);
    }
    
    @DeleteMapping("/grades/delete/{id}")
    public ResponseEntity<HttpStatus> deleteGrade(@PathVariable String id){
        int index = gradeService.getStudentIndex(id);
        gradeService.deleteGrade(index);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }
}
