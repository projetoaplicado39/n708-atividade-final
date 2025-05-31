package com.edupath.msauth.event.publisher;

import com.edupath.msauth.event.model.UserCreatedEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserEventPublisher {

    private final RabbitTemplate rabbitTemplate;

    @Value("${exchange.name}")
    private String exchange;

    @Value("${routing.key}")
    private String routingKey;

    public UserEventPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishUserCreated(String userId, String username) {
        UserCreatedEvent event = new UserCreatedEvent(userId, username);
        rabbitTemplate.convertAndSend(exchange, routingKey, event);
    }
}
