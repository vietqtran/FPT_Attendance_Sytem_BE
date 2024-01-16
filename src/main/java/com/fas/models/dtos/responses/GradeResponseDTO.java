package com.fas.models.dtos.responses;


import com.fas.models.entities.Grade;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class GradeResponseDTO {
    private UUID id;

    private String code;

    private boolean status = true;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();

    public GradeResponseDTO (Grade grade) {
        this.id = grade.getId();
        this.code = grade.getCode();
        this.status = grade.isStatus();
        this.createdAt = grade.getCreatedAt();
        this.updatedAt = grade.getUpdatedAt();
    }

}
