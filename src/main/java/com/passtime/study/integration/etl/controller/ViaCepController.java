package com.passtime.study.integration.etl.controller;

import com.passtime.study.integration.etl.domain.ViaCepBo;
import com.passtime.study.integration.etl.gateway.ViaCepGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/viacep-integration")
public class ViaCepController {

    private final ViaCepGateway viaCepGateway;

    public ViaCepController(ViaCepGateway viaCepGateway) {
        this.viaCepGateway = viaCepGateway;
    }

    @PostMapping
    public ViaCepBo searchLocation(@RequestBody String cep) {
        return viaCepGateway.locationSearch(cep);
    }
}
