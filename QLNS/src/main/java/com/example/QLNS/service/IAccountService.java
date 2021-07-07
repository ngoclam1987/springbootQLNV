package com.example.QLNS.service;
import com.example.QLNS.dto.AccountDTO;

import java.util.List;


public interface IAccountService {
    List<AccountDTO> findAll();
    void save(AccountDTO dto);
    void  delete(long[] ids);
}
