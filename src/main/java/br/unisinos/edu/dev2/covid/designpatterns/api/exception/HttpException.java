package br.unisinos.edu.dev2.covid.designpatterns.api.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class HttpException extends RuntimeException {
    private HttpStatus status;

    public HttpException(String message, HttpStatus status){
        super(message);
        this.status = status;
    }
}
