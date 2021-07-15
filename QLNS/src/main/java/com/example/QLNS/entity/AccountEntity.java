package com.example.QLNS.entity;
import com.example.QLNS.models.Auditable;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "account")

public class AccountEntity extends Auditable<String> {

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password" , columnDefinition = "varchar(255) default '123456'")
    private String password;


    @Column(name = "status", columnDefinition = "integer default 1")
    private Integer status;

    @ManyToMany
    @JoinTable(
            name = "account_role",
            joinColumns = {@JoinColumn(name = "account_id", referencedColumnName="id")},
            inverseJoinColumns = {@JoinColumn(name ="role_id",  referencedColumnName="id")}
    )
    private List<RoleEntity> Account_Roles = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "account_groupRole",
            joinColumns = {@JoinColumn(name = "account_id", referencedColumnName="id")},
            inverseJoinColumns = {@JoinColumn(name ="groupRole_id",  referencedColumnName="id")}
    )
    private List<GroupRoleEntity> Account_GroupRoles = new ArrayList<>();
}
