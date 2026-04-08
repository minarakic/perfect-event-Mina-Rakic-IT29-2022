package com.perfectevent.user_service;

import com.perfectevent.user_service.entity.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void shouldSetAndGetFields() {
        User user = new User();
        user.setName("Mina");

        assertEquals("Mina", user.getName());
    }
    @Test
    void shouldUpdateUserName() {
        User user = new User();
        user.setName("A");

        user.setName("B");

        assertEquals("B", user.getName());
    }
}