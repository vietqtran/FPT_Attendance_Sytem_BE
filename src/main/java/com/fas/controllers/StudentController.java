package com.fas.controllers;

import com.fas.models.dtos.requests.StudentRequestDTO;
import com.fas.models.dtos.responses.StudentResponseDTO;
import com.fas.models.utils.MessageDetails;
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
    private MessageDetails<StudentResponseDTO> createStudent(@Valid @RequestBody StudentRequestDTO student) throws Exception {
        return new MessageDetails<>("Student created successfully", studentService.createStudent(student), "Success");
    }

    @PutMapping("/student/update/{studentId}")
    private MessageDetails<StudentResponseDTO> updateStudent(@Valid @RequestBody StudentRequestDTO student, @PathVariable UUID studentId) throws Exception {
        return new MessageDetails<>("Student updated successfully", studentService.updateStudent(studentId, student), "Success");
    }

    @PutMapping("/student/delete/{studentId}")
    private MessageDetails<StudentResponseDTO>  deleteStudent(@PathVariable UUID studentId) throws Exception {
        return new MessageDetails<>("Student deleted successfully", studentService.deleteStudent(studentId), "Success");
    }
}
