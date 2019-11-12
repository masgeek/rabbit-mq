package com.tsobu.broker.service;

import com.tsobu.broker.config.RabbitConfig;
import com.tsobu.broker.entity.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderMessageSender {
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public OrderMessageSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendOrder(Order order) {
        this.rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_ORDERS, order);
    }
}
