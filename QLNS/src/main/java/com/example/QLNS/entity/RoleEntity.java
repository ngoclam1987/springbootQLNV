package com.example.QLNS.entity;
import com.example.QLNS.models.Auditable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role")

public class RoleEntity extends Auditable<String> {

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "status")
    private  int status;

    @ManyToMany(mappedBy = "Account_Roles")
    List<AccountEntity> accounts = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "roles_groupRole",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "groupRole_id", referencedColumnName = "id"))
    private List<GroupRoleEntity> GroupRole_Role;
}
