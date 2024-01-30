package com.fas.models.dtos.responses;

import com.fas.models.entities.Account;
import com.fas.models.entities.Instructor;
import com.fas.models.entities.Student;
import com.fas.models.entities.SystemUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponseDTO {
    private UUID id;

    private String email;

    private String accessToken;

    private CampusResponseDTO campus;

    private RoleResponseDTO role;

    private Instructor instructor;

    private SystemUser systemUser;

    private Student student;
    public AccountResponseDTO(Account account) {
        this.id = account.getId();
        this.email = account.getEmail();
        this.campus = new CampusResponseDTO(account.getCampus());
        this.role = new RoleResponseDTO(account.getRole());
        this.accessToken = accessToken;
        this.instructor = account.getInstructor() == null ? null : new Instructor(account.getInstructor().getId());
        this.systemUser = account.getSystemUser() == null ? null : new SystemUser(account.getSystemUser().getId());
        this.student = account.getStudent() == null ? null : new Student(account.getStudent().getId());
    }
}
