package com.example.QLNS.models;

import com.example.QLNS.entity.AccountEntity;
import com.example.QLNS.entity.RoleEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetails implements UserDetails {
    private AccountEntity accountEntity;

    public MyUserDetails(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<RoleEntity> roles = accountEntity.getAccount_Roles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (RoleEntity role : roles){
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
         return authorities;
    }

    @Override
    public String getPassword() {
        return accountEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return accountEntity.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
