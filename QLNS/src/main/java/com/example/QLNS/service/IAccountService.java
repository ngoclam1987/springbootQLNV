package com.example.QLNS.service;
import com.example.QLNS.dto.AccountDTO;
import com.example.QLNS.entity.AccountEntity;
import com.example.QLNS.entity.RoleEntity;

import java.util.List;


public interface IAccountService {
    List<AccountDTO> getAllAccount();
    AccountDTO getAccountByID(long id);
    boolean save(AccountEntity entity);
    boolean  deleteListItem(long[] ids);
    boolean deleteItem(long id);
    boolean setRole(long idAccount, long idRole);
    boolean setListRole(long idAccount, long[] listIDRole);
    boolean removeRole(long idAccount, long idRole);
    List<String> getRoleName(long id);
}
