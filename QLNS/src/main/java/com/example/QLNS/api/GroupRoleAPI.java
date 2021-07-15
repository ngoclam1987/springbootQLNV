package com.example.QLNS.api;

import com.example.QLNS.entity.GroupRoleEntity;
import com.example.QLNS.models.ServiceResult;
import com.example.QLNS.service.GroupRoleService;
import com.example.QLNS.utils.StatusCodeConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/groupRole")
public class GroupRoleAPI {

    @Autowired
    private GroupRoleService groupRoleService;


    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        List<GroupRoleEntity>  entity = new ArrayList<>();
        entity = groupRoleService.getAll();
        if (entity != null){
            return ResponseEntity.status(HttpStatus.OK).body(new ServiceResult(StatusCodeConstant.SUCCESS,"Lấy danh sách Privile thành công",entity));
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ServiceResult(StatusCodeConstant.ERROR_GET_ALL_ACCOUNT,"Lấy danh sách Privile Thất bại",null));
    }

    @PostMapping("/created")
    public ResponseEntity<?> created(@RequestBody GroupRoleEntity entity) {
        boolean result = groupRoleService.save(entity);
        if (result == true) {
            return ResponseEntity.status(HttpStatus.OK).body(new ServiceResult(StatusCodeConstant.SUCCESS,"Thêm mới Privile thành công", null));
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ServiceResult(StatusCodeConstant.ERROR_CREATE_ACCOUNT,"Thêm mới Privile thất bại", null));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@RequestBody GroupRoleEntity entity, @PathVariable("id") Long id) {
        entity.setId(id);
        boolean result = groupRoleService.save(entity);
        if (result == true) {
            return ResponseEntity.status(HttpStatus.OK).body(new ServiceResult(StatusCodeConstant.SUCCESS,"Thêm mới Privile thành công", null));
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ServiceResult(StatusCodeConstant.ERROR,"Cập nhật Privile thất bại", null));
    }

    @DeleteMapping("deleteList")
    public ResponseEntity<?> delete(@RequestBody long[] ids) {

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ServiceResult(StatusCodeConstant.ERROR,"Xóa danh sách Privile thất bại", null));
    }

    @DeleteMapping("deleteItem/{id}")
    public ResponseEntity<?> deleteByID(@PathVariable("id") Long id) {

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ServiceResult(StatusCodeConstant.ERROR,"Xóa Privile thất bại", null));
    }
}
