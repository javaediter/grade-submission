/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltp.gradesubmission.repository;

import com.ltp.gradesubmission.entities.Student;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Edison Teran
 */
public interface StudentRepository extends CrudRepository<Student, Long>{
    Iterable<Student> findByOrderByNameAsc();
    Iterable<Student> findByOrderByBirthDateDesc();
    Iterable<Student> findByNameContainingIgnoreCase(String name);
}
