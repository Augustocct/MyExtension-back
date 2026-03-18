package com.myextension.app.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(
        @NotBlank(message = "Name is required") String name,
        @NotBlank(message = "Password is required") String password) {
}
