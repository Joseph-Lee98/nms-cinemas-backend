package com.nmscinemas.nms_cinemas_backend.service;

import com.nmscinemas.nms_cinemas_backend.dto.UserLoginDTO;
import com.nmscinemas.nms_cinemas_backend.dto.UserRegistrationDTO;
import com.nmscinemas.nms_cinemas_backend.entity.User;
import com.nmscinemas.nms_cinemas_backend.exception.InvalidCredentialsException;
import com.nmscinemas.nms_cinemas_backend.exception.UserAlreadyExistsException;
import com.nmscinemas.nms_cinemas_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(UserRegistrationDTO userDto) {
        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("A user with this email already exists.");
        }

        User newUser = new User();
        newUser.setName(userDto.getName());
        newUser.setEmail(userDto.getEmail());
        newUser.setPassword(userDto.getPassword()); 
        return userRepository.save(newUser);
    }

    public Optional<User> loginUser(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isEmpty() || !user.get().getPassword().equals(password)) {
            throw new InvalidCredentialsException("Invalid email or password.");
        }

        return user;
    }
}
