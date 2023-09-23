/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltp.gradesubmission.pojos;

import java.util.UUID;

/**
 *
 * @author Edison Teran
 */
public class Grade {
    private String student;
    private String subject;
    private String score;
    private String id;
    
    public Grade(){
        System.out.println("...simple");
        this.id = UUID.randomUUID().toString();
    }

    public Grade(String student, String subject, String score) {
        System.out.println("...with args");
        this.student = student;
        this.subject = subject;
        this.score = score;
        this.id = UUID.randomUUID().toString();
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
    
    public String getId(){
        return id;
    }
    
    public void setId(String id){
        this.id = id;
    }
}
