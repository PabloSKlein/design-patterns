package br.unisinos.edu.dev2.covid.designpatterns.api.service.iface;

import br.unisinos.edu.dev2.covid.designpatterns.api.dto.CasoCovidDTO;
import br.unisinos.edu.dev2.covid.designpatterns.api.dto.CasoCovidDetalhadoDTO;

public interface CasosCovidService {
    Long registarCaso(CasoCovidDTO casoCovidDTO);

    CasoCovidDetalhadoDTO consultarCaso(Long numeroRegistro);
}
