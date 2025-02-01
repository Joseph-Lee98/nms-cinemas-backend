package com.nmscinemas.nms_cinemas_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nmscinemas.nms_cinemas_backend.dto.UserLoginDTO;
import com.nmscinemas.nms_cinemas_backend.dto.UserRegistrationDTO;
import com.nmscinemas.nms_cinemas_backend.entity.User;
import com.nmscinemas.nms_cinemas_backend.service.UserService;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserRegistrationDTO userDto) {
        User registeredUser = userService.registerUser(userDto);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginDTO userDto) {
        Optional<User> existingUser = userService.loginUser(userDto.getEmail(), userDto.getPassword());
        return ResponseEntity.ok(existingUser.get());
    }
}
