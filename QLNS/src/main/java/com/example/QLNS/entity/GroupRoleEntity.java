package com.example.QLNS.entity;


import com.example.QLNS.models.Auditable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "groupRole")

public class GroupRoleEntity extends Auditable<String> {

    @Column(name = "group_role_name")
    private String groupRoleName;

    @Column(name = "status")
    private  int status;

    @ManyToMany(mappedBy = "GroupRole_Role")
    List<RoleEntity> roleEntities = new ArrayList<>();

    @ManyToMany(mappedBy = "Account_GroupRoles")
    List<AccountEntity> accountEntities = new ArrayList<>();
}
