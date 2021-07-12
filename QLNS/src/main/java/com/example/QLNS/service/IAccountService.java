package com.example.QLNS.service;
import com.example.QLNS.dto.AccountDTO;
import com.example.QLNS.models.JwtRequest;

import java.util.List;


public interface IAccountService {
    List<AccountDTO> listAccount();
    boolean save(AccountDTO dto);
    void  delete(long[] ids);

}
