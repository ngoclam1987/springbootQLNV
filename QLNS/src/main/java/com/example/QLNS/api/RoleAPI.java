package com.example.QLNS.api;

import com.example.QLNS.entity.RoleEntity;
import com.example.QLNS.models.ServiceResult;
import com.example.QLNS.service.RoleService;
import com.example.QLNS.utils.StatusCodeConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/role")
public class RoleAPI {

    @Autowired
    private RoleService roleService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getList() {
        List<RoleEntity> entity = new ArrayList<>();
        entity = roleService.getAll();
        if (entity != null){
            return ResponseEntity.status(HttpStatus.OK).body(new ServiceResult(StatusCodeConstant.SUCCESS,"Lấy danh sách Role thành công",entity));
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ServiceResult(StatusCodeConstant.ERROR_GET_ALL_ACCOUNT,"Lấy danh sách Role Thất bại",null));
    }

    @PostMapping("/created")
    public ResponseEntity<?> add(@RequestBody RoleEntity entity) {
        boolean result = roleService.save(entity);
        if (result == true) {
            return ResponseEntity.status(HttpStatus.OK).body(new ServiceResult(StatusCodeConstant.SUCCESS,"Thêm mới Role thành công", null));
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ServiceResult(StatusCodeConstant.ERROR_CREATE_ACCOUNT,"Thêm mới Role thất bại", null));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@RequestBody RoleEntity entity, @PathVariable("id") Long id) {
        entity.setId(id);
        boolean result = roleService.save(entity);
        if (result == true) {
            return ResponseEntity.status(HttpStatus.OK).body(new ServiceResult(StatusCodeConstant.SUCCESS,"Thêm mới Role thành công", null));
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ServiceResult(StatusCodeConstant.ERROR,"Cập nhật Role thất bại", null));
    }

    @DeleteMapping("deleteItem/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        boolean result = roleService.deleteItem(id);
        if (result == true) {
            return ResponseEntity.status(HttpStatus.OK).body(new ServiceResult(StatusCodeConstant.SUCCESS,"Thêm mới Role thành công", null));
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ServiceResult(StatusCodeConstant.ERROR,"Xóa Role thất bại", null));
    }

}
