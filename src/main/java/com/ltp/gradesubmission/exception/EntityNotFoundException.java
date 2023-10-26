/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltp.gradesubmission.exception;

/**
 *
 * @author Edison Teran
 */
public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(Long id, Class<?> entity){
        super("The " + entity.getSimpleName().toLowerCase() + " with id '" + id + "' does not found");
    }
}
