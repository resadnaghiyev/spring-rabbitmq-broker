package com.rashad.springrabbitmq.publisher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RabbitMQProducer {

    @Value("${rabbitmq.exchange.name}")
    public String exchange;

    @Value("${rabbitmq.routing.key}")
    public String routingKey;

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(String message) {
        log.info("Message sent -> {}", message);
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }
}
