package com.store.backend.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "PRODUTO_STORE")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_PRODUTO")
    private Long id;

    @Column(name = "DESCRIÇÃO_CURTA")
    private String shortDescription;

    @Column(name = "DESCRIÇÃO_DETALHADA")
    private String longDescription;

    @Column(name = "VALOR_COMPRA")
    private Double costValue;

    @Column(name = "VALOR_VENDA")
    private Double saleValue;

    @ManyToOne
    @JoinColumn(name = "ID_MARCA")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIA")
    private Category category;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_INICIAL")
    private Date initialDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_ATUALIZAÇÃO")
    private Date atualizationDate;
}
