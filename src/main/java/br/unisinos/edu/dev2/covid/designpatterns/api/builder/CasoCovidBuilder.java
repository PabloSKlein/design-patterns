package br.unisinos.edu.dev2.covid.designpatterns.api.builder;

import br.unisinos.edu.dev2.covid.designpatterns.api.entity.CasoCovid;
import br.unisinos.edu.dev2.covid.designpatterns.api.entity.Infectado;
import br.unisinos.edu.dev2.covid.designpatterns.api.entity.Localizacao;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class CasoCovidBuilder {
    private CasoCovid casoCovid;

    public static CasoCovidBuilder builder(){
        return new CasoCovidBuilder(new CasoCovid());
    }

    public CasoCovidBuilder dataRegistro(LocalDateTime dataRegristro){
        casoCovid.setDataRegistro(dataRegristro);
        return this;
    }

    public CasoCovidBuilder infectado(Infectado infectado){
        casoCovid.setInfectado(infectado);
        return this;
    }

    public CasoCovidBuilder localizacao(Localizacao localizacao){
        casoCovid.setLocalizacao(localizacao);
        return this;
    }

    public CasoCovid build(){
        return casoCovid;
    }
}
