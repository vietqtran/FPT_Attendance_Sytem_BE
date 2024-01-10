package com.fas.services.implementation;

import com.fas.dtos.requests.StudentRequestDTO;
import com.fas.dtos.responses.StudentResponseDTO;
import com.fas.models.entities.Student;
import com.fas.repositories.StudentRepository;
import com.fas.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StudentServiceImplementation implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public StudentResponseDTO createStudent(StudentRequestDTO student) {
        Student newStudent = student.getStudent();
        Student savedStudent = studentRepository.save(newStudent);
        return new StudentResponseDTO(savedStudent);
    }

    @Override
    public StudentResponseDTO getStudent(UUID studentId) {
        return null;
    }

    @Override
    public StudentResponseDTO updateStudent(UUID studentId, Student student) {
        return null;
    }

    @Override
    public void deleteStudent(UUID studentId) {

    }
}
