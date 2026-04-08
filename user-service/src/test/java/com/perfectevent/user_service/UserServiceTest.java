package com.perfectevent.user_service;

import com.perfectevent.user_service.dto.UserDto;
import com.perfectevent.user_service.entity.User;
import com.perfectevent.user_service.repository.UserRepository;
import com.perfectevent.user_service.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void shouldReturnAllUsers() {
        User user = new User();
        user.setName("Mina");

        when(userRepository.findAll()).thenReturn(List.of(user));

        List<User> users = userService.getAllUsers();

        assertEquals(1, users.size());
    }

    @Test
    void shouldSaveUser() {
        UserDto dto = new UserDto();
        dto.setName("Test");

        User user = new User();
        user.setName("Test");

        when(userRepository.save(any(User.class))).thenReturn(user);

        User saved = userService.createUser(dto);

        assertNotNull(saved);
        assertEquals("Test", saved.getName());
    }
}