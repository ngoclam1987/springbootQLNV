package com.example.QLNS.service;

import com.example.QLNS.entity.AccountEntity;
import com.example.QLNS.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountEntity entity = new AccountEntity();
        entity = accountRepository.findUserByUserName(username);
        if(entity != null){
            return new User(entity.getUserName(),entity.getPassword(), new ArrayList<>());
        }
        return null;
    }

}
