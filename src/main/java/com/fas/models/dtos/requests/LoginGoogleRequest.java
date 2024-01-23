package com.fas.models.dtos.requests;

import com.fas.models.entities.Account;
import lombok.Data;

@Data
public class LoginGoogleRequest {
    private String email;

    private CampusRequestDTO campus;

    public Account getAccount() {
        return new Account(email, campus.getCampus());
    }
}
