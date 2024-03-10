package com.fas.models.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private boolean status = false;

    @ManyToOne
    private Student student;

    private String content;

    private LocalDateTime createAt = LocalDateTime.now();
    private LocalDateTime updateAt = LocalDateTime.now();

    public Attendance(boolean status, Student student, String content, LocalDateTime createAt, LocalDateTime updateAt) {
        this.status = status;
        this.student = student;
        this.content = content;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}
