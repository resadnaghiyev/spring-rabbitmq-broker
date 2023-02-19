package com.rashad.springrabbitmq.publisher;

import com.rashad.springrabbitmq.dto.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RabbitMQJsonProducer {

    @Value("${rabbitmq.exchange.name}")
    public String exchange;

    @Value("${rabbitmq.routing.json.key}")
    public String routingJsonKey;

    private final RabbitTemplate template;

    public void sendJsonMessage(User user) {
        log.info("Message sent --> {}", user);
        template.convertAndSend(exchange, routingJsonKey, user);
    }
}
