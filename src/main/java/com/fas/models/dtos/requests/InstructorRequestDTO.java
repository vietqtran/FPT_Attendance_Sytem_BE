package com.fas.models.dtos.requests;

import com.fas.models.entities.Instructor;

import java.time.LocalDateTime;
import java.util.UUID;

public class InstructorRequestDTO {
    private UUID id;

    private String email;

    private boolean status;

    private String username;

    private LocalDateTime createAt = LocalDateTime.now();

    private LocalDateTime updateAt = LocalDateTime.now();

    public Instructor getInstructor() {
        return new Instructor(id, email, status, username, createAt, updateAt);
    }
}
