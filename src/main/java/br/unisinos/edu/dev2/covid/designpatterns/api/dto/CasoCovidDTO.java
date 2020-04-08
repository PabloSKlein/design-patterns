package br.unisinos.edu.dev2.covid.designpatterns.api.dto;

import lombok.Data;

@Data
public class CasoCovidDTO {
    private LocalizacaoDTO localizacao;
    private PessoaDTO infectado;
}
