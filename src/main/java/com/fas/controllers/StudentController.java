package com.fas.controllers;

import com.fas.dtos.requests.StudentRequestDTO;
import com.fas.dtos.responses.StudentResponseDTO;
import com.fas.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    private StudentResponseDTO createStudent(@RequestBody @Valid StudentRequestDTO student) {
        return studentService.createStudent(student);
    }

}
