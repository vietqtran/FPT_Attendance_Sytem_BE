package com.fas.dtos.responses;

import com.fas.models.entities.Account;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class AccountResponseDTO {
    private UUID id;

    private String email;

    private String username;

    private String accessToken;

    private LocalDateTime createAt = LocalDateTime.now();

    private LocalDateTime updateAt = LocalDateTime.now();

    public AccountResponseDTO(Account account) {
        this.id = account.getId();
        this.email = account.getEmail();
        this.username = account.getUsername();
        this.accessToken = accessToken;
        this.createAt = account.getCreateAt();
        this.updateAt = account.getUpdateAt();
    }
}
