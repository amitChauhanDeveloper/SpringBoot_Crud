package com.example.student.student_demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="student_cems")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="stu_id")
    private int stuid;

    @Column(name="stu_name")
    private String name;

    @Column(name="stu_class")
    private int std;

    @Column(name="is_Active")
    private Boolean isActive;

   /*  @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_strength_stu_id", referencedColumnName = "stu_id")
    private StudentStrength studentStrength; */

}


 