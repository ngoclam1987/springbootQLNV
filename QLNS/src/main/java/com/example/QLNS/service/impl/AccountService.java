package com.example.QLNS.service.impl;

import com.example.QLNS.dto.AccountDTO;
import com.example.QLNS.entity.AccountEntity;
import com.example.QLNS.models.JwtRequest;
import com.example.QLNS.repository.AccountRepository;
import com.example.QLNS.service.IAccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private ModelMapper mapper = new ModelMapper();

    @Override
    public List<AccountDTO> listAccount() {
        List<AccountEntity> entity = new ArrayList<>();
        List<AccountDTO> result = new ArrayList<>();
        entity = accountRepository.findAll();
        for (AccountEntity item : entity) {
            AccountDTO dto = new AccountDTO();
            dto = mapper.map(item, AccountDTO.class);
            result.add(dto);
        }
        return result;
    }

    @Override
    public boolean save(AccountDTO dto) {

        AccountEntity accountEntity = new AccountEntity();
        List<AccountEntity> listAccountEntity = accountRepository.findAll();

        if (dto.getId() != null) {
            accountEntity = accountRepository.getById(dto.getId());
            String userNameDTO = dto.getUserName();
            String userNameEntity = accountEntity.getUserName();
            if (!userNameDTO.equals(userNameEntity)) {
                return false; // không cho người dùng cập nhật lại username
            }
        } else {
            accountEntity = accountRepository.findUserByUserName(dto.getUserName());
            if (accountEntity != null) {
                return false; // username đã tồn tại , không được phép thêm mới
            }
        }
        accountEntity = mapper.map(dto, AccountEntity.class);
        accountEntity.setPassword(passwordEncoder.encode(dto.getPassword()));
        accountRepository.save(accountEntity);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteListItem(long[] ids) {
        for (long item : ids) {
            try {
                accountRepository.deleteById(item);
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    @Transactional
    @Override
    public boolean deleteItem(long id) {
        try {
            accountRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
