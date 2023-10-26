/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltp.gradesubmission.controller;

import com.ltp.gradesubmission.entity.Student;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Edison Teran
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/students")
public class StudentController {
    
    @Autowired
    private IStudentService studentService;
    
    @PostMapping("/save")
    public ResponseEntity<Student> submitStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Optional<Student> student = studentService.getStudent(id);
        if(student.isPresent()){
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }       
    }
    
    @GetMapping("/")
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }
    
    @GetMapping("/name/asc")
    public ResponseEntity<List<Student>> getStudentsByNameAsc(){
        return new ResponseEntity<>(studentService.getStudentsByNameAsc(), HttpStatus.OK);
    }
    
    @GetMapping("/birthdate/desc")
    public ResponseEntity<List<Student>> getStudentsByBirhtDayDesc(){
        return new ResponseEntity<>(studentService.getStudentsByBirthDateDesc(), HttpStatus.OK);
    }
    
    @GetMapping("/name/{like}")
    public ResponseEntity<List<Student>> getStudentsByBirhtDayDesc(@PathVariable String like){
        return new ResponseEntity<>(studentService.getStudentsByLike(like), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);               
    }
}
