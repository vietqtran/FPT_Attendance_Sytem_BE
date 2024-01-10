package com.fas.services;

import com.fas.dtos.requests.AccountRequestDto;
import com.fas.dtos.responses.AccountResponseDto;

public interface AccountService {
    public AccountResponseDto createAccount(AccountRequestDto accountRequestDto);
}
