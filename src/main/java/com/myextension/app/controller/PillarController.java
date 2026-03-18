package com.myextension.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myextension.app.dto.request.PillarRequestDTO;
import com.myextension.app.dto.response.PillarResponseDTO;
import com.myextension.app.mapper.PillarMapper;
import com.myextension.app.service.PillarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pillars")
public class PillarController {

    private final PillarService pillarService;

    public PillarController(PillarService pillarService) {
        this.pillarService = pillarService;
    }

    @PostMapping("/create")
    public ResponseEntity<PillarResponseDTO> createPillar(@RequestBody @Valid PillarRequestDTO pillar) {
        PillarResponseDTO createdPillar = pillarService.createPillar(pillar);
        return ResponseEntity.ok(createdPillar);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PillarResponseDTO> updatePillar(@PathVariable Long id,
            @RequestBody @Valid PillarRequestDTO pillarRequestDTO) {
        PillarResponseDTO updatedPillar = pillarService.updatePillar(id, pillarRequestDTO);
        return ResponseEntity.ok(updatedPillar);
    }

    @GetMapping("/list")
    public List<PillarResponseDTO> listPillars() {
        return pillarService.listPillar().stream()
                .map(PillarMapper::toDTO)
                .collect(java.util.stream.Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PillarResponseDTO> getPillarById(@PathVariable Long id) {
        PillarResponseDTO pillar = pillarService.getPillar(id);
        return ResponseEntity.ok(pillar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePillarById(@PathVariable Long id) {
        pillarService.deletePillar(id);
        return ResponseEntity.noContent().build();
    }
}
