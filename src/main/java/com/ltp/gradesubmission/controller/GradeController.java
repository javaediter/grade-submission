/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltp.gradesubmission.controller;

import com.ltp.gradesubmission.pojos.Grade;
import com.ltp.gradesubmission.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Edison Teran
 */
@Controller
public class GradeController {
    
    @Autowired
    private GradeService gradeService;
    
    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id){
        Grade grade = gradeService.getGradeById(id);
        model.addAttribute("grade", grade);
        return "form";
    }
    
    @PostMapping("/handleSubmit")
    public String submitForm(Grade grade){
        int index = gradeService.getStudentIndex(grade.getId());
        if(index < 0){
            gradeService.addGrade(grade);
        }else{
            gradeService.updateGrade(grade, index);
        }        
        return "redirect:/grades";
    }
    
    @GetMapping("/grades")
    public String getGrades(Model model){
        model.addAttribute("grades", gradeService.getGrades());
        return "grades";
    }
    
    @GetMapping("/handleDelete")
    public String deleteGrade(String id){
        int index = gradeService.getStudentIndex(id);
        gradeService.deleteGrade(index);
        return "redirect:/grades";
    }   
    
}
