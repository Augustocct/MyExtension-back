package com.myextension.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myextension.app.entity.Entry;

public interface EntryRepository extends JpaRepository<Entry, Long> {

}
