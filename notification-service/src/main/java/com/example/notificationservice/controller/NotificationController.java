package com.example.notificationservice.controller;

import org.springframework.web.bind.annotation.*;
import com.example.notificationservice.dto.NotificationRequest;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @PostMapping
    public String sendNotification(@RequestBody NotificationRequest request) {

        System.out.println("Notification received:");
        System.out.println("User ID: " + request.getUserId());
        System.out.println("Event ID: " + request.getEventId());
        System.out.println("Tickets: " + request.getNumberOfTickets());

        return "Notification sent successfully!";
    }
}