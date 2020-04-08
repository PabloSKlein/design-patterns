package br.unisinos.edu.dev2.covid.designpatterns.api.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CasoCovidDetalhadoDTO extends CasoCovidDTO {
    private LocalDateTime dataRegistro;
}
