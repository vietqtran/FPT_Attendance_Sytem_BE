package com.fas.models.dtos.requests;

import com.fas.models.entities.Account;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class AccountRequestDTO {
    private UUID id;

    private String email;

    private String password;

    private String username;

    private LocalDateTime createAt = LocalDateTime.now();

    private LocalDateTime updateAt = LocalDateTime.now();

    public Account getAccount() {
        return new Account(id, email, password, username, createAt, updateAt);
    }
}
