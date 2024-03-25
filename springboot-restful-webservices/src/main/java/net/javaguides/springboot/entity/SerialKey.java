package net.javaguides.springboot.entity;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "serial_key")
public class SerialKey {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "serial_key", columnDefinition = "BINARY(16)")
    private UUID serialKey;

    @Column(name = "role")
    private String Role;

    @Column(name = "status", columnDefinition = "VARCHAR(10) DEFAULT 'inactive'")
    @Pattern(regexp = "^(active|inactive)$")
    private String status;

    public UUID getSerialKey() {
        return serialKey;
    }

    public void setSerialKey(UUID serialKey) {
        this.serialKey = serialKey;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
