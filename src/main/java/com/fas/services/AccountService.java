package com.fas.services;

import com.fas.dtos.requests.AccountRequestDTO;
import com.fas.dtos.responses.AccountResponseDTO;

public interface AccountService {
    public AccountResponseDTO createAccount(AccountRequestDTO accountRequestDto);


}
