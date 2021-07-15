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

    @Column(name = "birth_day")
    private Date birthDay;

    @Column(name = "gender")
    private String gender;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "id_number")
    private String idNumber;

    @Column(name = "date_range")
    private Date dateRange;

    @Column(name = "place_of_issue")
    private String placeOfIssue;

    @Column(name = "address")
    private String address;

    @Column(name = "status")
    private Integer status;

    @Column(name = "email")
    private String email;

    @Column(name = "personal_email")
    private String personalEmail;

    @Column(name = "tax_code")
    private String taxCode;

    @Column(name = "bank_account_number")
    private String bankAccountNumber;

    @Column(name = "beneficiary_bank")
    private String beneficiaryBank;

    @Column(name = "marital_status")
    private Boolean maritalStatus;

    @Column(name = "position_id")
    private Long positionID;


    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName="id")
    private AccountEntity accountID;

    @Column(name = "department_id")
    private Long departmentID;

    @Column(name = "manager_id")
    private Long managerID;

    @Column(name = "workplace_id")
    private Long workplaceID;

    @Column(name = "note")
    private String note;

}
