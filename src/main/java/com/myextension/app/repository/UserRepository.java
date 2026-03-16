package com.myextension.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myextension.app.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
