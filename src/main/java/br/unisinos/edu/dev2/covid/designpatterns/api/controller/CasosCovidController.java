package br.unisinos.edu.dev2.covid.designpatterns.api.controller;

import br.unisinos.edu.dev2.covid.designpatterns.api.dto.CasoCovidDTO;
import br.unisinos.edu.dev2.covid.designpatterns.api.dto.CasoCovidDetalhadoDTO;
import br.unisinos.edu.dev2.covid.designpatterns.api.service.iface.CasosCovidService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static br.unisinos.edu.dev2.covid.designpatterns.api.util.Constantes.URI_RESPOSTA_CASO_CRIADO;
import static java.lang.String.format;
import static java.net.URI.create;
import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("covid")
@AllArgsConstructor
@Validated
@Api(value = "API manutenir casos de covid no país")
public class CasosCovidController {
    private CasosCovidService casosCovidService;

    @PostMapping("/casos")
    @ApiOperation(value = "Inserir novo caso de covid")
    public ResponseEntity inserirCaso(@RequestBody @Valid CasoCovidDTO casoCovidDTO) {
        var idCasoRegistrado = casosCovidService.registarCaso(casoCovidDTO);
        return created(create(format(URI_RESPOSTA_CASO_CRIADO, idCasoRegistrado))).build();
    }

    @GetMapping("/casos/{numeroRegistro}")
    @ApiOperation(value = "Consulta caso por número de registro")
    public ResponseEntity<CasoCovidDetalhadoDTO> consultarCaso(@ApiParam(required = true) @PathVariable Long numeroRegistro) {
        return ok(casosCovidService.consultarCaso(numeroRegistro));
    }
}
