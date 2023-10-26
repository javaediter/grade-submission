/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltp.gradesubmission.controller;

import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.entity.Grade;
import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.service.ICourseService;
import com.ltp.gradesubmission.service.IGradeService;
import com.ltp.gradesubmission.service.IStudentService;
import java.util.List;
import java.util.Optional;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Edison Teran
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/grades")
public class GradeController {
    
    @Autowired
    private IGradeService gradeService;
    
    @Autowired
    private IStudentService studentService;
    
    @Autowired
    private ICourseService courseService;    
    
    @GetMapping("/")
    public ResponseEntity<List<Grade>> getGrades(){
        return new ResponseEntity<>(gradeService.getGrades(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Grade> getGrade(@PathVariable Long id){
        Optional<Grade> grade = gradeService.getGrade(id);
        if(grade.isPresent()){
            return new ResponseEntity<>(grade.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }        
    }

    @PostMapping("/save/{student_id}/{course_id}")
    public ResponseEntity<Grade> postGrade(@PathVariable(name = "student_id", required = true) Long studentId, @PathVariable(name = "course_id", required = true) Long courseId ,@RequestBody Grade grade){
        Optional<Student> student = studentService.getStudent(studentId); 
        Optional<Course> course = courseService.getCourse(courseId);
        grade.setStudent(student.isPresent() ? student.get(): null);
        grade.setCourse(course.isPresent() ? course.get(): null);
        return new ResponseEntity<>(gradeService.saveGrade(grade), HttpStatus.CREATED);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Grade> putGrade(@RequestBody Grade grade){
        return new ResponseEntity<>(gradeService.saveGrade(grade), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteGrade(@PathVariable Long id){
        gradeService.deleteGrade(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    
}
