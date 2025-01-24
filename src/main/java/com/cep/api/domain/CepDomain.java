package com.cep.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.coyote.BadRequestException;

import java.util.Objects;
@Getter
@Setter
public class CepDomain {

    @JsonProperty
    public String cep;

    @JsonProperty
    public String logradouro;

    @JsonProperty
    public String bairro;

    @JsonProperty
    public String uf;

    @JsonProperty
    public String estado;

    public CepDomain(){}
    public CepDomain(String cep, String logradouro, String bairro, String uf, String estado) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.uf = uf;
        this.estado = estado;
    }

    public CepDomain returnIfValid(String cep) throws BadRequestException {

        if (setCep(cep))
            return this;

        throw new BadRequestException("Invalid CEP for search. Use only numbers | minimum 8 numbers " + cep);
    }
    public boolean setCep(String cep){

        if (Objects.nonNull(cep)
                && !cep.isBlank()
                // && cep.length() >= 8 TODO ADD validation after change
                && cep.chars().allMatch(value -> Character.isDigit(value))) {
            this.cep = cep;
            return true;
        }

        return false;
    }

    public String getCep(){
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getUf() {
        return uf;
    }

    public String getEstado() {
        return estado;
    }
}
