package com.fas.controllers;

import com.fas.models.dtos.requests.GradeRequestDTO;
import com.fas.models.dtos.responses.GradeResponseDTO;
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

    /**
     * Create a grade.
     *
     * @param  gradeReq   the grade request data transfer object
     * @return            the message details with the grade response and success code
     */
    @PostMapping("/grade")
    private MessageDetails<GradeResponseDTO> createGrade(@RequestBody @Valid GradeRequestDTO gradeReq) {
        GradeResponseDTO grade = gradeService.createGrade(gradeReq);
        return new MessageDetails<GradeResponseDTO>("Grade created successfully", grade, Code.SUCCESS);
    }

    /**
     * Get all grade.
     *
     * @return         	description of return value
     */
    @GetMapping("/grade")
    private MessageDetails<List<GradeResponseDTO>> getAllGrade() {
        List<GradeResponseDTO> courses = gradeService.getAllGrade();
        return new MessageDetails<List<GradeResponseDTO>>("Get all grade successfully", courses, Code.SUCCESS);
    }

    /**
     * Update a course grade.
     *
     * @param  gradeReq  the grade request DTO
     * @param  gradeId   the grade ID
     * @return           the message details with the updated grade response DTO
     */
    @PutMapping("/grade/{gradeId}")
    private MessageDetails<GradeResponseDTO> updateCourse(@RequestBody GradeRequestDTO gradeReq, @PathVariable UUID gradeId) {
        GradeResponseDTO course = gradeService.updateGrade(gradeId, gradeReq);
        return new MessageDetails<GradeResponseDTO>("Update Grade successfully", course, Code.SUCCESS);
    }

    /**
     * Deletes a grade by gradeId.
     *
     * @param  gradeId  the ID of the grade to be deleted
     * @return          a message indicating the success of the delete operation
     */
    @DeleteMapping("/grade/{gradeId}")
    private MessageDetails<GradeResponseDTO> deleteCourse(@PathVariable UUID gradeId) {
        gradeService.deleteGrade(gradeId);
        return new MessageDetails<GradeResponseDTO>("Delete grade successfully", null, Code.SUCCESS);
    }
}
