package com.cep.api.repository;

import com.cep.api.entity.CepLogEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CepLogRepository extends MongoRepository<CepLogEntity,Long> { }
