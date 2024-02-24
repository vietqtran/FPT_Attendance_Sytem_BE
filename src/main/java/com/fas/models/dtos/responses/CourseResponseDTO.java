package com.fas.models.dtos.responses;

import com.fas.models.entities.Course;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Data
public class CourseResponseDTO {
    private UUID id;

    private String code;

    private String name;

    private String description;

    private Integer noCredit;

    private List<GradeResponseDTO> grades = new ArrayList();

    private boolean status = true;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();

    public CourseResponseDTO(Course newCourse) {
        this.id = newCourse.getId();
        this.code = newCourse.getCode();
        this.name = newCourse.getName();
        this.description = newCourse.getDescription();
        this.noCredit = newCourse.getNoCredit();
        this.status = newCourse.isStatus();
        this.grades = new ArrayList(newCourse.getGrades().stream().map(GradeResponseDTO::new).toList());
        this.createdAt = newCourse.getCreatedAt();
        this.updatedAt = newCourse.getUpdatedAt();
    }
}

