package com.store.backend.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "IMAGENS")
public class Images {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IMAGENS_ID", nullable = false)
    private Long id;

    @Column(name = "NOME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "PRODUTO_ID")
    private Product product;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_INICIAL")
    private Date initialDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_ATUALIZACAO")
    private Date atualizationDate;
}
