package com.store.backend.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "IMAGENS")
public class Images {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IMAGENS_ID", nullable = false)
    private Long id;


}
