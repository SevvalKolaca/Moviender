package com.moviender.moviender.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.moviender.moviender.user.model.User;

import java.util.UUID;

public interface UserRepository<T> extends JpaRepository<User, UUID> {
    //User findById(UUID id);
    // zaten jpa içerisinde olduğundan tanımlamaya gerek yok

    User findByUsername(String username);
    Boolean existsByUsername(String username);
}
