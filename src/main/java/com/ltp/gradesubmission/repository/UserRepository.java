/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltp.gradesubmission.repository;

import com.ltp.gradesubmission.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Edison Teran
 */
public interface UserRepository extends JpaRepository<User, Long>{
    public Optional<User> findUserByUsername(String username);
}
