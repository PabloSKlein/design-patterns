package br.unisinos.edu.dev2.covid.designpatterns.api.dto;

import br.unisinos.edu.dev2.covid.designpatterns.api.enumeration.UfEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class LocalizacaoDTO {
    @NotNull
    @ApiModelProperty(example = "RS")
    private UfEnum uf;
    @NotBlank
    @ApiModelProperty(example = "Cachoerinha")
    private String cidade;
    @ApiModelProperty(example = "Fatima")
    private String bairro;
}
