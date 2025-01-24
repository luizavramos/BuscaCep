package com.cep.api.mapper;

import com.cep.api.domain.CepDomain;
import com.cep.api.entity.CepEntity;

import java.util.Objects;

public class EntityMapper {

    public static CepEntity getCepEntity(CepDomain domain) {
        if (Objects.nonNull(domain))
            return new CepEntity(domain.getCep(), domain.getLogradouro(), domain.getBairro(), domain.getUf(), domain.getEstado());

        return null;
    }
}
