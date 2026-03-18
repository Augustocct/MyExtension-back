package com.myextension.app.mapper;

import java.time.LocalDateTime;

import com.myextension.app.dto.request.UserRequestDTO;
import com.myextension.app.dto.response.UserResponseDTO;
import com.myextension.app.entity.User;

public class UserMapper {

    public static User toEntity(UserRequestDTO dto) {
        User user = new User();
        user.setName(dto.name());
        user.setPassword(dto.password());
        user.setCreatedAt(LocalDateTime.now());
        return user;
    }

    public static UserResponseDTO toDTO(User entity) {
        return new UserResponseDTO(
                entity.getId(),
                entity.getName());
    }
}
