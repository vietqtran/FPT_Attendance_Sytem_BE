package com.fas.services.implementation;

import com.fas.models.dtos.requests.AccountRequestDTO;
import com.fas.models.dtos.responses.AccountResponseDTO;
import com.fas.models.entities.Account;
import com.fas.models.entities.Campus;
import com.fas.models.entities.Role;
import com.fas.models.enums.CampusName;
import com.fas.models.enums.RoleType;
import com.fas.models.exceptions.AccountExceptions;
import com.fas.repositories.AccountRepository;
import com.fas.services.AccountService;
import com.fas.services.CampusService;
import com.fas.services.RoleSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

    /**
     * Find an account by email.
     *
     * @param  email  the email of the account to find
     * @return       the account found by the email
     */
    @Override
    public Account findAccountByEmail(String email) {
        return accountRepository.findByEmail(email);
    }
}
