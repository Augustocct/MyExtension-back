package com.myextension.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myextension.app.dto.request.PillarRequestDTO;
import com.myextension.app.dto.response.PillarResponseDTO;
import com.myextension.app.entity.Pillar;
import com.myextension.app.entity.User;
import com.myextension.app.mapper.PillarMapper;
import com.myextension.app.repository.PillarRepository;
import com.myextension.app.repository.UserRepository;

@Service
public class PillarService {
    private final PillarRepository pillarRepository;

    private final UserRepository userRepository;

    public PillarService(PillarRepository pillarRepository, UserRepository userRepository) {
        this.pillarRepository = pillarRepository;
        this.userRepository = userRepository;
    }

    public PillarResponseDTO createPillar(PillarRequestDTO pillarRequestDTO) {
        User user = userRepository.findById(pillarRequestDTO.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Pillar pillar = PillarMapper.toEntity(pillarRequestDTO);
        pillar.setUser(user);
        Pillar savedPillar = pillarRepository.save(pillar);
        return PillarMapper.toDTO(savedPillar);
    }

    public PillarResponseDTO updatePillar(Long id, PillarRequestDTO pillarRequestDTO) {
        Pillar existingPillar = findPillarById(id);
        existingPillar.setName(pillarRequestDTO.name());
        Pillar updatedPillar = pillarRepository.save(existingPillar);
        return PillarMapper.toDTO(updatedPillar);
    }

    public PillarResponseDTO getPillar(Long id) {
        Pillar pillar = findPillarById(id);
        return PillarMapper.toDTO(pillar);
    }

    public Pillar findPillarById(Long id) {
        return pillarRepository.findById(id).orElseThrow(() -> new RuntimeException("Pillar not found"));
    }

    public List<Pillar> listPillar() {
        return pillarRepository.findAll();
    }

    public void deletePillar(Long id) {
        pillarRepository.deleteById(id);
    }
}
