/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltp.gradesubmission.service;

import com.ltp.gradesubmission.entity.Student;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Edison Teran
 */
public interface IStudentService {
    
    public Optional<Student> getStudent(Long id);
    public List<Student> getStudents();
    public List<Student> getStudentsByNameAsc();
    public List<Student> getStudentsByBirthDateDesc();
    public List<Student> getStudentsByLike(String like);
    public Student saveStudent(Student student);
    public void deleteStudent(Long id);
}
