package com.fas.controllers;

import com.fas.models.dtos.requests.GradeRequestDTO;
import com.fas.models.dtos.responses.GradeResponseDTO;
import com.fas.models.entities.Grade;
import com.fas.models.enums.Code;
import com.fas.models.utils.MessageDetails;
import com.fas.services.GradeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @PostMapping("/grade")
    private MessageDetails<GradeResponseDTO> createGrade(@RequestBody @Valid GradeRequestDTO gradeReq) {
        GradeResponseDTO grade = gradeService.createGrade(gradeReq);
        if(grade == null) {
            return new MessageDetails<GradeResponseDTO>("Create grade failed", null, Code.FAILURE);
        }
        return new MessageDetails<GradeResponseDTO>("Grade created successfully", grade, Code.SUCCESS);
    }

    @GetMapping("/grade")
    private MessageDetails<List<GradeResponseDTO>> getAllGrade() {
        List<GradeResponseDTO> courses = gradeService.getAllGrade();
        if(courses == null) {
            return new MessageDetails<List<GradeResponseDTO>>("Get all grade failed", null, Code.FAILURE);
        }
        return new MessageDetails<List<GradeResponseDTO>>("Get all grade successfully", courses, Code.SUCCESS);
    }

    @GetMapping("/grade/{gradeId}")
    private MessageDetails<GradeResponseDTO> getGrade(@PathVariable UUID gradeId) {
        Grade grade = gradeService.getGradeById(gradeId);
        if(grade == null) {
            return new MessageDetails<GradeResponseDTO>("Get grade failed", null, Code.FAILURE);
        }
        return new MessageDetails<GradeResponseDTO>("Get grade successfully", new GradeResponseDTO(grade), Code.SUCCESS);
    }

    @GetMapping("/grade/major/{gradeId}")
    private MessageDetails<List<GradeResponseDTO>> getAllGradeByMajor(@PathVariable UUID gradeId) {
        List<GradeResponseDTO> grade = gradeService.getGradeByMajor(gradeId);
        if(grade == null) {
            return new MessageDetails<List<GradeResponseDTO>>("Get grade failed", null, Code.FAILURE);
        }
        return new MessageDetails<List<GradeResponseDTO>>("Get grade successfully", grade, Code.SUCCESS);
    }

    @PutMapping("/grade/update/{gradeId}")
    private MessageDetails<GradeResponseDTO> updateGrade(@RequestBody GradeRequestDTO gradeReq, @PathVariable UUID gradeId) {
        GradeResponseDTO course = gradeService.updateGrade(gradeId, gradeReq);
        if(course == null) {
            return new MessageDetails<GradeResponseDTO>("Update grade failed", null, Code.FAILURE);
        }
        return new MessageDetails<GradeResponseDTO>("Update Grade successfully", course, Code.SUCCESS);
    }

    @PutMapping("/grade/delete/{gradeId}")
    private MessageDetails<GradeResponseDTO> deleteGrade(@PathVariable UUID gradeId) {
        GradeResponseDTO course = gradeService.deleteGrade(gradeId);
        if(course == null) {
            return new MessageDetails<GradeResponseDTO>("Delete grade failed", null, Code.FAILURE);
        }
        return new MessageDetails<GradeResponseDTO>("Delete grade successfully", course, Code.SUCCESS);
    }

    @PutMapping("/grade/{gradeId}/assign/{studentId}")
    private MessageDetails<GradeResponseDTO> assignCourse(@PathVariable UUID gradeId, @PathVariable UUID studentId) {
        GradeResponseDTO course = gradeService.assignGradeToStudent(gradeId, studentId);
        if(course == null) {
            return new MessageDetails<GradeResponseDTO>("Assign course failed", null, Code.FAILURE);
        }
        return new MessageDetails<GradeResponseDTO>("Assign course successfully", course, Code.SUCCESS);

    }

    @PutMapping("/grade/{gradeId}/unAssign/{studentId}")
    public MessageDetails<GradeResponseDTO> unassignCourse(@PathVariable UUID gradeId, @PathVariable UUID studentId) {
        GradeResponseDTO course = gradeService.unassignGradeToStudent(gradeId, studentId);
        if(course == null) {
            return new MessageDetails<GradeResponseDTO>("Unassign course failed", null, Code.FAILURE);
        }
        return new MessageDetails<GradeResponseDTO>("Unassign course successfully", course, Code.SUCCESS);
    }

    @GetMapping("/grade/course/{courseId}")
    private MessageDetails<List<GradeResponseDTO>> getAllGradeByCourse(@PathVariable UUID courseId) {
        List<GradeResponseDTO> courses = gradeService.getAllGradeByCourse(courseId);
        if(courses == null) {
            return new MessageDetails<List<GradeResponseDTO>>("Get all grade failed", null, Code.FAILURE);
        }
        return new MessageDetails<List<GradeResponseDTO>>("Get all grade successfully", courses, Code.SUCCESS);
    }

    @GetMapping("/grade/course/{courseId}/term/{termId}")
    private MessageDetails<List<GradeResponseDTO>> getAllGradeByCourse(@PathVariable UUID courseId, @PathVariable UUID termId) {
        List<GradeResponseDTO> courses = gradeService.getAllGradeByCourseAndTerm(courseId, termId);
        if(courses == null) {
            return new MessageDetails<List<GradeResponseDTO>>("Get all grade failed", null, Code.FAILURE);
        }
        return new MessageDetails<List<GradeResponseDTO>>("Get all grade successfully", courses, Code.SUCCESS);
    }
}
