package com.perfectevent.notification_service.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE = "bookingQueue";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE);
    }
}