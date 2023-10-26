/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltp.gradesubmission.service;

import com.ltp.gradesubmission.entity.Course;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Edison Teran
 */
public interface ICourseService {
    public Optional<Course> getCourse(Long id);
    public List<Course> getCourses();
    public Course saveCourse(Course grade);
    public void deleteCourse(Long id);
}
