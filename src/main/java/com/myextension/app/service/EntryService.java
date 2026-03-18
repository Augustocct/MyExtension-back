package com.myextension.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myextension.app.dto.request.EntryRequestDTO;
import com.myextension.app.dto.response.EntryResponseDTO;
import com.myextension.app.entity.Entry;
import com.myextension.app.entity.Pillar;
import com.myextension.app.entity.User;
import com.myextension.app.mapper.EntryMapper;
import com.myextension.app.repository.EntryRepository;
import com.myextension.app.repository.PillarRepository;
import com.myextension.app.repository.UserRepository;

@Service
public class EntryService {
    private final EntryRepository entryRepository;

    private final UserRepository userRepository;

    private final PillarRepository pillarRepository;

    public EntryService(EntryRepository entryRepository, UserRepository userRepository,
            PillarRepository pillarRepository) {
        this.entryRepository = entryRepository;
        this.userRepository = userRepository;
        this.pillarRepository = pillarRepository;
    }

    public EntryResponseDTO createEntry(EntryRequestDTO entryRequestDTO) {
        User author = userRepository.findById(entryRequestDTO.authorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));
        Pillar pillar = pillarRepository.findById(entryRequestDTO.pillarId())
                .orElseThrow(() -> new RuntimeException("Pillar not found"));
        Entry entry = EntryMapper.toEntity(entryRequestDTO);
        entry.setAuthor(author);
        entry.setPillar(pillar);
        Entry savedEntry = entryRepository.save(entry);
        return EntryMapper.toDTO(savedEntry);
    }

    public EntryResponseDTO updateEntry(Long id, EntryRequestDTO entry) {
        Entry existingEntry = findEntryById(id);
        existingEntry.setTitle(entry.title());
        existingEntry.setContent(entry.content());
        Entry updatedEntry = entryRepository.save(existingEntry);
        return EntryMapper.toDTO(updatedEntry);
    }

    public EntryResponseDTO getEntry(Long id) {
        Entry entry = entryRepository.findById(id).orElseThrow(() -> new RuntimeException("Entry not found"));
        return EntryMapper.toDTO(entry);
    }

    public Entry findEntryById(Long id) {
        return entryRepository.findById(id).orElseThrow(() -> new RuntimeException("Entry not found"));
    }

    public List<EntryResponseDTO> listEntry() {
        return entryRepository.findAll().stream().map(EntryMapper::toDTO).collect(java.util.stream.Collectors.toList());
    }

    public void deleteEntry(Long id) {
        entryRepository.deleteById(id);
    }
}
