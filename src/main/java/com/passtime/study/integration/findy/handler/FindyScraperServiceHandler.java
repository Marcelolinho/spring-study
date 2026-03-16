package com.passtime.study.integration.findy.handler;

import com.passtime.study.integration.findy.model.FindyBotEndpoint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.handler.AbstractReplyProducingMessageHandler;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

public class FindyScraperServiceHandler extends AbstractReplyProducingMessageHandler {

    private final String pythonVenv = "classpath:python/env/bin/python";


    @Override
    public Message<FindyBotEndpoint> handleRequestMessage(Message<?> requestMessage) {
        return handle((Message<FindyBotEndpoint>) requestMessage);
    }

    public Message<FindyBotEndpoint> handle(Message<FindyBotEndpoint> requestMessage) {



        return MessageBuilder.withPayload(requestMessage).build().getPayload();
    }
}
