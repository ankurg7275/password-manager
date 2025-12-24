package com.passwordmanager.service;

import com.passwordmanager.model.PasswordEntry;
import com.passwordmanager.repository.VaultRepository;
import com.passwordmanager.security.*;

import java.time.LocalDate;
import java.util.List;

public class VaultService {

    public void addPassword(String user, String masterPassword, String site, String username,
                            String password, LocalDate expiry) {

        if (!PasswordValidator.isStrong(password)) {
            throw new RuntimeException("Weak password!");
        }

        String encrypted = CryptoEngine.encrypt(password, masterPassword);

        List<PasswordEntry> entries = VaultRepository.load(user);
        entries.add(new PasswordEntry(site, username, encrypted, expiry));
        VaultRepository.save(user, entries);
    }

    public List<PasswordEntry> listPasswords(String user) {
        return VaultRepository.load(user);
    }

    public String decryptPassword(PasswordEntry entry, String masterPassword) {
        return CryptoEngine.decrypt(entry.getEncryptedPassword(), masterPassword);
    }

    public boolean isExpired(PasswordEntry entry) {
        return entry.getExpiry() != null && LocalDate.now().isAfter(entry.getExpiry());
    }

    public void updatePassword(String user, String masterPassword, PasswordEntry entry,
                               String newPassword, LocalDate newExpiry) {

        if (!PasswordValidator.isStrong(newPassword)) {
            throw new RuntimeException("Weak password!");
        }

        entry.setEncryptedPassword(CryptoEngine.encrypt(newPassword, masterPassword));
        entry.setExpiry(newExpiry);

        VaultRepository.save(user, VaultRepository.load(user));
    }
}
