package com.cep.api.client;

import com.cep.api.domain.CepDomain;
import com.cep.api.entity.CepEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "cep", url = "${cep.core.url}")
public interface CepCoreClient {

        @RequestMapping(method = RequestMethod.GET, value = "/{cep}")
        Optional<CepDomain> getCep(@PathVariable("cep") String cep);

        @RequestMapping(method = RequestMethod.GET, value = "")
        List<CepDomain> getAllCep();
}
