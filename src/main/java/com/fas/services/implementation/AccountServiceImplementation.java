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

       if(account.getRole() != null) {
           switch (account.getRole().getType().name()) {
               case "ROLE_STUDENT":
                   Role role1 = roleService.findRoleByType(RoleType.ROLE_STUDENT);
                   newAccount.setRole(role1);
                   break;
               case "ROLE_INSTRUCTOR":
                   Role role2 = roleService.findRoleByType(RoleType.ROLE_INSTRUCTOR);
                   newAccount.setRole(role2);
                   break;
               case "ROLE_ADMIN":
                   Role role3 = roleService.findRoleByType(RoleType.ROLE_ADMIN);
                   newAccount.setRole(role3);
                   break;
               case "ROLE_MANAGER":
                   Role role4 = roleService.findRoleByType(RoleType.ROLE_MANAGER);
                   newAccount.setRole(role4);
                   break;
           }
       }

        if(account.getCampus() != null) {
            switch (account.getCampus().getName().name()) {
                case "FU_HL":
                    Campus campus1 = campusService.findByCampusName(CampusName.FU_HL);
                    newAccount.setCampus(campus1);
                    break;
                case "FU_HCM":
                    Campus campus2 = campusService.findByCampusName(CampusName.FU_HCM);
                    newAccount.setCampus(campus2);
                    break;
                case "FU_DN":
                    Campus campus3 = campusService.findByCampusName(CampusName.FU_DN);
                    newAccount.setCampus(campus3);
                    break;
                case "FU_CT":
                    Campus campus4 = campusService.findByCampusName(CampusName.FU_CT);
                    newAccount.setCampus(campus4);
                    break;
                case "FU_QN":
                    Campus campus5 = campusService.findByCampusName(CampusName.FU_QN);
                    newAccount.setCampus(campus5);
                    break;
            }
        }

        Account savedAccount = accountRepository.save(newAccount);

        return new AccountResponseDTO(savedAccount);
    }

    @Override
    public Account findAccountByEmail(String email) {
        return accountRepository.findByEmail(email);
    }
}
