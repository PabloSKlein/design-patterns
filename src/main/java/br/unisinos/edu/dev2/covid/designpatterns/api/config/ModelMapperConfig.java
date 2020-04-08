package br.unisinos.edu.dev2.covid.designpatterns.api.config;

import br.unisinos.edu.dev2.covid.designpatterns.api.dto.LocalizacaoDTO;
import br.unisinos.edu.dev2.covid.designpatterns.api.dto.PessoaDTO;
import br.unisinos.edu.dev2.covid.designpatterns.api.entity.Infectado;
import br.unisinos.edu.dev2.covid.designpatterns.api.entity.Localizacao;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);

        modelMapper.createTypeMap(PessoaDTO.class, Infectado.class);
        modelMapper.createTypeMap(LocalizacaoDTO.class, Localizacao.class);

        return modelMapper;
    }
}