/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltp.gradesubmission.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Data;

/**
 *
 * @author Edison Teran
 */
@Data
@Entity
@Table(name = "students", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name", "birth_date"})
})
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;
    
    @JsonIgnore// no muestran las calificaciones en formato json, y también se evita un ciclo infinito de parseo a json
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)//al borrar el estudiante también se borran sus calificaciones
    private List<Grade> grades;
}
