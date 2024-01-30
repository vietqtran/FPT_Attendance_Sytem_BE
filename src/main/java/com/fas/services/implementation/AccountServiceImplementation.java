package com.fas.services.implementation;

import com.fas.models.dtos.requests.AccountRequestDTO;
import com.fas.models.dtos.responses.AccountResponseDTO;
import com.fas.models.dtos.responses.StudentResponseDTO;
import com.fas.models.entities.Account;
import com.fas.models.entities.Campus;
import com.fas.models.entities.Role;
import com.fas.models.entities.Student;
import com.fas.models.enums.CampusName;
import com.fas.models.enums.RoleType;
import com.fas.models.exceptions.AccountExceptions;
import com.fas.models.exceptions.StudentExceptions;
import com.fas.repositories.AccountRepository;
import com.fas.services.AccountService;
import com.fas.services.CampusService;
import com.fas.services.RoleSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AccountServiceImplementation implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleSevice roleService;

    @Autowired
    private CampusService campusService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Account findAccountByEmail(String email) {
        return accountRepository.findByEmail(email);
    }



    @Override
    public AccountResponseDTO createAccount(AccountRequestDTO accountRequestDTO) {
        Account account = accountRequestDTO.getAccount();
        Account savedAccount = accountRepository.save(account);
        return new AccountResponseDTO(savedAccount);
    }

    @Override
    public AccountResponseDTO changePassword(String password, UUID id) throws AccountExceptions {
        Account oldAccount = accountRepository.findById(id).get();
        oldAccount.setPassword(passwordEncoder.encode(password));
        Account savedAccount = accountRepository.save(oldAccount);
        AccountResponseDTO accountResponseDTO = new AccountResponseDTO(savedAccount);
        return accountResponseDTO;
    }
}
