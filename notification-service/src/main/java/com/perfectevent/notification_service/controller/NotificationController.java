package com.perfectevent.notification_service.controller;

import org.springframework.web.bind.annotation.*;
import com.perfectevent.notification_service.dto.NotificationRequest;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest request) {

        System.out.println("Notification received:");
        System.out.println("User ID: " + request.getUserId());
        System.out.println("Event ID: " + request.getEventId());
        System.out.println("Tickets: " + request.getNumberOfTickets());

    }
}