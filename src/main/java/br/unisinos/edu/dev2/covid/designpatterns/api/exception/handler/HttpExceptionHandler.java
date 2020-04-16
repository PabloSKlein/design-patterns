package br.unisinos.edu.dev2.covid.designpatterns.api.exception.handler;

import br.unisinos.edu.dev2.covid.designpatterns.api.exception.HttpException;
import br.unisinos.edu.dev2.covid.designpatterns.api.exception.dto.ApiErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static java.time.LocalDateTime.now;
import static org.springframework.http.ResponseEntity.status;

@ControllerAdvice
public class HttpExceptionHandler {

    @ExceptionHandler(HttpException.class)
    public ResponseEntity<ApiErrorDTO> handleHttpException(HttpException e) {
        var apiError = ApiErrorDTO.builder()
                .message(e.getMessage())
                .localDateTime(now())
                .build();

        return status(e.getStatus()).body(apiError);
    }
}
