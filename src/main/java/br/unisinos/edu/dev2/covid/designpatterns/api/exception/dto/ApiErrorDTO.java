package br.unisinos.edu.dev2.covid.designpatterns.api.exception.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiErrorDTO {
    private String message;
    private LocalDateTime localDateTime;
    private List<ApiErrorDetailDTO> apiErrorDetailList;
}
