package com.fas.controllers;

import com.fas.models.dtos.requests.StudentRequestDTO;
import com.fas.models.dtos.responses.StudentResponseDTO;
import com.fas.models.entities.Student;
import com.fas.models.enums.Code;
import com.fas.models.exceptions.StudentExceptions;
import com.fas.models.utils.MessageDetails;
import com.fas.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    private MessageDetails<StudentResponseDTO> createStudent(@Valid @RequestBody StudentRequestDTO student) throws StudentExceptions {
        StudentResponseDTO newStudent = studentService.createStudent(student);
        if(newStudent == null) {
            return new MessageDetails<>("Student created failed", null, Code.FAILURE);
        }
        return new MessageDetails<>("Student created successfully", newStudent, Code.SUCCESS);
    }

    @PutMapping("/student/update/{studentId}")
    private MessageDetails<StudentResponseDTO> updateStudent(@Valid @RequestBody StudentRequestDTO student, @PathVariable UUID studentId) throws StudentExceptions {
        StudentResponseDTO updatedStudent = studentService.updateStudent(studentId, student);
        if(updatedStudent == null) {
            return new MessageDetails<>("Student updated failed", null, Code.FAILURE);
        }
        return new MessageDetails<>("Student updated successfully", studentService.updateStudent(studentId, student), Code.SUCCESS);
    }


    @PutMapping("/student/delete/{studentId}")
    private MessageDetails<StudentResponseDTO>  deleteStudent(@PathVariable UUID studentId) throws StudentExceptions {
        StudentResponseDTO student = studentService.deleteStudent(studentId);
        if(student == null) {
            return new MessageDetails<>("Student deleted failed", null, Code.FAILURE);
        }
        return new MessageDetails<>("Student deleted successfully", student, Code.SUCCESS);
    }

    @GetMapping("/student")
    private MessageDetails<List<StudentResponseDTO>> getAllStudents() {
        List<StudentResponseDTO> student = studentService.getAllStudents();
        if(student == null) {
            return new MessageDetails<>("Get all students failed", null, Code.FAILURE);
        }
        return new MessageDetails<>("Get all students successfully", studentService.getAllStudents(), Code.SUCCESS);
    }

    @GetMapping("/student/{studentId}")
    private MessageDetails<StudentResponseDTO> getStudentById(@PathVariable UUID studentId) {
        Student student = studentService.findStudentById(studentId);
        if(student == null) {
            return new MessageDetails<>("Get students failed", null, Code.FAILURE);
        }
        return new MessageDetails<>("Get students successfully", new StudentResponseDTO(student), Code.SUCCESS);
    }

    @GetMapping("/student/email/{email}")
    private MessageDetails<StudentResponseDTO> getStudentByEmail(@PathVariable String email) {
        Student student = studentService.findStudentByEmail(email);
        if(student == null) {
            return new MessageDetails<>("Get student failed", null, Code.FAILURE);
        }
        return new MessageDetails<>("Get student successfully", new StudentResponseDTO(student), Code.SUCCESS);
    }

    @GetMapping("/student/grade/{gradeId}/course/{courseId}")
    private MessageDetails<?> getStudentsByGradeId(@PathVariable UUID gradeId,
                                                   @PathVariable UUID courseId,
                                                   @RequestParam(required = false) String page,
                                                   @RequestParam(required = false) String size) {
        Page<StudentResponseDTO> studentsPage = studentService.getStudentsByGradeId(gradeId, courseId, page, size);

        if(studentsPage == null) {
            return new MessageDetails<>("Get students failed", null, Code.FAILURE);
        }

        Map<String, Object> students = new HashMap<>();
        students.put("content", studentsPage.getContent());
        students.put("totalPages", studentsPage.getTotalPages());
        students.put("currentPage", studentsPage.getNumber() + 1);
        return new MessageDetails<>("Get students successfully", students, Code.SUCCESS);
    }
}
