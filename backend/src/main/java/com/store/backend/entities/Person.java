package com.store.backend.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "PESSOA")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NOME")
    private String name;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "SENHA")
    private String password;

    @Column(name = "ENDEREÇO")
    private String address;

    @Column(name = "CEP")
    private String cep;

    @ManyToOne
    @JoinColumn(name = "ID_CIDADE")
    private City city;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_INICIAL")
    private Date initialDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_ATUALIZAÇÃO")
    private Date atualizationDate;

}
