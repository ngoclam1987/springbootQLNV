package com.example.QLNS.api;

import com.example.QLNS.dto.AccountDTO;
import com.example.QLNS.entity.AccountEntity;
import com.example.QLNS.models.ServiceResult;
import com.example.QLNS.service.impl.AccountService;
import com.example.QLNS.utils.StatusCodeConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('SELECTED_ACCOUNT')")
    public ResponseEntity<?> getListAccount() {
        List<AccountDTO> result = accountService.getAllAccount();
        if (result != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new ServiceResult(StatusCodeConstant.SUCCESS,"Lấy danh sách Account thành công",result));
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ServiceResult(StatusCodeConstant.ERROR_GET_ALL_ACCOUNT,"Lấy danh sách Account Thất bại",null));

    }

    @PostMapping("/created")
    public ResponseEntity<?> addAccount(@RequestBody AccountEntity entity) {
        boolean result = accountService.save(entity);
        if (result == true) {
            return ResponseEntity.status(HttpStatus.OK).body(new ServiceResult(StatusCodeConstant.SUCCESS,"Thêm mới Account thành công", null));
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ServiceResult(StatusCodeConstant.ERROR_CREATE_ACCOUNT,"Thêm mới account thất bại", null));
    }
    @PostMapping("/setRole")
    public  ResponseEntity<?> setRole(@RequestParam("idAccount") Long id_account  ,@RequestParam("idRole") Long id_role){

        boolean result = accountService.setRole(id_account,id_role);
        if (result == true) {
            return ResponseEntity.status(HttpStatus.OK).body(new ServiceResult(StatusCodeConstant.SUCCESS,"Gán quyền cho Account thành công", null));
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ServiceResult(StatusCodeConstant.ERROR,"Gán quyền cho account thất bại", null));
    }

    @PostMapping("/setListRole")
    public  ResponseEntity<?> setListRole(@RequestParam long[] listIDRole, @RequestParam("id") Long id){

        boolean result = accountService.setListRole(id,listIDRole);
        if (result == true) {
            return ResponseEntity.status(HttpStatus.OK).body(new ServiceResult(StatusCodeConstant.SUCCESS,"Gán quyền cho Account thành công", null));
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ServiceResult(StatusCodeConstant.ERROR,"Gán quyền cho account thất bại", null));
    }

    @PostMapping("/removeRole")
    public  ResponseEntity<?> removeRole(@RequestParam("idAccount") Long id_account  ,@RequestParam("idRole") Long id_role){

        boolean result = accountService.removeRole(id_account,id_role);
        if (result == true) {
            return ResponseEntity.status(HttpStatus.OK).body(new ServiceResult(StatusCodeConstant.SUCCESS,"Xóa quyền cho Account thành công", null));
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ServiceResult(StatusCodeConstant.ERROR,"Xóa quyền cho account thất bại", null));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateAccount(@RequestBody AccountEntity entity, @PathVariable("id") Long id) {
        entity.setId(id);
        boolean result = accountService.save(entity);
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
