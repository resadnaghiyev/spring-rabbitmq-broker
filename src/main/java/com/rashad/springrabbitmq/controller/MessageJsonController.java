package com.rashad.springrabbitmq.controller;

import com.rashad.springrabbitmq.dto.User;
import com.rashad.springrabbitmq.publisher.RabbitMQJsonProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageJsonController {

    private final RabbitMQJsonProducer jsonProducer;

    @PostMapping("/publish")
    public String sendJsonMessage(@RequestBody User user) {
        jsonProducer.sendJsonMessage(user);
        return "Json Message sent to RabbitMQ..";
    }
}
