package com.example.QLNS.service.impl;

import com.example.QLNS.dto.AccountDTO;
import com.example.QLNS.entity.AccountEntity;
import com.example.QLNS.entity.RoleEntity;
import com.example.QLNS.repository.AccountRepository;
import com.example.QLNS.repository.RoleRepository;
import com.example.QLNS.service.IAccountService;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private ModelMapper mapper = new ModelMapper();

    @Override
    public AccountDTO getAccountByID(long id){
        boolean checkEx = accountRepository.existsById(id);
        if(!checkEx){
            return null;
        }
        AccountEntity entity = new AccountEntity();
        entity = accountRepository.getById(id);
        if(entity == null){
            return null;
        }
        AccountDTO result = new AccountDTO();
        result = mapper.map(entity,AccountDTO.class);
        return result;
    }

    @Override
    public List<AccountDTO> getAllAccount() {

        List<AccountEntity> entity = new ArrayList<>();
        List<AccountDTO> result = new ArrayList<>();
        try{
            entity = accountRepository.findAll();
        }catch (Exception e){
            return null;
        }
        for (AccountEntity item : entity) {
            AccountDTO dto = new AccountDTO();
            dto = mapper.map(item, AccountDTO.class);
            result.add(dto);
        }
        return result;
    }

    @Override
    public boolean save(AccountEntity newEntity) {
        AccountEntity oldEntity = new AccountEntity();
        if (newEntity.getId() != null) {
            if(!accountRepository.existsById(newEntity.getId())){
                return false; // id khoong t???n t???i trong database kh??ng th??? c???p nh???t
            }
            oldEntity = accountRepository.getById(newEntity.getId());

            if (!oldEntity.getUserName().equals(newEntity.getUserName())) {
                return false; // kh??ng cho ng?????i d??ng thay ?????i username
            }
        } else {
            oldEntity = accountRepository.findUserByUserName(newEntity.getUserName());
            if (oldEntity != null) {
                return false; // username ???? t???n t???i , kh??ng ???????c ph??p th??m m???i
            }
        }
        newEntity.setPassword(passwordEncoder.encode(newEntity.getPassword()));
        accountRepository.save(newEntity);
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

    @Transactional
    @Override
    public boolean setRole(long idAccount, long idRole){
        Optional<AccountEntity> accountEntity =  accountRepository.findById(idAccount);
        Optional<RoleEntity> roleEntity = roleRepository.findById(idRole);
        if (accountEntity.isEmpty() || roleEntity.isEmpty()) {
            return false;
        }
        List<RoleEntity> roles = new ArrayList<>();
        roles = accountEntity.get().getAccount_Roles();
        for (RoleEntity item : roles){
            if (item.getId() == idRole)
            {
                return  false; // quy???n ???? ???? ???????c g??n cho Account r???i kh??ng g??n th??m n???a
            }
        }
        boolean result = roles.add(roleEntity.get());
        if(result){
            accountEntity.get().setAccount_Roles(roles);
            accountRepository.save(accountEntity.get());
        }
        return true;
    }
    @Transactional
    @Override
    public List<String> getRoleName(long id){
        List<String> result = new ArrayList<>();
        List<RoleEntity> rolesEntities = new ArrayList<>();
        AccountEntity accountEntity = accountRepository.getById(id);
        rolesEntities = accountEntity.getAccount_Roles();
        for (RoleEntity item: rolesEntities)
        {
            result.add(item.getRoleName());
        }
        return result;
    }

    @Transactional
    @Override
    public boolean setListRole(long idAccount, long[] listIDRole){
        Optional<AccountEntity> accountEntity =  accountRepository.findById(idAccount);
        List<RoleEntity> listRole = new ArrayList<>();
        for (int i = 0; i < listIDRole.length; i++){
            if(!roleRepository.existsById(listIDRole[i])){
                return false;// n???u c?? id kh??ng t???n t???i trong role th?? ngay l???p t???c tr??? v??? false
            }
            //n???u id c?? t???n t???i th?? l???y role ???? b??? v??o list
            listRole.add(roleRepository.getById(listIDRole[i]));
        }
        //l???y t???t c???o role c???a account ???? ra
        List<RoleEntity> roles = new ArrayList<>();
        roles = accountEntity.get().getAccount_Roles();
        for (int i = 0; i < listIDRole.length; i++){
            boolean key = false;
            for (RoleEntity item : roles){
                //ki???m tra xem quy???n ???? ???? c?? trong danh s??ch quy???n c???a account ch??a
                if (item.getId() == listIDRole[i]){
                    key = true;
                }
            }
            if(key == false){
                roles.add(listRole.get(i));
            }
        }
        accountEntity.get().setAccount_Roles(roles);
        accountRepository.save(accountEntity.get());
        return true;
    }

    @Transactional
    @Override
    public boolean removeRole(long idAccount, long idRole){
        Optional<AccountEntity> accountEntity =  accountRepository.findById(idAccount);
        Optional<RoleEntity> roleEntity = roleRepository.findById(idRole);
        if (accountEntity.isEmpty() || roleEntity.isEmpty()) {
            return false;
        }
        List<RoleEntity> role = new ArrayList<>();
        role = accountEntity.get().getAccount_Roles();
        for (RoleEntity item : role){
            if (item.getId() == idRole)
            {
                boolean result = role.remove(roleEntity.get());
                if(result){
                    accountEntity.get().setAccount_Roles(role);
                    accountRepository.save(accountEntity.get());
                    return  true;
                }
            }
        }
        return false;
    }

}