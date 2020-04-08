package br.unisinos.edu.dev2.covid.designpatterns.api.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
@Data
public class Infectado {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idInfectado;
    @Column
    @NotNull
    private int idade;
    @Column
    private boolean transmissaoLocal;
    @Column
    private boolean viajouRecentemente;
    @Column
    private boolean possuiDoencaAgravente;
    @OneToOne(mappedBy = "infectado")
    private CasoCovid casoCovid;
}
