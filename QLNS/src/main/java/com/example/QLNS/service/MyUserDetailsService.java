package com.example.QLNS.service;

import com.example.QLNS.entity.AccountEntity;
import com.example.QLNS.entity.RoleEntity;
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

    @Autowired
    AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity = accountRepository.findUserByUserName(username);
        if(accountEntity != null){
            List<String> roleName = accountService.getRoleName(accountEntity.getId());
            List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
            if(roleName != null)
            {
                for (String role : roleName){
                    GrantedAuthority authority = new SimpleGrantedAuthority(role);
                    grantList.add(authority);
                }
            }
            return new User(accountEntity.getUserName(),accountEntity.getPassword(), grantList);
        }
        return null;
    }

}
