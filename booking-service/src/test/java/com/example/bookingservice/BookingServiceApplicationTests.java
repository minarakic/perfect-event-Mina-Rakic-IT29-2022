package com.example.bookingservice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class BookingServiceApplicationTests {

    @Test
    void simpleBookingCalculationTest() {
        int tickets = 2;
        int result = tickets +1 ;

        assertEquals(3, result);
    }

}
