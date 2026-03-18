package com.myextension.app.dto.request;

public record EntryRequestDTO(
        String title,
        String content,
        Long pillarId,
        Long authorId) {

}
