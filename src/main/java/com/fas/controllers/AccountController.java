package com.fas.controllers;

import com.fas.models.dtos.requests.AccountRequestDTO;
import com.fas.models.dtos.responses.AccountResponseDTO;
import com.fas.models.entities.Account;
import com.fas.models.exceptions.AccountExceptions;
import com.fas.models.exceptions.RoleExceptions;
import com.fas.models.utils.MessageDetails;
import com.fas.securities.jwt.JwtProvider;
import com.fas.securities.services.AccountDetailsService;
import com.fas.services.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AccountDetailsService accountDetailsService;


    @PostMapping("/signup")
    public MessageDetails<AccountResponseDTO> createAccount(@Valid @RequestBody AccountRequestDTO accountRequestDto) throws AccountExceptions, RoleExceptions {
        AccountResponseDTO accountResponseDTO = accountService.createAccount(accountRequestDto);
        return new MessageDetails<>("Account created successfully", accountResponseDTO, "Success");
    }

    @PostMapping("/signin")
    public MessageDetails<AccountResponseDTO> loginUser(@RequestBody @Valid AccountRequestDTO accountRequestDTO) throws AccountExceptions, RoleExceptions {
        Account account = accountRequestDTO.getAccount();
        Authentication authentication = authenticate(account.getEmail(), account.getPassword());

        String token = jwtProvider.generateToken(authentication);

        Account existingAccount = accountService.findAccountByEmail(account.getEmail());
        if(existingAccount != null && account.getCampus() != null && account.getRole() != null) {
            AccountResponseDTO accountResponseDTO = new AccountResponseDTO(existingAccount);
            accountResponseDTO.setAccessToken(token);

            return new MessageDetails<>("Login successfully", accountResponseDTO, "Success");
        }

        return new MessageDetails<>("Login failed", null, "Failure");
    }

    private Authentication authenticate(String email, String password) {
        UserDetails userDetails = accountDetailsService.loadUserByUsername(email);

        if(userDetails == null) {
            throw new BadCredentialsException("Your email, or password is incorrect. Please try again");
        }

        if(!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Your email, or password is incorrect. Please try again");
        }

        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }
}
