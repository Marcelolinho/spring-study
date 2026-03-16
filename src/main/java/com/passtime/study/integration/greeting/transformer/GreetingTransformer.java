package com.passtime.study.integration.greeting.transformer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GreetingTransformer {

    @Transformer(inputChannel = "filterChannel", outputChannel = "transformerChannel")
    public String transformGreeting(Message<String> message) {
        String strOfMessage = message.getPayload();
        strOfMessage = strOfMessage + " From Marcelo!";
        log.info("Mensagem transformada! {}", strOfMessage);
        return strOfMessage;
    }

//    Aqui pode ser um Service abstrato ou algo do tipo
}
