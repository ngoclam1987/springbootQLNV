package com.example.QLNS.api;

import com.example.QLNS.dto.AccountDTO;
import com.example.QLNS.models.ServiceResult;
import com.example.QLNS.service.impl.AccountService;
import com.example.QLNS.utils.StatusCodeConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")

public class AccountAPI {

    @Autowired
    private AccountService accountService;

    @GetMapping("/getItem/{id}")
    public ResponseEntity<?> getAccountByID(@PathVariable("id") Long id) {
        AccountDTO result = accountService.getAccountByID(id);
        if (result != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new ServiceResult(StatusCodeConstant.SUCCESS,"Lấy danh sách Account thành công",result));
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ServiceResult(StatusCodeConstant.ERROR_GET_ALL_ACCOUNT,"Lấy danh sách Account Thất bại",null));

    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getListAccount() {
        List<AccountDTO> result = accountService.listAccount();
        if (result != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new ServiceResult(StatusCodeConstant.SUCCESS,"Lấy danh sách Account thành công",result));
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ServiceResult(StatusCodeConstant.ERROR_GET_ALL_ACCOUNT,"Lấy danh sách Account Thất bại",null));

    }

    @PostMapping("/created")
    public ResponseEntity<?> addAccount(@RequestBody AccountDTO accountDTO) {
        boolean result = accountService.save(accountDTO);
        if (result == true) {
            return ResponseEntity.status(HttpStatus.OK).body(new ServiceResult(StatusCodeConstant.SUCCESS,"Thêm mới Account thành công", null));
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ServiceResult(StatusCodeConstant.ERROR_CREATE_ACCOUNT,"Thêm mới account thất bại", null));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateAccount(@RequestBody AccountDTO dto, @PathVariable("id") Long id) {
        dto.setId(id);
        boolean result = accountService.save(dto);
        if (result == true) {
            return ResponseEntity.status(HttpStatus.OK).body(new ServiceResult(StatusCodeConstant.SUCCESS,"Cập nhật Account thành công", null));
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ServiceResult(StatusCodeConstant.ERROR,"Cập nhật account thất bại", null));
    }

    @DeleteMapping("deleteList")
    public ResponseEntity<?> deleteLítAccount(@RequestBody long[] ids) {
        boolean result = accountService.deleteListItem(ids);
        if (result == true) {
            return ResponseEntity.status(HttpStatus.OK).body(new ServiceResult(StatusCodeConstant.SUCCESS,"Xóa danh sách Account thành công", null));
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ServiceResult(StatusCodeConstant.ERROR,"Xóa danh sách Account thất bại", null));
    }

    @DeleteMapping("deleteItem/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable("id") Long id) {
        boolean result = accountService.deleteItem(id);
        if (result == true) {
            return ResponseEntity.status(HttpStatus.OK).body(new ServiceResult(StatusCodeConstant.SUCCESS,"Xóa Account thành công", null));
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ServiceResult(StatusCodeConstant.ERROR,"Xóa Account thất bại", null));
    }
}
