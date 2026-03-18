package com.myextension.app.dto.request;

import jakarta.validation.constraints.NotBlank;

public record EntryRequestDTO(
                @NotBlank(message = "Title is required") String title,
                @NotBlank(message = "Content is required") String content,
                Long pillarId,
                Long authorId) {

}
