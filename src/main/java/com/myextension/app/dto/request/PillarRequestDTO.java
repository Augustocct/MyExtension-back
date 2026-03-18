package com.myextension.app.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PillarRequestDTO(@NotBlank(message = "Name is required") String name,
        @NotNull(message = "User ID is required") @Min(value = 1, message = "User ID must be a positive number") Long userId) {

}