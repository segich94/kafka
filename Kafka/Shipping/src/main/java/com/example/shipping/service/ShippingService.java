package com.example.shipping.service;

import com.example.shipping.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;

@Service
@RequiredArgsConstructor
public class ShippingService {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    @KafkaListener(topics = "payed_orders")
    public void listener(Order order){

    }

    private void shipping(Order order){
        System.out.print(order.getId() + " shipping");
        sent(order);
    }

    private void sent(Order order) {
        kafkaTemplate.send("sent_orders", order);
    }

}
