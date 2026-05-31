package com.mahendra.trello_clone.service;

import com.mahendra.trello_clone.model.User;
import com.mahendra.trello_clone.repository.UserRepository;
import com.mahendra.trello_clone.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public String registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return "Email already exists!";
        }
        userRepository.save(user);
        return "User registered successfully!";
    }

    public String loginUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return "User not found!";
        }
        if (!user.getPassword().equals(password)) {
            return "Invalid password!";
        }
        return jwtUtil.generateToken(email);
    }
}