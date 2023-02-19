package com.rashad.springrabbitmq.consumer;

import com.rashad.springrabbitmq.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitMQJsonConsumer {

    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void consume(User user) {
        log.info("Received Json message --> {}", user);
    }
}
