package com.fas.controllers;


import com.fas.models.dtos.requests.CourseRequestDTO;
import com.fas.models.dtos.responses.CourseResponseDTO;
import com.fas.models.dtos.responses.EventResponseDTO;
import com.fas.models.entities.Course;
import com.fas.models.entities.Event;
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
        CourseResponseDTO course = courseService.creatCourse(courseReq);
        if(course == null) {
            return new MessageDetails<>("Course created failed", null, Code.FAILURE);
        }
        return new MessageDetails<>("Course created successfully", course, Code.SUCCESS);
    }

    @GetMapping("/course/{courseId}")
    private MessageDetails<CourseResponseDTO> getCourseById(@PathVariable UUID courseId) {
        Course course = courseService.getCourseById(courseId);
        if(course == null) {
            return new MessageDetails<>("Get course failed", null, Code.FAILURE);
        }
        return new MessageDetails<>("Get course successfully", new CourseResponseDTO(course), Code.SUCCESS);
    }

    @GetMapping("/course")
    private MessageDetails<List<CourseResponseDTO>> getAllCourse() {
        List<CourseResponseDTO> courses = courseService.getAllCourse();
        if(courses == null) {
            return new MessageDetails<>("Get all courses failed", null, Code.FAILURE);
        }
        return new MessageDetails<>("Get all courses successfully", courses, Code.SUCCESS);
    }

    @GetMapping("/course/major/{majorId}")
    private MessageDetails<List<CourseResponseDTO>> getAllCourseByMajor(@PathVariable UUID majorId) {
        List<CourseResponseDTO> courses = courseService.getAllCourseByMajor(majorId);
        if(courses == null) {
            return new MessageDetails<>("Get all course failed", null, Code.FAILURE);
        }
        return new MessageDetails<>("Get all course successfully", courses, Code.SUCCESS);
    }

    @PutMapping("/course/update/{courseId}")
    private MessageDetails<CourseResponseDTO> updateCourse(@RequestBody CourseRequestDTO courseReq, @PathVariable UUID courseId) {
        CourseResponseDTO course = courseService.updateCourse(courseReq, courseId);
        if(course == null) {
            return new MessageDetails<>("Update course failed", null, Code.FAILURE);
        }
        return new MessageDetails<>("Update course successfully", course, Code.SUCCESS);
    }

    @PutMapping("/course/delete/{courseId}")
    private MessageDetails<CourseResponseDTO> deleteCourse(@PathVariable UUID courseId) {
        CourseResponseDTO course = courseService.deleteCourse(courseId);
        if(course == null) {
            return new MessageDetails<>("Delete course failed", null, Code.FAILURE);
        }
        return new MessageDetails<>("Delete course successfully", course, Code.SUCCESS);
    }

    @PutMapping("/course/{courseId}/assign/{studentId}")
    private MessageDetails<CourseResponseDTO> assignCourseToStudent(@PathVariable UUID courseId, @PathVariable UUID studentId) {
        CourseResponseDTO course = courseService.assignCourseToStudent(courseId, studentId);
        if(course == null) {
            return new MessageDetails<>("Assign student to course failed", null, Code.FAILURE);
        }
        return new MessageDetails<>("Assign student to course successfully", course, Code.SUCCESS);
    }

    @PutMapping("/course/{courseId}/unAssign/{studentId}")
    public MessageDetails<CourseResponseDTO> unAssignCourseToStudent(@PathVariable UUID courseId, @PathVariable UUID studentId) {
        CourseResponseDTO course = courseService.unAssignCourseToStudent(courseId, studentId);
        if(course == null) {
            return new MessageDetails<>("Remove student from course failed", null, Code.FAILURE);
        }
        return new MessageDetails<>("Remove student from successfully", course, Code.SUCCESS);
    }
}
