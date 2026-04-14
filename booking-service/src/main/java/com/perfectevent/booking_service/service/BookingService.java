package com.perfectevent.booking_service.service;

import com.perfectevent.booking_service.dto.EventResponse;
import com.perfectevent.booking_service.entity.Booking;
import com.perfectevent.booking_service.dto.BookingDto;
import com.perfectevent.booking_service.exception.BookingException;
import com.perfectevent.booking_service.repository.BookingRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final RestTemplate restTemplate;

    private final RabbitTemplate rabbitTemplate;

    public BookingService(BookingRepository bookingRepository,
                          RestTemplate restTemplate,
                          RabbitTemplate rabbitTemplate) {
        this.bookingRepository = bookingRepository;
        this.restTemplate = restTemplate;
        this.rabbitTemplate = rabbitTemplate;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking createBooking(BookingDto dto) {

        Booking booking = new Booking();
        booking.setUserId(dto.getUserId());
        booking.setEventId(dto.getEventId());
        booking.setNumberOfTickets(dto.getNumberOfTickets());

        String eventUrl = "https://event-service-sf8p.onrender.com/events/" + booking.getEventId();
        String userUrl = "https://user-service-eu.onrender.com/users/" + booking.getUserId();

        try {
            restTemplate.getForObject(userUrl, Object.class);
        } catch (Exception e) {
            throw new BookingException("User not found");
        }

        EventResponse event;
        try {
            event = restTemplate.getForObject(eventUrl,
                    EventResponse.class);

        } catch (Exception e) {
            throw new BookingException("Event not found");
        }
        if (dto.getNumberOfTickets() > event.getCapacity()) {
            throw new BookingException("Not enough available seats");
        }

        Booking savedBooking = bookingRepository.save(booking);

        /*String notificationUrl = "http://notification-service:8083/notifications";

        try {
            restTemplate.postForObject(notificationUrl, savedBooking, Object.class);
        } catch (Exception e) {
            System.out.println("Notification service not available!");
        }*/
        rabbitTemplate.convertAndSend("bookingQueue", dto);

        return savedBooking;
    }
}
