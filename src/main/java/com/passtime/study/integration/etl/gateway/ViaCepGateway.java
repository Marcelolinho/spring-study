package com.passtime.study.integration.etl.gateway;

import com.passtime.study.integration.etl.domain.ViaCepBo;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.stereotype.Component;

@Component
@MessagingGateway
public interface ViaCepGateway {

    @Gateway(requestChannel = "inputDirectChannel", replyChannel = "outputDirectChannel")
    public ViaCepBo locationSearch(String cep);
}
