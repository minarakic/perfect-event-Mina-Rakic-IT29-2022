package com.example.notificationservice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NotificationServiceIntegrationTest {

    @Test
    void notificationMessageCreated() {

        String message = "Booking confirmed";

        assertEquals("Booking confirmed", message);

    }

}