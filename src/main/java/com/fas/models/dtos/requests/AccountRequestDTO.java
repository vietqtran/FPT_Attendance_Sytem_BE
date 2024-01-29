package com.fas.models.dtos.requests;

import com.fas.models.entities.Account;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AccountRequestDTO {

    private String email;

    private String password;

    @NotNull(message = "Role must not be null")
    private long roleId;

    @NotNull(message = "Campus must not be null")
    private long campusId;

    public Account getAccount() {
        return new Account(email, password, roleId, campusId);
    }
}
