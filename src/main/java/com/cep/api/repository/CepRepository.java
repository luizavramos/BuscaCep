package com.cep.api.repository;

import com.cep.api.entity.CepEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CepRepository extends MongoRepository<CepEntity,String> {
    Optional<CepEntity> findByCep(String cep);

    boolean existsByCep(String cep);
}
