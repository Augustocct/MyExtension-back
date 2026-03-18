package com.myextension.app.mapper;

import com.myextension.app.dto.request.EntryRequestDTO;
import com.myextension.app.dto.response.EntryResponseDTO;
import com.myextension.app.entity.Entry;

public class EntryMapper {
    public static Entry toEntity(EntryRequestDTO dto) {
        Entry entry = new Entry();
        entry.setTitle(dto.title());
        entry.setContent(dto.content());
        return entry;
    }

    public static EntryResponseDTO toDTO(Entry entity) {
        return new EntryResponseDTO(
                entity.getId(),
                entity.getTitle(),
                entity.getContent(),
                PillarMapper.toDTO(entity.getPillar()),
                UserMapper.toDTO(entity.getAuthor()));
    }
}
