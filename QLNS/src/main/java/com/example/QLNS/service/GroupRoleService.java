package com.example.QLNS.service;

import com.example.QLNS.entity.GroupRoleEntity;
import com.example.QLNS.repository.GroupRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GroupRoleService {
    @Autowired
    private GroupRoleRepository groupRoleRepository;


    public List<GroupRoleEntity> getAll() {
        return groupRoleRepository.findAll();
    }

    public boolean save(GroupRoleEntity newEntity) {
        GroupRoleEntity oldEntity = new GroupRoleEntity();
        if (newEntity.getId() != null) {
            if(!groupRoleRepository.existsById(newEntity.getId())){
                return false; // id không tồn tại trong database không thể cập nhật
            }
        }
        groupRoleRepository.save(newEntity);
        return true;
    }

    @Transactional
    public boolean deleteItem(long id) {
        try {
            groupRoleRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
