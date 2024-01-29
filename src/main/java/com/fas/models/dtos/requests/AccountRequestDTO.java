package com.fas.models.dtos.requests;

import com.fas.models.entities.Account;
import com.fas.models.entities.Instructor;
import com.fas.models.entities.Student;
import com.fas.models.entities.SystemUser;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class AccountRequestDTO {

    private String email;

    private String password;

    private long roleId;

    private long campusId;

    private UUID instructorId;

    private UUID systemUserId;

    private UUID studentId;


    public Account getAccount() {
        return new Account(email, password, roleId, campusId, instructorId, systemUserId, studentId);
    }
}
