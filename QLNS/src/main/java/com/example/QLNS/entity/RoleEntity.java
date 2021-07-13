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

    @Column(name = "roleName")
    private String roleName;

    @Column(name = "status")
    private  int status;

    @ManyToMany(mappedBy = "mapRoles")
    List<AccountEntity> accounts = new ArrayList<>();
}
