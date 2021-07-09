package com.example.QLNS.service.impl;

import com.example.QLNS.dto.AccountDTO;
import com.example.QLNS.entity.AccountEntity;
import com.example.QLNS.repository.AccountRepository;
import com.example.QLNS.service.IAccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private AccountRepository accountRepository;


    @Override
    public List<AccountDTO> findAll(){
        List<AccountEntity> entity = new ArrayList<>();
        List<AccountDTO> result = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();
        entity = accountRepository.findAll();
        for (AccountEntity item : entity){
            AccountDTO dto = new AccountDTO();
            dto = mapper.map(item, AccountDTO.class);
            dto.setPassword(null);
            result.add(dto);
        }
        return result;
    }
    @Override
    public void save(AccountDTO dto){
        AccountEntity accountEntity = new AccountEntity();
        accountRepository.save(accountEntity);
    }

    @Override
    public  void  delete(long[] ids){
        for (long item : ids){
            accountRepository.deleteById(item);
        }
    }


}
