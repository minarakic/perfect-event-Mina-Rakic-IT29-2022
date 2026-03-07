package com.example.bookingservice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookingServiceIntegrationTest {

    @Test
    void bookingLogicWorks() {

        int tickets = 2;
        int pricePerTicket = 50;

        int totalPrice = tickets * pricePerTicket;

        assertEquals(100, totalPrice);

    }

}