package com.example.orders.service;

import com.example.orders.model.Order;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    public void createOrder(Order order){
        kafkaTemplate.send("new_orders",order);
    }
}
