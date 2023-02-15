package com.example.student.student_demo.service;

import com.example.student.student_demo.dto.StudentCreateDTO;
import com.example.student.student_demo.dto.StudentReadDTO;
import com.example.student.student_demo.dto.StudentResponseDTO;
import com.example.student.student_demo.dto.StudentUpdateDTO;
import com.example.student.student_demo.model.Student;
import com.example.student.student_demo.model.StudentStrength;
import com.example.student.student_demo.repository.StudentRepository;
import com.example.student.student_demo.repository.StudentStrengthRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private StudentStrengthRepository studentStrengthRepository;

  // save operation
  @Override
  public StudentResponseDTO saveStudentCreateDTO(
    StudentCreateDTO studentCreateDTO
  ) {
    Student student = new Student();
    StudentStrength studentStrength = new StudentStrength();

    //student.setStuid(UUID.randomUUID().toString());
    student.setName(studentCreateDTO.getName());
    student.setStd(studentCreateDTO.getStd());
    student.setIsActive(true);
    studentRepository.save(student);

    if(student.getStd() == studentStrength.getStd())
    {
      //studentStrength= studentRepository.findById(studentCreateDTO);
      studentStrength.setTotalstrength(studentCreateDTO.getTotalstrength() + 1);
      studentStrength.setStd(studentCreateDTO.getStd());
      studentStrengthRepository.save(studentStrength);

    }
    else{  
      System.out.println("std is not match");
    }

    //StudentStrength studentStrength = new StudentStrength();
    //studentStrength= studentRepository.findById(studentCreateDTO);
    //studentStrength.setTotalstrength(studentCreateDTO.getTotalstrength() + 1);
    //studentStrength.setStd(studentCreateDTO.getStd());

    //studentStrengthRepository.save(studentStrength);

    StudentResponseDTO responseDto = new StudentResponseDTO();
    responseDto.setStd(student.getStd());
    responseDto.setName(student.getName());

    return responseDto;
  }

  // Read Operation
  @Override
  public List<StudentReadDTO> getAllStudent() {
    List<Student> getStudent = studentRepository.findAll();
    List<StudentReadDTO> studentDTOList = new ArrayList<>();
    for (Student a : getStudent) {
      StudentReadDTO studentDTO = new StudentReadDTO(a.getName(), a.getStd());
      studentDTOList.add(studentDTO);
    }

    return studentDTOList;
  }

  // Read operation by id
  @Override
  public Optional<Student> findById(Integer stuid) {
    return studentRepository.findById(stuid);
  }

  // Update operation

  @Override
  public Integer updateStudent(StudentUpdateDTO studentUpdateDTO) {
    if (studentRepository.existsById(studentUpdateDTO.getStuid())) {
      Student student = studentRepository.getById(studentUpdateDTO.getStuid());

      student.setName(studentUpdateDTO.getName());
      student.setStd(studentUpdateDTO.getStd());
      studentRepository.save(student);
    } else {
      System.out.println("Student ID do not Exist");
    }

    return null;
  }

  // delete operation
  @Override
  public boolean deleteStudent(Integer stuid) {
    if (studentRepository.existsById(stuid)) {
      studentRepository.deleteById(stuid);
    } else {
      System.out.println("student id not found");
    }
    return true;
  }
}
