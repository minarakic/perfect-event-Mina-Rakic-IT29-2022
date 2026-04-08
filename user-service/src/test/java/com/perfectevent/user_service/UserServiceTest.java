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
import java.util.Optional;

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

    @Test
    void shouldReturnUserById() {

        User user = new User();
        user.setId(1L);
        user.setName("Mina");
        user.setEmail("mina@test.com");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User foundUser = userService.getUserById(1L);

        assertNotNull(foundUser);
        assertEquals("Mina", foundUser.getName());
    }

    @Test
    void shouldThrowExceptionWhenUserNotFound() {

        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            userService.getUserById(1L);
        });

    }

    @Test
    void shouldCreateUserEntityFromDTO() {

        UserDto dto = new UserDto();
        dto.setName("Test");
        dto.setEmail("test@test.com");

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        assertEquals("Test", user.getName());
        assertEquals("test@test.com", user.getEmail());
    }
}