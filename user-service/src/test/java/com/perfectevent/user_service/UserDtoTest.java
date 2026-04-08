package com.perfectevent.user_service;

import com.perfectevent.user_service.dto.UserDto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserDtoTest {

    @Test
    void shouldSetAndGetName() {
        UserDto dto = new UserDto();

        dto.setName("Mina");
        assertEquals("Mina", dto.getName());

        dto.setName(null);
        assertNull(dto.getName());
    }
    @Test
    void shouldTestAllGettersAndSetters() {
        UserDto dto = new UserDto();

        dto.setName("Mina");
        dto.setEmail("mina@gmail.com");

        assertEquals("Mina", dto.getName());
        assertEquals("mina@gmail.com", dto.getEmail());

        // edge case
        dto.setName(null);
        assertNull(dto.getName());
    }
}