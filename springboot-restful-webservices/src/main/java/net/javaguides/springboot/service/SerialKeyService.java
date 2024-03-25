package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.entity.SerialKey;
import net.javaguides.springboot.repository.SerialKeyRepository;

@Service
public class SerialKeyService {

    @Autowired
    private SerialKeyRepository serialKeyRepository;

    // Tüm seri anahtarlarını getir
    public List<SerialKey> getAllSerialKeys() {
        return serialKeyRepository.findAll();
    }

    // Seri anahtar bul
    public SerialKey findBySerialKey(UUID serialKey) {
        return serialKeyRepository.findBySerialKey(serialKey);
    }

    // Yeni seri anahtar kaydet
    public SerialKey saveSerialKey(SerialKey serialKey) {
        return serialKeyRepository.save(serialKey);
    }

    // Seri anahtar güncelle
    public SerialKey updateSerialKey(UUID serialKey, SerialKey newSerialKey) {
        Optional<SerialKey> existingSerialKey = serialKeyRepository.findById(serialKey);
        if (existingSerialKey.isPresent()) {
            SerialKey updatedSerialKey = existingSerialKey.get();
            updatedSerialKey.setRole(newSerialKey.getRole());
            updatedSerialKey.setStatus(newSerialKey.getStatus());
            return serialKeyRepository.save(updatedSerialKey);
        } else {
            return null; // Belirtilen seri anahtar bulunamadı
        }
    }

    // Seri anahtar sil
    public void deleteSerialKey(UUID serialKey) {
        serialKeyRepository.deleteById(serialKey);
    }
}
