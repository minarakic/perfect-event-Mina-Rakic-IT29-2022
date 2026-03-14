package com.perfectevent.user_service.dto;

public class UserDTO {

    private String name;
    private String email;

    public UserDTO() {
        //Required by Jackson for JSON deserialization
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}