package com.example.eventservice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EventServiceIntegrationTest {

    @Test
    void eventCapacityCalculation() {

        int capacity = 100;
        int booked = 30;

        int remaining = capacity - booked;

        assertEquals(70, remaining);

    }

}