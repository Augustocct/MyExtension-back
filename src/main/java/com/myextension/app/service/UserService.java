package com.myextension.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myextension.app.entity.User;
import com.myextension.app.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        User existingUser = getUser(id);
        existingUser.setName(user.getName());
        existingUser.setPassword(user.getPassword());
        return userRepository.save(existingUser);
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
