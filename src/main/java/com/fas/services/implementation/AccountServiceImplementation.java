package com.fas.services.implementation;

import com.fas.dtos.requests.AccountRequestDto;
import com.fas.dtos.responses.AccountResponseDto;
import com.fas.models.entities.Account;
import com.fas.repositories.AccountRepository;
import com.fas.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImplementation implements AccountService {
    @Autowired
    private AccountRepository accountRepository;


    @Override
    public AccountResponseDto createAccount(AccountRequestDto accountRequestDto) {
        Account account = accountRequestDto.getAccount();
        account = accountRepository.save(account);

        AccountResponseDto accountResponseDto = new AccountResponseDto(account);

        return accountResponseDto;
    }
}
