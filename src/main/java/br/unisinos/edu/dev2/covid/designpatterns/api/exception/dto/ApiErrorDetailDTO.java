package br.unisinos.edu.dev2.covid.designpatterns.api.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiErrorDetailDTO {
    private String field;
    private String message;
}
