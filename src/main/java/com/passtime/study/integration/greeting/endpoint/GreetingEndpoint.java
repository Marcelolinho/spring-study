package com.passtime.study.integration.greeting.endpoint;

import com.passtime.study.integration.greeting.gateway.MessageGateway;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/greeting")
public class GreetingEndpoint {

    private final MessageGateway messageGateway;

    public GreetingEndpoint(MessageGateway messageGateway) {
        this.messageGateway = messageGateway;
    }

    @PostMapping
    public String normalGreeting(@RequestBody String message) {
        return messageGateway.sendGreeting(message);
    }

    @InitBinder
    public void initiate(WebDataBinder binder) {

    }
}
