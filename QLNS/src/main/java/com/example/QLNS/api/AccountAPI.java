package com.example.QLNS.api;

import com.example.QLNS.dto.AccountDTO;
import com.example.QLNS.entity.AccountEntity;
import com.example.QLNS.service.impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/account")

public class AccountAPI {

    @Autowired
    private AccountService accountService;

    @GetMapping("/getlist")
    public  ResponseEntity<?>  getListAccount() {

        return ResponseEntity.ok(accountService.listAccount());
    }

    @PostMapping("/created")
    public ResponseEntity<?> addAccount(@RequestBody AccountDTO accountDTO) {
        boolean result = accountService.save(accountDTO);
        if (result == true) {
            return ResponseEntity.status(HttpStatus.OK).body("thêm account thành công");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("thêm account thất bại");
    }

    @PutMapping("update/{id}")
    public void updateAccount(@RequestBody AccountDTO dto, @PathVariable("id") Long id) {
        dto.setId(id);
        accountService.save(dto);
    }

    @DeleteMapping("delete")
    public void deleteAccount(@RequestBody long[] ids) {
        accountService.delete(ids);
    }
}
