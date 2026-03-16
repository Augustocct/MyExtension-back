package com.myextension.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myextension.app.entity.Pillar;
import com.myextension.app.service.PillarService;

@RestController
@RequestMapping("/pillars")
public class PillarController {

    private final PillarService pillarService;

    public PillarController(PillarService pillarService) {
        this.pillarService = pillarService;
    }

    @PostMapping("/create")
    public Pillar createPillar(@RequestBody Pillar pillar) {
        return pillarService.createPillar(pillar);
    }

    @PutMapping("/{id}")
    public Pillar updatePillar(@PathVariable Long id, @RequestBody Pillar pillar) {
        Pillar existingPillar = pillarService.updatePillar(id, pillar);
        if (existingPillar == null) {
            throw new RuntimeException("Pillar not found");
        }
        return existingPillar;
    }

    @GetMapping("/list")
    public List<Pillar> listPillars() {
        return pillarService.listPillar();
    }

    @GetMapping("/{id}")
    public Pillar getPillarById(@PathVariable Long id) {
        return pillarService.getPillar(id);
    }

    @DeleteMapping("/{id}")
    public void deletePillarById(@PathVariable Long id) {
        pillarService.deletePillar(id);
    }
}
