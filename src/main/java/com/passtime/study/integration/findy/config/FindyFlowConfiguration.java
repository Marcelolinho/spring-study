package com.passtime.study.integration.findy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableIntegration
public class FindyFlowConfiguration {

    @Bean
    public MessageChannel pythonRequestChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel pythonReplyChannel() {
        return new DirectChannel();
    }
}
