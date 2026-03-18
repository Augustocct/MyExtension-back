package com.myextension.app.mapper;

import com.myextension.app.dto.request.PillarRequestDTO;
import com.myextension.app.dto.response.PillarResponseDTO;
import com.myextension.app.entity.Pillar;

public class PillarMapper {
    public static Pillar toEntity(PillarRequestDTO dto) {
        Pillar pillar = new Pillar();
        pillar.setName(dto.name());
        return pillar;
    }

    public static PillarResponseDTO toDTO(Pillar entity) {
        return new PillarResponseDTO(
                entity.getId(),
                entity.getName());
    }
}
