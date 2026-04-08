package com.perfectevent.notification_service.listener;

import com.perfectevent.notification_service.dto.NotificationRequest;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {

    @RabbitListener(queues = "bookingQueue")
    public void receive(NotificationRequest request) {

        System.out.println("MESSAGE FROM QUEUE");
        System.out.println("User ID: " + request.getUserId());
        System.out.println("Event ID: " + request.getEventId());
        System.out.println("Tickets: " + request.getNumberOfTickets());
    }
}