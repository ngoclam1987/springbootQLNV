package com.example.QLNS.entity;
import com.example.QLNS.models.Auditable;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")

public class AccountEntity extends Auditable<String> {

    @Column(name = "userName")
    private String userName;

    @Column(name = "password" , columnDefinition = "varchar(255) default '123456'")
    private String password;

    @ManyToOne
    @JoinColumn(name = "account_type", referencedColumnName="id") // thông qua khóa ngoại address_id
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private AccountTypeEntity accountType;

    @Column(name = "status", columnDefinition = "integer default 1")
    private Integer status;

    @ManyToMany
    @JoinTable(
            name = "account_role",
            joinColumns = {@JoinColumn(name = "account_id", referencedColumnName="id")},
            inverseJoinColumns = {@JoinColumn(name ="role_id",  referencedColumnName="id")}
    )
    private List<RoleEntity> mapRoles = new ArrayList<>();
}
