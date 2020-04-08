package br.unisinos.edu.dev2.covid.designpatterns.api.exception.factory;

import br.unisinos.edu.dev2.covid.designpatterns.api.exception.HttpException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static br.unisinos.edu.dev2.covid.designpatterns.api.util.Constantes.MSG_REGISTRO_NAO_ENCONTRADO;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HttpExceptionFactory {
    public static HttpException buildRegistroNaoEncontrado() {
        return new HttpException(MSG_REGISTRO_NAO_ENCONTRADO, NOT_FOUND);
    }
}
