package com.example.QLNS.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AccountDTO extends  BaseDTO{

    private String userName;
    private String password;
    private Long accountTypeID;
}
