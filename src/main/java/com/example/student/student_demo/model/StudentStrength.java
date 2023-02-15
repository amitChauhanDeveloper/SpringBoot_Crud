package com.example.student.student_demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student_strength")
public class StudentStrength {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="stg_id")
    private int stgid;

    @Column(name="std")
    private int std;

    @Column(name="total_strength")
    private int totalstrength; 

    /* @OneToOne(mappedBy = "student_strength")
    private Student student; */
    
}


 
