/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltp.gradesubmission.controller;

import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.service.ICourseService;
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
@RequestMapping("/courses")
@CrossOrigin(origins = "*")
public class CourseController {
    
    @Autowired
    private ICourseService courseService;
    
    @GetMapping("/")
    public ResponseEntity<List<Course>> getCourses(){
        return new ResponseEntity<>(courseService.getCourses(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Long id){
        Optional<Course> course = courseService.getCourse(id);
        if(course.isPresent()){
            return new ResponseEntity<>(course.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }
    
    @PostMapping("/save")
    public ResponseEntity<Course> saveCourse(@RequestBody Course course){
        return new ResponseEntity<>(courseService.saveCourse(course), HttpStatus.CREATED);
    }
    
    @DeleteMapping("delete/{id}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
