package com.fas.services;

import com.fas.models.dtos.requests.StudentRequestDTO;
import com.fas.models.dtos.responses.InstructorResponseDTO;
import com.fas.models.dtos.responses.StudentResponseDTO;
import com.fas.models.entities.Instructor;
import com.fas.models.entities.Student;
import com.fas.models.exceptions.StudentExceptions;

import java.util.UUID;

public interface InstructorService {
    public InstructorResponseDTO createStudent(StudentRequestDTO student) throws StudentExceptions;

    public Instructor findStudentById(UUID studentId) throws StudentExceptions;

    public InstructorResponseDTO updateStudent(UUID studentId, StudentRequestDTO student) throws StudentExceptions;

    public InstructorResponseDTO deleteStudent(UUID studentId) throws StudentExceptions;
}
