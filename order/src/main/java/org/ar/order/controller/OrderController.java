package org.ar.order.controller;

import org.ar.order.response.OrderResponse;
import org.ar.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// this controller exists purely for debugging!

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/{orderId}")
    public OrderResponse getOrderInfo(@PathVariable Long orderId) {
        return orderService.getOrderInfo(orderId);
    }
}
