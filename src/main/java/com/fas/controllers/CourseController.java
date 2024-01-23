package com.fas.controllers;


import com.fas.models.dtos.requests.CourseRequestDTO;
import com.fas.models.dtos.responses.CourseResponseDTO;
import com.fas.models.enums.Code;
import com.fas.models.utils.MessageDetails;
import com.fas.services.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/course")
    private MessageDetails<CourseResponseDTO> createCourse(@RequestBody @Valid CourseRequestDTO courseReq) {
        CourseResponseDTO course = courseService.creatMajor(courseReq);
        return new MessageDetails<CourseResponseDTO>("Course created successfully", course, Code.SUCCESS);
    }

    @GetMapping("/course")
    private MessageDetails<List<CourseResponseDTO>> getAllCourse() {
        List<CourseResponseDTO> courses = courseService.getAllCourse();
        return new MessageDetails<List<CourseResponseDTO>>("Get all Course successfully", courses, Code.SUCCESS);
    }

    @PutMapping("/course/{courseId}")
    private MessageDetails<CourseResponseDTO> updateCourse(@RequestBody CourseRequestDTO courseReq, @PathVariable UUID courseId) {
        CourseResponseDTO course = courseService.updateMajor(courseReq, courseId);
        return new MessageDetails<CourseResponseDTO>("Update Course successfully", course, Code.SUCCESS);
    }

    @DeleteMapping("/course/{courseId}")
    private MessageDetails<CourseResponseDTO> deleteCourse(@PathVariable UUID courseId) {
        CourseResponseDTO course = courseService.deleteMajor(courseId);
        return new MessageDetails<CourseResponseDTO>("Delete Course successfully", course, Code.SUCCESS);
    }
}
