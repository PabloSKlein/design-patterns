package br.unisinos.edu.dev2.covid.designpatterns.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class PessoaDTO {
    @NotNull
    @ApiModelProperty(example = "00000000000")
    private String cpf;
    @Min(1)
    @NotNull
    @ApiModelProperty(example = "20")
    private int idade;
    @ApiModelProperty(example = "false")
    private Boolean transmissaoLocal;
    @ApiModelProperty(example = "false")
    private Boolean viajouRecentemente;
    @ApiModelProperty(example = "false")
    private Boolean possuiDoencaAgravente;
}
