package com.fas.services;

import com.fas.models.dtos.requests.CourseRequestDTO;
import com.fas.models.dtos.requests.MajorRequestDTO;
import com.fas.models.dtos.responses.CourseResponseDTO;
import com.fas.models.entities.Course;

import java.util.List;
import java.util.UUID;

public interface CourseService {
    public CourseResponseDTO creatMajor(CourseRequestDTO courseRequest);

    public CourseResponseDTO updateMajor(CourseRequestDTO courseRequest, UUID id);

    public CourseResponseDTO deleteMajor(UUID id);

    public Course getMajorById(UUID id);

    public List<CourseResponseDTO> getAllCourse();

    public Course getCourseByCode(String code);
}
