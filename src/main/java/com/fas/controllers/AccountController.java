package com.fas.controllers;

import com.fas.dtos.requests.AccountRequestDto;
import com.fas.dtos.responses.AccountResponseDto;
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
    public AccountResponseDto createAccount(@RequestBody AccountRequestDto accountRequestDto) {
        return accountService.createAccount(accountRequestDto);
    }
}
