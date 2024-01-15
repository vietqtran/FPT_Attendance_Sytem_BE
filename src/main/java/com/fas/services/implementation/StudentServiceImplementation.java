package com.fas.services.implementation;

import com.fas.models.dtos.requests.StudentRequestDTO;
import com.fas.models.dtos.responses.StudentResponseDTO;
import com.fas.models.entities.Student;
import com.fas.models.exceptions.StudentExceptions;
import com.fas.repositories.StudentRepository;
import com.fas.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentServiceImplementation implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student findStudentByEmail(String email) {
        Student student = studentRepository.findByEmail(email);
        return student;
    }

    @Override
    public StudentResponseDTO createStudent(StudentRequestDTO student) throws StudentExceptions {
        if (findStudentByEmail(student.getEmail()) != null) {
            throw new StudentExceptions("Email already exists");
        }

        Student newStudent = student.getStudent();
        Student savedStudent = studentRepository.save(newStudent);
        return new StudentResponseDTO(savedStudent);
    }

    @Override
    public Student findStudentById(UUID studentId) throws StudentExceptions {
        Optional<Student> existedStudent = studentRepository.findById(studentId);
        if(existedStudent.isEmpty()){
            throw new StudentExceptions("Student not found");
        }
        return existedStudent.get();
    }

    @Override
    public StudentResponseDTO updateStudent(UUID studentId, StudentRequestDTO student) throws StudentExceptions {
        Student oldStudent = findStudentById(studentId);
        Student newStudent = student.getStudent();

        oldStudent.setUpdateAt(LocalDateTime.now());
        oldStudent.setAddress(newStudent.getAddress());
        oldStudent.setMajor(newStudent.getMajor());
        oldStudent.setPhone(newStudent.getPhone());
        oldStudent.setBirthDay(newStudent.getBirthDay());
        oldStudent.setFirstName(newStudent.getFirstName());
        oldStudent.setMiddleName(newStudent.getMiddleName());
        oldStudent.setLastName(newStudent.getLastName());
        oldStudent.setProfileImage(newStudent.getProfileImage());

        Student savedStudent = studentRepository.save(oldStudent);
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO(savedStudent);
        return studentResponseDTO;
    }

    @Override
    public StudentResponseDTO deleteStudent(UUID studentId) throws StudentExceptions {
        Student oldStudent = findStudentById(studentId);

        oldStudent.setUpdateAt(LocalDateTime.now());
        oldStudent.setStatus(false);
        Student updateStudent = studentRepository.save(oldStudent);

        StudentResponseDTO studentResponseDTO = new StudentResponseDTO(updateStudent);
        return studentResponseDTO ;
    }
}
