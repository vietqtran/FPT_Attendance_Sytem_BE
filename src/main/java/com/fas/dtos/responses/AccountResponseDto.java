package com.fas.dtos.responses;

import com.fas.models.entities.Account;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class AccountResponseDto {
    private UUID id;

    private String email;

    private String password;

    private String username;

    private LocalDateTime createAt = LocalDateTime.now();

    private LocalDateTime updateAt = LocalDateTime.now();

    public AccountResponseDto(Account account) {
        this.id = account.getId();
        this.email = account.getEmail();
        this.password = account.getPassword();
        this.username = account.getUsername();
        this.createAt = account.getCreateAt();
        this.updateAt = account.getUpdateAt();
    }
}
