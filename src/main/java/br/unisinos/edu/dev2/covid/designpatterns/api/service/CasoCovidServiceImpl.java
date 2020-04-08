package br.unisinos.edu.dev2.covid.designpatterns.api.service;

import br.unisinos.edu.dev2.covid.designpatterns.api.builder.CasoCovidBuilder;
import br.unisinos.edu.dev2.covid.designpatterns.api.dto.CasoCovidDTO;
import br.unisinos.edu.dev2.covid.designpatterns.api.dto.CasoCovidDetalhadoDTO;
import br.unisinos.edu.dev2.covid.designpatterns.api.dto.LocalizacaoDTO;
import br.unisinos.edu.dev2.covid.designpatterns.api.dto.PessoaDTO;
import br.unisinos.edu.dev2.covid.designpatterns.api.entity.CasoCovid;
import br.unisinos.edu.dev2.covid.designpatterns.api.entity.Infectado;
import br.unisinos.edu.dev2.covid.designpatterns.api.entity.Localizacao;
import br.unisinos.edu.dev2.covid.designpatterns.api.exception.HttpException;
import br.unisinos.edu.dev2.covid.designpatterns.api.exception.factory.HttpExceptionFactory;
import br.unisinos.edu.dev2.covid.designpatterns.api.repository.CasosCovidRepository;
import br.unisinos.edu.dev2.covid.designpatterns.api.repository.InfectadoRepository;
import br.unisinos.edu.dev2.covid.designpatterns.api.repository.LocalizacaoRepository;
import br.unisinos.edu.dev2.covid.designpatterns.api.service.iface.CasosCovidService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static br.unisinos.edu.dev2.covid.designpatterns.api.exception.factory.HttpExceptionFactory.buildRegistroNaoEncontrado;
import static java.time.LocalDateTime.now;

@Service
@AllArgsConstructor
public class CasoCovidServiceImpl implements CasosCovidService {
    private final CasosCovidRepository casosCovidRepository;
    private final InfectadoRepository infectadoRepository;
    private final LocalizacaoRepository localizacaoRepository;
    private final ModelMapper modelMapper;

    @Override
    public Long registarCaso(CasoCovidDTO casoCovidDTO) {
        var infectado = infectadoRepository.save(modelMapper.map(casoCovidDTO.getInfectado(), Infectado.class));
        var localizacao = localizacaoRepository.save(modelMapper.map(casoCovidDTO.getLocalizacao(), Localizacao.class));
        var casoCovid = CasoCovidBuilder.builder()
                .dataRegistro(now())
                .infectado(infectado)
                .localizacao(localizacao)
                .build();
        return casosCovidRepository.save(casoCovid).getIdCasoCovid();
    }

    @Override
    public CasoCovidDetalhadoDTO consultarCaso(Long numeroRegistro) {
       return casosCovidRepository.findById(numeroRegistro)
               .map(this::mapeiaParaCasoDTO)
                .orElseThrow(HttpExceptionFactory::buildRegistroNaoEncontrado);
    }

    private CasoCovidDetalhadoDTO mapeiaParaCasoDTO(CasoCovid caso) {
        var casoCovidDetalhadoDTO = modelMapper.map(caso, CasoCovidDetalhadoDTO.class);
        casoCovidDetalhadoDTO.setInfectado(modelMapper.map(caso.getInfectado(), PessoaDTO.class));
        casoCovidDetalhadoDTO.setLocalizacao(modelMapper.map(caso.getLocalizacao(), LocalizacaoDTO.class));
        return casoCovidDetalhadoDTO;
    }
}
