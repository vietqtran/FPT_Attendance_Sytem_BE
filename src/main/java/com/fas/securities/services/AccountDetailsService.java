package com.fas.securities.services;

import com.fas.models.entities.Account;
import com.fas.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountDetailsService implements UserDetailsService {
    @Autowired
    private AccountService accountService;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountService.findAccountByEmail(email);
        if(account == null) {
            throw new UsernameNotFoundException("Account not found with email: " + email);
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        return new AccountDetails(account.getEmail(), account.getPassword(), authorities);
    }
}
