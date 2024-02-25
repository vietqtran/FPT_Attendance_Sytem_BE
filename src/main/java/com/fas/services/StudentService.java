package com.fas.services;

import com.fas.models.dtos.requests.StudentRequestDTO;
import com.fas.models.dtos.responses.StudentResponseDTO;
import com.fas.models.entities.Campus;
import com.fas.models.entities.Major;
import com.fas.models.entities.Student;
import com.fas.models.exceptions.StudentExceptions;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface StudentService {

    StudentResponseDTO createStudent(StudentRequestDTO student) throws StudentExceptions;

    Student findStudentById(UUID studentId) throws StudentExceptions;

    StudentResponseDTO updateStudent(UUID studentId, StudentRequestDTO student) throws StudentExceptions;

    StudentResponseDTO deleteStudent(UUID studentId) throws StudentExceptions;

    List<StudentResponseDTO> getAllStudents();
    public List<StudentResponseDTO> findStudentByMajorAndCampus(UUID majorId, Long campusId);
    Student findStudentByEmail(String email);

    Page<StudentResponseDTO> filterAndSortStudents(UUID gradeId, UUID courseId, UUID majorId, String searchValue, String order, String page, String size);
}
