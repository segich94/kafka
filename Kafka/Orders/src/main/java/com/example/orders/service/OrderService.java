package com.example.orders.service;

import lombok.RequiredArgsConstructor;
import org.example.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    public void createOrder(Order order){
        kafkaTemplate.send("new_orders",order);
    }
}
