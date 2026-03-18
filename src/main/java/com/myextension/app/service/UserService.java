package com.myextension.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myextension.app.dto.request.UserRequestDTO;
import com.myextension.app.dto.response.UserResponseDTO;
import com.myextension.app.entity.User;
import com.myextension.app.mapper.UserMapper;
import com.myextension.app.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user = UserMapper.toEntity(userRequestDTO);
        User savedUser = userRepository.save(user);
        return UserMapper.toDTO(savedUser);
    }

    public UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO) {
        User existingUser = findUserEntity(id);
        existingUser.setName(userRequestDTO.name());
        existingUser.setPassword(userRequestDTO.password());
        User updatedUser = userRepository.save(existingUser);
        return UserMapper.toDTO(updatedUser);
    }

    public UserResponseDTO getUser(Long id) {
        User user = findUserEntity(id);
        return UserMapper.toDTO(user);
    }

    public List<UserResponseDTO> listUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper::toDTO)
                .toList();
    }

    public User findUserEntity(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
