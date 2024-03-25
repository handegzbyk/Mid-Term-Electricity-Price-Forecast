package net.javaguides.springboot.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.entity.SerialKey;

@Repository
public interface SerialKeyRepository extends JpaRepository<SerialKey, UUID> {
    SerialKey findBySerialKey(UUID serialKey);
}
