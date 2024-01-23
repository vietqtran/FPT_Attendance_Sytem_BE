package com.fas.models.dtos.responses;

import com.fas.models.entities.Account;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class AccountResponseDTO {
    private UUID id;

    private String email;

    private String accessToken;

    private CampusResponseDTO campus;

    public AccountResponseDTO(Account account) {
        this.id = account.getId();
        this.email = account.getEmail();
        this.campus = new CampusResponseDTO(account.getCampus());
        this.accessToken = accessToken;
    }
}
