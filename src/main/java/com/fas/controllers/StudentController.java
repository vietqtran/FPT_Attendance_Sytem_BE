package com.fas.controllers;

import com.fas.models.dtos.requests.StudentRequestDTO;
import com.fas.models.dtos.responses.StudentResponseDTO;
import com.fas.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    private StudentResponseDTO createStudent(@Valid @RequestBody StudentRequestDTO student) throws Exception {
        return studentService.createStudent(student);
    }

    @PutMapping("/student/update/{studentId}")
    private StudentResponseDTO updateStudent(@Valid @RequestBody StudentRequestDTO student, @PathVariable UUID studentId) throws Exception {
        return studentService.updateStudent(studentId, student);
    }

    @PutMapping("/student/delete/{studentId}")
    private StudentResponseDTO deleteStudent(@PathVariable UUID studentId) throws Exception {
        return studentService.deleteStudent(studentId);
    }
}
