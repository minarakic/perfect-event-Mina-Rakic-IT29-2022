package com.booking_service.service;

import com.booking_service.entity.Booking;
import com.booking_service.repository.BookingRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final RestTemplate restTemplate;

    public BookingService(BookingRepository bookingRepository, RestTemplate restTemplate) {
        this.bookingRepository = bookingRepository;
        this.restTemplate = restTemplate;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking createBooking(Booking booking) {

        String eventUrl = "http://event-service:8081/events/" + booking.getEventId();
        String userUrl = "http://user-service:8080/users/" + booking.getUserId();

        try {
            restTemplate.getForObject(eventUrl, Object.class);
            restTemplate.getForObject(userUrl, Object.class);
        } catch (Exception e) {
            throw new RuntimeException("User or Event does not exist!");
        }

        Booking savedBooking = bookingRepository.save(booking);

        String notificationUrl = "http://notification-service:8083/notifications";

        try {
            restTemplate.postForObject(notificationUrl, savedBooking, Object.class);
        } catch (Exception e) {
            System.out.println("Notification service not available!");
        }

        return savedBooking;
    }
}