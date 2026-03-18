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

import com.myextension.app.dto.request.EntryRequestDTO;
import com.myextension.app.dto.response.EntryResponseDTO;
import com.myextension.app.service.EntryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/entrys")
public class EntryController {
    private final EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @PostMapping("/create")
    public ResponseEntity<EntryResponseDTO> createEntry(@RequestBody @Valid EntryRequestDTO entryRequestDTO) {
        EntryResponseDTO createdEntry = entryService.createEntry(entryRequestDTO);
        return ResponseEntity.ok(createdEntry);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EntryResponseDTO> updateEntry(@PathVariable Long id,
            @RequestBody @Valid EntryRequestDTO entry) {
        EntryResponseDTO updatedEntry = entryService.updateEntry(id, entry);
        return ResponseEntity.ok(updatedEntry);
    }

    @GetMapping("/list")
    public ResponseEntity<List<EntryResponseDTO>> getEntry() {
        return ResponseEntity.ok(entryService.listEntry());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntryResponseDTO> getEntryById(@PathVariable Long id) {
        EntryResponseDTO entry = entryService.getEntry(id);
        return ResponseEntity.ok(entry);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntryById(@PathVariable Long id) {
        entryService.deleteEntry(id);
        return ResponseEntity.noContent().build();
    }
}