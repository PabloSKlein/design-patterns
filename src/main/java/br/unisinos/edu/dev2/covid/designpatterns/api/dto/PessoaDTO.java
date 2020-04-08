package br.unisinos.edu.dev2.covid.designpatterns.api.dto;

import lombok.Data;

@Data
public class PessoaDTO {
    private int idade;
    private boolean transmissaoLocal;
    private boolean viajouRecentemente;
    private boolean possuiDoencaAgravente;
}
