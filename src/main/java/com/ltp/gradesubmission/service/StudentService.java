/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltp.gradesubmission.service;

import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.repository.StudentRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Edison Teran
 */
@Service
public class StudentService implements IStudentService{
    
    @Autowired
    private StudentRepository repository;

    @Override
    public Optional<Student> getStudent(Long id) {
        return repository.findById(id);        
    }

    @Override
    public List<Student> getStudents() {
        return (List<Student>) repository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Student> getStudentsByNameAsc() {
        return (List<Student>) repository.findByOrderByNameAsc();
    }

    @Override
    public List<Student> getStudentsByBirthDateDesc() {
        return (List<Student>) repository.findByOrderByBirthDateDesc();
    }

    @Override
    public List<Student> getStudentsByLike(String like) {
        return (List<Student>) repository.findByNameContainingIgnoreCase(like);
    }
}
