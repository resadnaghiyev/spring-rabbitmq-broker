package com.rashad.springrabbitmq.controller;

import com.rashad.springrabbitmq.publisher.RabbitMQProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final RabbitMQProducer producer;

    @GetMapping("/publish")
    public String sendMessage(@RequestParam String message) {
        producer.sendMessage(message);
        return "Message sent to RabbitMQ..";
    }
}
