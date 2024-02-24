package com.fas.models.dtos.responses;


import com.fas.models.entities.Major;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class MajorResponseDTO {

    private UUID id;

    private String code;

    private String name;

    private boolean status = true;

    private List<CourseResponseDTO> courses = new ArrayList();

    private LocalDateTime createAt = LocalDateTime.now();

    private LocalDateTime updateAt = LocalDateTime.now();

    public MajorResponseDTO(Major major) {
        this.id = major.getId();
        this.code = major.getCode();
        this.name = major.getName();
        this.status = major.isStatus();
        this.courses = new ArrayList<>(major.getCourses().stream().map(CourseResponseDTO::new).toList());
        this.createAt = major.getCreateAt();
        this.updateAt = major.getUpdateAt();
    }

}
