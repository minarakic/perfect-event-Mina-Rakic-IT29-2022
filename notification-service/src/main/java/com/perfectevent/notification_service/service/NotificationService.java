package com.perfectevent.notification_service.service;

import com.perfectevent.notification_service.dto.NotificationRequest;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendNotification(NotificationRequest request) {
        System.out.println("Notification received:");
        System.out.println("User ID: " + request.getUserId());
        System.out.println("Event ID: " + request.getEventId());
        System.out.println("Tickets: " + request.getNumberOfTickets());
    }
}
