package com.fas.controllers;

import com.fas.dtos.requests.AccountRequestDTO;
import com.fas.dtos.responses.AccountResponseDTO;
import com.fas.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/account")
    public AccountResponseDTO createAccount(@RequestBody AccountRequestDTO accountRequestDto) {
        return accountService.createAccount(accountRequestDto);
    }


}
