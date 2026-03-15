package com.perfectevent.user_service;

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
        user.setEmail("mina@test.com");

        when(userRepository.findAll()).thenReturn(List.of(user));

        List<User> users = userService.getAllUsers();

        assertEquals(1, users.size());
        assertEquals("Mina", users.get(0).getName());
    }

    @Test
    void shouldSaveUser() {

        User user = new User();
        user.setName("Luka");
        user.setEmail("luka@test.com");

        when(userRepository.save(user)).thenReturn(user);

        User savedUser = userService.saveUser(user);

        assertNotNull(savedUser);
        assertEquals("Luka", savedUser.getName());
    }
}