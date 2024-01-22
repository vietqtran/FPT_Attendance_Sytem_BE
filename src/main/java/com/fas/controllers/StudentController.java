package com.fas.controllers;

import com.fas.models.dtos.requests.StudentRequestDTO;
import com.fas.models.dtos.responses.StudentResponseDTO;
import com.fas.models.exceptions.StudentExceptions;
import com.fas.models.utils.MessageDetails;
import com.fas.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private MessageDetails<StudentResponseDTO> createStudent(@Valid @RequestBody StudentRequestDTO student) throws StudentExceptions {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("User Roles: " + authentication);

        return new MessageDetails<>("Student created successfully", studentService.createStudent(student), "Success");
    }

    @PutMapping("/student/update/{studentId}")
    private MessageDetails<StudentResponseDTO> updateStudent(@Valid @RequestBody StudentRequestDTO student, @PathVariable UUID studentId) throws StudentExceptions {
        return new MessageDetails<>("Student updated successfully", studentService.updateStudent(studentId, student), "Success");
    }

    @DeleteMapping("/student/delete/{studentId}")
    private MessageDetails<StudentResponseDTO>  deleteStudent(@PathVariable UUID studentId) throws StudentExceptions {
        return new MessageDetails<>("Student deleted successfully", studentService.deleteStudent(studentId), "Success");
    }

    @GetMapping("/student")
    private MessageDetails<List<StudentResponseDTO>> getAllStudents() {
        return new MessageDetails<>("Get all students successfully", studentService.getAllStudents(), "Success");
    }
}
