package com.cep.api.entity;

import com.cep.api.domain.CepDomain;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "cep_log")
public class CepLogEntity {
    public LocalDateTime dateTime;
    public List<String> cep;


    public CepLogEntity(List<String> cep, LocalDateTime dateTime) {
        this.cep = cep;
        this.dateTime = dateTime;
    }
    public CepLogEntity(List<String> cep) {
        this.cep = cep;
        dateTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "CepLogEntity{" +
                "dateTime=" + dateTime +
                ", cep='" + cep + '\'' +
                '}';
    }
}
