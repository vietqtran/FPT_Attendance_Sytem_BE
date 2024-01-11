package com.fas.services.implementation;

import com.fas.models.dtos.requests.AccountRequestDTO;
import com.fas.models.dtos.responses.AccountResponseDTO;
import com.fas.models.entities.Account;
import com.fas.models.exceptions.AccountExceptions;
import com.fas.repositories.AccountRepository;
import com.fas.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountServiceImplementation implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public AccountResponseDTO createAccount(AccountRequestDTO accountRequestDto) throws AccountExceptions {
        Account account = accountRequestDto.getAccount();

        Account existedAccount = accountRepository.findByEmail(account.getEmail());
        if(existedAccount != null) {
            throw new AccountExceptions("Account is existed with email: " + existedAccount.getEmail());
        }

        Account newAccount = new Account();
        newAccount.setEmail(account.getEmail());
        newAccount.setPassword(passwordEncoder.encode(account.getPassword()));
        newAccount.setUsername(account.getUsername());

        Account savedAccount = accountRepository.save(newAccount);

        return new AccountResponseDTO(savedAccount);
    }

    @Override
    public Account findAccountByEmail(String email) {
        return accountRepository.findByEmail(email);
    }
}
