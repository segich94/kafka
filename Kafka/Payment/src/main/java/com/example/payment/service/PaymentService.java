package com.example.payment.service;

import com.example.payment.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    @KafkaListener(topics = "new_orders")
    public void listener(Order order) {
        pay(order);
    }

    public void send(Order order){
        kafkaTemplate.send("payed_orders",order);
    }

    private void pay(Order order){
        System.out.println(order.getId() + " pay!");
        send(order);
    }




}
