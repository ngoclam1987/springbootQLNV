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
import java.util.Optional;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private AccountRepository accountRepository;

    private  ModelMapper mapper = new ModelMapper();

    @Override
    public List<AccountDTO> findAll(){
        List<AccountEntity> entity = new ArrayList<>();
        List<AccountDTO> result = new ArrayList<>();
        entity = accountRepository.findAll();
        for(AccountEntity item : entity){
            AccountDTO dto = new AccountDTO();
            dto = mapper.map(item, dto.getClass());
            result.add(dto);
        }
        return result;
    }
    @Override
    public void save(AccountDTO dto){
        AccountEntity accountEntity = new AccountEntity();
        accountEntity = mapper.map(dto, accountEntity.getClass());
        accountRepository.save(accountEntity);
    }

    @Override
    public  void  delete(long[] ids){
        for (long item : ids){
            accountRepository.deleteById(item);
        }
    }


}
