package com.example.QLNS.api;
import com.example.QLNS.dto.AccountDTO;
import com.example.QLNS.service.impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountAPI {

    @Autowired
    private AccountService accountService;

    @GetMapping("/account")
    public List<AccountDTO> listAccount(){
        return accountService.findAll();
    }
    @PostMapping("/account")
    public void addAccount(@RequestBody AccountDTO accountDTO){
        accountService.save(accountDTO);
    }
    @PutMapping("/account/{id}")
    public  void   updateAccount(@RequestBody AccountDTO dto, @PathVariable("id") Long id){
        dto.setId(id);
        accountService.save(dto);
    }
    @DeleteMapping("/account")
    public  void deleteAccount(@RequestBody long[] ids){
        accountService.delete(ids);
    }
}
