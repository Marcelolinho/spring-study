package com.passtime.study.integration.greeting.gateway;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway(defaultRequestChannel = "inputChannel")
public interface MessageGateway {

    @Gateway(requestChannel = "inputChannel", replyChannel = "outputChannel")
    String sendGreeting(String message);
}
