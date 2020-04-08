package br.unisinos.edu.dev2.covid.designpatterns.api.dto;

import br.unisinos.edu.dev2.covid.designpatterns.api.enumeration.UfEnum;
import lombok.Data;

@Data
public class LocalizacaoDTO {
    private UfEnum uf;
    private String cidade;
    private String bairro;
}
