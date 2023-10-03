/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltp.gradesubmission.service;

import com.ltp.gradesubmission.entities.Course;
import com.ltp.gradesubmission.repository.CourseRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Edison Teran
 */
@Service
public class CourseService implements ICourseService{
    
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Optional<Course> getCourse(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public List<Course> getCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course saveCourse(Course grade) {
        return courseRepository.save(grade);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
    
}
