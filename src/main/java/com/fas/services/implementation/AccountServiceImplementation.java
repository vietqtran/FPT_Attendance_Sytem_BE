package com.fas.services.implementation;

import com.fas.dtos.requests.AccountRequestDTO;
import com.fas.dtos.responses.AccountResponseDTO;
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
    public AccountResponseDTO createAccount(AccountRequestDTO accountRequestDto) {
        Account account = accountRequestDto.getAccount();
        System.out.println(account);
        account = accountRepository.save(account);
        AccountResponseDTO accountResponseDto = new AccountResponseDTO(account);
        return accountResponseDto;
    }
}
