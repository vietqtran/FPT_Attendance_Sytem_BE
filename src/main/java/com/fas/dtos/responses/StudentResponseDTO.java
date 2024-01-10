package com.fas.dtos.responses;

import com.fas.models.entities.Account;
import com.fas.models.entities.Student;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class StudentResponseDTO {
    private UUID id;

    private String email;

//  private String password;

    private String username;

    private LocalDateTime createAt = LocalDateTime.now();

    private LocalDateTime updateAt = LocalDateTime.now();

    public StudentResponseDTO(Student student) {
        this.id = student.getId();
        this.email = student.getEmail();
//        this.password = account.getPassword();
        this.username = student.getUsername();
        this.createAt = student.getCreateAt();
        this.updateAt = student.getUpdateAt();
    }
}
