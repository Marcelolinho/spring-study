//package com.passtime.study.integration.findy.controller;
//
//import com.passtime.study.integration.findy.gateway.FindyGateway;
//import com.passtime.study.integration.findy.model.FindyBotEndpoint;
//import org.springframework.messaging.Message;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("api/findy")
//public class FindyBotController {
//
//    private final FindyGateway findyGateway;
//
//    public FindyBotController(FindyGateway findyGateway) {
//        this.findyGateway = findyGateway;
//    }
//
//    @PostMapping("/search")
//    public List<Object> search(FindyBotEndpoint findyBotEndpoint) {
//        Message<FindyBotEndpoint> findyBotEndpointMessage = findyGateway.search(findyBotEndpoint);
//        return findyBotEndpointMessage.getPayload().getResult();
//    }
//}
