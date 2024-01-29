package com.fas.controllers;

import com.fas.models.dtos.requests.StudentRequestDTO;
import com.fas.models.dtos.responses.StudentResponseDTO;
import com.fas.models.enums.Code;
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

    /**
     * A description of the entire Java function.
     *
     * @param  student  description of parameter
     * @return          description of return value
     */
    @PostMapping("/student")
    private MessageDetails<StudentResponseDTO> createStudent(@Valid @RequestBody StudentRequestDTO student) throws StudentExceptions {
        return new MessageDetails<>("Student created successfully", studentService.createStudent(student), Code.SUCCESS);
    }

    /**
     * Update a student with the given studentId.
     *
     * @param  student    the updated student information
     * @param  studentId  the ID of the student to be updated
     * @return            a message details object with the updated student response and success code
     */
    @PutMapping("/student/update/{studentId}")
    private MessageDetails<StudentResponseDTO> updateStudent(@Valid @RequestBody StudentRequestDTO student, @PathVariable UUID studentId) throws StudentExceptions {
        return new MessageDetails<>("Student updated successfully", studentService.updateStudent(studentId, student), Code.SUCCESS);
    }


    /**
     * Deletes a student with the given ID.
     *
     * @param  studentId  the ID of the student to be deleted
     * @return            a MessageDetails object containing the success message, the deleted student, and the code
     * @throws StudentExceptions if an error occurs while deleting the student
     */
    @PutMapping("/student/delete/{studentId}")
    private MessageDetails<StudentResponseDTO>  deleteStudent(@PathVariable UUID studentId) throws StudentExceptions {
        return new MessageDetails<>("Student deleted successfully", studentService.deleteStudent(studentId), Code.SUCCESS);
    }

    /**
     * Get all students.
     *
     * @return         	message details with list of student response DTO and success code
     */
    @GetMapping("/student")
    private MessageDetails<List<StudentResponseDTO>> getAllStudents() {
        return new MessageDetails<>("Get all students successfully", studentService.getAllStudents(), Code.SUCCESS);
    }

    @GetMapping("/student/{studentId}")
    private MessageDetails<StudentResponseDTO> getStudentById(@PathVariable UUID studentId) {
        return new MessageDetails<>("Get students successfully", new StudentResponseDTO(studentService.findStudentById(studentId)), Code.SUCCESS);
    }
}
