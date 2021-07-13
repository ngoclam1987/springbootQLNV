package com.example.QLNS.service;
import com.example.QLNS.dto.AccountDTO;

import java.util.List;


public interface IAccountService {
    List<AccountDTO> listAccount();
    AccountDTO getAccountByID(long id);
    boolean save(AccountDTO dto);
    boolean  deleteListItem(long[] ids);
    boolean deleteItem(long id);

}
