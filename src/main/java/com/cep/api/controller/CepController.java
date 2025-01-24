package com.cep.api.controller;

import com.cep.api.domain.CepDomain;
import com.cep.api.model.CepResponse;
import com.cep.api.service.CepService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cep")
@Tag(name = "CEP", description = "Endpoints para consulta de informações de CEP.")
public class CepController {

    private final CepService service;

    public CepController(CepService service) {
        this.service = service;
    }

    @Operation(
            description = "Consulta de CEP",
            summary = "Busca informações detalhadas de um endereço associado a um CEP específico."
    )
    @GetMapping("/{cep}")
    public ResponseEntity<CepResponse> getCep(@PathVariable("cep") String cep) throws Exception {

        var domain = new CepDomain().returnIfValid(cep);

        return new ResponseEntity<>(new CepResponse(service.getCep(domain)), HttpStatus.OK);
    }

    @Operation(
            summary = "Lista todos os CEPs disponíveis",
            description = "Retorna uma lista com todos os registros de CEP, incluindo logradouro, bairro, estado e UF."
    )
    @GetMapping
    public ResponseEntity<List<CepDomain>> findAll() {
        List<CepDomain> cepList = service.findAll();

        if (cepList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(cepList);
    }


}
