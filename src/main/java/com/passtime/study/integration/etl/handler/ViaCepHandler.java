package com.passtime.study.integration.etl.handler;

import com.passtime.study.integration.etl.domain.ViaCepBo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
@Slf4j
public class ViaCepHandler {

    private final RestTemplate restTemplate;

    public ViaCepHandler(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @ServiceActivator(inputChannel = "inputDirectChannel", outputChannel = "outputDirectChannel")
    public ViaCepBo searchCep(String cep) {
        String cepFormatted = cep.replace("-", "");
        if (cepFormatted.length() != 8) {
            log.debug("Não realizando a busca, cep inválido");
            return null;
        }
        log.debug("Buscando pelo CEP {}", cep);

        try {
            URI viaCepUri = new URI(String.format("https://viacep.com.br/ws/%s/json/", cep.replace("-", "")));

            ResponseEntity<ViaCepBo> locationHttpObj = restTemplate.exchange(viaCepUri, HttpMethod.GET, null, ViaCepBo.class);
            ViaCepBo locationBo = locationHttpObj.getBody();

            if (locationHttpObj.getStatusCode().is2xxSuccessful() && locationBo != null) {
                return locationBo;
            }
        } catch (Exception e) {
            log.error("Erro ao buscar o CEP: {}", e.getMessage());
            return null;
        }

        return null;
    }
}
