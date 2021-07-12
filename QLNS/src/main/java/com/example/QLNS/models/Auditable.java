package com.example.QLNS.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)

public abstract class Auditable<U> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "createdTime")
    @CreatedDate
    @Temporal(TIMESTAMP)
    private Date createdTime;

    @Column(name = "createdBy")
    @CreatedBy
    private U createdBy;

    @Column(name = "updatedBy")
    @LastModifiedBy
    private U UpdatedBy;

    @Column(name = "updatedTime")
    @LastModifiedDate
    @Temporal(TIMESTAMP)
    private Date updatedTime;

}
