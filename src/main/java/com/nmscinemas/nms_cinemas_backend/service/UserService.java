package com.nmscinemas.nms_cinemas_backend.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nmscinemas.nms_cinemas_backend.entity.User;
import com.nmscinemas.nms_cinemas_backend.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> loginUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
}
