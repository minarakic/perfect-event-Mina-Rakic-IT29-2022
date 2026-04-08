package com.perfectevent.event_service.controller;

import com.perfectevent.event_service.entity.Event;
import com.perfectevent.event_service.service.EventService;
import com.perfectevent.event_service.repository.EventRepository;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.perfectevent.event_service.dto.EventDto;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    @PostMapping
    public Event createEvent(@Valid @RequestBody EventDto dto) {

        Event event = new Event();
        event.setName(dto.getName());
        event.setLocation(dto.getLocation());
        event.setDate(dto.getDate());
        event.setCapacity(dto.getCapacity());

        return eventRepository.save(event);
    }
}