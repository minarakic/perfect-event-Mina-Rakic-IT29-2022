package com.perfectevent.user_service;

import com.perfectevent.user_service.exception.GlobalExceptionHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GlobalExceptionHandlerTest {

    @Test
    void shouldHandleException() {
        GlobalExceptionHandler handler = new GlobalExceptionHandler();

        assertThrows(NullPointerException.class, () -> {
            handler.handleValidationExceptions(null);
        });
    }
}