package com.perfectevent.user_service.controller;

import com.perfectevent.user_service.dto.UserDto;
import com.perfectevent.user_service.entity.User;
import com.perfectevent.user_service.service.UserService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@Valid @RequestBody UserDto userDTO) {
        return userService.createUser(userDTO);
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}