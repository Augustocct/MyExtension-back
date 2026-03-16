package com.myextension.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myextension.app.entity.Pillar;
import com.myextension.app.repository.PillarRepository;

@Service
public class PillarService {
    private final PillarRepository pillarRepository;

    public PillarService(PillarRepository pillarRepository) {
        this.pillarRepository = pillarRepository;
    }

    public Pillar createPillar(Pillar pillar) {
        return pillarRepository.save(pillar);
    }

    public Pillar updatePillar(Long id, Pillar pillar) {
        Pillar existingPillar = getPillar(id);
        existingPillar.setName(pillar.getName());
        return pillarRepository.save(existingPillar);
    }

    public Pillar getPillar(Long id) {
        return pillarRepository.findById(id).orElseThrow(() -> new RuntimeException("Pillar not found"));
    }

    public List<Pillar> listPillar() {
        return pillarRepository.findAll();
    }

    public void deletePillar(Long id) {
        pillarRepository.deleteById(id);
    }
}
