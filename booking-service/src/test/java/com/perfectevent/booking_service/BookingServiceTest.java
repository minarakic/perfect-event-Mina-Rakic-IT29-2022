package com.perfectevent.booking_service;

import com.perfectevent.booking_service.dto.BookingDto;
import com.perfectevent.booking_service.dto.EventResponse;
import com.perfectevent.booking_service.entity.Booking;
import com.perfectevent.booking_service.exception.BookingException;
import com.perfectevent.booking_service.repository.BookingRepository;
import com.perfectevent.booking_service.service.BookingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookingServiceTest {

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private RabbitTemplate rabbitTemplate;

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

    @Test
    void shouldCreateBookingSuccessfully() {
        BookingDto dto = new BookingDto();
        dto.setUserId(1L);
        dto.setEventId(1L);
        dto.setNumberOfTickets(2);

        EventResponse event = new EventResponse();
        event.setCapacity(10);

        when(restTemplate.getForObject(contains("users"), eq(Object.class)))
                .thenReturn(new Object());

        when(restTemplate.getForObject(contains("events"), eq(EventResponse.class)))
                .thenReturn(event);

        when(bookingRepository.save(any(Booking.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        Booking result = bookingService.createBooking(dto);

        assertNotNull(result);
        assertEquals(2, result.getNumberOfTickets());
    }

    @Test
    void shouldThrowExceptionWhenCapacityExceeded() {
        BookingDto dto = new BookingDto();
        dto.setUserId(1L);
        dto.setEventId(1L);
        dto.setNumberOfTickets(20);

        EventResponse event = new EventResponse();
        event.setCapacity(5);

        when(restTemplate.getForObject(contains("users"), eq(Object.class)))
                .thenReturn(new Object());

        when(restTemplate.getForObject(contains("events"), eq(EventResponse.class)))
                .thenReturn(event);

        assertThrows(BookingException.class,
                () -> bookingService.createBooking(dto));
    }
}