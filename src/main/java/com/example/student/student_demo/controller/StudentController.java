package com.example.student.student_demo.controller;

import com.example.student.student_demo.dto.StudentCreateDTO;
import com.example.student.student_demo.dto.StudentReadDTO;
import com.example.student.student_demo.dto.StudentResponseDTO;
import com.example.student.student_demo.dto.StudentUpdateDTO;
import com.example.student.student_demo.model.Student;
import com.example.student.student_demo.service.StudentService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StudentController {

  @Autowired
  private StudentService studentService;

  // Save operation
  @PostMapping("/student-create")
  public ResponseEntity<StudentResponseDTO> saveStudentCreateDTO(
    @RequestBody StudentCreateDTO studentCreateDTO
  ) {
    StudentResponseDTO response = studentService.saveStudentCreateDTO(studentCreateDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  // Read Operation

  @GetMapping("/getAllStudent")
  public List<StudentReadDTO> getAllStudent() {
    List<StudentReadDTO> allStudents = studentService.getAllStudent();
    return allStudents;
  }
  
  // Read operation by id 

  @GetMapping("/studentById/{stuid}")
      public Optional<Student> findByID(@PathVariable Integer stuid){
       Optional <Student> findByID = studentService.findById(stuid);
       return findByID;
      }

  // Update operation

  @PutMapping(path = "/student-update")
  public Integer updateStudent(@RequestBody StudentUpdateDTO studentUpdateDTO) {
    Integer stuid = studentService.updateStudent(studentUpdateDTO);
    return null;
  }

  // Delete operation

  @DeleteMapping(path = "/deletestudent/{id}")
  public Integer deleteStudent(@PathVariable(value = "id") Integer stuid) {
    boolean deletestudent = studentService.deleteStudent(stuid);
    return null;
  }
}

