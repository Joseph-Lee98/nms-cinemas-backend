package com.nmscinemas.nms_cinemas_backend.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nmscinemas.nms_cinemas_backend.entity.User;
import com.nmscinemas.nms_cinemas_backend.service.UserService;

@CrossOrigin(origins = "*") 
@RestController
@RequestMapping("/users")
public class UserController {
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User registeredUser = userService.registerUser(user);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        Optional<User> existingUser = userService.loginUser(user.getEmail(), user.getPassword());
        
        if (existingUser.isPresent()) {
            return ResponseEntity.ok(existingUser.get()); 
        } else {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }
}
