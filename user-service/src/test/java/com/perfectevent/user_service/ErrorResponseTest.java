package com.perfectevent.user_service;

import com.perfectevent.user_service.exception.ErrorResponse;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ErrorResponseTest {

    @Test
    void shouldCreateErrorResponse() {
        ErrorResponse error = new ErrorResponse("Error", List.of("msg1"));

        assertEquals("Error", error.getMessage());
        assertEquals(1, error.getErrors().size());
    }
}