package com.perfectevent.user_service;

import com.perfectevent.user_service.controller.UserController;
import com.perfectevent.user_service.entity.User;
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
class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    void shouldReturnAllUsers() {
        User user = new User();
        user.setName("Test");

        when(userService.getAllUsers()).thenReturn(List.of(user));

        List<User> result = userController.getAllUsers();

        assertEquals(1, result.size());
    }
    @Test
    void shouldCallService() {
        when(userService.getAllUsers()).thenReturn(List.of());

        userController.getAllUsers();

        verify(userService, times(1)).getAllUsers();
    }
    @Test
    void shouldReturnEmptyListFromController() {
        when(userService.getAllUsers()).thenReturn(List.of());

        var result = userController.getAllUsers();

        assertTrue(result.isEmpty());
    }
    @Test
    void shouldReturnUsersListNotNull() {
        when(userService.getAllUsers()).thenReturn(List.of(new User()));

        var result = userController.getAllUsers();

        assertNotNull(result);
    }
    @Test
    void shouldReturnListWithMultipleUsers() {
        User u1 = new User();
        u1.setName("A");

        User u2 = new User();
        u2.setName("B");

        when(userService.getAllUsers()).thenReturn(List.of(u1, u2));

        var result = userController.getAllUsers();

        assertEquals(2, result.size());
    }
    @Test
    void shouldNotReturnNull() {
        when(userService.getAllUsers()).thenReturn(List.of());

        var result = userController.getAllUsers();

        assertNotNull(result);
    }
    @Test
    void shouldCallServiceExactlyOnce() {
        when(userService.getAllUsers()).thenReturn(List.of());

        userController.getAllUsers();

        verify(userService, times(1)).getAllUsers();
    }
    @Test
    void shouldReturnDifferentResultsOnMultipleCalls() {
        when(userService.getAllUsers())
                .thenReturn(List.of())
                .thenReturn(List.of(new User()));

        var first = userController.getAllUsers();
        var second = userController.getAllUsers();

        assertEquals(0, first.size());
        assertEquals(1, second.size());
    }
    @Test
    void shouldReturnExactlyWhatServiceReturns() {
        List<User> mockList = List.of(new User(), new User());

        when(userService.getAllUsers()).thenReturn(mockList);

        List<User> result = userController.getAllUsers();

        assertSame(mockList, result);
    }
    @Test
    void shouldHandleMultipleCalls() {
        when(userService.getAllUsers()).thenReturn(List.of(), List.of());

        userController.getAllUsers();
        userController.getAllUsers();

        verify(userService, times(2)).getAllUsers();
    }
}