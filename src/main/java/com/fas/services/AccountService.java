package com.fas.services;

import com.fas.dtos.requests.AccountRequestDTO;
import com.fas.dtos.responses.AccountResponseDTO;
import com.fas.models.entities.Account;

public interface AccountService {
    public AccountResponseDTO createAccount(AccountRequestDTO accountRequestDto) throws RuntimeException;

    public Account findAccountByEmail(String email);
}
