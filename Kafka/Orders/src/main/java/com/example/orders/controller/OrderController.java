package com.example.orders.controller;

import com.example.orders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.example.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/newOrder")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @PostMapping
    public void createOrder(@RequestBody Order order){
        orderService.createOrder(order);
    }
}
