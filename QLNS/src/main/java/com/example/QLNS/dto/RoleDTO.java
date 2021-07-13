package com.example.QLNS.dto;

import com.example.QLNS.models.Auditable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RoleDTO extends Auditable<String> {

    private Integer status;
    private String roleName;
}
