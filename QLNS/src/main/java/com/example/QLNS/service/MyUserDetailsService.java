package com.example.QLNS.service;

import com.example.QLNS.entity.AccountEntity;
import com.example.QLNS.entity.RoleEntity;
import com.example.QLNS.models.MyUserDetails;
import com.example.QLNS.repository.AccountRepository;
import com.example.QLNS.service.impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountEntity accountEntity  = accountRepository.findUserByUserName(username);
        if(accountEntity == null){
           throw new UsernameNotFoundException("không tìm thấy tài khoản này");
        }
        return new MyUserDetails(accountEntity);
    }

}
