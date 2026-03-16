package com.myextension.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myextension.app.entity.Entry;
import com.myextension.app.repository.EntryRepository;

@Service
public class EntryService {
    private final EntryRepository entryRepository;

    public EntryService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public Entry createEntry(Entry entry) {
        return entryRepository.save(entry);
    }

    public Entry updateEntry(Long id, Entry entry) {
        Entry existingEntry = getEntry(id);
        existingEntry.setTitle(entry.getTitle());
        existingEntry.setContent(entry.getContent());
        return entryRepository.save(existingEntry);
    }

    public Entry getEntry(Long id) {
        return entryRepository.findById(id).orElseThrow(() -> new RuntimeException("Entry not found"));
    }

    public List<Entry> listEntry() {
        return entryRepository.findAll();
    }

    public void deleteEntry(Long id) {
        entryRepository.deleteById(id);
    }
}
