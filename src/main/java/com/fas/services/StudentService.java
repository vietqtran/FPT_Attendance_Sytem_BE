package com.fas.services;

import com.fas.dtos.requests.StudentRequestDTO;
import com.fas.dtos.responses.StudentResponseDTO;
import com.fas.models.entities.Student;

import java.util.UUID;

public interface StudentService {

    public Student findStudentByEmail(String email);

    public StudentResponseDTO createStudent(StudentRequestDTO student) throws Exception;


    public Student findStudentById(UUID studentId) throws Exception;

    public StudentResponseDTO updateStudent(UUID studentId, StudentRequestDTO student) throws Exception;

    public void deleteStudent(UUID studentId);
}
