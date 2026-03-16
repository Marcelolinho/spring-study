package com.passtime.study.integration.etl.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableIntegration
public class ViaCepFlowConfiguration {

    @Bean
    public MessageChannel subscriberChannel() {
        // De acordo com a doc:
        // Esse canal é usado principalmente para alguma NOTIFICAÇÃO
        // Ele não recebe mensagem, apenas envia
        return new PublishSubscribeChannel();
    }

    @Bean
    public MessageChannel inputDirectChannel() {
        /*
            Ele é parecido com o PublishSubscribeChannel porque também é dependente da AbstractSubscribableChannel,
            ou seja, ele é um canal direto, você publica e ele já envia (Publish - Send)

            O mais simples de ser usado quando o canal/aplicação for Single Threaded, isso porque ele é
            um canal que desempenha um papel Single Threaded

            Ele pode receber mensagens mas você não consegue utilizar o método "receive" ou "doReceive"
            porque ele não realiza a implementação do mesmo.
         */
        return new DirectChannel();
    }

    @Bean
    public MessageChannel outputDirectChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel queueChannel() {
         /*
            Funciona de N -> 1, ou seja, muitos podem enviar mensagens mas ele
            ENVIA apenas para 1 consumidor.

            Em seu construtor você consegue delimitar a capacidade de mensagens que ele segura na fila para processamento,
            isso tudo claro controlado pelo framework

            Interessante pra usar com o Kafka por exemplo, onde o canal guarda mensagens
            enquanto o canal consumer ainda não está disponível

            Utiliza FIFO (First In First Out)
         */
        return new QueueChannel(10);
    }
}
