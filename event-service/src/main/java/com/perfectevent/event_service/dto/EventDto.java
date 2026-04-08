package com.perfectevent.event_service.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

public class EventDto {

    @NotBlank(message = "Event name is required")
    @Size(min = 3, max = 100, message = "Event name must be between 3 and 100 characters")
    private String name;

    @NotBlank(message = "Location is required")
    private String location;

    @Future(message = "Event date must be in the future")
    private LocalDateTime date;

    @Min(value = 1, message = "Capacity must be greater than 0")
    private int capacity;

    // GETTERS & SETTERS
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
}