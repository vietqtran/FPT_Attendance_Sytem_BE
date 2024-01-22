package com.fas.models.dtos.responses;

import com.fas.models.entities.Instructor;

import java.time.LocalDateTime;
import java.util.UUID;

public class InstructorResponseDTO {
    private UUID id;

    private String email;

    private boolean status;

    private String username;

    private LocalDateTime createAt = LocalDateTime.now();

    private LocalDateTime updateAt = LocalDateTime.now();

    public InstructorResponseDTO(Instructor instructor) {
        this.id = instructor.getId();
        this.email = instructor.getEmail();
        this.status = instructor.isStatus();
        this.username = instructor.getUsername();
        this.createAt = instructor.getCreateAt();
        this.updateAt = instructor.getUpdateAt();
    }
}
