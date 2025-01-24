package com.cep.api.model;

import com.cep.api.domain.CepDomain;
import lombok.Builder;

import java.util.Objects;

public class CepResponse extends CepDomain {
    public CepResponse(CepDomain domain) {
        if (Objects.nonNull(domain)){
            cep = domain.getCep();
            bairro = domain.getBairro();
            logradouro = domain.getLogradouro();
            uf = domain.getUf();
            estado = domain.getEstado();
        }

    }
}
