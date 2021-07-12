package com.example.QLNS.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class EmployeeEntity extends BaseEntity<String> {

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
    private Boolean status;

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

    @Column(name = "accountID")
    private Long accountID;

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
