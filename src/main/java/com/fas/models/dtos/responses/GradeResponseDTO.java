package com.fas.models.dtos.responses;


import com.fas.models.entities.Campus;
import com.fas.models.entities.Grade;
import com.fas.models.entities.Major;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class GradeResponseDTO {
    private UUID id;

    private String code;

    private boolean status = true;

    public List<StudentResponseDTO> students;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();

    private Major major;

    private Campus campus;

    public GradeResponseDTO (Grade grade) {
        this.id = grade.getId();
        this.code = grade.getCode();
        this.status = grade.isStatus();
        this.students = grade.getStudents().stream().map(StudentResponseDTO::new).toList();
        this.createdAt = grade.getCreatedAt();
        this.updatedAt = grade.getUpdatedAt();
        this.major = grade.getMajor();
        this.campus = grade.getCampus();
    }
}