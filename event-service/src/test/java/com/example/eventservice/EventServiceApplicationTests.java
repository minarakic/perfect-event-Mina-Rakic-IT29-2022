package com.example.eventservice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class EventServiceApplicationTests {

    @Test
    void simpleEventTest() {
        String eventName = "DevOps Conference";
        assertEquals("DevOps Conference", eventName);
    }
    //checking if eventName has an expected value
}
