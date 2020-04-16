package br.unisinos.edu.dev2.covid.designpatterns.api.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CasoCovidDTO {
    @NotNull
    private LocalizacaoDTO localizacao;
    @NotNull
    private PessoaDTO infectado;
}
