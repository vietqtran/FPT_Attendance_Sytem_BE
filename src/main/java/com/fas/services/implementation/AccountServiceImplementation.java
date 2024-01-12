package com.fas.services.implementation;

import com.fas.models.dtos.requests.AccountRequestDTO;
import com.fas.models.dtos.responses.AccountResponseDTO;
import com.fas.models.entities.Account;
import com.fas.models.entities.Role;
import com.fas.models.enums.RoleType;
import com.fas.models.exceptions.AccountExceptions;
import com.fas.repositories.AccountRepository;
import com.fas.services.AccountService;
import com.fas.services.RoleSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountServiceImplementation implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleSevice roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public AccountResponseDTO createAccount(AccountRequestDTO accountRequestDto) throws AccountExceptions {
        Account account = accountRequestDto.getAccount();

        System.out.println(account);

        Account existedAccount = accountRepository.findByEmail(account.getEmail());
        if(existedAccount != null) {
            throw new AccountExceptions("Account is existed with email: " + existedAccount.getEmail());
        }

        Account newAccount = new Account();
        newAccount.setEmail(account.getEmail());
        newAccount.setPassword(passwordEncoder.encode(account.getPassword()));
        newAccount.setUsername(account.getUsername());

        switch (account.getRole().getType().name()) {
            case "STUDENT":
                Role role1 = roleService.findRoleByType(RoleType.STUDENT);
                newAccount.setRole(role1);
                break;
            case "INSTRUCTOR":
                Role role2 = roleService.findRoleByType(RoleType.INSTRUCTOR);
                newAccount.setRole(role2);
                break;
            case "ADMIN":
                Role role3 = roleService.findRoleByType(RoleType.ADMIN);
                newAccount.setRole(role3);
                break;
            case "MANAGER":
                Role role4 = roleService.findRoleByType(RoleType.MANAGER);
                newAccount.setRole(role4);
                break;
        }

        Account savedAccount = accountRepository.save(newAccount);

        return new AccountResponseDTO(savedAccount);
    }

    @Override
    public Account findAccountByEmail(String email) {
        return accountRepository.findByEmail(email);
    }
}
