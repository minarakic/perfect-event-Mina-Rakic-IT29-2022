package com.perfectevent.user_service.controller;

import com.perfectevent.user_service.entity.User;
import com.perfectevent.user_service.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void shouldReturnAllUsers() throws Exception {

        User user = new User();
        user.setId(1L);
        user.setName("Mina");
        user.setEmail("mina@test.com");

        when(userService.getAllUsers()).thenReturn(List.of(user));

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk());
    }
}