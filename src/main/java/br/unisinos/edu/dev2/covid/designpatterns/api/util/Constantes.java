package br.unisinos.edu.dev2.covid.designpatterns.api.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Constantes {
    public static final String URI_RESPOSTA_CASO_CRIADO = "covid/casos/%s";
    public static final String MSG_REGISTRO_NAO_ENCONTRADO = "Registro não encontrado";
}
