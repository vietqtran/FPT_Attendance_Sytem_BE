package com.fas.services.implementation;

import com.fas.models.dtos.requests.StudentRequestDTO;
import com.fas.models.dtos.responses.InstructorResponseDTO;
import com.fas.models.entities.Instructor;
import com.fas.models.exceptions.StudentExceptions;
import com.fas.services.InstructorService;

import java.util.UUID;

public class InstructorServiceImplementation implements InstructorService {
    @Override
    public InstructorResponseDTO createStudent(StudentRequestDTO student) throws StudentExceptions {
        return null;
    }

    @Override
    public Instructor findStudentById(UUID studentId) throws StudentExceptions {
        return null;
    }

    @Override
    public InstructorResponseDTO updateStudent(UUID studentId, StudentRequestDTO student) throws StudentExceptions {
        return null;
    }

    @Override
    public InstructorResponseDTO deleteStudent(UUID studentId) throws StudentExceptions {
        return null;
    }
}
