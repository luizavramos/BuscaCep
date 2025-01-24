package com.cep.api.entity;

import com.cep.api.domain.CepDomain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.coyote.BadRequestException;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Data
@NoArgsConstructor
@Document(collection = "cep")
public class CepEntity {

    public String cep;
    public String logradouro;
    public String bairro;
    public String uf;
    public String estado;

    public CepDomain toDomain() {
        return new CepDomain(this.cep, this.logradouro, this.bairro, this.uf, this.estado);
    }

    public CepEntity(String cep, String logradouro, String bairro, String uf, String estado) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.uf = uf;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "CepEntity{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", bairro='" + bairro + '\'' +
                ", uf='" + uf + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
