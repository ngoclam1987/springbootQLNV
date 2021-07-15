package com.example.QLNS.repository;

import com.example.QLNS.entity.GroupRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRoleRepository extends JpaRepository<GroupRoleEntity, Long> {

}
