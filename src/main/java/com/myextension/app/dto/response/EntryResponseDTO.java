package com.myextension.app.dto.response;

public record EntryResponseDTO(
        Long id,
        String title,
        String content,
        PillarResponseDTO pillar,
        UserResponseDTO author) {

}
