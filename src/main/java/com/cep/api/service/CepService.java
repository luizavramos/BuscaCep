package com.cep.api.service;

import com.cep.api.client.CepCoreClient;
import com.cep.api.domain.CepDomain;
import com.cep.api.entity.CepEntity;
import com.cep.api.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CepService {

    private CepCoreClient client;
    private CepLogService service;

    public CepService (CepCoreClient client, CepLogService service){
        this.client = client;
        this.service = service;
    }
    public CepDomain getCep(CepDomain domain) throws NotFoundException {

        try {

            var databaseCep = service.findByCep(domain.getCep());

            if(databaseCep.isPresent()){
                service.saveLog(domain);
                return databaseCep.get().toDomain();
            }

            var response = client.getCep(domain.getCep()).get();

            service.saveFullRegister(response);

            return response;

        }catch (Exception e){
            System.out.println("Getting record failed for: " + domain.getCep() + " \n with message: " + e.getMessage()); // TODO Change Log
            throw new NotFoundException("Record not found for: " + domain.getCep());
        }

    }

    public List<CepDomain> findAll() {
        var response = client.getAllCep();
        service.saveFullRegisterGetAll(response);

        return response;
        }

}
