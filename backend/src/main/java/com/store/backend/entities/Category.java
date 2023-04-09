package com.store.backend.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "CATEGORIA")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CATEGORIA_ID", nullable = false)
    private Long id;

    @Column(name = "NOME")
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_INICIAL")
    private Date initialDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_ATUALIZACAO")
    private Date atualizationDate;
}
