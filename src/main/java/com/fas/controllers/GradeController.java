package com.fas.controllers;


import com.fas.models.dtos.requests.GradeRequestDTO;
import com.fas.models.dtos.responses.GradeResponseDTO;
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
        return new MessageDetails<GradeResponseDTO>("Grade created successfully", grade, "success");
    }

    @GetMapping("/grade")
    private MessageDetails<List<GradeResponseDTO>> getAllGrade() {
        List<GradeResponseDTO> courses = gradeService.getAllGrade();
        return new MessageDetails<List<GradeResponseDTO>>("Get all grade successfully", courses, "success");
    }

    @PutMapping("/grade/{gradeId}")
    private MessageDetails<GradeResponseDTO> updateCourse(@RequestBody GradeRequestDTO gradeReq, @PathVariable UUID gradeId) {
        GradeResponseDTO course = gradeService.updateGrade(gradeId, gradeReq);
        return new MessageDetails<GradeResponseDTO>("Update Grade successfully", course, "success");
    }

    @DeleteMapping("/grade/{gradeId}")
    private MessageDetails<GradeResponseDTO> deleteCourse(@PathVariable UUID gradeId) {
        gradeService.deleteGrade(gradeId);
        return new MessageDetails<GradeResponseDTO>("Delete grade successfully", null, "success");
    }
}
