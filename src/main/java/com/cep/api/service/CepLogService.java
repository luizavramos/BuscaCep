package com.cep.api.service;

import com.cep.api.domain.CepDomain;
import com.cep.api.entity.CepEntity;
import com.cep.api.entity.CepLogEntity;
import com.cep.api.mapper.EntityMapper;
import com.cep.api.repository.CepLogRepository;
import com.cep.api.repository.CepRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CepLogService {
    private final CepLogRepository logRepository;
    private final CepRepository cepRepository;

    public CepLogService(CepLogRepository logRepository, CepRepository cepRepository){
        this.logRepository = logRepository;
        this.cepRepository = cepRepository;
    }

    public void saveLog(CepDomain domain) {
        try {

            logRepository.save(new CepLogEntity(List.of(domain.getCep())));

        } catch (Exception e){
            System.out.println("Error registering get: " + e.getMessage()); // TODO add log
        }
    }
    public void saveFullRegister(CepDomain domain) {
        try {

            this.saveLog(domain);
            if(!cepRepository.existsByCep(domain.getCep()))
                cepRepository.save(EntityMapper.getCepEntity(domain));

        } catch (Exception e){
            System.out.println("Error registering get: " + e.getMessage());
        }
    }

    public void saveFullRegisterGetAll(List<CepDomain> domain) {
        try {
            this.saveLogAll(domain);
        } catch (Exception e){
            System.out.println("Error registering get: " + e.getMessage());
        }
    }

    public void saveLogAll(List<CepDomain> domains) {
        try {

            List<String> ceps = domains.stream()
                    .map(CepDomain::getCep)
                    .collect(Collectors.toList());

            logRepository.save(new CepLogEntity(ceps));

        } catch (Exception e){
            System.out.println("Error registering get: " + e.getMessage()); // TODO add log
        }
    }
    public Optional<CepEntity> findByCep(String cep) {
        return cepRepository.findByCep(cep);
    }
}
