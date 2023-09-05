/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltp.gradesubmission.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Edison Teran
 */
@Controller
public class SpellController {
    
    @GetMapping("/spell")
    public String getSpellName(Model model){
        String name = "Renato";
        char[] characteres = name.toCharArray();
        model.addAttribute("name", name);
        model.addAttribute("characteres", characteres);
        return "spell";
    }
}
