package com.passtime.study.integration.greeting.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.Filter;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GreetingFilter {

    @Filter(inputChannel = "inputChannel", outputChannel = "filterChannel", discardChannel = "errorChannel", throwExceptionOnRejection = "A sua mensagem não começa com 'hello'")
    public boolean greetingFilter(Message<String> message) {
      log.info("Filtrando a mensagem aqui!!!!!!!! -> {}", message.getPayload());

      String strOfMessage = message.getPayload().toLowerCase();

      if (!strOfMessage.startsWith("hello")) {
          return false;
      }
      return true;
    }

//    Aqui poderia executar um canExecute por exemplo
}
