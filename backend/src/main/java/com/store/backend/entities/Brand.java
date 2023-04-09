package com.store.backend.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name= "MARCA")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MARCA_ID", nullable = false)
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
