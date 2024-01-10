package com.fas.controllers;

import com.fas.dtos.requests.StudentRequestDTO;
import com.fas.dtos.responses.StudentResponseDTO;
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

    @PutMapping("/student/{studentId}")
    private StudentResponseDTO updateStudent(@Valid @RequestBody StudentRequestDTO student, @PathVariable UUID studentId) throws Exception {
        return studentService.updateStudent(studentId, student);
    }

}
