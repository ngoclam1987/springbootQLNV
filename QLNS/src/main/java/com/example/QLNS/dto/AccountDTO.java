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

public class AccountDTO extends Auditable<String> {

    private String userName;
    private Integer status;
}
