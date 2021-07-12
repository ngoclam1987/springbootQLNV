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

    @GetMapping("/getAll")
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
    public ResponseEntity<?> updateAccount(@RequestBody AccountDTO dto, @PathVariable("id") Long id) {
        dto.setId(id);
        boolean result = accountService.save(dto);
        if(result){
            return ResponseEntity.status(HttpStatus.OK).body("cập nhật account thành công");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("cập nhật account thất bại");
    }

    @DeleteMapping("deleteList")
    public ResponseEntity<?> deleteLítAccount(@RequestBody long[] ids) {
       boolean result = accountService.deleteListItem(ids);
        if(result){
            return ResponseEntity.status(HttpStatus.OK).body("xóa danh sách account thành công");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("xóa danh sách account thất bại");
    }

    @DeleteMapping("deleteItem/{id}")
    public ResponseEntity<?> deleteAccount( @PathVariable("id") Long id) {
        boolean result = accountService.deleteItem(id);
        if(result){
            return ResponseEntity.status(HttpStatus.OK).body("xóa account thành công");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("xóa account thất bại");
    }
}
