package com.fas.models.dtos.responses;

import com.fas.models.entities.Account;
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

    public AccountResponseDTO(Account account) {
        this.id = account.getId();
        this.email = account.getEmail();
        this.campus = new CampusResponseDTO(account.getCampus());
        this.accessToken = accessToken;
    }
}
