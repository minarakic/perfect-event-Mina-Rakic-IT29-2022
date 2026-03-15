package com.example.bookingservice;

import com.booking_service.entity.Booking;
import com.booking_service.repository.BookingRepository;
import com.booking_service.service.BookingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookingServiceTest {

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingService bookingService;

    @Test
    void shouldReturnAllBookings() {

        Booking booking = new Booking();
        booking.setUserId(1L);
        booking.setEventId(1L);

        when(bookingRepository.findAll()).thenReturn(List.of(booking));

        List<Booking> bookings = bookingService.getAllBookings();

        assertEquals(1, bookings.size());
    }
}