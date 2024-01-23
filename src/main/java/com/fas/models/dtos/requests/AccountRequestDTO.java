package com.fas.models.dtos.requests;

import com.fas.models.entities.Account;
import com.fas.models.entities.Campus;
import com.fas.models.entities.Role;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class AccountRequestDTO {

    private String email;

    private String password;

    private RoleRequestDTO role;

    private CampusRequestDTO campus;

    public Account getAccount() {
        return new Account(email, password, role.getRole(), campus.getCampus());
    }
}
