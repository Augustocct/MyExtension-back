package com.myextension.app.dto.request;

import jakarta.validation.constraints.NotBlank;

public record PillarRequestDTO(@NotBlank(message = "Name is required") String name,
                Long userId) {

}