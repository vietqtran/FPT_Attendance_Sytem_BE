package com.fas.services;

import com.fas.dtos.requests.StudentRequestDTO;
import com.fas.dtos.responses.StudentResponseDTO;
import com.fas.models.entities.Student;

import java.util.UUID;

public interface StudentService {
    public StudentResponseDTO createStudent(StudentRequestDTO student);

    public StudentResponseDTO getStudent(UUID studentId);

    public StudentResponseDTO updateStudent(UUID studentId, Student student);

    public void deleteStudent(UUID studentId);
}
