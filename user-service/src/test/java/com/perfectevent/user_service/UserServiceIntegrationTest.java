package com.perfectevent.user_service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceIntegrationTest {

    @Test
    void emailFormatCheck() {

        String email = "test@example.com";

        assertTrue(email.contains("@"));

    }

}