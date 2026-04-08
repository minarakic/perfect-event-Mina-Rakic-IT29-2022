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

    @Test
    void shouldMapDtoToUserCorrectly() {

        UserDto dto = new UserDto();
        dto.setName("Mina");

        User user = new User();
        user.setName("Mina");

        when(userRepository.save(any(User.class))).thenReturn(user);

        User saved = userService.createUser(dto);

        assertEquals("Mina", saved.getName());
    }
    @Test
    void shouldReturnEmptyListWhenNoUsers() {

        when(userRepository.findAll()).thenReturn(List.of());

        List<User> users = userService.getAllUsers();

        assertTrue(users.isEmpty());
    }

    @Test
    void shouldCallRepositorySave() {

        UserDto dto = new UserDto();
        dto.setName("Test");

        User user = new User();
        user.setName("Test");

        when(userRepository.save(any(User.class))).thenReturn(user);

        userService.createUser(dto);

        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void shouldHandleNullName() {
        UserDto dto = new UserDto();
        dto.setName(null);

        User user = new User();
        user.setName(null);

        when(userRepository.save(any(User.class))).thenReturn(user);

        User saved = userService.createUser(dto);

        assertNull(saved.getName());
    }

    @Test
    void shouldReturnTrueWhenUsersExist() {
        when(userRepository.findAll()).thenReturn(List.of(new User()));

        boolean result = userService.hasUsers();

        assertTrue(result);
    }

    @Test
    void shouldReturnFalseWhenNoUsers() {
        when(userRepository.findAll()).thenReturn(List.of());

        boolean result = userService.hasUsers();

        assertFalse(result);
    }
    @Test
    void shouldReturnCorrectUserCount() {
        when(userRepository.findAll()).thenReturn(List.of(new User(), new User()));

        int count = userService.countUsers();

        assertEquals(2, count);
    }

    @Test
    void shouldReturnZeroWhenNoUsers() {
        when(userRepository.findAll()).thenReturn(List.of());

        int count = userService.countUsers();

        assertEquals(0, count);
    }
    @Test
    void shouldReturnTrueWhenRepositoryIsEmpty() {
        when(userRepository.findAll()).thenReturn(List.of());

        boolean result = userService.isEmpty();

        assertTrue(result);
    }

    @Test
    void shouldReturnFalseWhenRepositoryIsNotEmpty() {
        when(userRepository.findAll()).thenReturn(List.of(new User()));

        boolean result = userService.isEmpty();

        assertFalse(result);
    }
}