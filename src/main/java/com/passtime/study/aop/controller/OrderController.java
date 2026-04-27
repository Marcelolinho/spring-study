package com.passtime.study.aop.controller;

import com.passtime.study.aop.model.StudyOrder;
import com.passtime.study.aop.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RequestMapping("/api/orders")
@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public StudyOrder sendOrder(StudyOrderRequestDto orderRequest) {
        StudyOrder
        return null;
    }

    public record StudyOrderRequestDto(Integer productId, int quantity, BigDecimal price){};
}
