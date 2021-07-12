package com.example.QLNS.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")

public class Role extends BaseEntity<String>{

    @Column(name = "roleName")
    private String roleName;

    @Column(name = "status")
    private  int status;
}
