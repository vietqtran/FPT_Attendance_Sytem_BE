package com.fas.dtos.requests;

import com.fas.models.entities.Student;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class StudentRequestDTO {
    private UUID id;
    private String email;

    private String username;

    private LocalDateTime createAt = LocalDateTime.now();

    private LocalDateTime updateAt = LocalDateTime.now();

    public Student getStudent() {
        return new Student(id, email, username, createAt, updateAt);
    }
}
