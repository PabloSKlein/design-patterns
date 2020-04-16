package br.unisinos.edu.dev2.covid.designpatterns.api.exception.handler;

import br.unisinos.edu.dev2.covid.designpatterns.api.exception.dto.ApiErrorDTO;
import br.unisinos.edu.dev2.covid.designpatterns.api.exception.dto.ApiErrorDetailDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static java.time.LocalDateTime.now;
import static java.util.stream.Collectors.toList;
import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST;
import static org.springframework.http.ResponseEntity.status;

@ControllerAdvice
public class BeanHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorDTO> handleHttpException(MethodArgumentNotValidException e) {
        var details = e.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> new ApiErrorDetailDTO(fieldError.getField(), fieldError.getDefaultMessage()))
                .collect(toList());

        var apiError = ApiErrorDTO.builder()
                .message("Parametro(s) de entrada obrigatório(s) inválido(s) ou não informado(s).")
                .localDateTime(now())
                .apiErrorDetailList(details)
                .build();

        return status(SC_BAD_REQUEST).body(apiError);
    }
}
