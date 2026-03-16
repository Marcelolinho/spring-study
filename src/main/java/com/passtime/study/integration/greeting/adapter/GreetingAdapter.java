package com.passtime.study.integration.greeting.adapter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Slf4j
public class GreetingAdapter {

    @ServiceActivator(inputChannel = "outputChannel")
    public String handleGreeting(Message<String> message) {
      log.info("Última parada da mensagem!");
      return message.getPayload();
    }

    @ServiceActivator(inputChannel = "errorChannel")
    public String handleError(Message<String> message) {
        log.error("Aqui ele joga o erro do 'throwExceptionOnRejection' da classe de Filter!");
        throw new RuntimeException(message.getPayload());
    }
}
