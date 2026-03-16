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

import com.myextension.app.entity.Entry;
import com.myextension.app.service.EntryService;

@RestController
@RequestMapping("entrys")
public class EntryController {
    private final EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @PostMapping("/create")
    public Entry createEntry(@RequestBody Entry entry) {
        return entryService.createEntry(entry);
    }

    @PutMapping("/update/{id}")
    public Entry updateEntry(@PathVariable Long id, @RequestBody Entry entry) {
        Entry existingEntry = entryService.updateEntry(id, entry);
        if (existingEntry == null) {
            throw new RuntimeException("Entry not found");
        }
        return existingEntry;
    }

    @GetMapping("/list")
    public List<Entry> getEntry() {
        return entryService.listEntry();
    }

    @GetMapping("/{id}")
    public Entry getEntryById(@PathVariable Long id) {
        return entryService.getEntry(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEntryById(@PathVariable Long id) {
        entryService.deleteEntry(id);
    }
}