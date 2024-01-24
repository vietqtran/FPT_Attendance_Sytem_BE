package com.fas.models.dtos.requests;

import com.fas.models.entities.Account;
import com.fas.models.entities.Campus;
import com.fas.models.entities.Role;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class AccountRequestDTO {

    private String email;

    private String password;

    @NotNull(message = "Role must not be null")
    private RoleRequestDTO role;

    @NotNull(message = "Campus must not be null")
    private CampusRequestDTO campus;

    public Account getAccount() {
        return new Account(email, password, role.getRole(), campus.getCampus());
    }
}
