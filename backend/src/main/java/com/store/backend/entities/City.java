package com.store.backend.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "CIDADE")
@Data
@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CIDADE_ID", nullable = false)
    private Long id;

    @Column(name = "NOME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "ESTADO_ID")
    private State state;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_INICIAL")
    private Date initialDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_ATUALIZACAO")
    private Date atualizationDate;
}
