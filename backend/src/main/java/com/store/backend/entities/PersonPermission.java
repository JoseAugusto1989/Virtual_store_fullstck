package com.store.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "PERMISSAO_PESSOA")
public class PersonPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_PESSOA")
    @JsonIgnore
    private Person person;

    @ManyToOne
    @JoinColumn(name = "ID_PERMISSAO")
    private Permission permission;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_INICIAL")
    private Date initialDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_ATUALIZAÇÃO")
    private Date atualizationDate;

}
