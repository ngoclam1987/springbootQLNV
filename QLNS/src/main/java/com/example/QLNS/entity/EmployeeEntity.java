package com.example.QLNS.entity;

import com.example.QLNS.models.Auditable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class EmployeeEntity extends Auditable<String> {

    @Column(name = "name")
    private String name;

    @Column(name = "birthDay")
    private Date birthDay;

    @Column(name = "gender")
    private String gender;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "idNumber")
    private String idNumber;

    @Column(name = "dateRange")
    private Date dateRange;

    @Column(name = "placeOfIssue")
    private String placeOfIssue;

    @Column(name = "address")
    private String address;

    @Column(name = "status")
    private Integer status;

    @Column(name = "email")
    private String email;

    @Column(name = "personalEmail")
    private String personalEmail;

    @Column(name = "taxCode")
    private String taxCode;

    @Column(name = "bankAccountNumber")
    private String bankAccountNumber;

    @Column(name = "beneficiaryBank")
    private String beneficiaryBank;

    @Column(name = "maritalStatus")
    private Boolean maritalStatus;

    @Column(name = "positionID")
    private Long positionID;


    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName="id")
    private AccountEntity accountID;

    @Column(name = "departmentID")
    private Long departmentID;

    @Column(name = "managerID")
    private Long managerID;

    @Column(name = "workplaceID")
    private Long workplaceID;

    @Column(name = "note")
    private String note;

    @Column(name = "relativesID")
    private Long relativesID;
}
