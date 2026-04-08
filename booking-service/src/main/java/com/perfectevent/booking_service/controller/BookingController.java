package com.perfectevent.booking_service.controller;

import com.perfectevent.booking_service.entity.Booking;
import com.perfectevent.booking_service.service.BookingService;
import com.perfectevent.booking_service.dto.BookingDto;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;


import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @PostMapping
    public Booking createBooking(@Valid @RequestBody BookingDto dto)
    {
        return bookingService.createBooking(dto);
    }
}