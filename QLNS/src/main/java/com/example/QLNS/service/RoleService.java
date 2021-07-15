package com.example.QLNS.service;

import com.example.QLNS.entity.RoleEntity;
import com.example.QLNS.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<RoleEntity> getAll() {
        return roleRepository.findAll();
    }

    public boolean save(RoleEntity newEntity) {
        RoleEntity oldEntity = new RoleEntity();
        if (newEntity.getId() != null) {
            if(!roleRepository.existsById(newEntity.getId())){
                return false; // id không tồn tại trong database không thể cập nhật
            }
        }
        roleRepository.save(newEntity);
        return true;
    }

    @Transactional
    public boolean deleteItem(long id) {
        try {
            roleRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
