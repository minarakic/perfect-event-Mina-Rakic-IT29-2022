package com.perfectevent.booking_service.dto;

public class EventResponse {

    private Long id;
    private String name;
    private String location;
    private String date;
    private int capacity;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}