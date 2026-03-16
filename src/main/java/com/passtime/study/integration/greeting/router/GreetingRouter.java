package com.passtime.study.integration.greeting.router;

import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.Router;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GreetingRouter {

    @Router(inputChannel = "transformerChannel")
    public String routeGreeting(Message<String> message) {
        String strOfMessage = message.getPayload();
        log.info("Router pegou o payload: {}", strOfMessage);

//        Roteando para o outputChannel padrão
        return "outputChannel";
    }
}
