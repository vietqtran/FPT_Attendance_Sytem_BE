package com.fas.services;

import com.fas.models.dtos.requests.AccountRequestDTO;
import com.fas.models.dtos.responses.AccountResponseDTO;
import com.fas.models.entities.Account;
import com.fas.models.exceptions.AccountExceptions;

public interface AccountService {
    public AccountResponseDTO createAccount(AccountRequestDTO accountRequestDto) throws AccountExceptions;

    public Account findAccountByEmail(String email);
}
