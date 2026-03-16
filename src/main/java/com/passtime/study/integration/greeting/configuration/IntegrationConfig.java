package com.passtime.study.integration.greeting.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;

@Slf4j
@Configuration
@EnableIntegration
@ComponentScan("com.passtime.study.integration")
public class IntegrationConfig {

    @Bean
    public MessageChannel inputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel outputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel errorChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel filterChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel transformerChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel routerChannel() {
        return new DirectChannel();
    }
}
