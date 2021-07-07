package com.example.QLNS.entity;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dateCreated")
    private Date dateCreated;
    @Column(name = "createdBy")
    private Long createdBy;
    @Column(name = "updatedBy")
    private Long UpdatedBy;
    @Column(name = "dateUpdated")
    private Date dateUpdated;

}
