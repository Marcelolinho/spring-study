package com.passtime.study.integration.findy.gateway;

import com.passtime.study.integration.findy.model.FindyBotEndpoint;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway(defaultRequestChannel = "pythonRequestChannel")
public interface FindyGateway {

    @Gateway(requestChannel = "pythonRequestChannel", replyChannel = "pythonReplyChannel")
    Message<FindyBotEndpoint> pythonSearch(FindyBotEndpoint findyBotEndpoint);
}
