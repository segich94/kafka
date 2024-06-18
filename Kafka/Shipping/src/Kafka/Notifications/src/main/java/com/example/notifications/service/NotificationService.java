package com.example.notifications.service;

import org.example.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @KafkaListener(topics = "sent_orders")
    public void listener(Order order){
        System.out.println("Notification " + order.toString());
    }
}
