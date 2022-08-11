package com.pruebadruid.repository;

import com.pruebadruid.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByName(String name);
    boolean existsByName(String name);
}
