package com.example.QLNS.entity;

import com.example.QLNS.models.Auditable;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accountType")

public class AccountTypeEntity extends Auditable<String> {

    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "accountType", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude // Khoonhg sử dụng trong toString()
    private List<AccountEntity> accountEntities;
}
