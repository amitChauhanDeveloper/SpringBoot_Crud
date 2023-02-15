package com.example.student.student_demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.student.student_demo.dto.StudentCreateDTO;
import com.example.student.student_demo.dto.StudentReadDTO;
import com.example.student.student_demo.dto.StudentResponseDTO;
import com.example.student.student_demo.dto.StudentUpdateDTO;
import com.example.student.student_demo.model.Student;


@Service
public interface StudentService {
    
    // save operation
    StudentResponseDTO saveStudentCreateDTO (StudentCreateDTO studentCreateDTO);

    // read operation
    List<StudentReadDTO> getAllStudent();

    // read by id 
    Optional <Student> findById(Integer stuid);


    // update operation 
    Integer updateStudent(StudentUpdateDTO studentUpdateDTO);

    boolean deleteStudent(Integer stuid);

    

}
